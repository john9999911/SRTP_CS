package com.srtp_cs.dev.controller.Search;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

    @RequestMapping("search_result")
    public String SearchResult(@RequestParam("resultNum") int resultNum, Model model){




        return "search_result";
    }
}
