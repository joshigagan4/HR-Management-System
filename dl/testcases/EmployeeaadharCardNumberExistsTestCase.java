import com.thinking.machines.hr.dl.interfaces.*;
import com.thinking.machines.hr.dl.exceptions.*;
import com.thinking.machines.hr.dl.dao.*;
import com.thinking.machines.hr.dl.dto.*;
import com.thinking.machines.common.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.io.*;
public class EmployeeaadharCardNumberExistsTestCase
{
public static void main(String gg[])
{
try
{
String aadharCardNumber=Keyboard.getString("Enter Aadhar Card Number : ");
boolean employee;
employee=new EmployeeDAO().aadharCardNumberExists(aadharCardNumber);
System.out.println(employee);
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}
}
}