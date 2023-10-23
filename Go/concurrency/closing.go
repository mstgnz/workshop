package main

import (
	"fmt"
)

func closingChan(c chan int) {
	for i := 10; i > 0; i-- {
		c <- i*i ^ i
	}
	close(c)
}

func main() {
	ch := make(chan int)
	go closingChan(ch)

	for {
		val, ok := <-ch
		if ok == false {
			break
		}
		fmt.Print(val, " ")
	}
}
