package manga.readder.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    final String createTableYeuThich =
            "create table YeuThich (idYeuThich TEXT  PRIMARY KEY , tenTruyen TEXT , anh TEXT, nguon TEXT, tacGia TEXT, theLoai TEXT, soChap TEXT, ngay TEXT, luotXem INTERGER )";
    final String createTableLichSu =
            "create table LichSu(idLichSu TEXT  PRIMARY KEY , tenTruyen TEXT , anh TEXT, nguon TEXT, tacGia TEXT, theLoai TEXT, soChap TEXT, ngay TEXT, luotXem INTERGER ,thoiGian DATE)";
    final String dropTableLibrarian = "drop table if exists YeuThich";
    final String dropTableMember = "drop table if exists LichSu";
    final String createTableTruyen =
            "create table Truyen (id TEXT  PRIMARY KEY , tenTruyen TEXT , anh TEXT, nguon TEXT, tacGia TEXT, theLoai TEXT, soChap TEXT, ngay TEXT, luotXem INTERGER )";
    final String dropTableTruyen = "drop table if exists Truyen";
    public DbHelper(Context context) {
        super(context, "manga", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTableYeuThich);
        db.execSQL(createTableLichSu);
        db.execSQL(createTableTruyen);

//        db.execSQL(createTableBookType);
//        db.execSQL(createTableBook);
//        db.execSQL(createTableBookBill);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(dropTableLibrarian);
        db.execSQL(dropTableMember);
        db.execSQL(dropTableTruyen);
//        db.execSQL(dropTableBookType);
//        db.execSQL(dropTableBook);
//        db.execSQL(dropTableBookBill);
    }
}

