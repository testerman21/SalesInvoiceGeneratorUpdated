
package com.invoice.view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Ahmed Hamouda
 */
public class InvHeaderDialog extends JDialog {
    private JTextField customerNameField;
    private JTextField invoiceDateField;
    private JLabel customerNameLbl;
    private JLabel invoiceDateLbl;
    private JButton okButton;
    private JButton cancelButton;

    public InvHeaderDialog(InvoiceFrame frame) {
        customerNameLbl = new JLabel("Customer Name:");
        customerNameField = new JTextField(20);
        invoiceDateLbl = new JLabel("Invoice Date:");
        invoiceDateField = new JTextField(20);
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");
        
        okButton.setActionCommand("newInvoiceOKBtn");
        cancelButton.setActionCommand("newInvoiceCancelBtn");
        
        okButton.addActionListener(frame.getActionListener());
        cancelButton.addActionListener(frame.getActionListener());
        setLayout(new GridLayout(3, 2));
        
        add(invoiceDateLbl);
        add(invoiceDateField);
        add(customerNameLbl);
        add(customerNameField);
        add(okButton);
        add(cancelButton);
        
        pack();
        
    }

    public JTextField getCustomerNameField() {
        return customerNameField;
    }

    public JTextField getInvoiceDateField() {
        return invoiceDateField;
    }
    
}
