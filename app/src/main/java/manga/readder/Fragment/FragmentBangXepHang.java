package manga.readder.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import manga.readder.Activity.MainActivity;
import manga.readder.Adapter.BangXepHangAdapter;
import manga.readder.Adapter.MangaAdapter;
import manga.readder.DB.BangXepHangDAO;
import manga.readder.DB.TruyenDAO;
import manga.readder.Interface.GetManga;
import manga.readder.Model.Manga;
import manga.readder.R;
import manga.readder.api.APIGetManga;

public class FragmentBangXepHang extends Fragment  {

    GridView gridView;
    BangXepHangAdapter adapter;
    ArrayList<Manga> list;
    MainActivity mMainActivity;
    BangXepHangDAO truyenDAO;
    Manga manga;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bang_xep_hang, container, false);
        mMainActivity = (MainActivity) getActivity();
        gridView = view.findViewById(R.id.gvManga);
        truyenDAO = new BangXepHangDAO(getContext());
        list = truyenDAO.getTop();
        adapter = new BangXepHangAdapter(getActivity(),0,list);
        gridView.setAdapter(adapter);
//        new APIGetManga(this).execute();

        gridView.setOnItemClickListener((parent, view1, position, id) -> {
            manga = list.get(position);
            mMainActivity.replaceFragment(manga);
        });
        return view;
    }

//    @Override
//    public void start() {
//        Toast.makeText(getActivity(), "Loading", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void finish(String data) {
//        try {
//            list.clear();
//            JSONArray array = new JSONArray(data);
//            for (int i = 0; i < array.length(); i++) {
//                JSONObject o = array.getJSONObject(i);
//                list.add(new Manga(o));
//                adapter = new BangXepHangAdapter(getActivity(), 0, list) ;
//                listView.setAdapter(adapter);
//
//            }
//        } catch (JSONException e) {
//        }
//    }
//
//    @Override
//    public void error() {
//        Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
//    }
}