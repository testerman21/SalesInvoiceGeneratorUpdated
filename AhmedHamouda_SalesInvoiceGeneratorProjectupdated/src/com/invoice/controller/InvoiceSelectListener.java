
package com.invoice.controller;

import com.invoice.model.InvHeader;
import com.invoice.model.InvLine;
import com.invoice.model.InvLineTable;
import com.invoice.view.InvoiceFrame;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Ahmed Hamouda
 */
public class InvoiceSelectListener implements ListSelectionListener{
    
    private InvoiceFrame frame ;

    public InvoiceSelectListener(InvoiceFrame frame) {
        this.frame = frame;
    }
    

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectInvoiceIndex = frame.getInvHeaderTable().getSelectedRow();
        System.out.println("Invoice Selected : " + selectInvoiceIndex);
        if (selectInvoiceIndex != -1){
            
        InvHeader selectedInvoice = frame.getInvoicesArray().get(selectInvoiceIndex);
        ArrayList<InvLine> lines = selectedInvoice.getRows();
        InvLineTable lineTableModel = new InvLineTable(lines);
        frame.setRowsArray(lines);
        frame.getInvLineTable().setModel(lineTableModel);
        frame.getCstNameLbl().setText(selectedInvoice.getCst());
        frame.getInvIdLbl().setText("" +selectedInvoice.getId());
        frame.getInvTotalLbl().setText(""+ selectedInvoice.getInvTotal());
        frame.getInvDateLbl().setText( InvoiceFrame.invDateFormat.format(selectedInvoice.getDate()));
        }
    }
 
    
}
