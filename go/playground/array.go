package main

import (
	"fmt"
)

func main(){

	// array
	var arr1 [4]int
	fmt.Printf("Arr1 -> %T, %v\n", arr1, arr1)

	// slice
	var slc1 []int
	fmt.Printf("Arr2 -> %T, %v\n",slc1, slc1)

	fmt.Println()

	// array copy -> pass by value
	fmt.Println("Array Copy")
	arr2 := [3]int{1,2,3}
	arr3 := arr2
	fmt.Println(arr2, arr3)
	arr3[1] = 100
	fmt.Println(arr2, arr3)

	// slice copy -> pass by reference
	fmt.Println("Slice Copy")
	slc2 := []int{1,2,3}
	slc3 := slc2
	fmt.Println(slc2, slc3)
	slc2[1] = 55
	fmt.Println(slc2, slc3) // same, because slice is reference type
	fmt.Printf("%p, %p\n",slc2, slc3)
	// append element slice
	fmt.Println("Append Slice")
	slc2 = append(slc2, 11)
	fmt.Println(slc2, slc3)
	slc2[0] = 99
	fmt.Println(slc2, slc3)
	fmt.Printf("%p, %p\n",slc2, slc3) // expansion operation changes reference
	fmt.Println()

	// underArray
	fmt.Println("Under Array")
	underArray := [...]int{1,2,3,4,5}
	fmt.Printf("under array -> %T - %v \n", underArray, underArray)
	slc4 := underArray[1:3]
	fmt.Printf("slice -> %T %v \n", slc4, slc4)

	// make - copy
	fmt.Println("make and copy")
	slc5, slc6 := make([]int, 2), make([]int, 2)
	fmt.Println(slc5, slc6)
	slc5[0] = 77
	slc5[1] = 88
	copy(slc6, slc5)
	fmt.Printf("slc5: %v, slc6: %v, slc5 pointer %p, slc6 pointer %p",slc5, slc6,slc5,slc6)


}
