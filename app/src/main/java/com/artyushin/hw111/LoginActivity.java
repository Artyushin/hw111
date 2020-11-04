package com.artyushin.hw111;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final TextView textInfo = findViewById(R.id.textViewInfo);
        final EditText name = findViewById(R.id.editTextName);
        final EditText email = findViewById(R.id.editTextEmail);

        Button buttonOK = findViewById(R.id.buttonOK);
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textInfo.setText("Подписка на рассылку успешно оформлена для пользователя "
                        + name.getText() + " на электронный адрес " + email.getText());
            }
        });

        Button buttonClear = findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textInfo.setText("");
                name.setText("");
                email.setText("");
            }
        });
    }
}