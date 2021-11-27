package manga.readder.UI;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import manga.readder.Adapter.MangaAdapter;
import manga.readder.Fragment.FragmentBangXepHang;
import manga.readder.Fragment.FragmentDanhSachDatLich;
import manga.readder.Fragment.FragmentDanhSachYT;
import manga.readder.Fragment.FragmentLichSu;
import manga.readder.Fragment.FragmentManga;
import manga.readder.Interface.GetManga;
import manga.readder.Model.Manga;
import manga.readder.R;
import manga.readder.api.APIGetManga;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    EditText edSearch;
    MangaAdapter adapter;
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
        edSearch = findViewById(R.id.edSearch);
        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawerlayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.nav_drawer_open,
                R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(this);

        replaceFragment(new FragmentManga());
        navigationView.getMenu().findItem(R.id.nav_truyen_tranh).setChecked(true);
        setClick();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id== R.id.nav_truyen_tranh){
            if(CurrentFragment != FRAGMENT_MANGA){
                replaceFragment(new FragmentManga());
                CurrentFragment = FRAGMENT_MANGA;
            }
        }else if(id== R.id.nav_bang_xep_hang){
            if(CurrentFragment != FRAGMENT_BANGXEPHANG){
                replaceFragment(new FragmentBangXepHang());
                CurrentFragment = FRAGMENT_BANGXEPHANG;
            }
        }else if(id== R.id.nav_lich_su){
            if(CurrentFragment != FRAGMENT_LICHSU){
                replaceFragment(new FragmentLichSu());
                CurrentFragment = FRAGMENT_LICHSU;
            }
        }else if(id== R.id.nav_danh_sach_yt){
            if(CurrentFragment != FRAGMENT_DANHSACHYT){
                replaceFragment(new FragmentDanhSachYT());
                CurrentFragment = FRAGMENT_DANHSACHYT;
            }
        }else if(id== R.id.nav_danh_sach_dat_lich){
            if(CurrentFragment != FRAGMENT_DANHSACHDATLICH){
                replaceFragment(new FragmentDanhSachDatLich());
                CurrentFragment = FRAGMENT_DANHSACHDATLICH;
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }
    private void replaceFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, fragment);
        transaction.commit();
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
}