package com.manages.background.exception;

import com.manages.background.utils.ResultJson;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author kzh
 * @Description
 * @Date 19-5-16 下午5:24
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ResultJsonException extends RuntimeException {
    private ResultJson resultJson;

    public ResultJsonException(ResultJson resultJson) {
        this.resultJson = resultJson;
    }
}
