package com.app.fruits;
public class Apple extends Fruit{
    public Apple(String name,double weight,String color){
        super(name, weight, color);
    }

    @Override
    public String toString(){
        return super.toString();
    }

    @Override
    public String taste(){
        return "sweet & sour";
    }

    public void jam(){
        System.out.println(getName()+" : Making Jam");
    }
}