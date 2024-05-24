package com.wojtek.test_reader

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.FontResource
import test_readerapp.shared.generated.resources.*
import test_readerapp.shared.generated.resources.Res
import test_readerapp.shared.generated.resources.rubik_regular

@Composable
fun App() {

    TestScreen()
}


val commonFontSize = 14.sp
val style: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = FontFamily(Font(Res.font.rubik_regular, FontWeight.Normal)),
            fontWeight = FontWeight.Normal,
            fontSize = commonFontSize,
            color = Color.Black
        )
    }

val staticText =
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec non ligula quam. Sed et nisl non erat lacinia feugiat et et velit. Mauris mattis ante et tellus luctus, in efficitur erat rhoncus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean nec lorem lobortis, lacinia quam a, varius arcu. Nam blandit sapien in nunc sollicitudin, a interdum velit convallis. Donec tristique feugiat ex, eget volutpat felis rutrum sit amet. Maecenas aliquam, augue ut tincidunt finibus, libero ligula rutrum augue, et hendrerit nulla eros non enim. Aliquam et ante et risus porttitor vehicula. Curabitur maximus dapibus leo in lacinia. Aliquam non dictum purus. Pellentesque varius justo quis sem maximus eleifend. Quisque mattis ex ligula, eu cursus nunc congue vitae. Ut eu massa dignissim lacus placerat molestie."


data class Style(val color: Color = Color.Black, val fontSize: Float = 14f, val fontFamily: FontResource = Res.font.rubik_regular)

@Composable
fun TestScreen() {
    var styleState by remember {
        mutableStateOf(Style())
    }
    Column(modifier = Modifier.background(Color.White)) {
        LazyColumn(modifier = Modifier.weight(1.0f), verticalArrangement = Arrangement.spacedBy(24.dp)) {
            for (i in 0..100) {
                item {
                    Text(
                        staticText,
                        style = style.copy(color = styleState.color, fontSize = styleState.fontSize.sp, fontFamily = FontFamily(Font(styleState.fontFamily, FontWeight.Normal)))
                        )
                }
            }
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Text(
                modifier = Modifier.padding(16.dp).clickable {
                    styleState = (styleState.copy(color = Color.Black))
                },
                text = "Black",
                style = style
            )

            Text(
                modifier = Modifier.padding(16.dp).clickable {
                    styleState = (styleState.copy(color = Color.Green))
                },
                text = "Green",
                style = style
            )

            Text(
                modifier = Modifier.padding(16.dp).clickable {
                    styleState = (styleState.copy(color = Color.Yellow))
                },
                text = "Yellow",
                style = style
            )
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Text(
                modifier = Modifier.padding(16.dp).clickable {
                    styleState = (styleState.copy(fontSize = 14f))
                },
                text = "Size 14",
                style = style
            )

            Text(
                modifier = Modifier.padding(16.dp).clickable {
                    styleState = (styleState.copy(fontSize = 18f))
                },
                text = "Size 18",
                style = style
            )

            Text(
                modifier = Modifier.padding(16.dp).clickable {
                    styleState = (styleState.copy(fontSize = 22f))
                },
                text = "Size 22",
                style = style
            )
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Text(
                modifier = Modifier.padding(16.dp).clickable {
                    styleState = (styleState.copy(fontFamily = Res.font.rubik_regular))
                },
                text = "roboto",
                style = style
            )

            Text(
                modifier = Modifier.padding(16.dp).clickable {
                    styleState = (styleState.copy(fontFamily = Res.font.HelveticaNeueMedium))
                },
                text = "helvetica",
                style = style
            )

            Text(
                modifier = Modifier.padding(16.dp).clickable {
                    styleState = (styleState.copy(fontFamily = Res.font.COMICSANS))
                },
                text = "Comic Sans",
                style = style
            )
        }
    }
}
