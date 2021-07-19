import java.awt.*;
import java.awt.event.*;
class aaa extends Frame implements ItemListener
{
private Checkbox c1;
private Checkbox c2;
private Label l1;
aaa()
{
c1=new Checkbox("Reading");
c2=new Checkbox("Music");
c1.addItemListener(this);
c2.addItemListener(this);
l1=new Label("         ");
setLayout(new FlowLayout());
add(c1);
add(c2);
add(l1);
setLocation(10,10);
setSize(500,400);
setVisible(true);
}
public void itemStateChanged(ItemEvent ev)
{
if(ev.getItemSelectable()==c1)
{
if(c1.getState()) l1.setText("Reading checked");
else l1.setText("Reading unchecked");
}
if(ev.getItemSelectable()==c2)
{
if(c2.getState()) l1.setText("Music checked");
else l1.setText("Music unchecked");
}
}
public static void main(String gg[])
{
aaa a;
a=new aaa();
}
}