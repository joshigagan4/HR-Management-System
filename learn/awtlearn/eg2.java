import java.awt.*;
class awt2 extends Frame
{
private Button b1,b2,b3,b4,b5,b6;
awt2()
{
b1=new Button("One");
b2=new Button("Two");
b3=new Button("Three");
b4=new Button("Four");
b5=new Button("Five");
/*
b6=new Button("Six");
setLayout(new GridLayout(2,3)); //GridLayout me jitne cell bole he utne components dene hi he, km zyada karenge to layout bigad jaega,jo bhi hoga wo unpredictable hoga . Dummy Labels bhi add kr sakte he Dummy label matlab label with empty string
add(b1);
add(b2);
add(b3);
add(b4);
add(b5);
add(b6);
*/
setLayout(new BorderLayout()); //setLayout ke through BorderLayout install kiya, agar ye nahi likhe to bhi chalega kyuki bydefault BorderLayout set rehta he
add(b1,BorderLayout.EAST);
add(b2,BorderLayout.WEST);
add(b3,BorderLayout.NORTH);
add(b4,BorderLayout.SOUTH);
add(b5,BorderLayout.CENTER);

setLocation(10,10);
setSize(500,400);
}
public static void main(String gg[])
{
awt2 a=new awt2();
a.setVisible(true);
}
}