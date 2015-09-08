package com.disney.android.wdprvalidatorsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.disney.android.wdprvalidators.PrimitiveValidator;
import java.util.List;

/**
 * Created by venkatgonuguntala on 9/4/15.
 */
public class UncheckedDemo extends Activity {

    private TextView mResultText;

    private PrimitiveValidator mPrimitiveValidator;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.unchecked_activity);

        mResultText = (TextView) findViewById(R.id.show_uncheckedtext_view);

        mPrimitiveValidator = new PrimitiveValidator();

        Button button = (Button) findViewById(R.id.uncheckedButton);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                onUncheckedClick(view);
            }
        });
    }

    private void onUncheckedClick(View view)
    {

        List<String> result = mPrimitiveValidator.checkUnchecked();

        String errorCode="";

        for (String str : result)
        {
            str ="\n"+str;

            errorCode=errorCode.concat(str);
        }

        if (result.isEmpty())
        {
            Toast.makeText(this, "true", Toast.LENGTH_LONG).show();

        }
        else
        {
            Toast.makeText(this, errorCode, Toast.LENGTH_LONG).show();
        }

        mResultText.setText("");
    }
}
