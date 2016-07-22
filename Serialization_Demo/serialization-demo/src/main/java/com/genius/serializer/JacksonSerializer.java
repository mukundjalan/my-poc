package com.genius.serializer;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.genius.serializer.model.SerializationConstants;

public class JacksonSerializer implements Serializer {

  private final ObjectMapper mapper;

  public JacksonSerializer() {
    mapper = new ObjectMapper();
  }

  @Override
  public <T> void serialize(T objectToSerialize) {
    try {
      mapper.writeValue(new File(SerializationConstants.FILE_PATH), objectToSerialize);
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  @Override
  public <T, U extends T> T deSerialize(Class<U> clazz) {
    try {
      return mapper.readValue(new File(SerializationConstants.FILE_PATH), clazz);
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

}
