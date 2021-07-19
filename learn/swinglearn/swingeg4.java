import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
class aaa extends JFrame implements DocumentListener
{
private JTextField t1;
aaa()
{
t1=new JTextField(20);
t1.getDocument().addDocumentListener(this);
Container c=getContentPane();
c.setLayout(new FlowLayout());
c.add(t1);
setLocation(10,10);
setSize(400,400);
setVisible(true);
}
public void changedUpdate(DocumentEvent ev)
{
System.out.println("changedUpdate got called");
searchDesignation();
}
public void removeUpdate(DocumentEvent ev)
{
System.out.println("removeUpdate got called");
searchDesignation();
}
public void insertUpdate(DocumentEvent ev)
{
System.out.println("insertUpdate got called");
searchDesignation();
}
private void searchDesignation()
{
}
public static void main(String gg[])
{
aaa a=new aaa();
}
}