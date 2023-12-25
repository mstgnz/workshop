package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	reader := bufio.NewReader(os.Stdin)

	fmt.Print("write something : ")
	s, _ := reader.ReadString('\n')
	fmt.Print(s)
}
