package com.srjlove.impetusregistration;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class RegitrationActivity extends AppCompatActivity {

    private SQLiteDatabase mDatabase;
    private EditText fName;
    private EditText et_pass;
    private EditText et_email;
    private EditText et_mNumber;
    private EditText lName;
    private Button btn_submit;
    private Button btn_view;
    private ImageButton ib;
    private static final String TAG = "Registration";
    private byte[] bitmapImage =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regitration);
        mDatabase = new DbHelper(this).getWritableDatabase();
        init();

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitData();
            }
        });

        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 456);

            }
        });

        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegitrationActivity.this, ViewDataActivity.class));
            }
        });

    }

    private void init() {
        fName = (EditText) findViewById(R.id.et_full_name);
        lName = (EditText) findViewById(R.id.et_last_name);
        et_mNumber = (EditText) findViewById(R.id.et_mobile_number);
        et_email = (EditText) findViewById(R.id.et_email);
        et_pass = (EditText) findViewById(R.id.et_password);
        btn_submit = (Button) findViewById(R.id.btn_submit);
        btn_view = (Button) findViewById(R.id.btn_view);
        ib = (ImageButton) findViewById(R.id.ib);
    }

    private void submitData() {

        ContentValues mValue = new ContentValues();
        mValue.put(DbHelper.FULL_NAME, fName.getText().toString());
        mValue.put(DbHelper.LAST_NAME, lName.getText().toString());
        mValue.put(DbHelper.MOB, Long.parseLong(et_mNumber.getText().toString()));
        mValue.put(DbHelper.EMAIL, et_email.getText().toString());
        mValue.put(DbHelper.PASS, Integer.parseInt(et_pass.getText().toString()));
        mValue.put(DbHelper.IMAGE,bitmapImage);
        Log.i(TAG, bitmapImage.toString());

        mDatabase.insert(DbHelper.TABLE_NAME, null, mValue);
        Toast.makeText(RegitrationActivity.this, "Data inserted Successfully", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 456 && data != null) {
            try {
                Bitmap mBitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), data.getData());
                ByteArrayOutputStream mStream = new ByteArrayOutputStream();
                mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, mStream);
                bitmapImage = mStream.toByteArray();
                ib.setImageBitmap(mBitmap);

            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this, "Error fetching image", Toast.LENGTH_SHORT).show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
