import com.thinking.machines.hr.bl.managers.*;
import com.thinking.machines.hr.bl.interfaces.*;
import com.thinking.machines.hr.bl.exceptions.*;
import com.thinking.machines.hr.bl.pojo.*;
import com.thinking.machines.hr.bl.managers.*;
import java.util.*;

class BLEmployeesGetAllTestCase
{
public static void main(String gg[])
{
try
{
EmployeeManager employeeManager=EmployeeManager.getEmployeeManager();
List<EmployeeInterface> employees=employeeManager.getAll(EmployeeInterface.NAME);
for(EmployeeInterface employee:employees)
{
System.out.printf("EmployeeId %s,Name %s\n",employee.getEmployeeId(),employee.getName());
}
}catch(BLException blException)
{

}
}
}