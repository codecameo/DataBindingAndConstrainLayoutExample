package bytes.wit.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

/**
 * Created by Md. Sifat-Ul Haque on 3/11/2017.
 */

public class UserInfoModel extends BaseObservable{

    private String firstName, lastName, password;
    private int age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        Log.d("Age","Age "+age);
        if (this.age != age){
            this.age = age;
            if (this.age != 0)
            notifyPropertyChanged(BR.age);
        }
    }
}
