package com.manages.background.utils;

import com.alibaba.fastjson.JSONObject;
import com.manages.background.exception.BusinessException;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Administrator on 2018-10-17.
 */
public class JwtTokenUtils implements Serializable{

    public static Long getUserId(){
        String Authorization = getauthstr();
        return getJSONObject(Authorization).getLong("userId");
    }
    public static String getPhone(){
        String Authorization = getauthstr();
        return getJSONObject(Authorization).getString("mobile");
    }

    private static String getauthstr() {
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        String Authorization = request.getHeader("Authorization");
        if (Objects.isNull(Authorization)) {
            throw new BusinessException(500, "Authorization不存在");
        }
        return Authorization;
    }

    public static String getUserName(String authorization){
        return getJSONObject(authorization).getString("mobile");
    }

    public static Long getUserId(String authorization){
        return getJSONObject(authorization).getLong("userId");
    }

    public static JSONObject getJSONObject(String authorization){
        String token = authorization.split(" ")[1];
        Jwt jwt = JwtHelper.decode(token);
        JSONObject jsonObject = JSONObject.parseObject(jwt.getClaims());
        JSONObject userBase = jsonObject.getJSONObject("userBase");
        return userBase;
    }
}
