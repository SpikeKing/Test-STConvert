package com.example.wcl.teststconvert;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.spreada.utils.chinese.ZHConverter;


public class MainActivity extends ActionBarActivity {

    private TextView mTextView;
    private EditText mEditText;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView)findViewById(R.id.show_text);
        mEditText = (EditText)findViewById(R.id.edit_text);
        mButton = (Button)findViewById(R.id.convert_button);

//        ZHConverter converter = ZHConverter.getInstance(ZHConverter.SIMPLIFIED);
//        String simplifiedStr = converter.convert("有背光的機械式鍵盤");
//
//        ZHConverter.convert("有背光的机械式键盘", ZHConverter.TRADITIONAL);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String simp = mEditText.getText().toString();
                String trad = ZHConverter.convert(simp, ZHConverter.TRADITIONAL);
                mTextView.setText(trad);
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
