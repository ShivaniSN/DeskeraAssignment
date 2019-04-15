package apps.com.deskeraassignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_EditSave extends AppCompatActivity {

    ImageView imageViewBack;
    TextView textViewEditSave,textViewTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittabledetails);

        imageViewBack = (ImageView)findViewById(R.id.imageviewback);
        textViewEditSave = (TextView)findViewById(R.id.tv_editsave);
        textViewTitle = (TextView)findViewById(R.id.tv_title);

        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity_EditSave.this, Activity_Main.class);
                startActivity(i);
            }
        });
    }

    @Override // prompt the user to to open activity_dashboard activity on back pressed.....
    public void onBackPressed() {
        Intent intent = new Intent(Activity_EditSave.this, Activity_Main.class);
        startActivity(intent);
    }
}
