package com.example.home.presentation

import com.example.commons.viewmodel.State
import com.example.commons.viewmodel.Tag
import com.example.home.domain.entities.Trail


data class HomeState(
    var trails: List<Trail>,
    override val tag: Tag = Tag.LOADING
): State {

    companion object {
        val EMPTY_VALUE = HomeState(listOf())
    }
}
