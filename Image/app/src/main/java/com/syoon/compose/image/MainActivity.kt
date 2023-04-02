package com.syoon.compose.image

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.syoon.compose.image.ui.theme.ImageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImageTheme {
                //ImageEx()
                CoilEx()
            }
        }
    }
}

@Composable
fun ImageEx() {
    Column {
        // Step1 : Image 만들기
        Image(
            painter = painterResource(id = R.drawable.wall),
            contentDescription = "엔텔로프 캐넌"
        )

        // Step2 : ImageVector에 Incons.Filled.Settings를 설정
        Image(
            imageVector = Icons.Filled.Settings,
            contentDescription = "세팅"
        )
    }
}

@Composable
fun CoilEx() {
    Column {
        // Step1 : rememberImagePainter를 이용하여 Image의 painter 설정
        // deprecated 됐지만 Compose 한국어 문서에서는 추천
        val painter =
            rememberImagePainter(data = "https://user-images.githubusercontent.com/110798031/229339695-86b240e9-039f-47b8-8ae9-05f514de7311.png")

        Image(
            painter = painter,
            contentDescription = "벌새"
        )

        // Step2 : AsyncImage 이용하여 image 띄우기
        // 공식 라이브러리에서 추천하는 방법
        AsyncImage(
            model = "https://user-images.githubusercontent.com/110798031/229339695-86b240e9-039f-47b8-8ae9-05f514de7311.png",
            contentDescription = "벌새"
        )
    }
}

// 네트워크를 통해 가져오는 이미지는 preview로 볼 수 없음
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ImageTheme {
        //ImageEx()
    }
}