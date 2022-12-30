package com.example.myapplication;
import android.app.DatePickerDialog;
import android.os.Build;
import java.time.temporal.*;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Calendar;
import java.time.*;

public class MainActivity extends AppCompatActivity {

    DatePickerDialog picker;
    EditText eText1;
    EditText eText2;
    Button btnGet;
    TextView tvw;
    LocalDate ld1;
    LocalDate ld2;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvw=(TextView)findViewById(R.id.textView1);
        eText1=(EditText) findViewById(R.id.editText1);
        eText1.setInputType(InputType.TYPE_NULL);
        eText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                    ld1=LocalDate.of(year,monthOfYear + 1,dayOfMonth);
                                }
                                eText1.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            }
                        }, year, month, day);
                picker.show();

            }
        });
        eText2=(EditText) findViewById(R.id.editText2);
        eText2.setInputType(InputType.TYPE_NULL);
        eText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                    ld2=LocalDate.of(year,monthOfYear+1,dayOfMonth);
                                }
                                eText2.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            }
                        }, year, month, day);
                picker.show();

            }
        });


        btnGet=(Button)findViewById(R.id.button1);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    tvw.setTextSize(TypedValue.COMPLEX_UNIT_SP, (80 / getResources().getDisplayMetrics().density));
                    long day= ChronoUnit.DAYS.between(ld1,ld2);
                    tvw.setText("Age:" + Long.toString(day / 365) + "\nNo of Days:" + Long.toString(day*1) + "\nNo of Hours:" + Long.toString(day * 24) + "\nNo of Munites:" + Long.toString(day * 24 * 60) + "\nNo of Second:" + Long.toString(day * 24 * 60));
                }
                catch (Exception e)
                {
                }
            }
        });
    }
}