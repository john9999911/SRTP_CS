package com.srtp_cs.dev.controller.Search;

import com.srtp_cs.dev.common.JythonTool;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller

public class ResultController {

    @RequestMapping("/result")
    public String result(
            Model model,
            @RequestParam("searchText")String searchText,
            @RequestParam("searchNum")int num
    ) {
        System.out.println("searchText: " + searchText);
        //searchText 不能包含中文
        for (int i = 0; i < searchText.length(); i++) {
            if (searchText.substring(i,i+1).matches("[\u4e00-\u9fa5]")) {
                model.addAttribute("msg", "搜索词不能包含中文");
                System.out.println("搜索词不能包含中文");
                return "/index" ;
            }
        }

        model.addAttribute("searchText", searchText);
        model.addAttribute("selectedNum", num);

        JythonTool jythonTool = new JythonTool();
        List<List<String>>results = jythonTool.callJython(searchText, num);
        String[][] result_strs = new String[results.size()][];
        for (int i = 0; i < results.size(); i++) {
            result_strs[i] = results.get(i).toArray(new String[0]);
        }

//        model.addAttribute("results",results);
        model.addAttribute("results", result_strs);
        return "search_result";
    }
}