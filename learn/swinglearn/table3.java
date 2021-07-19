import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.*;
import javax.swing.ListSelectionModel;
import javax.swing.event.*;
class StudentModel extends AbstractTableModel
{
private Object data[][];
private String title[];
StudentModel()
{
populateDataStructure();
}
private void populateDataStructure()
{
title=new String[5];
title[0]="RollNumber";
title[1]="Name";
title[2]="City";
title[3]="Gender";
title[4]="Indian";
data=new Object[5][5];
data[0][0]=101;
data[0][1]="Rahul";
data[0][2]="Indore";
data[0][3]="Male";
data[0][4]=true;
data[1][0]=102;
data[1][1]="Shraddha";
data[1][2]="Bhopal";
data[1][3]="Female";
data[1][4]=true;
data[2][0]=103;
data[2][1]="Omansh";
data[2][2]="Dewas";
data[2][3]="Male";
data[2][4]=false;
data[3][0]=104;
data[3][1]="Ramesh";
data[3][2]="Delhi";
data[3][3]="Male";
data[3][4]=true;
data[4][0]=105;
data[4][1]="Suresh";
data[4][2]="Pune";
data[4][3]="Male";
data[4][4]=false;
}
public int getRowCount()
{
return data.length;
}
public int getColumnCount()
{
return title.length;
}
public String getColumnName(int columnIndex)
{
return title[columnIndex];
}
public Object getValueAt(int rowIndex,int columnIndex)
{
return data[rowIndex][columnIndex];
}
public boolean isCellEditable(int rowIndex,int columnIndex)
{
return false;
}
public Class getColumnClass(int columnIndex)
{
Class c=null;	
if(columnIndex==0) c=Integer.class;
if(columnIndex==1) return String.class;
if(columnIndex==2) return String.class;
if(columnIndex==3) return String.class;
if(columnIndex==4) c=Boolean.class;
return c;
}
public void setValueAt(Object d,int rowIndex,int columnIndex)
{
data[rowIndex][columnIndex]=d;
}
}
class StudentView extends JFrame implements ListSelectionListener
{
private Container container;
private StudentModel studentmodel;
private JTable table;
private JScrollPane jsp;
StudentView()
{
studentmodel=new StudentModel();
container=getContentPane();
table=new JTable(studentmodel);
JTableHeader tableHeader=table.getTableHeader();
tableHeader.setResizingAllowed(false);
Font titleFont=new Font("Verdana",Font.BOLD,14);
tableHeader.setFont(titleFont);
table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
ListSelectionModel selectedRow=table.getSelectionModel();
selectedRow.addListSelectionListener(this);
table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
TableColumnModel columnModel=table.getColumnModel();
columnModel.getColumn(0).setPreferredWidth(120);
columnModel.getColumn(1).setPreferredWidth(120);
columnModel.getColumn(2).setPreferredWidth(120);
columnModel.getColumn(3).setPreferredWidth(120);
columnModel.getColumn(4).setPreferredWidth(120);
//setJTableColumnWidth(table,100,100,100,100);
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
public void valueChanged(ListSelectionEvent lse)
{
ListSelectionModel model=(ListSelectionModel) lse.getSource();
int rowSelected=model.getMinSelectionIndex();
System.out.println("Row : "+ rowSelected +" is selected");
}
public static void main(String gg[])
{	
StudentView ev=new StudentView();
}
}