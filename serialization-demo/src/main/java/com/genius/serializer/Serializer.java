package com.genius.serializer;

public interface Serializer {

  public void serialize(Object objectToSerialize);

  public <T> T deSerialize(Class<T> clazz);

}
