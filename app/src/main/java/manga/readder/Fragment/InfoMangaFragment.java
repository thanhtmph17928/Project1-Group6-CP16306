package manga.readder.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import manga.readder.Activity.MainActivity;
//import manga.readder.Adapter.ChapterAdapter;
import manga.readder.Activity.User;
import manga.readder.Adapter.InfoMangaAdapter;
import manga.readder.Model.Chapter;
import manga.readder.Model.Manga;
import manga.readder.R;

public class InfoMangaFragment extends Fragment {
    private View view;
    private MainActivity mMainActivity;
    TextView tvTen,tvTieuDe,tvTacGia,tvTheLoai,tvSoChap;
    ImageView imgAnh;
    ListView listView;
    ArrayList<String> listChap;
    InfoMangaAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_info_manga, container, false);
//        rvChap = view.findViewById(R.id.rvChap);
//        mMainActivity = (MainActivity) getActivity();
//        LinearLayoutManager layoutManager = new LinearLayoutManager(mMainActivity);
//        rvChap.setLayoutManager(layoutManager);
//        ChapterAdapter adapter = new ChapterAdapter(getListChap());
//        rvChap.setAdapter(adapter);
//        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(mainActivity, DividerItemDecoration.VERTICAL);
//        rvChap.addItemDecoration(itemDecoration);
        imgAnh  = view.findViewById(R.id.imgAnh);
        tvTen = view.findViewById(R.id.tvTen);
        tvTieuDe = view.findViewById(R.id.tvTieuDe);
        tvTacGia = view.findViewById(R.id.tvTacGia);
        tvTheLoai = view.findViewById(R.id.tvTheLoai);
        tvSoChap = view.findViewById(R.id.tvSoChap);
        listView = view.findViewById(R.id.lvChap);



        Bundle bundleRecive = getArguments();
        if (bundleRecive!=null){
            Manga manga = (Manga) bundleRecive.get("obj_user");
            if (manga!=null) {
                tvTen.setText("Tên truyện :"+manga.getTenTruyen());
                tvTieuDe.setText(manga.getTenTruyen());
                tvTacGia.setText("Tác giả :"+manga.getTacGia());
                tvTheLoai.setText("Thể loại:"+manga.getTheLoai());
                tvSoChap.setText("Số chap: "+manga.getSoChap());
                Glide.with(getContext()).load(manga.getAnh()).into(imgAnh);
                int soChapter = Integer.parseInt(manga.getSoChap());
                listChap = new ArrayList<>();
                for (int i = 1;i<=soChapter;i++){
                    listChap.add("Chapter "+i);
                }
                adapter = new InfoMangaAdapter(getActivity(),0,listChap);
                listView.setAdapter(adapter);
            }
        }
        return view;
    }

}