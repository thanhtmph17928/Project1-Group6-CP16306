package manga.readder.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import manga.readder.Activity.MainActivity;
import manga.readder.Adapter.LichSuAdapter;
import manga.readder.Adapter.YeuThichAdapter;
import manga.readder.DB.LichSuDAO;
import manga.readder.DB.YeuThichDAO;
import manga.readder.Model.Manga;
import manga.readder.R;

public class FragmentLichSu extends Fragment {

    ListView listView;
    LichSuAdapter adapter;
    ArrayList<Manga> list;
    MainActivity mMainActivity;
    Manga manga;
    LichSuDAO lichSuDAO;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lich_su, container, false);

        lichSuDAO = new LichSuDAO(getContext());
        list = new ArrayList<>();

        mMainActivity = (MainActivity) getActivity();

        listView = view.findViewById(R.id.lvLS);
        list = (ArrayList<Manga>) lichSuDAO.getAll();
        adapter = new LichSuAdapter(getActivity(), 0, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view1, position, id) -> {
            manga = list.get(position);
            mMainActivity.replaceFragment(manga);
        });
        return view;
    }
}