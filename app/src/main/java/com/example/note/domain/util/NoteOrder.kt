package com.example.note.domain.util

sealed class NoteOrder(val orderType: OrderType) {
    class Title(orderingType: OrderType) : NoteOrder(orderingType)
    class Date(orderingType: OrderType) : NoteOrder(orderingType)
    class Color(orderingType: OrderType) : NoteOrder(orderingType)

    fun copy(orderType: OrderType): NoteOrder {
        return when (this) {
            is Title -> Title(orderType)
            is Date -> Date(orderType)
            is Color -> Color(orderType)
        }
    }
}