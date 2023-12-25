package LinearLinkedList

// Linear Sequential
// Tek Yönlü Linklist

func AddSequentially() {

	// ilk node objemizi oluşturuyoruz ve bu root yani ilk objemizdir.
	root := Node{X: 2, Next: nil}

	// Sıralı eleman ekleme işleminde eklenen node objesinin değeri root objesinin değerinden büyükse sonuna, değilse başına eklenecektir.

	// Araya eleman eklenmeden önce node listemizi yazdır.
	NodePrint(&root)

	// Sıralı ekle fonksiyonuna karışık olarak değerler verdik. addToSequentially fonksiyonu karışık verilen bu değerleri sıralı olarak eklemelidir.

	addToSequentially(&root, 34)
	addToSequentially(&root, 5)
	addToSequentially(&root, 15)
	addToSequentially(&root, 66)
	addToSequentially(&root, 1)

	// Araya eleman eklendikten sonra node listemizi yazdır.
	NodePrint(&root)

}

// fonksiyon her çağrıldığında verilen data değerini node objesi içersinde dolaşarak ilgili x değerinden büyük ise sağına, küçük ise soluna ekleyecektir.
// sıralı ekleme işleminde, verinin büyüklük küçüklük durumuna göre ekleme yerleri değişecektir.
// bu durumda node objesinin en başıa, ortasına veya en sonuna ekleme işlemi gerçekleimiş olacaktır
func addToSequentially(root *Node, data int) {
	// eklenenecek olan yeni değer mevcut root node objesi değerinden küçük ise başa eklenmeli
	// bunun için de root objesini geçici olarak tutacak bir temp olması gerekiyor.
	if root.X > data {
		temp := *root
		root.X = data
		root.Next = &temp
	} else {
		// diğer durumlarda node objesinde next null olana kadar veya gelen değer mevcuttan küçük olana kadar ilerle
		iter := root

		for iter.Next != nil && iter.Next.X < data {
			iter = iter.Next
		}

		temp := *iter

		iter.Next = &Node{X: data, Next: nil}

		iter.Next.Next = temp.Next
	}

}
