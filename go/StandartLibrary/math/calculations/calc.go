package main

import (
	"fmt"
	"math"
)

func main() {
	x := 10.0

	// Absolute value
	fmt.Println(math.Abs(x), math.Abs(-x))

	// Pow (x^y) and Exp (e^x)
	fmt.Println(math.Pow(x, 2.0))
	fmt.Println(math.E, math.Exp(x))

	// Trigonometry and other functions
	fmt.Println(math.Cos(math.Pi))
	fmt.Println(math.Sin(math.Pi / 2))
	fmt.Println(math.Tan(math.Pi / 2))

	fmt.Println(math.Log(10))

	// Square and cube roots
	fmt.Println(math.Sqrt(25))
	fmt.Println(math.Cbrt(125))

	// calculate the Hypotenuse of a right triangle
	fmt.Println(math.Hypot(30, 40))
}
