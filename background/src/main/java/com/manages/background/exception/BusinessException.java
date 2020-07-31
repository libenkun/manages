package com.manages.background.exception;

import com.manages.background.enums.CodeEnum;

/**
 * @Author kzh
 * @Description 自定义业务异常
 * @Date 19-3-6 下午2:05
 */
public class BusinessException extends RuntimeException {

    // 异常信息code
    private Integer errorCode;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Integer code, String message) {
        super(message);
        this.errorCode = code;
    }

    public BusinessException(CodeEnum codeEnum, String message) {
        this(codeEnum.getCode(), message);
    }

    public BusinessException(CodeEnum codeEnum) {
        this(codeEnum.getCode(), codeEnum.getMsg());
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}
