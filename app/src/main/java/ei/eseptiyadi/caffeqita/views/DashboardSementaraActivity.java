package ei.eseptiyadi.caffeqita.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ei.eseptiyadi.caffeqita.R;

public class DashboardSementaraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_sementara);
    }

    public void ToListMenu(View view) {
        Intent abc = new Intent(DashboardSementaraActivity.this, ListMenuActivity.class);
        startActivity(abc);
    }

    public void ToTransaksi(View view) {
        Intent abc = new Intent(DashboardSementaraActivity.this, ListTransaksiActivity.class);
        startActivity(abc);
    }
}