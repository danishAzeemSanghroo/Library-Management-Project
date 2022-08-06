/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseManager;

import BeanClasses.BatchBean;
import BeanClasses.BookBean;
import BeanClasses.BookIssueBean;
import BeanClasses.DepartmentBean;
import BeanClasses.FacultyBean;
import BeanClasses.ProgramBean;
import BeanClasses.StudentBean;
import Frames.DefaulterListFrame;
import java.awt.FileDialog;
import java.io.FileOutputStream;
import java.io.PrintStream;
//import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.year;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import java.util.List;
import java.util.Vector;

/**
 *
 * @author Danish
 */
public class DatabaseManager {
   

    
    //usindh connection starts
	private static Connection con;
    private static String fac_id;
	static{
		try{
			init();
		}catch(Exception e){
		}
	}
	private static void init()throws Exception{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection("jdbc:odbc:ProjectLibrary");
	}
     // usindh connection ends
        
	public static int addFaculty(String facName,String remarks)throws Exception{
		String query="INSERT into faculty (fac_name,remarks) values ('"+facName+"','"+remarks+"')";
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}
	public static int addDepartment(int facId,String deptName,String remarks)throws Exception{
		String query="INSERT into department (fac_id,dept_name,remarks) values ("+facId+",'"+deptName+"','"+remarks+"')";
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}
	public static int addProgram(int deptId,String progName,int semDuration,String remarks)throws Exception{
		String query="INSERT into program (dept_id,prog_name,duration_in_sem,remarks) values ('"+deptId+"','"+progName+"',"+semDuration+",'"+remarks+"')";
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}
	public static int addBatch(int progId,int batchYear,String shift,String groupDesc,String remarks)throws Exception{
		String query="INSERT into batch (prog_id,batch_year,shift,group_desc,remarks) values ("+progId+","+batchYear+",'"+shift+"','"+groupDesc+"','"+remarks+"')";
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}
	public static int addStudent(int batchId,String stdName,String fName,String surname,String rollNo,String gender,String remarks)throws Exception{
		String query="INSERT into student (batch_id,std_name,fname,surname,roll_no,gender,remarks) values ("+batchId+",'"+stdName+"','"+fName+"','"+surname+"','"+rollNo+"','"+gender+"','"+remarks+"')";
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}


        public static int addBook(int deptId,String bookTitle,String author,String publisher,String edition,int yearOfPublishing,int quantity,String isbn,String accessNo,int price,String dateOfPurchase,String purchaseFrom,String remarks)throws Exception{
                        dateOfPurchase="#"+dateOfPurchase+"#";
                    if(dateOfPurchase.trim().equals(""))
                     dateOfPurchase=null;
            String query="INSERT into book (dept_id,book_title,author,publisher,edition_volume,year_of_publishing,quantity,isbn,access_no,price,date_of_purchase,purchase_from,remarks) values ("+deptId+",'"+bookTitle+"','"+author+"','"+publisher+"','"+edition+"',"+yearOfPublishing+","+quantity+",'"+isbn+"','"+accessNo+"',"+price+","+dateOfPurchase+",'"+purchaseFrom+"','"+remarks+"')";
            System.out.println(query);
            
            Statement st=null;
            try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
            }finally{
                if(st!=null)
                    st.close();
            }
        }
        public static int addBookIssue(int bookId,int stdId,String dateOfIssue,String dateOfReturn,int fine,String remarks)throws Exception{
            dateOfIssue="#"+dateOfIssue+"#";
            if(dateOfReturn.trim().equals(""))
                dateOfReturn=null;
            else
               dateOfReturn="#"+dateOfReturn+"#";
    
            String query="INSERT into book_issue (book_id,std_id,date_of_issue,date_of_return,fine,remarks) values ("+bookId+","+stdId+","+dateOfIssue+","+dateOfReturn+","+fine+",'"+remarks+"')";
            System.out.println(query);
            
            Statement st=null;
            try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
            }finally{
                if(st!=null)
                    st.close();
            }
        }        
	public static int deleteFaculty(int facId)throws Exception{
		String query="DELETE from faculty where fac_id="+facId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}
	public static int deleteDepartment(int deptId)throws Exception{
		String query="DELETE from department where dept_id="+deptId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}
	public static int deleteProgram(int progId)throws Exception{
		String query="DELETE from program where prog_id="+progId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}
	public static int deleteBatch(int batchId)throws Exception{
		String query="DELETE from batch where batch_id="+batchId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}
	public static int deleteStudent(int StdId)throws Exception{
		String query="DELETE from student where std_id="+StdId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}
	public static int deleteBook(int bookId)throws Exception{
		String query="DELETE from book where prog_id="+bookId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}   
	public static int deleteBookIssue(int IssueId)throws Exception{
		String query="DELETE from book_issue where issue_id="+IssueId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}        
        
	public static int updateFaculty(int facId,String facName,String remarks)throws Exception{
		String query="UPDATE faculty set fac_name='"+facName+"' , remarks='"+remarks+"' where fac_id="+facId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}
	public static int updateDepartment(int deptId,String deptName,String remarks)throws Exception{
		String query="UPDATE department set dept_name='"+deptName+"' , remarks='"+remarks+"' where dept_id="+deptId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}
	public static int updateProgram(int progId,String progName,int semDuration,String remarks)throws Exception{
		String query="UPDATE program set prog_name='"+progName+"' , duration_in_sem="+semDuration+" , remarks='"+remarks+"' where prog_id="+progId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}
	public static int updateBatch(int batchId,int batchYear,String shift,String groupDesc,String remarks)throws Exception{
		String query="UPDATE batch set batch_year='"+batchYear+"' ,shift='"+shift+"' ,group_desc='"+groupDesc+"' , remarks='"+remarks+"' where batch_id="+batchId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}
	public static int updateStudent(int stdId,String stdName,String fName,String surname,String rollNo,String remarks)throws Exception{
		String query="UPDATE student set std_name='"+stdName+"' ,fname='"+fName+"' ,surname='"+surname+"' ,roll_no='"+rollNo+"' , remarks='"+remarks+"' where std_id="+stdId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}
  public static int updateBook(int bookId,String bookTitle,String author,String publisher,String edition,int yearOfPublishing,int quantity,String isbn,String accessNo,int price,String dateOfPurchase,String purchaseFrom,String remarks)throws Exception{
                    dateOfPurchase="#"+dateOfPurchase+"#";
                    if(dateOfPurchase.trim().equals(""))
                     dateOfPurchase=null;
      String query="Update book set book_title='"+bookTitle+"' , author = '"+author+"' , publisher = '"+publisher+"' , edition_volume = '"+edition+"' , year_of_publishing = "+yearOfPublishing+" , quantity = "+quantity+" , isbn = '"+isbn+"' , access_no = '"+accessNo+"' , price = "+price+" , date_of_purchase = "+dateOfPurchase+" , purchase_from = '"+purchaseFrom+"' , remarks = '"+remarks+"' where book_id = "+bookId; 
                System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
  } 
    public static int updateBookIssue(int bookId,int stdId,int issueId,String dateOfIssue,String dateOfReturn,int fine,String remarks)throws Exception{
                String query="Update book_issue set date_of_issue='"+dateOfIssue+"' , date_of_return = '"+dateOfReturn+"' , fine = "+fine+" , remarks = '"+remarks+"' where book_id = "+bookId+" and std_id="+stdId+" and issue_id="+issueId; 
                System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
  } 
   
   //subint.karbi@outlook.com 1111

	public static Vector getFaculty()throws Exception{
		String query="select * from faculty";
		System.out.println(query);
		Statement st=null;
		ResultSet result=null;
		try{
			st=con.createStatement();
			result=st.executeQuery(query);
			Vector v=new Vector();
			while(result.next()){
				FacultyBean bean=new FacultyBean();	
				bean.setFacId( result.getInt("fac_id") );
				bean.setFacName( result.getString("fac_name") );
				bean.setRemarks( result.getString("remarks") );			
				v.addElement(bean);
			}
			return v;
		}finally{
			if(result!=null)result.close();
			if(st!=null)st.close();
		}
	}
	public static Vector getDepartment(int facId)throws Exception{
		String query="select * from department where fac_id= "+facId ;
		System.out.println(query);
		Statement st=null;
		ResultSet result=null;
		try{
			st=con.createStatement();
			result=st.executeQuery(query);
			Vector v=new Vector();
			while(result.next()){
				DepartmentBean bean=new DepartmentBean();	
				bean.setDeptId( result.getInt("dept_id") );
				bean.setFacId( result.getInt("fac_id") );
				bean.setDeptName( result.getString("dept_name") );
				bean.setRemarks( result.getString("remarks") );			
				v.addElement(bean);
			}
			return v;
		}finally{
			if(result!=null)result.close();
			if(st!=null)st.close();
		}
	}
	public static Vector getProgram(int deptId)throws Exception{
		String query="select * from program where dept_id="+deptId;
		System.out.println(query);
		Statement st=null;
		ResultSet result=null;
		try{
			st=con.createStatement();
			result=st.executeQuery(query);
			Vector v=new Vector();
			while(result.next()){
				ProgramBean bean=new ProgramBean();	
				bean.setProgId( result.getInt("prog_id") );
				bean.setDeptId( result.getInt("dept_id") );
				bean.setProgName( result.getString("prog_name") );
				bean.setSemDuration( result.getInt("duration_in_sem"));
				bean.setRemarks( result.getString("remarks") );			
				v.addElement(bean);
			}
			return v;
		}finally{
			if(result!=null)result.close();
			if(st!=null)st.close();
		}
	}
	public static Vector getBatch(int progId)throws Exception{
		String query="select * from batch where prog_id="+progId;
		System.out.println(query);
		Statement st=null;
		ResultSet result=null;
		try{
			st=con.createStatement();
			result=st.executeQuery(query);
			Vector v=new Vector();
			while(result.next()){
				BatchBean bean=new BatchBean();	
				bean.setBatchId( result.getInt("batch_id") );
				bean.setProgId( result.getInt("prog_id") );
				bean.setBatchYear( result.getInt("batch_year") );
				bean.setShift( result.getString("shift") );
				bean.setGroupDesc( result.getString("group_desc") );
				bean.setRemarks( result.getString("remarks") );			
				v.addElement(bean);
			}
			return v;
		}finally{
			if(result!=null)result.close();
			if(st!=null)st.close();
		}
	}
        	public static Vector getBatch()throws Exception{
		String query="select * from batch ";
		System.out.println(query);
		Statement st=null;
		ResultSet result=null;
		try{
			st=con.createStatement();
			result=st.executeQuery(query);
			Vector v=new Vector();
			while(result.next()){
				BatchBean bean=new BatchBean();	
				bean.setBatchId( result.getInt("batch_id") );
				bean.setProgId( result.getInt("prog_id") );
				bean.setBatchYear( result.getInt("batch_year") );
				bean.setShift( result.getString("shift") );
				bean.setGroupDesc( result.getString("group_desc") );
				bean.setRemarks( result.getString("remarks") );			
				v.addElement(bean);
			}
			return v;
		}finally{
			if(result!=null)result.close();
			if(st!=null)st.close();
		}
	}
	public static Vector getStudent(int batchId)throws Exception{
		String query="select * from student where batch_id= "+batchId;
		System.out.println(query);
		Statement st=null;
		ResultSet result=null;
		try{
			st=con.createStatement();
			result=st.executeQuery(query);
			Vector v=new Vector();
			while(result.next()){
				StudentBean bean=new StudentBean();	
				bean.setStdId( result.getInt("std_id") );
				bean.setBatchId( result.getInt("batch_id") );
				bean.setName( result.getString("std_name") );
				bean.setFname( result.getString("fname") );
				bean.setSurname( result.getString("surname") );
				bean.setRollNo( result.getString("roll_no") );
                                bean.setGender(result.getString("gender"));
				bean.setRemarks( result.getString("remarks") );			
				v.addElement(bean);
			}
			return v;
		}finally{
			if(result!=null)result.close();
			if(st!=null)st.close();
		}
	}    
  public static Vector getStudent()throws Exception{
		String query="select * from student ";
		System.out.println(query);
		Statement st=null;
		ResultSet result=null;
		try{
			st=con.createStatement();
			result=st.executeQuery(query);
			Vector v=new Vector();
                        int sno=0;
			while(result.next()){
                            sno++;
				StudentBean bean=new StudentBean();	
				bean.setSerialNum(sno);
                                
                                bean.setStdId( result.getInt("std_id") );
				bean.setBatchId( result.getInt("batch_id") );
				bean.setName( result.getString("std_name") );
				bean.setFname( result.getString("fname") );
				bean.setSurname( result.getString("surname") );
				bean.setRollNo( result.getString("roll_no") );
                                bean.setGender(result.getString("gender"));
				bean.setRemarks( result.getString("remarks") );	
                                //bean.setSerialNum(result.getInt("serial_num"));
				v.addElement(bean);
			}
			return v;
		}finally{
			if(result!=null)result.close();
			if(st!=null)st.close();
		}
	}          
	public static Vector getGender(String rollNo)throws Exception{
		String query="select * from student where roll_no= "+rollNo;
		System.out.println(query);
		Statement st=null;
		ResultSet result=null;
		try{
			st=con.createStatement();
			result=st.executeQuery(query);
			Vector v=new Vector();
			while(result.next()){
				StudentBean bean=new StudentBean();	
				bean.setStdId( result.getInt("std_id") );
				bean.setBatchId( result.getInt("batch_id") );
				bean.setName( result.getString("std_name") );
				bean.setFname( result.getString("fname") );
				bean.setSurname( result.getString("surname") );
				bean.setRollNo( result.getString("roll_no") );
                                bean.setGender(result.getString("gender"));
				bean.setRemarks( result.getString("remarks") );			
				v.addElement(bean);
			}
			return v;
		}finally{
			if(result!=null)result.close();
			if(st!=null)st.close();
		}
	}   
  	/*public static Vector getRollNo(int batchId,int part,int examYear)throws Exception{
		String query="select * from seat_list where batch_id= "+batchId+" and part="+part+" and year="+examear;
		System.out.println(query);
		Statement st=null;
		ResultSet result=null;
		try{
			st=con.createStatement();
			result=st.executeQuery(query);
			Vector v=new Vector();
			while(result.next()){
				SeatListBean bean=new SeatListBean();
                                bean.setSlId(result.getInt("sl_id"));
                                bean.setBatchId( result.getInt("batch_id") );
				bean.setPart( result.getInt("part") );
                                bean.setYear(result.getInt("year"));
                                bean.setType( result.getString("type") );
                                bean.setPrepDate( result.getDate("prep_date") );
				bean.setRemarks( result.getString("remarks") );			
				v.addElement(bean);
			}
			return v;
		}finally{
			if(result!=null)result.close();
			if(st!=null)st.close();
		}
	}        
       */
	      public static Vector getBook(int deptId)throws Exception{
      String query="select * from book where dept_id="+deptId;
      System.out.println(query);
      Statement st=null;
      ResultSet result=null;
      try{
          	st=con.createStatement();
		result=st.executeQuery(query);
		Vector v=new Vector();
                while(result.next()){
                    BookBean  bean = new BookBean (); 
                    bean.setBookId(result.getInt("book_id"));
                    bean.setBookTitle(result.getString("book_title"));
                    bean.setAuthor(result.getString("author"));
                    bean.setPublisher(result.getString("publisher"));
                    bean.setEdition(result.getString("edition_volume"));
                    bean.setYearOfPublishing(result.getInt("year_of_publishing"));
                    bean.setQuantity(result.getInt("quantity"));
                    bean.setIsbn(result.getString("isbn"));
                    bean.setAccessNo(result.getString("access_no"));
                    bean.setPrice(result.getInt("price"));
                    bean.setDateOfPurchase(result.getDate("date_of_purchase"));
                    bean.setPurchaseFrom(result.getString("purchase_from"));
                    bean.setRemarks(result.getString("remarks"));
                    v.addElement(bean);
                }
          return v;
      }finally{
              if(result!=null)result.close();;
              if(st!=null)st.close();;}
      }  

      public static Vector getBookIssue(int bookId)throws Exception{
      String query="select bi.book_id,bi.std_id,bi.issue_id,bi.date_of_issue,bi.date_of_return,bi.fine,bi.remarks,std_name,fname,surname,roll_no,gender from book_issue bi,student std where bi.std_id=std.std_id and book_id="+bookId;
      System.out.println(query);
     
      Statement st=null;
      ResultSet result=null;
      try{
          	st=con.createStatement();
		result=st.executeQuery(query);
		Vector v=new Vector();
                while(result.next()){
                    BookIssueBean  bean = new BookIssueBean ();
                    bean.setBookId(result.getInt("book_id"));
                    bean.setStdId(result.getInt("std_id"));
                    bean.setIssueId(result.getInt("issue_id"));
                    bean.setDateOfIssue(result.getDate("date_of_issue"));
                    bean.setDateOfReturn(result.getDate("date_of_return"));
                    bean.setFine(result.getInt("fine"));
                    bean.setRemarks(result.getString("remarks"));
                    
                    bean.setName(result.getString("std_name"));
                    bean.setFname(result.getString("fname"));
                    bean.setSurname(result.getString("surname"));
                    bean.setRollNo(result.getString("roll_no"));
                    bean.setGender(result.getString("gender"));
                         
                    v.addElement(bean);
                }
          return v;
      }finally{
              if(result!=null)result.close();;
              if(st!=null)st.close();;}
      }  
     public static Vector getDefaulterList(String dateOfIssue1,String dateOfIssue2)throws Exception{
            if(dateOfIssue1.trim().equals(""))
                     dateOfIssue1=null;
            else
                dateOfIssue1="#"+dateOfIssue1+"#";
            if(dateOfIssue2.trim().equals(""))
                     dateOfIssue2=null;
            else
                dateOfIssue2="#"+dateOfIssue2+"#";    
            
      String query="select roll_no,std_name,fname,surname,b.book_title,b.author,b.publisher,b.price from book_issue bi,book b,student std where bi.std_id=std.std_id and bi.book_id=b.book_id and date_of_issue>"+dateOfIssue1+" and date_of_issue<"+dateOfIssue2+" ";
      System.out.println(query);
   
      Statement st=null;
      ResultSet result=null;
      try{
          	st=con.createStatement();
	        result=st.executeQuery(query);
		Vector v=new Vector();
                BookIssueBean  bean =  null;
                while(result.next()){
                    bean = new BookIssueBean ();
                  // Vector vector=new Vector();
                    bean.setRollNo(result.getString("roll_no"));
                    bean.setName(result.getString("std_name"));
                    bean.setFname(result.getString("fname"));
                    bean.setSurname(result.getString("surname"));
                    bean.setBookTitle(result.getString("book_title"));
                    bean.setAuthor(result.getString("author"));
                    bean.setPublisher(result.getString("publisher"));
                    bean.setPrice(result.getInt("price"));
                    v.addElement(bean);
         //==================================================================                  
//                    obj={result.getString("roll_no"),
//                                  result.getString("std_name"), 
//                                  result.getString("fname"),
//                                  result.getString("surname"),
//                                  result.getString("book_title"),
//                                  result.getString("author"),
//                                  result.getString("publisher"),
//                                  result.getInt("price")
//                                 };
        //=================================================================            
                   // System.out.println(obj + " " + result);
                    
//                    bean.setRollNo(result.getString("roll_no"));
//                    bean.setName(result.getString("std_name"));
//                    bean.setFname(result.getString("fname"));
//                    bean.setSurname(result.getString("surname"));
//                    bean.setBookTitle(result.getString("book_title"));
//                    bean.setAuthor(result.getString("author"));
//                    bean.setPublisher(result.getString("publisher"));
//                    bean.setPrice(result.getInt("price"));
                    
      //=====================================================================                 
                    
               
                }
          return v;
      }
      finally{
              if(result!=null)result.close();;
              if(st!=null)st.close();;
      }
            
}      
   

}

