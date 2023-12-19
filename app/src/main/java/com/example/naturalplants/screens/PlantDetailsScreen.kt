package com.example.naturalplants.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.naturalplants.data.plants
import com.example.naturalplants.models.Plant

@Composable
fun PlantDetailsScreen(navController: NavController,plantID : Int?)
{

    // Implement composable later
    val plant = plants.find { plant ->  plant.id == plantID}


    Column {
        if (plant != null) {
            Text(text = plant.name)
        }
        Spacer(modifier = Modifier.size(8.dp))
        if (plant != null) {
            Text(text = plant.description)
        }
    }

}