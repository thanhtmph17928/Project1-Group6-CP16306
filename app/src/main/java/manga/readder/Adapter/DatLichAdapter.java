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

import manga.readder.Fragment.FragmentDanhSachDatLich;
import manga.readder.Model.Manga;
import manga.readder.R;

public class DatLichAdapter extends ArrayAdapter<Manga> {
    private final Context context;
    private final ArrayList<Manga> list;
    FragmentDanhSachDatLich fragment;


    public DatLichAdapter(Context context, FragmentDanhSachDatLich fragment, ArrayList<Manga> objects) {
        super(context, 0, objects);
        this.context = context;
        this.list = objects;
        this.fragment = fragment;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_dat_lich, null);
        }
        if (list.size() > 0) {
            Manga manga = list.get(position);
            ImageView imgManga = convertView.findViewById(R.id.imgManga);
            TextView tvName = convertView.findViewById(R.id.tvName);
            TextView tvTacGia = convertView.findViewById(R.id.tvTacGia);
            tvName.setText(manga.getTenTruyen());
            tvTacGia.setText(manga.getTacGia());
            Glide.with(context).load(manga.getAnh()).into(imgManga);

        }
        return convertView;

    }
}
