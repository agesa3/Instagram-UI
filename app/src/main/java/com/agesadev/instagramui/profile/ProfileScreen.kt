package com.agesadev.instagramui.profile

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.Alignment
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.agesadev.instagramui.R

@Composable
fun ProfileScreen() {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(name = "agesa_collins", modifier = Modifier.padding(10.dp))
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(25.dp))
        ButtonSection(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
        )
        Spacer(modifier = Modifier.height(25.dp))
        HighlightSection(
            highlights = listOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.bell),
                    text = "Youtube"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.bell),
                    text = "Youtube"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.bell),
                    text = "Youtube"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.bell),
                    text = "Youtube"
                ),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        PostTabView(
            imageWithText = listOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.bell),
                    text = "Posts"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.bell),
                    text = "Reels"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.bell),
                    text = "IGTV"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.bell),
                    text = "Profile"
                ),
            )
        ) {
            selectedTabIndex = it
        }
        when(selectedTabIndex){
            0-> PostSection(posts = listOf(

            ))

        }
    }
}

@Composable
fun TopBar(
    name: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier.fillMaxWidth()
    ) {

        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Icon(
            painter = painterResource(id = R.drawable.bell),
            contentDescription = "Back",
            modifier = Modifier.size(24.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.dotmenu),
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(20.dp)
        )

    }

}

@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
) {
    Column(modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            RoundImage(
                image = painterResource(id = R.drawable.profile_me),
                modifier = Modifier
                    .size(100.dp)
                    .weight(3f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            StatSection(modifier = Modifier.weight(7f))
        }
        ProfileDescription(
            displayName = "Agesa Collins",
            description = "Android Developer",
            url = "https://github.com/agesa3",
            followedBy = listOf("Elon Musk", "Jeff Bezos"),
            otherCount = 50
        )

    }


}

@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier = Modifier
) {
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(
                1f, matchHeightConstraintsFirst = true
            )
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape

            )
            .padding(3.dp)
            .clip(CircleShape)
    )

}

@Composable
fun StatSection(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier

    ) {
        ProfileStat(numberText = "384", text = "Posts")
        ProfileStat(numberText = "100K", text = "Followers")
        ProfileStat(numberText = "300", text = "Following")
    }
}


@Composable
fun ProfileStat(
    numberText: String,
    text: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = numberText,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text)
    }

}

@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    url: String,
    followedBy: List<String>,
    otherCount: Int
) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = description,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = url,
            color = Color(0xff3d3d91),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )

        if (followedBy.isNotEmpty()) {
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    append("Followed by ")
                    pushStyle(boldStyle)
                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if (index < followedBy.size - 1) {
                            append(", ")
                        }
                    }
                    if (otherCount > 2) {
                        append(" and ")
                        pushStyle(boldStyle)
                        append("$otherCount others")
                    }
                },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        }
    }

}

@Composable
fun ButtonSection(
    modifier: Modifier = Modifier
) {
    val minWidth = 95.dp
    val height = 30.dp
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ) {
        ActionButton(
            text = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height = height)
        )
        ActionButton(
            text = "Message",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height = height)
        )
        ActionButton(
            text = "Email",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height = height)
        )
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height = height)
        )
    }

}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    icon: ImageVector? = null
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
    ) {
        if (text != null) {
            Text(
                text = text,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        }
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Black
            )
        }
    }
}

@Composable
fun HighlightSection(
    modifier: Modifier = Modifier,
    highlights: List<ImageWithText>
) {
    LazyRow(modifier = modifier) {
        items(highlights.size) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(end = 15.dp)
            ) {
                RoundImage(
                    image = highlights[it].image,
                    modifier = Modifier.size(70.dp)
                )
                Text(
                    text = highlights[it].text, overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )
            }
        }
    }

}

@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    imageWithText: List<ImageWithText>,
    onTabSelected: (selectedIndex: Int) -> Int
) {

    var selectedTabIndex by remember {
        mutableStateOf(0)
    }

    val inActiveColor = Color(0xFF777777)
    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier
    ) {
        imageWithText.forEachIndexed { index, item ->
            Tab(selected = selectedTabIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inActiveColor,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }) {
                Icon(
                    painter = item.image, contentDescription = item.text,
                    tint = if (selectedTabIndex == index) Color.Black else inActiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun PostSection(
    posts: List<Painter>,
    modifier: Modifier = Modifier

) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        modifier = modifier.scale(1.01f)
    ) {
        items(posts.size) {
            Image(
                painter = posts[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(width = 1.dp, color = Color.White)
            )
        }

    }

}
