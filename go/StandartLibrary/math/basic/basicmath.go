package main

import (
	"fmt"
	"math"
)

func main() {
	fmt.Println(math.Pi)

	// Ceiling and Floor functions
	fmt.Println(math.Ceil(math.Pi))
	fmt.Println(math.Floor(math.Pi))

	// Truncate will return int value of X
	fmt.Printf("%.2f\n", math.Trunc(math.Pi))

	// Max and Min values
	fmt.Println(math.Max(math.Pi, math.Ln2))
	fmt.Println(math.Min(math.Pi, math.Ln2))

	// Mod operator is like % but for floats
	fmt.Println(17 % 5)
	fmt.Println(math.Mod(17.0, 5.0))

	// Round and RoundToEven
	fmt.Printf("%.1f\n", math.Round(10.5))
	fmt.Printf("%.1f\n", math.Round(-10.5))

	fmt.Printf("%.1f\n", math.RoundToEven(10.5))
	fmt.Printf("%.1f\n", math.RoundToEven(11.5))
}
