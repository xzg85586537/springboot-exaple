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
 * @Date: 2020-01-15 11:19
 * @Version 1.0
 */
public class SqlException extends RuntimeException {
    public SqlException() {
    }

    public SqlException(String message) {
        super(message);
    }

    public SqlException(String code, String message) {
        super(code + ": " + message);
    }

    public SqlException(Throwable cause) {
        super(cause);
    }

    public SqlException(String message, Throwable cause) {
        super(message, cause);
    }
}
