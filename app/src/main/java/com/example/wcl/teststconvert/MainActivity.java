package com.example.wcl.teststconvert;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.spreada.utils.chinese.ZHConverter;

/**
 * 简体-繁体转换示例:
 * 使用{@link com.spreada.utils.chinese.ZHConverter}库；
 * 两种使用方式：参数，转换器(ZHConverter)；
 * 实现繁体-简体的双向转换。
 * <p/>
 * created by C.L.Wang
 */
@SuppressWarnings("all")
public class MainActivity extends ActionBarActivity {

    private TextView mTextView; // 显示框

    private EditText mSmpEditText; // 简体字输入框
    private Button mConvertToTrdButton; // 转换繁体按钮

    private EditText mTrdEditText; // 繁体字输入框
    private Button mConvertToSmpButton; // 转换简体按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.show_text);


        mSmpEditText = (EditText) findViewById(R.id.smp_edit_text);
        mConvertToTrdButton = (Button) findViewById(R.id.convert_trd_button);
        mSmpEditText.setText("春雨医生三周年纪念");

        // 简体转换为繁体
        mConvertToTrdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String smp = mSmpEditText.getText().toString();

                // 通过参数转换
                String trd = ZHConverter.convert(smp, ZHConverter.TRADITIONAL);

                mTextView.setText(trd);
            }
        });

        mTrdEditText = (EditText) findViewById(R.id.trd_edit_text);
        mConvertToSmpButton = (Button) findViewById(R.id.convert_smp_button);
        mTrdEditText.setText("春雨醫生三周年紀念");

        // 繁体转换为简体
        mConvertToSmpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String trd = mTrdEditText.getText().toString();

                // 通过转换器转换
                ZHConverter converter = ZHConverter.getInstance(ZHConverter.SIMPLIFIED);
                String smp = converter.convert(trd);

                mTextView.setText(smp);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
