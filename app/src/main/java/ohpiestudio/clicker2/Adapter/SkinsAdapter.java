package ohpiestudio.clicker2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

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
        return 0;
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
        return null;
    }
}
