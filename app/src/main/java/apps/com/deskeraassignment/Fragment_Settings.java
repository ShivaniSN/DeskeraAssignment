package apps.com.deskeraassignment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment_Settings extends Fragment{

    TextView textViewTemperature,textViewViewDetails,textViewDateOfProbation;
    SwitchCompat switchCompatSound,switchCompatNotifications;
    String stringTemperatureUnit = "",stringIsSoundOn = "",stringIsNotificationOn = "";

    public static Fragment_Settings newInstance() {

        return new Fragment_Settings();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_settings, container, false);

        textViewTemperature = (TextView) view.findViewById(R.id.tv_temp);
        textViewViewDetails = (TextView) view.findViewById(R.id.tv_viewdetails);
        textViewDateOfProbation = (TextView) view.findViewById(R.id.tv_dop);
        switchCompatSound  = (SwitchCompat)view.findViewById(R.id.sc_sound);
        switchCompatNotifications  = (SwitchCompat)view.findViewById(R.id.sc_notifications);

        textViewViewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (stringTemperatureUnit.equals("")){
                    Toast.makeText(getContext(),"Select Temperature Unit",Toast.LENGTH_LONG).show();
                }else {
                    Intent i = new Intent(getContext(), Activity_ViewDetails.class);
                    i.putExtra("issound", stringIsSoundOn);
                    i.putExtra("isnotification", stringIsNotificationOn);
                    i.putExtra("tempunit", stringTemperatureUnit);
                    i.putExtra("dop", textViewDateOfProbation.getText());
                    startActivity(i);
                }
            }
        });

        textViewTemperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.dialog_temperature);

                // set the custom dialog components - text, image and button
                Button buttonFarhenheit = (Button) dialog.findViewById(R.id.btn_farhenheit);
                Button buttonCelcius = (Button) dialog.findViewById(R.id.btn_celcius);

                // if button is clicked, close the custom dialog
                buttonFarhenheit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        stringTemperatureUnit = "Farhenheit";
                        textViewTemperature.setText(stringTemperatureUnit);
                        dialog.dismiss();
                    }
                });

                buttonCelcius.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        stringTemperatureUnit = "Celcius";
                        textViewTemperature.setText(stringTemperatureUnit);
                        dialog.dismiss();
                    }
                });
                        dialog.show();
            }
        });

        switchCompatSound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    stringIsSoundOn = "True";
                }else {
                    stringIsSoundOn = "False";
                }
            }
        });

        switchCompatNotifications.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    stringIsNotificationOn = "True";
                }else {
                    stringIsNotificationOn = "False";
                }
            }
        });

        return view;
    }
}
