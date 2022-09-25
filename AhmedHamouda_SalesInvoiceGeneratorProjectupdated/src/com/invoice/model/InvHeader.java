
package com.invoice.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class InvHeader {
    private int id;
    private String cst;
    private Date date;
    private ArrayList<InvLine> rows;
    private DateFormat invDateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public InvHeader() {
    }

    public InvHeader(int no, String customer, Date invDate) {
        this.id = no;
        this.cst = customer;
        this.date = invDate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCst() {
        return cst;
    }

    public void setCst(String cst) {
        this.cst = cst;
    }

    public ArrayList<InvLine> getRows() {
        if (rows == null){
            rows = new ArrayList<>();
        }
        return rows;
    }

    public void setRows(ArrayList<InvLine> rows) {
        this.rows = rows;
    }
    
    public double getInvTotal(){
        double total = 0.0;
        for (int i = 0 ; i<getRows().size();i++){
            total +=getRows().get(i).getRowTotal();
        }
        return total;
    }

    @Override
    public String toString() {
        return  id + "," +  invDateFormat.format(date) + "," + cst  ;
    }
    
    
}
