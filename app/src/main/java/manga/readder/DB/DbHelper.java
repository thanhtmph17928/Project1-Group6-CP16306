package manga.readder.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    final String createTableYeuThich =
            "create table YeuThich (idYeuThich INTEGER  PRIMARY KEY AUTOINCREMENT, tenTruyen TEXT , anh TEXT, nguon TEXT, tacGia TEXT, theLoai TEXT, soChap TEXT, ngay TEXT, luotXem TEXT )";
    final String createTableLichSu =
            "create table LichSu(idLichSu Integer  PRIMARY KEY AUTOINCREMENT, tenTruyen TEXT , anh TEXT, nguon TEXT, tacGia TEXT, theLoai TEXT, soChap TEXT, ngay TEXT, luotXem TEXT )";
    final String dropTableLibrarian = "drop table if exists YeuThich";
    final String dropTableMember = "drop table if exists LichSu";


    public DbHelper(Context context) {
        super(context, "library", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTableYeuThich);
        db.execSQL(createTableLichSu);
//        db.execSQL(createTableBookType);
//        db.execSQL(createTableBook);
//        db.execSQL(createTableBookBill);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(dropTableLibrarian);
        db.execSQL(dropTableMember);
//        db.execSQL(dropTableBookType);
//        db.execSQL(dropTableBook);
//        db.execSQL(dropTableBookBill);
    }
}

