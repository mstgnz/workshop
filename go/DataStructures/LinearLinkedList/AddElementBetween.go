package LinearLinkedList

// Linear Sequential
// Tek Yönlü Linklist

func AddElementBetween() {

	// ilk node objemizi oluşturuyoruz ve bu root yani ilk objemizdir.
	root := Node{X: 2, Next: nil}

	// oluşturduğumuz node objesini gezebilmek (iterable) için root olan objemizin referansı ile iter oluşruyoruz.
	iter := &root

	// araya elemen ekleyebilmek için önce bir kaç node oluşturuyoruz.
	for i := 2; i < 6; i++ {
		if iter.Next == nil {
			iter.Next = &Node{X: i * i, Next: nil}
			iter = iter.Next
		}
	}

	// Araya eleman eklemeden önce node listemizi yazdır.
	NodePrint(&root)

	// Eklenecek elemanın hangi araya olduğunu seçelim örneğin - 9 ile 16 arasına 11 değeri taşına node ekleyelim.
	// 1 - Bunu ekleyebilmek için. öncelikle iter objemiz root objesinden başlayarak, next'in x değeri 9'a eşit olana kadar ilerleyecek.
	// 2 - 9'ncu değere ait node objesini tutan iter'in next'ini bir değişkene atıyoruz ki kaybolmasın.
	// 3 - sonra iter'in next'i için değeri 11 olan yeni bir node oluşturuyoruz, artık 9'ncu değere sahip node 11'nci değere sahip nodu göstermiş olacak.
	// 4 - Son olarakta 16'ncı değere sahip node objesini tutan değişkeni, 11'nci nodu tutan objenin next'ine atıyoruz.
	// böylelikle araya elemen ekleme işlemi sağlanmış olacaktır.

	iter = &root

	// 1. step
	for iter.X != 9 {
		iter = iter.Next
	}

	// 2.step
	temp := *iter

	// 3.step
	iter.Next = &Node{X: 11, Next: nil}

	// 4.step
	iter.Next.Next = temp.Next

	// Araya eleman eklendikten sonra node listemizi yazdır.
	NodePrint(&root)

}
