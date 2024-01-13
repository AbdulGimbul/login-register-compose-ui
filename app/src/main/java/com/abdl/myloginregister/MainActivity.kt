package com.abdl.myloginregister

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdl.myloginregister.ui.theme.MyLoginRegisterTheme
import com.abdl.myloginregister.ui.theme.blue1
import com.abdl.myloginregister.ui.theme.blue2

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyLoginRegisterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}

@Composable
fun LoginScreen() {

    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    var isPasswordVisible by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBackIos,
            contentDescription = null,
            modifier = Modifier
                .padding(8.dp)
                .size(24.dp)
                .clickable { /*TODO*/ }
        )
        Text(
            text = "Log In",
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 16.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = {
                    Text(text = "Email", color = Color.LightGray)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 16.dp)
                    .border(
                        width = 2.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(12.dp)
                    ),
                shape = RoundedCornerShape(12.dp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Mail,
                        contentDescription = null,
                        tint = Color.LightGray
                    )
                }
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = {
                    Text(text = "Password", color = Color.LightGray)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 16.dp)
                    .border(
                        width = 2.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(12.dp)
                    ),
                shape = RoundedCornerShape(12.dp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = null,
                        tint = Color.LightGray
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = if (isPasswordVisible)
                            Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = null,
                        tint = Color.LightGray,
                        modifier = Modifier.clickable {
                            isPasswordVisible = !isPasswordVisible
                        }
                    )
                },
                visualTransformation = if (isPasswordVisible) {
                    PasswordVisualTransformation()
                } else {
                    VisualTransformation.None
                },
            )
            Text(
                text = "Forgot password?",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                textAlign = TextAlign.End,
                fontWeight = FontWeight.SemiBold,
                color = blue1,
            )
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 16.dp)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                blue1,
                                blue2,
                            ),
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(Color.Transparent)
            ) {
                Text(
                    text = "Log In",
                    Modifier.padding(8.dp),
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                    )
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )
                Text(
                    text = "or Log in with",
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = Color.LightGray
                )
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedButton(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(12.dp),
                    border = BorderStroke(width = 2.dp, color = Color.LightGray),
                    modifier = Modifier.weight(1f)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(4.dp)
                            .size(24.dp),
                    )
                }

                OutlinedButton(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(12.dp),
                    border = BorderStroke(width = 2.dp, color = Color.LightGray),
                    modifier = Modifier.weight(1f)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.apple),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(4.dp)
                            .size(24.dp)
                    )
                }

                OutlinedButton(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(12.dp),
                    border = BorderStroke(width = 2.dp, color = Color.LightGray),
                    modifier = Modifier.weight(1f)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.facebook),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(4.dp)
                            .size(24.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Text(
                    text = "No account? Sign up",
                    textAlign = TextAlign.Center,
                    color = Color.LightGray
                )
                Text(text = " ")
                Text(
                    text = "here",
                    color = blue1,
                    fontWeight = FontWeight.SemiBold,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.clickable { /*TODO*/ })
            }
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun LoginPreview() {
    MyLoginRegisterTheme {
        LoginScreen()
    }
}