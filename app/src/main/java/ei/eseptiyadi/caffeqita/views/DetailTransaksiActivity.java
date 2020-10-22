package ei.eseptiyadi.caffeqita.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ei.eseptiyadi.caffeqita.R;
import ei.eseptiyadi.caffeqita.adapter.DetailTransaksi;
import ei.eseptiyadi.caffeqita.model.DetailTransaksiItem;
import ei.eseptiyadi.caffeqita.model.ResponseDetailTransaksi;
import ei.eseptiyadi.caffeqita.network.ApiServices;
import ei.eseptiyadi.caffeqita.network.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailTransaksiActivity extends AppCompatActivity {

    TextView txKodeTransaksi;
    RecyclerView rvDetailTransaksi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_transaksi);

        Intent getIntent = getIntent();
        String getKodeTransaksi = getIntent.getStringExtra("KODE_TRANSAKSI");

        txKodeTransaksi = (TextView)findViewById(R.id.txtKodeTransaksi);
        txKodeTransaksi.setText(getKodeTransaksi);

        rvDetailTransaksi = (RecyclerView)findViewById(R.id.rvDetailTransaksi);
        rvDetailTransaksi.setHasFixedSize(true);
        rvDetailTransaksi.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        showDetailTransaksi(getKodeTransaksi);
    }

    private void showDetailTransaksi(String getKodeTransaksi) {
        ApiServices apiServices = RetrofitClient.getInstance();
        Call<ResponseDetailTransaksi> responseDetailTransaksiCall = apiServices.detailtransaksi(getKodeTransaksi);

        responseDetailTransaksiCall.enqueue(new Callback<ResponseDetailTransaksi>() {
            @Override
            public void onResponse(Call<ResponseDetailTransaksi> call, Response<ResponseDetailTransaksi> response) {
                if (response.isSuccessful()) {
                    List<DetailTransaksiItem> detailTransaksiItems = response.body().getDetailTransaksi();
                    boolean status = response.body().isStatus();

                    if (status == true) {
                        DetailTransaksi adapterDetailTransaksi = new DetailTransaksi(DetailTransaksiActivity.this, detailTransaksiItems);
                        rvDetailTransaksi.setAdapter(adapterDetailTransaksi);
                        Toast.makeText(DetailTransaksiActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(DetailTransaksiActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseDetailTransaksi> call, Throwable t) {
                Toast.makeText(DetailTransaksiActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void RefreshDetailMenu() {

    }
}