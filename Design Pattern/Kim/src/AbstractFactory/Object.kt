package AbstractFactory

class Blue : Color {
    override fun fill() {
        println("Inside Blue::fill() method.")
    }
}

class Green : Color {
    override fun fill() {
        println("Inside Green::fill() method.")
    }
}

class Red: Color {
    override fun fill() {
        println("Inside Red::fill() method.")
    }
}

class Circle : Shape {
    override fun draw() {
        println("Inside Circle::draw() method")
    }
}

class Rectangle: Shape {
    override fun draw() {
        println("Inside Rectangle::draw() method")
    }
}

class Square : Shape {
    override fun draw() {
        println("Inside Square::draw() method")
    }
}