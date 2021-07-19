package com.thinking.machines.hr.pl.model;
//import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.io.*;
import java.net.*;
import com.itextpdf.text.Font;
import java.util.Date.*;
import java.text.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.Font.FontFamily;
import com.thinking.machines.hr.bl.managers.*;
import com.thinking.machines.hr.bl.pojo.*;
import com.thinking.machines.hr.bl.interfaces.*;
import com.thinking.machines.hr.bl.exceptions.*;
import com.thinking.machines.hr.pl.exceptions.*;
import com.thinking.machines.common.*;
import java.io.FileOutputStream.*;
public class DesignationModel extends AbstractTableModel
{
private String title[];
private java.util.List<DesignationInterface> l;
private DesignationManager dm;
public DesignationModel()
{
populateDataStructures();
}
public void populateDataStructures()
{
dm=DesignationManager.getDesignationManager();
try
{
l=dm.getDesignations();
}catch(BLException blException)
{
System.out.println(blException.getGenericException());
}
title=new String[2];
title[0]="S.No.";
title[1]="Designation";
}
public int getRowCount()
{
return l.size();
}
public int getColumnCount()
{
return 2;
}
public String getColumnName(int columnIndex)
{
return title[columnIndex];
}
public Object getValueAt(int rowIndex,int columnIndex)
{
if(columnIndex==0) return (rowIndex+1);
Object obj=l.get(rowIndex).getTitle();
return obj;
}
public boolean isCellEditable(int rowIndex,int columnIndex)
{
return false;
}
public Class getColumnClass(int columnIndex)
{
if(columnIndex==0) return Integer.class;
else
{
return String.class;
}
}
public DesignationInterface getDesignationAt(int e) throws ModelException
{
if(e<0 || e>=l.size()) throw new ModelException("Designation does not exists");
return l.get(e);
}
public void add(DesignationInterface dm) throws ModelException
{
try
{
DesignationManager d=DesignationManager.getDesignationManager();
d.add(dm);
l=d.getDesignations();
fireTableDataChanged();
}catch(BLException be)
{
java.util.List<String> list=be.getExceptions();
for(String i:list) throw new ModelException(i);
}
}
public void update(DesignationInterface dm) throws ModelException
{
try
{
DesignationManager d=DesignationManager.getDesignationManager();
d.update(dm);
l=d.getDesignations();
fireTableDataChanged();
}catch(BLException be)
{
java.util.List<String> list=be.getExceptions();
for(String i:list) throw new ModelException(i);
}
}
public void delete(int code) throws ModelException
{
try
{
DesignationManager d=DesignationManager.getDesignationManager();
d.delete(code);
l=d.getDesignations();
fireTableDataChanged();
}catch(BLException be)
{
java.util.List<String> list=be.getExceptions();
for(String i:list) throw new ModelException(i);
}
}


public int indexOf(DesignationInterface di) throws ModelException
{
int i;
for(i=0;i<l.size();i++)
{
if(di.equals(l.get(i)))
{
break;
}
}
return i;
}
public DesignationInterface getDesignation(String text,boolean caseSensitive,boolean partial) throws ModelException
{
int found=0;
int e=0;
if(caseSensitive==false)
{
while(e<l.size())
{
String d=l.get(e).getTitle().toLowerCase();
if(text.equalsIgnoreCase(d) || d.startsWith(text.toLowerCase()))
{
found=1;
break;
}
e++;
}
}
else
{
while(e<l.size())
{
String d=l.get(e).getTitle();
if(text.equals(d) || d.startsWith(text))
{
found=1;
break;
}
e++;
}
}
if(found==0)
{
throw new ModelException("Invalid Designation Entered");
}
DesignationInterface clone=new Designation();
POJOCopier.copy(clone,l.get(e));
return clone;
}
public void exportToPdf(File selectedFile)
{
try
{
DesignationInterface designation;
String title="";
Font titleFont;
Font dataFont;
titleFont=new Font(FontFamily.HELVETICA,15,Font.BOLD,BaseColor.RED);
dataFont=new Font(FontFamily.HELVETICA,10,Font.BOLD,BaseColor.BLACK);
PdfPTable table1=null;
int size=l.size();
int pageSize=25;
int noOfPages;
int sn=0;
int cp=0;
Document document=new Document();
int result=(size)%(pageSize);
if(result!=0)
{
noOfPages=(size/pageSize)+1;
}
else
{
noOfPages=(size/pageSize);
}//if else ends here
boolean newPage=true;
int i=0;
PdfWriter.getInstance(document,new FileOutputStream(selectedFile));
document.open();
while(i<size)
{
if(newPage==true)
{
cp++;
Font font =new Font(FontFamily.HELVETICA,20,Font.BOLD,BaseColor.GREEN);
PdfPTable table=new PdfPTable(2);
//table.setWidthPercentage(100);
table.setWidths(new int[]{2,24});
table.setTotalWidth(527);
table.setLockedWidth(true);
table.getDefaultCell().setFixedHeight(40);
Image img=Image.getInstance("c:\\HR\\pl\\classes\\images\\logo.jpg");
PdfPCell cell1=new PdfPCell(img,true);
cell1.setRowspan(2);
PdfPCell cell2=new PdfPCell(new Paragraph("G.J. InfoTech Inc.",font));
cell2.setRowspan(2);
cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
PdfPCell cell3=new PdfPCell(new Paragraph(" "));
cell3.setColspan(2);
PdfPCell cell4=new PdfPCell(new Paragraph("List Of Designations",new Font(FontFamily.HELVETICA,14,Font.BOLD,BaseColor.BLACK) ));
cell4.setColspan(2);
cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
PdfPCell cell5=new PdfPCell(new Paragraph("Page"+cp+"/"+noOfPages));
cell5.setColspan(2);
cell5.setHorizontalAlignment(Element.ALIGN_RIGHT);
cell1.setBorder(PdfPCell.NO_BORDER);
cell2.setBorder(PdfPCell.NO_BORDER);
cell3.setBorder(PdfPCell.NO_BORDER);
cell4.setBorder(PdfPCell.NO_BORDER);
cell5.setBorder(PdfPCell.NO_BORDER);
table.addCell(cell1);
table.addCell(cell2);
table.addCell(cell3);
table.addCell(cell4);
table.addCell(cell5);
document.add(table);
document.add(new Paragraph(" "));
document.add(new Paragraph(" "));
table1=new PdfPTable(2);
table1.setWidthPercentage(100);
table1.setTotalWidth(288);
table1.setLockedWidth(true);
//table.setTotalWidth(288);
//table.setLockedWidth(true);
//table.setWidths(new float[]{1,2,2});
table1.setWidths(new float[]{1,2});
PdfPCell id=new PdfPCell(new Paragraph("S.No.",new Font(FontFamily.HELVETICA,14,Font.BOLD,BaseColor.BLACK)));
PdfPCell designationTitle=new PdfPCell(new Paragraph("Designation",new Font(FontFamily.HELVETICA,14,Font.BOLD,BaseColor.BLACK)));
id.setHorizontalAlignment(Element.ALIGN_RIGHT);
designationTitle.setHorizontalAlignment(Element.ALIGN_CENTER);
table1.addCell(id);
table1.addCell(designationTitle);
newPage=false;
}
//extract ith object from ds
designation=l.get(i);
sn++;
title=designation.getTitle();
PdfPCell snCell=new PdfPCell(new Paragraph(" "+sn));
snCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
PdfPCell titleCell=new PdfPCell(new Paragraph(title,dataFont));
titleCell.setHorizontalAlignment(Element.ALIGN_LEFT);
table1.addCell(snCell);
table1.addCell(titleCell);
//footer
if((sn%pageSize)==0||sn==size)
{
document.add(table1);
document.add(new Paragraph(""));
document.add(new Paragraph(""));
document.add(new Paragraph(""));
document.add(new Paragraph("Software by:- Gagan Joshi",new Font(FontFamily.HELVETICA,15,Font.BOLD,BaseColor.BLACK)));
if(sn<size)
{
document.newPage();
newPage=true;
}
}
i++;
}//while loop ktm
document.close();
}catch(Exception e)
{

}
}
}