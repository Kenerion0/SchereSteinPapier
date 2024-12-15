var name = System.getProperty("user.home")
var selection = "Unbekannt"
var selectionENEMY = ""
var resultList = mutableListOf<String>()
var Points = 0

fun main() {
    newGame()
    readUserInput()
    evaluateGame()
}
fun newround(){
    cpuInput()
    readUserInput()
    if (selection == "exit") {
        println("Spiel wird beendet! \n")
        printResults()
    } else {
        evaluateGame()
    }
}
fun printResults() {
    println("==== Ergebnisse ====")
    resultList.forEachIndexed { index, value ->
        println("($index) $value") }
    println("Gesamt: $Points Punkte")
}
fun cpuInput() {
    val random = (1..3).random()

    selectionENEMY = when(random) {
        1 -> "Schere"
        2 -> "Stein"
        3 -> "Papier"
        else -> "Unbekannt"
    }
}
fun newGame() {

    println("Herzlich Willkommen zu diesem Spiel.")
    println("Heutiger Spieler: $name \n")
}
fun readUserInput() {
    println("====== Deine Auswahl ======")
    println("1. Schere")
    println("2. Stein")
    println("3. Papier")
    println("exit. Beenden")
    println("==========================")
    val input = readln()
    selection = when(input) {
        "1" -> "Schere"
        "2" -> "Stein"
        "3" -> "Papier"
        "exit" -> "exit"
        else -> "Unbekannt"
    }
    if (selection == "Unbekannt") {
        println("Falsche Eingabe! \n")
    readUserInput()}
}
fun evaluateGame() {
    println("Deine Auswahl: $selection")
    println("Dein Gegner: $selectionENEMY")
    if (selection == selectionENEMY) {
        println("Unentschieden")
        resultList.add("[DU] $selection [Gegner] $selectionENEMY -> Unentschieden")
    } else {
        if (selection == "Schere") {
            if (selectionENEMY == "Papier") {
                println("Du hast Gewonnen!")
                resultList.add("[DU] $selection [Gegner] $selectionENEMY -> Gewonnen")
                Points++
            } else {
                println("Du hast Verloren!")
                resultList.add("[DU] $selection [Gegner] $selectionENEMY -> Verloren")
            }
        }
        if (selection == "Papier") {
            if (selectionENEMY == "Schere") {
                println("Du hast Verloren!")
                resultList.add("[DU] $selection [Gegner] $selectionENEMY -> Verloren")
            } else {
                println("Du hast Gewonnen!")
                resultList.add("[DU] $selection [Gegner] $selectionENEMY -> Gewonnen")
                Points++
            }
        }
        if (selection == "Stein") {
            if (selectionENEMY == "Papier") {
                println("Du hast Verloren!")
                resultList.add("[DU] $selection [Gegner] $selectionENEMY -> Verloren")
            } else {
                println("Du hast Gewonnen!")
                resultList.add("[DU] $selection [Gegner] $selectionENEMY -> Gewonnen")
                Points++
            }
        }
    }
    newround()
}