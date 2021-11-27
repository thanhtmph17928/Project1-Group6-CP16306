package manga.readder.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import manga.readder.Adapter.MangaAdapter;
import manga.readder.Interface.GetManga;
import manga.readder.Model.Manga;
import manga.readder.R;
import manga.readder.api.APIGetManga;

public class FragmentManga extends Fragment implements GetManga {
    GridView gridView;
    MangaAdapter adapter;
    ArrayList<Manga> list;
    EditText edSearch;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_manga, container, false);
        init();
        mapping();
        setUp();
        gridView = view.findViewById(R.id.gvManga);
        new APIGetManga(this).execute();

        return view;
    }
    private void init() {
        list = new ArrayList<>();
        adapter = new MangaAdapter(getActivity(), 0, list);

    }

    private void mapping() {

    }

    private void setUp() {
//        list = new ArrayList<>();
////        list.add(new Manga("http://st.imageinstant.net/data/comics/112/tobaku-datenroku-kaiji.jpg","Tobaku Datenroku Kaiji"));
////        list.add(new Manga("http://st.imageinstant.net/data/comics/112/tobaku-datenroku-kaiji.jpg","Tobaku Datenroku Kaiji"));
////        list.add(new Manga("http://st.imageinstant.net/data/comics/112/tobaku-datenroku-kaiji.jpg","Tobaku Datenroku Kaiji"));
////        list.add(new Manga("http://st.imageinstant.net/data/comics/112/tobaku-datenroku-kaiji.jpg","Tobaku Datenroku Kaiji"));
////        list.add(new Manga("http://st.imageinstant.net/data/comics/112/tobaku-datenroku-kaiji.jpg","Conan"));
//
//        adapter = new MangaAdapter(getActivity(),0,list);
//        gridView.setAdapter(adapter);
    }


    @Override
    public void start() {
        Toast.makeText(getActivity(), "Loading", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void finish(String data) {
        try {
            list.clear();
            data = "[\n" +
                    "  {\n" +
                    "    \"mangaName\": \"Koujo Denka no Kateikyoushi\",\n" +
                    "    \"linkImage\": \"http://st.imageinstant.net/data/comics/215/koujo-denka-no-kateikyoushi.jpg\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"mangaName\": \"Hazukashigariya no Kunoichi-san\",\n" +
                    "    \"linkImage\": \"http://st.imageinstant.net/data/comics/100/hazukashigariya-no-kunoichi-san.jpg\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"mangaName\": \"Metamorphose no Engawa\",\n" +
                    "    \"linkImage\": \"http://st.imageinstant.net/data/comics/2/metamorphose-no-engawa.jpg\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"mangaName\": \"Crappy Game Hunter Challenges God-Tier Game\",\n" +
                    "    \"linkImage\": \"http://st.imageinstant.net/data/comics/49/crappy-game-hunter-challenges-god-tier-g-9474.jpg\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"mangaName\": \"Sợi Xích Thần\",\n" +
                    "    \"linkImage\": \"http://st.imageinstant.net/data/comics/160/soi-xich-than.jpg\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"mangaName\": \"Mutant Muốn Có Người Yêu\",\n" +
                    "    \"linkImage\": \"http://st.imageinstant.net/data/comics/23/mutant-muon-co-nguoi-yeu.jpg\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"mangaName\": \"Dị Giới Kiến Quốc Ký\",\n" +
                    "    \"linkImage\": \"http://st.imageinstant.net/data/comics/125/di-gioi-kien-quoc-ky.jpg\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"mangaName\": \"Mashle: Phép Thuật và Cơ Bắp\",\n" +
                    "    \"linkImage\": \"http://st.imageinstant.net/data/comics/120/mashle-phep-thuat-va-co-bap.jpg\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"mangaName\": \"Tobaku Datenroku Kaiji\",\n" +
                    "    \"linkImage\": \"http://st.imageinstant.net/data/comics/112/tobaku-datenroku-kaiji.jpg\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"mangaName\": \"Lord - Bá Vương\",\n" +
                    "    \"linkImage\": \"http://st.imageinstant.net/data/comics/77/lord-ba-vuong.jpg\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"mangaName\": \"Midarana Kakyou ni su kuu Mono\",\n" +
                    "    \"linkImage\": \"http://st.imageinstant.net/data/comics/65/midarana-kakyou-ni-su-kuu-mono.jpg\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"mangaName\": \"Kỵ Sĩ Trong Vòng Cấm\",\n" +
                    "    \"linkImage\": \"http://st.imageinstant.net/data/comics/183/area-no-kishi.jpg\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"mangaName\": \"Koujo Denka no Kateikyoushi\",\n" +
                    "    \"linkImage\": \"http://st.imageinstant.net/data/comics/215/koujo-denka-no-kateikyoushi.jpg\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"mangaName\": \"Hazukashigariya no Kunoichi-san\",\n" +
                    "    \"linkImage\": \"http://st.imageinstant.net/data/comics/100/hazukashigariya-no-kunoichi-san.jpg\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"mangaName\": \"Metamorphose no Engawa\",\n" +
                    "    \"linkImage\": \"http://st.imageinstant.net/data/comics/2/metamorphose-no-engawa.jpg\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"mangaName\": \"Crappy Game Hunter Challenges God-Tier Game\",\n" +
                    "    \"linkImage\": \"http://st.imageinstant.net/data/comics/49/crappy-game-hunter-challenges-god-tier-g-9474.jpg\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"mangaName\": \"Sợi Xích Thần\",\n" +
                    "    \"linkImage\": \"http://st.imageinstant.net/data/comics/160/soi-xich-than.jpg\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"mangaName\": \"Mutant Muốn Có Người Yêu\",\n" +
                    "    \"linkImage\": \"http://st.imageinstant.net/data/comics/23/mutant-muon-co-nguoi-yeu.jpg\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"mangaName\": \"Dị Giới Kiến Quốc Ký\",\n" +
                    "    \"linkImage\": \"http://st.imageinstant.net/data/comics/125/di-gioi-kien-quoc-ky.jpg\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"mangaName\": \"Mashle: Phép Thuật và Cơ Bắp\",\n" +
                    "    \"linkImage\": \"http://st.imageinstant.net/data/comics/120/mashle-phep-thuat-va-co-bap.jpg\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"mangaName\": \"Tobaku Datenroku Kaiji\",\n" +
                    "    \"linkImage\": \"http://st.imageinstant.net/data/comics/112/tobaku-datenroku-kaiji.jpg\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"mangaName\": \"Lord - Bá Vương\",\n" +
                    "    \"linkImage\": \"http://st.imageinstant.net/data/comics/77/lord-ba-vuong.jpg\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"mangaName\": \"Midarana Kakyou ni su kuu Mono\",\n" +
                    "    \"linkImage\": \"http://st.imageinstant.net/data/comics/65/midarana-kakyou-ni-su-kuu-mono.jpg\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"mangaName\": \"Kỵ Sĩ Trong Vòng Cấm\",\n" +
                    "    \"linkImage\": \"http://st.imageinstant.net/data/comics/183/area-no-kishi.jpg\"\n" +
                    "  }\n" +
                    "]";
            JSONArray array = new JSONArray(data);
            for (int i = 0; i < array.length(); i++) {
                JSONObject o = array.getJSONObject(i);
                list.add(new Manga(o));
                adapter = new MangaAdapter(getActivity(), 0, list);
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