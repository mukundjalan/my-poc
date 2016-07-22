package com.genius.serializer.exec;

import com.genius.serializer.SerializerEnum;
import com.genius.serializer.model.AggregatedEmployee;
import com.genius.serializer.model.Employee;
import com.genius.serializer.model.GeneralizedEmployee;
import com.genius.serializer.model.ShadowedEmployee;
import com.genius.serializer.model.UnoverridedShadowedEmployee;

public class SerializerDemo {

  public static void main(String[] args) {
    SerializerDemo fullDemo = new SerializerDemo();

    fullDemo.executeGeneralizationDemo("Generalized Serialization",
        GeneralizedEmployee.prepareSampleObject());
    
    fullDemo.executeGeneralizationDemo("Aggregated Serialization",
        AggregatedEmployee.prepareSampleObject());
    
    fullDemo.executeGeneralizationDemo("Shadowed Serialization",
        ShadowedEmployee.prepareSampleObject());
    
    fullDemo.executeGeneralizationDemo("Unoverrided Shadowed Serialization",
        UnoverridedShadowedEmployee.prepareSampleObject());

    System.out.println("Demo Finished Successfully!!!");
  }

  public void executeGeneralizationDemo(String demoType, Employee employeeToSerialize) {
    System.out.println(demoType + " Demo\n");

    System.out.println("Employee To Serialize -");
    System.out.println(employeeToSerialize);
    System.out
        .println("--------------------------------------------------------------------------\n");

    SerializerEnum.demoAllSerializers(employeeToSerialize.getClass(), employeeToSerialize);
    System.out
        .println("**************************************************************************\n");
  }

}
