package com.genius.serializer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.genius.serializer.model.SerializationConstants;

public class JavaSerializer implements Serializer {

  public void serialize(Object objectToSerialize) {
    try (FileOutputStream fileOut = new FileOutputStream(SerializationConstants.FILE_PATH);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);) {
      out.writeObject(objectToSerialize);
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  @SuppressWarnings("unchecked")
  public <T> T deSerialize(Class<T> clazz) {
    try (FileInputStream fileIn = new FileInputStream(SerializationConstants.FILE_PATH);
        ObjectInputStream in = new ObjectInputStream(fileIn);) {
      return (T) in.readObject();
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

}
