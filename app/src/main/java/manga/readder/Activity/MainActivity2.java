package manga.readder.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import manga.readder.Fragment.FragmentManga;
import manga.readder.R;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.content_frame,new HomeFragment());
        fragmentTransaction.commit();
    }
    public void goToDetailFragment(User user){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        DetailFragment detailFragment = new DetailFragment();
        FragmentManga fragmentManga = new FragmentManga();
        Bundle bundle = new Bundle();
        bundle.putSerializable("obj_user",user);
        detailFragment.setArguments(bundle);

        fragmentTransaction.replace(R.id.content_frame,detailFragment);
        fragmentTransaction.addToBackStack(DetailFragment.TAG);
        fragmentTransaction.commit();
    }
    public void goToMangaFragment(User user){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        DetailFragment detailFragment = new DetailFragment();
        FragmentManga fragmentManga = new FragmentManga();
//        Bundle bundle = new Bundle();
//        bundle.putSerializable("obj_user",user);
//        detailFragment.setArguments(bundle);

        fragmentTransaction.replace(R.id.content_frame,fragmentManga);
        fragmentTransaction.addToBackStack(DetailFragment.TAG);
        fragmentTransaction.commit();
    }
}