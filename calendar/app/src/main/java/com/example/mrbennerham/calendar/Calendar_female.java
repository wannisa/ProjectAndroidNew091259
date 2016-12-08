package com.example.mrbennerham.calendar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class Calendar_female extends AppCompatActivity implements View.OnClickListener {

    private String id;
    private EditText startdate;
    private EditText enddate;
    private DatePickerDialog fromDatePickerDialog;
    private SimpleDateFormat dateFormatter;
    private DatePickerDialog fromDatePickerDialogEnd;
    private SimpleDateFormat dateFormatterEnd;

    @Override
    protected void onCreate(Bundle savedInstanceStatusCode) {
        super.onCreate(savedInstanceStatusCode);
        setContentView(R.layout.calendar_female);
        final Button btn0 = (Button) findViewById(R.id.button3);
        btn0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent1);

            }
        });
        final Button btn1 = (Button) findViewById(R.id.button4);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), CalendarShowEvent.class);
                startActivity(intent1);

            }
        });
        final ImageView btn2 = (ImageView) findViewById(R.id.calendaricon);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), Calendar_female.class);
                startActivity(intent1);

            }
        });
        final ImageView btn3 = (ImageView) findViewById(R.id.drugicon);
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), Notifications.class);
                startActivity(intent1);

            }
        });
        final ImageView btn4 = (ImageView) findViewById(R.id.faqicon);
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent1);

            }
        });
        final ImageView btn5 = (ImageView) findViewById(R.id.doctoricon);
        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_INSERT)
                        .setType("vnd.android.cursor.item/event")
                        .putExtra(CalendarContract.Events.TITLE, "นัดคุณหมอ")
                        .putExtra(Intent.EXTRA_EMAIL, "pawarisaclinic58@gmail.com");
                startActivityForResult(Intent.createChooser(intent
                        , "กรุณาเลือก Google Calendar ซึ่งจะใช้งานได้ดีกับคุณ"), 0);

            }
        });

        dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        setAddStartdate();
        setDateTimeField();

        dateFormatterEnd = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        setAddEndtime();
        setDateTimeFieldEnd();
    }

    private void setAddStartdate() {//ให้เซ็ตข้อมมูลเข้าให้เป็นวันที่
        startdate = (EditText) findViewById(R.id.editText);
        startdate.setInputType(InputType.TYPE_NULL);
    }

    private void setAddEndtime() {//ให้เซ็ตข้อมมูลเข้าให้เป็นวันที่
        enddate = (EditText) findViewById(R.id.editText2);
        enddate.setInputType(InputType.TYPE_NULL);
    }

    private void setDateTimeField() {//เรียกปฎิทิน
        startdate.setOnClickListener(this);
        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                startdate.setText(dateFormatter.format(newDate.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }
    private void setDateTimeFieldEnd() {//เรียกปฎิทิน
        enddate.setOnClickListener(this);
        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialogEnd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                enddate.setText(dateFormatterEnd.format(newDate.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return true;
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Intent intent1 = new Intent(getApplicationContext(), Menu_Home.class);
        startActivity(intent1);
        finish();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.menu_add, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        if (v == startdate) {
            fromDatePickerDialog.show();
        }
        else if(v == enddate){
            fromDatePickerDialogEnd.show();
        }
    }
    public void onSave(View view) {

        String textdate = startdate.getText().toString();
        if(textdate.equals("")) {
            Toast.makeText(this, "กรุณาตั้งวันที่สเริ่มต้นประจำเดือน", Toast.LENGTH_SHORT).show();
            return;
        }
        String  textdate2= enddate.getText().toString();
        if(textdate2.equals("")) {
            Toast.makeText(this, "กรุณาตั้งเวันที่สิ้นสุดประจำเดือน", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent t = new Intent(Calendar_female.this, Calendar_female.class);
        if (id != null) {
            t.putExtra("id", id);
        }

        t.putExtra("textdate", textdate);
        t.putExtra("textdate2", textdate2);
        Toast.makeText(this, "เริ่มต้น"+textdate +"สิ้นสุด "+ textdate2 , Toast.LENGTH_LONG).show();

        startActivity(t);

        finish();
    }


}

