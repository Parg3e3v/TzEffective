package com.parg3v.tz_effective.view.catalog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.parg3v.tz_effective.R
import com.parg3v.tz_effective.components.ProductItem
import com.parg3v.tz_effective.components.ProductItemPlaceholder
import com.parg3v.tz_effective.components.Shimmer
import com.parg3v.tz_effective.model.ProductsListState

@Composable
fun CatalogScreen(viewModel: CatalogViewModel = hiltViewModel(), navController: NavController) {

    val itemsList by viewModel.productsState.collectAsStateWithLifecycle()
    val imageSlider = listOf(
        painterResource(id = R.drawable.img_54a876a5_2205_48ba_9498_cfecff4baa6e_1),
        painterResource(id = R.drawable.img_54a876a5_2205_48ba_9498_cfecff4baa6e_1),
        painterResource(id = R.drawable.img_54a876a5_2205_48ba_9498_cfecff4baa6e_1)
    )
    CatalogScreenUI(
        controller = navController, itemsListState = itemsList
    )
}

@Composable
fun CatalogScreenUI(controller: NavController, itemsListState: ProductsListState) {
    Box(modifier = Modifier.fillMaxSize()) {

        if (itemsListState.error.isEmpty())


            Shimmer(isLoading = itemsListState.isLoading, contentAfterLoading = {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(7.dp),
                    horizontalArrangement = Arrangement.spacedBy(7.dp)
                ) {
                    items(itemsListState.data) { product ->
                        ProductItem(
                            images = listOf(
                                painterResource(id = R.drawable.img_54a876a5_2205_48ba_9498_cfecff4baa6e_1),
                                painterResource(id = R.drawable.img_54a876a5_2205_48ba_9498_cfecff4baa6e_1),
                                painterResource(id = R.drawable.img_54a876a5_2205_48ba_9498_cfecff4baa6e_1),
                                painterResource(id = R.drawable.img_54a876a5_2205_48ba_9498_cfecff4baa6e_1)
                            ), product = product
                        )
                    }
                }
            }, loadingComposable = {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(7.dp),
                    horizontalArrangement = Arrangement.spacedBy(7.dp)
                ) {
                    items(8) {
                        ProductItemPlaceholder()
                    }
                }
            })
    }
}
