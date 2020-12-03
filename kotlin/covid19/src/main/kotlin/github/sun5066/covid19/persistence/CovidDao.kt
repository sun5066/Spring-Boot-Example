package github.sun5066.covid19.persistence

import github.sun5066.covid19.domain.CovidVO

interface CovidDao {
    fun selectAll()

    fun findById(id: Long)

    fun insert(covidVO: CovidVO)

    fun update(covidVO: CovidVO)

    fun delete(id: Long)
}