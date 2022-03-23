package com.srtp_cs.dev.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private String rid;
    private String search_keyword;
    private String result_code_id;
    private String score;
}
