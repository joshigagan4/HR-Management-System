import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;// f small c small
import javax.swing.filechooser.FileFilter;
class aaa extends JFrame implements ActionListener
{
private JButton b1,b2;
private Container container;
private Dimension d;
private JFileChooser fileChooser;
private int status;
private FileNameExtensionFilter f1,f2;
aaa()
{
fileChooser=new JFileChooser(){
public void approveSelection(){
File file=getSelectedFile();
if(!(new File(file.getParent()).isDirectory()) && getDialogType()==SAVE_DIALOG)
{
JOptionPane.showMessageDialog(null,"Invalid path");
return;
}
if(file.exists() && getDialogType()==SAVE_DIALOG)
{
int confirm=JOptionPane.showConfirmDialog(null,file.getName()+" already exists! Would you like to overwrite it?","File already exists",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
if(confirm!=JOptionPane.YES_OPTION)return;
}
String filename=file.getPath();
int i=filename.lastIndexOf(".");
System.out.println(i);
if(i==(-1))
{
filename=filename+".pdf";
file = new File(file.getPath() +".pdf");
setSelectedFile(file);
}
else
{

}
super.approveSelection();
/*if(ext==null||(!ext.equals("pdf")))
{
file=new File(file.getPath()+"."+"pdf");
setSelectedFile(file);
}*/
}
};//current director dene ke liye
fileChooser.setAcceptAllFileFilterUsed(false);//All files wala option Remove krne ke liye
f1=new FileNameExtensionFilter("JAVA files","java");
f2=new FileNameExtensionFilter("PDF files","pdf");
fileChooser.addChoosableFileFilter(f1);
fileChooser.addChoosableFileFilter(f2);
b1=new JButton("save");
b2=new JButton("open");
b1.addActionListener(this);
b2.addActionListener(this);
container=getContentPane();
d=Toolkit.getDefaultToolkit().getScreenSize();
int w=600;
int h=600;
setLayout(new FlowLayout());
container.add(b1);
container.add(b2);
setSize(w,h);
setLocation((d.width/2)-(w/2),(d.height/2)-(h/2));
setVisible(true);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
status=fileChooser.showSaveDialog(null);
if(status==JFileChooser.APPROVE_OPTION)
{
File selectedFile=fileChooser.getSelectedFile();
System.out.println(selectedFile.getParent());
System.out.println(selectedFile.getName());
}
if(status==JFileChooser.CANCEL_OPTION)
{
System.out.println("Cancelled");
}
}
if(ae.getSource()==b2)
{
status=fileChooser.showOpenDialog(null);
if(status==JFileChooser.APPROVE_OPTION)
{
File selectedFile=fileChooser.getSelectedFile();
System.out.println(selectedFile.getParent());
System.out.println(selectedFile.getName());
}
if(status==JFileChooser.CANCEL_OPTION)
{
System.out.println("cancelled");
}
}
}
public static void main(String gg[])
{
aaa a=new aaa();
}
}