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
import objectBox.LoanOtherIncomeBox;
import objectBox.ObjectBox;

public class LoanOtherIncomeAdapter extends BaseAdapter {
    private Context context;
    private Activity activity;
    private LayoutInflater inflater;
    private List<LoanOtherIncomeBox> data;
    private Box<LoanOtherIncomeBox> loanOtherIncomeBoxBox;

    private final String TAG = getClass().getSimpleName() + " Atiar= ";

    public LoanOtherIncomeAdapter(Activity activity, List<LoanOtherIncomeBox> data) {
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
        loanOtherIncomeBoxBox = ObjectBox.get().boxFor(LoanOtherIncomeBox.class);

        // getting lead data for the row
        final LoanOtherIncomeBox d = data.get(position);

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_loan_other_income_list_item, null);


        TextView _incomesource = convertView.findViewById(R.id.other_income_source);
        TextView _monthlyincome = convertView.findViewById(R.id.other_monthly_income);
        TextView _total_income=convertView.findViewById(R.id.total_other_income);
        LinearLayout _item = convertView.findViewById(R.id.other_income_item);
        ImageView _deleteItem = convertView.findViewById(R.id.other_income_delete_item);


        _incomesource.setText(d.getSOURCE());
        _monthlyincome.setText(d.getMONTHLYINCOME());




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
                loanOtherIncomeBoxBox.remove(d);
                notifyDataSetChanged();

            }
        });

        return convertView;

    }

    //To update the searchView items in TransportList Activity
    public void update(List<LoanOtherIncomeBox> resuls){
        data = new ArrayList<>();
        data.addAll(resuls);
        notifyDataSetChanged();
    }
}