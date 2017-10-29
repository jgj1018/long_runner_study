**Actor**
1. Builder
<br />
It defines API to create Instance. 
In builder, methods are defined to create
every single part. 

2. ConcreteBuilder
<br />
It implements API of Builder. 

3. Director
<br />
Director make Instance using API of Builder
**Do not rely on the ConcreteBuilder. Only use Builder API**

Concrete Builders can be substituted because they are encapsulated

The difference to Abstract Factory :
Builder should have order