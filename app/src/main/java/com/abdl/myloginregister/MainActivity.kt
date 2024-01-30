package com.abdl.myloginregister

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.abdl.myloginregister.ui.LoginRegisterApp
import com.abdl.myloginregister.ui.screen.LoginScreen
import com.abdl.myloginregister.ui.screen.RegisterScreen
import com.abdl.myloginregister.ui.theme.MyLoginRegisterTheme

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
                    val navController = rememberNavController()
                    LoginRegisterApp(navController = navController)
                }
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
        RegisterScreen(onBackButtonClicked = {}, onRegisterButtonClicked = {}, onTextHereClicked = {})
    }
}