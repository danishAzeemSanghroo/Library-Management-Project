/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import BeanClasses.BatchBean;
import BeanClasses.BookIssueBean;
import BeanClasses.DefaulterBean;
import DatabaseManager.DatabaseManager;
import EnDeCoder.Decoder;
import Printing.DefaulterListPrint;
import java.awt.FileDialog;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Danish
 */
public class DefaulterListFrame extends javax.swing.JFrame {
String filename;
String fileAddress;
    /**
     * Creates new form DefaulterListFrame
     */
    public DefaulterListFrame() {
        initComponents();

       //getDefaulterList();
    }
    
private  void getDefaulterList(){
 
        
    String dateOfIssue1=Decoder.getDateFormat(dateDateChooser.getDate());
    String dateOfIssue2=Decoder.getDateFormat(toDateChooser.getDate());
          
    
    try{
        Vector v = DatabaseManager.getDefaulterList(dateOfIssue1,dateOfIssue2);

//        Vector cols=new Vector();
      // System.out.println("Vectors="+v);
//        cols.addElement("Roll NO");
//        cols.addElement("Name");
//        cols.addElement("Father's Name");
//        cols.addElement("Surname");
//        cols.addElement("Book Title");
//        cols.addElement("Author");
//        cols.addElement("Publisher");
//        cols.addElement("Price");
//
//        
// 
//          
//        //display in JOptionPane  
//        JTable table=new JTable(v,cols);
//        JScrollPane scroll=new JScrollPane(table);
//        JOptionPane.showMessageDialog(null,scroll);
        
        //disply in JTable
        DefaultTableModel model=(DefaultTableModel)defaulterListTable.getModel();
                    clear();
                Vector vector =null;
               for(int i=0; i<v.size(); i++){
                   BookIssueBean bean= (BookIssueBean)v.elementAt(i);
//                   Object[] obj={bean.getRollNo(), bean.getName(),bean.getFname(),bean.getSurname(),bean.getBookTitle(),bean.getAuthor(),bean.getPublisher(),bean.getPrice()};
                    vector = new Vector();
                     vector.addElement(bean.getRollNo());
                     vector.addElement(bean.getName());
                     vector.addElement(bean.getFname());
                     vector.addElement(bean.getSurname());
                     vector.addElement(bean.getBookTitle());
                     vector.addElement(bean.getAuthor());
                     vector.addElement(bean.getPublisher());
                     vector.addElement(bean.getPrice());
                     
                     model.addRow(vector);
                     
                }   
               
               
               

// public void saveAsFile(){
//        //JTable table=new JTable();
//        FileDialog fd=new FileDialog(gui,"Save",FileDialog.SAVE);
//        fd.setVisible(true);
//        
//        
//        if(fd.getFile()!=null){
//            filename=fd.getFile();
//            fileAddress=fd.getDirectory();
//            gui.setTitle(filename);
//        }
//        try{
//            String path =fileAddress+filename+".cvs";
//            FileOutputStream f=new FileOutputStream(path);
//            PrintStream file=new PrintStream(f);
//            file.println(gui.TextArea.getText());
//           //file.println(table);
//            f.close();
//           }catch(Exception e){System.out.println(e.getStackTrace());}
//    }               
//====================================================================        
//        Object[] obj=new Object[8];
//        for(int i=0;i<v.size();i++){
//            obj[0]=v.elementAt(i);
//            obj[1]=v.elementAt(i);
//            obj[2]=v.elementAt(i);
//            obj[3]=v.elementAt(i);
//            obj[4]=v.elementAt(i);
//            obj[5]=v.elementAt(i);
//            obj[6]=v.elementAt(i);
//            obj[7]=v.elementAt(i);
//        }
 //  ================================================================     
     //  defaulterListTable.removeAllItems();
//		for(int i=0; i<v.size(); i++){
//			defaulterListTable.addItem(v.elementAt(i));
//                }
 //=================================================================       
            

    }catch(Exception e)
    {
        
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
    }    
    
}
//private void save(){
//        //JTable table=new JTable();
//        FileDialog fd=new FileDialog(new DefaulterListFrame(),"Save",FileDialog.SAVE);
//        fd.setVisible(true);
//        fd.show();
//        
//        if(fd.getFile()!=null){
//           filename = fd.getFile();
//           fileAddress = fd.getDirectory();
//            //setTitle(filename);
//        }
//        try{
//            String path =fileAddress+filename+".cvs";
//            FileOutputStream f=new FileOutputStream(path);
//            PrintStream file=new PrintStream(f);
//       Vector cols=new Vector();
//  
//        cols.addElement("Roll NO");
//        cols.addElement("Name");
//        cols.addElement("Father's Name");
//        cols.addElement("Surname");
//        cols.addElement("Book Title");
//        cols.addElement("Author");
//        cols.addElement("Publisher");
//        cols.addElement("Price");
//        file.println(cols);
//        DefaultTableModel model=(DefaultTableModel)defaulterListTable.getModel();
//                    clear();
//             
//               for(int i=0; i<cols.size(); i++){
//                   
//                  file.println(i+" , "+i*i+" , "+i*2+" , "+i*3+" , "+i*4+" , "+i*5+" , "+i*6+" , "+i*7+" , "+i*8);
//                   
//                }  
//               
//            f.close();
//           }catch(Exception e){System.out.println(e.getStackTrace());}
//    } 

private void clear(){
    DefaultTableModel model=(DefaultTableModel)defaulterListTable.getModel();
    while(model.getRowCount()>0){
        for(int i=0;i<model.getRowCount();++i){
            model.removeRow(i);
        }
    }
}
private String takeDataFromTable(){
            DefaultTableModel model=(DefaultTableModel)defaulterListTable.getModel();
            Vector data=model.getDataVector();
            String temp="";
            String rows="";
            
            for(int i=0;i<data.size();i++){
                temp+=data.elementAt(i);
                String brick=temp.replace("[", "");
                rows=brick.replace("]", "\n");
            }
            return rows;
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        defaulterListLabel = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        printButton = new javax.swing.JButton();
        dateLabel = new javax.swing.JLabel();
        toLabel = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        defaulterListTable = new javax.swing.JTable();
        dateDateChooser = new com.toedter.calendar.JDateChooser();
        toDateChooser = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        defaulterListLabel.setFont(new java.awt.Font("Stencil", 1, 60)); // NOI18N
        defaulterListLabel.setText("DEFAULTER LIST");
        getContentPane().add(defaulterListLabel);
        defaulterListLabel.setBounds(280, 20, 550, 61);

        saveButton.setText("SAVE");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        getContentPane().add(saveButton);
        saveButton.setBounds(650, 730, 90, 40);

        printButton.setText("PRINT");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });
        getContentPane().add(printButton);
        printButton.setBounds(780, 730, 100, 40);

        dateLabel.setText("DATE");
        getContentPane().add(dateLabel);
        dateLabel.setBounds(20, 90, 50, 40);

        toLabel.setText("TO");
        getContentPane().add(toLabel);
        toLabel.setBounds(260, 90, 30, 40);

        searchButton.setText("SEARCH");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        getContentPane().add(searchButton);
        searchButton.setBounds(470, 90, 110, 40);

        defaulterListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ROLL NO", "NAME", "FATHER'S NAME", "SURNAME", "BOOK TITLE", "AUTHOR", "PUBLISHER", "PRICE"
            }
        ));
        jScrollPane2.setViewportView(defaulterListTable);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(20, 150, 1100, 560);
        getContentPane().add(dateDateChooser);
        dateDateChooser.setBounds(80, 100, 150, 26);
        getContentPane().add(toDateChooser);
        toDateChooser.setBounds(300, 100, 140, 26);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        getDefaulterList();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
         FileDialog fd=new FileDialog(new DefaulterListFrame(),"Save",FileDialog.SAVE);
        fd.setVisible(true);
       // fd.show();
        
        if(fd.getFile()!=null){
           filename = fd.getFile();
           fileAddress = fd.getDirectory();
            //setTitle(filename);
        }
        try{
            String path =fileAddress+filename+".csv";
            FileOutputStream f=new FileOutputStream(path);
            PrintStream file=new PrintStream(f);
       Vector cols=new Vector();
  
        cols.addElement("Roll NO");
        cols.addElement("Name");
        cols.addElement("Father's Name");
        cols.addElement("Surname");
        cols.addElement("Book Title");
        cols.addElement("Author");
        cols.addElement("Publisher");
        cols.addElement("Price");
        file.println(cols);
        file.println(takeDataFromTable());
//        DefaultTableModel model=(DefaultTableModel)defaulterListTable.getModel();
//                 Vector data =  model.getDataVector();
//             
//               for(int i=0; i<data.size(); i++){
//                   
//                 // file.println(i+" , "+i*i+" , "+i*2+" , "+i*3+" , "+i*4+" , "+i*5+" , "+i*6+" , "+i*7+" , "+i*8);
//                   file.println(data.elementAt(i));
//                }  
//               
            f.close();
           }catch(Exception e){System.out.println(e.getStackTrace());}
      
         
    }//GEN-LAST:event_saveButtonActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
            //DefaulterListWork
//       try{
//           
//        String dateOfIssue1=dateTextField.getText();
//        String dateOfIssue2=toTextField.getText();
//        Vector v = DatabaseManager.getDefaulterList(dateOfIssue1,dateOfIssue2);
//        new DefaulterListPrint(v);
//        
//       }catch(Exception e){
//           e.printStackTrace();
//       }
        //notWorking
//        try{
//         Vector v1=DatabaseManager.getBatch();
//         Vector tempVector = new Vector();
//         for(int i=0;i<v1.size();i++){
//            BatchBean bean=(BatchBean)v1.elementAt(i);
//              if(bean==null)return;
//              
//             Vector v = DatabaseManager.getStudent( bean.getBatchId() );
//             tempVector = v;
//	   System.out.println(v);
//              
//         }
//	  new DefaulterListPrint(tempVector);
//            
//                
//
//            
//	}catch(Exception e){
//		e.printStackTrace();
//		javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
//	} 
  
       try{
           
        
        Vector v = DatabaseManager.getStudent();
        new DefaulterListPrint(v);
        
       }catch(Exception e){
           e.printStackTrace();
       }        
    }//GEN-LAST:event_printButtonActionPerformed

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
            java.util.logging.Logger.getLogger(DefaulterListFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DefaulterListFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DefaulterListFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DefaulterListFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DefaulterListFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dateDateChooser;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel defaulterListLabel;
    private javax.swing.JTable defaulterListTable;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton printButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton searchButton;
    private com.toedter.calendar.JDateChooser toDateChooser;
    private javax.swing.JLabel toLabel;
    // End of variables declaration//GEN-END:variables




}
