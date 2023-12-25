package LinearLinkedList

import "fmt"

// Node struct tipinde bir node oluşturduk ve node objesi iki tane değer alacak;
// bir sonraki node objesini tutacak olan Next niteliği ile taşınacak objenin karşılığı X
// bu int türünde x yerine herhangi bir türde bir obje konulabilir.
// generic tanımlama go 1.18 çıkması beklenmektedir. 2022 başlarında çıkacağı söyleniyor.
type Node struct {
	X    int
	Next *Node
}

// AddToStart Başına Ekle Methodu
func (node *Node) AddToStart(data int) {
	temp := *node
	node.X = data
	node.Next = &temp
}

// AddToSequentially Sıralı Ekle Methodu
func (node *Node) AddToSequentially(data int) {

	for node.Next != nil && node.Next.X < data {
		node = node.Next
	}

	temp := *node

	node.Next = &Node{X: data, Next: nil}

	node.Next.Next = temp.Next
}

// AddToBetween Araya Ekle Methodu
func (node *Node) AddToBetween(data int, which int) {

	for node.X != which {
		node = node.Next
	}

	temp := *node

	node.Next = &Node{X: data, Next: nil}

	node.Next.Next = temp.Next
}

// AddToEnd Sonuna Ekle Methodu
func (node *Node) AddToEnd(data int) {
	iter := node
	for iter.Next != nil {
		iter = iter.Next
	}
	iter.Next = &Node{X: data, Next: nil}
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
	}
}

// Print Yazdır
func (node *Node) Print() {
	iter := node
	for iter != nil {
		fmt.Println(iter.X)
		iter = iter.Next
	}
}
