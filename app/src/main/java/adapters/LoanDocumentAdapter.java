package adapters;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.sfdw.shaktisme.R;

import java.util.List;

import objectBox.LoanDocumentBox;
import services.ObjectBoxManager;
import services.ServiceManager;

public class LoanDocumentAdapter extends RecyclerView.Adapter<LoanDocumentAdapter.MyViewHolder> {
    private final String TAG = getClass().getName() + " Atiar - ";

    private List<LoanDocumentBox> _loanDocumenList;
    ServiceManager _serviceManager;
    ObjectBoxManager _objectBoxManager;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView _documentImage;
        public TextView _documentType, _documentName;
        public Button _btnRemoveDoc;

        public MyViewHolder(View view) {
            super(view);
            _documentImage = view.findViewById(R.id.document);
            _documentType = view.findViewById(R.id.docType);
            _documentName = view.findViewById(R.id.docComments);
            _btnRemoveDoc = view.findViewById(R.id.btnRemoveDoc);
            this.setIsRecyclable(false);
        }
    }

    public LoanDocumentAdapter(List<LoanDocumentBox> documentsList) {
        this._loanDocumenList = documentsList;
        _serviceManager = new ServiceManager();
        _objectBoxManager = new ObjectBoxManager();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_documents_list_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        LoanDocumentBox documentBox = _loanDocumenList.get(position);

        holder._documentType.setText(_serviceManager.getDocumentTypeName(documentBox.getDOC_TYPE_ID()));
        holder._documentName.setText(documentBox.getDOC_NAME());
        if(documentBox.getDOC() != null)
        {
            try {
                byte[] decodedString = Base64.decode(documentBox.getDOC(), Base64.DEFAULT);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 8;

                Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                holder._documentImage.setImageBitmap(decodedByte);
            }catch (Exception e){
                e.printStackTrace();
            }

        }

        holder._btnRemoveDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _loanDocumenList.remove(position);
                _objectBoxManager.RemoveLoanDocumentBox(documentBox);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (_loanDocumenList == null) {
            return 0;
        }
        return _loanDocumenList.size();

    }

}