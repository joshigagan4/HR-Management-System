import java.util.*;
class eg7psp
{
public static void main(String gg[])
{
List<String> list=new ArrayList<>();
int lb=0;
int ub=0;
int mid=0;
int weight=0;
String g="";
long start=System.nanoTime();
for(int i=0;i<18000;i++)
{
g=UUID.randomUUID().toString();
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
weight=g.compareTo(list.get(mid));
if(weight>0)
{
if(mid==ub)
{
list.add(ub+1,g);
break;
}
weight=g.compareTo(list.get(mid+1));
if(weight>0)
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
long end;
end=System.nanoTime();
long timeDifference=end-start;
for(int e=0;e<list.size();e++)
System.out.println(list.get(e)); 
System.out.println(timeDifference);
}
}