package manga.readder.Fragment;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;
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
    SearchView searchView;
    EditText edSearch;
    @SuppressLint("SimpleDateFormat")
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_manga, container, false);
        setHasOptionsMenu(true);
        init();
        mapping();
        setUp();
        gridView = view.findViewById(R.id.gvManga);
        edSearch = view.findViewById(R.id.edSearch);
        edSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String  s = edSearch.getText().toString();
                adapter.sortTruyen(s);
            }
        });
        new APIGetManga(this).execute();
        adapter = new MangaAdapter(getContext(),0,list);
        gridView.setAdapter(adapter);

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
            truyenDAO = new TruyenDAO(getContext());
            list.clear();
            JSONArray array = new JSONArray(data);
            for (int i = 0; i < array.length(); i++) {
                JSONObject o = array.getJSONObject(i);
                Manga manga = new Manga(o);
                String id = manga.getId();
                if (truyenDAO.checkExistsManga(id)>0){
                    if (truyenDAO.insert(manga)>0){

                    }
                }
                list.add(manga);
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

//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        inflater.inflate(R.menu.search_menu,menu);
//        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
//        searchView = (androidx.appcompat.widget.SearchView) menu.findItem(R.id.actionsearch).getActionView();
//        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
//        searchView.setMaxWidth(Integer.MAX_VALUE);
////        searchView.setOnClickListener(v -> {
////            edSearch.setVisibility(View.VISIBLE);
////        });
////        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
////            @Override
////            public boolean onQueryTextSubmit(String query) {
////                adapter.getFilter().filter(query);
////
////                return false;
////            }
////
////            @Override
////            public boolean onQueryTextChange(String newText) {
////                adapter.getFilter().filter(newText);
////                return false;
////            }
////        });
//    }


}