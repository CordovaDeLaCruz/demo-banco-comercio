package com.banco.demo.commons.libs.networking.mapper


abstract class Mapper<E, D> {
    abstract fun mapFromModel(type: E?): D?
    abstract fun mapToModel(type: D?): E?

    fun mapFromModel(type: List<E>?): List<D> {
        val list: MutableList<D> = ArrayList()
        if (type != null) {
            for (i in type.indices) {
                list.add(mapFromModel(type[i])!!)
            }
        }
        return list
    }

    fun mapToModel(type: List<D>?): List<E> {
        val list: MutableList<E> = ArrayList()
        if (type != null) {
            for (i in type.indices) {
                list.add(mapToModel(type[i])!!)
            }
        }
        return list
    }
}
