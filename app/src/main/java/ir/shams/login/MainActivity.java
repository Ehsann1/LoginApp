package ir.shams.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {
    String USERNAME = "Ehsan";
    String PASSWORD = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etUsername = findViewById(R.id.etUsername);
        EditText etPassword = findViewById(R.id.etPassword);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "تمامی فیلد ها الزامیست", Toast.LENGTH_SHORT).show();
                } else if (username.equals(USERNAME) && password.equals(PASSWORD)) {
                    Toast.makeText(MainActivity.this, "با موفقیت وارد شدید :)", Toast.LENGTH_SHORT).show();

                    // Start the new activity
                    Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                    startActivity(intent);
                } else {
                    if (username.equals(USERNAME)) {
                        Toast.makeText(MainActivity.this, "رمزعبور اشتباه است!", Toast.LENGTH_SHORT).show();
                    }else if (password.equals(PASSWORD)){
                        Toast.makeText(MainActivity.this, "نام کاربری اشتباه است!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "نام کاربری و رمزعبور اشتباه است!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}