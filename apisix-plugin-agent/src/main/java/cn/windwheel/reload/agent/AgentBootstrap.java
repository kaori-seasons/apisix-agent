package cn.windwheel.reload.agent;

import cn.windwheel.reload.common.AnsiLog;
import cn.windwheel.reload.common.utils.VersionUtils;

import java.lang.instrument.Instrumentation;

/**
 * agent 启动类
 *
 * @author windwheel
 */
public class AgentBootstrap {

    /**
     * 启动时加载
     */
    public static void premain(String args, Instrumentation inst) {
        AnsiLog.info("premain agent: {}", VersionUtils.getLatestVersion());
    }

    /**
     * 运行时加载（attach）
     */
    public static void agentmain(String args, Instrumentation inst) {
        AnsiLog.info("agentmain agent: " + VersionUtils.getLatestVersion());
        Handler handler = new ReloadClassHandler();
        handler.process(args, inst);
    }


}
