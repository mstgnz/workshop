package LinearLinkedList

import "fmt"

func NodePrint(node *Node) {

	// iter objesi üzerinden tüm node objelerinin next değeri nil olana kadar döngü ile yazdırabiliriz.
	fmt.Println("root objesini fonksiyon üzerinden döngü ile iterable")
	iter := node
	for iter != nil {
		fmt.Println(iter.X)
		iter = iter.Next
	}
}
