package manga.readder.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import manga.readder.Model.Chapter;
import manga.readder.R;


public class InfoMangaAdapter extends ArrayAdapter<Chapter> {

    private final Context context;
    private final ArrayList<Chapter> list;

    public InfoMangaAdapter(Context context, int resource, ArrayList<Chapter> objects) {
        super(context, resource, objects);
        this.context = context;
        this.list = objects;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_chap, null);
        }
        if (list.size() > 0) {
            Chapter chapter = this.list.get(position);
            TextView tvChap = convertView.findViewById(R.id.tvChap);
            tvChap.setText(chapter.getTenChap());
        }
        return convertView;

    }
}
