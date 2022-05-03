package cn.windwheel.reload.watcher.worker;

/**
 * @author windwheel
 */
public class WorkerFactory {

    public static Worker createWorker() {
        return new LocalWorker();
    }


}
