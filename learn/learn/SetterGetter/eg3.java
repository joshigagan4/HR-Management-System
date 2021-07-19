import java.awt.datatransfer.*;
import java.awt.*;
import java.lang.reflect.Field;
import java.util.Arrays;
class SetterGetterGenerator
{
public static void main(String gg[])
{
try
{
SetterGetterGenerator gt = new SetterGetterGenerator();
StringBuffer sb = new StringBuffer();
Class c=Class.forName(gg[0]);
//assignment
Field[] fields = c.getDeclaredFields();
for(Field f : fields)
{
String fieldName = f.getName();
String fieldType = f.getType().getSimpleName();
gt.createSetter(fieldName, fieldType, sb);
gt.createGetter(fieldName, fieldType, sb);
}
StringSelection ss=new StringSelection(sb.toString());
Clipboard clipboard;
clipboard=Toolkit.getDefaultToolkit().getSystemClipboard();
clipboard.setContents(ss,ss);
}catch(Exception e)
{
System.out.println(e);
}
}
private void createSetter(String fieldName, String fieldType, StringBuffer setter)
{
setter.append("public void").append(" set");
setter.append(getFieldName(fieldName));
setter.append("(" + fieldType + " " + fieldName + ") {");
setter.append("\n\t this."+ fieldName + " = " + fieldName + ";");
setter.append("\n" + "}" + "\n");
}
private void createGetter(String fieldName, String fieldType, StringBuffer getter)
{
getter.append("public " + fieldType).append((fieldType.equals("boolean")?" is" : " get") + getFieldName(fieldName) + "(){");
getter.append("\n\treturn " + fieldName + ";");
getter.append("\n" + "}" + "\n");
}
private String getFieldName(String fieldName)
{
return fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, fieldName.length());
}
}