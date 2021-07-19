import com.thinking.machines.hr.bl.interfaces.*;
import com.thinking.machines.hr.bl.pojo.*;
import com.thinking.machines.hr.bl.exceptions.*;
import com.thinking.machines.hr.bl.managers.*;
import java.math.*;
import java.text.*;
import java.io.*;
import java.util.*;
import com.thinking.machines.hr.dl.dao.*;
import com.thinking.machines.hr.dl.exceptions.*;
import com.thinking.machines.hr.dl.interfaces.*;
import com.thinking.machines.hr.dl.dto.*;
import com.thinking.machines.common.*;
class EmployeeManagerGetByEmployeeIdTestCase
{
public static void main(String gg[])
{
SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
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
String vDateOfBirth=simpleDateFormat.format(employee.getDateOfBirth());
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
}
