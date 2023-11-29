package com.syoon.compose.lazylayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.syoon.compose.lazylayout.ui.theme.LazyColumnTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumnTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LazyColumnEx(itemList = items)
                    //LazyRowEx(itemList = items)
                    //LazyVerticalGridEx(itemList = items)
                    //LazyHorizontalGridEx(itemList = items)
                }
            }
        }
    }
}

@Composable
fun TripItem(itemData: ItemData) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        //modifier = Modifier.padding(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier
            .padding(8.dp)
            //.width(200.dp)
        ) {
            Image(
                painter = painterResource(id = itemData.imageId),
                contentDescription = itemData.title,
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = itemData.title, style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = itemData.description)
        }
    }
}

/**
 * Lazy Layout
 * 기존 View 시스템에서 RecyclerView와 유사함
 * 화면에 표시될 때 스크롱 가능한 아이템 목록을 렌더링 (필요할 때만 보여주는 역할)
 */

@Composable
fun LazyColumnEx(itemList: List<ItemData>) {
    val listState = rememberLazyListState() // 스크롤 위치와 List 정보를 포함하는 객체
    val showButton by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > 0
        }
    }
    val coroutineScope = rememberCoroutineScope()

    Box {
        LazyColumn(
            state = listState,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // header와 footer를 item 블록으로 넣을 수 있음
            item {
                Text(text = ">>>>여행 정보 시작<<<<")
            }
            items(itemList) { item ->
                TripItem(itemData = item)
            }
        }

        AnimatedVisibility(modifier = Modifier.align(Alignment.BottomCenter), visible = showButton) {
            Button(onClick = {
                coroutineScope.launch {
                    listState.animateScrollToItem(
                        index = 0
                    )
                }
            }) {
                Text(text = "up")
            }
        }
    }
}

@Composable
fun LazyRowEx(itemList: List<ItemData>) {
    LazyRow(
        // modifier를 사용할 경우 스크롤 시 좌/우가 padding값이 들어가진 상태로 진행
//        modifier = Modifier.padding(
//            start = 24.dp,
//            end = 24.dp
//        ),

        // contentPadding을 사용하면 컨텐츠 내의 영역을 설정할 수 있음
        contentPadding = PaddingValues(
            start = 16.dp,
            end = 16.dp
        ),

        // 아이템 사이의 간격 설정
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(itemList) { item ->
            TripItem(itemData = item)
        }
    }
}

@Composable
fun LazyVerticalGridEx(itemList: List<ItemData>) {
    // columns의 너비를 지정
    LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 150.dp)) {
        items(itemList) {
            TripItem(itemData = it)
        }
    }
}

@Composable
fun LazyHorizontalGridEx(itemList: List<ItemData>) {
    // rows의 너비를 지정
    LazyHorizontalGrid(
        //rows = GridCells.Fixed(3),
        rows = GridCells.Adaptive(150.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(start = 16.dp)
    ) {
        items(itemList) {item ->
            TripItem(itemData = item)
        }
    }
}

/**
 * preview
 */
@Preview(showBackground = true)
@Composable
fun ItemPreView() {
    LazyColumnTheme {
        TripItem(
            ItemData(
                imageId = R.drawable.a1,
                title = "해변 놀이 공원",
                description = "해변 놀이 공원 설명입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreView() {
    LazyColumnTheme {
        LazyRowEx(itemList = items)
    }
}


/**
 * item data
 */
data class ItemData(
    @DrawableRes
    val imageId: Int,
    val title: String,
    val description: String,
)

val items = listOf(
    ItemData(
        imageId = R.drawable.a1,
        title = "해변 놀이 공원",
        description = "해변 놀이 공원 설명입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
    ),
    ItemData(
        imageId = R.drawable.a2,
        title = "캐년",
        description = "미국의 캐년입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
    ),
    ItemData(
        imageId = R.drawable.a3,
        title = "워터월드",
        description = "워터월드입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
    ),
    ItemData(
        imageId = R.drawable.a1,
        title = "미국의 캐년",
        description = "미국의 캐년입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
    ),
    ItemData(
        imageId = R.drawable.a5,
        title = "라스베가스",
        description = "라스베가스입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
    ),
    ItemData(
        imageId = R.drawable.a6,
        title = "호르슈 밴드",
        description = "호르슈 밴드입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
    ),
    ItemData(
        imageId = R.drawable.a7,
        title = "미국의 길",
        description = "미국의 길입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
    ),
    ItemData(
        imageId = R.drawable.a8,
        title = "엔텔로프 캐년",
        description = "엔텔로프 캐년입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
    ),
    ItemData(
        imageId = R.drawable.a9,
        title = "그랜드 캐년",
        description = "그랜드 캐년입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
    ),
)