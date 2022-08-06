/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanClasses;

/**
 *
 * @author Danish
 */
public class DepartmentBean {
	private int deptId;
	private int facId;
	private String deptName;
	private String remarks;

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public int getFacId() {
        return facId;
    }

    public void setFacId(int facId) {
        this.facId = facId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
	
	/*public void setDeptId(int deptId){
		this.deptId=deptId;
	}
	public void setFacId(int facId){
		this.facId=facId;
	}
	public void setdeptName(String deptName){
		this.deptName=deptName;
	}
	public void setRemarks(String remarks){
		this.remarks=remarks;
	}
        
        public g getdeptName(){
		return deptName;
	}

	public int getDeptId(){
		return deptId;
	}
	public int getFacId(){
		return facId;
	}
	public String getdeptName(){
		return deptName;
	}
	public String getRemarks(){
		return remarks;
	} 

  /*  public void setDeptName(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    public String toString(){
    return deptName;
    }

  

}
