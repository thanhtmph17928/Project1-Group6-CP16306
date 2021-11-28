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

import manga.readder.Model.Manga;
import manga.readder.R;

public class BangXepHangAdapter extends ArrayAdapter<Manga> {

    private final Context context;
    private final ArrayList<Manga> list;

    public BangXepHangAdapter(Context context, int resource, ArrayList<Manga> objects) {
        super(context, resource,objects);
        this.context = context;
        this.list = objects;
    }
    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_bang_xep_hang, null);
        }
        if (list.size() > 0) {
            Manga manga = this.list.get(position);
            TextView tvId = convertView.findViewById(R.id.tvId);
            TextView tvTenTruyen = convertView.findViewById(R.id.tvTenTruyen);
            TextView tvLuotXem = convertView.findViewById(R.id.tvLuotXem);

            tvId.setText(manga.getId());
            tvTenTruyen.setText(manga.getTenTruyen());
            tvLuotXem.setText("Lượt xem: "+manga.getLuotXem());

        }
        return convertView;

    }
}
