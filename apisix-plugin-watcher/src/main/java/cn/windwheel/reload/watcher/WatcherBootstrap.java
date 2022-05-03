package cn.windwheel.reload.watcher;

import cn.windwheel.reload.common.AnsiLog;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;

/**
 * @author windwheel
 */
public class WatcherBootstrap {


    public static void main(String[] args) throws Exception {
        CommandLineParser defaultParser = new DefaultParser();
        Options options = new Options()
                .addOption("path", "path", true, "hot reload class watch path")
                .addOption("pid", "pid", true, "java process id");
        CommandLine commandLine = defaultParser.parse(options, args);
        String path = commandLine.getOptionValue("path");
        String pid = commandLine.getOptionValue("pid");
        Config.init(pid, path.split(","));
        AnsiLog.info("start apisix-plugin-watcher-boot");
        AnsiLog.info("pid: {}", pid);
        AnsiLog.info("watchPath: {}", path);
        App.me().start();
    }

}
