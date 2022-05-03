package cn.windwheel.reload.agent;

import java.lang.instrument.Instrumentation;

/**
 * @author windwheel
 */
public interface Handler {

    void process(String args, Instrumentation inst);

}
