package com.example.ekstrovertquiz.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.example.ekstrovertquiz.R
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView


class DetailComponent {

    @Composable
    fun VideoPlayer(isLoading:(Boolean) -> Unit) {
        AndroidView(factory = {
            var view = YouTubePlayerView(it)
            view.addYouTubePlayerListener(
                object : AbstractYouTubePlayerListener() {
                    override fun onReady(youTubePlayer: YouTubePlayer) {
                        super.onReady(youTubePlayer)
                        isLoading.invoke(false)
                        youTubePlayer.loadVideo("56JOMkPvoKs", 0f)
                    }
                }
            )
            view
        })
    }

    @Composable
    fun MateriDownload(
        modifier: Modifier = Modifier
    ) {
        Surface(
            shape = RoundedCornerShape(10.dp),
            elevation = 8.dp,
            color = MaterialTheme.colors.primary,
            contentColor = Color.White,
            modifier = modifier
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, bottom = 12.dp, end = 18.dp, start = 18.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Evolutionary Clustering",
                    style = MaterialTheme.typography.h1,
                    fontSize = 14.sp
                )

                Icon(
                    painter = painterResource(id = R.drawable.download_icon),
                    contentDescription = null,
                )
            }
        }
    }

    @Composable
    fun TopBar(navController: NavController) {
        Surface(
            Modifier
                .fillMaxWidth(),
            color = Color.White,
            elevation = 8.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp,top = 10.dp, bottom = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(painter = painterResource(id = R.drawable.dropdown_arrow),
                            contentDescription = null,
                            tint = Color.Black,
                            modifier = Modifier
                                .rotate(90f))
                    }
                    Text(text = "Evolutionary Clustering",
                        style = MaterialTheme.typography.h1,
                        fontSize = 16.sp,
                        color = Color.Black)
                }
            }
        }
    }

}