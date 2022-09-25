
package com.invoice.view;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author DELL
 */
public class InvLineDialog extends JDialog{
    private JTextField itemField;
    private JTextField itemCount;
    private JTextField itemPrice;
    private JLabel itemNameLabel;
    private JLabel itemCountLabel;
    private JLabel itemPriceLabel;
    private JButton okButton;
    private JButton cancelButton;
    
    public InvLineDialog(InvoiceFrame frame) {
        itemField = new JTextField(20);
        itemNameLabel = new JLabel("Item Name");
        
        itemCount = new JTextField(20);
        itemCountLabel = new JLabel("Item Count");
        
        itemPrice = new JTextField(20);
        itemPriceLabel = new JLabel("Item Price");
        
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");
        
        okButton.setActionCommand("newLineOKBtn");
        cancelButton.setActionCommand("newLineCancelBtn");
        
        okButton.addActionListener(frame.getActionListener());
        cancelButton.addActionListener(frame.getActionListener());
        setLayout(new GridLayout(4, 2));
        
        add(itemNameLabel);
        add(itemField);
        add(itemCountLabel);
        add(itemCount);
        add(itemPriceLabel);
        add(itemPrice);
        add(okButton);
        add(cancelButton);
        
        pack();
    }

    public JTextField getItemField() {
        return itemField;
    }

    public JTextField getItemCount() {
        return itemCount;
    }

    public JTextField getItemPrice() {
        return itemPrice;
    }
}
