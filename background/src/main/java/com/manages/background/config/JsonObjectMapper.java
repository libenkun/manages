package com.manages.background.config;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;

public class JsonObjectMapper extends ObjectMapper {
    public JsonObjectMapper(){
        super();
        SimpleModule simpleModule = new SimpleModule();
        //全局Long转字符串
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
        // simpleModule.addDeserializer(.class, CommonDateDeserializer.INSTANCE);
       // this.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        this.registerModule(simpleModule);
        //设置全局时间转换
        this.setDateFormat(new CustomDateFormat());
        this.registerModule(new JavaTimeModule());
        //全局将null 转""
     this.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
               //将null转为""
               jsonGenerator.writeString(StringUtils.EMPTY);
            }
        }
        );

    }


}
