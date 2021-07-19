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
public class EmployeeUI
{
public void add()
{
try
{
SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
String vEmployeeId;
String vName=Keyboard.getString("Enter name : ");
int code=Keyboard.getInt("Enter designation : ");
DesignationInterface designation;
designation=new Designation();
DesignationManagerInterface designationManager;
designationManager=DesignationManager.getDesignationManager();
designation=designationManager.getByCode(code);
Date vDateOfBirth=new Date();
try
{
vDateOfBirth=sdf.parse(Keyboard.getString("Enter date of Birth(dd/MM/yyyy) : "));
}catch(ParseException parseException)
{
System.out.println(parseException);
}
BigDecimal vBasicSalary=new BigDecimal(Keyboard.getString("Enter basic salary :"));
String vGender=Keyboard.getString("Enter gender (male/female) :");
if(vGender.equals("male")!=true && vGender.equals("female")!=true)
{
throw new RuntimeException("Invalid gender : "+vGender);
}
boolean vIsIndian;
String in=Keyboard.getString("Is Indian (Y/N) : ");
if(in.equals("Y")!=true && in.equals("N")!=true)
{
throw new RuntimeException("Invalid Indian factor :"+in);
}
vIsIndian=(in.equals("Y"))?true:false;
String vPANNumber=Keyboard.getString("Enter PAN Number : ");
String vAadharCardNumber=Keyboard.getString("Enter Aadhar card number : ");
EmployeeManagerInterface employeeManager;
employeeManager=EmployeeManager.getEmployeeManager();
EmployeeInterface employee;
employee=new Employee();
employee.setName(vName);
employee.setDesignation(designation);
if(vGender.equals("male")) employee.setGender(Employee.MALE);
if(vGender.equals("female")) employee.setGender(Employee.FEMALE);
employee.setDateOfBirth(vDateOfBirth);
employee.isIndian(vIsIndian);
employee.setBasicSalary(vBasicSalary);
employee.setPANNumber(vPANNumber);
employee.setAadharCardNumber(vAadharCardNumber);
employeeManager.add(employee);
System.out.println(" Employee added with id as : "+employee.getEmployeeId());
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
try
{
SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
String vEmployeeId=Keyboard.getString("Enter Employee ID : ");
String vName=Keyboard.getString("Enter name : ");
int code=Keyboard.getInt("Enter designation : ");
DesignationInterface designation;
designation=new Designation();
DesignationManagerInterface designationManager;
designationManager=DesignationManager.getDesignationManager();
designation=designationManager.getByCode(code);
Date vDateOfBirth=new Date();
try
{
vDateOfBirth=sdf.parse(Keyboard.getString("Enter date of Birth(dd/MM/yyyy) : "));
}catch(ParseException parseException)
{
System.out.println(parseException);
}
BigDecimal vBasicSalary=new BigDecimal(Keyboard.getString("Enter basic salary :"));
String vGender=Keyboard.getString("Enter gender (male/female) :");
if(vGender.equals("male")!=true && vGender.equals("female")!=true)
{
throw new RuntimeException("Invalid gender : "+vGender);
}
boolean vIsIndian;
String in=Keyboard.getString("Is Indian (Y/N) : ");
if(in.equals("Y")!=true && in.equals("N")!=true)
{
throw new RuntimeException("Invalid Indian factor :"+in);
}
vIsIndian=(in.equals("Y"))?true:false;
String vPANNumber=Keyboard.getString("Enter PAN Number : ");
String vAadharCardNumber=Keyboard.getString("Enter Aadhar card number : ");
EmployeeManagerInterface employeeManager;
employeeManager=EmployeeManager.getEmployeeManager();
EmployeeInterface employee;
employee=new Employee();
employee.setEmployeeId(vEmployeeId);
employee.setName(vName);
employee.setDesignation(designation);
if(vGender.equals("male")) employee.setGender(Employee.MALE);
if(vGender.equals("female")) employee.setGender(Employee.FEMALE);
employee.setDateOfBirth(vDateOfBirth);
employee.isIndian(vIsIndian);
employee.setBasicSalary(vBasicSalary);
employee.setPANNumber(vPANNumber);
employee.setAadharCardNumber(vAadharCardNumber);
employeeManager.update(employee);
System.out.println("Employee updated......!");
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
try
{
String employeeId=Keyboard.getString("Enter a Employee ID to delete : ");
EmployeeManagerInterface employeeManager;
employeeManager=EmployeeManager.getEmployeeManager();
employeeManager.delete(employeeId);
System.out.println("Employee deleted of employee ID : "+employeeId);
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
EmployeeManagerInterface employeeManager;
employeeManager=EmployeeManager.getEmployeeManager();
int count;
count=employeeManager.getCount();
System.out.printf("Number of Employee added is :"+count);
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
public void getAll()
{
try
{
EmployeeManagerInterface employeeManager;
employeeManager=EmployeeManager.getEmployeeManager();
List<EmployeeInterface> employees;
employees=employeeManager.getAll(EmployeeInterface.NAME);
SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy");
for(EmployeeInterface employee :employees)
{
System.out.println("Employee ID :"+employee.getEmployeeId());
System.out.println("Name :"+employee.getName());
System.out.println("Designation code :"+employee.getDesignation().getCode());
System.out.println("Date Of Birth :"+sdf.format(employee.getDateOfBirth()));
System.out.println("Basic Salary :"+employee.getBasicSalary().toPlainString());
System.out.println("Is Indian :"+employee.isIndian());
System.out.println("Gender :"+employee.getGender());
System.out.println("PAN number :"+employee.getPANNumber());
System.out.println("Aadhar card number :"+employee.getAadharCardNumber());
System.out.println("--------------------------------------------------------------");
}
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
public void getByEmployeeId()
{
try
{
String EmployeeId=Keyboard.getString("Enter employee ID : ");
EmployeeManagerInterface employeeManager;
employeeManager=EmployeeManager.getEmployeeManager();
EmployeeInterface employee;
employee=new Employee();
employee=employeeManager.getByEmployeeId(EmployeeId);
String vName=employee.getName();
DesignationInterface vdesignation=employee.getDesignation();
String vTitle=vdesignation.getTitle();
boolean vIsIndian=employee.isIndian();
String vGender=employee.getGender();
Date vDateOfBirth=employee.getDateOfBirth();
BigDecimal vBasicSalary=employee.getBasicSalary();
String vPANNumber=employee.getPANNumber();
String vAadharCardNumber=employee.getAadharCardNumber();
System.out.println("Name of employee : "+vName);
System.out.println("Designation of employee : "+vTitle);
System.out.println("Is employee is indian : "+vIsIndian);
System.out.println("Gender of employee : "+vGender);
System.out.println("Date of Birth of the employee : "+vDateOfBirth);
System.out.println("Basic Salary of the employee : "+vBasicSalary);
System.out.println("Pan Number of the employee : "+vPANNumber);
System.out.println("Aadhar Card Number of the employee : "+vAadharCardNumber);
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
public void getByAadharCardNumber()
{
try
{
String AadharCardNumber=Keyboard.getString("Enter a aadhar card Number : ");
EmployeeManagerInterface employeeManager;
employeeManager=EmployeeManager.getEmployeeManager();
EmployeeInterface employee;
employee=new Employee();
employee=employeeManager.getByAadharCardNumber(AadharCardNumber);
String vEmployeeId=employee.getEmployeeId();
String vName=employee.getName();
DesignationInterface vdesignation=employee.getDesignation();
String vTitle=vdesignation.getTitle();
boolean vIsIndian=employee.isIndian();
String vGender=employee.getGender();
Date vDateOfBirth=employee.getDateOfBirth();
BigDecimal vBasicSalary=employee.getBasicSalary();
String vPanNumber=employee.getPANNumber();
System.out.println("Employee ID :"+vEmployeeId);
System.out.println("Name: "+vName);
System.out.println("Designation  : "+vTitle);
System.out.println("Is employee is indian : "+vIsIndian);
System.out.println("Gender : "+vGender);
System.out.println("Basic Salary  : "+vBasicSalary);
System.out.println("Date of Birth : "+vDateOfBirth);
System.out.println("Pan Number :"+vPanNumber);
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
public void getByPanNumber()
{
try
{
String PanNumber=Keyboard.getString("Enter a PAN Number : ");
EmployeeManagerInterface employeeManager;
employeeManager=EmployeeManager.getEmployeeManager();
EmployeeInterface employee;
employee=new Employee();
employee=employeeManager.getByPANNumber(PanNumber);
String vEmployeeId=employee.getEmployeeId();
String vName=employee.getName();
DesignationInterface vdesignation=employee.getDesignation();
String vTitle=vdesignation.getTitle();
boolean vIsIndian=employee.isIndian();
String vGender=employee.getGender();
Date vDateOfBirth=employee.getDateOfBirth();
BigDecimal vBasicSalary=employee.getBasicSalary();
String vAadharCardNumber=employee.getAadharCardNumber();
System.out.println("Employee ID :"+vEmployeeId);
System.out.println("Name of employee : "+vName);
System.out.println("Designation of employee : "+vTitle);
System.out.println("Is employee is indian : "+vIsIndian);
System.out.println("Gender of employee : "+vGender);
System.out.println("Date of Birth of the employee : "+vDateOfBirth);
System.out.println("Basic Salary of the employee : "+vBasicSalary);
System.out.println("Aadhar Card Number of the employee : "+vAadharCardNumber);
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
public void employeeIdExists()
{
String employeeId=Keyboard.getString("Enter Employee ID:");
try
{
EmployeeManagerInterface employeeManager;
employeeManager=EmployeeManager.getEmployeeManager();
boolean vEmployeeId=employeeManager.employeeIdExists(employeeId);
System.out.println("Is Employee exists :" +vEmployeeId);
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
public void aadharCardNumberExists()
{
String aadharCard=Keyboard.getString("Enter aadhar card Number :");
try
{
EmployeeManagerInterface employeeManager;
employeeManager=EmployeeManager.getEmployeeManager();
boolean vAadharCardNumber=employeeManager.aadharCardNumberExists(aadharCard);
System.out.println("Is Aadhar Card Number exists :" +vAadharCardNumber);
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
public void panNumberExists()
{
String panNumber=Keyboard.getString("Enter Pan Number :");
try
{
EmployeeManagerInterface employeeManager;
employeeManager=EmployeeManager.getEmployeeManager();
boolean vPanNumber=employeeManager.panNumberExists(panNumber);
System.out.println("Is Pan Number exists :" +vPanNumber);
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
public void isDesignationAlloted()
{
int designationCode=Keyboard.getInt("Enter a code :");
try
{
EmployeeManagerInterface employeeManager;
employeeManager=EmployeeManager.getEmployeeManager();
boolean codeFound=employeeManager.isDesignationAlloted(designationCode);
System.out.println("Is Designation Alloted to an employee :"+codeFound);
}catch(BLException blException)
{
System.out.println(blException.getGenericException());
}
}
public void countOfEmployeesWithSameDesignation()
{
int designationCode=Keyboard.getInt("Enter a code :");
try
{
EmployeeManagerInterface employeeManager;
employeeManager=EmployeeManager.getEmployeeManager();
int count;
count=employeeManager.countOfEmployeesWithSameDesignation(designationCode);
System.out.println("Employees with designation code "+ designationCode +" is "+count);
}catch(BLException blException)
{
System.out.println(blException.getGenericException());
}
}
}