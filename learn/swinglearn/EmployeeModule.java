import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
class EmployeeFrame extends JFrame
{
private JLabel titleLabel;
private JLabel nameCaptionLabel;
private JTextField nameTextField;
private JLabel genderCaptionLabel;
private ButtonGroup genderGroup;
private JRadioButton maleRadioButton;
private JRadioButton femaleRadioButton;
private JLabel indianCaptionLabel;
private JCheckBox isIndianCheckBox;
private JLabel citiesCaptionLabel;
private JComboBox citiesComboBox;
private JLabel hobbiesCaptionLabel;
private JList hobbiesList;
private Container container;
private ImageIcon frameIcon;
private ImageIcon saveButtonIcon;
private JButton saveButton;
EmployeeFrame()
{
titleLabel=new JLabel("Employee Management");
nameCaptionLabel=new JLabel("Name");
nameTextField=new JTextField();
genderCaptionLabel=new JLabel("Gender");
genderGroup=new ButtonGroup();
maleRadioButton=new JRadioButton("Male");
femaleRadioButton=new JRadioButton("Female");
genderGroup.add(maleRadioButton);
genderGroup.add(femaleRadioButton);
indianCaptionLabel=new JLabel("Indian");
isIndianCheckBox=new JCheckBox();
citiesCaptionLabel=new JLabel("City");
citiesComboBox=new JComboBox();
citiesComboBox.addItem("Pune");
citiesComboBox.addItem("Mumbai");
citiesComboBox.addItem("Delhi");
citiesComboBox.addItem("Indore");
citiesComboBox.addItem("Ujjain");
citiesComboBox.addItem("Dewas");
hobbiesCaptionLabel=new JLabel("Hobbies");
Vector<String> hobbies=new Vector<>();
hobbies.add("Reading");
hobbies.add("Movies");
hobbies.add("Drawing");
hobbies.add("Writing poems");
hobbiesList=new JList(hobbies);
frameIcon=new ImageIcon("logo.png");
saveButtonIcon=new ImageIcon("save.png");
saveButton=new JButton(saveButtonIcon);
setIconImage(frameIcon.getImage());
setTitle("HR Application");
Font titleFont=new Font("Verdana",Font.BOLD,22);
titleLabel.setFont(titleFont);
Font dataFont=new Font("Times New Roman",Font.PLAIN,18);
nameCaptionLabel.setFont(dataFont);
nameTextField.setFont(dataFont);
genderCaptionLabel.setFont(dataFont);
maleRadioButton.setFont(dataFont);
femaleRadioButton.setFont(dataFont);
indianCaptionLabel.setFont(dataFont);
citiesCaptionLabel.setFont(dataFont);
citiesComboBox.setFont(dataFont);
hobbiesCaptionLabel.setFont(dataFont);
hobbiesList.setFont(dataFont);
container=getContentPane();
container.setLayout(null);
int lm,tm;
int w=600;
int h=500;
lm=10;
tm=0;
titleLabel.setBounds(lm+10,tm+10,300,40);
nameCaptionLabel.setBounds(lm+10,tm+10+40+10,150,30);
nameTextField.setBounds(lm+10+150+10,tm+10+40+10,300,30);
genderCaptionLabel.setBounds(lm+10,tm+10+40+10+30+10,150,30);
maleRadioButton.setBounds(lm+10+150+5,tm+10+40+10+30+10,100,30);
femaleRadioButton.setBounds(lm+10+150+5+100+5,tm+10+40+10+30+10,100,30);
indianCaptionLabel.setBounds(lm+10,tm+10+40+10+30+10+30+10,150,30);
isIndianCheckBox.setBounds(lm+10+150+5,tm+10+40+10+30+10+30+10,100,30);
citiesCaptionLabel.setBounds(lm+10,tm+10+40+10+30+10+30+10+30+10,150,30);
citiesComboBox.setBounds(lm+10+150+5,tm+10+40+10+30+10+30+10+30+10,300,30);
hobbiesCaptionLabel.setBounds(lm+10,tm+10+40+10+30+10+30+10+30+10+30+10,150,30);
hobbiesList.setBounds(lm+10+150+5,tm+10+40+10+30+10+30+10+30+10+30+10,300,100);
saveButton.setBounds((w/2)-(60/2),tm+10+40+10+30+10+30+10+30+10+30+10+100+10+50,60,50);
saveButton.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ev)
{
String name=nameTextField.getText();
String gender="";
if(maleRadioButton.isSelected())
{
gender="Male";
}
if(femaleRadioButton.isSelected())
{
gender="Female";
}
String isIndian="No";
if(isIndianCheckBox.isSelected())
{
isIndian="Yes";
}
String city=(String)citiesComboBox.getSelectedItem();
Object hobbies[]=hobbiesList.getSelectedValues();
System.out.println("Name :"+name);
System.out.println("Gender :"+gender);
System.out.println("Is Indian :"+isIndian);
System.out.println("City :"+city);
System.out.println("Hobbies :");
String hobby;
for(int e=0;e<hobbies.length;e++)
{
hobby=(String)hobbies[e];
System.out.printf("%d : %s\n",e+1,hobby);
}
}
});
container.add(titleLabel);
container.add(nameCaptionLabel);
container.add(nameTextField);
container.add(genderCaptionLabel);
container.add(maleRadioButton);
container.add(femaleRadioButton);
container.add(indianCaptionLabel);
container.add(isIndianCheckBox);
container.add(citiesCaptionLabel);
container.add(citiesComboBox);
container.add(hobbiesCaptionLabel);
container.add(hobbiesList);
container.add(saveButton);
setSize(w,h);
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
setDefaultCloseOperation(EXIT_ON_CLOSE);
setLocation((d.width/2)-(w/2),(d.height/2)-(h/2));
setVisible(true);
}
public static void main(String gg[])
{
EmployeeFrame ef=new EmployeeFrame();
}
}