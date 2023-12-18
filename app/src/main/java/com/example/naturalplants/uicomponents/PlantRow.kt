package com.example.naturalplants.uicomponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.naturalplants.R
import com.example.naturalplants.models.Plant


@Composable
fun PlantRow(plant : Plant,
             onItemClick: (Plant) -> Unit){

    Row(
        verticalAlignment = Alignment.Top,
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clickable { onItemClick(plant) }

    ) {
        Image(
            painter = painterResource(id = plant.imageRes),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .border(
                    BorderStroke(1.dp, Color.Gray),
                    CircleShape
                )
                .padding(3.dp)
                .clip(CircleShape),
            contentDescription = "Plant image")
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp)
        ){
            Text(text = plant.name, style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = plant.description)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PlantRowPreview(){
    //PlantRow("Plant Name","Plant details",R.drawable.cilantro)
}