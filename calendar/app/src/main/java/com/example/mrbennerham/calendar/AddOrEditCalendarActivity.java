package com.example.mrbennerham.calendar;

import android.app.Activity;
import android.app.DatePickerDialog;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by MR.BENNERHAM on 10/30/2016.
 */
public class AddOrEditCalendarActivity extends Activity implements View.OnClickListener{
    private String id;

    Button  btn_time;
    private int  mHour, mMinute;
    EditText in_date, in_time;

    private Calendar cal;
    private int day;
    private int month;
    private int year;

    private int hour;
    private int min;
    private DatePickerDialog fromDatePickerDialog;
    private TimePicker.OnTimeChangedListener fromTimePickerDialog;
    private SimpleDateFormat dateFormatter;
    private SimpleDateFormat timeFormatter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcalendar);

        dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        timeFormatter = new SimpleDateFormat("H:mm", Locale.US);


        datefindViewsById();
        timefindViewsById();
        setDateTimeField();


        btn_time = (Button) findViewById(R.id.btn_time);
        cal = Calendar.getInstance();
        hour = cal.get(Calendar.HOUR_OF_DAY);
        min = cal.get(Calendar.MINUTE);
        in_time = (EditText) findViewById(R.id.in_time);
        btn_time.setOnClickListener(this);

        id = getIntent().getStringExtra("id");
        if (id != null) {

            in_date.setText(getIntent().getStringExtra("date"));
            in_time.setText(getIntent().getStringExtra("timer"));
        } else {

        }
    }

    public void onSave(View view) {

        String textdate = in_date.getText().toString();
        if(textdate.equals("")) {
            Toast.makeText(this, "กรุณาตั้งวันที่เริ่มต้นการวิ่ง", Toast.LENGTH_SHORT).show();
            return;
        }
            String texttimer = in_time.getText().toString();
            if(texttimer.equals("")) {
                Toast.makeText(this, "กรุณาตั้งเวลาเริ่มต้นการวิ่ง", Toast.LENGTH_SHORT).show();
                return;
            }
                Intent t = new Intent(AddOrEditCalendarActivity.this, MainActivity.class);
                if (id != null) {
                    t.putExtra("id", id);
                }

                t.putExtra("textdate", textdate);
                t.putExtra("texttimer", texttimer);
                Toast.makeText(this, "คุณได้เริ่มต้นฝึกวิ่ง วันที่"+textdate +"เวลา "+ texttimer , Toast.LENGTH_LONG).show();

                startActivity(t);

        finish();
    }


    public void onCancel(View view) {

        Intent intent = new Intent(AddOrEditCalendarActivity.this,MainActivity.class);
        startActivity(intent);
    }

    private void datefindViewsById() {
        in_date = (EditText) findViewById(R.id.in_date);
        in_date.setInputType(InputType.TYPE_NULL);
        in_date.requestFocus();
    }

    private void setDateTimeField() {
        in_date.setOnClickListener(this);
        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                in_date.setText(dateFormatter.format(newDate.getTime()));
            }
        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

    private void timefindViewsById() {

        in_time = (EditText) findViewById(R.id.in_time);
        in_time.setInputType(InputType.TYPE_NULL);
        in_time.requestFocus();
    }







            @Override
    public void onClick(View v) {
        if(v == in_date) {
            fromDatePickerDialog.show();
        } else if (v == btn_time) {
// Get Current Time
                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {
                                if(hourOfDay <10 && minute <10 ){
                                    in_time.setText("0" + hourOfDay + ":" + "0" + minute);
                                }
                                else if(hourOfDay >10 && minute <10) {
                                in_time.setText( hourOfDay + ":" + "0" + minute);
                                }
                                else if(hourOfDay <10 && minute >10) {
                                    in_time.setText("0" + hourOfDay + ":" + minute);
                            }
                                else {
                                    in_time.setText(hourOfDay +":" + minute);
                                }
                            }
                        }, mHour, mMinute, false);
                timePickerDialog.show();
            }

// Get Current Time

        }
    }

