package com.example.mrbennerham.calendar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class Notifications extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifications);

        final Button btn1 = (Button) findViewById(R.id.addEventButton);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_INSERT)
                        .setType("vnd.android.cursor.item/event")
                        //.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis())
                        //.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis())
//                .putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY , false) // just included for completeness
                        .putExtra(CalendarContract.Events.TITLE, "ทานยา");
//                .putExtra(Events.DESCRIPTION, "Heading out with friends to do something awesome.")
//                .putExtra(Events.EVENT_LOCATION, "Earth")
//                .putExtra(Events.RRULE, "FREQ=DAILY;COUNT=10")
//                .putExtra(Events.AVAILABILITY, Events.AVAILABILITY_BUSY)
//                .putExtra(Events.ACCESS_LEVEL, Events.ACCESS_PRIVATE)
//                .putExtra(Intent.EXTRA_EMAIL, "aoy.wannisa1994@example.com");
                startActivity(intent);
            }
        });
        final Button btn2 = (Button) findViewById(R.id.drugcalendar);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(Notifications.this);
                alertDialog.setMessage("ผู้ใช้สามารถดูปฎิทิน แก้ไข และลบ event ได้");
                //alertDialog.setIcon(R.drawable.bgblood);

                alertDialog.setPositiveButton("ตกลง",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                String packageName = "com.google.android.calendar";
                                startApp(packageName);

                            }
                        });
                alertDialog.setNegativeButton("ยกเลิก",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent1 = new Intent(getApplicationContext(), Notifications.class);
                                startActivity(intent1);
                            }
                        });
                alertDialog.show();

            }
        });
        final ImageView btn3 = (ImageView) findViewById(R.id.calendaricon);
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), Calendar_female.class);
                startActivity(intent1);

            }
        });
        final ImageView btn4 = (ImageView) findViewById(R.id.drugicon);
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), Notifications.class);
                startActivity(intent1);

            }
        });
        final ImageView btn5 = (ImageView) findViewById(R.id.faqicon);
        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent1);

            }
        });
        final ImageView btn6 = (ImageView) findViewById(R.id.doctoricon);
        btn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_INSERT)
                        .setType("vnd.android.cursor.item/event")
                        .putExtra(CalendarContract.Events.TITLE, "นัดคุณหมอ")
                        .putExtra(Intent.EXTRA_EMAIL, "pawarisaclinic58@gmail.com");
                startActivityForResult(Intent.createChooser(intent
                        , "กรุณาเลือก Google Calendar ซึ่งจะใช้งานได้ดีกับคุณ"), 0);

            }
        });
        // startActivityForResult(Intent.createChooser(intent
        // , "Select photo from"), 0);
        //Uri uri = Uri.parse("content://com.android.calendar/events");
        //Intent calIntent = new Intent("android.intent.action.INSERT", uri)
        //         .setAction(Intent.ACTION_INSERT);
//       startActivity(calIntent);


      /*Calendar beginTime = Calendar.getInstance();
     beginTime.set(2012, 0, 19, 7, 30);
     Calendar endTime = Calendar.getInstance();
     endTime.set(2012, 0, 19, 8, 30);
     Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(Events.CONTENT_URI)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis())
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis())
                .putExtra(Events.TITLE, "Yoga")
                .putExtra(Events.DESCRIPTION, "Group class")
                .putExtra(Events.EVENT_LOCATION, "The gym")
                .putExtra(Events.AVAILABILITY, Events.AVAILABILITY_BUSY)
                .putExtra(Intent.EXTRA_EMAIL, "rowan@example.com,trevor@example.com");
        startActivity(intent);*/


    }
    public void startApp(String packageName) {
        try {
            Intent intent = getPackageManager().getLaunchIntentForPackage(packageName);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            startActivity(intent);
        } catch (NullPointerException e) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=" + packageName));
            startActivity(intent);
        }
    }
    public void onBackPressed() {
//        super.onBackPressed();
        Intent intent1 = new Intent(getApplicationContext(), Menu_Home.class);
        startActivity(intent1);
        finish();
    }
}


