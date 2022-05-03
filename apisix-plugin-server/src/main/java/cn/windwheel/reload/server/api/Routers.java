package cn.windwheel.reload.server.api;

import lombok.extern.slf4j.Slf4j;
import spark.Request;
import spark.Response;

/**
 * @author windwheel
 */
@Slf4j
public class Routers {

    public static Object hotfix(Request req, Response resp) {
        String className = req.params("className");
        log.info("className: {}", className);
        return "ok";
    }

}
