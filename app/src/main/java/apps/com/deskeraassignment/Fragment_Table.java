package apps.com.deskeraassignment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Table extends Fragment{

    ImageButton imageButtonAddNewData;
    TextView textViewEdit;
    RecyclerView recyclerView;

    private Adapter_Recycler_Item itemAdapter;
    List<ListItem> itemList = new ArrayList<ListItem>();
    SharedPreferences sharedPreferences;
    String stringItemList = "";

    public static Fragment_Table newInstance() {

        return new Fragment_Table();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_table, container, false);

        imageButtonAddNewData = (ImageButton)view.findViewById(R.id.ib_add);
        textViewEdit = (TextView) view.findViewById(R.id.tv_edit);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_viewItem);
        itemAdapter = new Adapter_Recycler_Item(itemList);
        sharedPreferences = getContext().getSharedPreferences("sharedPreferences", Context.MODE_PRIVATE);

        imageButtonAddNewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.dialog_addnewdata);

                // set the custom dialog components - text, image and button
                EditText editTextData = (EditText) dialog.findViewById(R.id.et_enterdata);
                Button buttonAdd = (Button) dialog.findViewById(R.id.btn_add);

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

        textViewEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), Activity_EditSave.class);
                startActivity(i);
            }
        });

        stringItemList = sharedPreferences.getString("itemlist", "");
        Gson gson = new Gson();
        ListItem itemInfoDtoArray[] = gson.fromJson(stringItemList, ListItem.class);

        return view;
    }
}
