package manga.readder.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    final String createTableYeuThich =
            "create table YeuThich (idYeuThich TEXT  PRIMARY KEY , tenTruyen TEXT , anh TEXT, nguon TEXT, tacGia TEXT, theLoai TEXT, soChap TEXT, ngay TEXT, luotXem INTEGER )";
    final String createTableDatLich =
            "create table DatLich (idDatLich TEXT  PRIMARY KEY , tenTruyen TEXT , anh TEXT, nguon TEXT, tacGia TEXT, theLoai TEXT, soChap TEXT, ngay TEXT, luotXem INTEGER )";
    final String createTableLichSu =
            "create table LichSu(id INTEGER PRIMARY KEY AUTOINCREMENT ,idLichSu TEXT  , tenTruyen TEXT , anh TEXT, nguon TEXT, tacGia TEXT, theLoai TEXT, soChap TEXT, ngay TEXT, luotXem INTEGER ,thoiGian DATE)";
    final String createTableTruyen =
            "create table Truyen (id TEXT  PRIMARY KEY , tenTruyen TEXT , anh TEXT, nguon TEXT, tacGia TEXT, theLoai TEXT, soChap TEXT, ngay TEXT, luotXem INTEGER )";

    final String dropTableTruyen = "drop table if exists Truyen";
    final String dropTableLYeuThich = "drop table if exists YeuThich";
    final String dropTableLichSu = "drop table if exists LichSu";
    final String dropTableDatLich = "drop table if exists DatLich";

    public DbHelper(Context context) {
        super(context, "manga", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTableYeuThich);
        db.execSQL(createTableLichSu);
        db.execSQL(createTableTruyen);
        db.execSQL(createTableDatLich);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(dropTableLYeuThich);
        db.execSQL(dropTableLichSu);
        db.execSQL(dropTableTruyen);
        db.execSQL(dropTableDatLich);
    }
}

