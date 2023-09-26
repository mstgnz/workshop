package main

import (
	"fmt"
)

func main() {

	nums := []int{4, 6, 7, 7}

	left := 0
	right := 1
	ln := len(nums) - 1
	var slc []int
	var result [][]int
	slc = append(slc, nums[left])
	for left < ln {
		if nums[left] > nums[right] {
			break
		}
		slc = append(slc, nums[right])
		result = append(result, slc)
		if right == ln {
			slc = []int{}
			left += 1
			right = left + 1
			continue
		}
		right += 1
	}
	fmt.Println(result)

}
