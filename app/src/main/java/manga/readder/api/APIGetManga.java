package manga.readder.api;

import android.os.AsyncTask;

import java.io.IOException;

import manga.readder.Interface.GetManga;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class APIGetManga extends AsyncTask<Void, Void, Void> {
    String data;
    GetManga getManga;
    OkHttpClient client = new OkHttpClient();

    public APIGetManga(GetManga getManga) {
        this.getManga = getManga;
        this.getManga.start();
    }

    //https://mangareaderrecreate.000webhostapp.com/layTruyen.php
    //       http://myjson.dit.upm.es/api/bins/bnwz
    @Override
    protected Void doInBackground(Void... voids) {
        Request request = new Request.Builder()
                .url("https://mangareaderrecreate.000webhostapp.com/layTruyen.php")
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
            this.getManga.error();
        } else {
            this.getManga.finish(data);
        }
    }
}
