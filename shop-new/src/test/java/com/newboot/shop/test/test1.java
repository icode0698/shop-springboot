package com.newboot.shop.test;

public class test1 {
    static String s1 = "1";
    String s2 = "2";
    static String s3 = "3";

    public static String getS1() {
        return s1;
    }

    public static void setS1(String s1) {
        test1.s1 = s1;
    }

    public String getS2() {
        return s2;
    }

    public void setS2(String s2) {
        this.s2 = s2;
    }

    public String getS3() {
        return s3;
    }

    public void setS3(String s3) {
        this.s3 = s3;
    }

    public static void main(String[] args) {
        test1 t = new test1();
        System.out.println(test1.s1);
        test1.setS1("4");
        System.out.println("afters1:" + test1.s1);
        System.out.println("getS1_afters1:" + test1.getS1());
        System.out.println(t.s2);
        t.setS2("5");
        System.out.println("afters2:" + t.s2);
        System.out.println("getS2_afters2:" + t.getS2());
        System.out.println(t.s3);
        t.setS3("6");
        System.out.println("afters3:" + t.s3);
        System.out.println("getS3_afters3:" + t.getS3());
    }
}
