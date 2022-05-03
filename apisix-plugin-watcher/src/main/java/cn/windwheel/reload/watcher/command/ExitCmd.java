package cn.windwheel.reload.watcher.command;

import cn.windwheel.reload.common.AnsiLog;
import cn.windwheel.reload.watcher.App;

/**
 * 退出程序
 *
 * @author windwheel
 */
public class ExitCmd implements Cmd {

    @Override
    public String[] key() {
        return new String[]{"exit"};
    }

    @Override
    public String help() {
        return "退出进程";
    }

    @Override
    public void handle() {
        AnsiLog.info("stop apisix-plugin-watcher-boot");
        App.me().stop();
    }

}
