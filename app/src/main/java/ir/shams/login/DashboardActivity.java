package ir.shams.login;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    private TableLayout tableUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Initialize database helper
        databaseHelper = new DatabaseHelper(this);

        // Get references to UI elements
        tableUsers = findViewById(R.id.tableUsers);
        Button btnOpenDigikala = findViewById(R.id.btnOpenDigikala);
        Button btnOpenGoogle = findViewById(R.id.btnOpenGoogle);
        Button btnCloseApp = findViewById(R.id.btnCloseApp);
        Button btnBackToLogin = findViewById(R.id.btnBackToLogin);

        // Populate user table
        populateUserTable();

        // Button listeners
        btnOpenDigikala.setOnClickListener(v -> openLink(this, "https://www.digikala.com"));
        btnOpenGoogle.setOnClickListener(v -> openLink(this, "https://www.google.com"));
        btnCloseApp.setOnClickListener(v -> closeApp());
        btnBackToLogin.setOnClickListener(v -> backToLogin());
    }

    private void populateUserTable() {
        // Add table headers
        addTableRow("ID", "Full Name", "Phone", "Username", true);

        // Fetch user data from the database
        Cursor cursor = databaseHelper.getAllUsers();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String id = cursor.getString(cursor.getColumnIndex("id"));
                @SuppressLint("Range") String fullName = cursor.getString(cursor.getColumnIndex("full_name"));
                @SuppressLint("Range") String phone = cursor.getString(cursor.getColumnIndex("phone_number"));
                @SuppressLint("Range") String username = cursor.getString(cursor.getColumnIndex("username"));

                addTableRow(id, fullName, phone, username, false);
            } while (cursor.moveToNext());

            cursor.close();
        } else {
            Toast.makeText(this, "No user data available.", Toast.LENGTH_SHORT).show();
        }
    }

    private void addTableRow(String id, String fullName, String phone, String username, boolean isHeader) {
        TableRow row = new TableRow(this);
        row.setGravity(Gravity.CENTER);

        // Add cells
        addCellToRow(row, id, isHeader);
        addCellToRow(row, fullName, isHeader);
        addCellToRow(row, phone, isHeader);
        addCellToRow(row, username, isHeader);

        tableUsers.addView(row);
    }

    private void addCellToRow(TableRow row, String text, boolean isHeader) {
        TextView cell = new TextView(this);
        cell.setText(text);
        cell.setGravity(Gravity.CENTER);
        cell.setPadding(8, 8, 8, 8);
        cell.setTextSize(isHeader ? 16 : 14);
        cell.setBackgroundResource(R.drawable.cell_border);

        // Use a simple text color fallback
        if (isHeader) {
            cell.setTextColor(getResources().getColor(android.R.color.black));
        } else {
            cell.setTextColor(getResources().getColor(android.R.color.darker_gray));
        }

        row.addView(cell);
    }

    @SuppressLint("QueryPermissionsNeeded")
    private void openLink(Context context, String url) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }

    private void closeApp() {
        finishAffinity(); // Close all activities
        System.exit(0); // Exit app
    }

    private void backToLogin() {
        Intent intent = new Intent(this, LoginActivity.class); // Adjust to your actual login activity
        startActivity(intent);
        finish();
    }
}
