package com.cy.java.exception;

public class ExceptionTest01 {
    static int doMethod(){
        try {
            int a=100;
            return a;//after returning
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }finally {//after
            System.out.println("finally");
        }
    }
    public static void main(String[] args) {
            doMethod();
    }
}
