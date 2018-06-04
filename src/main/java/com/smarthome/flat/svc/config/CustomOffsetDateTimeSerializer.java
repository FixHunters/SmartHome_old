package com.smarthome.flat.svc.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import org.threeten.bp.OffsetDateTime;


// je tu kvoli model.certificates
public class CustomOffsetDateTimeSerializer extends JsonSerializer<OffsetDateTime> {
  @Override
  public void serialize(OffsetDateTime arg0, JsonGenerator arg1, SerializerProvider arg2)
      throws IOException, JsonProcessingException {
    arg1.writeString(arg0.toString());
  }
}
