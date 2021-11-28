package manga.readder.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import manga.readder.Model.Manga;
import manga.readder.R;

public class MangaAdapter extends ArrayAdapter<Manga> {

    private final Context context;
    private final ArrayList<Manga> list;

//    private MangaAdapter.OnATtemClickListener mOnATtemClickListener;
//
//    public interface OnATtemClickListener{
//        void onClickItemUser();
//    }

    public MangaAdapter(Context context, int resource, ArrayList<Manga> objects) {
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
            convertView = inflater.inflate(R.layout.item_manga, null);
        }
        if (list.size() > 0) {
            Manga manga = this.list.get(position);
            TextView tvMangaName = convertView.findViewById(R.id.tvMangaName);
            ImageView imgManga = convertView.findViewById(R.id.imgManga);

            tvMangaName.setText(manga.getTenTruyen());
            Glide.with(context).load(manga.getAnh()).into(imgManga);
        }
        return convertView;

    }
}
