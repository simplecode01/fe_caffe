package ei.eseptiyadi.caffeqita.views;

import  androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import ei.eseptiyadi.caffeqita.R;
import ei.eseptiyadi.caffeqita.adapter.ListMenu;
import ei.eseptiyadi.caffeqita.adapter.ListTransaksi;
import ei.eseptiyadi.caffeqita.model.ListMenuItem;
import ei.eseptiyadi.caffeqita.model.ListtransaksiItem;
import ei.eseptiyadi.caffeqita.model.ResponseListMenu;
import ei.eseptiyadi.caffeqita.model.ResponseListTransaksi;
import ei.eseptiyadi.caffeqita.network.ApiServices;
import ei.eseptiyadi.caffeqita.network.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListMenuActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SwipeRefreshLayout swfLayoutRefreshMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_menu);

        recyclerView = (RecyclerView) findViewById(R.id.rvListMenu);
        swfLayoutRefreshMenu = (SwipeRefreshLayout) findViewById(R.id.srlMenuRefresh);
        swfLayoutRefreshMenu.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                // Do Action
                getUpdateListMenu();
            }
        });

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        getListMenu();
    }

    private void getListMenu() {
        ApiServices apiServices = RetrofitClient.getInstance();
        Call<ResponseListMenu> listMenuCall = apiServices.listmenu();

        listMenuCall.enqueue(new Callback<ResponseListMenu>() {
            @Override
            public void onResponse(Call<ResponseListMenu> call, Response<ResponseListMenu> response) {
                if (response.isSuccessful()) {
                    List<ListMenuItem> listmenuItems = response.body().getListmenu();
                    boolean status = response.body().isStatus();
                    if (status == true) {
                        ListMenu adapterListmenu = new ListMenu(ListMenuActivity.this, listmenuItems);
                        recyclerView.setAdapter(adapterListmenu);
                        Log.d("LOG", "Data : " + response.body().getListmenu() + "\n");
                    } else {
                        Toast.makeText(ListMenuActivity.this, "Masalah otentikasi sistem", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseListMenu> call, Throwable t) {
                Toast.makeText(ListMenuActivity.this, "ERROR " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void getUpdateListMenu() {
        ApiServices apiServices = RetrofitClient.getInstance();
        Call<ResponseListMenu> listMenuCall = apiServices.listmenu();

        listMenuCall.enqueue(new Callback<ResponseListMenu>() {
            @Override
            public void onResponse(Call<ResponseListMenu> call, Response<ResponseListMenu> response) {
                if (response.isSuccessful()) {
                    List<ListMenuItem> listmenuItems = response.body().getListmenu();
                    boolean status = response.body().isStatus();
                    if (status == true) {
                        ListMenu adapterListmenu = new ListMenu(ListMenuActivity.this, listmenuItems);
                        recyclerView.setAdapter(adapterListmenu);
                        Toast.makeText(ListMenuActivity.this, "Data list menu berhasil diperbaharui", Toast.LENGTH_SHORT).show();
                        swfLayoutRefreshMenu.setRefreshing(false);
                    } else {
                        Toast.makeText(ListMenuActivity.this, "Gawat!, Masalah otentikasi sistem", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseListMenu> call, Throwable t) {
                Toast.makeText(ListMenuActivity.this, "ERROR " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
