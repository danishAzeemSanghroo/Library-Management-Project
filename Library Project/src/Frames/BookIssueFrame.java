/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import BeanClasses.BatchBean;
import BeanClasses.BookBean;
import BeanClasses.BookIssueBean;
import BeanClasses.DepartmentBean;
import BeanClasses.FacultyBean;
import BeanClasses.ProgramBean;
import BeanClasses.StudentBean;
import DatabaseManager.DatabaseManager;
import EnDeCoder.Decoder;
import java.util.Vector;

/**
 *
 * @author Danish
 */
public class BookIssueFrame extends javax.swing.JFrame {

    /**
     * Creates new form BookIssueFrame
     */
    public BookIssueFrame() {
        initComponents();
        getFaculty();
        getStdFaculty();
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
         private void getStdFaculty(){
	try{
		Vector v=DatabaseManager.getFaculty();
		stdFacultyComboBox.removeAllItems();
		for(int i=0; i<v.size(); i++)
			stdFacultyComboBox.addItem(v.elementAt(i));

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
 private void getStdDepartment(){
	FacultyBean bean=(FacultyBean)stdFacultyComboBox.getSelectedItem();
	if(bean==null)return;

	try{
	          Vector v=DatabaseManager.getDepartment( bean.getFacId() );
	      stdDeptComboBox.removeAllItems();
		for(int i=0; i<v.size(); i++)
			stdDeptComboBox.addItem(v.elementAt(i));	
	}catch(Exception e){
		e.printStackTrace();
		javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
	}
}  
  private void getStdProgram(){
	DepartmentBean bean=(DepartmentBean)stdDeptComboBox.getSelectedItem();
	if(bean==null)return;

	try{
	          Vector v=DatabaseManager.getProgram( bean.getDeptId() );
	          stdProgComboBox.removeAllItems();
		for(int i=0; i<v.size(); i++)
			stdProgComboBox.addItem(v.elementAt(i));	
	}catch(Exception e){
		e.printStackTrace();
		javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
	}
}  
  private void getStdBatch(){
	ProgramBean bean=(ProgramBean)stdProgComboBox.getSelectedItem();
	if(bean==null)return;

	try{
	          Vector v=DatabaseManager.getBatch( bean.getProgId() );
	        stdBatchComboBox.removeAllItems();
		for(int i=0; i<v.size(); i++)
			stdBatchComboBox.addItem(v.elementAt(i));		
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
	          booksComboBox.removeAllItems();
                  for(int i=0;i<v.size();i++)
                      booksComboBox.addItem(v.elementAt(i));
	}catch(Exception e){
		e.printStackTrace();
		javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
	}
}    
private void getStdStudent(){
       BatchBean bean = (BatchBean)stdBatchComboBox.getSelectedItem();
       if(bean==null)return;
       try{
           	  Vector v=DatabaseManager.getStudent( bean.getBatchId() );
	          rollNoComboBox.removeAllItems();
                  for(int i=0;i<v.size();i++)
                      rollNoComboBox.addItem(v.elementAt(i));
       }catch(Exception e){
		e.printStackTrace();
		javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
	}
    
}
private void getBookRecord(){
    BookBean bean = (BookBean)booksComboBox.getSelectedItem();
     if(bean==null)return;  
        authorTextField.setText(bean.getAuthor());
        publisherTextField.setText(bean.getPublisher());
        editionTextField.setText(bean.getEdition());
        yearOfPublishingTextField.setText(""+bean.getYearOfPublishing());
        quantityTextField.setText(""+bean.getQuantity());
  
        priceTextField.setText(""+bean.getPrice());
        String date= Decoder.getDateFormat(bean.getDateOfPurchase());
        dateOfPurchaseTextField.setText( date );
        purchaseFromTextField.setText(bean.getPurchaseFrom());   
}
   private void getShiftGroup()
        {
            BatchBean bean=(BatchBean)stdBatchComboBox.getSelectedItem();
            if(bean==null)return;
         
//            String shift = Decoder.shiftDecode(bean.getShift());
//            String group = Decoder.groupDecode(bean.getGroupDesc());
  
              shiftTextField.setText(bean.getShift());
              groupTextField.setText(bean.getGroupDesc());
        }  

private void getBookIssue(){
    BookBean bean = (BookBean)booksComboBox.getSelectedItem();
    	if(bean==null)return;
//    StudentBean stdBean = (StudentBean)rollNoComboBox.getSelectedItem();
//        if(stdBean==null)return;
       
	try{
	          Vector v=DatabaseManager.getBookIssue( bean.getBookId());
                  dateOfIssueList.setListData(v); 		
	}catch(Exception e){
		e.printStackTrace();
		javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
	}
}

private void addBookIssue(){
    BookBean bkBean = (BookBean)booksComboBox.getSelectedItem();
    if(bkBean==null)return;
    StudentBean stdBean =(StudentBean)rollNoComboBox.getSelectedItem();
    if(stdBean==null)return;
  
    String dateOfReturn = Decoder.getDateFormat(dateOfReturnDateChooser.getDate());
    String dateOfIssue = Decoder.getDateFormat(dateOfIssueDateChooser.getDate());
    int fine=0;
    String remarks = remarksTextArea.getText();
    try{
        int rows = DatabaseManager.addBookIssue(bkBean.getBookId(),stdBean.getStdId(),dateOfIssue,dateOfReturn,fine,remarks);
        if(rows>=0){
            javax.swing.JOptionPane.showMessageDialog(this,rows+" Records Inserted.");
            clear();
            getBookIssue();
           }
    }catch(Exception e){
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this,"Error"+e.getMessage());
    }
}
private void deleteBookIssue(){
   
    int rows = 0;
    Object[] obj = (Object[])dateOfIssueList.getSelectedValues();
    for(int i=0;i<obj.length;i++){
        BookIssueBean bean = (BookIssueBean)obj[i];
        try{
            rows += DatabaseManager.deleteBookIssue(bean.getIssueId());
        }catch(Exception e){
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this,"Error"+ e.getMessage());
        }
    }
    if(rows>=0){
        javax.swing.JOptionPane.showMessageDialog(this, rows+" Record Removed");
        getBookIssue();
        clear();
    }
}
private void updateBookIssue(){
    
      int fine=0;
        if(fineTextField.getText().trim().length()>0)
            fine = Integer.parseInt(fineTextField.getText());
        
    int issueId = Integer.parseInt(issueIdTextField.getText());
    String dateOfReturn = Decoder.getDateFormat(dateOfReturnDateChooser.getDate());
    String dateOfIssue = Decoder.getDateFormat(dateOfIssueDateChooser.getDate());
    String remarks = remarksTextArea.getText();
    
 int rows = 0;
    Object[] obj = (Object[])dateOfIssueList.getSelectedValues();
    for(int i=0;i<obj.length;i++){
        BookIssueBean bean=(BookIssueBean)obj[i];
        try{
            rows += DatabaseManager.updateBookIssue(bean.getBookId(),bean.getStdId(),issueId,dateOfIssue,dateOfReturn,fine,remarks);
        }catch(Exception e){e.printStackTrace();}
    }
    	if(rows>=0){
	    javax.swing.JOptionPane.showMessageDialog(this,rows+" Record Modified.");
            getBookIssue();
	    clear();
        	}     
}
private void clear(){

}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bookIssueLabel = new javax.swing.JLabel();
        facultyLabel = new javax.swing.JLabel();
        deptLabel = new javax.swing.JLabel();
        booksLabel = new javax.swing.JLabel();
        issueIdLabel = new javax.swing.JLabel();
        dateOfIssueLabel = new javax.swing.JLabel();
        dateOfReturnLabel = new javax.swing.JLabel();
        fineLabel = new javax.swing.JLabel();
        remarksLabel = new javax.swing.JLabel();
        dateOfIssueListLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dateOfIssueList = new javax.swing.JList();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        facultyComboBox = new javax.swing.JComboBox();
        deptComboBox = new javax.swing.JComboBox();
        booksComboBox = new javax.swing.JComboBox();
        issueIdTextField = new javax.swing.JTextField();
        fineTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        rollNoLabel = new javax.swing.JLabel();
        rollNoComboBox = new javax.swing.JComboBox();
        authorLabel = new javax.swing.JLabel();
        publisherLabel = new javax.swing.JLabel();
        editionLabel = new javax.swing.JLabel();
        yearOfPublishingLabel = new javax.swing.JLabel();
        quantityLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        dateOfPurchaseLabel = new javax.swing.JLabel();
        purchaseFromLabel = new javax.swing.JLabel();
        authorTextField = new javax.swing.JTextField();
        publisherTextField = new javax.swing.JTextField();
        editionTextField = new javax.swing.JTextField();
        yearOfPublishingTextField = new javax.swing.JTextField();
        quantityTextField = new javax.swing.JTextField();
        priceTextField = new javax.swing.JTextField();
        dateOfPurchaseTextField = new javax.swing.JTextField();
        purchaseFromTextField = new javax.swing.JTextField();
        stdFacultyLabel = new javax.swing.JLabel();
        stdDeptLabel = new javax.swing.JLabel();
        stdProgLabel = new javax.swing.JLabel();
        stdBatchLabel = new javax.swing.JLabel();
        stdFacultyComboBox = new javax.swing.JComboBox();
        stdDeptComboBox = new javax.swing.JComboBox();
        stdProgComboBox = new javax.swing.JComboBox();
        stdBatchComboBox = new javax.swing.JComboBox();
        genderLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        fatherNameLabel = new javax.swing.JLabel();
        casteLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        fatherNameTextField = new javax.swing.JTextField();
        surnameTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        shiftTextField = new javax.swing.JTextField();
        groupTextField = new javax.swing.JTextField();
        genderTextField = new javax.swing.JTextField();
        stdRollNoLabel = new javax.swing.JLabel();
        rollNoTextField = new javax.swing.JTextField();
        dateOfIssueDateChooser = new com.toedter.calendar.JDateChooser();
        dateOfReturnDateChooser = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        bookIssueLabel.setFont(new java.awt.Font("Stencil", 1, 60)); // NOI18N
        bookIssueLabel.setText("BOOK ISSUE");
        getContentPane().add(bookIssueLabel);
        bookIssueLabel.setBounds(560, 20, 400, 60);

        facultyLabel.setText("FACULTY");
        getContentPane().add(facultyLabel);
        facultyLabel.setBounds(50, 90, 68, 40);

        deptLabel.setText("DEPARTMENT");
        getContentPane().add(deptLabel);
        deptLabel.setBounds(20, 140, 102, 40);

        booksLabel.setText("BOOKS");
        getContentPane().add(booksLabel);
        booksLabel.setBounds(60, 190, 60, 40);

        issueIdLabel.setText("ISSUE ID");
        getContentPane().add(issueIdLabel);
        issueIdLabel.setBounds(40, 580, 66, 50);

        dateOfIssueLabel.setText("DATE OF ISSUE");
        getContentPane().add(dateOfIssueLabel);
        dateOfIssueLabel.setBounds(270, 580, 115, 50);

        dateOfReturnLabel.setText("DATE OF RETURN ");
        getContentPane().add(dateOfReturnLabel);
        dateOfReturnLabel.setBounds(560, 580, 137, 50);

        fineLabel.setText("FINE");
        getContentPane().add(fineLabel);
        fineLabel.setBounds(870, 580, 34, 50);

        remarksLabel.setText("REMARKS");
        getContentPane().add(remarksLabel);
        remarksLabel.setBounds(30, 640, 70, 50);

        dateOfIssueListLabel.setText("DATE OF ISSUE");
        getContentPane().add(dateOfIssueListLabel);
        dateOfIssueListLabel.setBounds(1020, 90, 120, 40);

        dateOfIssueList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                dateOfIssueListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(dateOfIssueList);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(1020, 130, 170, 620);

        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton);
        addButton.setBounds(140, 770, 150, 50);

        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton);
        updateButton.setBounds(380, 770, 150, 50);

        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton);
        clearButton.setBounds(620, 770, 150, 50);

        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton);
        backButton.setBounds(850, 770, 150, 50);

        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton);
        deleteButton.setBounds(1020, 770, 170, 50);

        facultyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facultyComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(facultyComboBox);
        facultyComboBox.setBounds(150, 90, 850, 40);

        deptComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deptComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(deptComboBox);
        deptComboBox.setBounds(150, 140, 850, 40);

        booksComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                booksComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(booksComboBox);
        booksComboBox.setBounds(150, 190, 220, 40);
        getContentPane().add(issueIdTextField);
        issueIdTextField.setBounds(140, 580, 120, 50);
        getContentPane().add(fineTextField);
        fineTextField.setBounds(910, 580, 90, 50);

        remarksTextArea.setColumns(20);
        remarksTextArea.setRows(5);
        jScrollPane2.setViewportView(remarksTextArea);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(140, 640, 860, 110);

        rollNoLabel.setText("ROLL NO");
        getContentPane().add(rollNoLabel);
        rollNoLabel.setBounds(40, 530, 66, 30);

        rollNoComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rollNoComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(rollNoComboBox);
        rollNoComboBox.setBounds(140, 530, 230, 40);

        authorLabel.setText("AUTHOR");
        getContentPane().add(authorLabel);
        authorLabel.setBounds(380, 190, 70, 20);

        publisherLabel.setText("PUBLISHER");
        getContentPane().add(publisherLabel);
        publisherLabel.setBounds(560, 190, 90, 20);

        editionLabel.setText("EDITION");
        getContentPane().add(editionLabel);
        editionLabel.setBounds(760, 190, 70, 20);

        yearOfPublishingLabel.setText("YEAR OF PUBLISHING");
        getContentPane().add(yearOfPublishingLabel);
        yearOfPublishingLabel.setBounds(380, 250, 170, 20);

        quantityLabel.setText("QUANTITY");
        getContentPane().add(quantityLabel);
        quantityLabel.setBounds(880, 190, 90, 20);

        priceLabel.setText("PRICE");
        getContentPane().add(priceLabel);
        priceLabel.setBounds(910, 250, 60, 20);

        dateOfPurchaseLabel.setText("DATE OF PURCHASE");
        getContentPane().add(dateOfPurchaseLabel);
        dateOfPurchaseLabel.setBounds(560, 250, 160, 20);

        purchaseFromLabel.setText("PURCHASE FROM");
        getContentPane().add(purchaseFromLabel);
        purchaseFromLabel.setBounds(760, 250, 140, 20);

        authorTextField.setEditable(false);
        getContentPane().add(authorTextField);
        authorTextField.setBounds(380, 210, 170, 30);

        publisherTextField.setEditable(false);
        getContentPane().add(publisherTextField);
        publisherTextField.setBounds(560, 210, 190, 30);

        editionTextField.setEditable(false);
        getContentPane().add(editionTextField);
        editionTextField.setBounds(760, 210, 110, 30);

        yearOfPublishingTextField.setEditable(false);
        getContentPane().add(yearOfPublishingTextField);
        yearOfPublishingTextField.setBounds(380, 280, 170, 30);

        quantityTextField.setEditable(false);
        getContentPane().add(quantityTextField);
        quantityTextField.setBounds(880, 210, 120, 30);

        priceTextField.setEditable(false);
        getContentPane().add(priceTextField);
        priceTextField.setBounds(910, 280, 90, 30);

        dateOfPurchaseTextField.setEditable(false);
        getContentPane().add(dateOfPurchaseTextField);
        dateOfPurchaseTextField.setBounds(560, 280, 190, 30);

        purchaseFromTextField.setEditable(false);
        purchaseFromTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseFromTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(purchaseFromTextField);
        purchaseFromTextField.setBounds(760, 280, 130, 30);

        stdFacultyLabel.setText("FACULTY");
        getContentPane().add(stdFacultyLabel);
        stdFacultyLabel.setBounds(40, 320, 68, 40);

        stdDeptLabel.setText("DEPARTMENT");
        getContentPane().add(stdDeptLabel);
        stdDeptLabel.setBounds(10, 370, 110, 40);

        stdProgLabel.setText("PROGRAM");
        getContentPane().add(stdProgLabel);
        stdProgLabel.setBounds(30, 420, 75, 40);

        stdBatchLabel.setText("BATCH");
        getContentPane().add(stdBatchLabel);
        stdBatchLabel.setBounds(50, 470, 51, 40);

        stdFacultyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stdFacultyComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(stdFacultyComboBox);
        stdFacultyComboBox.setBounds(140, 320, 860, 40);

        stdDeptComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stdDeptComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(stdDeptComboBox);
        stdDeptComboBox.setBounds(140, 370, 860, 40);

        stdProgComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stdProgComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(stdProgComboBox);
        stdProgComboBox.setBounds(140, 420, 230, 40);

        stdBatchComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stdBatchComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(stdBatchComboBox);
        stdBatchComboBox.setBounds(140, 470, 230, 40);

        genderLabel.setText("GENDER");
        getContentPane().add(genderLabel);
        genderLabel.setBounds(590, 510, 70, 30);

        nameLabel.setText("NAME");
        getContentPane().add(nameLabel);
        nameLabel.setBounds(390, 450, 43, 30);

        fatherNameLabel.setText("FATHER'S NAME");
        getContentPane().add(fatherNameLabel);
        fatherNameLabel.setBounds(600, 460, 120, 20);

        casteLabel.setText("SURNAME");
        getContentPane().add(casteLabel);
        casteLabel.setBounds(790, 460, 90, 20);

        nameTextField.setEditable(false);
        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(nameTextField);
        nameTextField.setBounds(390, 480, 190, 30);

        fatherNameTextField.setEditable(false);
        getContentPane().add(fatherNameTextField);
        fatherNameTextField.setBounds(590, 480, 190, 30);

        surnameTextField.setEditable(false);
        getContentPane().add(surnameTextField);
        surnameTextField.setBounds(790, 480, 210, 30);

        jLabel1.setText("SHIFT");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(740, 510, 44, 30);

        jLabel2.setText("GROUP");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(940, 530, 60, 20);

        shiftTextField.setEditable(false);
        shiftTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shiftTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(shiftTextField);
        shiftTextField.setBounds(730, 540, 130, 30);

        groupTextField.setEditable(false);
        groupTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(groupTextField);
        groupTextField.setBounds(870, 540, 130, 30);

        genderTextField.setEditable(false);
        getContentPane().add(genderTextField);
        genderTextField.setBounds(590, 540, 130, 30);

        stdRollNoLabel.setText("ROLL NO");
        getContentPane().add(stdRollNoLabel);
        stdRollNoLabel.setBounds(390, 510, 70, 30);

        rollNoTextField.setEditable(false);
        getContentPane().add(rollNoTextField);
        rollNoTextField.setBounds(390, 540, 190, 30);
        getContentPane().add(dateOfIssueDateChooser);
        dateOfIssueDateChooser.setBounds(400, 590, 140, 40);
        getContentPane().add(dateOfReturnDateChooser);
        dateOfReturnDateChooser.setBounds(700, 590, 160, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dateOfIssueListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_dateOfIssueListValueChanged
        BookIssueBean bean = (BookIssueBean)dateOfIssueList.getSelectedValue();
        if(bean==null)return;
        
        issueIdTextField.setText(""+bean.getIssueId());
        //String dateOfIssue= Decoder.getDateFormat(bean.getDateOfIssue());
        dateOfIssueDateChooser.setDate( bean.getDateOfIssue() );
        
        if(bean.getDateOfReturn()!=null)
        {   
        String dateOfReturn =Decoder.getDateFormat(bean.getDateOfReturn());
        dateOfReturnDateChooser.setDate(bean.getDateOfReturn());
        }else {
        String dateOfReturn ="";
        dateOfReturnDateChooser.setDate(bean.getDateOfReturn());
        }
        
        fineTextField.setText(""+bean.getFine());           
        remarksTextArea.setText(bean.getRemarks());
        
        
        nameTextField.setText(bean.getName());
        fatherNameTextField.setText(bean.getFname());
        surnameTextField.setText(bean.getSurname());
        genderTextField.setText(bean.getGender());
        rollNoTextField.setText(bean.getRollNo());
        getShiftGroup();
        
    }//GEN-LAST:event_dateOfIssueListValueChanged

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
       addBookIssue();
    }//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        updateBookIssue();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clear();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        
    }//GEN-LAST:event_backButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        deleteBookIssue();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void facultyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facultyComboBoxActionPerformed
        getDepartment();
    }//GEN-LAST:event_facultyComboBoxActionPerformed

    private void deptComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deptComboBoxActionPerformed
        getBook();
    }//GEN-LAST:event_deptComboBoxActionPerformed

    private void booksComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_booksComboBoxActionPerformed
        getBookIssue();
        getBookRecord();
    }//GEN-LAST:event_booksComboBoxActionPerformed

    private void rollNoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rollNoComboBoxActionPerformed
            getBookIssue();
  
    }//GEN-LAST:event_rollNoComboBoxActionPerformed

    private void purchaseFromTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseFromTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_purchaseFromTextFieldActionPerformed

    private void stdFacultyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stdFacultyComboBoxActionPerformed
    getStdDepartment();
    }//GEN-LAST:event_stdFacultyComboBoxActionPerformed

    private void stdDeptComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stdDeptComboBoxActionPerformed
    getStdProgram();
    }//GEN-LAST:event_stdDeptComboBoxActionPerformed

    private void stdProgComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stdProgComboBoxActionPerformed
    getStdBatch();
    }//GEN-LAST:event_stdProgComboBoxActionPerformed

    private void stdBatchComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stdBatchComboBoxActionPerformed
    getStdStudent();
    }//GEN-LAST:event_stdBatchComboBoxActionPerformed

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void groupTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_groupTextFieldActionPerformed

    private void shiftTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shiftTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_shiftTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(BookIssueFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookIssueFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookIssueFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookIssueFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookIssueFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel authorLabel;
    private javax.swing.JTextField authorTextField;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel bookIssueLabel;
    private javax.swing.JComboBox booksComboBox;
    private javax.swing.JLabel booksLabel;
    private javax.swing.JLabel casteLabel;
    private javax.swing.JButton clearButton;
    private com.toedter.calendar.JDateChooser dateOfIssueDateChooser;
    private javax.swing.JLabel dateOfIssueLabel;
    private javax.swing.JList dateOfIssueList;
    private javax.swing.JLabel dateOfIssueListLabel;
    private javax.swing.JLabel dateOfPurchaseLabel;
    private javax.swing.JTextField dateOfPurchaseTextField;
    private com.toedter.calendar.JDateChooser dateOfReturnDateChooser;
    private javax.swing.JLabel dateOfReturnLabel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JComboBox deptComboBox;
    private javax.swing.JLabel deptLabel;
    private javax.swing.JLabel editionLabel;
    private javax.swing.JTextField editionTextField;
    private javax.swing.JComboBox facultyComboBox;
    private javax.swing.JLabel facultyLabel;
    private javax.swing.JLabel fatherNameLabel;
    private javax.swing.JTextField fatherNameTextField;
    private javax.swing.JLabel fineLabel;
    private javax.swing.JTextField fineTextField;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JTextField genderTextField;
    private javax.swing.JTextField groupTextField;
    private javax.swing.JLabel issueIdLabel;
    private javax.swing.JTextField issueIdTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
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
    private javax.swing.JComboBox rollNoComboBox;
    private javax.swing.JLabel rollNoLabel;
    private javax.swing.JTextField rollNoTextField;
    private javax.swing.JTextField shiftTextField;
    private javax.swing.JComboBox stdBatchComboBox;
    private javax.swing.JLabel stdBatchLabel;
    private javax.swing.JComboBox stdDeptComboBox;
    private javax.swing.JLabel stdDeptLabel;
    private javax.swing.JComboBox stdFacultyComboBox;
    private javax.swing.JLabel stdFacultyLabel;
    private javax.swing.JComboBox stdProgComboBox;
    private javax.swing.JLabel stdProgLabel;
    private javax.swing.JLabel stdRollNoLabel;
    private javax.swing.JTextField surnameTextField;
    private javax.swing.JButton updateButton;
    private javax.swing.JLabel yearOfPublishingLabel;
    private javax.swing.JTextField yearOfPublishingTextField;
    // End of variables declaration//GEN-END:variables
}
