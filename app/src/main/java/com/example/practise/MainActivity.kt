package com.example.practise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.practise.ui.theme.PractiseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PractiseTheme {
                Portfolio()
              //  StateManagement()
            }
        }
    }
}

fun getProject(): List<Project> {
    return listOf(
        Project("riyal", "there's no god but Allah"),
        Project("riyan", "And Prophet Muhammad is the messenger."),
        Project("riyal", "i am nothing"),
        Project("riyal", "i am nothing"),
        Project("riyal", "i am nothing"),
        Project("riyal", "i am nothing"),
        Project("riyal", "i am nothing"),
        Project("riyal", "i am nothing"),
        Project("riyal", "i am nothing")
    )
}

data class Project(
    val name: String, val desc: String,
)

//font here
val fontFamily = FontFamily(
    Font(
        R.font.f, weight = FontWeight.Bold
    )
)

//main thing
@Composable
fun Portfolio() {
    //lazy coloums toggle system
    val isOpen = remember {
        mutableStateOf(false)
    }


    Surface(
        tonalElevation = (8.dp),
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.surface,
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.contact),
                contentDescription = null,
                modifier = Modifier.size(60.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Divider()
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "hello riyal the 1",
                style = TextStyle(
                    color = Color.Magenta,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.headlineLarge.fontSize
                )
            )
            Text(
                text = "android developer beginner",
                style = TextStyle(
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize
                ),
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Row {
                Image(
                    painter = painterResource(id = R.drawable.fb),
                    contentDescription = "facebook",
                    modifier = Modifier.size(20.dp)
                )
                Text(text = "/factoid", modifier = Modifier.padding(start = 10.dp))
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row {
                Image(
                    painter = painterResource(id = R.drawable.yt),
                    contentDescription = "Youtube",
                    modifier = Modifier.size(20.dp)
                )
                Text(text = "/factoid", modifier = Modifier.padding(start = 10.dp))
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { isOpen.value = !isOpen.value }, shape = RectangleShape) {
                Text(text = "my projects")
            }
            if (isOpen.value){
            LazyColumn {
                items(getProject()) {
                    ProjectItem(it)}
                }
            }
        }

    }

}


@Composable
fun ProjectItem(project: Project) {
    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.contact),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .clip(shape = CircleShape)
        )
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = project.name, style = MaterialTheme.typography.headlineMedium)
            Text(text = project.desc, style = MaterialTheme.typography.bodyMedium)
        }
    }
}