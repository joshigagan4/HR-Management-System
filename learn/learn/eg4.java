class City
{
private int code;
public String name;
City()
{
System.out.println("Object created");
}
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
class Student
{
private int rollNumber;
private String name;
private Float height;
private City city;
public void setHeight(Float height)
{
this.height=height;
}
public Float getHeight()
{
return this.height;
}
public void setRollNumber(int rollNumber)
{
this.rollNumber=rollNumber;
}
public int getRollNumber()
{
return this.rollNumber;
}
public void setName(String name)
{
this.name=name;
}
public String getName()
{
return this.name;
}
public void setCity(City city)
{
this.city=city;
}
public City getCity()
{
return this.city;
}
}
class eg4psp
{
public static void main(String gg[])
{
Class returnType=City.class;
try
{
Object obj=returnType.newInstance();
}catch(InstantiationException ie)
{
}
catch(IllegalAccessException iae)
{
}
}
}




