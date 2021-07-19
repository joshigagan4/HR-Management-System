import com.thinking.machines.hr.bl.managers.*;
import com.thinking.machines.hr.bl.exceptions.*;
import com.thinking.machines.hr.bl.pojo.*;
import com.thinking.machines.hr.bl.interfaces.*;
import java.util.*;
class GetEmployeesTestCase
{
public static void main(String gg[])
{
try
{
EmployeeManager em=EmployeeManager.getEmployeeManager();
List<EmployeeInterface> employees=em.employees();
for(EmployeeInterface employee:employees)
{
//System.out.printf("Code %d ,Title %s \n",designation.getCode(),designation.getTitle());
System.out.printf("Name:",employee.getName());


}

}catch(BLException blException)
{
if(blException.hasGenericException()) System.out.println(blException.getGenericException());
}
}
}