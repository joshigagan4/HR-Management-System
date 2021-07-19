import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.*;
import java.util.*;
class aaa extends JFrame 
{
private JButton clickButton;
private Container container;
aaa()
{
clickButton=new JButton("Click");
container=getContentPane();
container.setLayout(null);
container.add(clickButton);
int lm,tm;
int w=600;
int h=500;
lm=10;
tm=0;
clickButton.setBounds((w/2)-(60/2),tm+10+40+10+30+10+30+10+30+10+30+10+100+10+50,100,50);
clickButton.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ev)
{
//JOptionPane.showMessageDialog(container,"Employee Added");
//int n=JOptionPane.showConfirmDialog(container,"Do you want to continue ?","Confirmation",JOptionPane.YES_NO_OPTION);
JFileChooser j = new JFileChooser();
j.setAcceptAllFileFilterUsed(false); 
FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .pdf and .mp4 files", "pdf","mp4"); 
j.addChoosableFileFilter(restrict); 
j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
j.setCurrentDirectory(new java.io.File("."));
j.showSaveDialog(null); 
//j.showOpenDialog(null);
if (j.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) 
{
System.out.println("getCurrentDirectory(): " + j.getCurrentDirectory());
System.out.println("getSelectedFile() : " + j.getSelectedFile());
} 
else 
{
System.out.println("No Selection ");
}
}
});
setSize(w,h);
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
setDefaultCloseOperation(EXIT_ON_CLOSE);
setLocation((d.width/2)-(w/2),(d.height/2)-(h/2));
setVisible(true);
}
public static void main(String gg[])
{
aaa a=new aaa();
}
}