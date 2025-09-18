package com.yamidev.actividad5;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerCategory;
    private TextView tvDate, tvTime;
    private ImageButton ibPickDate, ibPickTime, ibAdd, ibClear;
    private EditText etDescription;
    private ListView lvItems;

    // Lista para el ListView
    private final ArrayList<String> items = new ArrayList<>();
    private ArrayAdapter<String> listAdapter;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        spinnerCategory = findViewById(R.id.spinnerCategory);
        tvDate = findViewById(R.id.tvDate);
        tvTime = findViewById(R.id.tvTime);
        ibPickDate = findViewById(R.id.ibPickDate);
        ibPickTime = findViewById(R.id.ibPickTime);
        ibAdd = findViewById(R.id.ibAdd);
        ibClear = findViewById(R.id.ibClear);
        etDescription = findViewById(R.id.etDescription);
        lvItems = findViewById(R.id.lvItems);

        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(
                this, R.array.categorias, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(spinnerAdapter);

        listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        lvItems.setAdapter(listAdapter);

        calendar = Calendar.getInstance();
        updateDate();

    }

    private void updateDate() {
        tvDate.setText(new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(calendar.getTime()));
        tvTime.setText(new SimpleDateFormat("HH:mm", Locale.getDefault()).format(calendar.getTime()));
    }
}