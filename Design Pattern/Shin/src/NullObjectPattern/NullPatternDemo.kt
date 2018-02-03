package NullObjectPattern

import NullObjectPattern.customer.AbstractCustomer
import NullObjectPattern.factory.CustomerFactory

fun main(args: Array<String>) {
    val customer1:AbstractCustomer = CustomerFactory.getCustomer("Rob")
    val customer2:AbstractCustomer = CustomerFactory.getCustomer("Bob")
    val customer3:AbstractCustomer = CustomerFactory.getCustomer("Julie")
    val customer4:AbstractCustomer = CustomerFactory.getCustomer("Laura")

    println("Customers")
    println(customer1.name)
    println(customer2.name)
    println(customer3.name)
    println(customer4.name)
}