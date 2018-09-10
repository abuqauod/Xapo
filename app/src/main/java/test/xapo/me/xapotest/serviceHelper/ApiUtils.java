package test.xapo.me.xapotest.serviceHelper;

import test.xapo.me.xapotest.ui.Constants;

/**
 * Created by Mohammad
 * on 9/10/2018 9:10 AM.
 */

public class ApiUtils {

    private static final String BASE_URL = Constants.BASE_URL;

    public static GitHubInterface getInstance() {
        return RetrofitClient.getClient(BASE_URL).create(GitHubInterface.class);
    }

}
