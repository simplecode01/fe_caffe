package ei.eseptiyadi.caffeqita.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import ei.eseptiyadi.caffeqita.R;
import ei.eseptiyadi.caffeqita.model.ListMenuItem;
import ei.eseptiyadi.caffeqita.model.ListtransaksiItem;
import ei.eseptiyadi.caffeqita.views.DetailTransaksiActivity;

public class ListMenu extends RecyclerView.Adapter<ListMenu.MyViewHolder> {

    Context context;
    List<ListMenuItem> listMenuItems;

    public ListMenu(Context context, List<ListMenuItem> ListMenuItems) {
        this.context = context;
        this.listMenuItems= ListMenuItems;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_listmenu, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }
    @Override
    public void onBindViewHolder(ListMenu.MyViewHolder holder, int position) {
        holder.tvKodeNamaMenu.setText(listMenuItems.get(position).getKodeNama());
        holder.tvKodeHargaMenu.setText(listMenuItems.get(position).getHargamenu());
        holder.tvKodeKategori.setText(listMenuItems.get(position).getKategori());

        String name_of_image = listMenuItems.get(position).getImgMenu();

        String link_image = "https://wisataindonesiarbs.000webhostapp.com/caffe/picturemenu/" + name_of_image;

        Glide.with(context).load(link_image).into(holder.imgMenu);




        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Data yang ada pilih adalah kode transaksi " + listMenuItems.get(position).getKodeNama(), Toast.LENGTH_SHORT).show();
                kirimKodeTransaksi2Detail(listMenuItems.get(position).getKodeNama());
            }
        });
    }



    @Override
    public int getItemCount() {
        return listMenuItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imgMenu;
        TextView tvKodeNamaMenu, tvKodeHargaMenu, tvKodeKategori;

        public MyViewHolder(View itemView) {
            super(itemView);
            imgMenu = (ImageView)itemView.findViewById(R.id.IvMenu);
            tvKodeNamaMenu = (TextView)itemView.findViewById(R.id.tvKodeNamaMenu);
            tvKodeHargaMenu = (TextView)itemView.findViewById(R.id.tvKodeHargaMenu);
            tvKodeKategori = (TextView)itemView.findViewById(R.id.tvKodeKategori);
        }
    }
    public void kirimKodeTransaksi2Detail(String kodemenu) {
        //Intent kirimKode = new Intent(context, DetailTransaksiActivity.class);
        //kirimKode.putExtra("KODE_MENU", kodemenu);
        //context.startActivity(kirimKode);
    }

}
