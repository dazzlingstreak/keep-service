package com.learning.keep.common.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by huangdawei on 2017/8/25.
 */
public class MoneyDeserializer extends JsonDeserializer<Long> {
    @Override
    public Long deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String valueAsString = jsonParser.getValueAsString();
        BigDecimal multiplicand = new BigDecimal(10000);
        long longValue = new BigDecimal(valueAsString).multiply(multiplicand).longValue();
        return longValue;
    }
}
