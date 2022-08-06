/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnDeCoder;

/**
 *
 * @author Danish
 */
public class Encoder {
  	public static String messEncode(String mess){
		if(mess.equals("YES"))return "Y";
		if(mess.equals("NO"))return "N";
		return mess;	
	} 
    
	public static String gradeEncode(String grade){
		if(grade.equals("A GRADE"))return "A";
                if(grade.equals("B GRADE"))return "B";
                if(grade.equals("C GRADE"))return "C";
                if(grade.equals("D GRADE"))return "D";
                if(grade.equals("E GRADE"))return "E";
                if(grade.equals("FAIL"))return "F";

		return grade;	
	}          
	public static String schemePartEncode(String schemePart){
		if(schemePart.equals("1"))return "1";
		if(schemePart.equals("2"))return "2";
		if(schemePart.equals("3"))return "3";
		if(schemePart.equals("4"))return "4";

		return schemePart;	
	}      
	public static String subjTypeEncode(String subjType){
		if(subjType.equals("ELECTIVE"))return "E";
		if(subjType.equals("GENERAL"))return "G";

		return subjType;	
	}     
    	public static String isCreditableEncode(String isCreditable){
		if(isCreditable.equals("YES"))return "Y";
		if(isCreditable.equals("NO"))return "N";
		return isCreditable;	
	}         
	public static String typeEncode(String type){
		if(type.equals("REGULAR"))return "R";
		if(type.equals("IMPROVER"))return "I";
		if(type.equals("SPECIAL"))return "S";
		return type;	
	}     
    	public static String statusEncode(String status){
		if(status.equals("TEMPARORY"))return "T";
		if(status.equals("LEGAL"))return "L";
		return status;	
	}     
    	public static String genderEncode(String gender){
		if(gender.equals("MALE"))return "M";
		if(gender.equals("FEMALE"))return "F";
		return gender;	
	} 

	public static String shiftEncode(String shift){
		if(shift.equals("MORNING"))return "M";
		if(shift.equals("EVENING"))return "E";
		if(shift.equals("NOON"))return "N";
		return shift;	
	} 

	public static String groupEncode(String group){
		if(group.equals("ENGINEERING"))return "E";
		if(group.equals("MEDICAL"))return "M";
		if(group.equals("COMMERCE"))return "C";
		if(group.equals("GENERAL"))return "G";

		return group;	
	} 
    
}
