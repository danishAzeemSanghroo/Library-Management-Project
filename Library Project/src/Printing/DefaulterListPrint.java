/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Printing;


import BeanClasses.BookIssueBean;
import BeanClasses.StudentBean;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Vector;

/**
 *
 * @author Dani
 */
public class DefaulterListPrint{
    
    public DefaulterListPrint(Vector v){
        System.out.println(v.size());
        try{
            int perPage=22;
            int numOfStd=v.size();
            int totalPages=numOfStd/perPage;
            int lastPage=numOfStd%perPage;
            
                Book book= new Book();
                
                PageFormat pageFormat=getPageFormat();
               // PageFormat pageFormat1=getPageFormat();
                int n=0;
                
               
                 for(int p=1;p<=totalPages;p++){
                    StudentBean beans[]=new StudentBean[perPage];
                    for(int index=0;index<perPage;index++,n++){
                        beans[index]=(StudentBean)v.elementAt(n);
                        //beans[index].setSerialNum(n);                       
                    }
                    Document doc=new Document(beans);
                    book.append(doc, pageFormat);
                }
                
                StudentBean beans[]=new StudentBean[lastPage];
                for(int index=0;index<lastPage;index++){
                    beans[index]=(StudentBean)v.elementAt(n);
                    //beans[index].setSerialNum(n);
                }
                
                Document doc=new Document(beans);                
                book.append(doc, pageFormat);
                 
                PrinterJob printJob=PrinterJob.getPrinterJob();
                printJob.setPageable(book);
            
                if(printJob.printDialog())
                    printJob.print();
                
            }catch(PrinterException e){
                e.printStackTrace();
        }
    }

    private static PageFormat getPageFormat(){
    
        double PIXEL_PER_INCH=72;
            
            double PAPER_WIDTH=10.72*PIXEL_PER_INCH;
            double PAPER_HEIGHT=10.69*PIXEL_PER_INCH;
            
            double LEFT_MARGIN=0.01*PIXEL_PER_INCH;
            double RIGHT_MARGIN=0.01*PIXEL_PER_INCH;
            
            double TOP_MARGIN=0.01*PIXEL_PER_INCH;
            double BOTTOM_MARGIN=0.01*PIXEL_PER_INCH;
            
            Paper paper= new Paper();
            paper.setSize(PAPER_WIDTH, PAPER_HEIGHT);
           
            paper.setImageableArea(LEFT_MARGIN, TOP_MARGIN, (paper.getWidth())- (LEFT_MARGIN + RIGHT_MARGIN),(paper.getHeight())-(TOP_MARGIN +BOTTOM_MARGIN));
 
            
            PageFormat pageFormat=new PageFormat();
            pageFormat.setPaper(paper);
            
            pageFormat.setOrientation(PageFormat.PORTRAIT);
               
            return pageFormat; 
    }
    
    class Document extends Component implements Printable{
    
        StudentBean beans[];
       
        public Document (StudentBean beans[]){
           this.beans = beans;
           
        }
        
        
        @Override
        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
            try{
                
                Graphics2D g2d= (Graphics2D)graphics;
                g2d.translate(pageFormat.getImageableX(),pageFormat.getImageableY());
                g2d.setPaint(Color.BLACK);
                g2d.setColor(Color.BLACK);
                
                Font f=new Font("Arial",Font.BOLD,14);
                graphics.setFont(f);
                
                graphics.drawString("DEFAULTER LIST", 216, 20);
                g2d.drawLine(20, 36, 616, 36);
				
	
					
                Font f2=new Font("Arial",Font.BOLD,10);
                graphics.setFont(f2);
                int x=50;
                int z=10;
                graphics.drawString("S.No", 6, 46+z);
                graphics.drawString("ROLL NO.", 100+x, 46+z);
                graphics.drawString("NAME", 180+x, 46+z);
                graphics.drawString("F.NAME", 280+x, 46+z);
                graphics.drawString("SURNAME", 380+x, 46+z);
//                graphics.drawString("BOOK TITLE", 150+x, 46+z);
//                graphics.drawString("AUTHOR", 250+x, 46+z);
//                graphics.drawString("PUBLISHER", 380+x, 46+z);
//                graphics.drawString("PRICE", 530+x, 46+z);
                
                graphics.drawLine(20, 66, 616, 66);
				
				
				int y=77;
				//int serialNum=1;
                                
            
				for(int i=0; i<beans.length; i++){
                                  //BookIssueBean bean=(BookIssueBean)v.elementAt(i);
                                  // if(bean == null) break;
                                    
                                graphics.drawString(""+beans[i].getSerialNum(), 6, y+z);
				graphics.drawString(beans[i].getRollNo(), 100+x, y+z);
				graphics.drawString(beans[i].getName(), 180+x, y+z);
				graphics.drawString(beans[i].getFname(), 280+x, y+z);
				graphics.drawString(beans[i].getSurname(), 380+x, y+z);
//				graphics.drawString(bean.getBookTitle(), 150+x, y+z);
//                                graphics.drawString(bean.getAuthor(), 250+x, y+z);
//                                graphics.drawString(bean.getPublisher(), 380+x, y+z);
//                                graphics.drawString(""+bean.getPrice(), 530+x, y+z);
				y+=30;
                                //serialNum++;
				
				}
                                
                
            
            }catch(Exception e){
              e.printStackTrace();
            }
            return PAGE_EXISTS;
        }// print Method       
    }// Documents Class
	

	
}// Main Class    
    
