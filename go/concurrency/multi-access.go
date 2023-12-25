package main

import (
	"log"
	"math/rand"
	"time"
)

type Seat int
type Bar chan Seat

func (bar Bar) ServeCustomer(fast string) {
	log.Printf("%s enters the bar", fast)
	seat := <-bar // need a seat to drink
	log.Printf("%s drinks at %d", fast, seat)
	time.Sleep(time.Second * time.Duration(2+rand.Intn(6)))
	log.Printf("%s frees %d", fast, seat)
	bar <- seat // free seat and leave the bar
}

func main() {
	rand.NewSource(time.Now().UnixNano())

	bar := make(Bar, 3)

	for seatId := 0; seatId < cap(bar); seatId++ {
		bar <- Seat(seatId)
	}
	furious := []string{"Dom", "Brian", "Letty", "Mia", "Roman", "Tej"}
	for _, fast := range furious {
		time.Sleep(time.Second)
		go bar.ServeCustomer(fast)
	}

}
