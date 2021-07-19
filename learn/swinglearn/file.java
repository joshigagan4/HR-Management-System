



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser.*;
class file extends JFrame implements ActionListener
{
private JFrame frame;
private JButton button1;
private JButton button2;
FileNameExtensionFilter filter1;
FileNameExtensionFilter filter2;
file()
{
frame=new JFrame();
button1=new JButton("Save");
button1.addActionListener(this);
button2=new JButton("open");
button2.addActionListener(this);
setLayout(new FlowLayout());
setDefaultCloseOperation(EXIT_ON_CLOSE);
add(button1);
add(button2);
setVisible(true);
setLocation(300,150);
setSize(500,400);
}
public void actionPerformed(ActionEvent ae)
{
filter1=new FileNameExtensionFilter("PDF","pdf");
filter2=new FileNameExtensionFilter("MP4","mp4");
JFileChooser f=new JFileChooser();
f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
f.setCurrentDirectory(new java.io.File("."));
f.setAcceptAllFileFilterUsed(false);
f.addChoosableFileFilter(filter1);
f.addChoosableFileFilter(filter2);
if(ae.getSource()==button1)
{
if (f.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) 
{
System.out.println("getCurrentDirectory(): " + f.getCurrentDirectory());
System.out.println("getSelectedFile() : " + f.getSelectedFile());
} 
else 
{
System.out.println("No Selection ");
}
}
if(ae.getSource()==button2)
{
if (f.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
{
System.out.println("getCurrentDirectory(): " + f.getCurrentDirectory());
System.out.println("getSelectedFile() : " + f.getSelectedFile());
} 
else 
{
System.out.println("No Selection ");
}
}
}
public static void main(String gg[])
{
file f=new file();
}
}