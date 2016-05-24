package com.genius.serializer.model;

public class Person {
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Person [name=" + name + "]";
  }

  public static Person prepareSampleObject() {
    Person person = new Person();
    person.setName(SerializationConstants.NAME);
    return person;
  }

}
