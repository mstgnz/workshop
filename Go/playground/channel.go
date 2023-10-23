package main

import (
	"fmt"
	"time"
)

func main() {

	ch := make(chan string)
	fmt.Println("chan created")
	go sort(ch)
	fmt.Println("call sort func with goroutine")
	fmt.Println("waiting result....")
	result := <-ch
	fmt.Println("result : ", result)
}

func sort(c chan string) {
	a := ""
	for i := byte('a'); i <= byte('z'); i++ {
		a += string(i) + " "
		time.Sleep(time.Millisecond * 50)
	}
	c <- a
}
