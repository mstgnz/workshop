package main

import (
	"fmt"
)

func main(){

	var abc = "abc"

	fmt.Printf("abc pointer is: %v and pointer value is: %v", &abc, *&abc)

	x := 55
	y := &x

	fmt.Println(x,y)
	*y = 19
	fmt.Println(x,*y)

	// array -> pass by value
	fmt.Println("Array")
	arr1 := [2]int{4,5}
	arr2 := arr1
	fmt.Println(arr1, arr2)
	arr2[1] = 6
	fmt.Println(arr1, arr2)

	fmt.Println("Array Pointer")
	arr3 := [2]int{4,5}
	arr4 := &arr3 // Pay attention to the assignment process, although it is a pass by value, we have added a pass by reference function.
	fmt.Println(arr3, *arr4)
	arr4[1] = 6
	fmt.Println(arr3, *arr4)


}

