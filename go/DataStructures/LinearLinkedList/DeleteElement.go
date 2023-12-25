package LinearLinkedList

import "fmt"

// Linear Sequential
// Tek Yönlü Linklist

func DeleteElement() {

	// ilk node objemizi oluşturuyoruz ve bu root yani ilk objemizdir.
	root := Node{X: 2, Next: nil}

	// oluşturduğumuz node objesini gezebilmek (iterable) için root olan objemizin referansı ile iter oluşruyoruz.
	iter := &root

	// döngü kullanarak node ekleme, belirtilen node üzerinden başlayarak next'i null olan node öğesinden başlayarak yeni node objeleri oluşturuluyor.
	for i := 1; i < 5; i++ {
		if iter.Next == nil {
			iter.Next = &Node{X: i * 7, Next: nil}
			iter = iter.Next
		}
	}

	// node objemizin listesi 2, 7, 14, 21, 28
	NodePrint(&root)

	// Silinmek istenen node objesi root olabilir, arada bir node olabilir veya en son node olabilir.
	// tüm bu kriterlere uygun silme işlemini yazacağız.

	del := 14

	// ilk olarak root değer olan 2 yi silmek istersek eğer, root'un değeri aradığımız değer ise root'un yeni hali root'un next'i olarak atıyoruz.
	if root.X == del {
		root = *root.Next
	} else {
		iter = &root
		// silmek istenen değer arada veya sonda bir değer ise iter objemizi silinecek node objesinin bir öncekine kadar ilerletiyoruz
		for iter.Next != nil && iter.Next.X != del {
			iter = iter.Next
		}
		if iter.Next == nil {
			fmt.Println("Silmek istediğiniz değer listede bulunamadı!")
		} else {
			iter.Next = iter.Next.Next
		}
	}

	// node objemizin son hali
	NodePrint(&root)

}
