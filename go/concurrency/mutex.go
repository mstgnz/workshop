package main

import "fmt"

func main() {
	mutex := make(chan struct{}, 1)

	counter := 0
	increase := func() {
		mutex <- struct{}{} // lock
		counter++
		<-mutex // unlock
	}

	hundred := func(done chan<- struct{}) {
		for i := 0; i < 1000; i++ {
			increase()
		}
		done <- struct{}{}
	}

	done := make(chan struct{})
	go hundred(done)
	go hundred(done)
	<-done
	<-done
	fmt.Println(counter)
}
