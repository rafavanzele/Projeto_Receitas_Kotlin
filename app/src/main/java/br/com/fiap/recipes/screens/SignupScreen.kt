package br.com.fiap.recipes.screens

import android.content.res.Configuration
import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddAPhoto
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.recipes.R
import br.com.fiap.recipes.model.User
import br.com.fiap.recipes.navigation.Destination
import br.com.fiap.recipes.repository.SharedPreferencesUserRepository
import br.com.fiap.recipes.ui.theme.RecipesTheme

// *** Tela SignupScreen ***
@Composable
fun SignupScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ){
        TopEndCard(modifier = Modifier.align(Alignment.TopEnd))
        BottomStartCard(modifier = Modifier.align(Alignment.BottomStart))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TitleComponent()
            Spacer(modifier = Modifier.height(48.dp))
            UserImage()
            SignupUserForm(navController)
        }

    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    locale = "en"
)
@Composable
private fun SignupScreenPreview() {
    RecipesTheme {
        SignupScreen(rememberNavController())
    }
}

// *** Componente 1 - Título da tela ***
@Composable
fun TitleComponent() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.sign_up),
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = stringResource(R.string.criar_conta),
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleSmall
        )
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    locale = "en"
)
@Composable
private fun TitleComponentPreview() {
    RecipesTheme {
        TitleComponent()
    }

}

// TRECHO DE CÓDIGO FONTE OMITIDO...
// *** Componente 2 - Imagem do usuário
@Composable
fun UserImage() {
    Box(
        modifier = Modifier
            .size(120.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.man_profile),
            contentDescription = "",
            modifier = Modifier
                .size(110.dp)
                .align(Alignment.Center)
        )
        Icon(
            imageVector = Icons.Default.AddAPhoto,
            tint = MaterialTheme.colorScheme.primary,
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.BottomEnd)
        )
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    locale = "en"
)
@Composable
private fun UserImagePreview() {
    RecipesTheme {
        UserImage()
    }
}

// TRECHO DE CÓDIGO FONTE OMITIDO...
// *** Componente 3 - Formulário do Usuário
@Composable
fun SignupUserForm(navController: NavController) {

    //variaveis de estado para controlar os valores exibidos nos outlinedtextfields
    var name by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    //variaveis de estado para verificar se os dados fornecidos estão corretos
    var isNameError by remember { mutableStateOf(false) }
    var isEmailError by remember { mutableStateOf(false) }
    var isPasswordError by remember { mutableStateOf(false) }

    //variavel de estado para controlar a exibição da caixa de dialogo em caso de error
    var showDialogueError by remember { mutableStateOf(false) }
    var showDialogueSuccess by remember { mutableStateOf(false) }

    //função para verificar se os dados fornecidos estão corretos
    fun  validate(): Boolean{
        isNameError = name.length < 3
        isEmailError = email.length < 3 || !Patterns.EMAIL_ADDRESS.matcher(email).matches()
        isPasswordError = password.length < 3
        return !isNameError && !isEmailError && !isPasswordError
    }

    //criar uma instancia do sharedpreferenceuserrepository
    val userRepository = SharedPreferencesUserRepository(LocalContext.current)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)
    ) {
        // Caixa de texto your name
        OutlinedTextField(
            value = name,
            onValueChange = {name = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp),
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults
                .colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.primary
                ),
            label = {
                Text(
                    text = stringResource(R.string.digite_o_seu_nome),
                    style = MaterialTheme.typography.labelSmall
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.tertiary
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next
            ),

            isError = isNameError,
            trailingIcon = {
                if (isNameError){
                    Icon(
                        imageVector = Icons.Default.Error,
                        contentDescription = "Error",
                        tint = MaterialTheme.colorScheme.error
                    )
                }
            },

            supportingText = {
                if (isNameError) {
                    Text(
                        text = "O nome dever ter pelo menos 3 caracteres",
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.End
                    )
                }
            }
        )
        // Caixa de texto your e-mail
        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp),
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults
                .colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.primary
                ),
            label = {
                Text(
                    text = stringResource(R.string.e_mail),
                    style = MaterialTheme.typography.labelSmall
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.tertiary
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),

            isError = isEmailError,
            trailingIcon = {
                if (isEmailError){
                    Icon(
                        imageVector = Icons.Default.Error,
                        contentDescription = "Error",
                        tint = MaterialTheme.colorScheme.error
                    )
                }
            },

            supportingText = {
                if (isEmailError) {
                    Text(
                        text = "O email dever ter pelo menos 3 caracteres",
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.End
                    )
                }
            }
        )
        // Caixa de texto your password
        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults
                .colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.primary
                ),
            label = {
                Text(
                    text = stringResource(R.string.senha),
                    style = MaterialTheme.typography.labelSmall
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.tertiary
                )
            },
            /*trailingIcon = {
                Icon(
                    imageVector = Icons.Default.RemoveRedEye,
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.tertiary
                )
            },*/
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword,
                imeAction = ImeAction.Done
            ),

            isError = isPasswordError,
            trailingIcon = {
                if (isPasswordError){
                    Icon(
                        imageVector = Icons.Default.Error,
                        contentDescription = "Error",
                        tint = MaterialTheme.colorScheme.error
                    )
                }
            },

            supportingText = {
                if (isPasswordError) {
                    Text(
                        text = "A senha dever ter pelo menos 3 caracteres",
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.End
                    )
                }
            }
        )
        // Botão Create account
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = {
                if (validate()){
                    userRepository.saveUser(
                        User(name = name, password = password, email = email)
                    )
                    showDialogueSuccess = true
                } else {
                    showDialogueError = true
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = stringResource(R.string.criar_conta),
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
    //caixa de dialogo de sucesso
    if (showDialogueSuccess) {
        AlertDialog(
            onDismissRequest = {showDialogueError = false},
            title = { Text(text = "Sucesso!")},
            text = {Text(text = "Conta criada com sucesso!")},
            confirmButton = {
                TextButton(
                    onClick = {
                        navController.navigate(Destination.LoginScreen.route)
                    }
                ) { }
            }

        )
    }


    //caixa de dialogo de erro
    if(showDialogueError){
        AlertDialog(
            onDismissRequest = {showDialogueError = false},
            title = {Text(text = "Error")},
            text = {Text(text = "Por favor preencha todos os campos corretamente")},
            confirmButton = {
                TextButton(
                    onClick = {showDialogueError = false}
                ){
                    Text(text = "OK")
                }
            }
        )
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    locale = "en"
)
@Composable
private fun SignupUserFormPreview() {
    RecipesTheme {
        SignupUserForm(rememberNavController())
    }
}