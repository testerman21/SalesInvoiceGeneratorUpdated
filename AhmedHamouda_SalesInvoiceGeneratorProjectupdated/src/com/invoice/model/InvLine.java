
package com.invoice.model;


public class InvLine {
    private String itemName;
    private double itemPrice;
    private int count;
    private InvHeader header;

    public InvLine() {
    }

    public InvLine(String item, double price, int count, InvHeader header) {
        this.itemName = item;
        this.itemPrice = price;
        this.count = count;
        this.header = header;
    }

    public InvHeader getHeader() {
        return header;
    }

    public void setHeader(InvHeader header) {
        this.header = header;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    public double getRowTotal(){
        return itemPrice * count;
    }

    @Override
    public String toString() {
        return header.getId() + "," + itemName + " , " + itemPrice + "," + count;
    }

    
    
}
