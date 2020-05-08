package adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sfdw.shaktisme.R;
import com.sfdw.shaktisme.memberList.KYCActivity;

import java.util.ArrayList;
import java.util.List;

import io.objectbox.Box;
import objectBox.LoanStockOfGoodsBox;
import objectBox.ObjectBox;

public class LoanStockOfGoodsAdapter extends BaseAdapter {
    private Context context;
    private Activity activity;
    private LayoutInflater inflater;
    private List<LoanStockOfGoodsBox> data;
    private Box<LoanStockOfGoodsBox> loanStockOfGoodsBoxBox;

    private final String TAG = getClass().getSimpleName() + " Atiar= ";

    public LoanStockOfGoodsAdapter(Activity activity, List<LoanStockOfGoodsBox> data) {
        this.activity = activity;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int location) {
        return data.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        context = activity.getApplicationContext();
        loanStockOfGoodsBoxBox = ObjectBox.get().boxFor(LoanStockOfGoodsBox.class);

        // getting lead data for the row
        final LoanStockOfGoodsBox d = data.get(position);

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_biz_info_ponner_mozud_list_item, null);


        TextView _name = convertView.findViewById(R.id.ponner_mojud_product_name);
        TextView _qty = convertView.findViewById(R.id.ponner_mojud_qty);
        TextView _unitPrice = convertView.findViewById(R.id.ponner_mojud_unit_price);
        TextView _totalPrice = convertView.findViewById(R.id.ponner_mojud_total_price);
        LinearLayout _item = convertView.findViewById(R.id.ponner_mojud_item);
        ImageView _deleteItem = convertView.findViewById(R.id.ponner_mojud_delete_item);
        String totalCost = "";
        if (!d.getUNIT().equals("") && !d.getPRICE_PER_UNIT().equals("")){
            totalCost = (Integer.parseInt(d.getUNIT()) * Integer.parseInt(d.getPRICE_PER_UNIT())) + "";
        }

        _name.setText(d.getITEM_NAME());
        _qty.setText(d.getUNIT());
        _unitPrice.setText(d.getPRICE_PER_UNIT());
        _totalPrice.setText(totalCost);



        _item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, KYCActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

        _deleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.remove(position);
                loanStockOfGoodsBoxBox.remove(d);
                notifyDataSetChanged();

            }
        });

        return convertView;

    }

    //To update the searchView items in TransportList Activity
    public void update(List<LoanStockOfGoodsBox> resuls){
        data = new ArrayList<>();
        data.addAll(resuls);
        notifyDataSetChanged();
    }
}