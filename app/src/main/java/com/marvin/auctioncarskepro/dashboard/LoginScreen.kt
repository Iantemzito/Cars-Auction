package com.marvin.auctioncarskepro.dashboard



import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.marvin.auctioncarskepro.navigation.HOME_URL
import com.marvin.auctioncarskepro.navigation.REGISTER_URL
import com.marvin.auctioncarskepro.ui.theme.AuctionCarsKEProTheme

@Composable
fun LoginScreen(navController: NavHostController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var isLoggingIn by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // App Logo
        Image(
            painter = rememberImagePainter("https://example.com/logo.png"),
            contentDescription = "App Logo",
            modifier = Modifier.size(150.dp)


        )

        Spacer(modifier = Modifier.height(24.dp))

        // Username TextField
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            leadingIcon = {
                Icon(Icons.Filled.Person, contentDescription = "Username Icon")
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Password TextField
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            leadingIcon = {
                Icon(Icons.Filled.Lock, contentDescription = "Password Icon")
            },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = "Toggle Password Visibility"
                    )
                }
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { /* Handle on Done */ }
            ),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Login Button
        Button(
            onClick = {
                if (username.isNotEmpty() && password.isNotEmpty()) {
                    isLoggingIn = true
                    navController.navigate(HOME_URL)
                    // Simulate login delay
//                    onLoginSuccess()
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = !isLoggingIn
        ) {
            Text(text = if (isLoggingIn) "Logging in..." else "Login")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Forgot Password link
        TextButton(onClick = { navController.navigate(REGISTER_URL) }) {
            Text(text = "Register instead...", style = MaterialTheme.typography.bodySmall)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Or social login options
        Text(text = "Or login with", style = MaterialTheme.typography.bodyMedium)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Example: Google, Facebook login buttons (implement as needed)
            IconButton(onClick = { /* Google login logic */ }) {
                Icon(Icons.Filled.Email, contentDescription = "Google Login")
            }
            IconButton(onClick = { /* Facebook login logic */ }) {
                Icon(Icons.Filled.Face, contentDescription = "Facebook Login")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    AuctionCarsKEProTheme {
        LoginScreen(navController = rememberNavController())
    }
}
