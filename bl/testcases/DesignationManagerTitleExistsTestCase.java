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
class DesignationManagerTitleExistsTestCase
{
public static void main(String gg[])
{
String title=Keyboard.getString("Enter designation title:");
try
{
DesignationManagerInterface designationManager;
designationManager=DesignationManager.getDesignationManager();
boolean vTitle=designationManager.titleExists(title);
System.out.printf("Is Designation code exists :" +vTitle);
}catch(BLException blException)
{
System.out.println(blException.getGenericException());
}
}
}