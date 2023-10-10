package com.app.tester;

import java.util.Scanner;

import com.app.fruits.*;

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

        int size = sc.nextInt();
        System.out.println("Enter the size of the basket you want");
        Fruit[] basket = new Fruit[size];
        int counter = 0;
        boolean flag = false;

        while (!flag) {
            System.out.println("Enter you choice");
            int option = sc.nextInt();
            menuList();
            switch (option) {
                case 1:
                    boolean flag1 = false;
                    while (!flag1) {
                        subMenuList();
                        System.out.println("Enter you choice to add specific fruit in the basket");
                        int option1 = sc.nextInt();
                        switch (option1) {
                            case 1:
                                if(counter < basket.length){
                                    System.out.println("Enter NAME, WEIGHT & COLOR of the FRUIT");
                                }
                                break;
                            case 2:
                                break;
                            case 3:
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
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
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
