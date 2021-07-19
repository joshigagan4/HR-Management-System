import com.thinking.machines.hr.dl.interfaces.*;
import com.thinking.machines.hr.dl.exceptions.*;
import com.thinking.machines.hr.dl.dao.*;
import com.thinking.machines.hr.dl.dto.*;
import com.thinking.machines.common.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.io.*;
public class EmployeeAddTestCase
{
public static void main(String gg[])
{
SimpleDateFormat sdf;
sdf=new SimpleDateFormat("dd/MM/yyyy");
try
{
String name=Keyboard.getString("Enter name : ");
int designationCode=Keyboard.getInt("Enter Designation Code : ");
Date dateOfBirth=sdf.parse(Keyboard.getString("Enter date of birth dd/MM/yyyy :"));
BigDecimal basicSalary=new BigDecimal(Keyboard.getString("Enter basic salary : "));
String i=Keyboard.getString("Is the employee is an Indian resident(Y/N) :");
if(i.equals("Y")==false && i.equals("N")==false)
{
System.out.println("Invalid input\n");
return;
} 
boolean isIndian=i.equals("Y");
String g=Keyboard.getString("Enter gender (M/F) : ");
if(g.equals("M")==false && g.equals("F")==false)
{
System.out.println("Invalid input\n");
return;
}
EmployeeDTOInterface.GENDER gender;
if(g.equals("M"))
{
gender=EmployeeDTOInterface.MALE;
}
else
{
gender=EmployeeDTOInterface.FEMALE;
}
String panNumber=Keyboard.getString("Enter PAN Number :");
String aadharCardNumber=Keyboard.getString("Enter Aadhar Card Number : ");
EmployeeDTOInterface employeeDTO;
employeeDTO=new EmployeeDTO();
employeeDTO.setName(name);
employeeDTO.setDesignationCode(designationCode);
employeeDTO.setDateOfBirth(dateOfBirth);
employeeDTO.setBasicSalary(basicSalary);
employeeDTO.isIndian(isIndian);
employeeDTO.setGender(gender);
employeeDTO.setPANNumber(panNumber);
employeeDTO.setAadharCardNumber(aadharCardNumber);
EmployeeDAOInterface employeeDAO;
employeeDAO=new EmployeeDAO();
employeeDAO.add(employeeDTO);
String employeeId=employeeDTO.getEmployeeId();
System.out.println("Employee Added with Employee id as : "+employeeId);
}catch(DAOException daoException)
{
System.out.println(daoException);
}
catch(ParseException parseException)
{
System.out.println(parseException);
}
}
}