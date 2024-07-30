package org.massana2110.donarapp.features.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import org.massana2110.donarapp.R
import org.massana2110.donarapp.theme.BluePrimary
import org.massana2110.donarapp.theme.interFontFamily

@Composable
fun ProfileLogoutModal(onDismiss: () -> Unit, onContinueClick: () -> Unit) {
    Dialog(onDismissRequest = { onDismiss() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(0.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_information_blue),
                    contentDescription = ""
                )

                Text(
                    text = "Cerrar sesión",
                    modifier = Modifier.padding(top = 8.dp),
                    fontFamily = interFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = BluePrimary
                )

                Text(
                    text = "No podras realizar donaciones\n" +
                            "sin haber iniciado sesión",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 4.dp),
                    fontFamily = interFontFamily,
                    lineHeight = 15.sp,
                )

                Spacer(modifier = Modifier.height(16.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedButton(
                        modifier = Modifier.height(30.dp),
                        onClick = { onDismiss() },
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(1.dp, BluePrimary),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = BluePrimary),
                        contentPadding = PaddingValues(horizontal = 16.dp)
                    ) {
                        Text(text = "Cancelar")
                    }
                    OutlinedButton(
                        modifier = Modifier.height(30.dp),
                        onClick = { onContinueClick() },
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(1.dp, BluePrimary),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = BluePrimary),
                        contentPadding = PaddingValues(horizontal = 16.dp)
                    ) {
                        Text(text = "Continuar")
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
private fun ProfileLogoutModalPrev() {
    ProfileLogoutModal(onDismiss = {}, onContinueClick = {})
}