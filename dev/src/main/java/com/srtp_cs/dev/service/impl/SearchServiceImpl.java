package com.srtp_cs.dev.service.impl;

import com.google.googlejavaformat.java.FormatterException;
import com.srtp_cs.dev.common.FormatTool;
import com.srtp_cs.dev.common.OneResult;
import com.srtp_cs.dev.common.RunModelTool;
import com.srtp_cs.dev.service.SearchService;

import java.util.ArrayList;

public class SearchServiceImpl implements SearchService {
    FormatTool formatTool = new FormatTool();

    @Override
    public ArrayList<OneResult> search(String keyword, int num) {
        ArrayList<OneResult> result;
        RunModelTool runModelTool = new RunModelTool();
        result = runModelTool.runModel(keyword, num);
        for(OneResult oneResult : result){
            String tmpStr = "public class Solution{" + oneResult.getCode() + "}";

            try {
                oneResult.setCode(formatTool.format(tmpStr));
            } catch (FormatterException e) {
                e.printStackTrace();
            }
        }


        return result;
    }
}
