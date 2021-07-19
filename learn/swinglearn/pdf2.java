import java.io.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
class pdf2
{
public static void main(String gg[]) 
{
try
{
Document document=new Document(PageSize.A4,50,50,50,50);
PdfWriter.getInstance(document,new FileOutputStream("SecondPDF.pdf"));
document.open();
Font font =FontFactory.getFont(FontFactory.TIMES,18f,Font.BOLD,BaseColor.RED);
Font font1 =FontFactory.getFont(FontFactory.TIMES,15f,Font.ITALIC,BaseColor.GREEN);
PdfPTable table=new PdfPTable(3);
PdfPCell title1=new PdfPCell(new Paragraph("ID",font));
PdfPCell title2=new PdfPCell(new Paragraph("Name",font));
PdfPCell title3=new PdfPCell(new Paragraph("Enrollment No.",font));
PdfPCell id1=new PdfPCell(new Paragraph("101",font1));
PdfPCell id2=new PdfPCell(new Paragraph("102",font1));
PdfPCell id3=new PdfPCell(new Paragraph("103",font1));
PdfPCell name1=new PdfPCell(new Paragraph("Akshat",font1));
PdfPCell name2=new PdfPCell(new Paragraph("Rajat",font1));
PdfPCell name3=new PdfPCell(new Paragraph("Anamika",font1));
PdfPCell e1=new PdfPCell(new Paragraph("EMP10001",font1));
PdfPCell e2=new PdfPCell(new Paragraph("EMP10003",font1));
PdfPCell e3=new PdfPCell(new Paragraph("EMP10004",font1));
table.addCell(title1);
table.addCell(title2);
table.addCell(title3);
table.addCell(id1);
table.addCell(name1);
table.addCell(e1);
table.addCell(id2);
table.addCell(name2);
table.addCell(e2);
table.addCell(id3);
table.addCell(name3);
table.addCell(e3);
table.setWidthPercentage(100);
document.add(table);
document.close();
System.out.println("PDF Created ....");
}catch(Exception e)
{
 e.printStackTrace();
}
}
}
