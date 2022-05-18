package com.srtp_cs.dev.controller.Search;


import com.srtp_cs.dev.common.OneResult;
import com.srtp_cs.dev.service.SearchService;
import com.srtp_cs.dev.service.impl.SearchServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;
import java.util.ArrayList;

@Controller

public class ResultController {
    SearchService searchService = new SearchServiceImpl();
    ArrayList<OneResult> results;

    @RequestMapping("/result")
    public String result(
            Model model,
            @RequestParam("searchText") String searchText,
            @RequestParam("searchNum") int num
    ) {
        System.out.println("searchText: " + searchText);
        //searchText 不能包含中文
        for (int i = 0; i < searchText.length(); i++) {
            if (searchText.substring(i, i + 1).matches("[\u4e00-\u9fa5]")) {
                model.addAttribute("msg", "搜索词不能包含中文");
                System.out.println("搜索词不能包含中文");
                return "/index";
            }
        }

        model.addAttribute("searchText", searchText);
        model.addAttribute("selectedNum", num);

        results = searchService.search(searchText, num);
        model.addAttribute("results", results);
        return "search_result";
    }

    @RequestMapping("/result_detail/{resultId}")
    public String result_detail(
            Model model,
            @PathVariable int resultId) {
        model.addAttribute("result", results.get(resultId));
        return "search_result_detail";
    }

}