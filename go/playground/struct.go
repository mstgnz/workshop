package main

import (
	"fmt"
)

type employee struct{ // employee has an address
	firstname string
	lastname string
	age int
	address
}

type address struct{
	home string
	work string
}

func getFirstName(emp employee) string{
	return emp.firstname
}

func (emp * employee) getFirstName() string{
	return emp.firstname
}


func main(){

	e1 := employee{"Mesut", "GENEZ",36, address{
		"home", "work",
	}}
	e2 := employee{"Muhammet","GENEZ",22, address{
		"home", "work",
	}}
	e3 := employee{}

	add1 := address{"home address", "work address"}

	e3.address = add1
	e3.firstname = "captain jack"
	e3.lastname = "sparrow"

	e4 := e1 // struct pass by value
	e4.age = 35

	fmt.Println(e1.getFirstName(), e2.getFirstName())
	fmt.Println(getFirstName(e1), getFirstName(e2))
	fmt.Println(e3)
	fmt.Println(add1)
	fmt.Println(e1.age, e4.age)

	// anonymous struct
	fmt.Println("Anonymous")
	anonymous := struct {
		field1 string
		field2 int
		field3 map[int]string
		field4 struct{
			field5 string
		}
		field6 interface{
			field7()
		}
	}{
		field1: "Field 1",
		field2: 2,
		field3: nil,
		field6: nil,
		field4: struct{ field5 string }{field5: "Field 5"},
	}

	fmt.Println(anonymous)
}
