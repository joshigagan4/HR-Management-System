import java.awt.*;
import java.awt.event.*;
class aaa extends Frame implements ActionListener
{
private Label citiesLabel;
private Choice citiesComboBox;
aaa()
{
citiesLabel=new Label("City");
citiesComboBox=new Choice();
citiesComboBox.add("Indore");
citiesComboBox.add("Ujjain");
citiesComboBox.add("Dewas");
citiesComboBox.add("Jaipur");
citiesComboBox.addActionListener(this);
setLayout(new FlowLayout());
add(citiesLabel);
add(citiesComboBox);
setLocation(10,20);
setSize(600,500);
setVisible(true);
}
public void actionPerformed(ActionEvent ae)
{
//System.out.println(citiesComboBox.getSelectedIndex());
//System.out.println(citiesComboBox.getSelectedItems());
}
public static void main(String gg[])
{
aaa a=new aaa();
}
}