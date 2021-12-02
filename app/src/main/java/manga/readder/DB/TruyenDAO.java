package manga.readder.DB;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import manga.readder.Model.Manga;

public class TruyenDAO {
    private final SQLiteDatabase db;


    public TruyenDAO(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    //insert
    public long insert(Manga obj) {
        ContentValues values = new ContentValues();
        values.put("tenTruyen", obj.getTenTruyen());
        values.put("anh", obj.getAnh());
        values.put("nguon", obj.getNguon());
        values.put("tacGia", obj.getTacGia());
        values.put("theLoai", obj.getTheLoai());
        values.put("soChap", obj.getSoChap());
        values.put("ngay", obj.getNgay());
        values.put("luotXem", obj.getLuotXem());
        values.put("id", obj.getId());

        return db.insert("Truyen", null, values);
    }

    // get tat ca data
    public ArrayList<Manga> getAll() {
        String sql = "SELECT * FROM Truyen";
        return getData(sql);
    }


    private ArrayList<Manga> getData(String sql, String... selectionArgs) {
        ArrayList<Manga> list = new ArrayList<>();
        @SuppressLint("Recycle") Cursor c = db.rawQuery(sql, selectionArgs);
        while (c.moveToNext()) {
            Manga obj = new Manga();
            obj.setId(c.getString(c.getColumnIndex("id")));
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

    public int checkExistsManga(String id) {
        int check = 1;
        String getMG = "SELECT * FROM Truyen WHERE id=" + id;
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery(getMG, null);
        if (cursor.getCount() != 0) {
            check = -1;
        }
        return check;
    }
}
