package main

import "fmt"

func main() {
	// Print a simple string, no newline
	fmt.Print("Welcome to go! ")

	// Print with a newline
	fmt.Println("This string ends with a new line")

	// Print a string with values
	const answer = 42
	fmt.Println("The answer to life is", answer)

	// Print a string with multiple interspersed values
	const a, b, c = 5, 5, 10
	fmt.Println("Add", a, "and", b, "you get", c)

	// print a slice of data
	items := []int{10, 20, 40, 80}
	length, err := fmt.Println(items)
	fmt.Println(length, err)
}
