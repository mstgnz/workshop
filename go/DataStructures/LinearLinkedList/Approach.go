package LinearLinkedList

import "fmt"

// Linear Sequential
// Tek Yönlü Linklist

func Approach() {
	// ilk node objemizi oluşturuyoruz ve bu root yani ilk objemizdir.
	root := Node{X: 12, Next: nil}

	// ilk oluşturulan node objemizin içersinde yer alan next isimli pointer için yeni bir node objesi oluşturuyoruz.
	// burda dikkate ederseniz yeni node objesini oluştururken aynı zamanda root'un next'ine referansını (&) veriyoruz.
	root.Next = &Node{X: 5, Next: nil}

	// ikinci oluşturulan node objemizin içersinde yer alan next isimli pointer için yeni bir node objesi daha oluşturuyoruz.
	root.Next.Next = &Node{X: 6, Next: nil}

	// böylece 3 adet node objesini birbiri ardına eklemiş olduk.

	// oluşturduğumuz node objesini gezebilmek (iterable) için root olan objemizin referansı ile iter oluşruyoruz.
	iter := &root

	// iter objesinin refransını değiştirmeden yazdırmak istersek eğer
	fmt.Println("root objesi üzerinden iterable")
	fmt.Printf("root node x : %v\nsecond node x : %v\nthirty node x : %v\n\n", iter.X, iter.Next.X, iter.Next.Next.X)

	// ilk önce manuel olarak root objesinden başlayarak her bir node objesinin next'ine gidiyoruz.
	// root objesinin x değerini yaz
	fmt.Println("iter referansını manuel değiştirerek iterable")
	fmt.Printf("root node x : %v\n", iter.X)
	// iter'in sahip olduğu referansı root'un next'i olarak değiştir.
	iter = iter.Next
	// iter artık root'un next'ini gösterdiği için bir sonraki node objesinin x değerini yazdır.
	fmt.Printf("second node x : %v\n", iter.X)
	// aynı işlem tekrar
	iter = iter.Next
	fmt.Printf("thirty node x : %v\n", iter.X)
	fmt.Println()

	// iter objesi üzerinden tüm node objelerinin next değeri nil olana kadar döngü ile yazdırabiliriz.
	fmt.Println("root objesi üzerinden döngü ile iterable")
	iter = &root
	for iter != nil {
		fmt.Println(iter.X)
		iter = iter.Next
	}

}
