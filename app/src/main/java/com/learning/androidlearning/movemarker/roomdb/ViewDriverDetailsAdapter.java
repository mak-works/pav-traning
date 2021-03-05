package com.learning.androidlearning.movemarker.roomdb;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.learning.androidlearning.R;

import java.util.List;

public class ViewDriverDetailsAdapter extends RecyclerView.Adapter<ViewDriverDetailsAdapter.ViewHolder> {
    private List<DriverDetails> driverDetails;
    private String TAG= ViewDriverDetailsAdapter.class.getSimpleName();
    private Context context;

    public ViewDriverDetailsAdapter(Context context, List<DriverDetails> driverDetails) {
        this.driverDetails = driverDetails;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.listitem_driverdetails, parent, false);
        return new ViewDriverDetailsAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tvDriverid.setText(String.valueOf(driverDetails.get(position).getDriverId()));
        holder.tvMobileNumber.setText(String.valueOf(driverDetails.get(position).getMobileNumber()));
        holder.tvName.setText(String.valueOf(driverDetails.get(position).getName()));
        holder.tvDate.setText(driverDetails.get(position).getDate().toString());
        Log.d(TAG, "date: "+driverDetails.get(position).getDate().toString());
    }

    @Override
    public int getItemCount() {
        return driverDetails.size();
    }

    /**
     * View holder class member this contains in every row in list.
     */

    public class ViewHolder extends RecyclerView.ViewHolder {
       TextView tvDriverid,tvMobileNumber,tvName,tvDate;

        public ViewHolder(View itemView) {
            super(itemView);
            tvDriverid = itemView.findViewById(R.id.tv_driverid);
            tvMobileNumber = itemView.findViewById(R.id.tv_mobileNumber);
            tvName = itemView.findViewById(R.id.tv_name);
            tvDate=itemView.findViewById(R.id.tv_date);
        }
    }
}
