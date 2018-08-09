package com.majq.sendmail.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.Map;

public class FreemarkerUtil {
    /**
     * 获取模板
     *
     * @param name
     * @return
     */
    public static Template getTemplate(String name) {
        Configuration cfg = new Configuration();
        cfg.setClassForTemplateLoading(Object.class, "/template");
        try {
            Template template = cfg.getTemplate(name);
            return template;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void print(String name, Map<String, Object> root, OutputStream outputStream) throws IOException, TemplateException {
        Template template = getTemplate(name);
        template.process(root, new PrintWriter(outputStream));
    }

    public static void print(String name, Map<String, Object> root, Writer outputStream) throws IOException, TemplateException {
        Template template = getTemplate(name);
        template.process(root, new PrintWriter(outputStream));
    }


    public static void fprint(String name, Map<String, Object> root, String outFile) {
        try (FileWriter writer = new FileWriter(new File(outFile))) {
            Template template = getTemplate(name);
            template.setEncoding("utf-8");
            template.process(root, writer);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

}
