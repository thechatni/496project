package com.company;

import java.util.Arrays;

//Rule 01. Declarations and Initialization (DCL)
//Rule 03. Numeric Types and Operations (NUM)
//Rule 02. Expressions (EXP)
//Rule 06. Methods (MET)

public class Main {

    public static void main(String[] args) {
	//write your code here

        Calculator ex = new Calculator();
        ex.m();
        int aa=ex.getAbsAdd(15,14);
        int bb = ex.multAccum(30, 15, 2);

        SuperClass s = new SuperClass();
        s.doSomething();

        System.out.println(A.a);
    }
}

//DCL00-J Prevent Class Initialization Cycles
class A {
    public static int a = B.b();
}

class B {
    public static int b() { return B.c(); }
    public static int c() { return 1; }
}

//DCL01-J. Do not reuse public identifiers from the Java Standard Library
class Calculator {
    public void m(){
        //EXP02-J. Do not use the Object.equals() method to compare two arrays
        int[]arr1=new int[20]; // Initialized to 0
        int[]arr2=new int[20]; // Initialized to 0
        System.out.println(Arrays.equals(arr1,arr2)); // Prints true

        //NUM01-J. Do not perform bitwise and arithmetic operations on the same data
        int x = -50;
        x /= 4;

        //EXP00-J. Do not ignore values returned by methods
        String original = "imperfect";
        original = original.replace('i', '9');
        System.out.println(original);
    }

    //MET01-J. Never use assertions to validate method arguments
    public int getAbsAdd(int x, int y) {
        if (x == Integer.MIN_VALUE || y == Integer.MIN_VALUE) {
            throw new IllegalArgumentException();
        }
        int absX = Math.abs(x);
        int absY = Math.abs(y);
        if (absX > Integer.MAX_VALUE - absY) {
            throw new IllegalArgumentException();
        }
        return absX + absY;
    }

    //NUM00-J. Detect or prevent integer overflow
    public int multAccum(int oldAcc, int newVal, int scale) {
        return Math.addExact(oldAcc, Math.multiplyExact(newVal, scale));
    }

}

//MET05-J. Ensure that constructors do not call overridable methods
class SuperClass {
    public SuperClass() {
        doSomething();
    }

    public final void doSomething() {
        System.out.println("This is superclass!");
    }
}