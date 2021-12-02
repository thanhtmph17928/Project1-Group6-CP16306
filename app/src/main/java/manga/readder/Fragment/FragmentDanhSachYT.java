package manga.readder.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import manga.readder.Activity.MainActivity;
import manga.readder.Adapter.YeuThichAdapter;
import manga.readder.DB.DatLichDAO;
import manga.readder.DB.YeuThichDAO;
import manga.readder.Model.Manga;
import manga.readder.R;

public class FragmentDanhSachYT extends Fragment {

    GridView gridView;
    YeuThichAdapter adapter;
    ArrayList<Manga> list;
    MainActivity mMainActivity;
    Manga manga;
    YeuThichDAO yeuThichDAO;
    DatLichDAO datLichDAO;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_danh_sach_y_t, container, false);

        yeuThichDAO = new YeuThichDAO(getContext());
        datLichDAO = new DatLichDAO(getContext());
        list = new ArrayList<>();

        mMainActivity = (MainActivity) getActivity();

        gridView = view.findViewById(R.id.gvManga);
        updateView();

        gridView.setOnItemClickListener((parent, view1, position, id) -> {
            manga = list.get(position);
            mMainActivity.replaceFragment(manga);
        });
        init();
        mapping();
        updateView();
        setClick();
        return view;
    }

    private void init() {

    }

    private void mapping() {

    }

    private void setClick() {

    }

    public void xoa(final String id) {
        yeuThichDAO.delete(id);

    }

    public void them(final Manga manga) {
        yeuThichDAO.insert(manga);

    }

    public void xoa1(final String id) {
        datLichDAO.delete(id);

    }

    public void them1(final Manga manga) {
        datLichDAO.insert(manga);

    }

    private void updateView() {
        list = (ArrayList<Manga>) yeuThichDAO.getAll();
        adapter = new YeuThichAdapter(getActivity(), this, list);
        gridView.setAdapter(adapter);
    }

}