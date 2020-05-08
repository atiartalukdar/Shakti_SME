package com.sfdw.shaktisme.kyc;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.sfdw.shaktisme.R;
import com.sfdw.shaktisme.memberList.KYCActivity;

import bp.Utils;
import butterknife.BindView;
import butterknife.ButterKnife;
import dataModelNew.MemberListDM;
import interfaces.IObjectBoxManager;
import objectBox.KYCBusinessDetailBox;
import retrofit2.Retrofit;
import rettrofit.APIInterface;
import services.ObjectBoxManager;


public class KYCBusinessDetailActivity extends Fragment {
    private final String TAG = getClass().getName() + " Atiar - ";

    public KYCBusinessDetailActivity() {
    }

    @BindView(R.id.ed_udpadito_ponner_name)
    EditText _edUdpaditoPonnerName;
    @BindView(R.id.ed_biz_je_dhoroner_ponno_buy_and_sell_koren)
    EditText _edBizJeDhoronerPonnoBuyAndSellKoren;
    @BindView(R.id.ed_biz_business_experience)
    EditText _edBizBusinessExperience;
    @BindView(R.id.ed_biz_business_year)
    EditText _edBizBusinessYear;
    @BindView(R.id.radio_btn_tread)
    RadioButton _radioBtnTread;
    @BindView(R.id.radio_btn_utpadon)
    RadioButton _radioBtnUtpadon;
    @BindView(R.id.radio_btn_sebamulok)
    RadioButton _radioBtnSebamulok;
    @BindView(R.id.radio_biz_business_type)
    RadioGroup _radioBizBusinessType;
    @BindView(R.id.ed_biz_parmanent_male_worker)
    EditText _edBizParmanentMaleWorker;
    @BindView(R.id.ed_biz_temporary_male_worker)
    EditText _edBizTemporaryMaleWorker;
    @BindView(R.id.ed_biz_total_male_worker)
    EditText _edBizTotalMaleWorker;
    @BindView(R.id.ed_biz_parmanent_female_worker)
    EditText _edBizParmanentFemaleWorker;
    @BindView(R.id.ed_biz_temporary_female_worker)
    EditText _edBizTemporaryFemaleWorker;
    @BindView(R.id.ed_biz_total_female_worker)
    EditText _edBizTotalFemaleWorker;
    @BindView(R.id.ed_next_12_years_male_worker_prediction)
    EditText _edNext12YearsMaleWorkerPrediction;
    @BindView(R.id.ed_next_12_years_female_worker_prediction)
    EditText _edNext12YearsFemaleWorkerPrediction;
    @BindView(R.id.ed_next_12_years_total_worker_prediction)
    EditText _edNext12YearsTotalWorkerPrediction;
    @BindView(R.id.radio_btn_increase)
    RadioButton _radioBtnIncrease;
    @BindView(R.id.radio_btn_decrease)
    RadioButton _radioBtnDecrease;
    @BindView(R.id.radio_biz_last_12_months_worker)
    RadioGroup _radioBizLast12MonthsWorker;
    @BindView(R.id.ed_biz_increase_or_decrease_number)
    EditText _edLast12MonthsWorkerCount;
    @BindView(R.id.saveBizDetails)
    Button _saveBtn;


    private MemberListDM.Data member;
    Retrofit retrofit;
    APIInterface apiInterface;

    private IObjectBoxManager _objectBoxManager = new ObjectBoxManager();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_biz_details, container, false);
        ButterKnife.bind(this, view);
        member = ((KYCActivity) getActivity()).getMember();

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                loadFormIfDataAvailable();
            }
        });

        _saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToLocalStorage();
            }
        });


        return view;
    }


    private void setkycBusinessDetail(KYCBusinessDetailBox data) {
        data.setBranch_id(member.getBRANCH_ID());
        data.setMember_id(member.getMEMBER_ID());
        data.setCenter_id(member.getCENTER_ID());
        data.setProd_name(_edUdpaditoPonnerName.getText().toString());
        data.setProd_type(_edBizJeDhoronerPonnoBuyAndSellKoren.getText().toString());
        data.setCurrent_exp(_edBizBusinessExperience.getText().toString());
        data.setTotalexp(_edBizBusinessYear.getText().toString());


        data.setMale_ft(_edBizParmanentMaleWorker.getText().toString());
        data.setMale_pt(_edBizTemporaryMaleWorker.getText().toString());
        data.setFemal_eft(_edBizParmanentFemaleWorker.getText().toString());
        data.setFemal_ept(_edBizTemporaryFemaleWorker.getText().toString());

        data.setPlane_dft(_edNext12YearsMaleWorkerPrediction.getText().toString());
        data.setPlane_dpt(_edNext12YearsFemaleWorkerPrediction.getText().toString());
        data.setEmp_changed(_edLast12MonthsWorkerCount.getText().toString());


        String business_type = "";
        switch (_radioBizBusinessType.getCheckedRadioButtonId()) {
            case R.id.radio_btn_tread:
                business_type = _radioBtnTread.getText().toString();
                break;
            case R.id.radio_btn_utpadon:
                business_type = _radioBtnUtpadon.getText().toString();
                break;
            case R.id.radio_btn_sebamulok:
                business_type = _radioBtnSebamulok.getText().toString();
                break;
        }
        data.setBusiness_type(business_type);

        String last12MonthsWorker = "";
        if (_radioBtnDecrease.isChecked()) {
            last12MonthsWorker = "1";
        } else {
            last12MonthsWorker = "0";
        }
        data.setIs_reduced(last12MonthsWorker);

    }

    private void saveToLocalStorage() {

        KYCBusinessDetailBox kycBusinessDetail = _objectBoxManager.GetKYCBusinessDetailBox(member.getBRANCH_ID(), member.getMEMBER_ID());

        if (kycBusinessDetail == null) {
            KYCBusinessDetailBox newData = new KYCBusinessDetailBox();
            setkycBusinessDetail(newData);
            _objectBoxManager.SaveKYCBusinessDetailBox(newData);
        } else {
            setkycBusinessDetail(kycBusinessDetail);
            _objectBoxManager.SaveKYCBusinessDetailBox(kycBusinessDetail);
        }

        Utils.showDialog(getContext(), "Data Saved");


    }

    private void loadFormIfDataAvailable() {
        KYCBusinessDetailBox data = _objectBoxManager.GetKYCBusinessDetailBox(member.getBRANCH_ID(), member.getMEMBER_ID());

        if (data != null) {
            _edBizJeDhoronerPonnoBuyAndSellKoren.setText(data.getProd_type());
            _edBizBusinessExperience.setText(data.getCurrent_exp());
            _edBizBusinessYear.setText(data.getTotalexp());

            _edUdpaditoPonnerName.setText(data.getProd_name());
            _edBizParmanentMaleWorker.setText(data.getMale_ft());
            _edBizTemporaryMaleWorker.setText(data.getMale_pt());

            if (data.getMale_ft().equals("") || data.getMale_pt().equals("")) {
                _edBizTotalMaleWorker.setText("");
            } else {
                _edBizTotalMaleWorker.setText((Integer.parseInt(data.getMale_ft()) + Integer.parseInt(data.getMale_pt())) + "");
            }

            _edBizParmanentFemaleWorker.setText(data.getFemal_eft());
            _edBizTemporaryFemaleWorker.setText(data.getFemal_ept());
            if (data.getFemal_eft().equals("") || data.getFemal_ept().equals("")) {
                _edBizTotalFemaleWorker.setText("");
            } else {
                _edBizTotalFemaleWorker.setText((Integer.parseInt(data.getFemal_eft()) + Integer.parseInt(data.getFemal_ept())) + "");
            }
            _edNext12YearsMaleWorkerPrediction.setText(data.getPlane_dft());
            _edNext12YearsFemaleWorkerPrediction.setText(data.getPlane_dpt());

            if (data.getPlane_dft().equals("") || data.getPlane_dpt().equals("")) {
                _edNext12YearsTotalWorkerPrediction.setText("");
            } else {
                _edNext12YearsTotalWorkerPrediction.setText((Integer.parseInt(data.getPlane_dft()) + Integer.parseInt(data.getPlane_dpt())) + "");
            }
            _edNext12YearsTotalWorkerPrediction.setTextColor(Color.BLACK);
            _edLast12MonthsWorkerCount.setText(data.getEmp_changed() + "");
            _radioBizLast12MonthsWorker.check((data.getIs_reduced().equals("1")) ? _radioBtnDecrease.getId() : _radioBtnIncrease.getId());


            if (data.getBusiness_type().trim().equals(getString(R.string.biz_tread).trim())) {
                Log.e(TAG, "match tread");
                _radioBizBusinessType.check(_radioBtnTread.getId());
            }
            if (data.getBusiness_type().trim().equals(getString(R.string.biz_utpadon_mukhi).trim())) {
                Log.e(TAG, "match utpadon");
                _radioBizBusinessType.check(R.id.radio_btn_utpadon);
            }
            if (data.getBusiness_type().trim().equals(getString(R.string.biz_seba_mulok).trim())) {
                Log.e(TAG, "match sebamulok");
                _radioBizBusinessType.check(R.id.radio_btn_sebamulok);
            }

            _radioBizLast12MonthsWorker.check((data.getIs_reduced().equals("1")) ? _radioBtnDecrease.getId() : _radioBtnIncrease.getId());


        }

    }
}
