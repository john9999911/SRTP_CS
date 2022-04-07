package com.srtp_cs.dev.controller.Admin;

import com.srtp_cs.dev.service.CodeService;
import com.srtp_cs.dev.service.impl.CodeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private CodeService codeService;

    @RequestMapping("/code")
    @ResponseBody
    public String addCode() {
        try {
            codeService.insertCodeByFile("D:\\ChenGe\\Codefiles\\Java\\SRTP_CS\\dev\\src\\main\\java\\com\\srtp_cs\\dev\\service\\CodeService.java", "java");
            return "succeed!";
        } catch (Exception e) {
            e.printStackTrace();
            return "failed!";
        }
    }

}
