package manga.readder.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import manga.readder.Activity.MainActivity;
import manga.readder.Adapter.BangXepHangAdapter;
import manga.readder.DB.BangXepHangDAO;
import manga.readder.Model.Manga;
import manga.readder.R;

public class FragmentBangXepHang extends Fragment {

    GridView gridView;
    BangXepHangAdapter adapter;
    ArrayList<Manga> list;
    MainActivity mMainActivity;
    BangXepHangDAO truyenDAO;
    Manga manga;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_bang_xep_hang, container, false);
        init();
        mapping();
        updateView();
        setClick();

        return view;
    }

    private void init() {
        mMainActivity = (MainActivity) getActivity();
        truyenDAO = new BangXepHangDAO(getContext());
    }

    private void mapping() {
        gridView = view.findViewById(R.id.gvManga);
    }

    private void setClick() {
        gridView.setOnItemClickListener((parent, view1, position, id) -> {
            manga = list.get(position);
            mMainActivity.replaceFragment(manga);
        });
    }

    private void updateView() {
        list = truyenDAO.getTop();
        adapter = new BangXepHangAdapter(getActivity(), 0, list);
        gridView.setAdapter(adapter);
    }
}