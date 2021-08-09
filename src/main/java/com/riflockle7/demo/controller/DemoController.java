package com.riflockle7.demo.controller;

import com.riflockle7.demo.vo.TestVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
class DemoController {
    @RequestMapping(value = "/home")
    public String home() {
        return "index";
    }

    @ResponseBody
    @RequestMapping("/valueTest")
    public String valueTest() {
        String value = "테스트 String";
        return value;
    }

    @RequestMapping("/test")
    public ModelAndView test() throws Exception {
        ModelAndView mav = new ModelAndView("demo");
        mav.addObject("name", "rickkky");
        List<String> testList = new ArrayList<>();
        testList.add("a");
        testList.add("b");
        testList.add("c");
        mav.addObject("list", testList);
        return mav;
    }

    @RequestMapping("/thymeleafTest")
    public String thymeleafTest(Model model) {
        TestVo testModel = new TestVo("rickky", "맄희");
        model.addAttribute("testModel", testModel);
        return "thymeleaf/thymeleafTest";
    }
}

/**
 * [@Controller], [@ResponseBody] 를 합친 역할
 */
@RestController
class DemoRestController {
    @RequestMapping(value = "/testValue", method = RequestMethod.GET)
    public String getTestValue() {
        String testValue = "레스트컨트롤러 테스트";
        return testValue;
    }
}