package ei.eseptiyadi.caffeqita.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseListMenu{

    @SerializedName("code")
    private int code;

    @SerializedName("listmenu")
    private List<ListMenuItem> listmenu;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private boolean status;

    public int getCode(){
        return code;
    }

    public List<ListMenuItem> getListmenu(){
        return listmenu;
    }

    public String getMessage(){
        return message;
    }

    public boolean isStatus(){
        return status;
    }

    @Override
    public String toString(){
        return
                "ResponseListMenu{" +
                        "code = '" + code + '\'' +
                        ",listmenu = '" + listmenu + '\'' +
                        ",message = '" + message + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}