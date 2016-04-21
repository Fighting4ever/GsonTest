package com.example.fighting4ever.gsontest;

/**
 * Created by Fighting4Ever on 2016/4/21.
 */
public class Car {
    private String color;
    private String brand;
    public Car(String brand, String color){
        this.brand = brand;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car: color is " + color
                +", brand is " + brand;
    }
}
