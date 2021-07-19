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
import java.text.*;
import java.math.*;
public class MainMenu
{
public void show()
{
int ch;
while(true)
{
System.out.println("MENU");
System.out.println("1. Designation Master");
System.out.println("2. Employee Master");
System.out.println("3. Exit");
ch=Keyboard.getInt(" Enter your Choice from Menu :");
if(ch<1 || ch>3)
{
System.out.println("Invalid Choice ");
return;
}
if(ch==1)
{
while(true)
{
System.out.println("------Designation Master------");
System.out.println("1. Add");
System.out.println("2. Update");
System.out.println("3. Delete");
System.out.println("4. Get Count");
System.out.println("5. Get By Code");
System.out.println("6. Get By Title");
System.out.println("7. Get Designations");
System.out.println("8. Code Exists");
System.out.println("9. Title Exists");
System.out.println("10. Is Attached to an Employee");
System.out.println("11. Get Employee Count with Designation");
System.out.println("12. Exit");
System.out.println("---------------------------------------------------");
int k=Keyboard.getInt("Enter Your Choice from Designation Master :");
if(k<1 || k>12)
{
System.out.println("Invalid Choice");
return;
}
if(k==1)
{
DesignationUI dui1=new DesignationUI();
dui1.add();
}
if(k==2)
{
DesignationUI dui2=new DesignationUI();
dui2.update();
}

if(k==3)
{
DesignationUI dui3=new DesignationUI();
dui3.delete();
}

if(k==4)
{
DesignationUI dui4=new DesignationUI();
dui4.getCount();
}

if(k==5)
{
DesignationUI dui5=new DesignationUI();
dui5.getByCode();
}

if(k==6)
{
DesignationUI dui6=new DesignationUI();
dui6.getByTitle();
}

if(k==7)
{
DesignationUI dui7=new DesignationUI();
dui7.getDesignations();
}

if(k==8)
{
DesignationUI dui8=new DesignationUI();
dui8.codeExists();
}

if(k==9)
{
DesignationUI dui9=new DesignationUI();
dui9.titleExists();
}

if(k==10)
{
DesignationUI dui10=new DesignationUI();
dui10.isAttachedToAnEmployee();
}

if(k==11)
{
DesignationUI dui11=new DesignationUI();
dui11.getEmployeesCountWithDesignation();
}

if(k==12)
{
break;
}
}
}
if(ch==2)
{
while(true)
{
System.out.println("--------Employee Master-------");
System.out.println("1. Add");
System.out.println("2. Update");
System.out.println("3. Delete");
System.out.println("4. Get Count");
System.out.println("5. Get All");
System.out.println("6. Get By Employee Id");
System.out.println("7. Get By Aadhar Card Number");
System.out.println("8. Get By PAN Number");
System.out.println("9. Employee Id Exists");
System.out.println("10. Aadhar Card Number Exists");
System.out.println("11. PAN Number Exists");
System.out.println("12. Is Designation Alloted");
System.out.println("13. Count Of Employees With Same Designation :");
System.out.println("14. Exit");
System.out.println("--------------------------------------------------");
int m=Keyboard.getInt("Enter Your Choice from Employee Master");
if(m<1 || m>14)
{
System.out.println("Invalid Choice");
return;
}
if(m==1)
{
EmployeeUI eui1=new EmployeeUI();
eui1.add();
}

if(m==2)
{
EmployeeUI eui2=new EmployeeUI();
eui2.update();
}

if(m==3)
{
EmployeeUI eui3=new EmployeeUI();
eui3.delete();
}

if(m==4)
{
EmployeeUI eui4=new EmployeeUI();
eui4.getCount();
}

if(m==5)
{
EmployeeUI eui5=new EmployeeUI();
eui5.getAll();
}

if(m==6)
{
EmployeeUI eui6=new EmployeeUI();
eui6.getByEmployeeId();
}

if(m==7)
{
EmployeeUI eui7=new EmployeeUI();
eui7.getByAadharCardNumber();
}

if(m==8)
{
EmployeeUI eui8=new EmployeeUI();
eui8.getByPanNumber();
}

if(m==9)
{
EmployeeUI eui9=new EmployeeUI();
eui9.employeeIdExists();
}

if(m==10)
{
EmployeeUI eui10=new EmployeeUI();
eui10.aadharCardNumberExists();
}

if(m==11)
{
EmployeeUI eui11=new EmployeeUI();
eui11.panNumberExists();
}

if(m==12)
{
EmployeeUI eui12=new EmployeeUI();
eui12.isDesignationAlloted();
}

if(m==13)
{
EmployeeUI eui13=new EmployeeUI();
eui13.countOfEmployeesWithSameDesignation();
}

if(m==14)
{
break;
}
}
}
if(ch==3)
{
return;
}
}
}
}