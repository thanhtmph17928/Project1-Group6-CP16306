package manga.readder.Activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import manga.readder.R;


public class DetailFragment extends Fragment {
    public static final String TAG = DetailFragment.class.getName();

    private TextView tvName;
    private Button btnBack;
    private MainActivity2 mMainActivity2;
    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_detail, container, false);
        tvName = mView.findViewById(R.id.tvName);
        btnBack = mView.findViewById(R.id.btnBack);

        Bundle bundleRecive = getArguments();
        if (bundleRecive!=null){
            User user = (User) bundleRecive.get("obj_user");
            if (user!=null) {
                tvName.setText(user.getName());
            }
        }
        btnBack.setOnClickListener(v -> {
            UserAdapter userAdapter = new UserAdapter(listGetUser(), new UserAdapter.ItemClickListener() {
                @Override
                public void onClickItemUser(User user) {
                    mMainActivity2.goToMangaFragment(user);
                }
            });
        });


        return mView;
    }

    private List<User> listGetUser() {
        List<User> list = new ArrayList<>();
        list.add(new User("a"));
        return list;
    }
}