import com.thinking.machines.hr.dl.interfaces.*;
import com.thinking.machines.hr.dl.exceptions.*;
import com.thinking.machines.hr.dl.dao.*;
import com.thinking.machines.hr.dl.dto.*;
import com.thinking.machines.common.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.io.*;
public class EmployeepanNumberExistsTestCase
{
public static void main(String gg[])
{
try
{
String panNumber=Keyboard.getString("Enter PAN Number : ");
boolean employee;
employee=new EmployeeDAO().panNumberExists(panNumber);
System.out.println(employee);
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}
}
}