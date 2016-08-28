package com.lambda;

public class OperateMath {

  public static void main(String[] args) {
    Integer num1 = 15;
    Integer num2 = 5;

    System.out.println("The numbers are: " + num1 + " & " + num2);

    for (MathOperations mathOperations : MathOperations.values()) {
      MathOperation mathOperation = mathOperations.getMathOperation();
      String operationName = mathOperations.getOperationName();
      System.out.println( operationName + " is: "
          + mathOperation.operate(num1, num2));
    }
  }

}

enum MathOperations {
  SUBTRACT("SUBTRACTTION", (num1, num2) -> num1 - num2),
  MULTIPLY("MULTIPLICATION", (int num1, int num2) -> { return num1 * num2; }),
  DIVIDE("DIVISION", (int num1, int num2) -> num1 / num2),
  ADD("ADDITION", new MathOperation() {
    @Override
    public int operate(int num1, int num2) {
      return num1 + num2;
    }
  });

  private final String operationName;
  private final MathOperation mathOperation;

  private MathOperations(String operationName, MathOperation mathOperation) {
    this.operationName = operationName;
    this.mathOperation = mathOperation;
  }

  public String getOperationName() {
    return operationName;
  }

  public MathOperation getMathOperation() {
    return mathOperation;
  }

}

@FunctionalInterface
interface MathOperation {
  int operate(int num1, int num2);
}
