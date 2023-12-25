package main

import (
	"fmt"
	"math/rand"
	"os"
	"strconv"
)

var (
	mineBool  [][]int
	mineBoard [][]string
	mineCount int
	mineOpen  int
)

type Mine struct {
	RowCount    int
	ColumnCount int
	Level       int
}

func (m *Mine) Create() {
	// Set Board
	mineBoard = make([][]string, m.RowCount)
	mineBool = make([][]int, m.RowCount)
	for i := 0; i < m.RowCount; i++ {
		mineBoard[i] = make([]string, m.ColumnCount)
		mineBool[i] = make([]int, m.ColumnCount)
	}
	for i := 0; i < m.RowCount; i++ {
		for j := 0; j < m.ColumnCount; j++ {
			mineBoard[i][j] = "__"
			mineBool[i][j] = 0
		}
	}
	// Set mine
	mineCount = m.RowCount * m.ColumnCount / m.Level
	mineOpen = mineCount
	row, column, mine := 0, 0, 0
	for i := 0; i < mineCount; i++ {
		row = rand.Intn(m.RowCount)
		column = rand.Intn(m.ColumnCount)
		if mineBool[row][column] == 0 {
			mineBool[row][column] = 1
			mine++
		} else {
			if mine != mineCount {
				i--
			}
		}
	}
}

func (m *Mine) Choose(row, column int) {
	// start index 1 for user
	row--
	column--
	// selected index is available and check bomb index
	if m.isIndexAvailable(row, column) {
		m.isBomb(row, column)
		m.setBoard(row, column)
	}
}

func (m *Mine) isIndexAvailable(row, column int) bool {
	if m.RowCount > row && m.ColumnCount > column {
		if mineBoard[row][column] == "__" {
			return true
		} else {
			fmt.Println("Already choose this index!")
		}
	}
	return false
}

func (m *Mine) isBomb(row, column int) {
	if mineBool[row][column] == 1 {
		fmt.Println("BOOOMMBBBBBB")
		fmt.Println("GAME OVER!")
		os.Exit(0)
	}
}

func (m *Mine) setBoard(row, column int) {
	count, row1, row2, column1, column2 := 0, row, row, column, column
	if row > 0 {
		row1 = row - 1
	}
	if column > 0 {
		column1 = column - 1
	}
	if len(mineBool) > row {
		row2 = row + 1
	}
	if len(mineBool[0]) > column+1 {
		column2 = column + 1
	}
	for i := row1; i <= row2; i++ {
		for j := column1; j <= column2; j++ {
			if mineBool[i][j] == 1 {
				count++
			}
		}
	}
	mineOpen += 1
	mineBoard[row][column] = strconv.Itoa(count)
}

func (m *Mine) isWin() bool {
	return mineOpen == m.RowCount*m.ColumnCount
}

func (m *Mine) Print() {
	for i := 0; i < m.RowCount; i++ {
		for j := 0; j < m.ColumnCount; j++ {
			fmt.Print(mineBoard[i][j])
		}
		fmt.Println()
	}
}
