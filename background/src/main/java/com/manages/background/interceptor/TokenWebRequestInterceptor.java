package com.manages.background.interceptor;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

import java.util.Objects;

/**
 * @author dinglixiao
 */
@Slf4j
@Component
public class TokenWebRequestInterceptor implements WebRequestInterceptor {

    @Override
    public void preHandle(WebRequest request) throws Exception {

        String Authorization = request.getHeader("Authorization");

        String token = null;
        if (Objects.nonNull(Authorization) && Authorization.startsWith("bearer ")) {
            token = Authorization.replaceFirst("bearer ", "");
        }
        if (Objects.nonNull(Authorization) && Authorization.startsWith("Bearer ")) {
            token = Authorization.replaceFirst("Bearer ", "");
        }

        Jwt jwt = null;
        if (token != null) {

            try {
                jwt = JwtHelper.decode(token);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }

        if (jwt != null) {

            JSONObject jsonObject = JSONObject.parseObject(jwt.getClaims());
            /*"userBase": {
                "userId": 1098864867511177200,
                "userName": "18388165727",
                "email": null,
                "mobile": "18388165727",
                "passWord": null,
                "userStatus": 1,
                "remark": "134saf",
                "registerSource": null,
                "createTime": 1550853575000,
                "modifyTime": 1550853575000
            }*/
            JSONObject userBase = jsonObject.getJSONObject("userBase");

            request.setAttribute("id", userBase.getLong("id"), WebRequest.SCOPE_REQUEST);
        }

        /**
         * otherData json解析
         */
        String otherData = request.getHeader("otherData");
        if (Objects.nonNull(otherData)) {
            JSONObject json = JSONObject.parseObject(otherData);
            json.forEach((k, v) -> request.setAttribute(k, v, WebRequest.SCOPE_REQUEST));
        }
    }

    @Override
    public void postHandle(WebRequest request, ModelMap model) throws Exception {

    }

    @Override
    public void afterCompletion(WebRequest request, Exception ex) throws Exception {

    }
}
