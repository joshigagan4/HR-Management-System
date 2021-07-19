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
class EmployeeManagerGetAllTestCase
{
public static void main(String gg[])
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
}