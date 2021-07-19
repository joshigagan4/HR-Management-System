import java.util.*;
class eg6psp
{
public static void main(String gg[])
{
ArrayList<String> list=new ArrayList<String>();
int lb=0;
int ub=0;
int mid=0;
int compare=0;
long startTime=System.nanoTime();
for(int i=0;i<18000;i++)
{
String g=UUID.randomUUID().toString();
if(list.size()==0)
{
list.add(g);
continue;
}
lb=0;
ub=list.size()-1;
while(true)
{
mid=(lb+ub)/2;
compare=g.compareTo(list.get(mid));
if(compare>0)
{
if(mid==ub)
{
list.add(ub+1,g);
break;
}
compare=g.compareTo(list.get(mid+1));
if(compare>0)
{
lb=mid+1;
}
else
{
list.add(mid+1,g);
break;
}
}
else
{
if(mid==ub)
{
list.add(ub,g);
break;
}
ub=mid;
}
}
}
long endTime;
endTime=System.nanoTime();
long timeDifference=endTime-startTime;
for(int j=0;j<list.size();j++)
System.out.println(list.get(j)); 
System.out.println(timeDifference);
}
}
 