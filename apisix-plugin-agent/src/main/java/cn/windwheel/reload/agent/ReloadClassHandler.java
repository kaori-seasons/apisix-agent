package cn.windwheel.reload.agent;

import cn.windwheel.reload.common.AgentConfig;
import cn.windwheel.reload.common.AnsiLog;

import java.io.File;
import java.lang.instrument.Instrumentation;
import java.lang.reflect.Method;
import java.net.URL;

/**
 * @author windwheel
 */
public class ReloadClassHandler implements Handler {

    private static final String HOT_RELOAD_WORKER_CLASS = "cn.windwheel.reload.core.HotReloadWorker";
    private static final String HOT_RELOAD_RELOAD_METHOD = "doReload";

    private static volatile ClassLoader myClassLoader;

    @Override
    public void process(String args, Instrumentation inst) {
        if (args == null) {
            throw new IllegalArgumentException("Agent args is null");
        }
        String[] splits = args.split(",");
        if (splits.length < 2) {
            throw new IllegalArgumentException(args);
        }
        try {
            File coreJarFile = AgentConfig.getCoreJarFile();
            if (myClassLoader == null) {
                myClassLoader = new MyClassloader(
                        new URL[]{coreJarFile.toURI().toURL()});
            }
            AnsiLog.info("agent core urls is {}", coreJarFile.toURI().toURL());
            Class<?> hotReloadWorkerClass = myClassLoader.loadClass(HOT_RELOAD_WORKER_CLASS);
            Method method = hotReloadWorkerClass.getDeclaredMethod(HOT_RELOAD_RELOAD_METHOD, Instrumentation.class, String[].class);
            method.invoke(null, inst, splits);
        } catch (Exception e) {
            AnsiLog.error("Reload failed: {}", e.getMessage());
            AnsiLog.error(e);
        }
    }
}
