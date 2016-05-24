package com.genius.serializer;

public enum SerializerEnum {
  JAVA("Java", new JavaSerializer()), KRYO("Kryo", new KryoSerializer());

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

  public static <T, U extends T> void demoAllSerializers(Class<U> clazz, T objectToSerialize) {
    for (SerializerEnum serializer : values()) {
      System.out.println("Demo " + serializer.serializerName + " Serializer");
      try {
        serializer.demoSerializer(clazz, objectToSerialize);
      } catch (Exception e) {
        System.out.println(serializer.serializerName + " Serializer Failed!!!");
      }
      System.out.println("--------------------------------------------------------------------------\n");
    }
  }
}
