package main

import (
	"fmt"
)

type shape interface {
	area() float64
	circumference() float64
}

func shapeFunc(s shape){
	fmt.Println(s)
	fmt.Println(s.area())
	fmt.Println(s.circumference())
	fmt.Printf("%T \n", s)
}

type rectangle struct{
	a,b  float64
}

func (r rectangle) area() float64{
	return r.a * r.b
}

func (r rectangle) circumference() float64{
	return 2 * (r.a + r.b)
}

func main(){

	r1 := rectangle{3,5}
	fmt.Println("Area:", r1.area())
	fmt.Println("Circumference:", r1.circumference())

	shapeFunc(r1)

}
