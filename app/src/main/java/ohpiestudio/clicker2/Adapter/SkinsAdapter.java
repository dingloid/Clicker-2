package ohpiestudio.clicker2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import ohpiestudio.clicker2.R;

import ohpiestudio.clicker2.Upgrades.Skins;


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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        TextView title;
        TextView price;
        TextView desc;
        ImageView thumbnails;

        if(view == null){
            View v = inflater.inflate(R.layout.list_layout_skins, null);

            //Declare UI
            title = (TextView) v.findViewById(R.id.skinName);
            thumbnails = (ImageView) v.findViewById(R.id.iconArray);
            price = (TextView) v.findViewById(R.id.skinCost);
            desc = (TextView) v.findViewById(R.id.descText);

            //Populate Text
            title.setText(String.valueOf(skinArray[i].getName()));
            desc.setText(skinArray[i].getDescription());
            thumbnails.setImageResource(icons[i]);

            if(skinArray[i].getUnlocked()){
                price.setVisibility(View.GONE);
            } else {
                price.setText(String.valueOf(skinArray[i].getPrice()));
            }

            return v;

        } else {
            View v = view;

            //Declare UI
            title = (TextView) v.findViewById(R.id.skinName);
            thumbnails = (ImageView) v.findViewById(R.id.iconArray);
            price = (TextView) v.findViewById(R.id.skinCost);
            desc = (TextView) v.findViewById(R.id.descText);

            //Populate Text
            title.setText(String.valueOf(skinArray[i].getName()));
            desc.setText(skinArray[i].getDescription());
            thumbnails.setImageResource(icons[i]);

            if(skinArray[i].getUnlocked()){
                price.setVisibility(View.GONE);;
            } else {
                price.setText(String.valueOf(skinArray[i].getPrice()));
            }

            return v;
        }
    }
}
