package org.massana2110.donarapp.features.home.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.massana2110.donarapp.R
import org.massana2110.donarapp.theme.GrayTertiary
import org.massana2110.donarapp.theme.YellowPrimary
import org.massana2110.donarapp.theme.interFontFamily

data class ProfileDonation(
    @DrawableRes val imageResourceId: Int,
    val title: String,
    val category: String,
    val amountDonated: Double,
    val amountGoal: Double,
    val percentageReached: Int
)

@Composable
fun ProfileDonationsList(modifier: Modifier = Modifier) {
    val listDonations = listOf(
        ProfileDonation(
            imageResourceId = R.drawable.manada_pick,
            title = "La Manada de Pick",
            category = "Animalista",
            amountDonated = 700.0,
            amountGoal = 1200.0,
            percentageReached = 65
        ),
        ProfileDonation(
            imageResourceId = R.drawable.fusal,
            title = "La Manada de Pick",
            category = "Salud",
            amountDonated = 700.0,
            amountGoal = 1200.0,
            percentageReached = 65
        ),
        ProfileDonation(
            imageResourceId = R.drawable.fundeso,
            title = "La Manada de Pick",
            category = "Salud",
            amountDonated = 700.0,
            amountGoal = 1200.0,
            percentageReached = 65
        ),
    )

    LazyColumn(modifier = modifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {
        item {
            Text(
                text = "Últimas donaciones",
                fontFamily = interFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
        items(listDonations) {
            DonationItem(donationItem = it)
        }
    }
}

@Composable
fun DonationItem(modifier: Modifier = Modifier, donationItem: ProfileDonation) {
    Card(
        modifier = modifier.fillMaxWidth(),
        onClick = { /*TODO*/ },
        colors = CardDefaults.elevatedCardColors(
            containerColor = GrayTertiary.copy(alpha = 0.2f)
        ),
        shape = RoundedCornerShape(8.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                modifier = Modifier.size(100.dp),
                painter = painterResource(id = donationItem.imageResourceId),
                contentDescription = donationItem.title
            )

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = donationItem.title,
                    fontFamily = interFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )

                DonarBadge(text = donationItem.category, modifier = Modifier.padding(vertical = 6.dp))

                DonationProgressIndicator(
                    donationReached = donationItem.amountDonated.toInt(),
                    donationGoal = donationItem.amountGoal.toInt(),
                    percentReached = donationItem.percentageReached,
                    colorLinearIndicator = YellowPrimary
                )
            }

        }
    }
}

@Preview(showBackground = false, showSystemUi = true)
@Composable
private fun ProfileDonationListPreview() {
    ProfileDonationsList()
}