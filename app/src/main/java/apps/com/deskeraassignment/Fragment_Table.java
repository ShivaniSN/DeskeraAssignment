package apps.com.deskeraassignment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(itemAdapter);

        imageButtonAddNewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.dialog_addnewdata);

                // set the custom dialog components - text, image and button
                EditText editTextItemName = (EditText) dialog.findViewById(R.id.et_enteritemname);
                EditText editTextItemDescription = (EditText) dialog.findViewById(R.id.et_enteritemdesc);
                EditText editTextItemCategory = (EditText) dialog.findViewById(R.id.et_enteritemcateg);
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

            }
        });

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), new RecyclerTouchListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent i = new Intent(getContext(), Activity_EditSave.class);
                i.putExtra("title",itemList.get(position).getStringName());
                startActivity(i);
            }
        }));

        stringItemList = sharedPreferences.getString("itemlist", "");
        Gson gson = new Gson();
        ListItem itemInfoDtoArray[] = gson.fromJson(stringItemList, ListItem[].class);

        for(int i=0;i<itemInfoDtoArray.length;i++)
        {
            // Get each user info in dto.
            ListItem userInfoDto = itemInfoDtoArray[i];
            ListItem lp = new ListItem();
            lp.setStringName(userInfoDto.getStringName());
            lp.setStringCategory(userInfoDto.getStringCategory());
            lp.setStringDescription(userInfoDto.getStringDescription());

            itemList.add(lp);
        }
        itemAdapter.notifyDataSetChanged();

        return view;
    }
}
