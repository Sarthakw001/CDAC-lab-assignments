package com.app.fruits;
public class Orange extends Fruit{
    public Orange(String name,double weight,String color){
        super(name, weight, color);
    }

    @Override
    public String toString(){
        return super.toString();
    }

    @Override
    public String taste(){
        return "sour";
    }

    public void juice(){
        System.out.println(getName()+" : Extracting Juice");
    }
}