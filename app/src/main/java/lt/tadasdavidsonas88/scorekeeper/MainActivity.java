package lt.tadasdavidsonas88.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String STATE_SCORE_1 = "state_score_1";
    private static final String STATE_SCORE_2 = "state_score_2";

    private int team1Score;
    private int team2Score;

    TextView team1ScoreTextView;
    TextView team2ScoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        team1ScoreTextView = findViewById(R.id.scoreTextView1);
        team2ScoreTextView = findViewById(R.id.scoreTextView2);

        team1Score = 0;
        team2Score = 0;

        if(savedInstanceState != null){
            team1Score = savedInstanceState.getInt(STATE_SCORE_1);
            team2Score = savedInstanceState.getInt(STATE_SCORE_2);
            // Set the Score text views
            team1ScoreTextView.setText(String.valueOf(team1Score));
            team2ScoreTextView.setText(String.valueOf(team2Score));
        }
    }

    /**
     * Method that handle onClick of both the decrement buttons
     * @param view - the decrement button that was clicked
     */
    public void decreaseScore(View view) {
        // Get the id of the button that was clicked
        int viewID = view.getId();
        switch (viewID){
            // If it was on Team 1
            case R.id.minusImageBtn1:
                // Decrement the score and update the TextView
                team1Score--;
                team1ScoreTextView.setText(String.valueOf(team1Score));
                break;
            // If it was Team 2
            case R.id.minusImageBtn2:
                // Decrement the score and update the TextView
                team2Score--;
                team2ScoreTextView.setText(String.valueOf(team2Score));
                break;
        }

    }

    /**
     * Method that handles onClick of both the increment buttons
     * @param view - the increment button that was clicked
     */
    public void increaseScore(View view) {
        // Get the id of the button that was clicked
        int viewID = view.getId();
        switch (viewID){
            // If it was on Team 1
            case R.id.plusImageButton1:
                // increment the score and update the TextView
                team1Score++;
                team1ScoreTextView.setText(String.valueOf(team1Score));
                break;
            // If it was Team 2
            case R.id.plusImageBtn2:
                // increment the score and update the TextView
                team2Score++;
                team2ScoreTextView.setText(String.valueOf(team2Score));
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu from XML
        getMenuInflater().inflate(R.menu.main_menu, menu);

        // Change the label of the menu based on the state of the app
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        }else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    //Check if the correct item was clicked
        if(item.getItemId()==R.id.night_mode){
            //Get the night mode state of the app
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            //Set the theme mode for the restarted activity
            if(nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
        }
        recreate();
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // save the scores
        outState.putInt(STATE_SCORE_1, team1Score);
        outState.putInt(STATE_SCORE_2, team2Score);
        super.onSaveInstanceState(outState);
    }
}
