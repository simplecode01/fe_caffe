package ei.eseptiyadi.caffeqita.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseDetailTransaksi{

	@SerializedName("code")
	private int code;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	@SerializedName("detail_transaksi")
	private List<DetailTransaksiItem> detailTransaksi;

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	public void setDetailTransaksi(List<DetailTransaksiItem> detailTransaksi){
		this.detailTransaksi = detailTransaksi;
	}

	public List<DetailTransaksiItem> getDetailTransaksi(){
		return detailTransaksi;
	}

	@Override
 	public String toString(){
		return 
			"ResponseDetailTransaksi{" + 
			"code = '" + code + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			",detail_transaksi = '" + detailTransaksi + '\'' + 
			"}";
		}
}