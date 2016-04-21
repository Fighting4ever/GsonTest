package com.example.fighting4ever.gsontest;

/**
 * Created by Fighting4Ever on 2016/4/21.
 */
public class Box {
    private double weight;
    private double height;
    public Box(double weight, double height){
        this.weight = weight;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Box: brand is " + weight
                +", price is " + height;
    }
}
