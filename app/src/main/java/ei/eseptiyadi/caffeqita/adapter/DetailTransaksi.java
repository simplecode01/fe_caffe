package ei.eseptiyadi.caffeqita.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ei.eseptiyadi.caffeqita.R;
import ei.eseptiyadi.caffeqita.model.DetailTransaksiItem;

public class DetailTransaksi extends RecyclerView.Adapter<DetailTransaksi.MyViewHolder> {

    Context context;
    List<DetailTransaksiItem> detailTransaksiList;

    public DetailTransaksi(Context context, List<DetailTransaksiItem> detailTransaksiList) {
        this.context = context;
        this.detailTransaksiList = detailTransaksiList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_detailtransaksi, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tviewNamaPembeli.setText(detailTransaksiList.get(position).getNamaPelanggan());
        holder.tviewTotalBayar.setText(detailTransaksiList.get(position).getTotalBayar());
        holder.tviewMetodeBayar.setText(detailTransaksiList.get(position).getMetodePembayaran());
        holder.tviewTotalUangCash.setText(detailTransaksiList.get(position).getTotalCash());
        holder.tviewUangKembali.setText(detailTransaksiList.get(position).getUangKembalian());

    }

    @Override
    public int getItemCount() {
        return detailTransaksiList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tviewNamaPembeli, tviewTotalBayar, tviewMetodeBayar, tviewTotalUangCash, tviewUangKembali;

        public MyViewHolder(View itemView) {
            super(itemView);

            tviewNamaPembeli = (TextView)itemView.findViewById(R.id.txGNamaPelanggan);
            tviewTotalBayar = (TextView)itemView.findViewById(R.id.txGTotalBayar);
            tviewMetodeBayar = (TextView)itemView.findViewById(R.id.txGMetodeBayar);
            tviewTotalUangCash = (TextView)itemView.findViewById(R.id.txGTotalCash);
            tviewUangKembali = (TextView)itemView.findViewById(R.id.txGUangKembalian);
        }
    }
}
