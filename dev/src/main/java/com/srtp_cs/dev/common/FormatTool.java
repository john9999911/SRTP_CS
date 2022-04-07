package com.srtp_cs.dev.common;

import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.FormatterException;
import com.google.googlejavaformat.java.JavaFormatterOptions;

public class FormatTool {
    JavaFormatterOptions.Style style;
    JavaFormatterOptions options;
    Formatter formatter;

    public FormatTool() {
        style = JavaFormatterOptions.Style.AOSP;
        options = JavaFormatterOptions.builder().style(style).build();
        formatter = new Formatter(options);
    }

    public String format(String source) throws FormatterException {
        return formatter.formatSource(source);
    }

    public static void main(String[] args) throws FormatterException {
        FormatTool formatTool = new FormatTool();
        String source = "public class FormatTool { public static void main(String[] args) { System.out.println(\"Hello World!\");}}";
        String formattedSource = formatTool.format(source);
        System.out.println(formattedSource);
    }
}



