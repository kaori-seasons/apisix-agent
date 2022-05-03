package cn.windwheel.reload.watcher.command;

import cn.windwheel.reload.common.AnsiLog;
import cn.windwheel.reload.watcher.App;

/**
 * 加载变更 Class
 *
 * @author windwheel
 */
public class ReloadCmd implements Cmd {

    @Override
    public String[] key() {
        return new String[]{"r"};
    }

    @Override
    public String help() {
        return "重新加载变更的 Class";
    }

    @Override
    public void handle() {
        AnsiLog.info("do reload class");
        App.me().reload();
    }

}
