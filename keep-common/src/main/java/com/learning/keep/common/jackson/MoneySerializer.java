package com.learning.keep.common.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by huangdawei on 2017/8/25.
 * Long类型的金额除以10000
 */
public class MoneySerializer extends JsonSerializer<Long> {
    @Override
    public void serialize(Long aLong, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        BigDecimal bigDecimal = new BigDecimal(aLong.doubleValue() / 10000);
        double value = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        jsonGenerator.writeString(String.valueOf(value));
    }
}
