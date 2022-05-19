package com.srtp_cs.dev.common;

import org.springframework.aop.scope.ScopedProxyUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RunModelTool {


    ArrayList<OneResult> rList = new ArrayList<>();

    public void run(String... exeArgs) {
        rList.clear();
        try {
            Process process = Runtime.getRuntime().exec(exeArgs);
            final InputStream is1 = process.getInputStream();

            new Thread(() -> {
                BufferedReader br = new BufferedReader(new InputStreamReader(is1));
                String line;
                OneResult result = new OneResult("", 0);
                int flag = 0;
                try {
                    while (!(line = br.readLine()).equals("******"));

                    while ((line = br.readLine()) != null) {
                        if (flag == 0) {
                            result.code = line;
                            flag = 1;
                        } else {
                            result.sim = Double.parseDouble(line);
                            rList.add(result);
                            flag = 0;
                            result = new OneResult("", 0);
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

            int exitVal = process.waitFor();
            System.out.println(exitVal == 0 ? "成功" : "失败");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<OneResult> runModel(String query, int num) {
        String[] exeArgs = {"powershell.exe", "D:\\ChenGe\\Codefiles\\srtp\\Hu_TabCS\\venv\\Scripts\\python.exe", "D:\\ChenGe\\Codefiles\\srtp\\Hu_TabCS\\model_code\\my_model.py", query, String.valueOf(num)};
        run(exeArgs);
        return rList;
    }

    public static void main(String[] args) {
        RunModelTool runExeTool = new RunModelTool();
        String[] exeArgs = {"powershell.exe", "D:\\ChenGe\\Codefiles\\srtp\\Hu_TabCS\\venv\\Scripts\\python.exe", "D:\\ChenGe\\Codefiles\\srtp\\Hu_TabCS\\model_code\\my_model.py", "convert int to string", "5"};
        runExeTool.run(exeArgs);
    }
}