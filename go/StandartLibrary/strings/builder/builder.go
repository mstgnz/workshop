package main

import (
	"fmt"
	"strings"
)

func main() {
	// Declare an empty strings.Builder
	var sb strings.Builder

	// Write some content
	sb.WriteString("This is string 1\n")
	sb.WriteString("This is string 2\n")
	sb.WriteString("This is string 3\n")

	// Output the concatenated string
	fmt.Println(sb.String())

	// Examine the builder's capacity
	fmt.Println("Capacity:", sb.Cap())

	// Grow the capacity - use this if you know in advance how much data
	// you're going to be writing into the buffer to minimize copies
	sb.Grow(1024)
	fmt.Println("Capacity:", sb.Cap())

	for i := 0; i <= 10; i++ {
		fmt.Fprintf(&sb, "String %d -- ", i)
	}
	fmt.Println(sb.String())

	// we can get the length of what the final string will be
	fmt.Println("Builder size is", sb.Len())

	// The Reset function will reset the builder to original state
	sb.Reset()
	fmt.Println("After Reset:")
	fmt.Println("Capacity:", sb.Cap())
	fmt.Println("Builder size is", sb.Len())
}
