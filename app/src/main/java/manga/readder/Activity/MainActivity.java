package manga.readder.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

import manga.readder.Adapter.MangaAdapter;
import manga.readder.Fragment.FragmentBangXepHang;
import manga.readder.Fragment.FragmentDanhSachDatLich;
import manga.readder.Fragment.FragmentDanhSachYT;
import manga.readder.Fragment.FragmentLichSu;
import manga.readder.Fragment.FragmentManga;
import manga.readder.Fragment.InfoMangaFragment;
import manga.readder.Fragment.ReadMangaFragment;
import manga.readder.Interface.GetManga;
import manga.readder.Model.Chapter;
import manga.readder.Model.Manga;
import manga.readder.R;
import manga.readder.api.APIGetManga;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    EditText edSearch;
    MangaAdapter adapter;
    Toolbar toolbar;
    FragmentManager manager;

    private static final int FRAGMENT_MANGA = 0;
    private static final int FRAGMENT_BANGXEPHANG = 1;
    private static final int FRAGMENT_LICHSU = 2;
    private static final int FRAGMENT_DANHSACHYT = 3;
    private static final int FRAGMENT_DANHSACHDATLICH = 4;

    private int CurrentFragment = FRAGMENT_MANGA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawerlayout);
        toolbar = findViewById(R.id.toolBar);

        //set toolbar
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

//        setTitle(getResources().getString(R.string.txt_bill));
        manager = getSupportFragmentManager();
        FragmentManga fragmentManga = new FragmentManga();
        manager.beginTransaction()
                .replace(R.id.flContent, fragmentManga)
                .commit();
        NavigationView nv = findViewById(R.id.navView);

//        mHeaderView = nv.getHeaderView(0);
//        edUser = mHeaderView.findViewById(R.id.tvUser);
//        Intent i = getIntent();
//        String user = i.getStringExtra("user");
//        librarianDAO = new LibrarianDAO(this);
//        librarian = librarianDAO.getID(user);
//        String userName = librarian.libName;
//        edUser.setText("Welcome " + userName + "!");
//
//
//        if (user.equalsIgnoreCase("admin")) {
//            nv.getMenu().findItem(R.id.sub_adduser).setVisible(true);
//        }

        nv.setNavigationItemSelectedListener(item -> {
            manager = getSupportFragmentManager();
            switch (item.getItemId()) {
                case R.id.nav_truyen_tranh:
//                    setTitle(getResources().getString(R.string.txt_bill));
                    FragmentManga fragmentManga1 = new FragmentManga();
                    manager.beginTransaction()
                            .replace(R.id.flContent, fragmentManga1)
                            .commit();
                    break;
                case R.id.nav_bang_xep_hang:
//                    setTitle(getResources().getString(R.string.txt_book_type));
                    FragmentBangXepHang fragmentBangXepHang = new FragmentBangXepHang();
                    manager.beginTransaction()
                            .replace(R.id.flContent, fragmentBangXepHang)
                            .commit();
                    break;
                case R.id.nav_lich_su:
//                    setTitle(getResources().getString(R.string.txt_book));
                    FragmentLichSu fragmentLichSu = new FragmentLichSu();
                    manager.beginTransaction()
                            .replace(R.id.flContent, fragmentLichSu)
                            .commit();
                    break;
                case R.id.nav_danh_sach_yt:
//                    setTitle(getResources().getString(R.string.txt_member));
                    FragmentDanhSachYT fragmentDanhSachYT = new FragmentDanhSachYT();
                    manager.beginTransaction()
                            .replace(R.id.flContent, fragmentDanhSachYT)
                            .commit();
                    break;
                case R.id.nav_danh_sach_dat_lich:
//                    setTitle(getResources().getString(R.string.txt_top));
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
        transaction.replace(R.id.flContent, infoMangaFragment);
        transaction.commit();
    }
    public void readManga(Chapter chapter){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        ReadMangaFragment readMangaFragment = new ReadMangaFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("obj_chapter",chapter);
        readMangaFragment.setArguments(bundle);
        transaction.replace(R.id.flContent, readMangaFragment);
        transaction.commit();
    }
    private void setClick() {
//        edSearch.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                String s = edSearch.getText().toString();
//                adapter.searchManga(s);
//            }
//        });
    }
}