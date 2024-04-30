package com.example.storeusersettings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.linearLayoutId);

        SharedPreferences sharedPreferences = getSharedPreferences("Bgcolor",Context.MODE_PRIVATE);
        int clr = sharedPreferences.getInt("color",getResources().getColor(R.color.white));
        layout.setBackgroundColor(clr);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.redId) {
            layout.setBackgroundColor(getResources().getColor(R.color.red));
            storeColor(getResources().getColor(R.color.red));
        } else if (item.getItemId() == R.id.yellowId) {
            layout.setBackgroundColor(getResources().getColor(R.color.yellow));
            storeColor(getResources().getColor(R.color.yellow));
        } else if (item.getItemId() == R.id.whiteId) {
            layout.setBackgroundColor(getResources().getColor(R.color.white));
            storeColor(getResources().getColor(R.color.white));
        }else if(item.getItemId()==R.id.purpleId){
            layout.setBackgroundColor(getResources().getColor(R.color.purple));
            storeColor(getResources().getColor(R.color.purple));
        }
        return super.onOptionsItemSelected(item);
    }

    private void storeColor(int color) {
        SharedPreferences sharedPreferences = getSharedPreferences("Bgcolor", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putInt("color",color);
        editor.commit();
    }
}