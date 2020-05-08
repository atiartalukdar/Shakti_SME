package adapters;


import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.sfdw.shaktisme.R;

import java.util.ArrayList;
import java.util.List;

import bp.Session;
import dataModelNew.LoadConfigurationDM;
import io.objectbox.Box;
import io.objectbox.query.QueryBuilder;
import objectBox.ObjectBox;
import objectBox.PrescreeningAnsBox;
import objectBox.PrescreeningAnsBox_;

public class PrescreeningAdapterBox extends RecyclerView.Adapter<PrescreeningAdapterBox.MyViewHolder> {
    private final String TAG = getClass().getName() + " Atiar - ";

    private List<LoadConfigurationDM.PreScreeningList> _preScreeningQuestionsList;
    private Box<PrescreeningAnsBox> ansBox;
    int leadID;

    private List<RadioGroup> itemStateArray = new ArrayList<>();

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView question;
        public RadioGroup group;
        public RadioButton o1, o2;

        public MyViewHolder(View view) {
            super(view);
            question = view.findViewById(R.id.question);
            group = view.findViewById(R.id.radioGroup);
            o1 = view.findViewById(R.id.radioButtonOption1);
            o2 = view.findViewById(R.id.radioButtonOption2);
            this.setIsRecyclable(false);
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            itemStateArray.add(adapterPosition, group);
        }
    }

    public PrescreeningAdapterBox(List<LoadConfigurationDM.PreScreeningList> preScreeningQuestionsList, int leadID) {
        this._preScreeningQuestionsList = preScreeningQuestionsList;
        this.leadID = leadID;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_prescreening_list_1, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ansBox = ObjectBox.get().boxFor(PrescreeningAnsBox.class);
        LoadConfigurationDM.PreScreeningList pre = _preScreeningQuestionsList.get(position);
        holder.question.setText(position + 1 + " | " + pre.getQUESTION());
        holder.o1.setText(pre.getOPTION1());
        holder.o2.setText(pre.getOPTION2());

        if (ansBox.query().equal(PrescreeningAnsBox_.LEAD_ID, leadID).build().find().size() > 0 && pre.getISFIRSTSTEP() == 1) {

            String previousCorrectAns = "";
            try {
                previousCorrectAns = ansBox.query().notNull(PrescreeningAnsBox_.QUESTION_ID).and().equal(PrescreeningAnsBox_.QUESTION_ID, pre.getPRESCREENINGID()).build().findFirst().getANSWER();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (previousCorrectAns != "" || !previousCorrectAns.equals(null) || !previousCorrectAns.equals("")) {
                    if (previousCorrectAns.equals(pre.getOPTION1())) {
                        holder.o1.setChecked(true);
                    } else if (previousCorrectAns.equals(pre.getOPTION2())) {
                        holder.o2.setChecked(true);
                    } else {
                        holder.o1.setChecked(false);
                        holder.o2.setChecked(false);
                    }
                }
            }
        }

        List<PrescreeningAnsBox> prePart2 = ansBox.query().equal(PrescreeningAnsBox_.LEAD_ID, leadID)
                .and()
                .equal(PrescreeningAnsBox_.isFirstStep, 0).build().find();

        if (prePart2.size() > 0 && pre.getISFIRSTSTEP() == 0) {
            new Handler().post(() -> {
                if (getAnsForParticularQuestion(pre.getPRESCREENINGID()).equals(holder.o1.getText().toString())) {
                    holder.o1.setChecked(true);
                    holder.o2.setChecked(false);
                }
                if (getAnsForParticularQuestion(pre.getPRESCREENINGID()).equals(holder.o2.getText().toString())) {
                    holder.o1.setChecked(false);
                    holder.o2.setChecked(true);
                }
            });
        }


        holder.group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButtonOption1) {
                    Log.e(TAG, "Lead ID: " + leadID + " question id: " + pre.getPRESCREENINGID() + " Ans: " + holder.o1.getText().toString());
                    if (!hasData(pre.getPRESCREENINGID(), holder.o1.getText().toString())) {
                        PrescreeningAnsBox PrescreeningAnsBox = new PrescreeningAnsBox(Session.getUserID(), leadID, pre.getPRESCREENINGID(), holder.o1.getText().toString(), pre.getQURRECTOPTION(), pre.getISFIRSTSTEP(), pre.getMARK());
                        ansBox.put(PrescreeningAnsBox);
                        Log.e(TAG, "inserted, data size: " + ansBox.getAll().size());
                    }
                } else if (checkedId == R.id.radioButtonOption2) {
                    Log.e(TAG, "Lead ID: " + leadID + " question id: " + pre.getPRESCREENINGID() + " Ans: " + holder.o2.getText().toString());
                    if (!hasData(pre.getPRESCREENINGID(), holder.o2.getText().toString())) {
                        PrescreeningAnsBox PrescreeningAnsBox = new PrescreeningAnsBox(Session.getUserID(), leadID, pre.getPRESCREENINGID(), holder.o2.getText().toString(), pre.getQURRECTOPTION(), pre.getISFIRSTSTEP(), pre.getMARK());
                        ansBox.put(PrescreeningAnsBox);
                        Log.e(TAG, "inserted, data size: " + ansBox.getAll().size());
                    }
                }
            }
        });


    }

    private boolean hasData(Integer questionID, String answer) {
        ansBox = ObjectBox.get().boxFor(PrescreeningAnsBox.class);
        QueryBuilder<PrescreeningAnsBox> builder = ansBox.query();
        PrescreeningAnsBox ans = null;
        try {
            ans = builder
                    .equal(PrescreeningAnsBox_.QUESTION_ID, questionID)
                    .and()
                    .equal(PrescreeningAnsBox_.LEAD_ID, leadID)
                    .build().findFirst();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ans != null) {
                ans.setANSWER(answer);
                Log.e(TAG, "\nUpdated Items: " + ans.toString() + "\n\n\n");
                ansBox.put(ans);
                return true;
            }
        }
        return false;
    }

    @Override
    public int getItemCount() {
        if (_preScreeningQuestionsList == null) {
            return 0;
        }
        return _preScreeningQuestionsList.size();

    }

    private String getAnsForParticularQuestion(Integer questionID) {
        PrescreeningAnsBox a = ansBox.query().equal(PrescreeningAnsBox_.LEAD_ID, leadID)
                .and()
                .equal(PrescreeningAnsBox_.QUESTION_ID, questionID).build().findFirst();

        try {
            return a.getANSWER();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "none";
    }

}