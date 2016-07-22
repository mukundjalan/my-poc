package com.genius.serializer;

import java.io.FileReader;
import java.io.FileWriter;

import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlWriter;
import com.genius.serializer.model.SerializationConstants;

public class YAMLSerializer implements Serializer {

  @Override
  public <T> void serialize(T objectToSerialize) {
    try {
      YamlWriter yamlWriter = new YamlWriter(new FileWriter(SerializationConstants.FILE_PATH));
      yamlWriter.write(objectToSerialize);
      yamlWriter.close();
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  @Override
  public <T, U extends T> T deSerialize(Class<U> clazz) {
    try {
      YamlReader yamlReader = new YamlReader(new FileReader(SerializationConstants.FILE_PATH));
      T deserializedObject = yamlReader.read(clazz);
      yamlReader.close();
      return deserializedObject;
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

}
