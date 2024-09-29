package io.bikeway.ui.composable

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import io.bikeway.ui.Routes
import io.bikeway.ui.theme.ColorPalette
import io.bikeway.ui.theme.Spacing

@Composable
fun NavBar(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    ) {
    Surface(
        color = ColorPalette.background,
        modifier = modifier.fillMaxWidth(),
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Row {
                Spacer(Modifier.width(Spacing.medium))

                NavBarButton(
                    navController = navController,
                    navigateTo = Routes.HOME,
                    icon = Icons.Outlined.Home,
                )
            }

            NavBarButton(
                navController = navController,
                navigateTo = Routes.BOOKMARKS,
                icon = Icons.Outlined.FavoriteBorder,
            )

            Row {
                NavBarButton(
                    navController = navController,
                    navigateTo = Routes.NEW_TRIP,
                    icon = Icons.Outlined.AddCircle,
                )

                Spacer(Modifier.width(Spacing.medium))
            }
        }
    }
}

@Composable
private fun NavBarButton(
    navController: NavHostController,
    navigateTo: String,
    icon: ImageVector,
) {
    val iconColor = animateColorAsState(
        targetValue = when (navigateTo == navController.currentDestination?.route) {
            true -> ColorPalette.primary
            false -> ColorPalette.secondary },
        label = "iconColor",
        )

    IconButton(onClick = { navController.navigate(navigateTo) }) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = iconColor.value,
            modifier = Modifier.size(32.dp),
        )
    }
}