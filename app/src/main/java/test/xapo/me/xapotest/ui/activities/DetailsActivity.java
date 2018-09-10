package test.xapo.me.xapotest.ui.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import test.xapo.me.xapotest.R;
import test.xapo.me.xapotest.models.Trending;
import test.xapo.me.xapotest.ui.Constants;

public class DetailsActivity extends AppCompatActivity {
    ProgressDialog mProgress;
    Trending mTrending;
    ImageView mAvatar;
    TextView mTitle;
    TextView mSubtitle;
    TextView mLink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        intiControls();
        loadTrending();

    }

    private void intiControls() {
        mProgress = new ProgressDialog(this);
        mAvatar = findViewById(R.id.avatar_image_view);
        mTitle = findViewById(R.id.title_text_view);
        mSubtitle = findViewById(R.id.subtitle_text_view);
        mLink = findViewById(R.id.link_text_view);
    }

    private void loadTrending() {
        mTrending = (Trending) getIntent().getSerializableExtra(Constants.EXTRA_DETAILS);
        Picasso.get().load(mTrending.getAvatar()).into(mAvatar);
        mTitle.setText(mTrending.getName());
        if (mTrending.getRepo() != null) {
            mSubtitle.setText(mTrending.getRepo().getDescription());
            mLink.setText(mTrending.getRepo().getUrl());
        } else {
            mSubtitle.setText(mTrending.getUsername());
        }
    }

}
