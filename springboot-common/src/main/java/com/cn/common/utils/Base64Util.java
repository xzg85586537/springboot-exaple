/*
 * Copyright 2020 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.cn.common.utils;

import cn.hutool.core.util.StrUtil;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.net.URLEncoder;

/**
 * @Author: Administrator
 *  图片路径和Base64位互相转换
 * @Date: 2020-02-05 15:09
 * @Version 1.0
 */
public class Base64Util {
    public static String imgToBase64(String filePath){
        try {
            InputStream is = new FileInputStream(filePath);
            byte[] data = new byte[is.available()];
            is.read(data);
            is.close();
            BASE64Encoder encoder = new BASE64Encoder();
            String base64 = encoder.encode(data);
            return URLEncoder.encode(base64,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return StrUtil.EMPTY;
        }
    }
    public static void base64ToImg(String base64,String filePath){
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] bytes = decoder.decodeBuffer(base64);
            File file = new File(filePath);
            OutputStream os = new FileOutputStream(file);
            os.write(bytes);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
