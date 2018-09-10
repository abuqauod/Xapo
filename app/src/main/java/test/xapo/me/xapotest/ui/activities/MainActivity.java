package test.xapo.me.xapotest.ui.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import test.xapo.me.xapotest.R;
import test.xapo.me.xapotest.models.Trending;
import test.xapo.me.xapotest.serviceHelper.ApiUtils;
import test.xapo.me.xapotest.serviceHelper.GitHubInterface;
import test.xapo.me.xapotest.ui.adapters.CustomAdapter;

public class MainActivity extends AppCompatActivity {
    GitHubInterface mInterface;
    ProgressDialog mProgress;
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiControls();
        loadTrending();
    }

    private void intiControls() {
        mProgress = new ProgressDialog(this);
        mRecyclerView = findViewById(R.id.main_activity_recycler);
    }

    private void loadTrending() {
        mProgress.setMessage("Loading....");
        mProgress.show();
        mInterface = ApiUtils.getInstance();
        mInterface.getTrending("android").enqueue(new Callback<ArrayList<Trending>>() {
            @Override
            public void onResponse(Call<ArrayList<Trending>> call, Response<ArrayList<Trending>> response) {
                mProgress.hide();
                ArrayList<Trending> body = response.body();
                if (body != null)
                    generateDataList(body);
            }

            @Override
            public void onFailure(Call<ArrayList<Trending>> call, Throwable t) {
                mProgress.hide();
            }
        });
    }

    private void generateDataList(ArrayList<Trending> photoList) {
        CustomAdapter adapter = new CustomAdapter(this, photoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);
    }
}
