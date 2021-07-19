import java.lang.reflect.*;
class bbbb
{
public void ramu(int a,int b)
{
}
}
class psp3
{
public static void main(String gg[])
{
try
{
Class c=Class.forName("bbbb");
Class params[];
params=new Class[2];
params[0]=int.class;
params[1]=int.class;
Method m=c.getMethod("ramu",params);
System.out.println(m.getName());
Class rt=m.getReturnType();
System.out.println("Return Type is : "+rt.getName());

}catch(Exception e)
{
System.out.println(e);
}
}
}