package Frames;


import BeanClasses.DepartmentBean;
import BeanClasses.FacultyBean;
import BeanClasses.ProgramBean;
import DatabaseManager.DatabaseManager;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Danish
 */
public class ProgramFrame extends javax.swing.JFrame {

    /**
     * Creates new form ProgramFrame
     */
    public ProgramFrame() {
        initComponents();
        getFaculty();
        //getDepartment();
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        programLabel = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(2000, 1000));
        getContentPane().setLayout(null);

        programLabel.setFont(new java.awt.Font("Stencil", 1, 48)); // NOI18N
        programLabel.setText("PROGRAM");
        getContentPane().add(programLabel);
        programLabel.setBounds(440, 60, 320, 60);

        facultyLabel.setText("FACULTY");
        getContentPane().add(facultyLabel);
        facultyLabel.setBounds(110, 140, 80, 30);

        deptLabel.setText("DEPARTMENT");
        getContentPane().add(deptLabel);
        deptLabel.setBounds(110, 190, 130, 30);

        progIdLabel.setText("PROGRAM ID");
        getContentPane().add(progIdLabel);
        progIdLabel.setBounds(110, 240, 97, 30);

        progNameLabel.setText("PROGRAM NAME");
        getContentPane().add(progNameLabel);
        progNameLabel.setBounds(110, 300, 123, 30);

        durationLabel.setText("DURATION");
        getContentPane().add(durationLabel);
        durationLabel.setBounds(110, 360, 82, 30);

        inSemesterLabel.setText("IN SEMESTER");
        getContentPane().add(inSemesterLabel);
        inSemesterLabel.setBounds(390, 360, 99, 30);

        remaksLabel.setText("REMARKS");
        getContentPane().add(remaksLabel);
        remaksLabel.setBounds(110, 430, 70, 30);

        progListLabel.setText("PROGRAMS");
        getContentPane().add(progListLabel);
        progListLabel.setBounds(850, 140, 84, 20);

        facultyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facultyComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(facultyComboBox);
        facultyComboBox.setBounds(260, 140, 560, 40);

        deptComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deptComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(deptComboBox);
        deptComboBox.setBounds(260, 200, 560, 40);
        getContentPane().add(progIdTextField);
        progIdTextField.setBounds(260, 250, 230, 40);
        getContentPane().add(progNameTextField);
        progNameTextField.setBounds(260, 300, 560, 40);
        getContentPane().add(durationTextField);
        durationTextField.setBounds(260, 360, 110, 40);

        remarksTextArea.setColumns(20);
        remarksTextArea.setRows(5);
        jScrollPane1.setViewportView(remarksTextArea);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(260, 410, 560, 200);

        programsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                programsListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(programsList);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(850, 160, 270, 440);

        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton);
        addButton.setBounds(240, 650, 140, 60);

        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton);
        updateButton.setBounds(390, 650, 140, 60);

        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton);
        clearButton.setBounds(540, 650, 130, 60);

        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton);
        backButton.setBounds(680, 650, 130, 60);

        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton);
        deleteButton.setBounds(849, 650, 270, 60);

        pack();
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

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
    if(addButton==evt.getSource())
        addProgram();        // TODO add your handling code here:
    }//GEN-LAST:event_addButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clear();        // TODO add your handling code here:
    }//GEN-LAST:event_clearButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
       if(deleteButton==evt.getSource()) deleteProgram();
// TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
           if(updateButton==evt.getSource())  
                updateProgram();        // TODO add your handling code here:
    }//GEN-LAST:event_updateButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
//          new MainFrame().setVisible(true);
//          dispose();          // TODO add your handling code here:
    }//GEN-LAST:event_backButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ProgramFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProgramFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProgramFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProgramFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProgramFrame().setVisible(true);
            }
        });
    }

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel progIdLabel;
    private javax.swing.JTextField progIdTextField;
    private javax.swing.JLabel progListLabel;
    private javax.swing.JLabel progNameLabel;
    private javax.swing.JTextField progNameTextField;
    private javax.swing.JLabel programLabel;
    private javax.swing.JList programsList;
    private javax.swing.JLabel remaksLabel;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}