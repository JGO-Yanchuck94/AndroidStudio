package com.example.mojaapka;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextFirstName;
    private EditText editTextSurname;
    private EditText editTextEmail;
    private EditText editTextPhone;
    private EditText editTextPassword;
    private EditText editTextPasswordConfirm;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// Powiązanie widoków z kodem
        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextSurname = findViewById(R.id.editTextSurname);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextPasswordConfirm = findViewById(R.id.editTextPasswordConfirm);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// Pobranie wprowadzonych danych
                String firstname = editTextFirstName.getText().toString().trim();
                String surname = editTextSurname.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String phone = editTextPhone.getText().toString().trim();
                phone = phone.replace(" ", "");
                String password = editTextPassword.getText().toString().trim();
                String passwordconfirm = editTextPasswordConfirm.getText().toString().trim();
// Walidacja danych
                if (firstname.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić imię.", Toast.LENGTH_SHORT).show();
                } else if (surname.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić adres e-mail.", Toast.LENGTH_SHORT).show();
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(MainActivity.this, "Niepoprawny adres e- mail.", Toast.LENGTH_SHORT).show();
                } else if (phone.length() < 9) {
                    Toast.makeText(MainActivity.this, "Numer telefonu musi mieć co najmniej 9 cyfr.", Toast.LENGTH_SHORT).show();
                } else if (password.length() < 6) {
                    Toast.makeText(MainActivity.this, "Hasło musi zawierać co najmniej 6 znaków.", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(passwordconfirm)) {
                    Toast.makeText(MainActivity.this, "Hasła nie są identyczne.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Formularz przesłany poprawnie.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}