package main

/*
	Bu içerik Şadi Evren ŞEKER'in Youtube platformunda yer alan BilgisayarKavramlari kanalında yayınladığı veri yapıları eğitim serisinden ilham alınarak hazırlanmıştır. Eğitim serisinde c ile veri yapıları işlenmektedir. Bu içerik bir nevi go versiyonu sayılabilir.
	link : https://www.youtube.com/watch?v=r3uOBb3BM-0&list=PLh9ECzBB8tJN9bckI6FbWB03HkmogKrFT
*/

import (
	"fmt"

	"github.com/mstgnz/workshop/go/DataStructures/CircularLinkedList"
	"github.com/mstgnz/workshop/go/DataStructures/DoubleLinkedList"
	"github.com/mstgnz/workshop/go/DataStructures/LinearLinkedList"
	"github.com/mstgnz/workshop/go/DataStructures/Queue"
	"github.com/mstgnz/workshop/go/DataStructures/Stack"
	"github.com/mstgnz/workshop/go/DataStructures/Tree"
)

func main() {

	// Linear Linked List, Her node bir sonraki node objesinin referansını tutar.
	linearLinkedList()

	// Circular Linked List, Son node'un next'i root node'unu gösterir.
	// circularLinkedList()

	// Double Linked List, Her node bir sonraki ve bir önceki node objesinin referansını tutar. Çift yönlü linkleme sağlanır.
	// doubleLinkedList()

	// Array Stack
	// stackArray()

	// Linked List Stack
	// stackLinkedList()

	// Array Queue
	// queueArray()

	// Linked List Queue
	// queueLinkedList()

	// Binary Tree
	// binaryTree()

}

// Double Linked List
func doubleLinkedList() {
	myDoubleLinkedList := DoubleLinkedList.Node{X: 5, Next: nil, Prev: nil}

	myDoubleLinkedList.AddToEnd(3)
	myDoubleLinkedList.AddToEnd(9)
	myDoubleLinkedList.AddToEnd(12)
	myDoubleLinkedList.AddToEnd(15)

	myDoubleLinkedList.Delete(3)
	myDoubleLinkedList.Delete(12)

	myDoubleLinkedList.AddToBetween(20, 5)

	myDoubleLinkedList.AddToSequentially(4)
	myDoubleLinkedList.AddToSequentially(11)

	myDoubleLinkedList.AddToStart(1)
	myDoubleLinkedList.AddToStart(2)

	myDoubleLinkedList.Print(false)
	fmt.Println("-----")
	myDoubleLinkedList.Print(true)

}

// Circular Linked List
func circularLinkedList() {
	myCircularLinkedList := CircularLinkedList.Node{X: 12, Next: nil}
	myCircularLinkedList.Next = &myCircularLinkedList

	myCircularLinkedList.AddToEnd(33)

	myCircularLinkedList.AddToSequentially(11)
	myCircularLinkedList.AddToSequentially(22)

	myCircularLinkedList.AddToStart(55)

	myCircularLinkedList.AddToBetween(66, 11)

	myCircularLinkedList.Delete(11)
	myCircularLinkedList.Delete(55)

	myCircularLinkedList.Print()
}

// Linear Linked List
func linearLinkedList() {

	// ilk adımlar
	// LinearLinkedList.Approach()

	// Eleman ekleme ve yazdırma
	// LinearLinkedList.GenerateElement()

	// Araya eleman ekleme ve harici yazdırma dosyası
	// LinearLinkedList.AddElementBetween()

	// Sıralı eleman ekleme
	// LinearLinkedList.AddSequentially()

	// Eleman Silme
	// LinearLinkedList.DeleteElement()

	// struct objesi üzerinden tüm methodları kullanabiliriz.
	// yukarda yapılan örneklerin hepsi artık struct objemizin birer methodu haline geldi.
	myLinearLinkedList := LinearLinkedList.Node{X: 23, Next: nil}

	myLinearLinkedList.AddToEnd(21)
	myLinearLinkedList.AddToEnd(33)
	myLinearLinkedList.AddToEnd(44)

	myLinearLinkedList.AddToStart(3)

	myLinearLinkedList.AddToSequentially(5)
	myLinearLinkedList.AddToSequentially(35)
	myLinearLinkedList.AddToSequentially(55)

	myLinearLinkedList.AddToBetween(12, 21)
	myLinearLinkedList.AddToBetween(66, 35)

	myLinearLinkedList.Delete(23)

	myLinearLinkedList.Print()
}

// Array Stack
func stackArray() {
	myArrayStack := Stack.ArrayStack()
	//myArrayStack.Constructor()
	myArrayStack.Push(33)
	myArrayStack.Push(55)
	myArrayStack.Print()
	myArrayStack.Push(65)
	myArrayStack.Print()
	myArrayStack.Push(76)
	myArrayStack.Print()
	myArrayStack.Push(86)
	myArrayStack.Print()
	myArrayStack.Pop()
	myArrayStack.Print()
	myArrayStack.Pop()
	myArrayStack.Print()
	myArrayStack.Pop()
	myArrayStack.Print()

}

// LinkedList Stack
func stackLinkedList() {
	myArrayStack := Stack.LinkedListStack(22)
	myArrayStack.Push(33)
	myArrayStack.Push(55)
	myArrayStack.Push(66)
	myArrayStack.Print()
	myArrayStack.Push(65)
	myArrayStack.Print()
	myArrayStack.Push(76)
	myArrayStack.Print()
	myArrayStack.Push(86)
	myArrayStack.Print()
	myArrayStack.Pop()
	myArrayStack.Print()
	myArrayStack.Pop()
	myArrayStack.Print()
	myArrayStack.Pop()
	myArrayStack.Print()
	myArrayStack.Pop()
	myArrayStack.Pop()
	myArrayStack.Pop()
	myArrayStack.Pop()
	myArrayStack.Print()
	myArrayStack.Push(55)
	myArrayStack.Push(66)
	myArrayStack.Print()
}

// Array Queue
func queueArray() {
	myArrayStack := Queue.ArrayQueue()
	myArrayStack.Enqueue(33)
	myArrayStack.Enqueue(55)
	myArrayStack.Enqueue(66)
	myArrayStack.Enqueue(77)
	myArrayStack.Dequeue()
	myArrayStack.Enqueue(33)
	myArrayStack.Print()
	myArrayStack.Enqueue(65)
	myArrayStack.Print()
	myArrayStack.Enqueue(76)
	myArrayStack.Print()
	myArrayStack.Enqueue(86)
	myArrayStack.Print()
	myArrayStack.Dequeue()
	myArrayStack.Print()
	myArrayStack.Dequeue()
	myArrayStack.Print()
	myArrayStack.Dequeue()
	myArrayStack.Print()
	myArrayStack.Enqueue(33)
	myArrayStack.Print()
	myArrayStack.Dequeue()
	myArrayStack.Print()
	myArrayStack.Dequeue()
	myArrayStack.Print()
}

// LinkedList Queue
func queueLinkedList() {
	myArrayStack := Queue.LinkedListQueue(22)
	myArrayStack.Enqueue(33)
	myArrayStack.Enqueue(55)
	myArrayStack.Enqueue(66)
	myArrayStack.Print()
	myArrayStack.Enqueue(65)
	myArrayStack.Print()
	myArrayStack.Enqueue(76)
	myArrayStack.Print()
	myArrayStack.Enqueue(86)
	myArrayStack.Print()
	myArrayStack.Dequeue()
	myArrayStack.Print()
	myArrayStack.Dequeue()
	myArrayStack.Print()
	myArrayStack.Dequeue()
	myArrayStack.Print()
	myArrayStack.Dequeue()
	myArrayStack.Dequeue()
	myArrayStack.Dequeue()
	myArrayStack.Dequeue()
	myArrayStack.Print()
	myArrayStack.Enqueue(55)
	myArrayStack.Enqueue(66)
	myArrayStack.Print()
}

// Binary Tree
func binaryTree() {
	myTree := Tree.BinaryTree(56)
	myTree.Insert(200)
	myTree.Insert(26)
	myTree.Insert(190)
	myTree.Insert(213)
	myTree.Insert(18)
	myTree.Insert(28)
	myTree.Insert(12)
	myTree.Insert(24)
	myTree.Insert(27)
	myTree.Print("NRL") // Infix: LNR-RNL, Prefix: NLR-NRL, Postfix: LRN, RLN
	myTree.Search(100)
	myTree.Search(24)
	fmt.Println(myTree.Exists(100))
	fmt.Println(myTree.Exists(24))
	fmt.Printf("Max value: %v\n", myTree.Max())
	fmt.Printf("Min value: %v\n", myTree.Min())
	myTree.Delete(56)
	myTree.Print("NRL")
}
