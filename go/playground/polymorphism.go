package main

import (
	"fmt"
	"strings"
)

type test1 interface{
	change() string
}

type test2 struct{
	field string
}

func Test2(field string) test1{
	return &test2{field}
}

func (t *test2) change() string {
	return "test 2 : " + strings.ToUpper(t.field)
}

type test3 struct{
	field string
}

func Test3(field string) test1{
	return &test3{field}
}

func (t *test3) change() string {
	return "test 3 : " + strings.Replace(t.field, "a", "e", -1)
}


func main(){

	t2 := Test2("how are you")
	t3 := Test3("how are you")

	fmt.Println(t2)
	fmt.Println(t3)

	fmt.Println(t2.change())
	fmt.Println(t3.change())

}
