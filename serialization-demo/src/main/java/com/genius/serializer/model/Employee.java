package com.genius.serializer.model;

import java.io.Serializable;

public class Employee extends Person implements Serializable {

  private static final long serialVersionUID = -1583109956518246542L;

  private String address;
  private transient int SSN;
  private int number;

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
    return "Employee [Inherited=" + super.toString() + ", address=" + address + ", SSN=" + SSN
        + ", number=" + number + "]";
  }

}
