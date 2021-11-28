package manga.readder.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import manga.readder.Model.Manga;
import manga.readder.R;

public class LichSuAdapter extends ArrayAdapter<Manga> {
    private final Context context;
    private final ArrayList<Manga> list;


    public LichSuAdapter(Context context, int resource, ArrayList<Manga> objects) {
        super(context, resource,objects);
        this.context = context;
        this.list = objects;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_lich_su, null);
        }
        if (list.size() > 0) {
            Manga manga = this.list.get(position);
            TextView tvTenTruyen = convertView.findViewById(R.id.tvTenTruyen);
            TextView tvSoChap= convertView.findViewById(R.id.tvChapter);

            tvTenTruyen.setText(manga.getTenTruyen());
            tvSoChap.setText("Số chapter: "+manga.getSoChap());

        }
        return convertView;

    }
}
