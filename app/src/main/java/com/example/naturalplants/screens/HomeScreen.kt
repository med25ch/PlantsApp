package com.example.naturalplants.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.naturalplants.data.plants
import com.example.naturalplants.navigation.NavigationItem
import com.example.naturalplants.uicomponents.PlantRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenUI(modifier : Modifier = Modifier,navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Natural Plants")
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) {innerPadding ->

        Column(
            modifier = modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {

            val context = LocalContext.current

            LazyColumn{

                items(plants) {plant ->

                    PlantRow(plant, onItemClick = {plant ->
                        Toast.makeText(context,"Item : ${plant.name} Clicked",Toast.LENGTH_SHORT).show()
                        navController.navigate(NavigationItem.DetailsScreen.route + "/${plant.id}")
                    })

                    // Divider
                    Divider(color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f))
                }

            }
        }

    }
}