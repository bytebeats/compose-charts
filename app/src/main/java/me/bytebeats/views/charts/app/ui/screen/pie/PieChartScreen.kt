package me.bytebeats.views.charts.app.ui.screen.pie

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.bytebeats.views.charts.app.ui.ScreenRouter
import me.bytebeats.views.charts.app.ui.theme.Margins
import me.bytebeats.views.charts.pie.PieChart
import me.bytebeats.views.charts.pie.render.SimpleSliceDrawer

/**
 * Created by bytebeats on 2021/9/30 : 15:50
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */

@Composable
fun PieChartScreen() {
    Scaffold(topBar = {
        TopAppBar(navigationIcon = {
            IconButton(onClick = { ScreenRouter.navigateHome() }) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Go back Home")
            }
        }, title = { Text(text = "Pie Chart") })
    }) {
        PieChartScreenContent(Modifier.padding(it))
    }
}

@Composable
private fun PieChartScreenContent(
    modifier: Modifier = Modifier
) {
    val pieChartDataModel = remember {
        PieChartDataModel()
    }

    Column(
        modifier = modifier.padding(
            horizontal = Margins.horizontal,
            vertical = Margins.vertical
        )
    ) {
        PieChartRow(pieChartDataModel = pieChartDataModel)
        SliceThicknessRow(
            sliceThickness = pieChartDataModel.sliceThickness,
            onValueUpdated = { pieChartDataModel.sliceThickness = it },
        )
        AddOrRemoveSliceRow(pieChartDataModel = pieChartDataModel)
    }
}

@Composable
private fun PieChartRow(pieChartDataModel: PieChartDataModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(vertical = Margins.vertical)
    ) {
        PieChart(
            pieChartData = pieChartDataModel.pieChartData,
            sliceDrawer = SimpleSliceDrawer(sliceThickness = pieChartDataModel.sliceThickness)
        )
    }
}

@Composable
private fun SliceThicknessRow(sliceThickness: Float, onValueUpdated: (Float) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = Margins.verticalLarge),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Slice Thickness: ",
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(end = Margins.horizontal)
        )
        Slider(
            value = sliceThickness,
            onValueChange = onValueUpdated,
            valueRange = 10F.rangeTo(100F)
        )
    }
}

@Composable
private fun AddOrRemoveSliceRow(pieChartDataModel: PieChartDataModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = Margins.vertical),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { pieChartDataModel.removeSlice() },
            enabled = pieChartDataModel.slices.size > 3,
            shape = CircleShape
        ) {
            Icon(Icons.Filled.Delete, contentDescription = "Remove slice from PieChart")
        }
        Row(
            modifier = Modifier.padding(horizontal = Margins.horizontal),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Slices: ")
            Text(
                text = pieChartDataModel.slices.count().toString(),
                style = TextStyle(fontWeight = FontWeight.ExtraBold, fontSize = 18.sp)
            )
        }
        Button(
            onClick = { pieChartDataModel.addSlice() },
            enabled = pieChartDataModel.slices.size < 9,
            shape = CircleShape
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Add Slice to PieChart"
            )
        }
    }
}

@Preview
@Composable
fun PieChartPreview() = PieChartScreen()
