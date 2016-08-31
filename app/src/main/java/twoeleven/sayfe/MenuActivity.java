package twoeleven.sayfe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void toLessonMenu(View view) {
        Intent i = new Intent(this, LessonMenuActivity.class);
        startActivity(i);
    }

    public void toSupport(View view) {
        Intent i = new Intent(this, SupportActivity.class);
        startActivity(i);
    }
}
