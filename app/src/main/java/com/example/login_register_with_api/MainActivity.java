package com.example.login_register_with_api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    TextView tvResultNama;
    String resultNama;
    Button btnLogout;
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();

        sharedPrefManager = new SharedPrefManager(this);

        // untuk mendapatkan data dari activity sebelumnya, yaitu activity login.
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            resultNama = extras.getString("result_nama");
            tvResultNama.setText(resultNama);
        }
    }

    private void initComponents(){
        tvResultNama = findViewById(R.id.tvResultNama);
        btnLogout = findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, false);
                startActivity(new Intent(MainActivity.this, LoginActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                finish();
            }
        });
    }
}