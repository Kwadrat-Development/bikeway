package io.bikeway.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.bikeway.R
import io.bikeway.ui.Routes
import io.bikeway.ui.theme.ColorPalette
import io.bikeway.ui.theme.Roundness
import io.bikeway.ui.theme.Spacing
import io.bikeway.ui.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(ColorPalette.background)
            .padding(Spacing.medium),
    ) {
        TopBar(
            onClickProfilePicture = { viewModel.navigateTo(Routes.PROFILE_PREVIEW) },
        )

        Spacer(Modifier.height(Spacing.medium))

        Statistics()

        Spacer(Modifier.height(Spacing.medium))
        
        RouteExplore()

        Spacer(Modifier.height(Spacing.medium))

        MapButtons()
    }
}


@Composable
private fun TopBar(onClickProfilePicture: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth(),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            // Profile picture
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(44.dp)
                    .background(
                        color = ColorPalette.primary,
                        shape = Roundness.circle,
                    )
                    .clip(Roundness.circle)
                    .clickable { onClickProfilePicture() },
            ) {
                Text(
                    text = "G",
                    style = TextStyle(
                        color = Color.Black,
                    ),
                )
            }

            Spacer(modifier = Modifier.width(Spacing.small))

            Text(
                text = "Welcome, Guest",
                color = Color.White,
            )
        }

        // Notifications button
        Box(
            modifier = Modifier
                .background(
                    color = ColorPalette.glassWhite,
                    shape = Roundness.circle,
                )
                .clip(Roundness.circle),
        ) {
            Icon(
                Icons.Outlined.Notifications,
                contentDescription = null,
                tint = ColorPalette.secondary,
                modifier = Modifier.padding(Spacing.small),
            )
        }
    }
}

@Composable
private fun Statistics() {
    @Composable
    fun StatBox(
        statName: String,
        value: Int,
        modifier: Modifier = Modifier,
    ) {
        Box(
            modifier = modifier
                .background(
                    color = ColorPalette.glassWhite,
                    shape = Roundness.small,
                )
        ) {
            Column(
                modifier = Modifier.padding(Spacing.small),
            ) {
                Text(
                    text = statName,
                    style = TextStyle(
                        color = Color.White,
                    ),
                )

                Spacer(Modifier.height(Spacing.small))
                
                Text(
                    text = "$value",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 32.sp,
                    ),
                )
            }
        }
    }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth(),
    ) {
        StatBox(
            statName = "Routes completed",
            value = 8,
            modifier = Modifier.weight(1f),
        )
        
        Spacer(Modifier.width(Spacing.medium))
        
        StatBox(
            statName = "Total kilometers",
            value = 412,
            modifier = Modifier.weight(1f),
        )
    }
}

@Composable
private fun RouteExplore() {
    Column {
        Text(
            text = "Explore",
            style = TextStyle(
                color = Color.White.copy(alpha = .5f),
            )
        )
        
        Spacer(Modifier.height(Spacing.small))

        val state = rememberLazyListState()
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            state = state,
            flingBehavior = rememberSnapFlingBehavior(lazyListState = state)
        ) {
            items(2) {
                MapRoute(modifier = Modifier.weight(0.9f))
                Spacer(Modifier.width(Spacing.medium))
            }
        }
    }
}

@Composable
private fun MapRoute(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(
                color = ColorPalette.glassWhite,
                shape = Roundness.small,
            )
    ) {
        Image(
            painter = painterResource(R.drawable.bike_trip),
            contentDescription = null,
            modifier = Modifier
                .clip(Roundness.small)
                .padding(Spacing.small),
        )
    }
}

@Composable
private fun MapButtons() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth(),
    ) {
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = ColorPalette.glassWhite,
            ),
            modifier = Modifier.weight(1f),
        ) {
            Text(
                text = "More details",
                style = TextStyle(
                    color = ColorPalette.primary,
                    fontWeight = FontWeight.Bold,
                ),
            )
        }
        
        Spacer(Modifier.width(Spacing.medium))

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = ColorPalette.glassWhite,
            ),
            onClick = {},

        ) {
            Icon(
                imageVector = Icons.Outlined.FavoriteBorder,
                contentDescription = null,
            )
        }
    }
}

