package com.abdl.myloginregister.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.abdl.myloginregister.ui.screen.LoginScreen
import com.abdl.myloginregister.ui.screen.RegisterScreen

enum class Screen {
    Login, Register
}

@Composable
fun LoginRegisterApp(
    navController: NavHostController
) {

    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Login.name,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(Screen.Login.name){
                LoginScreen(
                    onLoginClicked = {},
                    onTextHereClicked = {
                        navController.navigate(Screen.Register.name)
                    }
                )
            }
            composable(Screen.Register.name){
                RegisterScreen(
                    onBackButtonClicked = {
                        navController.navigate(Screen.Login.name){
                            popUpTo(Screen.Login.name){
                                inclusive = true
                            }
                        }
                    },
                    onRegisterButtonClicked = {},
                    onTextHereClicked = {
                        navController.navigate(Screen.Login.name){
                            popUpTo(Screen.Login.name){
                                inclusive = true
                            }
                        }
                    }
                )
            }
        }
    }
}