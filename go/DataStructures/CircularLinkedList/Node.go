package CircularLinkedList

import "fmt"

// Dairesel Link List, en son node objesinin next'i root objesini göstermektedir.
// Bu sayede next'in nexti ile gezindiğimizde sonsuz döngüye gireceğiz.
// Sonsuz döngüde kalmamk için. root objemizin kontrolü ile gezinme işlemini yaparak, ekleme, silme işlemlerini yapacağız.

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

	iter := node

	// eklenmek istenen değer root objesinin değerinden küçük ise
	if node.X > data {
		node.AddToStart(data)
		for iter.Next != node {

			iter = iter.Next
		}
		iter.Next = node

		// eklenmke istenen değer root objesinin değerinden büyük ise
	} else {

		// eklenmek istenen değerden küçük olan değere kadar ilerle
		for iter.Next != node && iter.Next.X < data {

			iter = iter.Next
		}

		// eklenmek istenen değerden küçük olan objenin nextine, eklenmek istenen değeri yeni obje oluşturarak ekle
		// yeni eklenen objenin next'ine ise mevcut next'i ekle
		iter.Next = &Node{X: data, Next: iter.Next}

	}

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
	for iter.Next != node {
		iter = iter.Next
	}
	iter.Next = &Node{X: data, Next: node}
}

// Delete Eleman Sil Methodu
func (node *Node) Delete(data int) {

	// silmek istenen değer arada veya sonda bir değer ise iter objemizi silinecek node objesinin bir öncekine kadar ilerletiyoruz

	iter := node

	// root objesi silinmek istenirse
	if iter.X == data {
		for iter.Next != node {
			iter = iter.Next
		}
		node.X = node.Next.X
		node.Next = node.Next.Next
		iter.Next = node

		// diğer elemenlardan biri silinmek istenirse
	} else {
		for iter.Next != node && iter.Next.X != data {
			iter = iter.Next
		}

		if iter.Next == node {
			fmt.Println("Silmek istediğiniz değer listede bulunamadı!")
		} else {
			iter.Next = iter.Next.Next
		}
	}

}

// Print Yazdır
func (node *Node) Print() {
	// dairesel link list olduğu için ilk başta iter objesi tanımlıyoruz ve döngüden önce iterin ilk objesini yazdırarak bir sonraki node objesine geçiyoruz.
	iter := node
	fmt.Println(iter.X)
	iter = iter.Next
	for iter != node {
		fmt.Println(iter.X)
		iter = iter.Next
	}
}
