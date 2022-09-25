
package com.invoice.model;

import com.invoice.view.InvoiceFrame;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ahmed Hamouda
 */
public class InvHeaderTable extends AbstractTableModel{
    
    private ArrayList<InvHeader> invArray;
    private String[] attributes = {"ID","Date","Customer Name","Total"};

    public InvHeaderTable(ArrayList<InvHeader> invoicesArray) {
        this.invArray = invoicesArray;
    }
    
    
    @Override
    public int getRowCount() {
        return invArray.size();
    }

    @Override
    public int getColumnCount() {
        return attributes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvHeader inv = invArray.get(rowIndex);
        switch(columnIndex){
            case 0: 
                return inv.getId();
            case 1: 
                return InvoiceFrame.invDateFormat.format(inv.getDate());
            case 2:
                return inv.getCst();
            case 3: 
                return inv.getInvTotal();
            
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        
        return attributes[column];
        
    }
    
    
    
}
