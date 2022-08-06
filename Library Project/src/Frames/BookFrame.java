/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import BeanClasses.BookBean;
import BeanClasses.DepartmentBean;
import BeanClasses.FacultyBean;
import DatabaseManager.DatabaseManager;
import EnDeCoder.Decoder;
import EnDeCoder.Encoder;
import java.util.Vector;

/**
 *
 * @author Danish
 */
public class BookFrame extends javax.swing.JFrame {

    /**
     * Creates new form BookFrame
     */
    public BookFrame() {
        initComponents();
        getFaculty();
    }
         private void getFaculty(){
	try{
		Vector v=DatabaseManager.getFaculty();
		facultyComboBox.removeAllItems();
		for(int i=0; i<v.size(); i++)
			facultyComboBox.addItem(v.elementAt(i));

	}catch(Exception e){
		e.printStackTrace();
		javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
	}
}//end method 
  private void getDepartment(){
	FacultyBean bean=(FacultyBean)facultyComboBox.getSelectedItem();
	if(bean==null)return;

	try{
	          Vector v=DatabaseManager.getDepartment( bean.getFacId() );
	      deptComboBox.removeAllItems();
		for(int i=0; i<v.size(); i++)
			deptComboBox.addItem(v.elementAt(i));	
	}catch(Exception e){
		e.printStackTrace();
		javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
	}
}
private void getBook(){
	DepartmentBean bean=(DepartmentBean)deptComboBox.getSelectedItem();
	if(bean==null)return;

	try{
	          Vector v=DatabaseManager.getBook( bean.getDeptId() );
	           booksList.setListData(v); 		
	}catch(Exception e){
		e.printStackTrace();
		javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
	}
}
private void addBook(){
    DepartmentBean deptBean = (DepartmentBean)deptComboBox.getSelectedItem();
    if(deptBean==null)return;
    String bookTitle = bookTitleTextField.getText();
    String author = authorTextField.getText();
    String publisher = publisherTextField.getText();
    String edition = editionTextField.getText();
    int yearOfPublishing = Integer.parseInt(yearOfPublishingTextField.getText());
    int quantity = Integer.parseInt(quantityTextField.getText());
    String isbn = isbnTextField.getText();
    String accessNo = accessNoTextField.getText();
    int price = Integer.parseInt(priceTextField.getText());
     String dateOfPurchase=Decoder.getDateFormat(dateOfPurchaseDateChooser.getDate());
    String purchaseFrom = purchaseFromTextField.getText();
    String remarks = remarksTextArea.getText();
    try{
        int rows = DatabaseManager.addBook(deptBean.getDeptId(),bookTitle,author,publisher,edition,yearOfPublishing,quantity,isbn,accessNo,price,dateOfPurchase,purchaseFrom,remarks);
        if(rows>=0){
            javax.swing.JOptionPane.showMessageDialog(this,rows+" Records Inserted.");
            clear();
            getBook();
           }
    }catch(Exception e){
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this,"Error"+e.getMessage());
    }
}
private void deleteBook(){
    int rows = 0;
    Object[] obj = (Object[])booksList.getSelectedValues();
    for(int i=0;i<obj.length;i++){
        BookBean bkBean = (BookBean)obj[i];
        try{
            rows += DatabaseManager.deleteBook(bkBean.getBookId());
        }catch(Exception e){
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this,"Error"+ e.getMessage());
        }
    }
    if(rows>=0){
        javax.swing.JOptionPane.showMessageDialog(this, rows+" Record Removed");
        getBook();
        clear();
    }
}
private void updateBook(){
    String bookTitle = bookTitleTextField.getText();
    String author = authorTextField.getText();
    String publisher = publisherTextField.getText();
    String edition = editionTextField.getText();
    int yearOfPublishing = Integer.parseInt(yearOfPublishingTextField.getText());
    int quantity = Integer.parseInt(quantityTextField.getText());
    String isbn = isbnTextField.getText();
    String accessNo = accessNoTextField.getText();
    int price = Integer.parseInt(priceTextField.getText());
      String dateOfPurchase=Decoder.getDateFormat(dateOfPurchaseDateChooser.getDate());
    String purchaseFrom = purchaseFromTextField.getText();
    String remarks = remarksTextArea.getText();    
    
    int rows = 0;
    Object[] obj = (Object[])booksList.getSelectedValues();
    for(int i=0;i<obj.length;i++){
        BookBean bkBean=(BookBean)obj[i];
        try{
            rows += DatabaseManager.updateBook(bkBean.getBookId(),bookTitle,author,publisher,edition,yearOfPublishing,quantity,isbn,accessNo,price,dateOfPurchase,purchaseFrom,remarks);
        }catch(Exception e){e.printStackTrace();}
    }
    	if(rows>=0){
	    javax.swing.JOptionPane.showMessageDialog(this,rows+" Record Modified.");
	getBook();
	    clear();
        	} 
}

private void clear(){}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bookLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        deptLabel = new javax.swing.JLabel();
        bookIdLabel = new javax.swing.JLabel();
        bookTitleLabel = new javax.swing.JLabel();
        authorLabel = new javax.swing.JLabel();
        publisherLabel = new javax.swing.JLabel();
        editionLabel = new javax.swing.JLabel();
        yearOfPublishingLabel = new javax.swing.JLabel();
        quantityLabel = new javax.swing.JLabel();
        isbnLabel = new javax.swing.JLabel();
        accessNoLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        dateOfPurchaseLabel = new javax.swing.JLabel();
        purchaseFromLabel = new javax.swing.JLabel();
        remarksLabel = new javax.swing.JLabel();
        facultyComboBox = new javax.swing.JComboBox();
        deptComboBox = new javax.swing.JComboBox();
        bookIdTextField = new javax.swing.JTextField();
        bookTitleTextField = new javax.swing.JTextField();
        authorTextField = new javax.swing.JTextField();
        publisherTextField = new javax.swing.JTextField();
        editionTextField = new javax.swing.JTextField();
        yearOfPublishingTextField = new javax.swing.JTextField();
        quantityTextField = new javax.swing.JTextField();
        isbnTextField = new javax.swing.JTextField();
        accessNoTextField = new javax.swing.JTextField();
        priceTextField = new javax.swing.JTextField();
        purchaseFromTextField = new javax.swing.JTextField();
        bookListLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        booksList = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        dateOfPurchaseDateChooser = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        bookLabel.setFont(new java.awt.Font("Stencil Std", 1, 60)); // NOI18N
        bookLabel.setText("BOOK");
        getContentPane().add(bookLabel);
        bookLabel.setBounds(600, 30, 200, 50);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("FACULTY");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(178, 130, 80, 40);

        deptLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        deptLabel.setText("DEPARTMENT");
        getContentPane().add(deptLabel);
        deptLabel.setBounds(150, 190, 120, 40);

        bookIdLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        bookIdLabel.setText("BOOK ID");
        getContentPane().add(bookIdLabel);
        bookIdLabel.setBounds(180, 260, 80, 40);

        bookTitleLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        bookTitleLabel.setText("BOOK TITLE");
        getContentPane().add(bookTitleLabel);
        bookTitleLabel.setBounds(520, 260, 100, 40);

        authorLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        authorLabel.setText("AUTHOR");
        getContentPane().add(authorLabel);
        authorLabel.setBounds(830, 260, 80, 40);

        publisherLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        publisherLabel.setText("PUBLISHER");
        getContentPane().add(publisherLabel);
        publisherLabel.setBounds(170, 330, 90, 40);

        editionLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        editionLabel.setText("EDITION");
        getContentPane().add(editionLabel);
        editionLabel.setBounds(530, 330, 80, 40);

        yearOfPublishingLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        yearOfPublishingLabel.setText("YEAR OF PUBLISHING");
        getContentPane().add(yearOfPublishingLabel);
        yearOfPublishingLabel.setBounds(820, 340, 180, 40);

        quantityLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        quantityLabel.setText("QUANTITY");
        getContentPane().add(quantityLabel);
        quantityLabel.setBounds(170, 400, 100, 40);

        isbnLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        isbnLabel.setText("ISBN");
        getContentPane().add(isbnLabel);
        isbnLabel.setBounds(540, 400, 50, 40);

        accessNoLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        accessNoLabel.setText("ACCESS NO");
        getContentPane().add(accessNoLabel);
        accessNoLabel.setBounds(820, 410, 100, 40);

        priceLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        priceLabel.setText("PRICE");
        getContentPane().add(priceLabel);
        priceLabel.setBounds(200, 470, 60, 40);

        dateOfPurchaseLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        dateOfPurchaseLabel.setText("DATE OF PURCHASE");
        getContentPane().add(dateOfPurchaseLabel);
        dateOfPurchaseLabel.setBounds(490, 470, 166, 40);

        purchaseFromLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        purchaseFromLabel.setText("PURCHASE FROM");
        getContentPane().add(purchaseFromLabel);
        purchaseFromLabel.setBounds(820, 470, 150, 40);

        remarksLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        remarksLabel.setText("REMARKS");
        getContentPane().add(remarksLabel);
        remarksLabel.setBounds(170, 530, 90, 40);

        facultyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facultyComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(facultyComboBox);
        facultyComboBox.setBounds(290, 120, 820, 50);

        deptComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deptComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(deptComboBox);
        deptComboBox.setBounds(290, 180, 820, 50);
        getContentPane().add(bookIdTextField);
        bookIdTextField.setBounds(290, 250, 220, 50);
        getContentPane().add(bookTitleTextField);
        bookTitleTextField.setBounds(620, 250, 200, 50);
        getContentPane().add(authorTextField);
        authorTextField.setBounds(910, 250, 200, 50);
        getContentPane().add(publisherTextField);
        publisherTextField.setBounds(290, 320, 220, 50);
        getContentPane().add(editionTextField);
        editionTextField.setBounds(620, 330, 200, 50);
        getContentPane().add(yearOfPublishingTextField);
        yearOfPublishingTextField.setBounds(1000, 330, 110, 50);
        getContentPane().add(quantityTextField);
        quantityTextField.setBounds(290, 390, 220, 50);
        getContentPane().add(isbnTextField);
        isbnTextField.setBounds(620, 400, 200, 50);
        getContentPane().add(accessNoTextField);
        accessNoTextField.setBounds(920, 400, 190, 50);
        getContentPane().add(priceTextField);
        priceTextField.setBounds(290, 460, 180, 50);
        getContentPane().add(purchaseFromTextField);
        purchaseFromTextField.setBounds(960, 460, 150, 50);

        bookListLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        bookListLabel.setText("BOOKS");
        getContentPane().add(bookListLabel);
        bookListLabel.setBounds(1130, 110, 80, 40);

        booksList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                booksListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(booksList);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(1140, 150, 280, 510);

        remarksTextArea.setColumns(20);
        remarksTextArea.setRows(5);
        jScrollPane2.setViewportView(remarksTextArea);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(290, 530, 820, 130);

        addButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton);
        addButton.setBounds(290, 680, 170, 50);

        updateButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton);
        updateButton.setBounds(490, 680, 200, 50);

        clearButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton);
        clearButton.setBounds(710, 680, 190, 50);

        backButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton);
        backButton.setBounds(930, 680, 180, 50);

        deleteButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton);
        deleteButton.setBounds(1140, 680, 280, 50);
        getContentPane().add(dateOfPurchaseDateChooser);
        dateOfPurchaseDateChooser.setBounds(670, 470, 150, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deptComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deptComboBoxActionPerformed
       getBook();
    }//GEN-LAST:event_deptComboBoxActionPerformed

    private void facultyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facultyComboBoxActionPerformed
       getDepartment(); 
    }//GEN-LAST:event_facultyComboBoxActionPerformed

    private void booksListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_booksListValueChanged
        BookBean bkBean = (BookBean)booksList.getSelectedValue();
        if(bkBean==null)return;
        
        bookIdTextField.setText(""+bkBean.getBookId());
        bookTitleTextField.setText(bkBean.getBookTitle());
        authorTextField.setText(bkBean.getAuthor());
        publisherTextField.setText(bkBean.getPublisher());
        editionTextField.setText(bkBean.getEdition());
        yearOfPublishingTextField.setText(""+bkBean.getYearOfPublishing());
        quantityTextField.setText(""+bkBean.getQuantity());
        isbnTextField.setText(bkBean.getIsbn());
        accessNoTextField.setText(bkBean.getAccessNo());
        priceTextField.setText(""+bkBean.getPrice());
        //String date= Decoder.getDateFormat(bkBean.getDateOfPurchase());
        dateOfPurchaseDateChooser.setDate( bkBean.getDateOfPurchase() );
       purchaseFromTextField.setText(bkBean.getPurchaseFrom());
        remarksTextArea.setText(bkBean.getRemarks());
    }//GEN-LAST:event_booksListValueChanged

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        addBook();
    }//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        updateBook();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
       clear();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        
    }//GEN-LAST:event_backButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        deleteBook();
    }//GEN-LAST:event_deleteButtonActionPerformed
    
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
            java.util.logging.Logger.getLogger(BookFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accessNoLabel;
    private javax.swing.JTextField accessNoTextField;
    private javax.swing.JButton addButton;
    private javax.swing.JLabel authorLabel;
    private javax.swing.JTextField authorTextField;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel bookIdLabel;
    private javax.swing.JTextField bookIdTextField;
    private javax.swing.JLabel bookLabel;
    private javax.swing.JLabel bookListLabel;
    private javax.swing.JLabel bookTitleLabel;
    private javax.swing.JTextField bookTitleTextField;
    private javax.swing.JList booksList;
    private javax.swing.JButton clearButton;
    private com.toedter.calendar.JDateChooser dateOfPurchaseDateChooser;
    private javax.swing.JLabel dateOfPurchaseLabel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JComboBox deptComboBox;
    private javax.swing.JLabel deptLabel;
    private javax.swing.JLabel editionLabel;
    private javax.swing.JTextField editionTextField;
    private javax.swing.JComboBox facultyComboBox;
    private javax.swing.JLabel isbnLabel;
    private javax.swing.JTextField isbnTextField;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JTextField priceTextField;
    private javax.swing.JLabel publisherLabel;
    private javax.swing.JTextField publisherTextField;
    private javax.swing.JLabel purchaseFromLabel;
    private javax.swing.JTextField purchaseFromTextField;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JTextField quantityTextField;
    private javax.swing.JLabel remarksLabel;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JButton updateButton;
    private javax.swing.JLabel yearOfPublishingLabel;
    private javax.swing.JTextField yearOfPublishingTextField;
    // End of variables declaration//GEN-END:variables
}
