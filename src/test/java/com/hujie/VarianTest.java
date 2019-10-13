package com.hujie;


import org.junit.Test;

public class VarianTest {

    private static  int staticvar = 0;
    private int var =0;

    @Test
    public void test1(){
        staticvar++;
        var++;

        System.out.println("staticvar"+staticvar);
        System.out.println("var"+var);
    }
}
