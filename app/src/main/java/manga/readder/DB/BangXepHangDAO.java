package manga.readder.DB;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import manga.readder.Model.Manga;

public class BangXepHangDAO {
    private final SQLiteDatabase db;
    private final Context context;

    public BangXepHangDAO(Context context) {
        this.context = context;
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    //top10
    public ArrayList<Manga> getTop() {
        String sqlTop = "SELECT * FROM Truyen " +
                "GROUP BY id ORDER BY luotXem DESC LIMIT 20";
        ArrayList<Manga> mangaArrayList = new ArrayList<>();
        @SuppressLint("Recycle") Cursor c = db.rawQuery(sqlTop, null);
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
            mangaArrayList.add(obj);

        }
        return mangaArrayList;


    }

}
