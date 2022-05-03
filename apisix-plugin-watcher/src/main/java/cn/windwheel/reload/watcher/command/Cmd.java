package cn.windwheel.reload.watcher.command;


/**
 * @author windwheel
 */
public interface Cmd {

    String[] key();

    String help();

    void handle();

}
