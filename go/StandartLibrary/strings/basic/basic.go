package main

import (
	"fmt"
	"strings"

	"golang.org/x/text/cases"
	"golang.org/x/text/language"
)

func main() {
	s := "The quick brown fox jumps over the lazy dog"

	// Basic string operations

	// Length of string
	fmt.Println("Length of string", len(s))

	// iterate over each character
	fmt.Println("\niterate over each character")
	for _, ch := range s {
		//fmt.Print(string(ch), ",")
		if string(ch) == " " {
			fmt.Print(",")
		} else {
			fmt.Print(string(ch))
		}
	}
	fmt.Println()

	// Using operators < > == !=
	fmt.Println("\nUsing operators < > == !=")
	fmt.Println("dog" < "cat")
	fmt.Println("dog" < "horse")
	fmt.Println("dog" == "Dog")

	// Comparing two strings
	fmt.Println("\nComparing two strings")
	result := strings.Compare("dog", "cat")
	fmt.Println(result)
	result = strings.Compare("dog", "dog")
	fmt.Println(result)

	// EqualFold tests using Unicode case-folding
	fmt.Println("\nEqualFold tests using Unicode case-folding")
	fmt.Println(strings.EqualFold("Hello", "hello"))

	// ToUpper, ToLower, Title
	fmt.Println("\nToUpper, ToLower, Title")
	s1 := strings.ToUpper(s)
	s2 := strings.ToLower(s)
	s3 := cases.Title(language.Turkish).String(s)
	fmt.Println("s1", s1)
	fmt.Println("s2", s2)
	fmt.Println("s3", s3)
}
