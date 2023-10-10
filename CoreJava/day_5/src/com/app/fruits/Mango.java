package com.app.fruits;
public class Mango extends Fruit{
    public Mango(String name,double weight,String color){
        super(name, weight, color);
    }

    @Override
    public String toString(){
        return super.toString();
    }

    @Override
    public String taste(){
        return "sweet";
    }
    
    public void pulp(){
        System.out.println(getName()+" : Creating Pulp");
    }
}