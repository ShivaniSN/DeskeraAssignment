package apps.com.deskeraassignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class Activity_ViewDetails extends AppCompatActivity{

    ImageView imageViewBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdetails);

        imageViewBack = (ImageView)findViewById(R.id.imageviewback);

        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity_ViewDetails.this, Activity_Main.class);
                startActivity(i);
            }
        });
    }

    @Override // prompt the user to to open activity_dashboard activity on back pressed.....
    public void onBackPressed() {
        Intent intent = new Intent(Activity_ViewDetails.this, Activity_Main.class);
        startActivity(intent);
    }
}
