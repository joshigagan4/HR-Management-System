import java.util.*;
class eg8psp
{
public static void main(String gg[])
{
List<String> list=new ArrayList<>();
long startTime=System.nanoTime();
for(int i=0;i<18000;i++)
{
String g=UUID.randomUUID().toString();
list.add(g);
Collections.sort(list);
}
long endTime;
endTime=System.nanoTime();
long timeDifference=endTime-startTime;
for(int e=0;e<list.size();e++)
System.out.println(list.get(e)); 
System.out.println(timeDifference);
}
}