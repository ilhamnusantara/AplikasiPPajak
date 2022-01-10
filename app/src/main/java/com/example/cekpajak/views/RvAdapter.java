package com.example.cekpajak.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cekpajak.R;
import com.example.cekpajak.models.Tax;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MViewHolder> {
    private Context context;
    private ArrayList<Tax> listTax;

    public RvAdapter(ArrayList<Tax> list) {
        this.listTax = list;
    }

    public class MViewHolder extends RecyclerView.ViewHolder{

        TextView tvUserID;
        TextView tvTaxName;
        TextView tvBillingID;
        TextView tvNTPN;
        TextView tvTaxAmount;

        public MViewHolder(@NonNull View itemView){
            super(itemView);
            tvTaxName = itemView.findViewById(R.id.taxName);
            tvBillingID = itemView.findViewById(R.id.billingiD);
            tvNTPN = itemView.findViewById(R.id.ntpnNumber);
            tvTaxAmount = itemView.findViewById(R.id.taxAmount);
        }
    }

    public ArrayList<Tax> getListTax() {
        return listTax;
    }

    public void setListTax(ArrayList<Tax> listTax) {
        this.listTax = listTax;
    }

    @Override
    public MViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_ntpn_data,viewGroup,false);
        return new MViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(MViewHolder mViewHolder, int position) {
        mViewHolder.tvTaxName.setText(getListTax().get(position).getTaxName());
//        mViewHolder.tvUserID.setText(getListTax().get(position).getUser_id());
        mViewHolder.tvBillingID.setText(getListTax().get(position).getBillingID());
        String ntpnText = "(Settled. No: " +getListTax().get(position).getNtpn() + ")";
        mViewHolder.tvNTPN.setText(ntpnText);
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        nf.setMaximumFractionDigits(0);
        nf.setCurrency(Currency.getInstance("IDR"));

        String taxAmount  = nf.format(getListTax().get(position).getTaxAmount());
        mViewHolder.tvTaxAmount.setText(taxAmount);
    }

    @Override
    public int getItemCount() {
        return getListTax().size();
    }


}
