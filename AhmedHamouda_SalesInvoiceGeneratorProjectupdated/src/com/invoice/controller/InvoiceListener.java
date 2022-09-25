
package com.invoice.controller;

import com.invoice.model.InvHeader;
import com.invoice.model.InvHeaderTable;
import com.invoice.model.InvLine;
import com.invoice.model.InvLineTable;
import com.invoice.view.InvoiceFrame;
import com.invoice.view.InvHeaderDialog;
import com.invoice.view.InvLineDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;



public class InvoiceListener implements ActionListener{
    private InvoiceFrame invFrame;
    private InvHeaderDialog h_Dialog;
    private InvLineDialog rowDialog;
    
    public InvoiceListener(InvoiceFrame f){
        this.invFrame = f;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Load Files":
                loadFiles();
                break;
            
            case "Save Files":
                saveFiles();
                break;
                
            case "Create New Invoice":
                createInvoice();
                break;
            
            case "Delete Invoice":
                deleteInvoice();
                break;
             
            case "Create New Line":
                createLine();
                break;
                
            case "Delete Line":
                deleteLine();
                break;
                
            case "newInvoiceOKBtn":
                NewInvoiceOkBtn();
                break;
                
            case "newInvoiceCancelBtn":
                cancelNewInvoiceBtn();
                break;
            case "newLineCancelBtn" :
                cancelNewLineBtn();
                break;
                
            case "newLineOKBtn" :
                NewLineOkBtn();
                break;
        }
    }

    private void loadFiles() {
        JFileChooser fileChooser = new JFileChooser();
        
        try {
        
        int result = fileChooser.showOpenDialog(invFrame);
        if (result == JFileChooser.APPROVE_OPTION){
            File headerFile = fileChooser.getSelectedFile();
            System.out.println("headerFile is "+ headerFile);
            Path headerPath =Paths.get(headerFile.getAbsolutePath());
            System.out.println(" heder path"+headerPath);
            List<String> headerLines = Files.readAllLines(headerPath);
             
            ArrayList<InvHeader> invoiceHeaders = new ArrayList<>();
            for (String headerLine : headerLines){
                    String [] arr = headerLine.split(",");
                    String str1 = arr[0];
                    String str2 = arr[1];
                    String str3 = arr[2];
                    int code = Integer.parseInt(str1);
                    Date invoiceDate = InvoiceFrame.invDateFormat.parse(str2);
                    InvHeader header = new InvHeader(code, str3, invoiceDate);
                    invoiceHeaders.add(header);
            }
            invFrame.setInvoicesArray(invoiceHeaders);
            result = fileChooser.showOpenDialog(invFrame);
            if (result == JFileChooser.APPROVE_OPTION){
                File lineFile = fileChooser.getSelectedFile();
                Path linePath = Paths.get(lineFile.getAbsolutePath());
                List<String> lineLines = Files.readAllLines(linePath);
                ArrayList<InvLine> invoiceLines = new ArrayList<>();
                for (String lineLine:lineLines){
                    String[] arr = lineLine.split(",");
                    String str1 = arr[0]; 
                    String str2 = arr[1];  
                    String str3 = arr[2];  
                    String str4 = arr[3];  
                    int invCode = Integer.parseInt(str1);
                    double price = Double.parseDouble(str3);
                    int count = Integer.parseInt(str4);
                    InvHeader inv = invFrame.getInvObject(invCode);
                    InvLine line = new InvLine(str2, price, count, inv);
                    inv.getRows().add(line);
                }
            }
            InvHeaderTable headerTableModel = new InvHeaderTable(invoiceHeaders);
            invFrame.setHeaderTable(headerTableModel);
            invFrame.getInvHeaderTable().setModel(headerTableModel);
                       
        }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(invFrame, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(invFrame, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveFiles() {
       ArrayList<InvHeader> invoicesArr = invFrame.getInvoicesArray();
       JFileChooser fileChooser = new JFileChooser();
        try {
            int result = fileChooser.showSaveDialog(invFrame);
       if (result == JFileChooser.APPROVE_OPTION){
           File hFile = fileChooser.getSelectedFile();
           FileWriter hFileWriter = new FileWriter(hFile);
           String hString = "";
           String lString = "";
           for (InvHeader invoiceHeader : invoicesArr){
             hString += invoiceHeader.toString();
             hString += "\n";
             for (InvLine invoiceLine :invoiceHeader.getRows() ){
                 lString += invoiceLine.toString();
                 lString += "\n";
             }
           }
           hString = hString.substring(0, hString.length()-1);
           lString = lString.substring(0, lString.length()-1);
           result = fileChooser.showSaveDialog(invFrame);
           File lineFile = fileChooser.getSelectedFile();
           FileWriter lFileWriter = new FileWriter(lineFile);
           hFileWriter.write(hString);
           lFileWriter.write(lString);
           hFileWriter.close();
           lFileWriter.close();
        }
       }catch (IOException ex) {
            JOptionPane.showMessageDialog(invFrame, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
       
    }

    private void createInvoice() {
        h_Dialog = new InvHeaderDialog(invFrame);
        h_Dialog.setVisible(true);
        
    }

    private void deleteInvoice() {
        
        int selectedInvIndex = invFrame.getInvHeaderTable().getSelectedRow();
        if (selectedInvIndex != -1){
            invFrame.getInvoicesArray().remove(selectedInvIndex);
            invFrame.getHeaderTable().fireTableDataChanged();
            invFrame.getInvLineTable().setModel(new InvLineTable(null));
            invFrame.setRowsArray(null);
            invFrame.getCstNameLbl().setText("");
            invFrame.getInvIdLbl().setText("");
            invFrame.getInvTotalLbl().setText("");
            invFrame.getInvDateLbl().setText("");
            
        }
        
    }

    private void createLine() {
        rowDialog = new InvLineDialog(invFrame);
        rowDialog.setVisible(true);
        
    }

    private void deleteLine() {
     int lineIndex = invFrame.getInvLineTable().getSelectedRow();
     int invoiceIndex = invFrame.getInvHeaderTable().getSelectedRow();
     if (lineIndex != -1){
         invFrame.getRowsArray().remove(lineIndex);
         InvLineTable lineTableModel = (InvLineTable)invFrame.getInvLineTable().getModel();
         lineTableModel.fireTableDataChanged();
         invFrame.getInvTotalLbl().setText("" +invFrame.getInvoicesArray().get(invoiceIndex).getInvTotal());
         invFrame.getHeaderTable().fireTableDataChanged();
         invFrame.getInvHeaderTable().setRowSelectionInterval(invoiceIndex, invoiceIndex);
     }
        
    }
    
    
    private void cancelNewInvoiceBtn() {
        h_Dialog.setVisible(false);
        h_Dialog.dispose();
        h_Dialog = null;
        
    }
    private void NewInvoiceOkBtn() {
        h_Dialog.setVisible(false);
        
        String cstName = h_Dialog.getCustomerNameField().getText();
        String dte =h_Dialog.getInvoiceDateField().getText();
        Date date = new Date();
        try {
            date = InvoiceFrame.invDateFormat.parse(dte);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(invFrame,"parse date error , put today date","wrong date format", JOptionPane.ERROR_MESSAGE);
        }
        
        int invNum = 0;
        for (InvHeader inv: invFrame.getInvoicesArray() ){
            if (inv.getId()> invNum ) invNum = inv.getId();
        }
        invNum++;
        InvHeader invhead = new InvHeader(invNum, cstName, date);
        invFrame.getInvoicesArray().add(invhead);
        invFrame.getHeaderTable().fireTableDataChanged();
        
        
        h_Dialog.dispose();
        h_Dialog = null;
        
    }

    private void cancelNewLineBtn() {
        rowDialog.setVisible(false);
        rowDialog.dispose();
        rowDialog = null;
    }

    private void NewLineOkBtn() {
        rowDialog.setVisible(false);
        
        String name = rowDialog.getItemField().getText();
        String s1 = rowDialog.getItemCount().getText();
        String s2 = rowDialog.getItemPrice().getText();
        int count = 1;
        double price = 1;
        try {
            count = Integer.parseInt(s1);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(invFrame, "Wrong Number","Invalid Format", JOptionPane.ERROR_MESSAGE);
        }
        try {
            price = Double.parseDouble(s2);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(invFrame, "Wrong Number","Invalid Format", JOptionPane.ERROR_MESSAGE);
        }
        int selectedHeader = invFrame.getInvHeaderTable().getSelectedRow();
        if (selectedHeader != -1){
            InvHeader invHeader = invFrame.getInvoicesArray().get(selectedHeader);
            InvLine line = new InvLine(name, price, count, invHeader);
            invFrame.getRowsArray().add(line);
            InvLineTable lineTableModel = (InvLineTable)invFrame.getInvLineTable().getModel();
            lineTableModel.fireTableDataChanged();
            invFrame.getHeaderTable().fireTableDataChanged();
        }
        invFrame.getInvHeaderTable().setRowSelectionInterval(selectedHeader,selectedHeader);
        
        rowDialog.dispose();
        rowDialog = null;
    }

    
    
}
