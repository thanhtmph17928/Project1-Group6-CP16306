package manga.readder.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import manga.readder.Activity.MainActivity;
import manga.readder.Adapter.MangaAdapter;
import manga.readder.DB.LichSuDAO;
import manga.readder.DB.TruyenDAO;
import manga.readder.Interface.GetManga;
import manga.readder.Model.LichSu;
import manga.readder.Model.Manga;
import manga.readder.R;
import manga.readder.api.APIGetManga;

public class FragmentManga extends Fragment implements GetManga {
    GridView gridView;
    MangaAdapter adapter;
    ArrayList<Manga> list;
    MainActivity mMainActivity;
    Manga manga;
    LichSu lichSu;
    LichSuDAO lichSuDAO;
    TruyenDAO truyenDAO;
    EditText edSearch;
    View view;
    ImageView imgAnHien;
    @SuppressLint("SimpleDateFormat")
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_manga, container, false);


        init();
        mapping();
        new APIGetManga(this).execute();
        updateView();
        setClick();

        imgAnHien = view.findViewById(R.id.imgAnHienView);

        imgAnHien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edSearch.setVisibility(View.VISIBLE);
            }
        });

        return view;
    }

    private void init() {
        lichSuDAO = new LichSuDAO(getContext());
        list = new ArrayList<>();
        mMainActivity = (MainActivity) getActivity();
    }

    private void mapping() {
        gridView = view.findViewById(R.id.gvManga);
        edSearch = view.findViewById(R.id.edSearch);
        edSearch.setVisibility(View.INVISIBLE);
    }

    private void setClick() {
        gridView.setOnItemClickListener((parent, view1, position, id) -> {
            manga = list.get(position);
            mMainActivity.replaceFragment(manga);
            lichSu = new LichSu();
            lichSu.setId(manga.getId());
            lichSu.setTenTruyen(manga.getTenTruyen());
            lichSu.setAnh(manga.getAnh());
            lichSu.setNguon(manga.getNguon());
            lichSu.setTacGia(manga.getTacGia());
            lichSu.setTheLoai(manga.getTheLoai());
            lichSu.setLuotXem(manga.getLuotXem());
            lichSu.setNgay(manga.getNgay());
            lichSu.setSoChap(manga.getSoChap());
            lichSu.setThoiGian(java.sql.Date.valueOf(now()));

            lichSuDAO.insert(lichSu);
        });
        edSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String s = edSearch.getText().toString();
                adapter.sortTruyen(s);
            }
        });
    }

    private void updateView() {
        adapter = new MangaAdapter(getContext(), 0, list);
        gridView.setAdapter(adapter);
    }

    private String now() {
        return sdf.format(Calendar.getInstance().getTime());
    }

    @Override
    public void start() {
        Toast.makeText(getActivity(), "Loading", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void finish(String data) {
        try {
            truyenDAO = new TruyenDAO(getContext());
            list.clear();
            JSONArray array = new JSONArray(data);
            for (int i = 0; i < array.length(); i++) {
                JSONObject o = array.getJSONObject(i);
                Manga manga = new Manga(o);
                String id = manga.getId();
                if (truyenDAO.checkExistsManga(id) > 0) {
                    truyenDAO.insert(manga);
                }
                list.add(manga);
                updateView();
            }
        } catch (JSONException ignored) {
        }
    }

    @Override
    public void error() {
        Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
    }


}