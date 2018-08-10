package com.majq.common.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.StringUtils;

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
        if (StringUtils.isBlank(name)) System.out.println("getTemplate name can not be null!");
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

    /**
     * 输出到指定的流中
     *
     * @param name
     * @param root
     * @param outputStream
     * @throws IOException
     * @throws TemplateException
     */
    public static void print(String name, Map<String, Object> root, OutputStream outputStream) throws IOException, TemplateException {
        if (StringUtils.isBlank(name) || null == root || null == outputStream)
            System.out.println("print params can not be null!");
        Template template = getTemplate(name);
        template.process(root, new PrintWriter(outputStream));
    }

    /**
     * 输出到指定的流中
     * @param name
     * @param root
     * @param outputStream
     * @throws IOException
     * @throws TemplateException
     */
    public static void print(String name, Map<String, Object> root, Writer outputStream) throws IOException, TemplateException {
        if (StringUtils.isBlank(name) || null == root || null == outputStream)
            System.out.println("print params can not be null!");
        Template template = getTemplate(name);
        template.process(root, new PrintWriter(outputStream));
    }

    /**
     * 输出到指定的文件中
     * @param name
     * @param root
     * @param outFile
     */
    public static void fprint(String name, Map<String, Object> root, String outFile) {
        if (StringUtils.isBlank(name) || null == root || StringUtils.isBlank(outFile))
            System.out.println("fprint params can not be null!");
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
