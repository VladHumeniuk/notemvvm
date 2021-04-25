package vhumeniuk.notesapp.mapper

abstract class BaseMapper<B, E> {

    abstract fun map(base: B): E

    abstract fun mapBack(entity: E): B
}