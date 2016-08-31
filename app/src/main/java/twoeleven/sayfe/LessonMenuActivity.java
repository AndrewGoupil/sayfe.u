package twoeleven.sayfe;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class LessonMenuActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    String[] headings1 = {"Basics of Consent", "Consent is Affirmative", "Legality and Consent",
            "Consent is Freely Given", "Consent is Continuous", "What About Drugs and Alcohol",
            "When is Consent Impossible?", "Consent and Culture"};

    String[] headings2 = {"Statistics"};

    Boolean[] checks1 = {true, false, false, false, false, false, false, false};

    Boolean finishedLessons = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_menu);

        Button checkButton = (Button) findViewById(R.id.button);
        checkButton.setClickable(false);
        checkButton.setPadding(0, 0, 0, 0);

        changeButtonIfDone();

        Spinner spin = (Spinner) findViewById(R.id.spinner1);
        spin.setOnItemSelectedListener(this);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), headings1, checks1);
        spin.setAdapter(customAdapter);
    }


    //Performing action onItemSelected and onNothing selected
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
        if (position == 1) {
            Intent i = new Intent(this, Lesson11Activity.class);
            startActivity(i);
        }
        if (position == 2) {
            Intent i = new Intent(this, Lesson12Activity.class);
            startActivity(i);
        }

        checks1[position] = true;
        changeButtonIfDone();
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
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

    public void checkFinished() {
        for (int i = 0; i < checks1.length; i++) {
            if (!checks1[i]) {
                break;
            }
            if (i == checks1.length - 1) {
                finishedLessons = true;
            }
        }
    }

    public void changeButtonIfDone() {
        checkFinished();
        Button checkButton = (Button) findViewById(R.id.button);
        if (finishedLessons) {
            checkButton.setBackgroundColor(Color.parseColor("#FF3F66"));
            checkButton.setClickable(true);
        }
    }

    public void openMenu1(View view) {
        Spinner menu1 = (Spinner) findViewById(R.id.spinner1);
        menu1.performClick();
    }

    public void toMenu(View view) {
        Intent i = new Intent(this, MenuActivity.class);
        startActivity(i);
    }

    public void toQuiz(View view) {
        Intent i = new Intent(this, QuizActivity.class);
        startActivity(i);
    }
}