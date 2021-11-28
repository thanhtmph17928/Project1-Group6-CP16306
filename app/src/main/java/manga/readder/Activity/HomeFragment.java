package manga.readder.Activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import manga.readder.R;

public class HomeFragment extends Fragment {
    private RecyclerView rcvUser;
    private View mView;
    private MainActivity2 mMainActivity2;

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_home, container, false);
        mMainActivity2 = (MainActivity2) getActivity();

        rcvUser = mView.findViewById(R.id.rcvUser);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mMainActivity2);
        rcvUser.setLayoutManager(linearLayoutManager);

        UserAdapter userAdapter = new UserAdapter(listGetUser(), new UserAdapter.ItemClickListener() {
            @Override
            public void onClickItemUser(User user) {
                mMainActivity2.goToDetailFragment(user);
            }
        });
        rcvUser.setAdapter(userAdapter);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(mMainActivity2,DividerItemDecoration.VERTICAL);
        rcvUser.addItemDecoration(itemDecoration);
        return mView;
    }

    private List<User> listGetUser() {
        List<User> list = new ArrayList<>();
        for (int i = 1;i<=20;i++){
            list.add(new User("this user "+i));

        }
        return list;
    }
}