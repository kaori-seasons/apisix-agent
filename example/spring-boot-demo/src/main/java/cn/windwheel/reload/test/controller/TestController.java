package cn.windwheel.reload.test.controller;

import cn.windwheel.reload.test.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author windwheel
 */
@RestController
public class TestController {

    @Resource
    private TestService testService;

    @RequestMapping("/test")
    public Object test() {
        return testService.list();
    }


}
