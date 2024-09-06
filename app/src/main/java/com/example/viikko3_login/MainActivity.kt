package com.example.viikko3_login

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.viikko3_login.ui.theme.Viikko3loginTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Viikko3loginTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Login()
                }
            }
        }
    }
}

@Composable
fun Login() {
    var nameInput by remember { mutableStateOf("")  }
    var passVisible by remember {  mutableStateOf((false)) }
    var passInput by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Login",
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)
        )
        OutlinedTextField(
            value = nameInput,
            onValueChange = { nameInput = it },
            label = { Text(text = "Username") },
            singleLine = true,
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_alternate_email_24),
                    contentDescription = "Email Icon"
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = passInput,
            onValueChange = { passInput = it },
            label = { Text(text = "Password") },
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_lock),
                    contentDescription = "Email Icon"
                )
            },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
            ),
            modifier = Modifier.fillMaxWidth()
        )
        Button(onClick = { passVisible = !passVisible }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Login")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Viikko3loginTheme {
        Login()
    }
}
