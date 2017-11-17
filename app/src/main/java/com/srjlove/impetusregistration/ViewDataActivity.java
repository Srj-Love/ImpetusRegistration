package com.srjlove.impetusregistration;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewDataActivity extends AppCompatActivity {

    private SQLiteDatabase mDatabase;
    DbHelper mHelper;
    private TextView tv_col;
    private RecyclerView mListView;
    private ArrayList<Model> mList;
    private static final String TAG = "ViewDataActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);
        mList = new ArrayList<>();
        init();
        LinearLayoutManager m = new LinearLayoutManager(this);
        m.setOrientation(LinearLayoutManager.VERTICAL);
        mListView.setLayoutManager(m);

        viewData();


    }

    private void init() {
        mListView = findViewById(R.id.rv);
    }

    private void viewData() {
        mDatabase = new DbHelper(this).getReadableDatabase();
        StringBuilder mBuffer = new StringBuilder();

        Cursor mCursor = mDatabase.query(DbHelper.TABLE_NAME, null, null, null, null, null, null);
        String[] cNames = mCursor.getColumnNames();
        for (String column : cNames) {
            mBuffer.append(column).append(" \t");
        }

        while (mCursor.moveToNext()) {
            String fname = mCursor.getString(mCursor.getColumnIndex(DbHelper.FULL_NAME));
            String lname = mCursor.getString(mCursor.getColumnIndex(DbHelper.LAST_NAME));
            String email = mCursor.getString(mCursor.getColumnIndex(DbHelper.EMAIL));
            int pass = mCursor.getInt(mCursor.getColumnIndex(DbHelper.PASS));
            int mob = mCursor.getInt(mCursor.getColumnIndex(DbHelper.MOB));
            byte[] image = mCursor.getBlob(mCursor.getColumnIndex(DbHelper.IMAGE));

            Model model = new Model(fname, lname, email, mob, pass, image);
            mList.add(model);
            Log.i(TAG, model.getFname() + " " + model.getLname() + " " + model.getEmail() + " " + model.getPass() + " " + model.getMob() + " \n");

        }
        mListView.setAdapter(new CustomListAdapter(this,mList));

        mCursor.close();
    }
}
