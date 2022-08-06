/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import BeanClasses.BookIssueBean;
import DatabaseManager.DatabaseManager;
import EnDeCoder.Decoder;
import Printing.DefaulterListPrint;
import java.awt.FileDialog;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Danish
 */
public class DefaulterListPanel extends javax.swing.JPanel {
String filename;
String fileAddress;
    /**
     * Creates new form DefaulterListPanel
     */
    public DefaulterListPanel() {
        initComponents();
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

        setBackground(new java.awt.Color(0, 102, 0));

        defaulterListLabel.setFont(new java.awt.Font("Stencil", 1, 60)); // NOI18N
        defaulterListLabel.setText("DEFAULTER LIST");

        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save_1.jpg"))); // NOI18N
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        printButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/print_1.jpg"))); // NOI18N
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        dateLabel.setText("DATE");

        toLabel.setText("TO");

        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search_1.png"))); // NOI18N
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(defaulterListLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(dateDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(toLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(toDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(630, 630, 630)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(248, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(defaulterListLabel)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(dateDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(toDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(125, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

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

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        getDefaulterList();
    }//GEN-LAST:event_searchButtonActionPerformed


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
