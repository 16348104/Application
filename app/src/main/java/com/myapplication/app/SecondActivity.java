package com.myapplication.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by xdx on 2016/3/6.
 */


public class SecondActivity extends ActionBarActivity implements View.OnClickListener {

    public static final int RESULT_CODE_TEST = 1;
    private TextView bmiTextView, resultTextView;
    private double weight, height;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initView();
        initData();
        refreshView();
    }

    private void refreshView() {
        double bmi = weight / height / height;
        String result;
        if (bmi < 18.5) {
            result = "体重过低";
        } else if (bmi < 24) {
            result = "体重正常";
        } else if (bmi < 28) {
            result = "超重";
        } else {
            result = "肥胖";
        }
        bmiTextView.setText("BMI: " + String.format("%.2f", bmi));
        resultTextView.setText(result);
    }

    private void initData() {
        weight = getIntent().getDoubleExtra("weight", 0);
        height = getIntent().getDoubleExtra("height", 0);
    }

    private void initView() {
        bmiTextView = (TextView) findViewById(R.id.bmi);
        resultTextView = (TextView) findViewById(R.id.result);
        back = (Button) findViewById(R.id.back);

        back.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("test", "second activity destroy...");
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.back) {
            Intent intent = new Intent();
            intent.putExtra("key", "value");
            setResult(RESULT_CODE_TEST, intent);
            finish();
        }
    }
}
