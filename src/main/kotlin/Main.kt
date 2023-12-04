import java.io.File

fun main(){
    println(decodeInput())
}

// advent of code 2023 day 2 part 2
// find which games would be possible and then add ids of all those game

fun decodeInput(): Int{
    var sumOfIDs = 0
    var powerSet: Int
    val redCubes = 12
    val greenCubes = 13
    val blueCubes = 14

    val filePath = "src/adventCode1.txt"
    val file = File(filePath)
    file.forEachLine {
        var redList = mutableListOf<Int>()
        var greenList = mutableListOf<Int>()
        var blueList = mutableListOf<Int>()

        val list = it.split(":")
        // get game id
        var id = list.first().filter {
            it.isDigit()
        }

        println(it)
        println("id is $id")

        // get games round in each game
        val gameRounds = list.last().split(";",",")
        // get game name and cubes in pair
        var gameNameCubesPairs: MutableList<Pair<Int, String>> = mutableListOf()
        for (j in 0..<gameRounds.size){
            gameNameCubesPairs.add(Pair(gameRounds[j].filter {
                it.isDigit()
            }.toInt()
                , gameRounds[j].filter {
                    it.isLetter()
                }))

        }
        gameNameCubesPairs.forEach {
            val cubes = it.first
            val game = it.second
            if (game.contains("red")){
                redList.add(cubes)

            }


            else if (game.contains("green")){
                greenList.add(cubes)
            }
            else {
                blueList.add(cubes)
            }
        }
        println("red cubes ${redList.max()} blue cubes ${blueList.max()} green cubes ${greenList.max()}")

        if (redList.max() <= redCubes && greenList.max() <= greenCubes && blueList.max() <= blueCubes){
            println("game is possible")
          //  sumOfIDs += id.toInt()
            println("sum of ids $sumOfIDs")
        }else
            println("game is not possible")

        powerSet = redList.max()*greenList.max()*blueList.max()
        sumOfIDs += powerSet
        println("power set ${powerSet}")



        println()

    }


    return sumOfIDs
}