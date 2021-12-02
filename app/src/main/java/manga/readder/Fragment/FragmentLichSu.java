package manga.readder.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import manga.readder.Activity.MainActivity;
import manga.readder.Adapter.LichSuAdapter;
import manga.readder.DB.LichSuDAO;
import manga.readder.Model.LichSu;
import manga.readder.Model.Manga;
import manga.readder.R;

public class FragmentLichSu extends Fragment {

    GridView gridView;
    LichSuAdapter adapter;
    ArrayList<Manga> mangaArrayList;
    ArrayList<LichSu> lichSuArrayList;
    MainActivity mMainActivity;
    Manga manga;
    LichSu lichSu;
    LichSuDAO lichSuDAO;
    String thoiGian;
    ArrayList<String> listThoiGian;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_lich_su, container, false);


        init();
        mapping();
        updateView();
        setClick();
        return view;
    }

    private void init() {
        lichSuDAO = new LichSuDAO(getContext());
        mangaArrayList = new ArrayList<>();
        listThoiGian = new ArrayList<>();
        mMainActivity = (MainActivity) getActivity();
        lichSuArrayList = (ArrayList<LichSu>) lichSuDAO.getAll();
    }

    private void mapping() {
        gridView = view.findViewById(R.id.gvManga);

        for (int i = 0; i < lichSuArrayList.size(); i++) {
            lichSu = lichSuArrayList.get(i);
            thoiGian = String.valueOf(lichSu.getThoiGian());
            listThoiGian.add(thoiGian);
            manga = new Manga();
            manga.setId(lichSu.getId());
            manga.setTenTruyen(lichSu.getTenTruyen());
            manga.setNguon(lichSu.getNguon());
            manga.setAnh(lichSu.getAnh());
            manga.setTacGia(lichSu.getTacGia());
            manga.setTheLoai(lichSu.getTheLoai());
            manga.setLuotXem(lichSu.getLuotXem());
            manga.setNgay(lichSu.getNgay());
            manga.setSoChap(lichSu.getSoChap());
            mangaArrayList.add(manga);
        }
    }

    private void setClick() {
        gridView.setOnItemClickListener((parent, view1, position, id) -> {
            manga = mangaArrayList.get(position);
            mMainActivity.replaceFragment(manga);
        });
    }

    private void updateView() {
        adapter = new LichSuAdapter(getActivity(), 0, mangaArrayList, listThoiGian);
        gridView.setAdapter(adapter);
    }
}