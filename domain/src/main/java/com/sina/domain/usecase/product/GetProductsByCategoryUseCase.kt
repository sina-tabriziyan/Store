package com.sina.domain.usecase.product

import com.sina.core.common.interactor.UseCaseFlow
import com.sina.core.common.responsestate.safeOpen
import com.sina.core.model.productlist.Products
import com.sina.domain.repositroy.ProductsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProductsByCategoryUseCase@Inject constructor(private val productsRepository: ProductsRepository) :
    UseCaseFlow<GetProductsByCategoryUseCase.Params, List<Products>>() {
    data class Params(val page: Int, val filters: Map<String, String>)

    override fun execute(params: Params): Flow<List<Products>> =
        with(params) { productsRepository.getProducts(page, filters) }.safeOpen()
}