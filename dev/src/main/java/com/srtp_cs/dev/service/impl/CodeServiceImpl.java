package com.srtp_cs.dev.service.impl;

import com.srtp_cs.dev.mapper.CodeMapper;
import com.srtp_cs.dev.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static com.srtp_cs.dev.common.PreprocessingTool.enTokenizeStopStem;

@Service
public class CodeServiceImpl implements CodeService {

    @Autowired
    private CodeMapper codeMapper;

    @Override
    public void insertCodeByFile(String filePath, String type) {
        List<String> rcodeList = new ArrayList<>();
        String url = "内置数据库";
        try {
            File myFile = new File(filePath);
            if (myFile.isFile() && myFile.exists()) {

                //考虑到编码格式，new FileInputStream(myFile)文件字节输入流，以字节为单位对文件中的数据进行读取
                //new InputStreamReader(FileInputStream a, "编码类型")
                //将文件字节输入流转换为文件字符输入流并给定编码格式
                InputStreamReader Reader = new InputStreamReader(new FileInputStream(myFile), StandardCharsets.UTF_8);

                //BufferedReader从字符输入流中读取文本，缓冲各个字符，从而实现字符、数组和行的高效读取。
                //通过BuffereReader包装实现高效读取
                BufferedReader bufferedReader = new BufferedReader(Reader);

                String lineTxt;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    rcodeList.add(lineTxt);
                }
                Reader.close();
            } else {
                System.out.println("找不到指定的文件");
            }

        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }

        int i = 10;
        for (String rcode : rcodeList) {
            if(i-- == 0) {
                break;
            }
            String pcode = enTokenizeStopStem(rcode);
            try {
                codeMapper.insertCode(rcode, pcode, url, type);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
