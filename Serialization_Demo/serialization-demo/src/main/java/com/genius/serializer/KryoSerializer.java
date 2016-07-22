package com.genius.serializer;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.genius.serializer.model.SerializationConstants;

public class KryoSerializer implements Serializer {

  private final Kryo kryo;

  public KryoSerializer() {
    kryo = new Kryo();
  }

  @Override
  public <T> void serialize(T objectToSerialize) {
    try (FileOutputStream fileOut = new FileOutputStream(SerializationConstants.FILE_PATH);
        Output output = new Output(fileOut);) {
      kryo.writeObject(output, objectToSerialize);
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  @Override
  public <T, U extends T> T deSerialize(Class<U> clazz) {
    try (FileInputStream fileIn = new FileInputStream(SerializationConstants.FILE_PATH);
        Input input = new Input(fileIn);) {
      return kryo.readObject(input, clazz);
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

}
