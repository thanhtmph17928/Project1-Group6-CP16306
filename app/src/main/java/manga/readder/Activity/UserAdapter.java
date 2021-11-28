package manga.readder.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import manga.readder.R;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{

    private List<User> mListUser;

    private ItemClickListener mItemClickListener;

    public interface ItemClickListener{
        void onClickItemUser(User user);
    }

    public UserAdapter(List<User> mListUser,ItemClickListener listener) {
        this.mListUser = mListUser;
        this.mItemClickListener = listener;
    }

    @NonNull
    @NotNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chap,parent,false);

        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull UserViewHolder holder, int position) {
        final User user = mListUser.get(position);
        if (user == null){
            return;
        }
        holder.tvName.setText(user.getName());
        holder.tvName.setOnClickListener(v -> {
            mItemClickListener.onClickItemUser(user);
        });

    }

    @Override
    public int getItemCount() {
        if (mListUser!=null){
            return mListUser.size();

        }        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
        private TextView tvName;
        public UserViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
        }
    }
}
