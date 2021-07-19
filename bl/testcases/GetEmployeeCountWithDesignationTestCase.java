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
class GetEmployeeCountWithDesignationTestCase
{
public static void main(String gg[])
{
int code=Keyboard.getInt("Enter a code :");
try
{
DesignationManagerInterface designationManager;
designationManager=DesignationManager.getDesignationManager();
int count;
count=designationManager.getEmployeesCountWithDesignation(code);
System.out.println("Employees with designation code "+ code +" is "+count);
}catch(BLException blException)
{
System.out.println(blException.getGenericException());
}
}
}