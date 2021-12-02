package manga.readder.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import manga.readder.Model.Manga;
import manga.readder.R;

public class MangaAdapter extends ArrayAdapter<Manga> implements Filterable {

    private final Context context;
    private final ArrayList<Manga> mListManga;

    public MangaAdapter(Context context, int resource, ArrayList<Manga> mListManga) {
        super(context, resource, mListManga);
        this.context = context;
        this.mListManga = mListManga;
    }

    public void sortTruyen(String s) {
        s = s.toUpperCase();
        int k = 0;
        for (int i = 0; i < mListManga.size(); i++) {
            Manga manga = mListManga.get(i);
            String name = manga.getTenTruyen().toUpperCase();
            if (name.contains(s)) {
                mListManga.set(i, mListManga.get(k));
                mListManga.set(k, manga);
                k++;
            }
        }
        notifyDataSetChanged();
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_manga, null);
        }
        if (mListManga.size() > 0) {
            Manga manga = mListManga.get(position);
            TextView tvMangaName = convertView.findViewById(R.id.tvMangaName);
            ImageView imgManga = convertView.findViewById(R.id.imgManga);

            tvMangaName.setText(manga.getTenTruyen());
            Glide.with(context).load(manga.getAnh()).into(imgManga);
        }

        return convertView;

    }
}
