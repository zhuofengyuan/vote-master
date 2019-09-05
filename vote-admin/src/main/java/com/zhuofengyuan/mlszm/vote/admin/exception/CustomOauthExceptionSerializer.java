package com.zhuofengyuan.mlszm.vote.admin.exception;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class CustomOauthExceptionSerializer extends StdSerializer<CustomOauthException> {
    public CustomOauthExceptionSerializer() {
        super(CustomOauthException.class);
    }

    @Override
    public void serialize(CustomOauthException value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        //可以不用下面的代码，只用 jsonGenerator.writeRawValue(myJsonString)  输出自定义字符串
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("code", value.getCode() == null ? value.getHttpErrorCode() : value.getCode());
        jsonGenerator.writeBooleanField("success", true);
        jsonGenerator.writeObjectField("payload", null);
        jsonGenerator.writeObjectField("msg", value.getMessage());
        jsonGenerator.writeEndObject();
    }
}
