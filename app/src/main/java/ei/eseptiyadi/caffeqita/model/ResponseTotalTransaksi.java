package ei.eseptiyadi.caffeqita.model;

import com.google.gson.annotations.SerializedName;

public class ResponseTotalTransaksi{

	@SerializedName("code")
	private int code;

	@SerializedName("message")
	private String message;

	@SerializedName("totaldata_transaksisaatini")
	private String totaldataTransaksisaatini;

	@SerializedName("kode_unique")
	private String kodeUnique;

	@SerializedName("getdate_time")
	private String getdateTime;

	@SerializedName("status")
	private boolean status;

	public int getCode(){
		return code;
	}

	public String getMessage(){
		return message;
	}

	public String getTotaldataTransaksisaatini(){
		return totaldataTransaksisaatini;
	}

	public String getKodeUnique(){
		return kodeUnique;
	}

	public String getGetdateTime(){
		return getdateTime;
	}

	public boolean isStatus(){
		return status;
	}
}