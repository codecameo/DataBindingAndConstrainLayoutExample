package bytes.wit.databinding;

import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.databinding.OnRebindCallback;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

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
        /*binding.scroll.setEnabled(false);*/
        binding.addOnRebindCallback(new OnRebindCallback() {
            @Override
            public boolean onPreBind(ViewDataBinding binding) {
                TransitionManager.beginDelayedTransition(
                        (ViewGroup)binding.getRoot());
                return super.onPreBind(binding);
            }
        });

        mUserInfoModel = new UserInfoModel();
        binding.setUserInfo(mUserInfoModel);
    }



}
