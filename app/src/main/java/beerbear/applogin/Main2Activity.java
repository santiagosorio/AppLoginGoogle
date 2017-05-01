package beerbear.applogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.Profile;
import com.facebook.login.LoginManager;

public class Main2Activity extends AppCompatActivity {

    private TextView tUser, tMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tUser = (TextView) findViewById(R.id.tUser);
        tMail = (TextView) findViewById(R.id.tMail);

        if (AccessToken.getCurrentAccessToken()== null){
            goMainActivity();
        }
        Profile perfil = com.facebook.Profile.getCurrentProfile();
        tUser.setText(perfil.getName());
        tMail.setText(perfil.getId());
    }

    private void goMainActivity() {
        Intent intent = new Intent(Main2Activity.this,MainActivity.class);
        startActivity(intent);
    }

    public void logOut(View view) {
        LoginManager.getInstance().logOut();
        goMainActivity();
    }
}
