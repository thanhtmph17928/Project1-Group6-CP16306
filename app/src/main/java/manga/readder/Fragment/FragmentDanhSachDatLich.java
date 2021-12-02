package manga.readder.Fragment;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import manga.readder.Activity.MainActivity;
import manga.readder.Adapter.DatLichAdapter;
import manga.readder.DB.DatLichDAO;
import manga.readder.Model.Manga;
import manga.readder.R;

public class FragmentDanhSachDatLich extends Fragment {
    DatLichAdapter adapter;
    View view;
    ArrayList<Manga> list;
    ListView listView;
    DatLichDAO datLichDAO;
    MainActivity mMainActivity;
    Manga manga;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_danh_sach_dat_lich, container, false);
        listView = view.findViewById(R.id.lvDatLich);
        datLichDAO = new DatLichDAO(getContext());
        updateView();

        mMainActivity = (MainActivity) getActivity();

        listView.setOnItemClickListener((parent, view1, position, id) -> {
            manga = list.get(position);
            mMainActivity.replaceFragment(manga);
        });
        listView.setOnItemLongClickListener((parent, view1, position, id) -> {
            manga = list.get(position);
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("Xóa");
            builder.setMessage("Bạn có chắc muốn xóa ?");
            builder.setCancelable(true);
            builder.setPositiveButton("Yes", (dialog, which) -> {
                datLichDAO.delete(manga.getId());
                updateView();
                dialog.cancel();
            });
            builder.setNegativeButton("No", (dialog, which) -> dialog.cancel());
            builder.show();
            return false;
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

    private void updateView() {
        list = (ArrayList<Manga>) datLichDAO.getAll();
        adapter = new DatLichAdapter(getActivity(), this, list);
        listView.setAdapter(adapter);
    }
}