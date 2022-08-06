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
public class BookIssuePanel extends javax.swing.JPanel {

    /**
     * Creates new form BookIssuePanel
     */
    public BookIssuePanel() {
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

        setBackground(new java.awt.Color(0, 153, 204));
        setForeground(new java.awt.Color(51, 51, 0));

        bookIssueLabel.setFont(new java.awt.Font("Stencil", 1, 40)); // NOI18N
        bookIssueLabel.setText("BOOK ISSUE");

        facultyLabel.setText("FACULTY");

        deptLabel.setText("DEPARTMENT");

        booksLabel.setText("BOOKS");

        issueIdLabel.setText("ISSUE ID");

        dateOfIssueLabel.setText("DATE OF ISSUE");

        dateOfReturnLabel.setText("DATE OF RETURN ");

        fineLabel.setText("FINE");

        remarksLabel.setText("REMARKS");

        dateOfIssueListLabel.setText("DATE OF ISSUE");

        dateOfIssueList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                dateOfIssueListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(dateOfIssueList);

        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add_1.jpg"))); // NOI18N
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/update_1.jpg"))); // NOI18N
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        clearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/clear_1.jpg"))); // NOI18N
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back_1.png"))); // NOI18N
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete_1.jpg"))); // NOI18N
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        facultyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facultyComboBoxActionPerformed(evt);
            }
        });

        deptComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deptComboBoxActionPerformed(evt);
            }
        });

        booksComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                booksComboBoxActionPerformed(evt);
            }
        });

        remarksTextArea.setColumns(20);
        remarksTextArea.setRows(5);
        jScrollPane2.setViewportView(remarksTextArea);

        rollNoLabel.setText("ROLL NO");

        rollNoComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rollNoComboBoxActionPerformed(evt);
            }
        });

        authorLabel.setText("AUTHOR");

        publisherLabel.setText("PUBLISHER");

        editionLabel.setText("EDITION");

        yearOfPublishingLabel.setText("YEAR OF PUBLISHING");

        quantityLabel.setText("QUANTITY");

        priceLabel.setText("PRICE");

        dateOfPurchaseLabel.setText("DATE OF PURCHASE");

        purchaseFromLabel.setText("PURCHASE FROM");

        authorTextField.setEditable(false);

        publisherTextField.setEditable(false);

        editionTextField.setEditable(false);

        yearOfPublishingTextField.setEditable(false);

        quantityTextField.setEditable(false);

        priceTextField.setEditable(false);

        dateOfPurchaseTextField.setEditable(false);

        purchaseFromTextField.setEditable(false);
        purchaseFromTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseFromTextFieldActionPerformed(evt);
            }
        });

        stdFacultyLabel.setText("FACULTY");

        stdDeptLabel.setText("DEPARTMENT");

        stdProgLabel.setText("PROGRAM");

        stdBatchLabel.setText("BATCH");

        stdFacultyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stdFacultyComboBoxActionPerformed(evt);
            }
        });

        stdDeptComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stdDeptComboBoxActionPerformed(evt);
            }
        });

        stdProgComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stdProgComboBoxActionPerformed(evt);
            }
        });

        stdBatchComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stdBatchComboBoxActionPerformed(evt);
            }
        });

        genderLabel.setText("GENDER");

        nameLabel.setText("NAME");

        fatherNameLabel.setText("FATHER'S NAME");

        casteLabel.setText("SURNAME");

        nameTextField.setEditable(false);
        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });

        fatherNameTextField.setEditable(false);

        surnameTextField.setEditable(false);

        jLabel1.setText("SHIFT");

        jLabel2.setText("GROUP");

        shiftTextField.setEditable(false);
        shiftTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shiftTextFieldActionPerformed(evt);
            }
        });

        groupTextField.setEditable(false);
        groupTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupTextFieldActionPerformed(evt);
            }
        });

        genderTextField.setEditable(false);

        stdRollNoLabel.setText("ROLL NO");

        rollNoTextField.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(facultyLabel)
                        .addGap(32, 32, 32)
                        .addComponent(facultyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(dateOfIssueListLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100)
                                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(111, 111, 111)
                                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(103, 103, 103)
                                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(deptLabel))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addComponent(booksLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(stdFacultyLabel))
                                    .addComponent(stdDeptLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(stdProgLabel))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(stdBatchLabel))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(rollNoLabel))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(issueIdLabel))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(remarksLabel)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(deptComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(booksComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(authorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(authorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(publisherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(publisherTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(editionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(editionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(quantityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(quantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(240, 240, 240)
                                        .addComponent(yearOfPublishingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(dateOfPurchaseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)
                                        .addComponent(purchaseFromLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(240, 240, 240)
                                        .addComponent(yearOfPublishingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(dateOfPurchaseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(purchaseFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(stdFacultyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(stdDeptComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(stdProgComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(stdBatchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(20, 20, 20)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nameLabel)
                                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(fatherNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(fatherNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(casteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(surnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rollNoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(stdRollNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(rollNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(genderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(genderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel1))
                                            .addComponent(shiftTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(groupTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(70, 70, 70)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(issueIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(dateOfIssueLabel)
                                        .addGap(15, 15, 15)
                                        .addComponent(dateOfIssueDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(dateOfReturnLabel)
                                        .addGap(3, 3, 3)
                                        .addComponent(dateOfReturnDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(fineLabel)
                                        .addGap(6, 6, 6)
                                        .addComponent(fineTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 300, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(519, 519, 519)
                .addComponent(bookIssueLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(bookIssueLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(facultyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(facultyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateOfIssueListLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(deptLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(booksLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90)
                                .addComponent(stdFacultyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(stdDeptLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(stdProgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(stdBatchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(rollNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(issueIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(remarksLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(deptComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(booksComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(authorLabel)
                                        .addGap(0, 0, 0)
                                        .addComponent(authorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(publisherLabel)
                                        .addGap(0, 0, 0)
                                        .addComponent(publisherTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(editionLabel)
                                        .addGap(0, 0, 0)
                                        .addComponent(editionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(quantityLabel)
                                        .addGap(0, 0, 0)
                                        .addComponent(quantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(yearOfPublishingLabel)
                                    .addComponent(dateOfPurchaseLabel)
                                    .addComponent(purchaseFromLabel)
                                    .addComponent(priceLabel))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(yearOfPublishingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateOfPurchaseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(purchaseFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addComponent(stdFacultyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(stdDeptComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(stdProgComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(stdBatchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(fatherNameLabel)
                                        .addGap(0, 0, 0)
                                        .addComponent(fatherNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(casteLabel)
                                        .addGap(0, 0, 0)
                                        .addComponent(surnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(stdRollNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(rollNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(genderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(genderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(shiftTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rollNoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(groupTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel2))))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(issueIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateOfIssueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateOfReturnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fineLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fineTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(dateOfIssueDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dateOfReturnDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(104, Short.MAX_VALUE))))
        );
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

    private void shiftTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shiftTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_shiftTextFieldActionPerformed

    private void groupTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_groupTextFieldActionPerformed


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
