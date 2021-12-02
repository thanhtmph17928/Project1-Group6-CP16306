package manga.readder.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import manga.readder.Activity.MainActivity;
import manga.readder.Adapter.InfoMangaAdapter;
import manga.readder.DB.DatLichDAO;
import manga.readder.DB.YeuThichDAO;
import manga.readder.Interface.GetChapter;
import manga.readder.Model.Chapter;
import manga.readder.Model.Manga;
import manga.readder.R;
import manga.readder.api.APIGetChapter;

public class InfoMangaFragment extends Fragment implements GetChapter {
    TextView tvTen, tvTieuDe, tvTacGia, tvTheLoai, tvSoChap, tvNguon;
    ImageView imgAnh;
    ListView listView;
    ArrayList<Chapter> listChap;
    InfoMangaAdapter adapter;
    Chapter chapter;
    Manga manga;
    Button btnYeuThich, btnDatLich;
    YeuThichDAO yeuThichDAO;
    DatLichDAO datLichDAO;
    private MainActivity mMainActivity;

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info_manga, container, false);

        mMainActivity = (MainActivity) getActivity();
        imgAnh = view.findViewById(R.id.imgAnh);
        tvTen = view.findViewById(R.id.tvTen);
        tvTieuDe = view.findViewById(R.id.tvTieuDe);
        tvNguon = view.findViewById(R.id.tvNguon);
        tvTacGia = view.findViewById(R.id.tvTacGia);
        tvTheLoai = view.findViewById(R.id.tvTheLoai);
        tvSoChap = view.findViewById(R.id.tvSoChap);
        listView = view.findViewById(R.id.lvChap);
        btnYeuThich = view.findViewById(R.id.btnYeuThich);
        btnDatLich = view.findViewById(R.id.btnDatLich);
        yeuThichDAO = new YeuThichDAO(getContext());
        datLichDAO = new DatLichDAO(getContext());


        Bundle bundleRecive = getArguments();
        if (bundleRecive != null) {
            manga = (Manga) bundleRecive.get("obj_manga");
            if (manga != null) {
                tvTen.setText("Tên truyện :" + manga.getTenTruyen());
                tvTieuDe.setText(manga.getTenTruyen());
                tvNguon.setText(manga.getNguon());
                tvTacGia.setText("Tác giả :" + manga.getTacGia());
                tvTheLoai.setText("Thể loại:" + manga.getTheLoai());
                tvSoChap.setText("Số chap: " + manga.getSoChap());
                Glide.with(requireContext()).load(manga.getAnh()).into(imgAnh);
                listChap = new ArrayList<>();
                adapter = new InfoMangaAdapter(getActivity(), 0, listChap);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener((parent, view1, position, id) -> {
                    chapter = listChap.get(position);
                    mMainActivity.readManga(chapter);
                });
                btnYeuThich.setOnClickListener(v -> {
                    if (yeuThichDAO.checkExists(manga.getId()) > 0) {
                        if (yeuThichDAO.insert(manga) > 0) {
                            Toast.makeText(getContext(), "Đã thêm vào danh sách yêu thích", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getContext(), "Truyện đã được thêm", Toast.LENGTH_SHORT).show();
                    }
                });
                btnDatLich.setOnClickListener(v -> {
                    if (datLichDAO.checkExists(manga.getId()) > 0) {
                        if (datLichDAO.insert(manga) > 0) {
                            Toast.makeText(getContext(), "Đã thêm vào danh sách đặt lịch", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getContext(), "Truyện đã được thêm", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
        assert manga != null;
        new APIGetChapter(this, manga.getId()).execute();

        return view;
    }

    @Override
    public void start() {
        Toast.makeText(getActivity(), "Loading", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void finish(String data) {
        try {
            listChap.clear();
            JSONArray array = new JSONArray(data);
            for (int i = 0; i < array.length(); i++) {
                JSONObject o = array.getJSONObject(i);
                listChap.add(new Chapter(o));
                adapter = new InfoMangaAdapter(getActivity(), 0, listChap);
                listView.setAdapter(adapter);

            }
        } catch (JSONException ignored) {
        }
    }

    @Override
    public void error() {
        Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
    }
}