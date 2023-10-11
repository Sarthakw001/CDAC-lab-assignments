package com.app.fruits;

/**
 * Fruit
 */
public class Fruit {

  private String name;
  private double weight;
  private String color;
  private boolean fresh;

  public Fruit(String name, double weight, String color) {
    this.color = color;
    this.weight = weight;
    this.name = name;
    this.fresh = true;
  }

  @Override
  public String toString() {
    return (
      "Name" +
      this.name +
      "\n" +
      "Color" +
      this.color +
      "\n" +
      "Weight" +
      this.weight
    );
  }

  public String getName() {
    return this.name;
  }

  public boolean isFresh() {
    return fresh;
  }

  public String getColor() {
    return this.color;
  }

  public double getWeight() {
    return this.weight;
  }

  public void setFresh(boolean fresh) {
    this.fresh = fresh;
  }

  public String taste() {
    return "No Specific taste";
  }
}
