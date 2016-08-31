package twoeleven.sayfe;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.text.SpannableString;
import android.text.method.ScrollingMovementMethod;
import android.text.style.AlignmentSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.TextView;

public class SupportActivity extends AppCompatActivity {

    float titleSize = 1.6f;
    float subtitleSize = 1.35f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

        String supportText = "\n\nAssaulted Women’s Helpline\n(416) 863-0511\n\n" +
                "Toronto Rape Crisis Centre/Multicultural Women Against Rape\nCounselling Line\n(416) 597-8808\n\n" +
                "Sexual Assault and Domestic Violence Care Centre at Women’s College Hospital\nFor Survivors of any Gender\n(416) 323-6040\n\n" +
                "Barbara Schliffer Commemorative Clinic\nFree Counselling, Legal Information, Referral Service for Women who are Survivors of Violence\n416-323-9149\n\n" +
                "Ontario Mental Health Helpline\n1 (866) 531-2600\n\n" +
                "Gerstein Centre Mental Health Crisis Line\n(416) 929-5200\n\n" +
                "UofT Sexual Harassment Office\n416-978-3908\n\n" +
                "UofT Mental Health Office\n(416) 978-8030\n";

        SpannableString spannedText = new SpannableString(supportText);

        spannedText.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER), 0, 598, 0);
        spannedText.setSpan(new ForegroundColorSpan(Color.BLACK), 0, 29, 0);
        spannedText.setSpan(new RelativeSizeSpan(titleSize), 0, 29, 0);
        spannedText.setSpan(new ForegroundColorSpan(Color.parseColor("#FF3F66")), 29, 45, 0);
        spannedText.setSpan(new RelativeSizeSpan(subtitleSize), 29, 45, 0);

        spannedText.setSpan(new ForegroundColorSpan(Color.BLACK), 45, 105, 0);
        spannedText.setSpan(new RelativeSizeSpan(titleSize), 45, 105, 0);
        spannedText.setSpan(new ForegroundColorSpan(Color.parseColor("#C73F66")), 105, 122, 0);
        spannedText.setSpan(new ForegroundColorSpan(Color.parseColor("#FF3F66")), 122, 138, 0);
        spannedText.setSpan(new RelativeSizeSpan(subtitleSize), 105, 138, 0);

        spannedText.setSpan(new ForegroundColorSpan(Color.BLACK), 138, 215, 0);
        spannedText.setSpan(new RelativeSizeSpan(titleSize), 138, 215, 0);
        spannedText.setSpan(new ForegroundColorSpan(Color.parseColor("#C73F66")), 215, 243, 0);
        spannedText.setSpan(new ForegroundColorSpan(Color.parseColor("#FF3F66")), 243, 259, 0);
        spannedText.setSpan(new RelativeSizeSpan(subtitleSize), 215, 259, 0);

        spannedText.setSpan(new ForegroundColorSpan(Color.BLACK), 259, 298, 0);
        spannedText.setSpan(new RelativeSizeSpan(titleSize), 259, 298, 0);
        spannedText.setSpan(new ForegroundColorSpan(Color.parseColor("#C73F66")), 298, 392, 0);
        spannedText.setSpan(new ForegroundColorSpan(Color.parseColor("#FF3F66")), 392, 406, 0);
        spannedText.setSpan(new RelativeSizeSpan(subtitleSize), 298, 406, 0);

        spannedText.setSpan(new ForegroundColorSpan(Color.BLACK), 406, 437, 0);
        spannedText.setSpan(new RelativeSizeSpan(titleSize), 406, 437, 0);
        spannedText.setSpan(new ForegroundColorSpan(Color.parseColor("#FF3F66")), 437, 455, 0);
        spannedText.setSpan(new RelativeSizeSpan(subtitleSize), 437, 455, 0);

        spannedText.setSpan(new ForegroundColorSpan(Color.BLACK), 455, 497, 0);
        spannedText.setSpan(new RelativeSizeSpan(titleSize), 455, 497, 0);
        spannedText.setSpan(new ForegroundColorSpan(Color.parseColor("#FF3F66")), 497, 513, 0);
        spannedText.setSpan(new RelativeSizeSpan(subtitleSize), 497, 513, 0);

        spannedText.setSpan(new ForegroundColorSpan(Color.BLACK), 513, 543, 0);
        spannedText.setSpan(new RelativeSizeSpan(titleSize), 513, 543, 0);
        spannedText.setSpan(new ForegroundColorSpan(Color.parseColor("#FF3F66")), 543, 557, 0);
        spannedText.setSpan(new RelativeSizeSpan(subtitleSize), 543, 557, 0);

        spannedText.setSpan(new ForegroundColorSpan(Color.BLACK), 557, 583, 0);
        spannedText.setSpan(new RelativeSizeSpan(titleSize), 557, 583, 0);
        spannedText.setSpan(new ForegroundColorSpan(Color.parseColor("#FF3F66")), 583, 598, 0);
        spannedText.setSpan(new RelativeSizeSpan(subtitleSize), 583, 598, 0);

        TextView scrollyText = (TextView) findViewById(R.id.supportTextView);
        scrollyText.setMovementMethod(new ScrollingMovementMethod());
        scrollyText.setBackgroundResource(android.R.color.white);
        scrollyText.setText(spannedText);
    }

    public void toMenu(View view) {
        Intent i = new Intent(this, MenuActivity.class);
        startActivity(i);
    }
}
