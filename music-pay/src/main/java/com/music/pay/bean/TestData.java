package com.music.pay.bean;

import org.junit.Test;

public class TestData {


    public void test(DataConnection dataConnection, Integer flage) {

        dataConnection.connection("test");
    }


    public static void main(String[] args) {
        TestData test = new TestData();
        test.test(str->{
            return str;
        },23);
    }
}
