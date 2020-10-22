package ei.eseptiyadi.caffeqita.views;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import ei.eseptiyadi.caffeqita.R;
import ei.eseptiyadi.caffeqita.adapter.ListTransaksi;
import ei.eseptiyadi.caffeqita.model.ListtransaksiItem;
import ei.eseptiyadi.caffeqita.model.ResponseListTransaksi;
import ei.eseptiyadi.caffeqita.model.ResponseTotalTransaksi;
import ei.eseptiyadi.caffeqita.network.ApiServices;
import ei.eseptiyadi.caffeqita.network.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListTransaksiActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SwipeRefreshLayout swfLayoutRefreshTransaksi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listtransaksi);

        recyclerView = (RecyclerView)findViewById(R.id.rvListTransaksi);
        swfLayoutRefreshTransaksi = (SwipeRefreshLayout)findViewById(R.id.srlListTransaksiRefresh);
        swfLayoutRefreshTransaksi.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                // Do Action
                getUpdateListTransaksi();
            }
        });

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        getListTransaksi();
    }

    private void getListTransaksi() {
        ApiServices apiServices = RetrofitClient.getInstance();
        Call<ResponseListTransaksi> listTransaksiCall = apiServices.listtransaksi();

        listTransaksiCall.enqueue(new Callback<ResponseListTransaksi>() {
            @Override
            public void onResponse(Call<ResponseListTransaksi> call, Response<ResponseListTransaksi> response) {
                if (response.isSuccessful()) {
                    List<ListtransaksiItem> listtransaksiItems = response.body().getListtransaksi();
                    boolean status = response.body().isStatus();
                    if (status == true) {
                        ListTransaksi adapterListtransaksi = new ListTransaksi(ListTransaksiActivity.this, listtransaksiItems);
                        recyclerView.setAdapter(adapterListtransaksi);
                        Log.d("LOG", "Data : " + response.body().getListtransaksi() + "\n");
                    } else {
                        Toast.makeText(ListTransaksiActivity.this, "Masalah otentikasi sistem", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseListTransaksi> call, Throwable t) {
                Toast.makeText(ListTransaksiActivity.this, "ERROR " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getUpdateListTransaksi() {
        ApiServices apiServices = RetrofitClient.getInstance();
        Call<ResponseListTransaksi> listTransaksiCall = apiServices.listtransaksi();

        listTransaksiCall.enqueue(new Callback<ResponseListTransaksi>() {
            @Override
            public void onResponse(Call<ResponseListTransaksi> call, Response<ResponseListTransaksi> response) {
                if (response.isSuccessful()) {
                    List<ListtransaksiItem> listtransaksiItems = response.body().getListtransaksi();
                    boolean status = response.body().isStatus();
                    if (status == true) {
                        ListTransaksi adapterListtransaksi = new ListTransaksi(ListTransaksiActivity.this, listtransaksiItems);
                        recyclerView.setAdapter(adapterListtransaksi);
                        Toast.makeText(ListTransaksiActivity.this, "Data list transaksi berhasil diperbaharui", Toast.LENGTH_SHORT).show();
                        swfLayoutRefreshTransaksi.setRefreshing(false);
                    } else {
                        Toast.makeText(ListTransaksiActivity.this, "Galat!, Masalah otentikasi sistem", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseListTransaksi> call, Throwable t) {
                Toast.makeText(ListTransaksiActivity.this, "ERROR " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void FABaddTransaksi(View view) {
        // Toast.makeText(this, "Ini tombol tambah transaksi", Toast.LENGTH_SHORT).show();

        ApiServices apiServices = RetrofitClient.getInstance();
        Call<ResponseTotalTransaksi> totalDataTransaksiCall = apiServices.totaldatatransaksi();

        totalDataTransaksiCall.enqueue(new Callback<ResponseTotalTransaksi>() {
            @Override
            public void onResponse(Call<ResponseTotalTransaksi> call, Response<ResponseTotalTransaksi> response) {

                AlertDialog.Builder builderDialog = new AlertDialog.Builder(ListTransaksiActivity.this);

                if (response.isSuccessful()) {
                    String totaldata_transaksi = response.body().getTotaldataTransaksisaatini();
                    String kode_unique = response.body().getKodeUnique();
                    String tanggal_tambah = response.body().getGetdateTime();
                    // Toast.makeText(ListTransaksiActivity.this, "Total data transaksi saat ini " + totaldata_transaksi, Toast.LENGTH_SHORT).show();

                    int newkodetransaksi = Integer.valueOf(totaldata_transaksi) + 1;
                    // Toast.makeText(ListTransaksiActivity.this, "Kode transaksi kita yang baru adalah " + kode_unique + "-" + tanggal_tambah + "-" + newkodetransaksi, Toast.LENGTH_SHORT).show();

                    builderDialog
                            .setTitle("Transaksi Baru")
                            .setMessage("Kode transaksi kita yang baru adalah " + kode_unique + "-" + tanggal_tambah + "-" + newkodetransaksi)
                            .setPositiveButton("Lanjutkan Transaksi", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            })
                            .setNegativeButton("Batalkan", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            });
                    AlertDialog alertDialog = builderDialog.create();
                    alertDialog.show();
                }
            }

            @Override
            public void onFailure(Call<ResponseTotalTransaksi> call, Throwable t) {

            }
        });



    }
}