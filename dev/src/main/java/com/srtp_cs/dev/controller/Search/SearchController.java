package com.srtp_cs.dev.controller.Search;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SearchController {

    @RequestMapping("search_result")
    public String SearchResult(@RequestParam("resultNum") int resultNum, Model model){
        String[] result = new String[resultNum];
        for (int i = 0; i < resultNum; i++) {
            result[i] = "result_" + i;
        }
        model.addAttribute("result", result);
        return "search_result";

    }

}
