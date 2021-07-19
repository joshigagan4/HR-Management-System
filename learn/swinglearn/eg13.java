import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;// f small c small
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
fileChooser=new JFileChooser(".");//current director dene ke liye
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