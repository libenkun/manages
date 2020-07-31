package com.manages.background.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class ResultJson implements Serializable {
    private Integer status;
    private Integer code;
    private Object data;
    private String message;

    /**
     * 封装失败响应信息
     * @param codeEnum
     * @param message
     * @return
     */
    public static ResultJson returnError( String message) {
        return returnError(0,message);
    }
    public static ResultJson returnError( Object data) {
        ResultJson resultJson = new ResultJson();
        resultJson.setStatus(0);
        resultJson.setCode(null);
        resultJson.setData(data);
        resultJson.setMessage("数据请求失败");
        return resultJson;
    }
    /**
     * 封装失败响应信息
     * @param code
     * @param message
     * @return
     */
    public static ResultJson returnError( Object data,String message) {
        ResultJson resultJson = new ResultJson();
        resultJson.setStatus(0);
        resultJson.setData(data);
        resultJson.setCode(null);
        resultJson.setMessage(message);
        return resultJson;
    }
    /**
     * 封装失败响应信息
     * @param code
     * @param message
     * @return
     */
    public static ResultJson returnError(Integer status,String message) {
        ResultJson resultJson = new ResultJson();
        resultJson.setStatus(status);
        resultJson.setData("");
        resultJson.setCode(null);
        resultJson.setMessage(message);
        return resultJson;
    }
    /**
     * 封装成功响应信息
     * @param message
     * @return
     */
    public static ResultJson returnOK(String message) {
        return returnOK(null, message);
    }

    /**
     * 封装成功响应信息
     * @param data
     * @return
     */
    public static ResultJson returnOK(Object data) {
        return returnOK(data, "数据请求成功");
    }

    /**
     * 封装成功响应信息
     * @param data
     * @param message
     * @return
     */
    public static ResultJson returnOK(Object data, String message) {
        ResultJson resultJson = new ResultJson();
        resultJson.setStatus(1);
        resultJson.setData(data);
        resultJson.setMessage(message);
        return resultJson;
    }

    /**
     * @param data
     * @return
     */
public static ResultJson ok(Object data){
    return returnOK(data, "数据请求成功");
}

    /**
     * @param message
     * @return
     */
    public static ResultJson error(String message){
        return returnError(0,message);
    }
}
