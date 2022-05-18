package com.srtp_cs.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping({"/jython"})
    @ResponseBody
    public String jythonTest() {

        return "result";
    }

}

