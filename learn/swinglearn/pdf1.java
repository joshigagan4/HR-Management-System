import java.io.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
class pdf1
{
public static void main(String gg[]) throws FileNotFoundException,DocumentException
{
Document document=new Document();
Font font=FontFactory.getFont(FontFactory.TIMES,18f,Font.ITALIC,BaseColor.RED);
PdfWriter.getInstance(document,new  FileOutputStream("FirstPDF.pdf"));
document.open();
Paragraph left=new Paragraph("This is left",font);
left.setAlignment(Element.ALIGN_LEFT);
document.add(left);
Paragraph right=new Paragraph("This is right",font);
right.setAlignment(Element.ALIGN_RIGHT);
document.add(right);
Paragraph center=new Paragraph("This is center",font);
center.setAlignment(Element.ALIGN_CENTER);
document.add(center);
document.close();
}
}