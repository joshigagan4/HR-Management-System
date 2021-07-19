import java.awt.*;
import java.util.*;
import java.text.*;
class TitlePanel extends Panel
{
private Label titleLabel;
TitlePanel()
{
titleLabel=new Label("Student (Add Module)");
setLayout(new GridLayout(1,3));
add(new Label("     "));
add(titleLabel);
add(new Label("     "));
}
}
class GenderPanel extends Panel
{
private CheckboxGroup gender;
private Checkbox maleCheckbox; 
private Checkbox femaleCheckbox;
GenderPanel()
{
gender=new CheckboxGroup();
maleCheckbox=new Checkbox("Male",gender,false);
femaleCheckbox=new Checkbox("Female",gender,false);
setLayout(new GridLayout(1,2));
add(maleCheckbox);
add(femaleCheckbox);
}
}
class ButtonsPanel extends Panel
{
private Button saveButton;
private Button cancelButton;
ButtonsPanel()
{
saveButton=new Button("Save");
cancelButton=new Button("Cancel");
setLayout(new GridLayout(1,5));
add(new Label("     "));
add(saveButton);
add(new Label("     "));
add(cancelButton);
add(new Label("     "));
}
}
class FormPanel extends Panel
{
private Label rollNumberLabel;
private Label nameLabel;
private Label genderLabel;
private TextField nameTextField;
private TextField rollNumberTextField;
private GenderPanel genderPanel;
FormPanel()
{
rollNumberLabel=new Label("Roll Number");
nameLabel=new Label("Name");
genderLabel=new Label("Gender");
rollNumberTextField=new TextField(20);
nameTextField=new TextField(50);
genderPanel=new GenderPanel();
setLayout(new GridLayout(3,2));
setLayout(new GridLayout(3,2));
add(rollNumberLabel);
add(rollNumberTextField);
add(nameLabel);
add(nameTextField);
add(genderLabel);
add(genderPanel);
}
}
class ModulePanel extends Panel
{
private TitlePanel titlePanel;
private ButtonsPanel buttonsPanel;
private FormPanel formPanel;
ModulePanel()
{
titlePanel=new TitlePanel();
buttonsPanel=new ButtonsPanel();
formPanel=new FormPanel();
setLayout(new BorderLayout());
add(titlePanel,BorderLayout.NORTH);
add(formPanel,BorderLayout.CENTER);
add(buttonsPanel,BorderLayout.SOUTH);
}
}
class awt4 extends Frame
{
private Label dateLabel;
private ModulePanel modulePanel;
awt4()
{
dateLabel=new Label("Date :"+new SimpleDateFormat("dd/MM/yy hh:mm:ss").format(new Date()));
modulePanel=new ModulePanel();
setLayout(new BorderLayout());
add(modulePanel,BorderLayout.CENTER);
add(dateLabel,BorderLayout.SOUTH);
setTitle("School Automation");
setLocation(10,10);
setSize(500,400);
setVisible(true);
}
public static void main(String gg[])
{
awt4 a=new awt4();
}
}