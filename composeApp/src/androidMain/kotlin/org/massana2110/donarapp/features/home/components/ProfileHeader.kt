package org.massana2110.donarapp.features.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.massana2110.donarapp.R
import org.massana2110.donarapp.theme.BluePrimary
import org.massana2110.donarapp.theme.BlueTertiary
import org.massana2110.donarapp.theme.LightGraySecondary
import org.massana2110.donarapp.theme.interFontFamily

@Composable
fun ProfileHeader(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(BlueTertiary)
    ) {
        TextButton(onClick = { /*TODO*/ }) {
            Text(
                text = "Editar",
                fontFamily = interFontFamily,
                fontWeight = FontWeight.Light,
                color = BluePrimary
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .size(96.dp)
                    .clip(CircleShape),
                painter = painterResource(id = R.drawable.photo_default),
                contentDescription = "Profile photo",
                contentScale = ContentScale.Crop
            )
            Text(
                text = "Vanessa Palma",
                modifier = Modifier.padding(vertical = 8.dp),
                fontFamily = interFontFamily,
                fontWeight = FontWeight.Bold,
                color = BluePrimary
            )

            Box(
                modifier = Modifier
                    .shadow(
                        6.dp,
                        shape = RoundedCornerShape(8.dp),
                        ambientColor = LightGraySecondary.copy(alpha = 0.2f)
                    )
                    .background(Color.White)
            ) {
                Row(modifier = Modifier.padding(8.dp)) {
                    Text(
                        text = "Tu saldo disponible: ",
                        fontFamily = interFontFamily
                    )
                    Text(
                        text = "$75.00",
                        fontFamily = interFontFamily,
                        fontWeight = FontWeight.Bold,
                        color = BluePrimary
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun ProfileHeaderPreview() {
    ProfileHeader()
}