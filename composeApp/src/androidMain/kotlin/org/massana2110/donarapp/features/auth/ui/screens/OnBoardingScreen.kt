package org.massana2110.donarapp.features.auth.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.massana2110.donarapp.R
import org.massana2110.donarapp.theme.BluePrimary
import org.massana2110.donarapp.theme.BlueTertiary
import org.massana2110.donarapp.theme.interFontFamily

data class OnboardingItem(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    onSkipClick: () -> Unit
) {
    val onBoardingItems = listOf(
        OnboardingItem(
            title = "Encuentra tu causa",
            description = "Puedes seleccionar entre 50 ONGs dirigidas a diferentes causas en un solo lugar.",
            image = R.drawable.onboarding_1
        ),
        OnboardingItem(
            title = "Se un agente de cambio",
            description = "Puedes donar una vez o las veces que desees, eligiendo a quien donar.",
            image = R.drawable.onboarding_2
        ),
        OnboardingItem(
            title = "Contribuye a un mejor futuro",
            description = "Sigue más de cerca las historias de quienes forman parte de las organizaciones.",
            image = R.drawable.onboarding_3
        ),
    )

    val pagerState = rememberPagerState(pageCount = { onBoardingItems.size })

    Box(modifier = modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
        TextButton(
            onClick = { onSkipClick() },
            colors = ButtonDefaults.textButtonColors(contentColor = BluePrimary)
        ) {
            Text(text = "Saltar", fontFamily = interFontFamily)
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OnboardingSection(
            modifier = Modifier.padding(horizontal = 12.dp),
            onBoardingItems,
            pagerState = pagerState
        )
        OnboardingPagerIndicator(pagerState = pagerState)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingSection(modifier: Modifier, items: List<OnboardingItem>, pagerState: PagerState) {
    HorizontalPager(state = pagerState, modifier = modifier) {
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = items[it].image),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                contentDescription = items[it].title
            )

            Text(
                text = items[it].title,
                modifier = Modifier.padding(top = 24.dp),
                fontFamily = interFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                lineHeight = 30.sp
            )
            Text(
                text = items[it].description,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 4.dp),
                fontFamily = interFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                lineHeight = 14.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingPagerIndicator(pagerState: PagerState) {
    val progress = pagerState.currentPage

    Row(modifier = Modifier.padding(top = 24.dp)) {
        repeat(pagerState.pageCount) { iteration ->
            val color = if (progress == iteration) BluePrimary else BlueTertiary
            val indicatorWidth = animateDpAsState(
                targetValue = if (progress == iteration) 34.dp else 15.dp,
                label = ""
            )

            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .height(15.dp)
                    .width(indicatorWidth.value)
                    .clip(CircleShape)
                    .background(color)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun OnBoardingPreview() {
    OnBoardingScreen {}
}