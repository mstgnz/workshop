package main

import "fmt"

type circle struct {
	radius int
	border int
}

func main() {
	x := 20
	f := 123.45

	// Basic formatting
	fmt.Printf("%d\n", x)
	fmt.Printf("%x\n", x)
	fmt.Println()

	// Booleans can be printed as "true" or "false"
	fmt.Printf("%t\n", x > 10)
	fmt.Println()

	// floating point numbers
	fmt.Printf("%f\n", f)
	fmt.Printf("%e\n", f)
	fmt.Println()

	// Using explicit argument indexes
	fmt.Printf("%[2]d %[1]d\n", 52, 40)
	fmt.Println()
	// Argument indexes can be used to print values repeatedly
	fmt.Printf("%d %#[1]o %#[1]x\n", 52)
	fmt.Println()

	// Print a value in default format
	c := circle{
		radius: 20,
		border: 5,
	}
	fmt.Printf("%v\n", c)
	fmt.Printf("%+v\n", c)
	fmt.Printf("%T\n", c)
	fmt.Println()

	// Sprintf is the same as Printf, but returns a string
	s := fmt.Sprintf("%[2]d %[1]d\n", 52, 40)
	fmt.Println(s)
}
