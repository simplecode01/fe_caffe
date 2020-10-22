package ei.eseptiyadi.caffeqita.model;

import com.google.gson.annotations.SerializedName;

public class ListMenuItem{

    @SerializedName("nama_menu")
    private String namamenu;

    @SerializedName("harga_menu")
    private String hargamenu;

    @SerializedName("kategori")
    private String kategori;

    @SerializedName("img_menu")
    private String imgMenu;

    public String getKodeNama(){
        return namamenu;
    }

    public String getHargamenu(){
        return hargamenu;
    }

    public String getKategori(){
        return kategori;
    }

    public String getImgMenu(){
        return imgMenu;
    }

    @Override
    public String toString(){
        return
                "ListtransaksiItem{" +
                        "kode_transaksi = '" + namamenu + '\'' +
                        ",metode_pembayaran = '" + hargamenu + '\'' +
                        ",total_cash = '" + kategori + '\'' +
                        ",img_menu = '" + imgMenu + '\'' +
                        "}";
    }
}