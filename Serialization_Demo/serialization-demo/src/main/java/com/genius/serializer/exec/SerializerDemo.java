package com.genius.serializer.exec;

import com.genius.serializer.JavaSerializer;
import com.genius.serializer.KryoSerializer;
import com.genius.serializer.Serializer;
import com.genius.serializer.model.Employee;

public class SerializerDemo {

  public static void main(String[] args) {
    SerializerDemo fullDemo = new SerializerDemo();
    fullDemo.executeDemo();
  }

  public void executeDemo() {
    Employee employeeToSerialize = Employee.prepareSampleObject();

    System.out.println("Employee To Serialize-");
    System.out.println(employeeToSerialize);
    System.out.println();

    this.demoSerializer("Java", new JavaSerializer(), Employee.class, employeeToSerialize);
    this.demoSerializer("Kryo", new KryoSerializer(), Employee.class, employeeToSerialize);
  }

  private <T> void demoSerializer(String serializerName, Serializer serializer, Class<T> clazz,
      T objectToSerialize) {
    System.out.println("Demo " + serializerName + " Serializer");
    serializer.serialize(objectToSerialize);
   
    System.out.println(serializerName + " Deserialized Object -");
    T deserializedObject = serializer.deSerialize(clazz);
    System.out.println(deserializedObject);

    System.out.println();
  }

}
