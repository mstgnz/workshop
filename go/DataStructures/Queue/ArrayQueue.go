package Queue

import "fmt"

type IArrayQueue interface{
	Enqueue(data int)
	Dequeue()
	ReSort()
	Print()
}

type arrayQueue struct {
	Arr []int
	ArrSize int
	FirstIndex int
	LastIndex int
}

func ArrayQueue() IArrayQueue{
	return &arrayQueue{[]int{0,0}, 2,0,0}
}

// Enqueue Add to data
func (arr *arrayQueue) Enqueue(data int) {
	// diziyi büyütmeden önce eğer diziden elemen çıkartılmışsa sadece sıra kaydır.
	// yani first index 0 dan farklı ise diziden elemen çıkartılmıştır o zaman diziyi büyütmek yerine diziyi tekrar sıralayacağız.
	// eğer first index 0 ise ve last index array size dan büyük ise dizi boyutunu arttıracağız
	if arr.LastIndex >= arr.ArrSize{
		if arr.FirstIndex == 0{
			newArr := make([]int, arr.ArrSize * 2)
			for i := 0; i < arr.ArrSize; i++ {
				newArr[i] = arr.Arr[i]
			}
			arr.Arr = newArr
			arr.ArrSize *= 2
		}else{
			arr.ReSort()
		}
	}
	arr.Arr[arr.LastIndex] = data
	arr.LastIndex++
}

// Dequeue Remove to data
func (arr *arrayQueue) Dequeue() {
	arr.Arr[arr.FirstIndex] = 0
	arr.FirstIndex++
	if arr.LastIndex - arr.FirstIndex <= arr.ArrSize / 4{
		newArr := make([]int, arr.ArrSize / 2)
		sort := 0
		for i := arr.FirstIndex; i < arr.LastIndex; i++ {
			newArr[sort] = arr.Arr[i]
			sort++
		}
		arr.Arr = newArr
		arr.ArrSize /= 2
		arr.LastIndex = arr.LastIndex - arr.FirstIndex
		arr.FirstIndex = 0
	}
}

// ReSort Diziyi yeniden sırala
func (arr *arrayQueue) ReSort() {
	newArr := make([]int, arr.ArrSize)
	sort := 0
	for i := arr.FirstIndex; i < arr.LastIndex; i++ {
		newArr[sort] = arr.Arr[i]
		sort++
	}
	arr.Arr = newArr
	arr.LastIndex = arr.LastIndex - arr.FirstIndex
	arr.FirstIndex = 0
}

// Print Yazdır
func (arr *arrayQueue) Print() {
	//fmt.Printf("len=%d cap=%d %v %v %v\n", len(arr.Arr), cap(arr.Arr), arr.Arr, arr.FirstIndex, arr.LastIndex)
	for i := arr.FirstIndex; i < arr.LastIndex; i++ {
		fmt.Printf("%v ", arr.Arr[i])
	}
	fmt.Println()
}