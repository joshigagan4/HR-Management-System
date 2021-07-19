package com.thinking.machines.hr.pl.ui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.ListSelectionModel;
import javax.swing.table.*;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileFilter;
import java.util.*;
import com.thinking.machines.hr.pl.model.*;
import com.thinking.machines.hr.pl.exceptions.*;
import com.thinking.machines.hr.bl.interfaces.*;
import com.thinking.machines.hr.bl.exceptions.*;
import com.thinking.machines.hr.bl.pojo.*;
import com.thinking.machines.hr.bl.managers.*;
public class DesignationUI extends JFrame implements ListSelectionListener,DocumentListener
{
private JLabel titleLabel;
private JLabel searchLabel;
private JTextField searchTextField;
private JLabel foundAndNotFoundLabel;
private JButton crossButton;
private JTable table;
private JScrollPane jsp;
private DesignationModel model;
private JLabel designationLabel;
private JLabel designationDisplayLabel;
private JTextField designationTextField;
private JButton aButton;
private JButton eButton;
private JButton cButton;
private JButton dButton;
private JButton pButton; 
private Container container;
private JFileChooser fileChooser;
private int status;
private FileNameExtensionFilter f1,f2;
int a=1;
public DesignationUI()
{
model=new DesignationModel();
setTitle("HR Automation System");
titleLabel=new JLabel("Designation Master");
Font titleFont=new Font("Verdana",Font.BOLD,24);
titleLabel.setFont(titleFont);
searchLabel=new JLabel("Search");
Font searchFont=new Font("Verdana",Font.BOLD,22);
searchLabel.setFont(searchFont);
searchTextField=new JTextField();
searchTextField.getDocument().addDocumentListener(this);
foundAndNotFoundLabel=new JLabel("Not Found");
foundAndNotFoundLabel.setVisible(false);
Font fnfFont=new Font("Times New Roman",Font.BOLD,12);
foundAndNotFoundLabel.setFont(fnfFont);
foundAndNotFoundLabel.setForeground(Color.RED);
crossButton=new JButton(new ImageIcon("c:\\HR\\pl\\classes\\images\\cross_Icon.png"));
crossButton.setBorder(null);
crossButton.setBackground(Color.white);
crossButton.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent actionEvent)
{
if(actionEvent.getSource()==crossButton)
{
searchTextField.setText("");
searchTextField.requestFocus();
foundAndNotFoundLabel.setVisible(false);
table.clearSelection();
}
}
});
table=new JTable(model);
table.setForeground(Color.black);
JTableHeader tableHeader=table.getTableHeader();
Font tableHeaderFont=new Font("Verdana",Font.BOLD,14);
tableHeader.setFont(tableHeaderFont);
tableHeader.setForeground(Color.black);
//tableHeader.setBackground(Color.black);
table.getTableHeader().setReorderingAllowed(false);
tableHeader.setResizingAllowed(false);
table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
ListSelectionModel selectedRow=table.getSelectionModel();
selectedRow.addListSelectionListener(this);
table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
TableColumnModel columnModel=table.getColumnModel();
columnModel.getColumn(0).setPreferredWidth(150);
columnModel.getColumn(1).setPreferredWidth(290+140);
jsp=new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
Border blackline=BorderFactory.createLineBorder(Color.black);
table.setRowHeight(20);
Font tableFont=new Font("times new roman",Font.BOLD,24);
//table.setFont(tableFont);
aButton=new JButton(new ImageIcon("c:\\HR\\pl\\classes\\images\\add_Icon.png"));
eButton=new JButton(new ImageIcon("c:\\HR\\pl\\classes\\images\\edit_Icon.png"));
cButton=new JButton(new ImageIcon("c:\\HR\\pl\\classes\\images\\cancel_Icon.png"));
dButton=new JButton(new ImageIcon("c:\\HR\\pl\\classes\\images\\delete_Icon.png"));
pButton=new JButton(new ImageIcon("c:\\HR\\pl\\classes\\images\\pdf_Icon.png"));
designationLabel=new JLabel("Designation :");
Font designationFont=new Font("Verdana",Font.BOLD,18);
designationLabel.setFont(designationFont);
designationDisplayLabel=new JLabel("");
Font designationDisplayFont=new Font("Verdana",Font.BOLD,16);
designationDisplayLabel.setFont(designationDisplayFont);
designationTextField=new JTextField();
designationTextField.setVisible(false);
int lm=10,tm=0;
titleLabel.setBounds(lm+210,tm+10,300,50);
foundAndNotFoundLabel.setBounds(lm+10+150+30+210+15+20+75,tm+10+40+5,300+100,30);
searchLabel.setBounds(lm+30+30,tm+10+40+10+10+10,200+100,30);
searchTextField.setBounds(lm+10+150+30,tm+10+40+10+10+10,300+100,30);
crossButton.setBounds(lm+10+150+30+50+100+100+100+50,tm+10+40+10+10+10,60,30);
jsp.setBounds(lm+30+30,tm+10+40+10+10+10+50,500+100,150);
designationLabel.setBounds(lm+30+30+50+30+20,tm+10+40+10+10+10+50+150+22,150,50);
designationDisplayLabel.setBounds(lm+30+30+100+100+25+30+5,tm+10+40+10+10+10+50+150+22,300,50);
designationTextField.setBounds(lm+30+30+50+100+100+25+30+20,tm+10+40+10+10+10+50+150+20,150,50);
aButton.setBounds(lm+30+30+30+50+50,tm+10+40+10+10+10+50+100+100+50+20,60,60);
eButton.setBounds(lm+30+30+30+50+50+10+10+50,tm+10+40+10+10+10+50+100+100+50+20,60,60);
cButton.setBounds(lm+30+30+30+50+50+10+20+100+10,tm+10+40+10+10+10+50+100+100+50+20,60,60);
dButton.setBounds(lm+30+30+30+50+50+10+30+150+10+10,tm+10+40+10+10+10+50+100+100+50+20,60,60);
pButton.setBounds(lm+30+30+30+50+50+10+40+200+10+20,tm+10+40+10+10+10+50+100+100+50+20,60,60);
JPanel buttonsPanel=new JPanel();
buttonsPanel.add(aButton);
buttonsPanel.add(eButton);
buttonsPanel.add(cButton);
buttonsPanel.add(dButton);
buttonsPanel.add(pButton);
buttonsPanel.setBorder(blackline);
buttonsPanel.setBounds(lm+30+30+30+50+20,tm+10+40+10+10+10+50+100+100+50,400,100);
JPanel detailsPanel=new JPanel();
detailsPanel.add(designationLabel);
detailsPanel.add(designationDisplayLabel);
detailsPanel.add(designationTextField);
detailsPanel.setBorder(blackline);
detailsPanel.setBounds(lm+30+30,tm+10+40+10+10+10+50+100+60,300+200+100,250);
JPanel fullPanel=new JPanel();
fullPanel.add(detailsPanel);
fullPanel.add(buttonsPanel);
container=getContentPane();
container.setLayout(null);
container.add(titleLabel);
container.add(searchLabel);
container.add(searchTextField);
container.add(foundAndNotFoundLabel);
container.add(crossButton);
container.add(jsp);
container.add(designationLabel);
container.add(designationDisplayLabel);
container.add(designationTextField);
container.add(aButton);
container.add(eButton);
container.add(cButton);
container.add(dButton);
container.add(pButton);
container.add(buttonsPanel);
container.add(detailsPanel);
container.add(fullPanel);
container.setBackground(Color.white);
if(model.getRowCount()==0)
{
eButton.setEnabled(false);
cButton.setEnabled(false);
dButton.setEnabled(false);
pButton.setEnabled(false);
crossButton.setEnabled(false);
searchTextField.setEnabled(false);
table.setEnabled(false);
}
if(model.getRowCount()!=0)
{
cButton.setEnabled(false);
}
aButton.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent actionEvent)
{
if(actionEvent.getSource()==aButton)
{
if(a==1)
{
//table.clearSelection();
foundAndNotFoundLabel.setVisible(false);
designationDisplayLabel.setVisible(false);
designationTextField.setVisible(true);
designationTextField.setEnabled(true);
designationTextField.setText("");
designationTextField.requestFocus();
crossButton.setEnabled(false);
searchTextField.setEnabled(false);
table.setEnabled(false);
eButton.setEnabled(false);
dButton.setEnabled(false);
pButton.setEnabled(false);
aButton.setEnabled(true);
aButton.setIcon(new ImageIcon("c:\\HR\\pl\\classes\\images\\save_Icon.png"));
cButton.setEnabled(true);
a=0;
}
else
{
try
{
if(designationTextField.getText().equals("")) 
{
JOptionPane.showMessageDialog(container, "Please enter a designation !");
}
DesignationInterface di=new Designation();
di.setTitle(designationTextField.getText());
model.add(di);
int rowIndex=model.indexOf(di);
table.setRowSelectionInterval(0, rowIndex);
table.scrollRectToVisible(table.getCellRect(rowIndex, 0, true));
JOptionPane.showMessageDialog(container, "Designation added" ,"Confirmation Message",JOptionPane.INFORMATION_MESSAGE);
crossButton.setEnabled(true);
searchTextField.setEnabled(true);
table.setEnabled(true);
eButton.setEnabled(true);
dButton.setEnabled(true);
pButton.setEnabled(true);
aButton.setEnabled(true);
aButton.setIcon(new ImageIcon("c:\\HR\\pl\\classes\\images\\add_Icon.png"));
cButton.setEnabled(false);
designationTextField.setText("");
designationTextField.setVisible(false);
designationDisplayLabel.setVisible(true);
a=1;
}catch(ModelException me)
{
JOptionPane.showMessageDialog(container, me.getMessage());
a=1;
}
}
}
}
});
cButton.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent actionEvent)
{
if(actionEvent.getSource()==cButton)
{
foundAndNotFoundLabel.setVisible(false);
designationDisplayLabel.setVisible(true);
designationTextField.setVisible(false);
crossButton.setEnabled(true);
searchTextField.setEnabled(true);
table.setEnabled(true);
eButton.setEnabled(true);
eButton.setIcon(new ImageIcon("c:\\HR\\pl\\classes\\images\\edit_Icon.png"));
dButton.setEnabled(true);
pButton.setEnabled(true);
aButton.setEnabled(true);
aButton.setIcon(new ImageIcon("c:\\HR\\pl\\classes\\images\\add_Icon.png"));
cButton.setEnabled(false);
a=1;
}
}
});
eButton.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent actionEvent)
{
if(actionEvent.getSource()==eButton)
{
if(table.getSelectionModel().isSelectionEmpty()) JOptionPane.showMessageDialog(container, "Please select a designation to update ");
else
{
if(a==1)
{
foundAndNotFoundLabel.setVisible(false);
designationDisplayLabel.setVisible(false);
designationTextField.setVisible(true);
designationTextField.setText(designationDisplayLabel.getText());
crossButton.setEnabled(false);
searchTextField.setEnabled(false);
table.setEnabled(true);
eButton.setEnabled(true);
eButton.setIcon(new ImageIcon("c:\\HR\\pl\\classes\\images\\update_Icon.png"));
dButton.setEnabled(false);
pButton.setEnabled(false);
aButton.setEnabled(false);
cButton.setEnabled(true);
a=0;
}
else
{
try
{
DesignationInterface di=new Designation();
int index=table.getSelectedRow();
di=model.getDesignationAt(index);
di.setTitle(designationTextField.getText());
model.update(di);
int rowIndex=model.indexOf(di);
table.setRowSelectionInterval(0, rowIndex);
table.scrollRectToVisible(table.getCellRect(rowIndex, 0, true));
JOptionPane.showMessageDialog(container, " Designation updated " ,"Confirmation Message",JOptionPane.INFORMATION_MESSAGE);
crossButton.setEnabled(true);
searchTextField.setEnabled(true);
table.setEnabled(true);
eButton.setEnabled(true);
eButton.setIcon(new ImageIcon("c:\\HR\\pl\\classes\\images\\edit_Icon.png"));
dButton.setEnabled(true);
pButton.setEnabled(true);
aButton.setEnabled(true);
cButton.setEnabled(false);
designationTextField.setText("");
designationTextField.setVisible(false);
designationDisplayLabel.setVisible(true);
a=1;
}catch(ModelException me)
{
JOptionPane.showMessageDialog(container, me.getMessage());
a=1;
}
}
}
}
}
});
dButton.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent av)
{
if(av.getSource()==dButton)
{
String titleSelectedToDelete=null;
if(table.getSelectionModel().isSelectionEmpty())
{
JOptionPane.showMessageDialog(container,"Please select a designation to delete ");
}
else
{
table.setEnabled(false);
searchTextField.setEnabled(true);
crossButton.setEnabled(true);
aButton.setEnabled(false);
eButton.setEnabled(false);
pButton.setEnabled(false);
cButton.setEnabled(true);
try
{
titleSelectedToDelete=model.getDesignationAt(table.getSelectedRow()).getTitle();
}catch(ModelException modelException)
{
System.out.println(modelException);
}
int result=JOptionPane.showConfirmDialog(null," Do you want to delete "+titleSelectedToDelete,"Alert",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE );
if(result==JOptionPane.YES_OPTION)
{
try
{
model.delete(model.getDesignationAt(table.getSelectedRow()).getCode());
}catch(ModelException modelException)
{
JOptionPane.showMessageDialog(container, modelException.getMessage() ,"Error",JOptionPane.ERROR_MESSAGE);
}
JOptionPane.showMessageDialog(container, "Designation deleted" ,"Confirmation Message",JOptionPane.INFORMATION_MESSAGE);
//table.setRowSelectionInterval(0 ,0);
table.setEnabled(true);
table.clearSelection();
aButton.setEnabled(true);
eButton.setEnabled(true);
dButton.setEnabled(true);
cButton.setEnabled(false);
pButton.setEnabled(true);
searchTextField.setEnabled(true);
crossButton.setEnabled(true);
designationLabel.setVisible(true);
designationDisplayLabel.setText("");
foundAndNotFoundLabel.setEnabled(false);
}
if(result==JOptionPane.NO_OPTION)
{
jsp.setEnabled(true);
table.setEnabled(true);
table.clearSelection();
aButton.setEnabled(true);
eButton.setEnabled(true);
cButton.setEnabled(false);
dButton.setEnabled(true);
pButton.setEnabled(true);
searchTextField.setEnabled(true);
crossButton.setEnabled(true);
designationLabel.setVisible(true);
designationDisplayLabel.setText("");
foundAndNotFoundLabel.setEnabled(false);
//table.setRowSelectionInterval(0 ,0);
}
}
}
}
});
pButton.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent actionEvent)
{
fileChooser=new JFileChooser();
status=fileChooser.showSaveDialog(null);
if(status==JFileChooser.APPROVE_OPTION)
{
File file=fileChooser.getSelectedFile();
if(!(new File(file.getParent()).isDirectory()))
{
JOptionPane.showMessageDialog(null,"Invalid path");
return;
}
if(file.exists())
{
int confirm=JOptionPane.showConfirmDialog(null,file.getName()+" already exists! Would you like to overwrite it?","File already exists",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
if(confirm!=JOptionPane.YES_OPTION)return;
}
String filename=file.getPath();
int i=filename.lastIndexOf(".");
if(i==(-1))
{
filename=filename+".pdf";
file = new File(file.getPath() +".pdf");
fileChooser.setSelectedFile(file);
}
else
{

}
fileChooser.setAcceptAllFileFilterUsed(false);
f1=new FileNameExtensionFilter("PDF files","pdf");
fileChooser.addChoosableFileFilter(f1);
model.exportToPdf(file);
JOptionPane.showMessageDialog(null,"PDF created in  "+file.getPath(),"Information",JOptionPane.INFORMATION_MESSAGE);
}
}
});
int width=800;
int height=600;
setSize(width,height);
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
setDefaultCloseOperation(EXIT_ON_CLOSE);
setLocation((d.width/2)-(width/2),(d.height/2)-(height/2));
}
public void changedUpdate(DocumentEvent de)
{
foundAndNotFoundLabel.setText("Found");
foundAndNotFoundLabel.setVisible(true);
searchDesignation();
}
public void removeUpdate(DocumentEvent de)
{
foundAndNotFoundLabel.setText("Found");
foundAndNotFoundLabel.setVisible(true);
searchDesignation();
}
public void insertUpdate(DocumentEvent de)
{
foundAndNotFoundLabel.setText("Found");
foundAndNotFoundLabel.setVisible(true);
searchDesignation();
}
public void searchDesignation()
{
DesignationInterface designationInterface=new Designation();
try
{
designationInterface=model.getDesignation(searchTextField.getText(),false,true);
int index=model.indexOf(designationInterface);
table.setRowSelectionInterval(0,index);
table.scrollRectToVisible(table.getCellRect(index,0,true));
}catch(ModelException me)
{
table.clearSelection();
foundAndNotFoundLabel.setText("Not Found");
foundAndNotFoundLabel.setVisible(true);
}
}
public void valueChanged(ListSelectionEvent lse)
{
ListSelectionModel m=(ListSelectionModel) lse.getSource();
int rowSelected=m.getMinSelectionIndex();
try
{
designationDisplayLabel.setText(model.getDesignationAt(rowSelected).getTitle());
}catch(ModelException modelException)
{
System.out.println(modelException.getMessage());
a=1;
}
}
}