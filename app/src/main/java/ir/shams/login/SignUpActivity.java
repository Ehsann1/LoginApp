package ir.shams.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    private EditText etFullName, etUsername, etPassword, etPhoneNumber;
    private Button btnSignUp;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Initialize database helper
        databaseHelper = new DatabaseHelper(this);

        // Initialize views
        etFullName = findViewById(R.id.et_full_name);
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        etPhoneNumber = findViewById(R.id.et_phone_number);
        btnSignUp = findViewById(R.id.btn_sign_up);

        // Set button click listener
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve user input
                String fullName = etFullName.getText().toString().trim();
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                String phoneNumber = etPhoneNumber.getText().toString().trim();

                // Validate input
                if (fullName.isEmpty() || username.isEmpty() || password.isEmpty() || phoneNumber.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "All fields required!", Toast.LENGTH_SHORT).show();
                    return;
                }
                String phonePattern = "^09\\d{9}$"; // Allows optional country code (e.g., +1) and 10 digits

                if (phoneNumber.matches(phonePattern)) {
                    // Save to database
                    boolean isInserted = databaseHelper.insertUser(fullName, phoneNumber, username, password);

                    if (isInserted) {
                        Toast.makeText(SignUpActivity.this, "Registration was successful!", Toast.LENGTH_SHORT).show();
                        finish(); // Close the activity (navigate back to the previous screen)
                    } else {
                        Toast.makeText(SignUpActivity.this, "This username exists!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Phone number is invalid
                    Toast.makeText(SignUpActivity.this, "Invalid phone number", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Button btnGoToSignUp = findViewById(R.id.btnBack);

        btnGoToSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
