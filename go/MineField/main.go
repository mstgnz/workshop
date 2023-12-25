package main

import (
	"fmt"
	"os"
)

var (
	rowCount    int
	columnCount int
	level       int
	row         int
	column      int
	err         error
)

func main() {

	fmt.Println(`WELCOME TO MINEFIELD GAME
- Set game board boundaries.
- Give a value for the degree of difficulty.
- The hardest value is 2.
- Start the game by selecting the row and column value.
-----------------------------------------------------`)

	fmt.Print("Row Count : ")
	_, err = fmt.Scanf("%d", &rowCount)
	fmt.Print("Column Count :")
	_, err = fmt.Scanf("%d", &columnCount)
	fmt.Print("Level : ")
	_, err = fmt.Scanf("%d", &level)

	if err != nil || rowCount <= 0 || columnCount <= 0 || level <= 0 {
		fmt.Println("Please just positive number")
		os.Exit(0)
	}

	// max 20x20
	if rowCount > 20 || columnCount > 20 {
		rowCount = 20
		columnCount = 20
	}

	// min 3x3
	if rowCount < 3 || columnCount < 3 {
		rowCount = 3
		columnCount = 3
	}

	// init minefield
	mine := Mine{
		rowCount,
		columnCount,
		level,
	}

	mine.Create()

	// start
	for {
		if mine.isWin() {
			fmt.Println("Congratulations you are win")
			os.Exit(0)
		}
		mine.Print()
		fmt.Print("Row : ")
		_, err = fmt.Scanf("%d", &row)
		fmt.Print("Column :")
		_, err = fmt.Scanf("%d", &column)

		if err != nil || row <= 0 || column <= 0 {
			fmt.Println("Please just positive number")
			os.Exit(0)
		}

		mine.Choose(row, column)
	}

}
