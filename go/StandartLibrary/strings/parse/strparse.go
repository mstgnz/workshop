package main

import (
	"fmt"
	"strconv"
)

func main() {
	sampleint := 100
	samplestr := "250"

	// This does a character conversion, not a numerical one
	newstr := string(rune(sampleint))
	fmt.Println("Result of using string():", newstr)

	// The strconv package contains a variety of functions for parsing and formatting
	// numbers, values, and strings

	// Convert an integer to string
	s := strconv.Itoa(sampleint)
	fmt.Printf("%T, %v\n", s, s)

	// Convert a string to integer
	sampleint, err := strconv.Atoi(samplestr)
	if err != nil {
		fmt.Println(err.Error())
	}
	fmt.Printf("%T, %v\n", sampleint, sampleint)

	// Other parse functions
	b, _ := strconv.ParseBool("true")
	fmt.Println(b)
	f, _ := strconv.ParseFloat("3.14159", 64)
	fmt.Println(f)
	i, _ := strconv.ParseInt("-42", 10, 64)
	fmt.Println(i)
	u, _ := strconv.ParseUint("42", 10, 64)
	fmt.Println(u)

	// Other format functions
	s = strconv.FormatBool(true)
	fmt.Println(s)
	s = strconv.FormatFloat(3.14159, 'E', -1, 64)
	fmt.Println(s)
	s = strconv.FormatInt(-42, 10)
	fmt.Println(s)
	s = strconv.FormatUint(42, 10)
	fmt.Println(s)
}
