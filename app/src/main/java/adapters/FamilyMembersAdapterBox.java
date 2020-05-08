package adapters;


import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sfdw.shaktisme.R;

import java.util.ArrayList;
import java.util.List;

import objectBox.KYCFamilyMemberBox;


public class FamilyMembersAdapterBox extends BaseAdapter {
    private Context context;
    private Activity activity;
    private LayoutInflater inflater;
    private List<KYCFamilyMemberBox> familyMembersList;
    String api="";
    boolean isVerified = false;
    private final String TAG = getClass().getSimpleName() + " Atiar= ";

    public FamilyMembersAdapterBox(Activity activity, List<KYCFamilyMemberBox> familyMembersList) {
        this.activity = activity;
        this.familyMembersList = familyMembersList;
    }

    @Override
    public int getCount() {
        return familyMembersList.size();
    }

    @Override
    public Object getItem(int location) {
        return familyMembersList.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        context = activity.getApplicationContext();

        // getting lead data for the row
        final KYCFamilyMemberBox familymember = familyMembersList.get(position);

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_family_members_item, null);

        TextView _nameAndAge = convertView.findViewById(R.id.custom_family_member_name);
        TextView _age = convertView.findViewById(R.id.custom_family_member_age);
        TextView _relation = convertView.findViewById(R.id.custom_family_member_relation);
        TextView _occupation = convertView.findViewById(R.id.custom_family_member_occupation);
        TextView _education = convertView.findViewById(R.id.custom_family_member_educational_qualification);
        TextView _marritalStatus = convertView.findViewById(R.id.custom_family_member_marrital_status);

        try {
            _nameAndAge.setText("Name: "+familymember.getFmname());
            _age.setText(familymember.getAge()+" ");
            _relation.setText(familymember.getRelation() + " ");
            _occupation.setText(familymember.getOccupation());
            _education.setText(familymember.getEducation());
            if (familymember.getIsmarried()==1){
                _marritalStatus.setText(convertView.getResources().getString(R.string.marriad));
            }else{
                _marritalStatus.setText(convertView.getResources().getString(R.string.unmarriad));
            }
        }catch (Exception e){
            Log.e(TAG, "Error while setting up family members' data on the view" + e.getLocalizedMessage());
            e.printStackTrace();
        }

        return convertView;

    }

    //To update the searchView items in TransportList Activity
    public void update(List<KYCFamilyMemberBox> resuls){
        familyMembersList = new ArrayList<>();
        familyMembersList.addAll(resuls);
        notifyDataSetChanged();
    }
}