package com.jzz;

import java.math.BigDecimal;

/**
 * @author:jzz
 * @date:2020/12/14
 */
public class Test {

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(12.0);
        if(isNum(bigDecimal)) {
            System.out.println(1);
        }else {
            System.out.println(2);
        }
    }

    public static Boolean isNum (BigDecimal bd) {
        try{
            bd.toBigIntegerExact();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static void menthod (String str) {
        System.out.println("1");
        System.out.println(0.1*5);
        System.out.println(0.1*5 == 0.5);
    }

    public void menthod (Object obj) {
        System.out.println("2");
    }

}
