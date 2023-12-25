package main

import (
	"fmt"
)

func main(){

	var map1 = map[string]string{}
	fmt.Println(map1)

	map1["abc"] = "def"
	map1["lorem"] = "ipsum"

	fmt.Println(map1["not found"])

	for k, v := range map1 {
		fmt.Println(k,v)
	}

	// map pass by reference
	map2 := map1
	fmt.Println(map1, map2)
	map2["abc"] = "xyz"
	fmt.Println(map1, map2)
	map2["new"] = "content"
	fmt.Println(map1, map2)

	// exists key
	fmt.Println("Exists Key")
	val, ok := map1["abc"]
	fmt.Println(val, ok)

	// not exists key
	fmt.Println("Not Exists Key")
	val, ok = map1["not"]
	fmt.Println(val,ok)

	// delete key
	fmt.Println("Delete Key")
	fmt.Println(map1)
	delete(map1, "abc")
	fmt.Println(map1)

}
