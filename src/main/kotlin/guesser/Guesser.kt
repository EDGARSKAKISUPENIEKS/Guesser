package guesser

fun main(args: Array<String>) {

    var deck: IntArray = IntArray(21)
    for (i in deck.indices) {
        deck[i] = i + 1
    }

    var setA: IntArray = IntArray(7)
    var setB: IntArray = IntArray(7)
    var setC: IntArray = IntArray(7)

    var setIndex: Int = 0
    var setCount: Int = 1
    var turnCount: Int = 0

    shuffleDeck(deck)

    splitDeck(deck, setCount, setA, setIndex, setB, setC)


    while (turnCount < 3) {
        izprinteSetus(setA, setB, setC)
        println()
        println("Memorize a number from three sets above and enter a, b or c in which set is your number.")
        println()
        var input: String = readLine()!!.toString().lowercase()

        when (input) {
            "a" -> {
                deck = setB + setA + setC
                turnCount++
            }
            "b" -> {
                deck = setA + setB + setC
                turnCount++
            }
            "c" -> {
                deck = setA + setC + setC
                turnCount++
            }
            else -> println("only use a,b or c")
        }
        splitDeck(deck, setCount, setA, setIndex, setB, setC)
    }

    println("Your number is ${deck[10]}")
}

private fun splitDeck(
    deck: IntArray,
    setCount: Int,
    setA: IntArray,
    setIndex: Int,
    setB: IntArray,
    setC: IntArray
) {
    var setCount1 = setCount
    var setIndex1 = setIndex
    for (number in deck) {
        when (setCount1) {
            1 -> {
                setA[setIndex1] = number
                setCount1++
            }
            2 -> {
                setB[setIndex1] = number
                setCount1++
            }
            3 -> {
                setC[setIndex1] = number
                setCount1 = 1
                setIndex1++
            }
        }
    }
}

private fun shuffleDeck(victim: IntArray) {
    for (i in victim.indices) {
        victim.shuffle()
    }
}

private fun izprinteSetus(setsA: IntArray, setsB: IntArray, setsC: IntArray) {
    println()
    print("a - ")
    printDeck(setsA)
    println()
    print("b - ")
    printDeck(setsB)
    println()
    print("c - ")

    printDeck(setsC)
}

private fun printDeck(deck: IntArray) {
    for (number in deck) {
        print(" $number ")
    }
}

private fun askSet() = readLine()!!.toString().lowercase()

