package com.disney.android.wdprvalidatorsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.disney.android.wdprvalidators.MapKeysValidator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by venkatgonuguntala on 10/27/15.
 */
public class MapKeysValidatorDemo extends Activity {

    public static final String TAG = MapKeysValidatorDemo.class.getName();

    private MapKeysValidator mMapKeysValidator = new MapKeysValidator();

    private Map<String,String> map = new HashMap<>();

    private Map<String,?> emptymap = new HashMap<>();

    private TextView mTextView;

    private Button mButton2;

    private Button mButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mapkeys);

        map.put("Amit", "Akshaj");
        map.put("Naren", "Bavisha");
        map.put("KK", "Sanskar");

        mTextView = (TextView) findViewById(R.id.textViewMapKeys);

        mButton2 = (Button) findViewById(R.id.button2);

        mButton3 = (Button) findViewById(R.id.button3);

    }


    public void checkMapKeysFunctionOne(View view) {

        String[] string = {};
        List<String> result = mMapKeysValidator.checkForMapKeys(map, string);

        String errorCode="";

        for (String str : result)
        {
            str ="\n"+str;

            errorCode=errorCode.concat(str);
        }

        if(errorCode.isEmpty())
        {
            mTextView.setText("success");
        }
        else
        {
            mTextView.setText(errorCode);
        }
    }

    public void checkMapKeysfunctionTwo(View view) {

        String string[] = {"big", "pig"};
        List<String> result = mMapKeysValidator.checkForMapKeys(map, string);

        String errorCode="";

        for (String str : result)
        {
            str ="\n"+str;

            errorCode=errorCode.concat(str);
        }

        if(errorCode.isEmpty())
        {
            mTextView.setText("success");
        }
        else
        {
            mTextView.setText(errorCode);
        }
    }

    public void checkMapKeysfunctionThree(View view){
        String string[] = {"123", "456"};
        List<String> result = mMapKeysValidator.checkForMapKeys(emptymap, string);

        String errorCode="";

        for (String str : result)
        {
            str ="\n"+str;

            errorCode=errorCode.concat(str);
        }

        if(errorCode.isEmpty())
        {
            mTextView.setText("success");
        }
        else
        {
            mTextView.setText(errorCode);
        }
    }

}
