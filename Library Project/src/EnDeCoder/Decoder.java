/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnDeCoder;

import java.text.SimpleDateFormat;

/**
 *
 * @author Danish
 */
public class Decoder {
   	public static String messDecode(String mess){
		if(mess.equals("Y"))return "YES";
		if(mess.equals("N"))return "NO";
		return mess;	
	}
	public static String gradeDecode(String grade){
		if(grade.equals("A"))return "A GRADE";
                if(grade.equals("B"))return "B GRADE";
                if(grade.equals("C"))return "C GRADE";
                if(grade.equals("D"))return "D GRADE";
                if(grade.equals("E"))return "E GRADE";
                if(grade.equals("F"))return "FAIL";

		return grade;	
	}           
	public static String schemePartDecode(String schemePart){
		if(schemePart.equals("1"))return "1";
		if(schemePart.equals("2"))return "2";
		if(schemePart.equals("3"))return "3";
		if(schemePart.equals("4"))return "4";

		return schemePart;	
	}    
	public static String subjTypeDecode(String subjType){
		if(subjType.equals("E"))return "ELECTIVE";
		if(subjType.equals("G"))return "GENERAL";

		return subjType;	
	}     
    	public static String isCreditableDecode(String isCreditable){
		if(isCreditable.equals("Y"))return "YES";
		if(isCreditable.equals("N"))return "NO";
		return isCreditable;	
	}      
	public static String typeDecode(String type){
		if(type.equals("R"))return "REGULAR";
		if(type.equals("I"))return "IMPROVER";
		if(type.equals("S"))return "SPECIAL";
		return type;	
	}       
    	public static String statusDecode(String status){
		if(status.equals("T"))return "TEMPARORY";
		if(status.equals("L"))return "LEGAL";
		return status;	
	}    
    	public static String genderDecode(String gender){
		if(gender.equals("M"))return "MALE";
		if(gender.equals("F"))return "FEMALE";
		return gender;	
	} 

	public static String shiftDecode(String shift){
		if(shift.equals("M"))return "MORNING";
		if(shift.equals("E"))return "EVENING";
		if(shift.equals("N"))return "NOON";
		return shift;	
	} 

	public static String groupDecode(String group){
		if(group.equals("E"))return "ENGINEERING";
		if(group.equals("M"))return "MEDICAL";
		if(group.equals("C"))return "COMMERCE";
		if(group.equals("G"))return "GENERAL";

		return group;	
	} 
        public static String getDateFormat(java.util.Date date)
        {
        SimpleDateFormat f = new SimpleDateFormat("dd-MMM-YYYY");
            String d=f.format(date);
            return d;
        }
    
}
