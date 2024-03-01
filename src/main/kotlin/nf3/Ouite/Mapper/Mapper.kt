package nf3.Ouite.Mapper

interface Mapper <T, U> {
    fun map(t: T): U
}