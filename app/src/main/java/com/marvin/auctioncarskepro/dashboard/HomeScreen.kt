package com.marvin.auctioncarskepro.dashboard



import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.marvin.auctioncarskepro.ui.theme.AuctionCarsKEProTheme
import androidx.compose.material3.MaterialTheme
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

data class Car(
    val id: Int,
    val model: String,
    val price: String,
    val imageUrl: String,
    val s: String,
    val s1: String
)

val sampleCars: List<Car>
    get() {
        val sampleCars = listOf(
            Car(
                1,
                "Toyota Axio",
                "KSh 500,000",
                "https://example.com/toyota-corolla.jpg",
                "45000",
                "https://example.com/car3.jpg"
            ),
            Car(
                2,
                "Mazda CX-5",
                "KSh 1,200,000",
                "https://example.com/mazda-cx5.jpg",
                "45000",
                "https://example.com/car3.jpg"
            ),
            Car(
                3,
                "Honda Civic",
                "KSh 750,000",
                "https://example.com/honda-civic.jpg",
                "45000",
                "https://example.com/car3.jpg"
            ),
            Car(
                4,
                "BMW X5",
                "KSh 4,500,000",
                "https://example.com/bmw-x5.jpg",
                "45000",
                "https://example.com/car3.jpg"
            ),
            Car(
                5,
                "BMW X3",
                "KSh 3,500,000",
                "https://example.com/bmw-x3.jpg",
                "45000",
                "https://example.com/car3.jpg"

            ),
        )
        return sampleCars
    }

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Header()
        CategoriesSection()
        CarList(cars = sampleCars)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header() {
    TopAppBar(
        title = {
            Text("Auction Cars KE")
        },
        actions = {
            IconButton(onClick = { /* TODO: Open Auction History */  }) {
                Icon(Icons.Default.Star, contentDescription = "Auction History")
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary // Background color
        )
    )
}

@Composable
fun CategoriesSection() {
    LazyRow (
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        items(listOf("All Cars", "SUVs", "Sedans", "New Arrivals", "Filter")) { category ->
            CategoryChip(categoryName = category)
        }
    }
}

@Composable
fun CategoryChip(categoryName: String) {
    Surface(
        modifier = Modifier.padding(4.dp),
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.secondary,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onSecondary)
    ) {
        Text(
            text = categoryName,
            modifier = Modifier.padding(8.dp),
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
fun CarList(cars: List<Car>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        items(cars) { car ->
            CarItem(car = car)
        }
    }
}

@Composable
fun CarItem(car: Car) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = rememberImagePainter(car.imageUrl),
                contentDescription = car.model,
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                Text(text = car.model, style = MaterialTheme.typography.headlineMedium)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = car.price, style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(8.dp))
                BidButton()
            }
        }
    }
}

@Composable
fun BidButton() {
    Button(
        onClick = { /* TODO: Start Auction or Place Bid */ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
    ) {
        Text(text = "Place Bid", color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    AuctionCarsKEProTheme {
        HomeScreen(navController = rememberNavController())
    }
}

