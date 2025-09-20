package com.yamidev.actividad5;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

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

        // Configurar los elementos de la interfaz de usuario
        spinnerCategory = findViewById(R.id.spinnerCategory);
        tvDate = findViewById(R.id.tvDate);
        tvTime = findViewById(R.id.tvTime);
        ibPickDate = findViewById(R.id.ibPickDate);
        ibPickTime = findViewById(R.id.ibPickTime);
        ibAdd = findViewById(R.id.ibAdd);
        ibClear = findViewById(R.id.ibClear);
        etDescription = findViewById(R.id.etDescription);
        lvItems = findViewById(R.id.lvItems);

        // Configurar el adaptador para el Spinner
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(
                this, R.array.categorias, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(spinnerAdapter);

        // Configurar el adaptador para el ListView
        listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        lvItems.setAdapter(listAdapter);

        // Configurar los listeners para los botones

        ibPickDate.setOnClickListener(v -> updateDateButton());
        ibPickTime.setOnClickListener(v -> updateTimeButton());
        ibAdd.setOnClickListener(v -> addTask());
        calendar = Calendar.getInstance();
        updateDate();

    }

    private void updateDate() {
        tvDate.setText(new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(calendar.getTime()));
        tvTime.setText(new SimpleDateFormat("HH:mm", Locale.getDefault()).format(calendar.getTime()));
    }

    private void updateTimeButton(){
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener(){
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                @SuppressLint("DefaultLocale") String timeSelected = String.format("%02d:%02d", hourOfDay, minute);
                tvTime.setText(timeSelected);
            }
        }, hour, minute, true);
        timePickerDialog.show();
    }

    private void updateDateButton(){
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener(){
            @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        @SuppressLint("DefaultLocale") String dateSelected = String.format( "%04d-%02d-%02d", year, month + 1, dayOfMonth);
                        tvDate.setText(dateSelected);
                    }
        }, year, month, day);
        datePickerDialog.show();
    }

    private void addTask() {
        String category = spinnerCategory.getSelectedItem().toString();
        String date = tvDate.getText().toString();
        String time = tvTime.getText().toString();
        String description = etDescription.getText().toString();

        if (!category.isEmpty() && !date.isEmpty() && !time.isEmpty() && !description.isEmpty()) {
            String task = category.toUpperCase() + "\n \t\t" + date + "\n \t\t" + time + "\n \t\t" + description;
            items.add(task);
            listAdapter.notifyDataSetChanged();
            etDescription.setText("");
            spinnerCategory.setSelection(0);
            updateDate();
        }else{
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
        }
    }










}