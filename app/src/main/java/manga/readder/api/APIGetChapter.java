package manga.readder.api;

import android.os.AsyncTask;

import java.io.IOException;

import manga.readder.Interface.GetChapter;
import manga.readder.Interface.GetManga;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class APIGetChapter extends AsyncTask<Void, Void, Void> {
    String data;
    GetChapter getChapter;
    String idTruyen;
    OkHttpClient client = new OkHttpClient();

    public APIGetChapter(GetChapter getChapter,String idTruyen) {
        this.getChapter = getChapter;
        this.idTruyen = idTruyen;
        this.getChapter.start();
    }
    @Override
    protected Void doInBackground(Void... voids) {
        Request request = new Request.Builder()
                .url("https://mangareaderrecreate.000webhostapp.com/layChapter.php?id="+idTruyen)
                .build();
        data = null;
        try {
            Response response = client.newCall(request).execute();
            data = response.body().string();
        } catch (IOException e) {
            data = null;
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        if (data == null) {
            this.getChapter.error();
        } else {
            this.getChapter.finish(data);
        }
    }
}
