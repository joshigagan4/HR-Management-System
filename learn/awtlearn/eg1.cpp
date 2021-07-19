#include<iostream>
using namespace std;
//the following code is being written by amit in year 2020
class Bulb;
class BulbEvent
{
private:
Bulb *source;
int oldWattage;
int newWattage;
public:
BulbEvent(Bulb *source,int oldWattage,int newWattage)
{
this->source=source;
this->oldWattage=oldWattage;
this->newWattage=newWattage;
}
Bulb * getSource()
{
return this->source;
}
int getOldWattage()
{
return this->oldWattage;
}
int getNewWattage()
{
return this->newWattage;
}
};
class BulbListener
{
public:
virtual void wattageChanged(BulbEvent *)=0;
};
class Bulb
{
private:
BulbListener *target;
int w;
public:
Bulb()
{
this->w=0;
this->target=NULL;
}
void addBulbListener(BulbListener *target)
{
this->target=target;
}
void setWattage(int w)
{
if(this->w!=w)
{
int oldWattage=this->w;
this->w=w;
if(target!=NULL)
{
BulbEvent *be=new BulbEvent(this,oldWattage,this->w);
target->wattageChanged(be);
}
}
}
int getWattage()
{
return this->w;
}
};
//the following code is being written by bobby in year 2021
class Whatever:public BulbListener
{
private:
Bulb *b1,*b2;
public:
Whatever()
{
b1=new Bulb;
b2=new Bulb;
b1->addBulbListener(this);
b2->addBulbListener(this);
}
void doSomething()
{
b1->setWattage(60);
b2->setWattage(100);
}
virtual ~Whatever()
{
delete b1;
delete b2;
}
void wattageChanged(BulbEvent *ev)
{
if(ev->getSource()==b1)
{
cout<<"Wattage of the object to which b1 is pointing to changed from "<<ev->getOldWattage()<<" to "<<ev->getNewWattage()<<endl;
}
if(ev->getSource()==b2)
{
cout<<"Wattage of the object to which b2 is pointing to changed from "<<ev->getOldWattage()<<" to "<<ev->getNewWattage()<<endl;
}
delete ev;
}
};
int main()
{
Whatever *w=new Whatever;
w->doSomething();
delete w;
return 0;
}

