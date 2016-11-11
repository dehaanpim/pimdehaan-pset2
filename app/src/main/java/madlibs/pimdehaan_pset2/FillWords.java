package madlibs.pimdehaan_pset2;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static android.R.id.input;
import static madlibs.pimdehaan_pset2.R.id.edit_text;
import static madlibs.pimdehaan_pset2.R.layout.story_result;

/**
 * Created by Pim on 8-11-2016.
 */

public class FillWords extends Activity{
    private Story story;
    private InputStream inputStream;
    public String nextplaceholder;
    public int totalplaceholders;
    public String wordtype;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fill_words);
        AssetManager am = getAssets();

        try {
            //InputStream inputStream = null;
            story = new Story(inputStream);
            inputStream = am.open("madlib1_tarzan.txt");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void onConfirmWord(View view)
    {
        Intent ConfirmWordIntent = new Intent(this,
        FilledStory.class);

        for (int i = 0; i < totalplaceholders; i++){
            EditText wordinput = (EditText) findViewById(edit_text);
            String edittext = (String) wordinput.getText().toString();
            story.fillInPlaceholder(edittext);
        }
    }

    public void checkstory(Story story){
        EditText wordtype = (EditText) findViewById(R.id.edit_text);
        wordtype.setHint(nextplaceholder);

        if (!story.isFilledIn()){
            EditText wordinput = (EditText) findViewById(edit_text);
            String edittext = (String) wordinput.getText().toString();
            story.fillInPlaceholder(edittext);
            nextplaceholder = story.getNextPlaceholder();
            totalplaceholders = story.getPlaceholderCount();
        }
        else {

        }

    }

}
