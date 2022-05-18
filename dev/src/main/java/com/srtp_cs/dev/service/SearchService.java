package com.srtp_cs.dev.service;


import com.srtp_cs.dev.common.OneResult;
import com.srtp_cs.dev.common.RunModelTool;

import java.util.ArrayList;

public interface SearchService {
    ArrayList<OneResult> search(String keyword, int num);

}
