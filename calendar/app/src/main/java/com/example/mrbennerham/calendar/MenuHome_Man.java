package com.example.mrbennerham.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class MenuHome_Man extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_home);
        final ImageButton btn1 = (ImageButton) findViewById(R.id.imageButton);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), CalendarShowEvent.class);
                startActivity(intent1);
            }
        });

        final ImageButton btn2 = (ImageButton) findViewById(R.id.imageButton2);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), Notifications.class);
                startActivity(intent2);

            }
        });

        final ImageButton btn3 = (ImageButton) findViewById(R.id.imageButton3);
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent2);

            }
        });

        final ImageButton btn4 = (ImageButton) findViewById(R.id.imageButton4);
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_INSERT)
                        .setType("vnd.android.cursor.item/event")
                        //.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis())
                        //.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis())
                        .putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY , false) // just included for completeness
                        .putExtra(CalendarContract.Events.TITLE, "นัดคุณหมอ")
                        //.putExtra(CalendarContract.Events.DESCRIPTION, "Heading out with friends to do something awesome.")
                        //.putExtra(CalendarContract.Events.EVENT_LOCATION, "Earth")
                        //.putExtra(CalendarContract.Events.RRULE, "FREQ=DAILY;COUNT=10")
                        //.putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY)
                        //.putExtra(CalendarContract.Events.ACCESS_LEVEL, CalendarContract.Events.ACCESS_PRIVATE)
                        .putExtra(Intent.EXTRA_EMAIL, "pawarisaclinic58@gmail.com");
                startActivityForResult(Intent.createChooser(intent
                        , "กรุณาเลือก Google Calendar ซึ่งจะใช้งานได้ดีกับคุณ"), 0);

            }
        });


        /*final Button btn1 = (Button) findViewById(R.id.button3);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType("vnd.android.cursor.item/event");
                startActivity(intent);

            }


        });*/
    }

    public void onBackPressed() {

        Intent intent1 = new Intent(getApplicationContext(), Main_MainActivity.class);
        startActivity(intent1);
        finish();


    }
}
