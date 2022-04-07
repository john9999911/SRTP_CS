package com.srtp_cs.dev.controller;

import com.srtp_cs.dev.common.JythonTool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping({"/jython"})
    @ResponseBody
    public String jythonTest() {
        JythonTool jythonTool = new JythonTool();
        try {
            List<List<String>>result = jythonTool.callJython("find", 3);
            StringBuilder sb = new StringBuilder();
            for (List<String> strings : result) {
                sb
                        .append(strings.get(0)).append(' ')
                        .append(strings.get(1)).append("\n");
            }
            System.out.println("jython succeed:\n" + sb);
            return "jython succeed:\n" + sb;
        } catch (Exception e) {
            e.printStackTrace();
            return "jython failed";
        }
    }

}

