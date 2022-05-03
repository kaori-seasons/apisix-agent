package cn.windwheel.reload.watcher;

import lombok.Data;

/**
 * @author windwheel
 */
@Data
public class Config {

    private String pid;
    private String[] watchPaths;

    private static Config INSTANCE;

    public static void init(String pid, String[] watchPaths) {
        INSTANCE = new Config();
        INSTANCE.setPid(pid);
        INSTANCE.setWatchPaths(watchPaths);
    }

    public static Config me() {
        return INSTANCE;
    }

}
