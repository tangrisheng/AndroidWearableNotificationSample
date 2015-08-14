package demo.wearable.trs.com.wearabledemo;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.util.Log;
import android.widget.TextView;

public class AmbientModeActivity extends WearableActivity {

    private static final String TAG = AmbientModeActivity.class.getSimpleName();
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAmbientEnabled();
        setContentView(R.layout.activity_display);
        mTextView = (TextView) findViewById(R.id.text);
    }

    @Override
    public void onEnterAmbient(Bundle ambientDetails) {
        super.onEnterAmbient(ambientDetails);
        Log.i(TAG, "onEnterAmbient");
    }

    @Override
    public void onExitAmbient() {
        super.onExitAmbient();
        Log.i(TAG, "onExitAmbient");
    }
}
