package main

import (
	"fmt"
	"strings"
)

func main() {
	// The map function returns a copy of a string with the characters modified
	// according to the mapping function
	shift := 11
	s := "The quick brown fox jumps over the lazy dog"

	// Create the mapping function
	transform := func(r rune) rune {
		switch {
		case r >= 'A' && r <= 'Z':
			value := int('A') + (int(r) - int('A') + shift)
			if value > 91 {
				value -= 26
			} else if value < 65 {
				value += 26
			}
			return rune(value)
		case r >= 'a' && r <= 'z':
			value := int('a') + (int(r) - int('a') + shift)
			if value > 122 {
				value -= 26
			} else if value < 97 {
				value += 26
			}
			return rune(value)
		case r == ' ':
			return rune('-')
		case r == rune('-'):
			return ' '
		}
		return r
	}

	// Encode the message
	encode := strings.Map(transform, s)
	fmt.Println(encode)

	// Decode the message
	shift = -shift
	decode := strings.Map(transform, encode)
	fmt.Println(decode)
}
