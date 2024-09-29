package io.bikeway.ui.screen

import android.provider.ContactsContract.Profile
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.bikeway.ui.theme.TextType
import io.bikeway.ui.viewmodel.ProfilePreviewViewModel

@Composable
fun ProfilePreviewScreen(
    viewModel: ProfilePreviewViewModel,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        TopBar()
    }
}

@Composable
private fun TopBar() {
    Surface {
        Text(
            text = "Profile preview",
            style = TextType.headline,
        )
    }
}