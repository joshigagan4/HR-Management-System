import java.lang.reflect.*;
import java.util.*;
class City
{
private int code;
private String name;
public void setCode(int code)
{
this.code=code;
}
public int getCode()
{
return this.code;
}
public void setName(String name)
{
this.name=name;
}
public String getName()
{
return this.name;
}
}
class aaa
{
private int x;
private City city;
public void setCity(City city)
{
this.city=city;
}
public City getCity()
{
return this.city;
}
public void setCool(int g)
{
}
public String getCool()
{
return "";
}
public void setX(int x)
{
this.x=x;
}
public void setkalia(int e)
{
}
public void set123(int e)
{
}
public int setBabu(int e)
{
return 10;
}
public void setKalu(int e)
{
}
public int getX()
{
return this.x;
}
private String golu;
public void setGolu(String golu)
{
this.golu=golu;
}
public String getGolu()
{
return this.golu;
}
public int getWhatever(int a,int b)
{
return 20;
}
public void setWhatever()
{
System.out.println("some message");
}
}
class POJOCopier
{
private POJOCopier(){}
public static void copy(Object target,Object source)
{
List<Method> setters=new ArrayList<>();
Class targetClass=target.getClass();
Method targetMethods[];
targetMethods=targetClass.getMethods();
int e;
Method method;
String methodName;
Class parameterTypes[];
Class returnType;
for(e=0;e<targetMethods.length;e++)
{
method=targetMethods[e];
methodName=method.getName();
if(methodName.length()<=3) continue;
if(methodName.startsWith("set")==false) continue;
parameterTypes=method.getParameterTypes();
if(parameterTypes.length!=1) continue;
returnType=method.getReturnType();
if(returnType.getName().equals("void")==false) continue;
char m=methodName.charAt(3);
if(m<65 || m>90) continue;
//System.out.println("Adding :"+methodName+" to setters list");
setters.add(method);
}
if(setters.size()==0) return;
List<Method> getters=new ArrayList<>();
Class sourceClass=source.getClass();
Method setterMethod;
Method getterMethod;
int kkk=0;
String getterName;
String setterName;
String propertyName;
Class getterMethodReturnType;
//System.out.println("Looking for getters that match the setters");
while(kkk<setters.size())
{
setterMethod=setters.get(kkk);
parameterTypes=setterMethod.getParameterTypes();
setterName=setterMethod.getName();
//System.out.println("Name of setter method :"+setterName);
propertyName=setterName.substring(3);
getterName="get"+propertyName;
//System.out.println("Looking for getter :"+getterName);
try
{
getterMethod=sourceClass.getMethod(getterName,new Class[0]);
getterMethodReturnType=getterMethod.getReturnType();
if(getterMethodReturnType.equals(parameterTypes[0])==false)
{
setters.remove(kkk);
continue;
}
//System.out.println("Getter method found :"+getterMethod.getName());
getters.add(getterMethod);
}catch(NoSuchMethodException nsme)
{
setters.remove(kkk);
continue;
}
kkk++;
}
//System.out.println("setters/getters Data Structure created");
Object getterResult;
kkk=0;
while(kkk<setters.size())
{
setterMethod=setters.get(kkk);
getterMethod=getters.get(kkk);
//System.out.println(setterMethod.getName()+ " -----> "+ getterMethod.getName());
try
{
getterResult=getterMethod.invoke(source,new Object[0]);
Class getterResultClass=getterResult.getClass();
if(isPrimitive(getterResultClass))
{
setterMethod.invoke(target,getterResult);
}
else
{
try
{
Object getterResultClassObject;
getterResultClassObject=getterResultClass.newInstance();
copy(getterResultClassObject,getterResult);
setterMethod.invoke(target,getterResultClassObject);
}catch(Exception exception)
{
//do nothing
}
}
}catch(Exception eee)
{
//do nothing
}
kkk++;
}
}
public static boolean isPrimitive(Class c)
{
String typeName=c.getName();
if(typeName.equals("long")==true || typeName.equals("java.lang.Long")) return true;
if(typeName.equals("int")==true || typeName.equals("java.lang.Integer")) return true;
if(typeName.equals("short")==true || typeName.equals("java.lang.Short")) return true;
if(typeName.equals("byte")==true || typeName.equals("java.lang.Byte")) return true;
if(typeName.equals("double")==true || typeName.equals("java.lang.Double")) return true;
if(typeName.equals("float")==true || typeName.equals("java.lang.Float")) return true;
if(typeName.equals("char")==true || typeName.equals("java.lang.Character")) return true;
if(typeName.equals("boolean")==true || typeName.equals("java.lang.Boolean")) return true;
if(typeName.equals("java.lang.String")==true) return true;
return false;
}
}
class psp2
{
public static void main(String gg[])
{
aaa a1=new aaa();
a1.setX(10);
a1.setGolu("Cool");
City c1=new City();
c1.setCode(101);
c1.setName("Ujjain");
a1.setCity(c1);
aaa a2=new aaa();
POJOCopier.copy(a2,a1);
System.out.println(a2.getX());
System.out.println(a2.getGolu());
System.out.println(a2.getCity().getCode());
System.out.println(a2.getCity().getName());
a2.getCity().setCode(152);
a2.getCity().setName("Indore");
System.out.println(a2.getCity().getCode());
System.out.println(a2.getCity().getName());
System.out.println(a1.getCity().getCode());
System.out.println(a1.getCity().getName());
}
}



