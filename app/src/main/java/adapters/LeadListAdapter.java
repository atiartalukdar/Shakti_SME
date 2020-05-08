

package adapters;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.sfdw.shaktisme.R;
import com.sfdw.shaktisme.lead.LeadActivity;
import com.sfdw.shaktisme.lead.LeadListActivity;
import com.sfdw.shaktisme.prescreening.PreScreening1;

import java.util.ArrayList;
import java.util.List;

import bp.Utils;
import de.hdodenhof.circleimageview.CircleImageView;
import objectBox.LeadBox;
import responseDataModel.CommonUploadResponse;
import rettrofit.APIManager;
import rettrofit.RequestListener;
import services.ObjectBoxManager;
import services.ServiceManager;

public class LeadListAdapter extends RecyclerView.Adapter<LeadListAdapter.MyViewHolder> {
    private final String TAG = getClass().getName() + " Atiar - ";
    ObjectBoxManager _objectBoxManager = new ObjectBoxManager();
    ServiceManager serviceManager = new ServiceManager();
    APIManager _apiManager = new APIManager();
    private Context context;

    private Activity activity;
    private List<LeadBox> leadList;

    public LeadListAdapter(Activity activity, List<LeadBox> leadList) {
        this.activity = activity;
        this.leadList = leadList;
        context = activity.getApplicationContext();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_lead_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final LeadBox lead = leadList.get(position);

        try {
            holder._leadID.setText(context.getResources().getString(R.string.leadID) + " " + lead.getLEAD_ID());
            holder._name.setText(lead.getAPPLICANT_NAME());
            holder._phone.setText(lead.getMOBILE_NO());
            holder._nid.setText((context.getResources().getString(R.string.nid)+lead.getNID_NO()));
            String typeOfLoan = serviceManager.getLeadOptionObject(lead.getLEADOPTION_ID()).getOPTIONNAMEBN() + " ";
            holder._typeOfLoan.setText(typeOfLoan);
            holder._requiredLoanAmount.setText(Utils.formatNumber(lead.getLOAN_AMOUNT()) + "/- ");

            if (lead.isIS_OFFLINE()) {
                holder._prescreeningBtn.setText(R.string.upload);
                holder._prescreeningBtn.setTextColor(Color.RED);
                holder._prescreeningBtn.setBackgroundColor(context.getResources().getColor(R.color.uploadBackgroundColor));
                holder._prescreeningStatusText.setTextColor(context.getResources().getColor(R.color.warningColor));
                holder._prescreeningStatusText.setText(context.getString(R.string.warning_lead_upload));
            }

            if (!lead.isIS_OFFLINE()) {
                if (lead.getSTATUS() == null){
                    holder._prescreeningStatusText.setTextColor(context.getResources().getColor(R.color.warningColor));
                    holder._prescreeningStatusText.setText(R.string.warning_contact_with_supervisor);
                    holder._prescreeningBtn.setVisibility(View.GONE);
                }
                else if (lead.getSTATUS().toLowerCase().equals("r")) {
                    holder._prescreeningBtn.setText(R.string.rejected);
                    holder._prescreeningBtn.setTextColor(Color.WHITE);
                    holder._prescreeningBtn.setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
                }
                else if (lead.getSTATUS().toLowerCase().equals("a")) {
                    String prescreeningStatus = lead.getPRESCREENING_STATUS();
                    if (prescreeningStatus == null ) {
                        holder._prescreeningBtn.setText(R.string.pre_screening);
                        holder._prescreeningBtn.setTextColor(context.getResources().getColor(R.color.colorWhite));
                        holder._prescreeningBtn.setBackgroundColor(context.getResources().getColor(R.color.colorActiveButton));
                    }else {
                        if (prescreeningStatus.toLowerCase().equals("p")) {
                            holder._prescreeningBtn.setVisibility(View.GONE);
                            holder._prescreeningStatusText.setTextColor(context.getResources().getColor(R.color.colorGreen));
                            holder._prescreeningStatusText.setText(R.string.prescreen_result_successfull);
                            holder._prescreeningStatusText.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_action_prescreening_successfull, 0, 0, 0);
                        } else if (prescreeningStatus.toLowerCase().equals("f")) {
                            holder._prescreeningBtn.setVisibility(View.GONE);
                            holder._prescreeningStatusText.setTextColor(context.getResources().getColor(R.color.colorAccent));
                            holder._prescreeningStatusText.setText(R.string.prescreen_result_unsuccessfull);
                            holder._prescreeningStatusText.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_action_prescreening_unsuccessfull, 0, 0, 0);
                        }else {
                            holder._prescreeningBtn.setText(R.string.pre_screening);
                            holder._prescreeningBtn.setTextColor(context.getResources().getColor(R.color.preScreening_button));
                            holder._prescreeningBtn.setBackground(context.getResources().getDrawable(R.drawable.round_corner));
                        }
                    }
                }
                else {
                    holder._prescreeningStatusText.setTextColor(context.getResources().getColor(R.color.warningColor));
                    holder._prescreeningStatusText.setText(R.string.warning_contact_with_supervisor);
                    holder._prescreeningBtn.setVisibility(View.GONE);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        holder._prescreeningBtn.setOnClickListener(v ->{

            if (!lead.isIS_OFFLINE()) {
                if (lead.getSTATUS() == null) {
                    Toast.makeText(context, v.getResources().getString(R.string.warning_contact_with_supervisor), Toast.LENGTH_LONG).show();
                    return;
                } else if (lead.getSTATUS().toLowerCase().equals("a") && lead.getPRESCREENING_STATUS() == null) {
                    /*List<PrescreeningAnsBox> existingPrescreeningAnsBoxList = _objectBoxManager.GetPrescreeningAnsBox(lead.getLEAD_ID());
                    if(existingPrescreeningAnsBoxList == null || existingPrescreeningAnsBoxList.size() == 0){
                        Intent intent = new Intent(context, PreScreening1.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("LeadDataModelObjectBox", lead);
                        context.startActivity(intent);
                    }
                    else {
                        uploadPrescreeningResultToServer(lead, existingPrescreeningAnsBoxList);
                    }*/
                    Intent intent = new Intent(context, PreScreening1.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("LeadDataModelObjectBox", lead);
                    context.startActivity(intent);

                } else if (lead.getSTATUS().toLowerCase().equals("r")) {
                    Toast.makeText(context, v.getResources().getString(R.string.rejected), Toast.LENGTH_LONG).show();
                    return;
                } else {
                    Toast.makeText(context, v.getResources().getString(R.string.warning_contact_with_supervisor), Toast.LENGTH_LONG).show();
                }
            }

            if (lead.isIS_OFFLINE()) {

                if (!Utils.isNetworkConnected()){
                    Utils.showDialog(activity,"Internet is not available. Please connect with internet.");
                    return;
                }

                uploadLeadToServer(lead);
            }

        });

        holder._leadListItem.setOnClickListener(view ->{
            if (lead.isIS_OFFLINE()) {
                Intent intent = new Intent(context, LeadActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("LeadDataModelObjectBox", lead);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (leadList == null) {
            return 0;
        }

        return leadList.size();
    }

    public void update(List<LeadBox> resuls) {
        leadList = new ArrayList<>();
        leadList.addAll(resuls);
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        CircleImageView _profileImage;
        CircleImageView _prescreeningResultImage;
        TextView _name;
        TextView _phone;
        TextView _leadID;
        TextView _nid;
        TextView _typeOfLoan;
        TextView _requiredLoanAmount;
        TextView _prescreeningStatusText;
        Button _prescreeningBtn;
        LinearLayout _leadListItem;

        public MyViewHolder(View convertView) {
            super(convertView);
            _profileImage = convertView.findViewById(R.id.custom_lead_list_profile_image);
            _prescreeningResultImage = convertView.findViewById(R.id.preScreeningStatus);
            _name = convertView.findViewById(R.id.custom_lead_list_name);
            _phone = convertView.findViewById(R.id.custom_lead_list_phone_number);
            _leadID = convertView.findViewById(R.id.custom_lead_list_lead_id);
            _nid = convertView.findViewById(R.id.custom_lead_list_nid);
            _typeOfLoan = convertView.findViewById(R.id.custom_lead_list_type_of_loan);
            _requiredLoanAmount = convertView.findViewById(R.id.custom_lead_list_required_loan_amount);
            _prescreeningStatusText = convertView.findViewById(R.id.custom_lead_list_prescreening_status_text);
            _prescreeningBtn = convertView.findViewById(R.id.custom_lead_list_btn_pre_screening);
            _leadListItem = convertView.findViewById(R.id.lead_item);
        }
    }

    private void uploadLeadToServer(LeadBox lead) {

        KProgressHUD kProgressHUD = Utils.showProgressDialog(activity, activity.getResources().getString(R.string.uploading));

        try {
            ProgressDialog progressDialog = new ProgressDialog(activity);
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage("Uploading Lead...");
            progressDialog.setCancelable(false);
            progressDialog.show();
            Log.e(TAG, "Lead data to be sent: " + Utils.convetToJsonString(lead));
            _apiManager.uploadLeadToServer(lead, new RequestListener<CommonUploadResponse>() {
                @Override
                public void onSuccess(CommonUploadResponse response) {
                    if (response == null) {
                        Utils.showDialog(activity, context.getResources().getString(R.string.server_error));
                    } else if (response.getIsSuccessful()) {
                        _objectBoxManager.RemoveLeadBox(lead.getBRANCH_ID(), lead.getLEAD_ID());

                        Intent intent = new Intent(context, LeadListActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);

                        notifyDataSetChanged();
                    } else {
                        Utils.showDialog(activity, response.getMessage());
                    }
                    progressDialog.dismiss();

                }

                @Override
                public void onError(Throwable t) {
                    Log.e(TAG, "new lead data upload failed and the reason is:  " + t.getMessage());
                    progressDialog.dismiss();
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "error when creating lead to server " + e.getMessage());
            e.printStackTrace();
        } finally {
            kProgressHUD.dismiss();
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}

