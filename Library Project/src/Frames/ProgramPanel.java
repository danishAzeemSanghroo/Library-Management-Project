/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import BeanClasses.DepartmentBean;
import BeanClasses.FacultyBean;
import BeanClasses.ProgramBean;
import DatabaseManager.DatabaseManager;
import java.util.Vector;

/**
 *
 * @author Danish
 */
public class ProgramPanel extends javax.swing.JPanel {

    /**
     * Creates new form ProgramPanel
     */
    public ProgramPanel() {
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
	try{
                FacultyBean bean =(FacultyBean)facultyComboBox.getSelectedItem();
                //System.out.println(bean);
                if(bean==null)return;
                Vector v=DatabaseManager.getDepartment(bean.getFacId());
		deptComboBox.removeAllItems();
		for(int i=0; i<v.size(); i++)
			deptComboBox.addItem(v.elementAt(i));

	}catch(Exception e){
		e.printStackTrace();
		javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
	}
}//end method 
private void getProgram(){
	DepartmentBean bean=(DepartmentBean)deptComboBox.getSelectedItem();
	if(bean==null)return;

	try{
	          Vector v=DatabaseManager.getProgram( bean.getDeptId() );
	           programsList.setListData(v); 		
	}catch(Exception e){
		e.printStackTrace();
		javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
	}
}       
   private void addProgram(){
     DepartmentBean bean=(DepartmentBean)deptComboBox.getSelectedItem();
     if(bean==null)return;

    String progName=progNameTextField.getText();
    int semDuration = Integer.parseInt(durationTextField.getText());
    String remarks=remarksTextArea.getText();

    try{
               	int rows=DatabaseManager.addProgram(bean.getDeptId(),progName,semDuration,remarks);
	if(rows>=1){
	        	javax.swing.JOptionPane.showMessageDialog(this,rows+" Records Inserted."); 
		clear();
		getProgram();				
	}
    }catch(Exception e){
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage()); 
    }

}   //end
private void deleteProgram(){
    ProgramBean bean = (ProgramBean)programsList.getSelectedValue();
    if(bean==null)return;
    try{
           int rows = DatabaseManager.deleteProgram(bean.getProgId());
           if(rows>=1){
           javax.swing.JOptionPane.showMessageDialog(this,rows+"Record Removed.");
           getProgram();
           clear();
           }
    }catch(Exception e){
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage()); 
    }

}
private void updateProgram(){
     ProgramBean bean=(ProgramBean)programsList.getSelectedValue();
     if(bean==null)return;

     String progName=progNameTextField.getText();
     int semDuration = Integer.parseInt(durationTextField.getText());
     String remarks=remarksTextArea.getText();

     try{
	int rows=DatabaseManager.updateProgram(bean.getProgId(),progName,semDuration,remarks);
	if(rows>=1){
	    javax.swing.JOptionPane.showMessageDialog(this,rows+" Record Modified.");
	    getProgram();
	    clear();
        	}
     }catch(Exception e){
         e.printStackTrace();
         javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
     } 
}

private void clear(){
    progIdTextField.setText("");
    progNameTextField.setText("");
    durationTextField.setText("");
    remarksTextArea.setText("");
} 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        facultyLabel = new javax.swing.JLabel();
        deptLabel = new javax.swing.JLabel();
        progIdLabel = new javax.swing.JLabel();
        progNameLabel = new javax.swing.JLabel();
        durationLabel = new javax.swing.JLabel();
        inSemesterLabel = new javax.swing.JLabel();
        remaksLabel = new javax.swing.JLabel();
        progListLabel = new javax.swing.JLabel();
        facultyComboBox = new javax.swing.JComboBox();
        deptComboBox = new javax.swing.JComboBox();
        progIdTextField = new javax.swing.JTextField();
        progNameTextField = new javax.swing.JTextField();
        durationTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        programsList = new javax.swing.JList();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        jLabel1.setText("Program");

        facultyLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        facultyLabel.setText("FACULTY");

        deptLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        deptLabel.setText("DEPARTMENT");

        progIdLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        progIdLabel.setText("PROGRAM ID");

        progNameLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        progNameLabel.setText("PROGRAM NAME");

        durationLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        durationLabel.setText("DURATION");

        inSemesterLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        inSemesterLabel.setText("IN SEMESTER");

        remaksLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        remaksLabel.setText("REMARKS");

        progListLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        progListLabel.setText("PROGRAMS");

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

        remarksTextArea.setColumns(20);
        remarksTextArea.setRows(5);
        jScrollPane1.setViewportView(remarksTextArea);

        programsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                programsListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(programsList);

        addButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add_1.jpg"))); // NOI18N
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        updateButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/update_1.jpg"))); // NOI18N
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        clearButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        clearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/clear_1.jpg"))); // NOI18N
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back_1.png"))); // NOI18N
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        deleteButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete_1.jpg"))); // NOI18N
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(526, 526, 526)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(progIdLabel)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(facultyLabel)
                                    .addComponent(deptLabel))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(19, 19, 19)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(remaksLabel)
                                        .addComponent(durationLabel))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(progNameLabel)
                                .addGap(7, 7, 7)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(durationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(inSemesterLabel))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(progNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(progIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(87, 87, 87)
                                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(84, 84, 84)
                                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(facultyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(deptComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(progListLabel)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(progListLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(facultyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(facultyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addComponent(deptComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(progIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(progNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(progNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(durationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(durationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(inSemesterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(deptLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(progIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(remaksLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(149, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void facultyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facultyComboBoxActionPerformed
        getDepartment(); // TODO add your handling code here:
    }//GEN-LAST:event_facultyComboBoxActionPerformed

    private void deptComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deptComboBoxActionPerformed
        getProgram();
    }//GEN-LAST:event_deptComboBoxActionPerformed

    private void programsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_programsListValueChanged
        ProgramBean bean=(ProgramBean)programsList.getSelectedValue();
        if(bean==null)return;

        progIdTextField.setText( ""+bean.getProgId());
        durationTextField.setText( ""+bean.getSemDuration());
        progNameTextField.setText( bean.getProgName());
        remarksTextArea.setText( bean.getRemarks()); // TODO add your handling code here:
    }//GEN-LAST:event_programsListValueChanged

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        //          new MainFrame().setVisible(true);
        //          dispose();          // TODO add your handling code here:
    }//GEN-LAST:event_backButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if(deleteButton==evt.getSource()) deleteProgram();
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        if(updateButton==evt.getSource())
        updateProgram();        // TODO add your handling code here:
    }//GEN-LAST:event_updateButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if(addButton==evt.getSource())
        addProgram();        // TODO add your handling code here:
    }//GEN-LAST:event_addButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clear();        // TODO add your handling code here:
    }//GEN-LAST:event_clearButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JComboBox deptComboBox;
    private javax.swing.JLabel deptLabel;
    private javax.swing.JLabel durationLabel;
    private javax.swing.JTextField durationTextField;
    private javax.swing.JComboBox facultyComboBox;
    private javax.swing.JLabel facultyLabel;
    private javax.swing.JLabel inSemesterLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel progIdLabel;
    private javax.swing.JTextField progIdTextField;
    private javax.swing.JLabel progListLabel;
    private javax.swing.JLabel progNameLabel;
    private javax.swing.JTextField progNameTextField;
    private javax.swing.JList programsList;
    private javax.swing.JLabel remaksLabel;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
