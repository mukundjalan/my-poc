package com.genius.serializer.model;

public class ShadowedEmployee extends Person implements Employee {

  private static final long serialVersionUID = -1583109956518246542L;

  private String name;
  private String address;
  private transient int SSN;
  private int number;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getSSN() {
    return SSN;
  }

  public void setSSN(int sSN) {
    SSN = sSN;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  @Override
  public String toString() {
    return "ShadowedEmployee [Inherited=" + super.toString() + ", name=" + name + ", address="
        + address + ", SSN=" + SSN + ", number=" + number + "]";
  }

  public static ShadowedEmployee prepareSampleObject() {
    ShadowedEmployee employee = new ShadowedEmployee();
    employee.setName(SerializationConstants.NAME);
    employee.setAddress(SerializationConstants.ADDRESS);
    employee.setSSN(SerializationConstants.SSN);
    employee.setNumber(SerializationConstants.NUMBER);
    return employee;
  }

}
