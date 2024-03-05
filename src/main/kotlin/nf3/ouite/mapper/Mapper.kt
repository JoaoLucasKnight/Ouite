package nf3.ouite.mapper

interface Mapper <T, U> {
    fun map(t: T): U
}