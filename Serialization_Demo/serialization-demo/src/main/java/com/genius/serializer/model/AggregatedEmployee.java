package com.genius.serializer.model;


public class AggregatedEmployee implements Employee {

  private static final long serialVersionUID = -1583109919648246547L;

  private Person person;
  private String address;
  private transient int SSN;
  private int number;

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
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
    return "AggregatedEmployee [Inherited=" + super.toString() + ", person=" + person + ", address=" + address + ", SSN=" + SSN
        + ", number=" + number + "]";
  }

  public static AggregatedEmployee prepareSampleObject() {
    AggregatedEmployee employee = new AggregatedEmployee();
    employee.setPerson(Person.prepareSampleObject());
    employee.setAddress(SerializationConstants.ADDRESS);
    employee.setSSN(SerializationConstants.SSN);
    employee.setNumber(SerializationConstants.NUMBER);
    return employee;
  }

}
