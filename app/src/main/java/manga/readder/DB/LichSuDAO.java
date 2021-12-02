package manga.readder.DB;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import manga.readder.Model.LichSu;

public class LichSuDAO {
    private final SQLiteDatabase db;

    public LichSuDAO(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    //insert
    public long insert(LichSu obj) {
        ContentValues values = new ContentValues();
        values.put("idLichSu", obj.getId());
        values.put("tenTruyen", obj.getTenTruyen());
        values.put("anh", obj.getAnh());
        values.put("nguon", obj.getNguon());
        values.put("tacGia", obj.getTacGia());
        values.put("theLoai", obj.getTheLoai());
        values.put("soChap", obj.getSoChap());
        values.put("luotXem", obj.getLuotXem());
        values.put("ngay", obj.getNgay());
        values.put("thoiGian", String.valueOf(obj.getThoiGian()));

        return db.insert("LichSu", null, values);
    }

    //delete
    public void delete(String id) {
        db.delete("LichSu", "idLichSu=?", new String[]{id});
    }

    // get tat ca data
    public List<LichSu> getAll() {
        String sql = "SELECT * FROM LichSu";
        return getData(sql);
    }


    private List<LichSu> getData(String sql, String... selectionArgs) {
        List<LichSu> list = new ArrayList<>();
        @SuppressLint("Recycle") Cursor c = db.rawQuery(sql, selectionArgs);
        while (c.moveToNext()) {
            LichSu obj = new LichSu();
            obj.setId(c.getString(c.getColumnIndex("idLichSu")));
            obj.setTenTruyen(c.getString(c.getColumnIndex("tenTruyen")));
            obj.setAnh(c.getString(c.getColumnIndex("anh")));
            obj.setNguon(c.getString(c.getColumnIndex("nguon")));
            obj.setTacGia(c.getString(c.getColumnIndex("tacGia")));
            obj.setTheLoai(c.getString(c.getColumnIndex("theLoai")));
            obj.setSoChap(c.getString(c.getColumnIndex("soChap")));
            obj.setNgay(c.getString(c.getColumnIndex("ngay")));
            obj.setLuotXem(c.getString(c.getColumnIndex("luotXem")));
            obj.setThoiGian(java.sql.Date.valueOf(c.getString(c.getColumnIndex("thoiGian"))));
            list.add(obj);
        }
        return list;
    }


}


