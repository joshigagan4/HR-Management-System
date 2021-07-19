import java.io.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*; 
import com.itextpdf.kernel.pdf.*;
class pdf3
{
public static void main(String gg[])
{
try
{
Document document=new Document(PageSize.A4,50,50,50,50);
PdfWriter.getInstance(document,new FileOutputStream("Image Formation"));
document.open();
Image img=Image.getInstance("c:\\HR\\swinglearn\\save.png");
document.add(new Paragraph("This is the icon of Save  Button"));
//document.newPage();
img.setFixedPosition(150,200);
document.add(img);
document.close();
System.out.println("Image Uploaded");
}catch(Exception e)
{
e.printStackTrace();
}
}
}