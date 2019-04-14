package apps.com.deskeraassignment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class Fragment_Table extends Fragment{

    ImageButton imageButtonAddNewData;

    public static Fragment_Table newInstance() {

        return new Fragment_Table();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_table, container, false);

        imageButtonAddNewData = (ImageButton)view.findViewById(R.id.ib_add);

        imageButtonAddNewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.dialog_temperature);

                // set the custom dialog components - text, image and button
                EditText editTextData = (EditText) dialog.findViewById(R.id.btn_farhenheit);
                Button buttonAdd = (Button) dialog.findViewById(R.id.btn_celcius);

                // if button is clicked, close the custom dialog
                buttonAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        stringTemperatureUnit = "Farhenheit";
//                        textViewTemperature.setText(stringTemperatureUnit);
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        return view;
    }
}
