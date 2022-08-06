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
public class ProgramBean {
        int deptId;
	int progId;
	String progName;
	int semDuration;
        String remarks;

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public int getProgId() {
        return progId;
    }

    public void setProgId(int progId) {
        this.progId = progId;
    }

    public String getProgName() {
        return progName;
    }

    public void setProgName(String progName) {
        this.progName = progName;
    }

    public int getSemDuration() {
        return semDuration;
    }

    public void setSemDuration(int semDuration) {
        this.semDuration = semDuration;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
	//String remarks;
	
	/*ublic void setDeptId(int deptId){
		this.deptId=deptId;
	}
	public void setProgId(int progId){
		this.progId=progId;
	}
	public void setProgName(String progName){
		this.progName=progName;
	}
	public void setDuration(int duration){
		this.duration=duration;
	}	
	public void setRemarks(String remarks){
		this.remarks=remarks;
	}

	public int getDeptId(){
		return deptId;
	}
	public int getProgId(){
		return progId;
	}
	public String getProgName(){
		return progName;
	}
	public int getDuration(){
		return duration;
	}	
	public String getRemarks(){
		return remarks;
	}   */
        public String toString()
        {
        return progName;
        }
}
