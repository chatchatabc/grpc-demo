package org.mvnsearch.application;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.protobuf.util.JsonFormat;
import org.junit.jupiter.api.Test;
import org.mvnsearch.service.AccountResponse;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linux_china
 */
public class JacksonTest {
    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        //objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        //objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        objectMapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);


    }

    @Test
    public void testProtoJsonOutput() throws Exception {
        AccountResponse account = AccountResponse.newBuilder().setId(1).setNick("linux_china").build();
        System.out.println(JsonFormat.printer().print(account));
    }
}
