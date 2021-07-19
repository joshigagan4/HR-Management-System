import java.awt.*;
import java.awt.event.*;
/*class CloseButtonHandler extends WindowAdapter
{
public void windowClosing(WindowEvent ev)
{
System.exit(0);
}
}
*/
//class aaa extends Frame implements WindowListener
class aaa extends Frame implements WindowListener
{
aaa()
{
/*addWindowListener(new WindowAdapter(){
public void windowClosing(WindowEvent ev)
{
System.out.println("Bye");
System.exit(0);
}
});
*/
/*WindowAdapter wa;
wa=new WindowAdapter(){
public void windowClosing(WindowEvent ev)
{
System.exit(0);
}
};
*/
//addWindowListener(wa);
//CloseButtonHandler cbh;
//cbh=new CloseButtonHandler();
//addWindowListener(cbh);
addWindowListener(this);
setLocation(10,10);
setSize(500,400);
setVisible(true);
}
public void windowDeactivated(WindowEvent ev)
{
System.out.println("window deactivated ");
}
public void windowActivated(WindowEvent ev)
{
System.out.println("window activated ");
}
public void windowOpened(WindowEvent ev)
{
System.out.println("window opened ");
}
public void windowClosed(WindowEvent ev)
{
System.out.println("window closed ");
}
public void windowClosing(WindowEvent ev)
{
System.out.println("window closing ");
System.exit(0);
}
public void windowIconified(WindowEvent ev)
{
System.out.println("window iconified ");
}
public void windowDeiconified(WindowEvent ev)
{
System.out.println("window deiconified ");
}

}
class psp
{
public static void main(String gg[])
{
aaa a=new aaa();
}
}