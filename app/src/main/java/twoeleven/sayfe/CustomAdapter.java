package twoeleven.sayfe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


class CustomAdapter extends BaseAdapter {
    Context context;
    String[] headings;
    Boolean[] checks;
    LayoutInflater inflater;

    public CustomAdapter(Context applicationContext, String[] headings, Boolean[] checks) {
        this.context = applicationContext;
        this.headings = headings;
        this.checks = checks;
        this.inflater = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {

        return headings.length;
    }

    @Override
    public String getItem(int i) {

        return headings[i];
    }

    public Boolean checkDone(int i) {

        return checks[i];
    }

    @Override
    public long getItemId(int i) {

        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = inflater.inflate(R.layout.special_dropdown, null);

        String singleHeading = getItem(position);

        TextView numText = (TextView) view.findViewById(R.id.numTextView);
        TextView headingText = (TextView) view.findViewById(R.id.headingTextView);
        ImageView doneOrNot = (ImageView) view.findViewById(R.id.avatarImageView);

        numText.setText(" " + Integer.toString(position) + ".");
        headingText.setText("     " + singleHeading);

        if (checkDone(position)) {
            doneOrNot.setImageResource(R.drawable.done);
        }
        else {
            doneOrNot.setImageResource(R.drawable.not_done);
        }


        return view;
    }
}

