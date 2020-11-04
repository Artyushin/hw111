package com.artyushin.hw111;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ItemData extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] maintitle;
    private final String[] subtitle;
    private final Integer[] imgid;
    private Boolean ischecket;
    private List<ItemData> items;

    public ItemData(Activity context, String[] maintitle, String[] subtitle, Integer[] imgid, Boolean ischecket) {
        super (context, R.layout.list_item, maintitle);

        this.context = context;
        this.maintitle = maintitle;
        this.subtitle = subtitle;
        this.imgid = imgid;
        this.ischecket = ischecket;
    }

    public View getView(int position, final View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater ( );
        final View rowView = inflater.inflate (R.layout.list_item, null, true);

        TextView titleText = (TextView) rowView.findViewById (R.id.title);
        ImageView imageView = (ImageView) rowView.findViewById (R.id.icon);
        TextView subtitleText = (TextView) rowView.findViewById (R.id.subtitle);
        final CheckBox checkBox = (CheckBox) rowView.findViewById (R.id.checkBox);

        imageView.setImageResource (imgid[position]);
        titleText.setText (maintitle[position]);
        subtitleText.setText (subtitle[position]);
        checkBox.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                ischecket = checkBox.isChecked ( );
                String text = "Снято!";
                if (ischecket) {
                    text = "Отмечено!";
                }
                Toast.makeText (context, text, Toast.LENGTH_SHORT).show ( );
            }
        });

        return rowView;
    }
}
