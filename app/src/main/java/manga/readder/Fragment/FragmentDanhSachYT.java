package manga.readder.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import manga.readder.Activity.MainActivity;
import manga.readder.Adapter.BangXepHangAdapter;
import manga.readder.Adapter.YeuThichAdapter;
import manga.readder.DB.YeuThichDAO;
import manga.readder.Model.Manga;
import manga.readder.R;

public class FragmentDanhSachYT extends Fragment {

    ListView listView;
    YeuThichAdapter adapter;
    ArrayList<Manga> list;
    MainActivity mMainActivity;
    Manga manga;
    YeuThichDAO yeuThichDAO;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_danh_sach_y_t, container, false);

        yeuThichDAO = new YeuThichDAO(getContext());
        list = new ArrayList<>();

        mMainActivity = (MainActivity) getActivity();

        listView = view.findViewById(R.id.lvYT);
        list = (ArrayList<Manga>) yeuThichDAO.getAll();
        adapter = new YeuThichAdapter(getActivity(), 0, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view1, position, id) -> {
            manga = list.get(position);
            mMainActivity.replaceFragment(manga);
        });
        return view;
    }
}