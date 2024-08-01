package org.massana2110.donarapp.features.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.massana2110.donarapp.R
import org.massana2110.donarapp.theme.BluePrimary
import org.massana2110.donarapp.theme.LightGraySecondary
import org.massana2110.donarapp.theme.YellowPrimary
import org.massana2110.donarapp.theme.interFontFamily

@Composable
fun HomeHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(BluePrimary)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Bienvenida Vanessa",
                    fontFamily = interFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 16.sp
                )
                Row {
                    Text(
                        text = "Tu saldo disponible:",
                        fontFamily = interFontFamily,
                        fontWeight = FontWeight.Medium,
                        color = Color.White,
                    )
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(
                        text = "$75.00",
                        fontFamily = interFontFamily,
                        fontWeight = FontWeight.Medium,
                        color = YellowPrimary
                    )
                }
            }

            Image(
                painter = painterResource(id = R.drawable.photo_default),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
            )
        }

        DonationSearchField(modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFFFAFAFA))
            .clickable { /* TODO */ }
        )
    }
}

@Composable
fun DonationSearchField(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Buscar",
            Modifier.padding(start = 8.dp),
            tint = LightGraySecondary
        )
        Text(
            text = "Busca por nombre o tema de interes",
            color = LightGraySecondary,
            fontFamily = interFontFamily,
            fontWeight = FontWeight.Normal
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeHeaderPreview() {
    HomeHeader()
}