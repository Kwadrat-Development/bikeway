package io.bikeway.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import io.bikeway.ui.NavigatorMixin

class HomeViewModel(
    override val navController: NavHostController,
) : ViewModel(), NavigatorMixin {

}