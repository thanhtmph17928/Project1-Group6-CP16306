package manga.readder.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
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
    @SuppressLint("SimpleDateFormat")
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_manga, container, false);
        init();
        mapping();
        setUp();
        gridView = view.findViewById(R.id.gvManga);
        new APIGetManga(this).execute();

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

            if (lichSuDAO.insert(lichSu)>0){
            }
        });

        return view;
    }
    private String now() {
        return sdf.format(Calendar.getInstance().getTime());
    }
    private void init() {
        lichSuDAO = new LichSuDAO(getContext());
        list = new ArrayList<>();
        mMainActivity = (MainActivity) getActivity();
//        adapter = new MangaAdapter(getActivity(),0,list);
//        gridView.setAdapter(adapter);

    }

    private void mapping() {

    }

    private void setUp() {
    }


    @Override
    public void start() {
        Toast.makeText(getActivity(), "Loading", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void finish(String data) {
        try {
            list.clear();
            JSONArray array = new JSONArray(data);
            for (int i = 0; i < array.length(); i++) {
                JSONObject o = array.getJSONObject(i);
                list.add(new Manga(o));
                adapter = new MangaAdapter(getActivity(), 0, list) ;
                gridView.setAdapter(adapter);

            }
        } catch (JSONException e) {
        }
    }

    @Override
    public void error() {
        Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
    }
}