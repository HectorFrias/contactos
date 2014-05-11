package com.example.contactos.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements OnClickListener {
        private static final int REQUEST_CHOOSE_PHONE = 1;
        private TextView vPhone;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            vPhone = (TextView) findViewById(R.id.TextView01);
            findViewById(R.id.Button01).setOnClickListener(this);

        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            if ((requestCode == REQUEST_CHOOSE_PHONE)
                    && (resultCode == Activity.RESULT_OK)) {
                try {
                    String phone = data.getStringExtra("phone");
                    vPhone.setText(phone);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public void onClick(View v) {
            Intent intent = new Intent("com.example.CHOOSE_PHONE");
            startActivityForResult(intent, REQUEST_CHOOSE_PHONE);
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
