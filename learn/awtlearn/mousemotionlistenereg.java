import java.awt.*;
import java.awt.event.*;
class abcd extends Frame implements MouseMotionListener
{
abcd()
{
addMouseMotionListener(this);
setLocation(10,10);
setSize(500,400);
setVisible(true);
}
public void mouseDragged(MouseEvent me)
{
System.out.println(" mouse dragged ");
}
public void mouseMoved(MouseEvent me)
{
System.out.println(" mouse moved ");
}
}
class psp
{
public static void main(String gg[])
{
abcd a=new abcd();
}
}