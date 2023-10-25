package core;

import java.time.LocalDate;

public class Pen {
    private static int uniqueId;
    private String name;
    private double price;
    private Color penColor;
    private String material;
    private int stock;
    private LocalDate updatedDate;
    private LocalDate listingDate;

    
    public Pen(String name,double price,Color penColor,String material,int stock){
        this.name = name;
        this.price = price;
        this.penColor = penColor;
        this.material = material;
        this.stock = stock;
        this.listingDate = LocalDate.now();
        this.updatedDate = null;
    }

    public String getName(){
        return this.name;
    }

    public void updateStock(int upStock) throws PenException {
        if(this.stock >= upStock){
            this.stock = this.stock - upStock;
            this.updatedDate = LocalDate.now();
        }else{
            throw new PenException("out of range");
        }
    }

    public LocalDate getlistingDate(){
        return this.listingDate;
    }

    public void setDiscount() {
        this.price  = this.price - (this.price*20)/100;
    } 
}
