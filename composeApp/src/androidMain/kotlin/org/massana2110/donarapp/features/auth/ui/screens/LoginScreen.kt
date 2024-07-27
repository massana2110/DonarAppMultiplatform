package org.massana2110.donarapp.features.auth.ui.screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.massana2110.donarapp.R
import org.massana2110.donarapp.features.auth.ui.viewmodels.LoginUiState
import org.massana2110.donarapp.theme.BluePrimary
import org.massana2110.donarapp.theme.BlueTertiary
import org.massana2110.donarapp.theme.Gray10
import org.massana2110.donarapp.theme.GrayPrimary
import org.massana2110.donarapp.theme.GraySecondary
import org.massana2110.donarapp.theme.GrayTertiary
import org.massana2110.donarapp.theme.YellowPrimary
import org.massana2110.donarapp.theme.interFontFamily

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    loginUiState: LoginUiState,
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLoginContinueClick: () -> Unit,
    onLoginSuccessful: () -> Unit
) {
    val context = LocalContext.current

    LaunchedEffect(loginUiState.isLoggedInSuccess) {
        if (loginUiState.isLoggedInSuccess) {
            Toast.makeText(context, "User Logged In", Toast.LENGTH_SHORT).show()
            onLoginSuccessful()
        }
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoginHeader()
        LoginDivider()
        LoginForm(
            email,
            password,
            onEmailChange,
            onPasswordChange,
            onLoginContinueClick,
            loginUiState.isLoading
        )
    }
}

@Composable
fun LoginHeader() {
    Image(painter = painterResource(id = R.drawable.ic_donar_app), contentDescription = "App Icon")
    Text(
        text = "Bienvenido a DonarApp",
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        color = BluePrimary,
        lineHeight = 29.sp,
        modifier = Modifier.padding(top = 16.dp)
    )
    Text(
        text = "Crea una cuenta o inicia sesión para convertirte \n" +
                "en un agente de cambio ",
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = GrayPrimary,
        textAlign = TextAlign.Center,
        lineHeight = 16.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 8.dp)
    )
    LoginSocialButtons()
}

@Composable
fun LoginSocialButtons() {
    Row(
        modifier = Modifier.padding(top = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(42.dp)) {
            Image(
                painter = painterResource(id = R.drawable.ic_apple),
                contentDescription = "Apple logo"
            )
        }
        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .size(42.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_google),
                contentDescription = "Apple logo"
            )
        }
        IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(42.dp)) {
            Image(
                painter = painterResource(id = R.drawable.ic_facebook),
                contentDescription = "Apple logo"
            )
        }
    }
}

@Composable
fun LoginDivider() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 32.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        HorizontalDivider(
            Modifier
                .height(1.dp)
                .weight(1f),
            color = Gray10
        )
        Text(
            text = "O si prefieres",
            modifier = Modifier.padding(horizontal = 18.dp),
            fontSize = 14.sp,
            fontFamily = interFontFamily,
            fontWeight = FontWeight.Normal,
            color = GrayPrimary
        )
        HorizontalDivider(
            Modifier
                .height(1.dp)
                .weight(1f),
            color = Gray10
        )
    }
}

@Composable
fun LoginForm(
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLoginContinueClick: () -> Unit,
    loading: Boolean,
) {
    Spacer(modifier = Modifier.height(16.dp))
    LoginInput(
        modifier = Modifier.padding(horizontal = 16.dp),
        label = "Correo electronico",
        placeHolder = "example@correo.com",
        value = email,
        onTextChanged = { onEmailChange(it) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
    )
    Spacer(modifier = Modifier.height(16.dp))
    LoginInput(
        modifier = Modifier.padding(horizontal = 16.dp),
        label = "Contraseña",
        placeHolder = "●●●●●●●●●",
        value = password,
        onTextChanged = { onPasswordChange(it) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = PasswordVisualTransformation()
    )
    Text(
        text = "¿Olvidaste tu contraseña",
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = GrayPrimary,
        modifier = Modifier.padding(top = 12.dp)
    )
    Button(
        onClick = { onLoginContinueClick() },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp, end = 16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = YellowPrimary,
            contentColor = GrayPrimary
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        if (loading) CircularProgressIndicator(modifier = Modifier.size(24.dp), color = Color.Black)
        else Text(text = "Continuar")
    }
    Spacer(modifier = Modifier.height(16.dp))
    Row {
        Text(
            text = "¿No tienes cuenta?",
            fontSize = 14.sp,
            color = GrayPrimary,
            fontFamily = interFontFamily
        )
        Text(
            text = "Crear cuenta",
            modifier = Modifier.padding(horizontal = 8.dp),
            fontSize = 14.sp,
            fontFamily = interFontFamily,
            color = BluePrimary,
        )
    }
}

@Composable
fun LoginInput(
    modifier: Modifier = Modifier,
    label: String,
    placeHolder: String,
    value: String,
    onTextChanged: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    var inputBorderWithValue by remember {
        mutableStateOf(GraySecondary)
    }
    var inputContainerWithValue by remember {
        mutableStateOf(Color(0xFFF0F2F5))
    }

    Column(modifier = modifier) {
        Text(
            text = label,
            fontFamily = interFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = GrayPrimary,
        )
        Surface(
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, inputBorderWithValue), // Change the color as needed
            color = inputContainerWithValue,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            TextField(
                value = value,
                onValueChange = {
                    onTextChanged(it)
                    if (it.isBlank()) {
                        inputBorderWithValue = GraySecondary
                        inputContainerWithValue = Color(0xFFF0F2F5)
                    } else {
                        inputBorderWithValue = BluePrimary
                        inputContainerWithValue = BlueTertiary
                    }
                },
                placeholder = { Text(text = placeHolder) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                maxLines = 1,
                keyboardOptions = keyboardOptions,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedPlaceholderColor = GrayTertiary,
                    unfocusedPlaceholderColor = GrayTertiary,
                ),
                visualTransformation = visualTransformation
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun LoginScreenPreview() {
    LoginScreen(
        loginUiState = LoginUiState(),
        email = "david.massana@gmail.com",
        password = "Hello",
        onEmailChange = {},
        onPasswordChange = {},
        onLoginContinueClick = {},
        onLoginSuccessful = {}
    )
}