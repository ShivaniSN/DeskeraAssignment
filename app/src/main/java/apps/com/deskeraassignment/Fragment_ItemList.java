package apps.com.deskeraassignment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Fragment_ItemList extends Fragment{

    RecyclerView recyclerView;

    private Adapter_Recycler_Favourites itemAdapter;
    List<ListItem> itemList = new ArrayList<ListItem>();
    SharedPreferences sharedPreferences;
    String stringItemList = "";

    public static Fragment_ItemList newInstance() {

        return new Fragment_ItemList();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_itemlist, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_viewItem);
        itemAdapter = new Adapter_Recycler_Favourites(itemList);
        sharedPreferences = getContext().getSharedPreferences("sharedPreferences", Context.MODE_PRIVATE);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(itemAdapter);

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
