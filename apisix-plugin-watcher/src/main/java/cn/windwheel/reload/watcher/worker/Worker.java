package cn.windwheel.reload.watcher.worker;

import java.util.Set;

/**
 * @author windwheel
 */
public interface Worker {


    void doReload(Set<String> files);


}
