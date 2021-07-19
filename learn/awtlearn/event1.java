import java.awt.*;
import java.awt.event.*;
class StudentAddFrame extends Frame implements ActionListener
{
private Label rollNumberLabel;
private Label nameLabel;
private TextField rollNumberTextField;
private TextField nameTextField;
private Button saveButton;
private Button cancelButton;
StudentAddFrame()
{
super("Student (Add Module)");
rollNumberLabel=new Label("RollNumber :");
nameLabel=new Label("Name :");
rollNumberTextField=new TextField(10);
nameTextField=new TextField(50);
saveButton=new Button("Save");
cancelButton=new Button("Cancel");
saveButton.addActionListener(this);
cancelButton.addActionListener(this);
setLayout(new FlowLayout());
add(rollNumberLabel);
add(rollNumberTextField);
add(nameLabel);
add(nameTextField);
add(saveButton);
add(cancelButton);
setLocation(10,20);
setSize(700,400);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==saveButton)
{
System.out.println("Saving.....");
}
if(ae.getSource()==cancelButton)
{
rollNumberTextField.setText("");
nameTextField.setText("");
rollNumberTextField.requestFocus();
}
}

public static void main(String gg[])
{
StudentAddFrame saf=new StudentAddFrame();
saf.setVisible(true);
}
}