import java.awt.*;
import java.util.*;
import java.text.*;
class awt3 extends Frame
{
private Label titleLabel;
private Label rollNumberLabel;
private Label nameLabel;
private Label genderLabel;
private Label dateLabel;
private TextField nameTextField;
private TextField rollNumberTextField;
private CheckboxGroup gender;
private Checkbox maleCheckbox; 
private Checkbox femaleCheckbox;
private Button saveButton;
private Button cancelButton;
awt3()
{
titleLabel=new Label("Student (Add Module)");
rollNumberLabel=new Label("Roll Number");
nameLabel=new Label("Name");
genderLabel=new Label("Gender");
dateLabel=new Label("Date :"+new SimpleDateFormat("dd/MM/yy hh:mm:ss").format(new Date()));
rollNumberTextField=new TextField(20);
nameTextField=new TextField(50);
gender=new CheckboxGroup();
maleCheckbox=new Checkbox("Male",gender,false);
femaleCheckbox=new Checkbox("Female",gender,false);
saveButton=new Button("Save");
cancelButton=new Button("Cancel");
Panel titlePanel=new Panel();
titlePanel.setLayout(new GridLayout(1,3));
titlePanel.add(new Label("     "));
titlePanel.add(titleLabel);
titlePanel.add(new Label("     "));
Panel genderPanel=new Panel();
genderPanel.setLayout(new GridLayout(1,2));
genderPanel.add(maleCheckbox);
genderPanel.add(femaleCheckbox);
Panel buttonsPanel=new Panel();
buttonsPanel.setLayout(new GridLayout(1,5));
buttonsPanel.add(new Label("     "));
buttonsPanel.add(saveButton);
buttonsPanel.add(new Label("     "));
buttonsPanel.add(cancelButton);
buttonsPanel.add(new Label("     "));
Panel formPanel=new Panel();
formPanel.setLayout(new GridLayout(3,2));
formPanel.add(rollNumberLabel);
formPanel.add(rollNumberTextField);
formPanel.add(nameLabel);
formPanel.add(nameTextField);
formPanel.add(genderLabel);
formPanel.add(genderPanel);
Panel modulePanel=new Panel();
modulePanel.setLayout(new BorderLayout());
modulePanel.add(titlePanel,BorderLayout.NORTH);
modulePanel.add(formPanel,BorderLayout.CENTER);
modulePanel.add(buttonsPanel,BorderLayout.SOUTH);
setLayout(new BorderLayout());
add(modulePanel,BorderLayout.CENTER);
add(dateLabel,BorderLayout.SOUTH);
setLocation(10,10);
setSize(500,400);
setVisible(true);
}
public static void main(String gg[])
{
awt3 a=new awt3();
}
}