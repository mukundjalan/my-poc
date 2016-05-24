package com.genius.serializer;

public interface Serializer {

  public <T> void serialize(T objectToSerialize);

  public <T, U extends T> T deSerialize(Class<U> clazz);

}
