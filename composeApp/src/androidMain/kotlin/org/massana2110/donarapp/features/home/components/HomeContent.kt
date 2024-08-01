package org.massana2110.donarapp.features.home.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield
import org.massana2110.donarapp.R
import org.massana2110.donarapp.theme.BluePrimary
import org.massana2110.donarapp.theme.BlueTertiary
import org.massana2110.donarapp.theme.GrayPrimary
import org.massana2110.donarapp.theme.YellowPrimary
import org.massana2110.donarapp.theme.interFontFamily

data class BannerItem(
    @DrawableRes val image: Int,
    val quantity: Int,
    val title: String,
    val description: String
)

data class CategoryItem(
    @DrawableRes val icon: Int,
    val name: String
)

data class ProjectItem(
    @DrawableRes val image: Int,
    val badgeName: String,
    val title: String,
    val description: String,
    val moneyReached: Int,
    val moneyGoal: Int,
    val percentReached: Int,
    val contributors: Int,
)

val categoryItems = listOf(
    CategoryItem(R.drawable.ic_dog, "Animalistas"),
    CategoryItem(R.drawable.ic_person, "Humanitarias"),
    CategoryItem(R.drawable.ic_plant, "Ambientales"),
    CategoryItem(R.drawable.ic_health, "Salud"),
    CategoryItem(R.drawable.ic_education, "Educación"),
    CategoryItem(R.drawable.ic_adult, "Adulto mayor"),
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeContent(modifier: Modifier) {
    val bannerItems = listOf(
        BannerItem(
            R.drawable.dogs_banner,
            85,
            "Perritos \nalimentados",
            "Gracias a tus donaciones\nen Arani El Salvador"
        ),
        BannerItem(
            R.drawable.garden_banner,
            98,
            "Arboles \nsembrados",
            "Gracias a tus donaciones\nen Fundación Naturaleza"
        ),
        BannerItem(
            R.drawable.dentist_banner,
            50,
            "Consultas \ndentales",
            "A través de su programa\nprimera infancia de FUSAL"
        ),
    )

    val projectItems = listOf(
        ProjectItem(
            image = R.drawable.education_image,
            badgeName = "Educación",
            title = "Educo",
            description = "Ayudanos a realizar mejoras en las infraestructuras de escuelas del país.",
            moneyReached = 700,
            moneyGoal = 1200,
            percentReached = 58,
            contributors = 3217
        ),
        ProjectItem(
            image = R.drawable.medical_image,
            badgeName = "Salud",
            title = "Fusal",
            description = "Ayudanos a dar un mejor servicio medico a la población del país.",
            moneyReached = 1258,
            moneyGoal = 3500,
            percentReached = 36,
            contributors = 3854
        ),
        ProjectItem(
            image = R.drawable.medical_image,
            badgeName = "Adulto mayor",
            title = "Fusate",
            description = "Buscamos brindar 100 terapias físicas a adultos mayores. ",
            moneyReached = 3250,
            moneyGoal = 3800,
            percentReached = 86,
            contributors = 4210
        ),
    )

    val pagerState = rememberPagerState(pageCount = { bannerItems.size })
    val scrollState = rememberScrollState()

    LaunchedEffect(Unit) {
        while (true) {
            yield()
            delay(2600)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % (pagerState.pageCount)
            )
        }
    }
    Column(modifier = Modifier.verticalScroll(scrollState)) {
        HomeBanner(modifier, bannerItems = bannerItems, pagerState = pagerState)
        HomeCategories(categoryItems)
        HomeProjects(modifier, projectItems)
        HomeInvites(modifier)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeBanner(modifier: Modifier, bannerItems: List<BannerItem>, pagerState: PagerState) {
    Box(
        modifier
            .fillMaxWidth()
            .height(150.dp)
    ) {
        HorizontalPager(state = pagerState) {
            Card(
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Box {
                    Image(
                        painter = painterResource(id = bannerItems[it].image),
                        contentDescription = bannerItems[it].title,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop,
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(start = 8.dp, bottom = 8.dp),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = bannerItems[it].quantity.toString(),
                                fontFamily = interFontFamily,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                fontSize = 40.sp
                            )
                            Text(
                                text = bannerItems[it].title,
                                fontFamily = interFontFamily,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                lineHeight = 16.sp,
                                modifier = Modifier.padding(start = 4.dp)
                            )
                        }
                        Text(
                            text = bannerItems[it].description,
                            fontFamily = interFontFamily,
                            fontWeight = FontWeight.Normal,
                            color = Color.White,
                            lineHeight = 13.sp,
                            fontSize = 10.sp
                        )
                    }
                }
            }
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerIndicator(pagerState: PagerState, modifier: Modifier) {
    Row(modifier = modifier.padding(bottom = 8.dp)) {
        repeat(pagerState.pageCount) { iteration ->
            val color = if (pagerState.currentPage == iteration) YellowPrimary else BlueTertiary
            Box(modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(12.dp)
            )
        }
    }
}

@Composable
fun HomeCategories(categoryItems: List<CategoryItem>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Dona por categoría",
            fontFamily = interFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        LazyRow(
            modifier = Modifier.padding(top = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(categoryItems) {
                ItemCategory(categoryItem = it)
            }
        }
    }
}

@Composable
fun ItemCategory(categoryItem: CategoryItem) {
    Column(
        modifier = Modifier
            .width(90.dp)
            .clip(RoundedCornerShape(8.dp))
            .border(1.dp, BluePrimary, RoundedCornerShape(8.dp))
            .background(Color.White)
            .clickable { /* TODO */ },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(32.dp)
                .padding(top = 12.dp),
            painter = painterResource(id = categoryItem.icon),
            contentDescription = categoryItem.name,
        )

        Text(
            text = categoryItem.name,
            modifier = Modifier.padding(start = 8.dp, top = 2.dp, end = 8.dp, bottom = 12.dp),
            fontSize = 11.sp,
            fontFamily = interFontFamily,
            fontWeight = FontWeight.Normal,
            color = BluePrimary
        )
    }
}

@Composable
fun HomeProjects(modifier: Modifier, projectItems: List<ProjectItem>) {
    Column(modifier = modifier) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Proyectos urgentes",
                fontFamily = interFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )

            Text(
                text = "Ver todo",
                fontFamily = interFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                color = BluePrimary
            )
        }

        LazyRow(
            modifier = Modifier.padding(top = 16.dp),
            contentPadding = PaddingValues(horizontal = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(projectItems) {
                ItemProject(it)
            }
        }
    }
}

@Composable
fun ItemProject(projectItem: ProjectItem) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.width(235.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Box(Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = projectItem.image),
                contentDescription = projectItem.title,
                Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            DonarBadge(
                text = projectItem.badgeName,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
        Text(
            text = projectItem.title,
            modifier = Modifier.padding(top = 8.dp, start = 4.dp),
            fontFamily = interFontFamily,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = projectItem.description,
            modifier = Modifier.padding(top = 4.dp, start = 4.dp, end = 4.dp),
            fontFamily = interFontFamily,
            fontWeight = FontWeight.Normal,
            lineHeight = 14.sp,
            fontSize = 12.sp,
        )

        DonationProgressIndicator(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 8.dp),
            donationReached = projectItem.moneyReached,
            donationGoal = projectItem.moneyGoal,
            percentReached = projectItem.percentReached,
            colorLinearIndicator = BluePrimary
        )

        Text(
            text = "${projectItem.contributors} contribuciones",
            fontFamily = interFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            modifier = Modifier.padding(horizontal = 8.dp)
        )

        Button(
            onClick = { /*TODO*/ }, modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 32.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = YellowPrimary,
                contentColor = GrayPrimary
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "Donar ahora", fontFamily = interFontFamily,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 12.sp,
            )
        }
    }
}

@Composable
fun HomeInvites(modifier: Modifier) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(BlueTertiary),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            modifier = Modifier
                .width(175.dp)
                .height(100.dp)
                .padding(horizontal = 8.dp),
            painter = painterResource(id = R.drawable.friends_invite_illustration),
            contentDescription = ""
        )

        Column(
            modifier = Modifier.padding(vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Invita a tus amigos",
                modifier = Modifier.fillMaxWidth(),
                fontFamily = interFontFamily,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 16.sp,
            )
            Text(
                text = "Y conviertanse en agentes de cambio para un mejor El Salvador",
                fontFamily = interFontFamily,
                fontWeight = FontWeight.Normal,
                lineHeight = 16.sp,
                modifier = Modifier.padding(end = 16.dp, top = 2.dp)
            )
            OutlinedButton(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, BluePrimary),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.White,
                )
            ) {
                Text(text = "Ver más", color = BluePrimary)
            }
        }
    }
}

@Preview(showSystemUi = true, device = "id:pixel_6")
@Composable
private fun HomeContentPreview() {
    Surface {
        HomeContent(Modifier.padding(16.dp))
    }
}