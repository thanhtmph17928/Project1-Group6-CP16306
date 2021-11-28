package manga.readder.Model;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Chapter implements Serializable {
    private String id;
    private String tenChap;
    private String idTruyen;
    private String link;

    public Chapter() {
    }

    public Chapter(String id, String tenChap, String idTruyen, String link) {
        this.id = id;
        this.tenChap = tenChap;
        this.idTruyen = idTruyen;
        this.link = link;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenChap() {
        return tenChap;
    }

    public void setTenChap(String tenChap) {
        this.tenChap = tenChap;
    }

    public String getIdTruyen() {
        return idTruyen;
    }

    public void setIdTruyen(String idTruyen) {
        this.idTruyen = idTruyen;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    public Chapter(JSONObject o) throws JSONException {
        id = o.getString("id");
        tenChap = o.getString("tenChap");
        idTruyen = o.getString("idTruyen");
        link = o.getString("link");
    }
}
