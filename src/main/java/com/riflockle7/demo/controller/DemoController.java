package com.riflockle7.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
class DemoController {
    @RequestMapping(value = "/home")
    public String home() {
        return "index.html";
    }

    @ResponseBody
    @RequestMapping("/valueTest")
    public String valueTest() {
        String value = "테스트 String";
        return value;
    }
}

/** [@Controller], [@ResponseBody] 를 합친 역할 */
@RestController
class DemoRestController {
    @RequestMapping(value = "/testValue", method = RequestMethod.GET)
    public String getTestValue() {
        String testValue = "레스트컨트롤러 테스트";
        return testValue;
    }
}