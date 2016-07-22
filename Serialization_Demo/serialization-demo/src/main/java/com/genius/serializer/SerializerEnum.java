package com.genius.serializer;

import java.util.ArrayList;
import java.util.List;

public enum SerializerEnum {
  JAVA("Java", new JavaSerializer()),
  KRYO("Kryo", new KryoSerializer()),
  JACKSON("Jackson", new JacksonSerializer()),
  YAML("YAML", new YAMLSerializer());

  private static final long PERFORMANCE_OBJECT_COUNT = 100000;

  private final String serializerName;
  private final Serializer serializer;

  private SerializerEnum(String serializerName, Serializer serializer) {
    this.serializerName = serializerName;
    this.serializer = serializer;
  }

  public <T, U extends T> void demoSerializer(Class<U> clazz, T objectToSerialize) {
    serializer.serialize(objectToSerialize);
    System.out.println(serializerName + " Deserialized Object -");
    System.out.println(serializer.deSerialize(clazz));
  }

  public <T, U extends T> void demoSerializerPerformance(Class<U> clazz, T objectToSerialize) {
    System.out.println("<<<<<<<<<<Serialization Performance for " + PERFORMANCE_OBJECT_COUNT
        + " Objects>>>>>>>>>>");
    List<T> objectsToSerialize = new ArrayList<>();
    for (int i = 0; i < PERFORMANCE_OBJECT_COUNT; i++) {
      objectsToSerialize.add(objectToSerialize);
    }

    long serializationStartTime;
    long serializationEndTime;
    long deserializationStartTime;
    long deserializationEndTime;

    System.out.println(serializerName + " Serialization Started: "
        + (serializationStartTime = System.currentTimeMillis()));
    serializer.serialize(objectsToSerialize);
    System.out.println(serializerName + " Serialization Ended  : "
        + (serializationEndTime = System.currentTimeMillis()));
    System.out.println(serializerName + " Serialization Time   : "
        + (serializationEndTime - serializationStartTime));
    System.out.println("............................................");

    System.out.println(serializerName + " Deserialization Started: "
        + (deserializationStartTime = System.currentTimeMillis()));
    serializer.deSerialize(ArrayList.class);
    System.out.println(serializerName + " Deserialization Ended  : "
        + (deserializationEndTime = System.currentTimeMillis()));
    System.out.println(serializerName + " Deserialization Time   : "
        + (deserializationEndTime - deserializationStartTime));
    System.out.println("............................................");
  }

  public static <T, U extends T> void demoAllSerializers(Class<U> clazz, T objectToSerialize) {
    for (SerializerEnum serializer : SerializerEnum.values()) {
      try {
        System.out.println("Demo " + serializer.serializerName + " Serializer");
        serializer.demoSerializer(clazz, objectToSerialize);
        serializer.demoSerializerPerformance(clazz, objectToSerialize);
      } catch (Exception e) {
        System.out.println(serializer.serializerName + " Serializer Failed!!!");
      } finally {
        System.out
            .println("--------------------------------------------------------------------------\n");
      }
    }
  }

}
