import java.awt.*;
import java.awt.event.*;
class abcd extends Frame implements MouseListener
{
abcd()
{
addMouseListener(this);
setLocation(10,10);
setSize(500,400);
setVisible(true);
}
public void mouseClicked(MouseEvent me)
{
System.out.println("mouse clicked ");
}
public void mousePressed(MouseEvent me)
{
System.out.println("mouse pressed ");
}
public void mouseReleased(MouseEvent me)
{
System.out.println("mouse released ");
}
public void mouseEntered(MouseEvent me)
{
System.out.println("mouse entered ");
}
public void mouseExited(MouseEvent me)
{
System.out.println("mouse exited ");
}
}
class psp
{
public static void main(String gg[])
{
abcd a=new abcd();
}
}