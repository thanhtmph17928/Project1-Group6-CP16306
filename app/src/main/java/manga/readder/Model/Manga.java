package manga.readder.Model;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Manga implements Serializable {
    private String tenTruyen;
    private String anh;
    private String nguon;
    private String tacGia;
    private String theLoai;
    private String soChap;
    private String ngay;

    public Manga() {
    }

    public Manga(JSONObject o) throws JSONException{
        tenTruyen = o.getString("tenTruyen");
        anh = o.getString("anh");
        nguon = o.getString("nguon");
        tacGia = o.getString("tacGia");
        theLoai = o.getString("theLoai");
        soChap = o.getString("soChap");
        ngay = o.getString("ngay");
    }

    public Manga(String tenTruyen, String anh, String nguon, String tacGia, String theLoai, String soChap, String ngay) {
        this.tenTruyen = tenTruyen;
        this.anh = anh;
        this.nguon = nguon;
        this.tacGia = tacGia;
        this.theLoai = theLoai;
        this.soChap = soChap;
        this.ngay = ngay;
    }

    public String getTenTruyen() {
        return tenTruyen;
    }

    public void setTenTruyen(String tenTruyen) {
        this.tenTruyen = tenTruyen;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getNguon() {
        return nguon;
    }

    public void setNguon(String nguon) {
        this.nguon = nguon;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getSoChap() {
        return soChap;
    }

    public void setSoChap(String soChap) {
        this.soChap = soChap;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }
}
