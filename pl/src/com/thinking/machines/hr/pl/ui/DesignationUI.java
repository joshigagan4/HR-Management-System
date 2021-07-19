package com.thinking.machines.hr.pl.ui;
import com.thinking.machines.hr.dl.exceptions.*;
import com.thinking.machines.hr.dl.interfaces.*;
import com.thinking.machines.hr.dl.dao.*;
import com.thinking.machines.hr.dl.dto.*;
import com.thinking.machines.hr.bl.exceptions.*;
import com.thinking.machines.hr.bl.interfaces.*;
import com.thinking.machines.hr.bl.pojo.*;
import com.thinking.machines.hr.bl.managers.*;
import com.thinking.machines.common.*;
import java.util.*;
public class DesignationUI
{
public void add()
{
String vTitle=Keyboard.getString("Enter Title :");
try
{
DesignationInterface designation;
designation=new Designation();
designation.setTitle(vTitle);
DesignationManager d=DesignationManager.getDesignationManager();
d.add(designation);
System.out.println("Designation : "+vTitle+" added with code as : "+designation.getCode());
}catch(BLException b)
{
List<String> list=b.getExceptions();
for(int i=0;i<list.size();i++)
{
String g=list.get(i);
System.out.println(g);
}
}
}
public void update()
{
int code=Keyboard.getInt("Enter code to update :");
String title=Keyboard.getString("Enter title to update :");
try
{
DesignationManagerInterface designationManager;
designationManager=DesignationManager.getDesignationManager();
DesignationInterface designation;
designation=new Designation();
designation.setCode(code);
designation.setTitle(title);
designationManager.update(designation);
System.out.println("Designation Updated....");
}catch(BLException b)
{
List<String> list=b.getExceptions();
for(int i=0;i<list.size();i++)
{
String g=list.get(i);
System.out.println(g);
}
}
}
public void delete()
{
int vCode=Keyboard.getInt("Enter a code to delete : ");
try
{
DesignationManagerInterface designationManager;
designationManager=DesignationManager.getDesignationManager(); 
designationManager.delete(vCode);
System.out.printf("designation deleted with code as %d",vCode);
}catch(BLException b)
{
List<String> list=b.getExceptions();
for(int i=0;i<list.size();i++)
{
String g=list.get(i);
System.out.println(g);
}
}
}
public void getCount()
{
try
{
DesignationManagerInterface designationManager;
designationManager=DesignationManager.getDesignationManager();
int count;
count=designationManager.getCount();
System.out.printf("Number of Designation added is :"+count);
}catch(BLException b)
{
List<String> list=b.getExceptions();
for(int i=0;i<list.size();i++)
{
String g=list.get(i);
System.out.println(g);
}
}
}
public void getByCode()
{
int code=Keyboard.getInt("Enter a code to get  title:");
try
{
DesignationManagerInterface designationManager;
designationManager=DesignationManager.getDesignationManager();
DesignationInterface designation;
designation=new Designation();
designation=designationManager.getByCode(code);
String title=designation.getTitle();
System.out.println("Designation code : "+code+" is with title as : "+title);
}catch(BLException b)
{
List<String> list=b.getExceptions();
for(int i=0;i<list.size();i++)
{
String g=list.get(i);
System.out.println(g);
}
}
}
public void getByTitle()
{
String title=Keyboard.getString("Enter a title to get code :");
try
{
DesignationManagerInterface designationManager;
designationManager=DesignationManager.getDesignationManager();
DesignationInterface designation;
designation=new Designation();
designation=designationManager.getByTitle(title);
int code=designation.getCode();
System.out.println("Designation title : "+title+" is with code as : "+code);
}catch(BLException b)
{
List<String> list=b.getExceptions();
for(int i=0;i<list.size();i++)
{
String g=list.get(i);
System.out.println(g);
}
}
}
public void getDesignations()
{
String title=Keyboard.getString("Enter a title:");
try
{
DesignationInterface designation;
designation=new Designation();
designation.setTitle(title);
DesignationManager d=DesignationManager.getDesignationManager();
d.add(designation);
System.out.println(title+" added with code as :"+designation.getCode());
}catch(BLException b)
{
List<String> list=b.getExceptions();
for(int i=0;i<list.size();i++)
{
System.out.println(i);
}
}
}
public void codeExists()
{
int code=Keyboard.getInt("Enter designation code:");
try
{
DesignationManagerInterface designationManager;
designationManager=DesignationManager.getDesignationManager();
boolean vCode=designationManager.codeExists(code);
System.out.printf("Designation code exists :" +vCode);
}catch(BLException blException)
{
System.out.println(blException.getGenericException());
}
}

public void titleExists()
{
String title=Keyboard.getString("Enter designation title:");
try
{
DesignationManagerInterface designationManager;
designationManager=DesignationManager.getDesignationManager();
boolean vTitle=designationManager.titleExists(title);
System.out.printf("Is Designation code exists :" +vTitle);
}catch(BLException blException)
{
System.out.println(blException.getGenericException());
}
}
public void isAttachedToAnEmployee()
{
int code=Keyboard.getInt("Enter a code :");
try
{
DesignationManagerInterface designationManager;
designationManager=DesignationManager.getDesignationManager();
boolean codeFound=designationManager.isAttachedToAnEmployee(code);
System.out.println("Attached to an Employee :"+codeFound);
}catch(BLException blException)
{
System.out.println(blException.getGenericException());
}
}
public void getEmployeesCountWithDesignation()
{
int code=Keyboard.getInt("Enter a code :");
try
{
DesignationManagerInterface designationManager;
designationManager=DesignationManager.getDesignationManager();
int count;
count=designationManager.getEmployeesCountWithDesignation(code);
System.out.println("Employees with designation code "+ code +"is "+count);
}catch(BLException blException)
{
System.out.println(blException.getGenericException());
}
}
}