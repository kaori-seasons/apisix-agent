package cn.windwheel.reload.common;

import cn.windwheel.reload.common.utils.StrUtils;

import java.io.File;

/**
 * @author windwheel
 */
public class AgentConfig {

    private static final String AGENT_HOME_PARAM = "AGENT_HOME";

    public static String getHomeDir() {
        String home = System.getProperty(AGENT_HOME_PARAM);
        if (StrUtils.isBlank(home)) {
            home = System.getenv(AGENT_HOME_PARAM);
        }
        if (StrUtils.isBlank(home)) {
            home = System.getProperty("user.home") + File.separator + ".apisix-plugin-agent";
        }
        return home;
    }

    public static String getAgentJar() {
        return getHomeDir() + File.separator + "apisix-plugin-agent.jar";
    }

    public static String getCoreJarPath() {
        return getHomeDir() + File.separator + "apisix-plugin-core.jar";
    }

    public static File getCoreJarFile() {
        return new File(getCoreJarPath());
    }


}
