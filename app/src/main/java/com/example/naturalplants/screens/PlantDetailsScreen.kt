package com.example.naturalplants.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.naturalplants.data.plants
import com.example.naturalplants.models.Plant
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun PlantDetailsScreen(navController: NavController,plantID : Int?)
{

    //
    val coroutineScope = rememberCoroutineScope()
    val data = remember { mutableStateOf("") }

    // Implement composable later
    coroutineScope.launch {
        // Simulate network call
        delay(5000)
        val plant = plants.find { plant ->  plant.id == plantID}
        if (plant != null) {
            data.value = plant.name
        }else{
            data.value = "Not found"
        }
    }

//    val plant = plants.find { plant ->  plant.id == plantID}


    Column {

        Text(text = data.value)

        Spacer(modifier = Modifier.size(8.dp))

        Text(text = data.value)

    }

}