package com.srtp_cs.dev.mapper;

import com.srtp_cs.dev.entity.Code;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CodeMapper {
    Code getCodeById(int id);
    List<Code> getCodeByType();
    List<Code> getAllCode();
    void insertCode(String rcode, String pcode, String source_url, String type);
    void updateCode(Code code);
    void deleteCode(int id);

}
