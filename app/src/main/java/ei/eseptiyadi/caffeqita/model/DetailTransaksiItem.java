package ei.eseptiyadi.caffeqita.model;

import com.google.gson.annotations.SerializedName;

public class DetailTransaksiItem{

	@SerializedName("kode_transaksi")
	private String kodeTransaksi;

	@SerializedName("metode_pembayaran")
	private String metodePembayaran;

	@SerializedName("nama_pelanggan")
	private String namaPelanggan;

	@SerializedName("total_cash")
	private String totalCash;

	@SerializedName("uang_kembalian")
	private String uangKembalian;

	@SerializedName("total_bayar")
	private String totalBayar;

	public void setKodeTransaksi(String kodeTransaksi){
		this.kodeTransaksi = kodeTransaksi;
	}

	public String getKodeTransaksi(){
		return kodeTransaksi;
	}

	public void setMetodePembayaran(String metodePembayaran){
		this.metodePembayaran = metodePembayaran;
	}

	public String getMetodePembayaran(){
		return metodePembayaran;
	}

	public void setNamaPelanggan(String namaPelanggan){
		this.namaPelanggan = namaPelanggan;
	}

	public String getNamaPelanggan(){
		return namaPelanggan;
	}

	public void setTotalCash(String totalCash){
		this.totalCash = totalCash;
	}

	public String getTotalCash(){
		return totalCash;
	}

	public void setUangKembalian(String uangKembalian){
		this.uangKembalian = uangKembalian;
	}

	public String getUangKembalian(){
		return uangKembalian;
	}

	public void setTotalBayar(String totalBayar){
		this.totalBayar = totalBayar;
	}

	public String getTotalBayar(){
		return totalBayar;
	}

	@Override
 	public String toString(){
		return 
			"DetailTransaksiItem{" + 
			"kode_transaksi = '" + kodeTransaksi + '\'' + 
			",metode_pembayaran = '" + metodePembayaran + '\'' + 
			",nama_pelanggan = '" + namaPelanggan + '\'' + 
			",total_cash = '" + totalCash + '\'' + 
			",uang_kembalian = '" + uangKembalian + '\'' + 
			",total_bayar = '" + totalBayar + '\'' + 
			"}";
		}
}