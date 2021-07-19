import java.lang.reflect.*;
class psp
{
public static void main(String gg[])
{
try
{
Class c;
c=Class.forName("com.thinking.machines.hr.dl.dto.EmployeeDTO");
Field f[]=c.getDeclaredFields();
String fieldName;
Class fieldType;
for(int e=0;e<f.length;e++)
{
fieldName=f[e].getName();
fieldType=f[e].getType();
System.out.println("Field : "+fieldName);
System.out.println("Data Type : "+fieldType.getName());
}
String methodName;
Class returnType;
Class parameterTypes[];
Method methods[]=c.getMethods();
for(int e=0;e<methods.length;e++)
{
methodName=methods[e].getName();
returnType=methods[e].getReturnType();
parameterTypes=methods[e].getParameterTypes();
System.out.println("Name : "+methodName);
System.out.println("Return Type : "+returnType.getName());
System.out.println("Parameters");
for(int k=0;k<parameterTypes.length;k++)
{
//try getSimpleName() in place of getName()
System.out.println(parameterTypes[k].getSimpleName());
}
}
}catch(ClassNotFoundException cnfe)
{
System.out.println(cnfe);
}
}
}
//to compile javac eg1.java
//to run java -classpath ..\dl\classes;. psp

