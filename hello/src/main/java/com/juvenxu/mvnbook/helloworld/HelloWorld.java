package com.juvenxu.mvnbook.helloworld;

/**
 * Created with IntelliJ IDEA.
 * User: keer
 * Date: 13-4-3
 * Time: 下午9:21
 */
public class HelloWorld {
    public String sayHello() {
        return "Hello Maven";
    }

    public static void main(String[] args) {
        System.out.println(new HelloWorld().sayHello());
    }
}
