
package com.invoice.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ahmed Hamouda
 */
public class InvLineTable extends AbstractTableModel{
    
    private ArrayList<InvLine> rowsArray;
    private String[] attributes = {"ITEM","Unit Price","Count","Total"};

    public InvLineTable(ArrayList<InvLine> linesArray) {
        this.rowsArray = linesArray;
    }
    
    

    @Override
    public int getRowCount() {
        return rowsArray == null ? 0 :  rowsArray.size();
    }

    @Override
    public int getColumnCount() {
        return attributes.length;
        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowsArray == null){
            return "";
        } else{
            InvLine line = rowsArray.get(rowIndex);
        switch (columnIndex){
            case 0:
                return line.getItemName();
            case 1:
                return line.getItemPrice();
            case 2: 
                return line.getCount();
            case 3:
                return line.getRowTotal();
            default: return "";
        }
        
        }
    }

    @Override
    public String getColumnName(int column) {
        return attributes[column];
    }
    
    
    
}
