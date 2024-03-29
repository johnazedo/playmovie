package com.example.home.data

import com.example.commons.network.*
import com.example.home.data.services.HomeService
import com.example.home.domain.entities.Trail
import com.example.home.domain.repositories.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class MovieRepositoryImpl(private val service: HomeService) : HomeRepository {
    override fun getTrails(): Flow<List<Trail>> = flow {
        service.getHomeService().result {
            onError { throw it }
            onSuccess {
                val result = Mapper.make(it)
                emit(result)
            }
        }
    }
}