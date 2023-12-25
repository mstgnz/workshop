package LinearLinkedList

import "fmt"

// Linear Sequential
// Tek Yönlü Linklist

func GenerateElement() {

	// ilk node objemizi oluşturuyoruz ve bu root yani ilk objemizdir.
	root := Node{X: 1, Next: nil}

	// oluşturduğumuz node objesini gezebilmek (iterable) için root olan objemizin referansı ile iter oluşruyoruz.
	iter := &root

	// döngü kullanarak node ekleme, belirtilen node üzerinden başlayarak next'i null olan node öğesinden başlayarak yeni node objeleri oluşturuluyor.
	for i := 1; i < 5; i++ {
		if iter.Next == nil {
			iter.Next = &Node{X: i * 7, Next: nil}
			iter = iter.Next
		}
	}

	nodePrint(&root)

}

func nodePrint(node *Node) {

	// iter objesi üzerinden tüm node objelerinin next değeri nil olana kadar döngü ile yazdırabiliriz.
	fmt.Println("root objesini fonksiyon üzerinden döngü ile iterable")
	iter := node
	for iter != nil {
		fmt.Println(iter.X)
		iter = iter.Next
	}
}
