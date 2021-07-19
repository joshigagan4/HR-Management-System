import com.thinking.machines.hr.dl.dao.*;
import com.thinking.machines.hr.dl.exceptions.*;
import com.thinking.machines.common.*;
class EmployeeDeleteTestCase
{
public static void main(String gg[])
{
try
{
String employeeId=Keyboard.getString("Enter employee Id to Delete : ");
new EmployeeDAO().delete(employeeId);
System.out.println("Employee with Id : "+employeeId+" deleted");
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}
}
}