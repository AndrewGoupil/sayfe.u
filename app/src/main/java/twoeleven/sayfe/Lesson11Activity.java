package twoeleven.sayfe;

import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Lesson11Activity extends AppCompatActivity {

    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson11);

        layout = (LinearLayout) findViewById(R.id.linear);

        newImage(0, R.drawable.testinfo1retry);
        newImage(1, R.drawable.testinfo2retry);
        newImage(2, R.drawable.testinfo3retry);

    }

    public void newImage(Integer id, int image) {
        ImageView imageView = new ImageView(this);
        imageView.setId(id);
        imageView.setImageBitmap(BitmapFactory.decodeResource(
                getResources(), image));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        layout.addView(imageView);
    }
}
