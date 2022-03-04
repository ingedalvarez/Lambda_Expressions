package com.company;

public class Calculator {
    interface IntegerMath{
        int operation(int a, int b);
    }

    public int operatioknBinary(int a, int b, IntegerMath op){
        return op.operation(a, b);
    }

    public static void main(String[] args) {
        Calculator myApp = new Calculator();
        IntegerMath addition = (a, b)->a + b;
        IntegerMath subtraccion = (a, b)-> a - b;

        System.out.println("40 + 2 = "+ myApp.operatioknBinary(40, 2, addition));
        System.out.println("20 - 12 = "+ myApp.operatioknBinary(20, 12, subtraccion));
    }
}
