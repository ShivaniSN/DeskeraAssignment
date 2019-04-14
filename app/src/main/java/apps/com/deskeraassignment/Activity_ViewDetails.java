package apps.com.deskeraassignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class Activity_ViewDetails extends AppCompatActivity{

    ImageView imageViewBack;
    TextView textViewTemperature,textViewSound,textViewNotifications,textViewDateOfProbation;
    String stringDateofJoining = "",stringDateofProbation = "";

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdetails);

        imageViewBack = (ImageView)findViewById(R.id.imageviewback);
        textViewSound = (TextView)findViewById(R.id.tv_sound);
        textViewNotifications = (TextView)findViewById(R.id.tv_notifications);
        textViewTemperature = (TextView)findViewById(R.id.tv_temp);
        textViewDateOfProbation = (TextView)findViewById(R.id.tv_dop);

        textViewSound.setText(getIntent().getStringExtra("issound"));
        textViewNotifications.setText(getIntent().getStringExtra("isnotification"));
        textViewTemperature.setText(getIntent().getStringExtra("tempunit"));
        textViewDateOfProbation.setText(getIntent().getStringExtra("dop"));

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
