package com.example.a1718040_profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView mTextView1;
    TextView mTextView2;
    TextView mTextView3;
    Spinner mLanguage;
    ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLanguage = (Spinner) findViewById(R.id.spLanguage);
        mTextView1 = (TextView) findViewById(R.id.id_nama);
        mTextView2 = (TextView) findViewById(R.id.id_alamat);
        mTextView3 = (TextView) findViewById(R.id.id_pend);

        mAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.language_option));
        mLanguage.setAdapter(mAdapter);

        if (LocaleHelper.getLanguage(MainActivity.this).equalsIgnoreCase("en")) {
            mLanguage.setSelection(mAdapter.getPosition("English"));
        } else if (LocaleHelper.getLanguage(MainActivity.this).equalsIgnoreCase("in")) {
            mLanguage.setSelection(mAdapter.getPosition("Indonesian"));
        }

        mLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Context context;
                Resources resources;
                switch (i) {
                    case 0:
                        context = LocaleHelper.setLocale(MainActivity.this, "en");
                        resources = context.getResources();
                        mTextView1.setText(resources.getString(R.string.text_akun));
                        mTextView2.setText(resources.getString(R.string.text_alamat));
                        mTextView3.setText(resources.getString(R.string.text_pend));
                        break;
                    case 1:
                        context = LocaleHelper.setLocale(MainActivity.this, "in");
                        resources = context.getResources();
                        mTextView1.setText(resources.getString(R.string.text_akun));
                        mTextView2.setText(resources.getString(R.string.text_alamat));
                        mTextView3.setText(resources.getString(R.string.text_pend));
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
}
