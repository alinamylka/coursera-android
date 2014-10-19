package course.labs.activitylab;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by ally on 06/10/14.
 */
public class SuperActivity extends Activity {

    // Use these as keys when you're saving state between reconfigurations
    private static final String RESTART_KEY = "restart";
    private static final String RESUME_KEY = "resume";
    private static final String START_KEY = "start";
    private static final String CREATE_KEY = "create";

    // Lifecycle counters
    private int mCreate;
    private int mRestart;
    private int mStart;
    private int mResume;


    private TextView mTvCreate;
    private TextView mTvStart;
    private TextView mTvRestart;
    private TextView mTvResume;

    public void init(Bundle savedInstanceState){

        // Has previous state been saved?
        if (savedInstanceState != null) {
            this.mCreate = savedInstanceState.getInt(CREATE_KEY);
            this.mStart = savedInstanceState.getInt(START_KEY);
            this.mResume = savedInstanceState.getInt(RESUME_KEY);
            this.mRestart = savedInstanceState.getInt(RESTART_KEY);
        }

        mTvCreate = (TextView) findViewById(R.id.create);
        mTvRestart = (TextView) findViewById(R.id.restart);
        mTvStart = (TextView) findViewById(R.id.start);
        mTvResume = (TextView) findViewById(R.id.resume);

        mCreate++;
        displayCounts();

    }

    @Override
    protected void onStart() {
        super.onStart();

        mStart++;
        displayCounts();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        mRestart++;
        displayCounts();
    }

    @Override
    protected void onResume() {
        super.onResume();

        mResume++;
        displayCounts();
    }

    // Updates the displayed counters
    // This method expects that the counters and TextView variables use the
    // names
    // specified above
    public void displayCounts() {

        mTvCreate.setText("onCreate() calls: " + mCreate);
        mTvStart.setText("onStart() calls: " + mStart);
        mTvResume.setText("onResume() calls: " + mResume);
        mTvRestart.setText("onRestart() calls: " + mRestart);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // Save state information with a collection of key-value pairs
        // 4 lines of code, one for every count variable
        outState.putInt(RESTART_KEY, mRestart);
        outState.putInt(RESUME_KEY, mResume);
        outState.putInt(START_KEY, mStart);
        outState.putInt(CREATE_KEY, mCreate);
    }
}
