###Abstract factory and Abstract component, product

compose product of component

#####Abstraction means focus on interface(API) rather than concrete implementation

that is, compose product of component by using only API not concrete implementation

implementation is only in subclass level

#####InterFace
1. AbstractProduct <br>
&nbsp;&nbsp;
AbstractProduct defines interface(API) of abstract product(Page) and abstract component(Item)

2. AbstractFactory <br>
&nbsp;&nbsp;
AbstractFactory defines An interface(API) to create AbstractProduct


Client does not know concrete product and factory

#####Pros and Cons
1. Pros <br>
**Easy to add new Concrete Factory<br>**
&nbsp;&nbsp;
Only implement abstract factory and Product.


2. Cons <br>
&nbsp;&nbsp;
If you want to add new component or product which
has different interface to other-class, need to edit All Concrete Classes which have same SuperClass.
