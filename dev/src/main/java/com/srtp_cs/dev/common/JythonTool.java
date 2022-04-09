package com.srtp_cs.dev.common;

import org.python.core.*;
import org.python.util.PythonInterpreter;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Properties;

public class JythonTool {
    String moduleUrl; //
    Properties props;
    PySystemState sys;
    Properties preprops;
    PythonInterpreter interpreter;
    String pythonHome; //
    String codePath; //
    String pythonPath; //
    String pythonPydPath; //
    String functionName; //
    PyFunction pyFunction;



    public JythonTool(){
        init();
    }

    void init(String moduleUrl, String pythonHome, String pythonPath, String codePath, String pythonPydPath, String functionName){
        this.moduleUrl = moduleUrl;
        this.pythonHome = pythonHome;
        this.pythonPath = pythonPath;
        this.codePath = codePath;
        this.pythonPydPath = pythonPydPath;
        this.functionName = functionName;

        props = new Properties();
        props.put("python.home", pythonHome); // set python home
        props.put("python.console.encoding", "UTF-8");
        props.put("python.security.respectJavaAccessibility", "false");
        props.put("python.import.site", "false");

        sys = Py.getSystemState();
        sys.path.add(codePath); //set source code path
        sys.path.add(pythonPath); //set python path

        preprops = System.getProperties();
        interpreter = new PythonInterpreter();
        PythonInterpreter.initialize(preprops, props, new String[0]);
        interpreter.execfile(moduleUrl);
        pyFunction = interpreter.get(functionName, PyFunction.class);
    }
    void init(){
        moduleUrl = "D:\\ChenGe\\Codefiles\\srtp\\Hu_TabCS\\model_code\\my_jython.py";
//        moduleUrl = "D:\\ChenGe\\Codefiles\\srtp\\Hu_TabCS\\model_code\\my_model.py";


        pythonHome = "E:\\Program Files (x86)\\Anaconda";
        pythonPath = "D:\\ChenGe\\Codefiles\\srtp\\Hu_TabCS\\venv\\Lib\\site-packages";
        codePath = "D:\\ChenGe\\Codefiles\\srtp\\Hu_TabCS\\model_code";
        pythonPydPath = "C:\\Users\\30838\\AppData\\Local\\JetBrains\\PyCharm2021.2\\python_stubs\\988085416\\numpy\\core";
        functionName = "call_module";
        init(moduleUrl, pythonHome, pythonPath, codePath, pythonPydPath, functionName);
    }

    public List<List<String>> callJython(String query, int numOfReturns) {
        PyString strJson=Py.newStringOrUnicode(query);
        PyObject pyResults = pyFunction.__call__(strJson, new PyInteger(numOfReturns));
        List<List<String>> Returns;
        Returns = (List<List<String>>) pyResults;
        return Returns;
    }

}














