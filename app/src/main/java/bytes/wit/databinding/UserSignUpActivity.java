package bytes.wit.databinding;

import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import bytes.wit.databinding.databinding.ActivityUserInfoBinding;

/**
 * Created by Md. Sifat-Ul Haque on 3/11/2017.
 */

public class UserSignUpActivity extends AppCompatActivity {

    private ActivityUserInfoBinding binding;
    private UserInfoModel mUserInfoModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_user_info);
        mUserInfoModel = new UserInfoModel();
        binding.setUserInfo(mUserInfoModel);
    }



}
