package com.parg3v.tz_effective.view.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.parg3v.tz_effective.R
import com.parg3v.tz_effective.components.CustomOutlinedTextField
import com.parg3v.tz_effective.components.PhoneNumberTextField
import com.parg3v.tz_effective.navigation.Screen
import com.parg3v.tz_effective.ui.theme.Grey
import com.parg3v.tz_effective.ui.theme.Typography

@Composable
fun LoginScreen(viewModel: LoginViewModel = hiltViewModel(), navController: NavController) {

    val name by viewModel.nameState.collectAsStateWithLifecycle()
    val surname by viewModel.surnameState.collectAsStateWithLifecycle()
    val phone by viewModel.phoneState.collectAsStateWithLifecycle()
    val validName by viewModel.validNameState.collectAsStateWithLifecycle()
    val validSurname by viewModel.validSurnameState.collectAsStateWithLifecycle()
    val validPhone by viewModel.validPhoneState.collectAsStateWithLifecycle()

    LoginScreenUI(
        controller = navController,
        nameProvider = { name },
        validName = validName,
        nameInputChange = viewModel::validateName,
        surnameProvider = { surname },
        validSurname = validSurname,
        surnameInputChange = viewModel::validateSurname,
        phoneProvider = { phone },
        validPhone = validPhone,
        phoneInputChange = viewModel::validatePhone
    )
}

@Composable
fun LoginScreenUI(
    controller: NavController,
    nameProvider: () -> String,
    nameInputChange: (String) -> Unit,
    validName: Boolean,
    surnameProvider: () -> String,
    surnameInputChange: (String) -> Unit,
    validSurname: Boolean,
    phoneProvider: () -> String,
    phoneInputChange: (String) -> Unit,
    validPhone: Boolean
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(top = dimensionResource(id = R.dimen.padding_login_top))
        )
        {
            CustomOutlinedTextField(
                value = nameProvider,
                onValueChange = nameInputChange,
                isError = if (nameProvider().isNotBlank()) !validName else false,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = dimensionResource(id = R.dimen.padding_login)),
                placeholder = { Text(text = stringResource(R.string.name)) }
            )

            CustomOutlinedTextField(
                value = surnameProvider,
                onValueChange = surnameInputChange,
                isError = if (surnameProvider().isNotBlank()) !validSurname else false,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = dimensionResource(id = R.dimen.padding_login)),
                placeholder = { Text(text = stringResource(R.string.surname)) }
            )

            PhoneNumberTextField(
                valueProvider = phoneProvider,
                onValueChange = phoneInputChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = dimensionResource(id = R.dimen.padding_login))
            )

            Button(
                onClick = { controller.navigate(Screen.HomeScreen.route) },
                enabled = listOf(validName, validSurname, validPhone).all { it },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    disabledContainerColor = MaterialTheme.colorScheme.secondary),
                shape = RoundedCornerShape(integerResource(id = R.integer.ui_round_percentage))
            ) {
                Text(text = stringResource(R.string.login), color = Color.White)
            }
        }

        Text(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(bottom = dimensionResource(id = R.dimen.login_message_padidng)),
            text = stringResource(R.string.message),
            textAlign = TextAlign.Center,
            style = Typography.displaySmall.copy(color = Grey)
        )
    }
}
