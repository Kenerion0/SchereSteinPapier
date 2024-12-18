import kotlin.system.exitProcess

var name = System.getProperty("user.home").substringAfterLast("\\")
var selection = "Unbekannt"
var selectionENEMY = ""
val resultList = mutableListOf<String>()
var Points = 0
var isGerman = true

fun main() {
    language()
    newGame()
    readUserInput()
}
fun language() {
    println("====== Language ======")
    println("1. English")
    println("2. German")
    println("==========================")
    val input = readln()
    isGerman = when(input) {
        "1" -> false
        "2" -> true
        else -> {
            println("Wrong input! \n")
            language()
            return
        }
    }
}
fun newround(){
    cpuInput()
    readUserInput()
    if (selection == "exit") {
        if (isGerman) {
            println("Spiel wird beendet! \n")
        }
        else {
            println("Game is closing! \n")
        }
        printResults()
    } else {
        evaluateGame()
    }
}
fun printResults() {
    if (isGerman) {
    println("==== Ergebnisse ====")
    resultList.forEachIndexed { index, value ->
        println("($index) $value") }
    println("Gesamt: $Points Punkte")}
    else {
        println("==== Results ====")
        resultList.forEachIndexed { index, value ->
            println("($index) $value") }
        println("Total: $Points points")
    }
}
fun cpuInput() {
    val random = (1..3).random()
    selectionENEMY = when(random) {
        1 -> "Schere"
        2 -> "Stein"
        3 -> "Papier"
        else -> "Unbekannt" }
    }
fun newGame() {
    if (isGerman) {
        println("Herzlich Willkommen zu diesem Spiel.")
        println("Heutiger Spieler: $name \n")
    }
    else {
        println("Welcome to this game.")
        println("Current player: $name \n")
    }
}
fun readUserInput() {
    if (isGerman) {
        println("====== Deine Auswahl ======")
        println("1. Schere")
        println("2. Stein")
        println("3. Papier")
        println("exit. Beenden")
        println("==========================")
    } else {
        println("====== Your choice ======")
        println("1. Scissors")
        println("2. Stone")
        println("3. Paper")
        println("exit. Closing")
        println("==========================")
    }

    val input = readln()
    selection = when (input) {
        "1" -> "Schere"
        "2" -> "Stein"
        "3" -> "Papier"
        "exit" -> "exit"
        else -> "Unbekannt"
    }
        if (selection == "Unbekannt") {
            if (isGerman) {
            println("Falsche Eingabe! \n")}
            else {
                println("Wrong input! \n")
            }
            readUserInput() }
    if (selection == "exit") {
        printResults()
        exitProcess(0)
    }
evaluateGame()
}
fun evaluateGame() {
    if (isGerman){
    println("Deine Auswahl: $selection")
    println("Dein Gegner: $selectionENEMY")}
    else {
        println("Your choice: $selection")
        println("Your enemy: $selectionENEMY")}
    if (selection == selectionENEMY) {
        if (isGerman){
        println("Unentschieden")}
        else {
            println("Undecided")
        }
        resultList.add("[DU] $selection [Gegner] $selectionENEMY -> Unentschieden")
    } else {
        if (selection == "Schere") {
            if (selectionENEMY == "Papier") {
                if (isGerman){
                println("Du hast Gewonnen!")}
                else{
                    println("You won!")
                }
                resultList.add("[DU] $selection [Gegner] $selectionENEMY -> Gewonnen")
                Points++
            } else {
                if (isGerman){
                println("Du hast Verloren!")
                }
                else {
                    println("You lost!")
                }
                resultList.add("[DU] $selection [Gegner] $selectionENEMY -> Verloren")
            }
        }
        if (selection == "Papier") {
            if (selectionENEMY == "Schere") {
                if (isGerman){
                println("Du hast Verloren!")}
                else {
                    println("You lost!")
                }
                resultList.add("[DU] $selection [Gegner] $selectionENEMY -> Verloren")
            } else {
                if (isGerman){
                println("Du hast Gewonnen!") }
                else {
                    println("You won!")
                }
                resultList.add("[DU] $selection [Gegner] $selectionENEMY -> Gewonnen")
                Points++
            }
        }
        if (selection == "Stein") {
            if (selectionENEMY == "Papier") {
                if (isGerman){
                println("Du hast Verloren!") }
                else {
                    println("You lost!")
                }
                resultList.add("[DU] $selection [Gegner] $selectionENEMY -> Verloren")
            } else {
                if (isGerman){
                println("Du hast Gewonnen!") }
                else {
                    println("You won!")
                }
                resultList.add("[DU] $selection [Gegner] $selectionENEMY -> Gewonnen")
                Points++
            }
        }
    }
    newround()
}
