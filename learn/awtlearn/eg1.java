import java.awt.*;
class eg1ui extends Frame
{
private Label l1,l2,l4,l5;
private TextField rollNumberTextField;
private TextField nameTextField;
private Checkbox adultCheckBox;
private CheckboxGroup genderGroup;
private Checkbox maleRadioButton;
private Checkbox femaleRadioButton;
private Choice cityComboBox;
private Button saveButton,cancelButton;
eg1ui()
{
super("First GUI Example");
l1=new Label("Roll Number :");
rollNumberTextField=new TextField(10);
l2=new Label("Name");
nameTextField=new TextField(25);
adultCheckBox=new Checkbox("Adult");
l4=new Label("Gender");
genderGroup=new CheckboxGroup();
maleRadioButton=new Checkbox("Male",genderGroup,false);
femaleRadioButton=new Checkbox("Female",genderGroup,false);
l5=new Label("City");
cityComboBox=new Choice();
cityComboBox.add("Ujjain");
cityComboBox.add("Indore");
cityComboBox.add("Dewas");
cityComboBox.add("Bombay");
saveButton=new Button("Save");
cancelButton=new Button("Cancel");
FlowLayout flowLayout;
flowLayout=new FlowLayout();
setLayout(flowLayout); //I have Installed flow layout manager
add(l1);
add(rollNumberTextField);
add(l2);
add(nameTextField);
add(adultCheckBox);
add(l4);
add(maleRadioButton);
add(femaleRadioButton);
add(l5);
add(cityComboBox);
add(saveButton);
add(cancelButton);
setLocation(10,50); //upper left corner position of Frame
setSize(500,400);  //width x Height

}
public static void main(String gg[])
{
eg1ui ui=new eg1ui();
ui.setVisible(true);
}


}