package com.example.mrbennerham.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class SearchActivity extends AppCompatActivity {

    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ImageView button = (ImageView) findViewById(R.id.searchButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editText = (EditText) findViewById(R.id.searchTextbox);
                String _val = editText.getText().toString();
                System.out.println("_val: " + _val);

                Bundle bundle = new Bundle();
                bundle.putString("keyword", _val);
                v.getContext().startActivity(new Intent(v.getContext(), FeedArticleActivity.class).putExtras(bundle));
            }
        });
        Button button1 = (Button) findViewById(R.id.button6);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editText = (EditText) findViewById(R.id.searchTextbox);
                String _val = editText.getText().toString();
                System.out.println("_val: " + _val);

                Bundle bundle = new Bundle();
                bundle.putString("keyword", _val);
                v.getContext().startActivity(new Intent(v.getContext(), FeedArticleActivity.class).putExtras(bundle));
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

    }
    public void onBackPressed() {
//        super.onBackPressed();
        Intent intent1 = new Intent(getApplicationContext(), Menu_Home.class);
        startActivity(intent1);
        finish();
    }
}
