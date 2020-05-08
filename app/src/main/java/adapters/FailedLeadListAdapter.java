package adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sfdw.shaktisme.R;

import java.util.ArrayList;
import java.util.List;

import bp.Utils;
import objectBox.LeadBox;
import retrofit2.Retrofit;
import rettrofit.APIInterface;
import rettrofit.RetrofitClientInstance;
import services.ServiceManager;

public class FailedLeadListAdapter extends RecyclerView.Adapter<FailedLeadListAdapter.MyViewHolder> {
    private final String TAG = getClass().getName() + " Atiar - ";
    ServiceManager _serviceManager = new ServiceManager();
    private Context context;

    private Activity activity;
    private List<LeadBox> leadList;

    public FailedLeadListAdapter(Activity activity, List<LeadBox> leadList) {
        this.activity = activity;
        this.leadList = leadList;
        context = activity.getApplicationContext();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_lead_fail_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final LeadBox lead = leadList.get(position);

        try {
            holder._leadID.setText(context.getResources().getString(R.string.leadID) + " " + lead.getLEAD_ID());
            holder._name.setText(lead.getAPPLICANT_NAME());
            holder._phone.setText(lead.getMOBILE_NO());
            holder._nid.setText(lead.getNID_NO());

            try {
                String typeOfLoan = _serviceManager.getLeadOptionObject(lead.getLEADOPTION_ID()).getOPTIONNAMEBN();
                holder._typeOfLoan.setText(typeOfLoan + " ");
            } catch (Exception e) {

                e.printStackTrace();
            }
            holder._requiredLoanAmount.setText(Utils.formatNumber(lead.getLOAN_AMOUNT()) + "/- ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        if (leadList == null) {
            return 0;
        }
        return leadList.size();
    }

    public void update(List<LeadBox> results) {
        leadList = new ArrayList<>();
        leadList.addAll(results);
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView _name;
        TextView _phone;
        TextView _leadID;
        TextView _nid;
        TextView _typeOfLoan;
        TextView _requiredLoanAmount;

        public MyViewHolder(View convertView) {
            super(convertView);
            _name = convertView.findViewById(R.id.custom_lead_fail_list_name);
            _phone = convertView.findViewById(R.id.custom_lead_fail_list_phone_number);
            _leadID = convertView.findViewById(R.id.custom_lead_fail_list_lead_id);
            _nid = convertView.findViewById(R.id.custom_lead_fail_list_nid);
            _typeOfLoan = convertView.findViewById(R.id.custom_lead_fail_list_type_of_loan);
            _requiredLoanAmount = convertView.findViewById(R.id.custom_lead_fail_list_required_loan_amount);
        }
    }
}

