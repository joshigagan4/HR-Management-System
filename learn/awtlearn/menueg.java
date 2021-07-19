import java.awt.*;
import java.awt.event.*;
class aaa extends Frame implements ActionListener
{
private MenuItem mi1,mi2,mi3,mi4,mi5,mi6,mi7,mi8,mi9,mi10,mi11,mi12,mi13,mi14,mi15,mi16,mi17,mi18;
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

m1=new Menu("Master");
m2=new Menu("Transaction");
m3=new Menu("Designation");
m4=new Menu("Employee");
m5=new Menu("Bank Account Details");

mi1=new MenuItem("Add Designation");
mi2=new MenuItem("Edit Designation");
mi3=new MenuItem("Delete Designation");
mi4=new MenuItem("get Count of Designations");
mi5=new MenuItem("Search by Code");
mi6=new MenuItem("Search by Title");
mi7=new MenuItem("Add Employee");
mi8=new MenuItem("Edit Employee");
mi9=new MenuItem("Delete Employee");
mi10=new MenuItem("get Employees");
mi11=new MenuItem("get by Employee Id");
mi12=new MenuItem("get by Pan Number");
mi13=new MenuItem("get by Aadhar Card Number");
mi14=new MenuItem("Exit");
mi15=new MenuItem("Account Number");
mi16=new MenuItem("IFSC Code");
mi17=new MenuItem("Branch");
mi18=new MenuItem("Exit");
mi14.addActionListener(this);
mi18.addActionListener(this);
mi1.addActionListener(this);

m3.add(mi1);
m3.add(mi2);
m3.add(mi3);
m3.add(mi4);
m3.add(mi5);
m3.add(mi6);
m1.add(m3);
m4.add(mi7);
m4.add(mi8);
m4.add(mi9);
m4.add(mi10);
m4.add(mi11);
m4.add(mi12);
m4.add(mi13);
m1.add(m4);
m1.add(mi14);
m5.add(mi15);
m5.add(mi16);
m5.add(mi17);
m2.add(m5);
m2.add(mi18);
mb=new MenuBar();
mb.add(m1);
mb.add(m2);
setMenuBar(mb);

setLocation(10,20);
setSize(500,400);
setVisible(true);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==mi14)
{
System.exit(0);
}
if(ae.getSource()==mi18)
{
System.exit(0);
}
if(ae.getSource()==mi1)
{
Frame frame=new Frame("Designation Add");
WindowAdapter wa;
wa=new WindowAdapter(){
public void windowClosing(WindowEvent we)
{
frame.dispose();
}
};
frame.addWindowListener(wa);
frame.setLocation(10,20);
frame.setSize(500,400);
frame.setVisible(true);
}
}
public static void main(String gg[])
{
aaa a=new aaa();
}
}