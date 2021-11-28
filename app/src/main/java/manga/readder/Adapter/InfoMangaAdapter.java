package manga.readder.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import manga.readder.Model.Chapter;
import manga.readder.Model.Manga;
import manga.readder.R;


public class InfoMangaAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final ArrayList<String> list;

    public InfoMangaAdapter(Context context, int resource, ArrayList<String> objects) {
        super(context, resource, objects);
        this.context = context;
        this.list = objects;
    }
//    public void searchManga(String s){
//        s = s.toUpperCase();
//        int k = 0;
//        for (int i=0;i<list.size();i++){
//            Manga manga = list.get(i);
//            String name = manga.getMangaName().toUpperCase();
//            if (name.indexOf(s)>=0){
//                list.set(i,list.get(k));
//                list.set(k,manga);
//                k++;
//            }
//        }
//        notifyDataSetChanged();
//    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_chap, null);
        }
        if (list.size() > 0) {
            String chapter = this.list.get(position);
            TextView tvChap = convertView.findViewById(R.id.tvChap);
            tvChap.setText(chapter);
        }
        return convertView;

    }
}
