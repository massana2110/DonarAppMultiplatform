package org.massana2110.donarapp.features.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.massana2110.donarapp.theme.GrayTertiary
import org.massana2110.donarapp.theme.YellowPrimary
import org.massana2110.donarapp.theme.interFontFamily

@Composable
fun DonationProgressIndicator(
    modifier: Modifier = Modifier,
    donationReached: Int,
    donationGoal: Int,
    percentReached: Int,
    colorLinearIndicator: Color
) {
    Column(modifier = modifier) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                Text(
                    text = "$$donationReached/",
                    fontFamily = interFontFamily,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 12.sp,
                )
                Text(
                    text = "$$donationGoal",
                    modifier = Modifier.padding(start = 2.dp),
                    fontFamily = interFontFamily,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 12.sp,
                    color = GrayTertiary
                )
            }

            Text(text = "$percentReached%")
        }

        LinearProgressIndicator(
            progress = { percentReached.toFloat() / 100 },
            color = colorLinearIndicator,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp)
                .clip(RoundedCornerShape(4.dp))
        )
    }
}

@Preview
@Composable
private fun DonationProgressIndicatorPrev() {
    DonationProgressIndicator(
        modifier = Modifier.fillMaxWidth(),
        donationReached = 1200,
        donationGoal = 2000,
        percentReached = 60,
        colorLinearIndicator = YellowPrimary
    )
}