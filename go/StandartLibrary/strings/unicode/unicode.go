package main

import (
	"fmt"
	"unicode"
)

func main() {
	// Declare a sample string
	const s = "The 'quick' brown fox, jumped over the *LAZY* dog!"

	// Init some count variables
	punctCount := 0
	lowerCount, upperCount := 0, 0
	spaceCount := 0
	hexdigitCount := 0

	// iterate over the characters and call unicode function tests
	for _, ch := range s {
		if unicode.IsPunct(ch) {
			punctCount++
		}
		if unicode.IsLower(ch) {
			lowerCount++
		}
		if unicode.IsUpper(ch) {
			upperCount++
		}
		if unicode.IsSpace(ch) {
			spaceCount++
		}
		if unicode.Is(unicode.Hex_Digit, ch) {
			hexdigitCount++
		}
	}

	// Print the results
	fmt.Println("Punctuation:", punctCount)
	fmt.Println("Lowercase:", lowerCount)
	fmt.Println("Uppercase:", upperCount)
	fmt.Println("Whitespace:", spaceCount)
	fmt.Println("Hex Digits:", hexdigitCount)
}
