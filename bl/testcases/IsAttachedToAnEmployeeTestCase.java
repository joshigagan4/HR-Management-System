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
class IsAttachedToAnEmployeeTestCase
{
public static void main(String gg[])
{
int code=Keyboard.getInt("Enter a code :");
try
{
DesignationManagerInterface designationManager;
designationManager=DesignationManager.getDesignationManager();
boolean codeFound=designationManager.isAttachedToAnEmployee(code);
System.out.println("Attached to an Employee :"+codeFound);
}catch(BLException blException)
{
System.out.println(blException.getGenericException());
}
}
}