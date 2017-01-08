package ohpiestudio.clicker2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import ohpiestudio.clicker2.R;
import ohpiestudio.clicker2.upgrades.Skins;

public class SkinsAdapter extends BaseAdapter {

    private int icons[];
    private Skins skinArray[];
    private static LayoutInflater inflater;

    public SkinsAdapter(Context context, int images[], Skins array[]){
        icons = images;
        skinArray = array;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return icons.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView title;
        TextView price;
        ImageView thumbnails;

        if(view == null){
            View v = inflater.inflate(R.layout.list_layout, null);

            //Declare UI
            title = (TextView) v.findViewById(R.id.powerUpName);
            thumbnails = (ImageView) v.findViewById(R.id.iconArray);
            price = (TextView) v.findViewById(R.id.powerUpCost);

            //Populate Text
            price.setText(String.valueOf(skinArray[i].getPrice()));
            title.setText(String.valueOf(skinArray[i].getName()));
            thumbnails.setImageResource(icons[i]);


            return v;
        } else {
            View v = view;

            //Declare UI
            title = (TextView) v.findViewById(R.id.powerUpName);
            thumbnails = (ImageView) v.findViewById(R.id.iconArray);
            price = (TextView) v.findViewById(R.id.powerUpCost);

            //Populate Text
            price.setText(String.valueOf(skinArray[i].getPrice()));
            title.setText(String.valueOf(skinArray[i].getName()));
            thumbnails.setImageResource(icons[i]);


            return v;
        }
    }
}
