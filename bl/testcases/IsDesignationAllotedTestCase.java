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
class IsDesignationAllotedTestCase
{
public static void main(String gg[])
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
}