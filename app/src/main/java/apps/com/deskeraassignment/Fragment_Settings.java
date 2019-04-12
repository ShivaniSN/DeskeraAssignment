package apps.com.deskeraassignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment_Settings extends Fragment{

    TextView textViewTemperature,textViewViewDetails;
    SwitchCompat switchCompatSound,switchCompatNotifications;

    public static Fragment_Settings newInstance() {

        return new Fragment_Settings();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_settings, container, false);

        textViewTemperature = (TextView) view.findViewById(R.id.tv_temp);
        textViewViewDetails = (TextView) view.findViewById(R.id.tv_viewdetails);
        switchCompatSound  = (SwitchCompat)view.findViewById(R.id.sc_sound);
        switchCompatNotifications  = (SwitchCompat)view.findViewById(R.id.sc_notifications);

        textViewViewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), Activity_ViewDetails.class);
                startActivity(i);
            }
        });

        textViewTemperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });

        return view;
    }
}
