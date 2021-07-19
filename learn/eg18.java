import java.util.*;
class psp
{
public static void main(String gg[])
{
List<String> list=new ArrayList<>();
int weight=0;
int index=0;
String g="";
int z=0;
int k=0;
while(k<18000)
{
g=UUID.randomUUID().toString();
/*if(list.size()==0)
{
list.add(g);
k++;
continue;
}*/
for(int i=0;i<list.size();i++)
{
weight=g.compareTo(list.get(i));
if(weight<0)
{
z=1;
index=i;
break;
}
}
if(z==1)list.add(index,g);
else list.add(g);
k++;
}
for(int i=0;i<list.size();i++)
{
System.out.println(list.get(i));
}
}
}