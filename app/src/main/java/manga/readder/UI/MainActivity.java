package manga.readder.UI;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import manga.readder.Adapter.MangaAdapter;
import manga.readder.Interface.GetManga;
import manga.readder.Model.Manga;
import manga.readder.R;
import manga.readder.api.APIGetManga;

public class MainActivity extends AppCompatActivity implements GetManga {

    GridView gridView;
    MangaAdapter adapter;
    ArrayList<Manga> list;
    EditText edSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        mapping();
        setUp();
        setClick();
        new APIGetManga(this).execute();
    }

    private void init() {
        list = new ArrayList<>();
        adapter = new MangaAdapter(this, 0, list);

    }

    private void mapping() {
        gridView = findViewById(R.id.gvManga);
        edSearch = findViewById(R.id.edSearch);
    }

    private void setUp() {
//        list = new ArrayList<>();
//        list.add(new Manga("http://st.imageinstant.net/data/comics/112/tobaku-datenroku-kaiji.jpg","Tobaku Datenroku Kaiji"));
//        list.add(new Manga("http://st.imageinstant.net/data/comics/112/tobaku-datenroku-kaiji.jpg","Tobaku Datenroku Kaiji"));
//        list.add(new Manga("http://st.imageinstant.net/data/comics/112/tobaku-datenroku-kaiji.jpg","Tobaku Datenroku Kaiji"));
//        list.add(new Manga("http://st.imageinstant.net/data/comics/112/tobaku-datenroku-kaiji.jpg","Tobaku Datenroku Kaiji"));
//        list.add(new Manga("http://st.imageinstant.net/data/comics/112/tobaku-datenroku-kaiji.jpg","Conan"));
//
//        adapter = new MangaAdapter(this,0,list);
        gridView.setAdapter(adapter);
    }

    private void setClick() {
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
                adapter.searchManga(s);
            }
        });
    }

    @Override
    public void start() {
        Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show();
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
                adapter = new MangaAdapter(this, 0, list);
                gridView.setAdapter(adapter);
            }
        } catch (JSONException e) {
        }
    }

    @Override
    public void error() {
        Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
    }
}