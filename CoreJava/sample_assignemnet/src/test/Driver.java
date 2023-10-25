package test;

import core.Pen;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import core.Color;

public class Driver {
    public static boolean threeMonthsOld(Pen p){

        LocalDate d = LocalDate.now();
        int month = d.getMonthValue();

        int lmonth = p.getlistingDate().getMonthValue();

        if((month - lmonth) >= 3 ){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)){
            List <Pen> pens = new ArrayList<>();
            boolean flag = true;
            while (flag) {
                System.out.println("Menu\n" + "1 -> Add new Pen\n" + "2 -> Update stock of pen\n"
                        + "3 -> set discount for all pen which are not sold in last 3 months\n"
                        + "4 -> Remove all pen which are not sold in 9\n");
                int option = sc.nextInt();
                switch(option) {
                    case 1:
                        System.out.println("Enter name,price,color,material,stock");
                        Pen temp = new Pen(sc.next(),sc.nextDouble(),Color.valueOf(sc.next().toUpperCase()),sc.next(),sc.nextInt());
                        pens.add(temp);
                    break;
                    case 2:
                        System.out.println("Enter the name of pen");
                        String name = sc.next();
                        System.out.println("Enter the quantity of stock to update");
                        int upStock = sc.nextInt();
                        for(Pen p : pens){
                            if(p.getName().equals(name)){
                                p.updateStock(upStock);
                                break;
                            }
                        }
                    break;
                    case 3:
                        for(Pen p : pens){
                            if(threeMonthsOld(p)){
                                p.setDiscount();
                            }
                        }
                    break;
                    case 4:
                        pens.removeIf(p -> {
                            if((LocalDate.now().getMonthValue() - p.getlistingDate().getMonthValue()) >= 9)
                                return true;
                            return false;
                        });
                    break;
                    case 0:
                     flag = false;
                    break;
                    default :
                    System.out.println("Invalid Choice"); 
                    break;
                }
            }
        } catch (Exception e) {

        }
    }
}
