import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
class EmployeeModel extends AbstractTableModel
{
private Object data[][];
private String title[];
EmployeeModel()
{
populateDataStructures();
}
private void populateDataStructures()
{
title=new String[3];
title[0]="Id.";
title[1]="Name";
title[2]="Indian";
data=new Object[5][3];
data[0][0]=101; //autoboxing and promotion
data[0][1]="Ramesh";
data[0][2]=true; //autoboxing and promotion
data[1][0]=102; //autoboxing and promotion
data[1][1]="Mahesh";
data[1][2]=true; //autoboxing and promotion
data[2][0]=103; //autoboxing and promotion
data[2][1]="John";
data[2][2]=false; //autoboxing and promotion
data[3][0]=104; //autoboxing and promotion
data[3][1]="Lalita";
data[3][2]=true; //autoboxing and promotion
data[4][0]=105; //autoboxing and promotion
data[4][1]="Tina";
data[4][2]=true; //autoboxing and promotion
}
public int getRowCount()
{
System.out.println("getRowCount got called ");
return data.length;
}
public int getColumnCount()
{
System.out.println("getColumnCount got called ");
return title.length;
}
public String getColumnName(int columnIndex)
{
return title[columnIndex];
}
public Object getValueAt(int rowIndex,int columnIndex)
{
System.out.println("getValueAt got called for"+rowIndex+","+columnIndex);
return data[rowIndex][columnIndex];
}
public boolean isCellEditable(int rowIndex,int columnIndex)
{
if(columnIndex==2) return true;
return false;
}
public Class getColumnClass(int columnIndex)
{
Class c=null;
if(columnIndex==0) c=Integer.class;
if(columnIndex==1) return String.class;
if(columnIndex==2) c=Boolean.class;
return c;
}
// the following method will be called when a cell is updated
public void setValueAt(Object d,int rowIndex,int columnIndex)
{
data[rowIndex][columnIndex]=d;
}
}
class EmployeeView extends JFrame
{
private Container container;
private EmployeeModel model;
private JTable table;
private JScrollPane jsp;
EmployeeView()
{
model=new EmployeeModel();
container=getContentPane();
table=new JTable(model);
jsp=new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
container.setLayout(new BorderLayout());
container.add(jsp,BorderLayout.CENTER);
int width=600;
int height=500;
setDefaultCloseOperation(EXIT_ON_CLOSE);
setSize(width,height);
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
setLocation((d.width/2)-(width/2),(d.height/2)-(height/2));
setVisible(true);
}
public static void main(String gg[])
{
EmployeeView e=new EmployeeView();
} 
}