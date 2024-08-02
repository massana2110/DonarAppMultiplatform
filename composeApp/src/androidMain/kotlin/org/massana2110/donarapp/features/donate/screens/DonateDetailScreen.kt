package org.massana2110.donarapp.features.donate.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.massana2110.donarapp.features.home.components.CustomTopBar
import org.massana2110.donarapp.features.home.models.listDonationOrganizations
import org.massana2110.donarapp.theme.BluePrimary

@Composable
fun DonateDetailScreen() {
    val item = listDonationOrganizations[0]

    Column(modifier = Modifier.fillMaxSize()) {
        CustomTopBar(title = "Descripción") {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Outlined.Share,
                    contentDescription = "Exit",
                    tint = BluePrimary
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .padding(horizontal = 16.dp)
                .clip(
                    RoundedCornerShape(8.dp)
                ),
            painter = painterResource(id = item.imgOrganization),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .offset(x = 24.dp, y = (-30).dp)
                .shadow(4.dp, CircleShape, ambientColor = Color(0xFF3C3C3C).copy(alpha = 0.1f))
                .background(Color.White)
        ) {
            Image(
                modifier = Modifier
                    .size(80.dp)
                    .padding(16.dp),
                painter = painterResource(id = item.logoOrganization),
                contentDescription = ""
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun DonateDetailScreenPreview() {
    DonateDetailScreen()
}