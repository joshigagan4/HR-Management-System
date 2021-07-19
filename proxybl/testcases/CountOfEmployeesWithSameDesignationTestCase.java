import com.thinking.machines.hr.bl.interfaces.*;
import com.thinking.machines.hr.bl.pojo.*;
import com.thinking.machines.hr.bl.exceptions.*;
import com.thinking.machines.hr.bl.managers.*;
import java.util.*;
import com.thinking.machines.hr.dl.dao.*;
import com.thinking.machines.hr.dl.exceptions.*;
import com.thinking.machines.hr.dl.interfaces.*;
import com.thinking.machines.hr.dl.dto.*;
import com.thinking.machines.common.*;
class CountOfEmployeesWithSameDesignationTestCase
{
public static void main(String gg[])
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