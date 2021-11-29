package manga.readder.DB;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import manga.readder.Model.Manga;

public class YeuThichDAO {
    private final SQLiteDatabase db;

    public YeuThichDAO(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    //insert
    public long insert(Manga obj) {
        ContentValues values = new ContentValues();
        values.put("idYeuThich", obj.getId());
        values.put("tenTruyen", obj.getTenTruyen());
        values.put("anh", obj.getAnh());
        values.put("nguon", obj.getNguon());
        values.put("tacGia", obj.getTacGia());
        values.put("theLoai", obj.getTheLoai());
        values.put("soChap", obj.getSoChap());
        values.put("ngay", obj.getNgay());
        values.put("luotXem", obj.getLuotXem());

        return db.insert("YeuThich", null, values);
    }

    //update
    public int update(Manga obj) {
        ContentValues values = new ContentValues();
        values.put("idYeuThich", obj.getId());
        values.put("tenTruyen", obj.getTenTruyen());
        values.put("anh", obj.getAnh());
        values.put("nguon", obj.getNguon());
        values.put("tacGia", obj.getTacGia());
        values.put("theLoai", obj.getTheLoai());
        values.put("soChap", obj.getSoChap());
        values.put("ngay", obj.getNgay());
        values.put("luotXem", obj.getLuotXem());

        return db.update("YeuThich", values, "idYeuThich=?", new String[]{String.valueOf(obj.getId())});
    }

    //delete
    public void delete(String id) {
        db.delete("YeuThich", "idYeuThich=?", new String[]{id});
    }

    // get tat ca data
    public List<Manga> getAll() {
        String sql = "SELECT * FROM YeuThich";
        return getData(sql);
    }


    //getData theo id
    public Manga getID(String id) {
        String sql = "SELECT * FROM YeuThich WHERE idYeuThich=?";
        List<Manga> mangaList = getData(sql, id);
        return mangaList.get(0);
    }

    private List<Manga> getData(String sql, String... selectionArgs) {
        List<Manga> list = new ArrayList<>();
        @SuppressLint("Recycle") Cursor c = db.rawQuery(sql, selectionArgs);
        while (c.moveToNext()) {
            Manga obj = new Manga();
            obj.setId(c.getString(c.getColumnIndex("idYeuThich")));
            obj.setTenTruyen(c.getString(c.getColumnIndex("tenTruyen")));
            obj.setAnh(c.getString(c.getColumnIndex("anh")));
            obj.setNguon(c.getString(c.getColumnIndex("nguon")));
            obj.setTacGia(c.getString(c.getColumnIndex("tacGia")));
            obj.setTheLoai(c.getString(c.getColumnIndex("theLoai")));
            obj.setSoChap(c.getString(c.getColumnIndex("soChap")));
            obj.setNgay(c.getString(c.getColumnIndex("ngay")));
            obj.setLuotXem(c.getString(c.getColumnIndex("luotXem")));

            list.add(obj);
        }
        return list;
    }
    public int checkExists(String id) {
        int check = 1;
        String getMG = "SELECT * FROM YeuThich WHERE idYeuThich ="+id;
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery(getMG, null);
        if (cursor.getCount() != 0) {
            check = -1;
        }
        return check;
    }


}


