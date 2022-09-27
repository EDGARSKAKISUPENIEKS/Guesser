package guesser

import java.util.*
import kotlin.random.Random

fun main(args: Array<String>) {

    var komplekts: Array<Int> = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21)

    var setsA: IntArray = IntArray(7)
    var setsB: IntArray = IntArray(7)
    var setsC: IntArray = IntArray(7)


    for (i in komplekts.indices) {
        komplekts.shuffle()
    }

    for (skaitlis in komplekts) {
        print(" $skaitlis ")
    }


    var indeks: Int = 0
    var setCount: Int = 1

    for (skaitlis in komplekts) {


        when (setCount) {
            1 -> {
                setsA[indeks] = skaitlis
                setCount++
            }
            2 -> {
                setsB[indeks] = skaitlis
                setCount++
            }
            3 -> {
                setsC[indeks] = skaitlis
                setCount = 1
                indeks++
            }
        }
    }

    izprinteSetus(setsA, setsB, setsC)
    saliekKomplektu(pajautaSetu(), komplekts, setsB, setsA, setsC)
    izprinteSetus(setsA, setsB, setsC)
    saliekKomplektu(pajautaSetu(), komplekts, setsB, setsA, setsC)
    izprinteSetus(setsA, setsB, setsC)
    saliekKomplektu(pajautaSetu(), komplekts, setsB, setsA, setsC)
    println(komplekts[10])
}

private fun izprinteSetus(setsA: IntArray, setsB: IntArray, setsC: IntArray) {
    println()
    print("a - ")
    for (skaitlis in setsA) {
        print(" $skaitlis ")
    }
    println()
    print("b - ")
    for (skaitlis in setsB) {
        print(" $skaitlis ")
    }
    println()
    print("c - ")
    for (skaitlis in setsC) {
        print(" $skaitlis ")
    }
}

private fun pajautaSetu() = readLine()!!.toString().lowercase()

private fun saliekKomplektu(
    izvele: String,
    komplekts: Array<Int>,
    setsB: IntArray,
    setsA: IntArray,
    setsC: IntArray
) {
    when (izvele) {
        "a" -> {
            var y: Int = 0
            for (i in komplekts.indices) {
                when (i) {
                    in 0..6 -> {
                        komplekts[i] = setsB[y]
                        y++
                    }
                    in 7..13 -> {
                        if (y >= 6) {
                            y = 0
                        }
                        komplekts[i] = setsA[y]
                        y++
                    }
                    in 13..20 -> {
                        if (y >= 6) {
                            y = 0
                        }
                        komplekts[i] = setsC[y]
                        y++
                    }
                }
            }
        }
        "b" -> {
            var y: Int = 0
            for (i in komplekts.indices) {
                when (i) {
                    in 0..6 -> {
                        komplekts[i] = setsA[y]
                        y++
                    }
                    in 7..13 -> {
                        if (y >= 6) {
                            y = 0
                        }
                        komplekts[i] = setsB[y]
                        y++
                    }
                    in 13..20 -> {
                        if (y >= 6) {
                            y = 0
                        }
                        komplekts[i] = setsC[y]
                    }
                }
            }
        }

        "c" -> {
            var y: Int = 0
            for (i in komplekts.indices) {
                when (i) {
                    in 0..6 -> {
                        komplekts[i] = setsA[y]
                        y++
                    }
                    in 7..13 -> {
                        if (y >= 6) {
                            y = 0
                        }
                        komplekts[i] = setsC[y]
                        y++
                    }
                    in 13..20 -> {
                        if (y >= 6) {
                            y = 0
                        }
                        komplekts[i] = setsB[y]
                    }
                }
            }
        }

        else -> println("nederīga izvēle!")
    }
}