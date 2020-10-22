package ei.eseptiyadi.caffeqita.network;

import ei.eseptiyadi.caffeqita.model.ResponseDetailTransaksi;
import ei.eseptiyadi.caffeqita.model.ResponseListMenu;
import ei.eseptiyadi.caffeqita.model.ResponseListTransaksi;
import ei.eseptiyadi.caffeqita.model.ResponseTotalTransaksi;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiServices {

    @GET("list_transaksi.php")
    Call<ResponseListTransaksi> listtransaksi();

    @GET("list_menu.php")
    Call<ResponseListMenu> listmenu();

    @FormUrlEncoded
    @POST("detail_transaksi.php")
    Call<ResponseDetailTransaksi> detailtransaksi(
            @Field("kode_transaksi") String kodetransaksi
    );

    @GET("initialdata_transaksi.php")
    Call<ResponseTotalTransaksi> totaldatatransaksi();

}
