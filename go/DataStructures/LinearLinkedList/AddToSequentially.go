package LinearLinkedList

// AddToSequentially fonksiyon her çağrıldığında verilen data değerini node objesi içersinde dolaşarak ilgili x değerinden büyük ise sağına, küçük ise soluna ekleyecektir.
// sıralı ekleme işleminde, verinin büyüklük küçüklük durumuna göre ekleme yerleri değişecektir.
// bu durumda node objesinin en başıa, ortasına veya en sonuna ekleme işlemi gerçekleimiş olacaktır
func AddToSequentially(root *Node, data int) {
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
