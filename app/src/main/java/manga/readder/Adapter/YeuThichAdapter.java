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

import manga.readder.Fragment.FragmentDanhSachYT;
import manga.readder.Model.Manga;
import manga.readder.R;

public class YeuThichAdapter extends ArrayAdapter<Manga> {
    private final Context context;
    private final ArrayList<Manga> list;
    FragmentDanhSachYT fragment;


    public YeuThichAdapter(Context context, FragmentDanhSachYT fragment, ArrayList<Manga> objects) {
        super(context, 0,objects);
        this.context = context;
        this.list = objects;
        this.fragment = fragment;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_yeu_thich, null);
        }
        if (list.size() > 0) {
            Manga manga = list.get(position);
            TextView tvMangaName = convertView.findViewById(R.id.tvMangaName);
            ImageView imgManga = convertView.findViewById(R.id.imgManga);
            TextView tvXoa = convertView.findViewById(R.id.tvUnFav);
            TextView tvThem = convertView.findViewById(R.id.tvFav);
            tvMangaName.setText(manga.getTenTruyen());
            Glide.with(context).load(manga.getAnh()).into(imgManga);
            tvXoa.setOnClickListener(v -> {
                fragment.xoa(manga.getId());
                tvXoa.setVisibility(View.INVISIBLE);
                tvThem.setVisibility(View.VISIBLE);
            });
            tvThem.setOnClickListener(v -> {
                fragment.them(manga);
                tvXoa.setVisibility(View.VISIBLE);
                tvThem.setVisibility(View.INVISIBLE);
            });
        }
        return convertView;

    }
}
