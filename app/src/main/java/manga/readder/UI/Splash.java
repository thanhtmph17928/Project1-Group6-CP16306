package manga.readder.UI;

import androidx.appcompat.app.AppCompatActivity;

import manga.readder.Fragment.FragmentManga;
import manga.readder.Model.Manga;
import manga.readder.R;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },1500);
    }
}