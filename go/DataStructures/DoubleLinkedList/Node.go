package DoubleLinkedList

import "fmt"

// İki yönlü link list, her node objesi bir sonraki ve bir önceki node objesinin referansını taşır.
// bu sayede next'in next'i ile tek yöne giderken aynı zamanda prev ile geri gidebileceğiz.

type Node struct {
	X    int
	Next *Node
	Prev *Node
}

// AddToStart Başına Ekle Methodu
func (node *Node) AddToStart(data int) {
	temp := *node
	node.X = data
	node.Next = &temp
	node.Next.Prev = node
	node.Next.Next.Prev = node.Next

}

// AddToSequentially Sıralı Ekle Methodu
func (node *Node) AddToSequentially(data int) {

	for node.Next != nil && node.Next.X < data {
		node = node.Next
	}

	node.Next = &Node{X: data, Next: node.Next, Prev: node}

	if node.Next.Next != nil {
		node.Next.Next.Prev = node.Next
	}

}

// AddToBetween Araya Ekle Methodu
func (node *Node) AddToBetween(data int, which int) {

	for node.Next != nil && node.X != which {
		node = node.Next
	}

	node.Next = &Node{X: data, Next: node.Next, Prev: node}

	if node.Next.Next != nil {
		node.Next.Next.Prev = node.Next
	}

}

// AddToEnd Sonuna Ekle Methodu
func (node *Node) AddToEnd(data int) {
	iter := node
	for iter.Next != nil {
		iter = iter.Next
	}
	iter.Next = &Node{X: data, Next: nil, Prev: iter}
}

// Delete Eleman Sil Methodu
func (node *Node) Delete(data int) {

	// silmek istenen değer arada veya sonda bir değer ise iter objemizi silinecek node objesinin bir öncekine kadar ilerletiyoruz
	for node.Next != nil && node.Next.X != data {
		node = node.Next
	}

	if node.Next == nil {
		fmt.Println("Silmek istediğiniz değer listede bulunamadı!")
	} else {
		node.Next = node.Next.Next
		node.Next.Prev = node
	}

}

// Print Yazdır
func (node *Node) Print(reverse bool) {
	iter := node
	if reverse { // sondan başa yazdır
		for iter.Next != nil {
			iter = iter.Next
		}
		for iter != nil {
			fmt.Println(iter.X)
			iter = iter.Prev
		}
	} else { // baştan sona yazdır
		for iter != nil {
			fmt.Println(iter.X)
			iter = iter.Next
		}
	}
}
