import java.util.Scanner

const val THREE = 3

fun main() {
    val input = Scanner(System.`in`)
    val grid = MutableList(THREE) { MutableList(THREE) { " " } }

    var x = 0
    var o = 0
    var check = 0

    var isX = true
    var isO = false
    var out = ""

    var gameMode = true

    table(grid)
    while (gameMode) {
        var showTable = false
        try {
            print("> ")
            val x1 = input.next()
            val x2 = input.next()

            if (grid[x1.toInt() - 1][x2.toInt() - 1] == " " && isX) {
                grid[x1.toInt() - 1][x2.toInt() - 1] = "X"
                x++
                isO = true
                isX = false
                showTable = true
            } else if (grid[x1.toInt() - 1][x2.toInt() - 1] == " " && isO) {
                grid[x1.toInt() - 1][x2.toInt() - 1] = "O"
                o++
                isX = true
                isO = false
                showTable = true
            } else if (grid[x1.toInt() - 1][x2.toInt() - 1] != " ") {
                println("This cell is occupied! Choose another one!")
            }
        } catch (e: NumberFormatException) {
            println("You should enter numbers!")
        } catch (e: IndexOutOfBoundsException) {
            println("Coordinates should be from 1 to 3!")
        }
        if (showTable) {
            table(grid)
        }

        if ((grid[0][0] == "X" || grid[0][0] == "O") && grid[0][0] == grid[0][1] && grid[0][1] == grid[0][2]) check++
        if ((grid[1][0] == "X" || grid[1][0] == "O") && grid[1][0] == grid[1][1] && grid[1][1] == grid[1][2]) check++
        if ((grid[2][0] == "X" || grid[2][0] == "O") && grid[2][0] == grid[2][1] && grid[2][1] == grid[2][2]) check++
        if ((grid[0][0] == "X" || grid[0][0] == "O") && grid[0][0] == grid[1][0] && grid[1][0] == grid[2][0]) check++
        if ((grid[0][1] == "X" || grid[0][1] == "O") && grid[0][1] == grid[1][1] && grid[1][1] == grid[2][1]) check++
        if ((grid[0][2] == "X" || grid[0][2] == "O") && grid[0][2] == grid[1][2] && grid[1][2] == grid[2][2]) check++
        if ((grid[0][0] == "X" || grid[0][0] == "O") && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) check++
        if ((grid[0][2] == "X" || grid[0][2] == "O") && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) check++
        // if ((grid[0][0] == "X" && grid[0][0] == grid[1][0] && grid[1][0] == grid[2][0] && grid[2][0] == grid[2][1]
        //             && grid[2][1] == grid[2][2])) check = 1
        // if ((grid[0][2] == "X" && grid[0][2] == grid[1][2] && grid[1][2] == grid[2][2] && grid[2][2] == grid[2][1]
        //             && grid[2][1] == grid[2][0])) check = 1

        if ((x - o == 1 || x - o == 0) && check == 1) {
            out = ("X wins")
            gameMode = false
        }
        if ((o - x == 1 || o - x == 0) && check == 1) {
            out = "O wins"
            gameMode = false
        }
        if (check == 0 && (x == 5 || o == 5)) {
            out = ("Draw")
            gameMode = false
        }
        //println(check)
    }
    println(out)
}

fun table(table: MutableList<MutableList<String>>) {
    println("---------")
    println("| ${table[0][0]} ${table[0][1]} ${table[0][2]} |")
    println("| ${table[1][0]} ${table[1][1]} ${table[1][2]} |")
    println("| ${table[2][0]} ${table[2][1]} ${table[2][2]} |")
    println("---------")
}
