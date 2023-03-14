package com.sdcode.forms

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sdcode.forms.ui.theme.FormsTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val str = remember {
                mutableStateOf("")
            }
            val scope = rememberCoroutineScope()
            val scaffoldState = rememberScaffoldState()
            Scaffold(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Red),
                scaffoldState = scaffoldState
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(it)
                ) {
                    TextField(
                        value = str.value,
                        onValueChange = { str.value = it },
                        placeholder = { Text(text = "Enter Your Name") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(onClick = {
                        scope.launch {
                            scaffoldState.snackbarHostState.showSnackbar("Hello ${str.value}")
                        }
                    }) {
                        Text(text = "pls Greet me!")
                    }

//                    Column(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .verticalScroll(verticalScrollState)
//                            .background(Color.Cyan)
//                    ) {
//                        for (i in 1..100) {
//                            Text(
//                                text = "step $i",
//                                fontSize = 24.sp,
//                                modifier = Modifier.fillMaxWidth(),
//                                textAlign = TextAlign.Center
//                            )
//                        }
//                    }
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.5f)
                            .background(Color.Cyan),
                    ) {
                        items(5000) {
                            Text(
                                text = "step $it",
                                fontSize = 24.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                        }
                    }

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .background(Color.Yellow),
                    ) {
                        itemsIndexed(
                            listOf(
                                "my",
                                "name",
                                "is",
                                "samir",
                                "and",
                                "my",
                                "name",
                                "is",
                                "samir",
                                "and",
                                "my",
                                "name",
                                "is",
                                "samir"
                            )
                        ) { index, item ->
                            Text(
                                text = item,
                                fontSize = 24.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                        }
                    }

                }
            }
        }
    }
}
