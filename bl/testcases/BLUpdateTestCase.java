import com.thinking.machines.hr.dl.exceptions.*;
import com.thinking.machines.hr.dl.interfaces.*;
import com.thinking.machines.hr.dl.dto.*;
import com.thinking.machines.hr.dl.dao.*;
import com.thinking.machines.hr.bl.interfaces.*;
import com.thinking.machines.hr.bl.exceptions.*;
import com.thinking.machines.hr.bl.managers.*;
import com.thinking.machines.hr.bl.pojo.*;
import java.util.*;
class BLUpdateTestCase
{
public static void main(String gg[])
{
int code=Integer.parseInt(gg[0]);
String title=gg[1];
try
{
DesignationInterface designation;
designation=new Designation();
designation.setCode(code);
designation.setTitle(title);
DesignationManager d=DesignationManager.getDesignationManager();
d.update(designation);
System.out.println(d.getCount());
System.out.println("Designation : "+title+" updated with code as : "+designation.getCode());
}catch(BLException b)
{
List<String> list=b.getExceptions();
for(String g:list)
System.out.println(g);
}
}
}