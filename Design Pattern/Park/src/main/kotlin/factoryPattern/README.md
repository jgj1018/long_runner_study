>interface(framework of process) in SuperClass
>>implement of method which creates instance in concreteClass
>>>Factory Pattern is the parallel Pattern
####Creation Pattern version of template Method pattern 

#####concept : making separation between implementation and interface of creation process

**Actor**
1. Creator
2. Product    
3. ConcreteCreator
4. ConcreteProduct

Role of Product<br />
&nbsp;&nbsp;Defining Interface of ConcreteProduct

Role of Creator <br />
&nbsp;&nbsp;Create the Product. Concrete process is implemented in ConcreteCreator.
Creator doesn't know about ConcreteProduct which is created in practice.
Creator only knows that if creation method is called, Product is created.
Super class is being free from Concretion(Dependency invasion principle) by deferring "new()" to subClass
and substitute creation with calling creation method.

_factory pattern can be used to make products which have nothing to do with each others by extension, don't have to 
rewrite code_ 
#framework never relies on the Concretes. 


Way to make creation method
1. make abstract method
2. make default case
3. raise exception