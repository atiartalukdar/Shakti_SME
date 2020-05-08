package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sfdw.shaktisme.R;

import java.util.List;

import dataModel.BusinessHomePageDataModel;

public class BusinessHomePageGridViewAdapter extends BaseAdapter {
    private Context mContext;
    List<BusinessHomePageDataModel> data ;
    private LayoutInflater inflater;


    // Constructor
    public BusinessHomePageGridViewAdapter(Context c, List<BusinessHomePageDataModel> data) {
        mContext = c;
        this.data = data;
    }

    public int getCount() {
        return data.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_grid_view_item, null);

        ImageView img = convertView.findViewById(R.id.image);
        TextView tv = convertView.findViewById(R.id.text);


        img.setImageResource(data.get(position).getDrawableID());
        tv.setText(data.get(position).getItemName());


        return convertView;
    }

}
