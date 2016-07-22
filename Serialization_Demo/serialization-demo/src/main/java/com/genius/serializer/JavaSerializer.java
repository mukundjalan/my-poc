package com.genius.serializer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.genius.serializer.model.SerializationConstants;

public class JavaSerializer implements Serializer {

  @Override
  public <T> void serialize(T objectToSerialize) {
    try (FileOutputStream fileOut = new FileOutputStream(SerializationConstants.FILE_PATH);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);) {
      out.writeObject(objectToSerialize);
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T, U extends T> T deSerialize(Class<U> clazz) {
    try (FileInputStream fileIn = new FileInputStream(SerializationConstants.FILE_PATH);
        ObjectInputStream in = new ObjectInputStream(fileIn);) {
      return (T) in.readObject();
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

}
