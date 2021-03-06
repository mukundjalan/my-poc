package com.genius.serializer.mule;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;

import com.genius.serializer.model.Employee;
import com.genius.serializer.model.GeneralizedEmployee;

public class SerializerDemoComponent implements Callable {

  @Override
  public Object onCall(MuleEventContext eventContext) throws Exception {
    MuleMessage muleMessage = eventContext.getMessage();
    
    Employee employee = GeneralizedEmployee.prepareSampleObject();
    muleMessage.setPayload(employee);
    
    return muleMessage;
  }

}
