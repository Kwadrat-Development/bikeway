package io.bikeway.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import io.bikeway.ui.NavigatorMixin

class ProfilePreviewViewModel(
    override val navController: NavHostController,
) : ViewModel(), NavigatorMixin {

}