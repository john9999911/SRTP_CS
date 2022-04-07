package com.srtp_cs.dev.controller.Search;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller

public class ResultController {

    @RequestMapping("/result")
    public String result(Model model, String search) {
        model.addAttribute("search", search);
        ArrayList<String> results = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            results.add("Result " + i);
        }
        model.addAttribute("results",results);

        return "search_result";
    }
}