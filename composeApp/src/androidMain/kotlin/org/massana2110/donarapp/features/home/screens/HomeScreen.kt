package org.massana2110.donarapp.features.home.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.massana2110.donarapp.features.home.components.HomeContent
import org.massana2110.donarapp.features.home.components.HomeHeader

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        HomeHeader()
        HomeContent(modifier = Modifier.padding(16.dp))
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}