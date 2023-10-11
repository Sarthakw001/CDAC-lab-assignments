package com.app.tester;

import com.app.fruits.*;
import java.util.Scanner;

public class FruitBasket {

  static void menuList() {
    System.out.println("Menu");
    System.out.println();
    System.out.println("1. Insert fruit in basket");
    System.out.println("2. Display names of all fruits in basket");
    System.out.println("3. Display name,weight,color of all fruits in basket");
    System.out.println("4. Mark specific fruit as not fresh");
    System.out.println("5. Mark all sour fruit as stale i.e.  NOT FRESH");
    System.out.println("6. Invoke fruit specific speciality");
    System.out.println("0. Exit from main menu");
  }

  static void subMenuList() {
    System.out.println();
    System.out.println("1. Add a Mango");
    System.out.println("2. Add a Apple");
    System.out.println("3. Add a Orange");
    System.out.println("0. Exit from Submenu");
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the size of the basket you want");
    int size = sc.nextInt();
    Fruit[] basket = new Fruit[size];
    int counter = 0;
    boolean flag = false;

    while (!flag) {
      menuList();
      System.out.println("Enter you choice");
      int option = sc.nextInt();
      switch (option) {
        case 1:
          boolean flag1 = false;
          while (!flag1) {
            subMenuList();
            System.out.println(
              "Enter you choice to add specific fruit in the basket"
            );
            int option1 = sc.nextInt();
            switch (option1) {
              case 1:
                if (counter < basket.length) {
                  System.out.println("Enter NAME, WEIGHT & COLOR of the mango");
                  basket[counter] =
                    new Mango(sc.next(), sc.nextDouble(), sc.next());
                  counter++;
                }
                break;
              case 2:
                if (counter < basket.length) {
                  System.out.println("Enter NAME, WEIGHT & COLOR of the Apple");
                  basket[counter] =
                    new Apple(sc.next(), sc.nextDouble(), sc.next());
                  counter++;
                }
                break;
              case 3:
                if (counter < basket.length) {
                  System.out.println(
                    "Enter NAME, WEIGHT & COLOR of the Orange"
                  );
                  basket[counter] =
                    new Orange(sc.next(), sc.nextDouble(), sc.next());
                  counter++;
                }
                break;
              case 0:
                flag1 = true;
                break;
              default:
                System.out.println("Invalid Choice");
                break;
            }
          }
          break;
        case 2:
          for (Fruit b : basket) {
            if (b != null) {
              System.out.println(b.getName());
            } else {
              System.out.println("Fruit not available in basket");
            }
          }
          break;
        case 3:
          for (Fruit b : basket) {
           if(b!=null){
            if (b.isFresh()) {
              System.out.println(b.toString());
            } else {
              System.out.println(b.getName() + " is not fresh");
            }
           }
          }
          break;
        case 4:
          System.out.println(
            "Enter the indices of the fruit in the basket to be marked as stale - NOT FRESH"
          );
          int idx = sc.nextInt() - 1;
          if (idx < counter) {
            basket[idx].setFresh(false);
          } else {
            System.out.println("Fruit is not present in the basket");
          }
          break;
        case 5:
          String taste = "sour";
          for (int i = 0; i < counter; i++) {
            if (taste.equals(basket[i].taste())) {
              basket[i].setFresh(false);
            }
          }
          break;
        case 6:
          System.out.println(
            "Enter the indices of the fruit to be called for specific speciality"
          );
          int idx1 = sc.nextInt() - 1;
          Fruit f = basket[idx1];
          if (idx1 < counter) {
            if (f instanceof Mango) {
              ((Mango)basket[idx1]).pulp();
            } else if (f instanceof Apple) {
              ((Apple)basket[idx1]).jam();
            } else{
              ((Orange)basket[idx1]).juice();
            }
          } else {
            System.out.println("Fruit is not present in the basket");
          }
          break;
        case 0:
          flag = true;
          break;
        default:
          System.out.println("Invalid Choice");
          break;
      }
    }
    sc.close();
  }
}
