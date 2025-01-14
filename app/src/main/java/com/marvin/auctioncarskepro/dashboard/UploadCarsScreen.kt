package com.marvin.auctioncarskepro.dashboard


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.marvin.auctioncarskepro.ui.theme.AuctionCarsKEProTheme

@Composable
fun AddCarScreen(navController: NavHostController) {
    var carMake by remember { mutableStateOf("") }
    var carModel by remember { mutableStateOf("") }
    var carYear by remember { mutableStateOf("") }
    var carPrice by remember { mutableStateOf("") }
    var carImageUri by remember { mutableStateOf<String?>(null) }
    var isSubmitting by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        // App Logo (Optional)
        Image(
            painter = rememberImagePainter("https://example.com/logo.png"),
            contentDescription = "App Logo",
            modifier = Modifier.size(150.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Car Make TextField
        OutlinedTextField(
            value = carMake,
            onValueChange = { carMake = it },
            label = { Text("Car Make") },
            leadingIcon = { Icon(Icons.Filled.AddCircle, contentDescription = "Car Make Icon") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Car Model TextField
        OutlinedTextField(
            value = carModel,
            onValueChange = { carModel = it },
            label = { Text("Car Model") },
            leadingIcon = { Icon(Icons.Filled.AddCircle,contentDescription = "Car Model Icon") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Car Year TextField
        OutlinedTextField(
            value = carYear,
            onValueChange = { carYear = it },
            label = { Text("Car Year") },
            leadingIcon = { Icon(Icons.Filled.DateRange, contentDescription = "Car Year Icon") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Car Price TextField
        OutlinedTextField(
            value = carPrice,
            onValueChange = { carPrice = it },
            label = { Text("Price") },
            leadingIcon = { Icon(Icons.Filled.ShoppingCart, contentDescription = "Price Icon") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Car Image Upload Section
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {
                    // Trigger image selection (simulated)
                    // You can integrate an image picker or camera here
                    carImageUri = "https://example.com/carimage.jpg"  // Simulated image URI
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Add Car Photo")
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Upload Car Image")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Show selected car image (if any)
            carImageUri?.let {
                Image(
                    painter = rememberImagePainter(it),
                    contentDescription = "Car Image",
                    modifier = Modifier.size(200.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Add Car Button
        Button(
            onClick = {
                if (carMake.isNotEmpty() && carModel.isNotEmpty() && carYear.isNotEmpty() && carPrice.isNotEmpty()) {
                    isSubmitting = true
                    // Simulate submission process
//                    onCarAdded() // Callback for successful car addition
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = !isSubmitting
        ) {
            Text(text = if (isSubmitting) "Submitting..." else "Add Car")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddCarScreenPreview() {
    AuctionCarsKEProTheme {
        AddCarScreen(navController = rememberNavController())
    }
}
