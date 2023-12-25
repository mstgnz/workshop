package main

import (
	"fmt"
	"strings"
)

func main() {
	fname := "filename.txt"
	fname2 := "temp_picfile.jpeg"
	vowels := "aeiouAEIOU"
	s := "The quick brown fox jumps over the lazy dog"

	// Common string searching functions

	// Use Contains to see if a substring is in a string
	fmt.Println(strings.Contains(s, "jump"))
	// Use ContainsAny to see if any of the given chars are in the string
	fmt.Println(strings.ContainsAny(s, "abcd"))

	// Use Index to find the offset of the first instance of a substring
	fmt.Println(strings.Index(s, "fox"))
	fmt.Println(strings.Index(s, "cat"))
	// Use IndexAny to find the first instance of any of the given chars
	fmt.Println(strings.IndexAny("grzbl", vowels))
	fmt.Println(strings.IndexAny("Golang!", vowels))

	// HasPrefix and HasSuffix can be used to see if a string starts with
	// or ends with a specific substring
	fmt.Println(strings.HasSuffix(fname, "txt"))
	fmt.Println(strings.HasPrefix(fname2, "temp"))

	// Count returns the number of non-overlapping instances of a substring
	fmt.Println(strings.Count(s, "the"))
	fmt.Println(strings.Count(s, "he"))
}
