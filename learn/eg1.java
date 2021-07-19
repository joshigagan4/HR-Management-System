import java.util.*;
class eg1psp
{
public static void main(String gg[])
{
List<String> list=new ArrayList<>();
long starTime=System.nanoTime();
System.out.println(starTime);
for(int k=0;k<18000;k++)
{
String g=UUID.randomUUID().toString();
if(list.size()==0) 
{
list.add(g);
}
int index=0;
int compare=0;
while(index<list.size())
{
compare=g.compareTo(list.get(index));
if(compare>0)
{
index++;
}
if(compare<=0)
{
break;
}
}
list.add(index,g);
}
for(int i=0;i<list.size();i++)
{
System.out.println(list.get(i));
}
long currentTime=System.nanoTime()-starTime;
System.out.println(currentTime);
}
}