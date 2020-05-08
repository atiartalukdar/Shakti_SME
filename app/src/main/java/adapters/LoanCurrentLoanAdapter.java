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
import objectBox.LoanCurrentLoanBox;
import objectBox.ObjectBox;

public class LoanCurrentLoanAdapter extends BaseAdapter {
    private Context context;
    private Activity activity;
    private LayoutInflater inflater;
    private List<LoanCurrentLoanBox> data;
    private Box<LoanCurrentLoanBox> loanCurrentLoanBoxBox;

    private final String TAG = getClass().getSimpleName() + " Atiar= ";

    public LoanCurrentLoanAdapter(Activity activity, List<LoanCurrentLoanBox> data) {
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
        loanCurrentLoanBoxBox = ObjectBox.get().boxFor(LoanCurrentLoanBox.class);

        // getting lead data for the row
        final LoanCurrentLoanBox d = data.get(position);

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_loan_current_loan_list_item, null);


        TextView _loan_source = convertView.findViewById(R.id.running_loan_source);
        TextView _loan_installment = convertView.findViewById(R.id.running_loan_installment);
        TextView _is_running=convertView.findViewById(R.id.running_loan_is_running);
        LinearLayout _item = convertView.findViewById(R.id.other_income_item);
        ImageView _deleteItem = convertView.findViewById(R.id.running_loan_delete_item);




        _loan_source.setText(d.getLOAN_NAME());
        _loan_installment.setText(d.getMONTHLY_INSTALLMENT());
        _is_running.setText(d.getIS_DUE_WITHNEW().equals("1") ? R.string.yes : R.string.no);

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
                loanCurrentLoanBoxBox.remove(d);
                notifyDataSetChanged();

            }
        });

        return convertView;

    }

    //To update the searchView items in TransportList Activity
    public void update(List<LoanCurrentLoanBox> resuls){
        data = new ArrayList<>();
        data.addAll(resuls);
        notifyDataSetChanged();
    }
}