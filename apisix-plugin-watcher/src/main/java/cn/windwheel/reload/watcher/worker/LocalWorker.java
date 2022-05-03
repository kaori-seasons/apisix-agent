package cn.windwheel.reload.watcher.worker;

import cn.windwheel.reload.common.AgentConfig;
import cn.windwheel.reload.common.AnsiLog;
import cn.windwheel.reload.common.consts.FileExtension;
import cn.windwheel.reload.common.utils.StrUtils;
import cn.windwheel.reload.watcher.Config;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;
import java.util.Set;

/**
 * @author windwheel
 */
public class LocalWorker implements Worker {

    @Override
    public void doReload(Set<String> files) {
        for (String file : files) {
            reloadClass(fileToClassName(file), file);
        }
    }

    /**
     * 文件路径转类名
     */
    private String fileToClassName(String classFilePath) {
        String[] watchPaths = Config.me().getWatchPaths();
        String path = classFilePath;
        for (String watchPath : watchPaths) {
            if (path.startsWith(watchPath)) {
                path = path.substring(watchPath.length());
                break;
            }
        }
        path = path.replace(FileExtension.CLASS_FILE_EXTENSION, "")
                .replace(FileExtension.JAVA_FILE_EXTENSION, "");

        String className = path.replaceAll("/", ".")
                .replaceAll("\\\\", ".");
        if (className.startsWith(".")) {
            className = className.substring(1);
        }
        if (className.endsWith(".")) {
            className = className.substring(0, className.length() - 1);
        }
        return className;
    }

    private synchronized void reloadClass(String className, String classFilePath) {
        AnsiLog.info("Reload class: {}", className);
        String pid = Config.me().getPid();
        if (StrUtils.isBlank(pid)) {
            return;
        }
        VirtualMachine attach = null;
        try {
            attach = VirtualMachine.attach(pid);
            AnsiLog.debug("Load agent jar: {}", AgentConfig.getAgentJar());
            attach.loadAgent(AgentConfig.getAgentJar(), className + "," + classFilePath);
            AnsiLog.info("Reload class success");
        } catch (Exception e) {
            AnsiLog.error("Reload class error");
            AnsiLog.error(e);
        } finally {
            if (attach != null) {
                try {
                    attach.detach();
                } catch (IOException e) {
                    AnsiLog.error("VirtualMachine detach error", e);
                }
            }
            AnsiLog.info("Reload class finished");
        }
    }


}
