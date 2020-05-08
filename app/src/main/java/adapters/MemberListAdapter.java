package adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sfdw.shaktisme.R;
import com.sfdw.shaktisme.memberList.LoanAssessmentActivity;
import com.sfdw.shaktisme.memberList.KYCActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import dataModelNew.MemberListDM;
import de.hdodenhof.circleimageview.CircleImageView;

public class MemberListAdapter extends BaseAdapter {
    private Context context;
    private Activity activity;
    private LayoutInflater inflater;
    private List<MemberListDM.Data> memberList;
    private final String TAG = getClass().getSimpleName() + " Atiar= ";

    public MemberListAdapter(Activity activity, List<MemberListDM.Data> memberList) {
        this.activity = activity;
        this.memberList = memberList;
    }

    @Override
    public int getCount() {
        return memberList.size();
    }

    @Override
    public Object getItem(int location) {
        return memberList.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        context = activity.getApplicationContext();

        // getting lead data for the row
        final MemberListDM.Data member = memberList.get(position);

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_member_list, null);

        CardView _memberCardView = convertView.findViewById(R.id.memberCardView);
        CircleImageView _profileImage = convertView.findViewById(R.id.custom_member_list_profile_image);
        TextView _name = convertView.findViewById(R.id.custom_member_list_name);
        TextView _phone = convertView.findViewById(R.id.custom_member_list_phone_number);
        TextView _memberID = convertView.findViewById(R.id.custom_member_list_member_id);
        TextView _nid = convertView.findViewById(R.id.custom_member_list_nid);
        TextView _totalLoan = convertView.findViewById(R.id.custom_member_list_total_loan);
        TextView _totalSavings = convertView.findViewById(R.id.custom_member_list_total_savings);
        TextView _totalOverdue = convertView.findViewById(R.id.custom_member_list_total_odBalance);
        LinearLayout item = convertView.findViewById(R.id.custom_member_item);

        Button _personalInfoBtn = convertView.findViewById(R.id.custom_member_list_personal_info);

        try {
            _memberID.setText(convertView.getResources().getString(R.string.memberID) +member.getMEMBER_ID());
            _name.setText(member.getMEMBER_NAME());
            _phone.setText(member.getMOBILE_NO());
            _nid.setText(member.getNID());
            _totalLoan.setText( member.getLOAN_OUTSTANDING() + "/-" );
            _totalSavings.setText( member.getTOTAL_SAVINGS() + "/-" );

            /*_totalOverdue.setText( member.getTOTAL_SAVINGS() + "/-" );  //TODO: need to add OD_BALANCE instead of getTotal_Savings

            if (member.getTOTAL_SAVINGS()<=0){
                _totalOverdue.setTextColor(Color.BLACK);
            }if (member.getTOTAL_SAVINGS()>0){
                _memberCardView.setBackgroundColor(Color.parseColor("#ECA8A8"));
            }

            */

            Picasso.get()
                    .load(member.getMEMBER_PHOTO_URL())
                    .placeholder(R.drawable.dummy_profile)
                    .error(R.drawable.dummy_profile)
                    .into(_profileImage);

            String kycStatus = member.getKYC_STATUS();
            String loanApprovalStatus = member.getLOAN_APPLICATION_STATUS();
            switch (kycStatus.toLowerCase()){
                case "0":
                    _personalInfoBtn.setEnabled(true);
                    _personalInfoBtn.setBackgroundColor(context.getResources().getColor(R.color.colorActiveButton));
                    _personalInfoBtn.setTextColor(context.getResources().getColor(R.color.colorWhite));
                    _personalInfoBtn.setText("KYC");
                    break;
                case "1":
                    if (loanApprovalStatus == null){
                        _personalInfoBtn.setEnabled(true);
                        _personalInfoBtn.setBackgroundColor(context.getResources().getColor(R.color.colorActiveButton));
                        _personalInfoBtn.setTextColor(context.getResources().getColor(R.color.colorWhite));
                        _personalInfoBtn.setText("Loan Assesment");
                        break;
                    }
                    switch (loanApprovalStatus){
                        case "0":
                            _personalInfoBtn.setEnabled(false);
                            _personalInfoBtn.setBackgroundColor(context.getResources().getColor(R.color.colorInActiveButton));
                            _personalInfoBtn.setTextColor(context.getResources().getColor(R.color.warningColor));
                            _personalInfoBtn.setText("Waiting for approval");
                            break;
                        case "1":
                            _personalInfoBtn.setEnabled(false);
                            _personalInfoBtn.setBackgroundColor(context.getResources().getColor(R.color.colorInActiveButton));
                            _personalInfoBtn.setTextColor(context.getResources().getColor(R.color.warningColor));
                            _personalInfoBtn.setText("Loan Application Approved");
                            break;
                        case "2":
                            _personalInfoBtn.setEnabled(false);
                            _personalInfoBtn.setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
                            _personalInfoBtn.setTextColor(Color.WHITE);
                            _personalInfoBtn.setText("Loan Application Rejected");
                            break;
                        case "3":
                            _personalInfoBtn.setEnabled(false);
                            _personalInfoBtn.setBackgroundColor(context.getResources().getColor(R.color.colorInActiveButton));
                            _personalInfoBtn.setTextColor(context.getResources().getColor(R.color.warningColor));
                            _personalInfoBtn.setText("Existing Loan Found");
                            break;

                    }
                    break;
            }
            _personalInfoBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (kycStatus.toLowerCase().equals("0")){
                        Intent intent = new Intent(context, KYCActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("memberDetails",member);
                        context.startActivity(intent);
                    }else if (kycStatus.toLowerCase().equals("1") && loanApprovalStatus == null){
                        Intent intent = new Intent(context, LoanAssessmentActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("memberDetails",member);
                        context.startActivity(intent);
                    }

                }
            });

        }catch (Exception e){
            e.printStackTrace();
        }




        return convertView;

    }

    //To update the searchView items in TransportList Activity
    public void update(List<MemberListDM.Data> resuls){
        memberList = new ArrayList<>();
        memberList.addAll(resuls);
        notifyDataSetChanged();
    }
}