package io.bikeway.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.bikeway.ui.theme.ColorPalette
import io.bikeway.ui.theme.Roundness
import io.bikeway.ui.theme.Spacing

@Composable
fun BookmarksScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(ColorPalette.background)
            .padding(Spacing.medium),
    ) {
        TopBar()
        BookmarkList()
    }
}

@Composable
private fun TopBar() {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text(
            text = "Bookmarks",
            style = TextStyle(
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
            ),
            modifier = Modifier.padding(vertical = Spacing.small)
        )
    }
}

@Composable
private fun BookmarkList() {
    LazyColumn {
        items(20) {
            BookmarkedTrip(it % 3 == 0)
            Spacer(Modifier.height(Spacing.small))
        }
    }
}

@Composable
private fun BookmarkedTrip(isCompleted: Boolean) {
    Box(
        modifier = Modifier.background(
            color = ColorPalette.glassWhite,
            shape = Roundness.small,
        ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(Spacing.small)
                .fillMaxWidth(),
        ) {
            Icon(
                imageVector = when (isCompleted){
                    true -> Icons.Filled.CheckCircle
                    false -> Icons.Outlined.CheckCircle
                },
                contentDescription = null,
                tint = when (isCompleted) {
                    true -> ColorPalette.primary
                    false -> ColorPalette.secondary
                },
            )

            Spacer(Modifier.width(Spacing.small))

            Column {
                Text(
                    text = "Route name",
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                    ),
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Place,
                        contentDescription = null,
                        tint = ColorPalette.secondary,
                        modifier = Modifier.size(18.dp)
                    )

                    Spacer(Modifier.width(Spacing.extraSmall))

                    Text(
                        text = "16 km",
                        style = TextStyle(
                            color = ColorPalette.secondary,
                        ),
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth(),
            ) {
                IconButton(
                    onClick = {},
                ) {
                    Icon(
                        imageVector = Icons.Filled.MoreVert,
                        contentDescription = null,
                        tint = Color.White,
                    )
                }
            }
        }
    }
}
