import java.awt.*;
import java.awt.event.*;
class aaa extends Frame implements ActionListener
{
private MenuItem mi1,mi2,mi3,mi4,mi5,mi6,mi7,mi8,mi9,mi10;
private Menu m1,m2,m3,m4,m5;
private MenuBar mb;
aaa()
{
WindowAdapter wa;
wa=new WindowAdapter(){
public void windowClosing(WindowEvent we)
{
System.exit(0);
}
};
addWindowListener(wa);

mi1=new MenuItem("Exit");
mi2=new MenuItem("Add");
mi3=new MenuItem("Update");
mi4=new MenuItem("Done");
mi5=new MenuItem("Id");
mi6=new MenuItem("PAN");
mi7=new MenuItem("Aadhar");
mi8=new MenuItem("Exit");
mi9=new MenuItem("Account Number");
mi10=new MenuItem("IFSC Code");
mi1.addActionListener(this);
mi8.addActionListener(this);
m1=new Menu("Master");
m2=new Menu("Student");
m3=new Menu("Employee");
m4=new Menu("Transaction");
m5=new Menu("Bank Account");

m2.add(mi2);
m2.add(mi3);
m2.add(mi4);
m3.add(mi5);
m3.add(mi6);
m3.add(mi7);
m4.add(m5);
m4.add(mi8);
m5.add(mi9);
m5.add(mi10);
m1.add(m2);
m1.add(m3);
m1.add(mi1);


mb=new MenuBar();
mb.add(m1);
mb.add(m4);
setMenuBar(mb);





setLocation(10,20);
setSize(500,400);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==mi1)
{
System.exit(0);
}
if(ae.getSource()==mi8)
{
System.exit(0);
}
}



public static void main(String gg[])
{
aaa a=new aaa();
a.setVisible(true);
}
}