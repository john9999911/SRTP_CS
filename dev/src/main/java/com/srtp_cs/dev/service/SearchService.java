package com.srtp_cs.dev.service;


import com.srtp_cs.dev.common.OneResult;

import java.util.ArrayList;

public interface SearchService {
    ArrayList<OneResult> search(String keyword, int num);

}
