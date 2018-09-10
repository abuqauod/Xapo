package test.xapo.me.xapotest.serviceHelper;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import test.xapo.me.xapotest.models.Trending;

/**
 * Created by Mohammad
 * on 9/10/2018 9:08 AM.
 */
public interface GitHubInterface {


    @GET("/developers")
    Call<ArrayList<Trending>> getTrending(@Query("language") String language);
}
