package ohpiestudio.clicker2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import ohpiestudio.clicker2.R;
import ohpiestudio.clicker2.Upgrades.PowerUp;

public class CustomAdapter extends BaseAdapter{

    private int icons[];
    private PowerUp powerUpArray[];
    private static LayoutInflater inflater;

    public CustomAdapter(Context context, int images[], PowerUp array[] ){
        icons = images;
        powerUpArray = array;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return icons.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView title;
        TextView price;
        TextView amountOwned;
        ImageView thumbnails;

        if(view == null){
            View v = inflater.inflate(R.layout.list_layout, null);

            //Declare UI
            title = (TextView) v.findViewById(R.id.powerUpName);
            thumbnails = (ImageView) v.findViewById(R.id.iconArray);
            amountOwned = (TextView) v.findViewById(R.id.amountOwnedText);
            price = (TextView) v.findViewById(R.id.powerUpCost);
            //Populate Text
            price.setText(String.valueOf(powerUpArray[i].getPrice()));
            amountOwned.setText(String.valueOf(powerUpArray[i].getAmountOwned()));
            title.setText(powerUpArray[i].getName());
            thumbnails.setImageResource(icons[i]);

            return v;
        } else {
            View v = view;

            //Declare UI
            title = (TextView) v.findViewById(R.id.powerUpName);
            thumbnails = (ImageView) v.findViewById(R.id.iconArray);
            amountOwned = (TextView) v.findViewById(R.id.amountOwnedText);
            price = (TextView) v.findViewById(R.id.powerUpCost);
            //Populate Text
            price.setText(String.valueOf(powerUpArray[i].getPrice()));
            amountOwned.setText(String.valueOf(powerUpArray[i].getAmountOwned()));
            title.setText(powerUpArray[i].getName());
            thumbnails.setImageResource(icons[i]);

            return v;
        }
    }
}
