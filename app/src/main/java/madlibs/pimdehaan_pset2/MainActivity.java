package madlibs.pimdehaan_pset2;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStartMadlibs(View view) {
        Intent FillWordsIntent = new Intent(this,
                FillWords.class);
        final int result = 1;
        startActivity(FillWordsIntent);
    }
}
