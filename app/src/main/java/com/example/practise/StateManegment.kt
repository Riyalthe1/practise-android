package com.example.practise

import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun StateManagement() {
    var username = remember { mutableStateOf("") }

    TextField(
        value = username.value,
        onValueChange = { username.value = it }
    )
}
