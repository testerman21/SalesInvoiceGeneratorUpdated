/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invoice.view;

import com.invoice.controller.InvoiceListener;
import com.invoice.controller.InvoiceSelectListener;
import com.invoice.model.InvHeader;
import com.invoice.model.InvHeaderTable;
import com.invoice.model.InvLine;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;


public class InvoiceFrame extends javax.swing.JFrame {

    public InvoiceFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        invoiceHeaderTable = new javax.swing.JTable();
        createNewInvoice = new javax.swing.JButton();
        deleteInvoice = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        invoiceNoLbl = new javax.swing.JLabel();
        invoiceTotalLbl = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        invoiceLineTable = new javax.swing.JTable();
        CreateLineBtn = new javax.swing.JButton();
        deleteLineBtn = new javax.swing.JButton();
        invoiceDateLbl = new javax.swing.JTextField();
        customerNameLbl = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        loadMenuItem = new javax.swing.JMenuItem();
        loadMenuItem.addActionListener(action_Listener);
        saveMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        invoiceHeaderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        invoiceHeaderTable.getSelectionModel().addListSelectionListener(invSelectListener);
        jScrollPane1.setViewportView(invoiceHeaderTable);

        createNewInvoice.setText("Create New Invoice");
        createNewInvoice.addActionListener(action_Listener);
        createNewInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createNewInvoiceActionPerformed(evt);
            }
        });

        deleteInvoice.setText("Delete Invoice");
        deleteInvoice.addActionListener(action_Listener);

        jLabel1.setText("Invoice Number :");

        jLabel2.setText("Invoice Date      :");

        jLabel3.setText("Customer Name :");

        jLabel4.setText("Invoice Total      :");

        invoiceLineTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(invoiceLineTable);

        CreateLineBtn.setText("Create New Line");
        CreateLineBtn.addActionListener(action_Listener);

        deleteLineBtn.setText("Delete Line");
        deleteLineBtn.addActionListener(action_Listener);

        jMenu1.setText("File");

        loadMenuItem.setText("Load Files");
        loadMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(loadMenuItem);

        saveMenuItem.setText("Save Files");
        saveMenuItem.addActionListener(action_Listener);
        jMenu1.add(saveMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(invoiceNoLbl)
                            .addComponent(invoiceTotalLbl)
                            .addComponent(invoiceDateLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                            .addComponent(customerNameLbl)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(createNewInvoice)
                .addGap(92, 92, 92)
                .addComponent(deleteInvoice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CreateLineBtn)
                .addGap(91, 91, 91)
                .addComponent(deleteLineBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(invoiceNoLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(invoiceDateLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(customerNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(invoiceTotalLbl))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteInvoice)
                    .addComponent(createNewInvoice)
                    .addComponent(CreateLineBtn)
                    .addComponent(deleteLineBtn))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loadMenuItemActionPerformed

    private void createNewInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createNewInvoiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createNewInvoiceActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InvoiceFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateLineBtn;
    private javax.swing.JButton createNewInvoice;
    private javax.swing.JTextField customerNameLbl;
    private javax.swing.JButton deleteInvoice;
    private javax.swing.JButton deleteLineBtn;
    private javax.swing.JTextField invoiceDateLbl;
    private javax.swing.JTable invoiceHeaderTable;
    private javax.swing.JTable invoiceLineTable;
    private javax.swing.JLabel invoiceNoLbl;
    private javax.swing.JLabel invoiceTotalLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem loadMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables
    private InvoiceListener action_Listener = new InvoiceListener(this);
    private ArrayList<InvHeader>invArray;
    private ArrayList<InvLine>rowsArray;
    private InvHeaderTable headerTable;
    public static SimpleDateFormat invDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private InvoiceSelectListener invSelectListener = new InvoiceSelectListener(this);

    public ArrayList<InvLine> getRowsArray() {
        return rowsArray;
    }

    public void setRowsArray(ArrayList<InvLine> linesArray) {
        this.rowsArray = linesArray;
    }
    
    

    public void setInvoicesArray(ArrayList<InvHeader> invoicesArray) {
        this.invArray = invoicesArray;
    }

    public ArrayList<InvHeader> getInvoicesArray() {
        return invArray;
    }
    
    
    public InvHeader getInvObject(int code){
        for (InvHeader inv:invArray){
            if (inv.getId()== code){
                return inv;
            }
        }
        return null;
    }

    public JTable getInvHeaderTable() {
        return invoiceHeaderTable;
    }

    public JTable getInvLineTable() {
        return invoiceLineTable;
    }
    

    public InvHeaderTable getHeaderTable() {
        return headerTable;
    }

    public void setHeaderTable(InvHeaderTable headerTable) {
        this.headerTable = headerTable;
    }

    public JTextField getCstNameLbl() {
        return customerNameLbl;
    }

    public JTextField getInvDateLbl() {
        return invoiceDateLbl;
    }

    public JLabel getInvIdLbl() {
        return invoiceNoLbl;
    }

    public JLabel getInvTotalLbl() {
        return invoiceTotalLbl;
    }

    public InvoiceListener getActionListener() {
        return action_Listener;
    }
    
    
}
