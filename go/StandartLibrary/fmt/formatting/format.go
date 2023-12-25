package main

import "fmt"

func main() {
	f := 123.4567

	// control the decimal precision
	fmt.Printf("%.2f\n", f)

	// print with width 10 and default precision
	fmt.Printf("%10f\n", f)

	// print with padding and precision
	fmt.Printf("%10.2f\n", f)

	// always use a + sign
	fmt.Printf("%+10.2f\n", f)

	// pad with 0s instead of spaces
	fmt.Printf("%010.4f\n", f)
}
