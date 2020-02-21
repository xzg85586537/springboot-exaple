/*
 * Copyright 2020 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.cn.common.exception;

/**
 * @Author: Administrator
 * @Date: 2020-01-13 14:04
 * @Version 1.0
 * 异常处理器：用unicode提示
 *  返回结果 如： return new R(xxxx,"123456",ExceptionProperties.getCodeName("123456"))
 */
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ExceptionProperties {
    private static final Logger log = LoggerFactory.getLogger(ExceptionProperties.class);
    private Properties exceptionProp;

    public ExceptionProperties() {
        log.info("===================ExceptionProperties=============");
    }

    @PostConstruct
    public void init() {
        this.exceptionProp = new Properties();
        InputStream is = null;
        Object bf = null;

        try {
            log.info("===================PostConstruct loading exception properties=============");
            this.load((InputStream)is, (BufferedReader)bf, "sql-exception.properties");
            this.load((InputStream)is, (BufferedReader)bf, "app-exception.properties");
        } catch (Exception var12) {
            var12.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    ((InputStream)is).close();
                }

                if (bf != null) {
                    ((BufferedReader)bf).close();
                }
            } catch (IOException var11) {
                var11.printStackTrace();
            }

        }

        log.info("=================PostConstruct loaded exception.properties complite=============");
    }

    private void load(InputStream is, BufferedReader bf, String file) throws IOException {
        is = new BufferedInputStream(Thread.currentThread().getContextClassLoader().getResourceAsStream(file));
        bf = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        this.exceptionProp.load(bf);
        log.info("===================PostConstruct loaded " + file + "=============");
    }

    public Properties getExceptionProp() {
        return this.exceptionProp;
    }

    public String getCodeName(String code) {
        return this.exceptionProp.getProperty(code, this.exceptionProp.getProperty("00000"));
    }
}
