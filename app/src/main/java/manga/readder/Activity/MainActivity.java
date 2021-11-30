package manga.readder.Activity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import manga.readder.Adapter.MangaAdapter;
import manga.readder.DB.TruyenDAO;
import manga.readder.Fragment.FragmentBangXepHang;
import manga.readder.Fragment.FragmentDanhSachDatLich;
import manga.readder.Fragment.FragmentDanhSachYT;
import manga.readder.Fragment.FragmentLichSu;
import manga.readder.Fragment.FragmentManga;
import manga.readder.Fragment.InfoMangaFragment;
import manga.readder.Fragment.ReadMangaFragment;
import manga.readder.Interface.GetManga;
import manga.readder.Model.Chapter;
import manga.readder.Model.LichSu;
import manga.readder.Model.Manga;
import manga.readder.R;
import manga.readder.api.APIGetManga;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    EditText edSearch;
    MangaAdapter adapter;
    Toolbar toolbar;
    FragmentManager manager;
    ActionBarDrawerToggle toggle;
    TruyenDAO truyenDAO;
    ArrayList<Manga> list;
    private SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        truyenDAO = new TruyenDAO(getApplicationContext());
        list = truyenDAO.getAll();
        adapter = new MangaAdapter(getApplicationContext(),0,list);
        drawerLayout = findViewById(R.id.drawerlayout);
        toolbar = findViewById(R.id.toolBar);

        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        setTitle("Truyện tranh");
        manager = getSupportFragmentManager();
        FragmentManga fragmentManga = new FragmentManga();
        manager.beginTransaction()
                .replace(R.id.flContent, fragmentManga)
                .commit();

        NavigationView nv = findViewById(R.id.navView);
        nv.setNavigationItemSelectedListener(item -> {
            manager = getSupportFragmentManager();
            switch (item.getItemId()) {
                case R.id.nav_truyen_tranh:
                    setTitle("Truyện tranh");
                    FragmentManga fragmentManga1 = new FragmentManga();
                    manager.beginTransaction()
                            .replace(R.id.flContent, fragmentManga1)
                            .commit();
                    break;
                case R.id.nav_bang_xep_hang:
                    setTitle("Bảng xếp hạng");
                    FragmentBangXepHang fragmentBangXepHang = new FragmentBangXepHang();
                    manager.beginTransaction()
                            .replace(R.id.flContent, fragmentBangXepHang)
                            .commit();
                    break;
                case R.id.nav_lich_su:
                    setTitle("Lịch sử ");
                    FragmentLichSu fragmentLichSu = new FragmentLichSu();
                    manager.beginTransaction()
                            .replace(R.id.flContent, fragmentLichSu)
                            .commit();
                    break;
                case R.id.nav_danh_sach_yt:
                    setTitle("Yêu thích");
                    FragmentDanhSachYT fragmentDanhSachYT = new FragmentDanhSachYT();
                    manager.beginTransaction()
                            .replace(R.id.flContent, fragmentDanhSachYT)
                            .commit();
                    break;
                case R.id.nav_danh_sach_dat_lich:
                    setTitle("Thông báo");
                    FragmentDanhSachDatLich fragmentDanhSachDatLich = new FragmentDanhSachDatLich();
                    manager.beginTransaction()
                            .replace(R.id.flContent, fragmentDanhSachDatLich)
                            .commit();
                    break;
            }
            drawerLayout.closeDrawers();
            return false;
        });


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }
    public void replaceFragment(Manga manga){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        InfoMangaFragment infoMangaFragment = new InfoMangaFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("obj_manga",manga);
        infoMangaFragment.setArguments(bundle);
        transaction.replace(R.id.flContent, infoMangaFragment)
                .addToBackStack(null);
        transaction.commit();
        setTitle(manga.getTenTruyen());


    }
    public void readManga(Chapter chapter){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        ReadMangaFragment readMangaFragment = new ReadMangaFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("obj_chapter",chapter);
        readMangaFragment.setArguments(bundle);
        transaction.replace(R.id.flContent, readMangaFragment)
                .addToBackStack(null);
        transaction.commit();
        setTitle(chapter.getTenChap());
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.search_menu,menu);
//        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        searchView = (SearchView) menu.findItem(R.id.actionsearch).getActionView();
//        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
//        searchView.setMaxWidth(Integer.MAX_VALUE);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                adapter.getFilter().filter(query);
//
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                adapter.getFilter().filter(newText);
//                return false;
//            }
//        });
//        return true;
//    }
}