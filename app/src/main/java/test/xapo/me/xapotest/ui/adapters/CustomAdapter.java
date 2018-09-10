package test.xapo.me.xapotest.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import test.xapo.me.xapotest.R;
import test.xapo.me.xapotest.models.Trending;
import test.xapo.me.xapotest.ui.Constants;
import test.xapo.me.xapotest.ui.activities.DetailsActivity;

/**
 * Created by Mohammad
 * on 9/10/2018 9:15 AM.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    Context mContext;
    private ArrayList<Trending> dataList;

    public CustomAdapter(Context context, ArrayList<Trending> dataList) {
        this.dataList = dataList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list_row, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CustomViewHolder holder, int position) {
        Trending item = dataList.get(holder.getAdapterPosition());
        holder.mTxtTitle.setText(item.getName());
        Picasso.get().load(item.getAvatar()).into(holder.mAvatar);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailsActivity.class);
                intent.putExtra(Constants.EXTRA_DETAILS, dataList.get(holder.getAdapterPosition()));
                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        TextView mTxtTitle;
        ImageView mAvatar;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            mTxtTitle = mView.findViewById(R.id.item_row_title_txt);
            mAvatar = mView.findViewById(R.id.item_row_avatar);
        }
    }
}
