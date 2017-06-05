package beerbear.applogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Main2Activity extends AppCompatActivity {

    private TextView tUser, tMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tUser = (TextView) findViewById(R.id.tUser);
        tMail = (TextView) findViewById(R.id.tMail);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            String name = user.getDisplayName();
            String email = user.getEmail();
            //Uri photoUrl = user.getPhotoUrl();

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getToken() instead.
            String uid = user.getUid();
            tUser.setText(name);
            tMail.setText(email);
        }else{
            goMainActivity();
        }
        //Profile perfil = com.facebook.Profile.getCurrentProfile();

    }

    private void goMainActivity() {
        Intent intent = new Intent(Main2Activity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void logOut(View view) {

        LoginManager.getInstance().logOut();
        FirebaseAuth.getInstance().signOut();
        goMainActivity();
    }
}
