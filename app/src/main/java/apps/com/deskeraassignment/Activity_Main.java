package apps.com.deskeraassignment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Activity_Main extends AppCompatActivity {

    private FrameLayout fragment;
    SharedPreferences sharedPreferences;
    List<ListItem> listSubscribers = new ArrayList<ListItem>();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_profile:
                    Fragment_Profile fragmentProfile = new Fragment_Profile();
                    FragmentTransaction fragmentTransactionProfile = getSupportFragmentManager().beginTransaction();
                    fragmentTransactionProfile.replace(R.id.fragment_frame, fragmentProfile);
                    fragmentTransactionProfile.commit();
                    return true;
                case R.id.navigation_items:
                    Fragment_Items fragmentItems = Fragment_Items.newInstance();
                    FragmentTransaction fragmentTransactionItems = getSupportFragmentManager().beginTransaction();
                    fragmentTransactionItems.replace(R.id.fragment_frame, fragmentItems);
                    fragmentTransactionItems.commit();
                    return true;
                case R.id.navigation_favourites:
                    Fragment_Favourites fragmentFavourites = Fragment_Favourites.newInstance();
                    FragmentTransaction fragmentTransactionFavourites = getSupportFragmentManager().beginTransaction();
                    fragmentTransactionFavourites.replace(R.id.fragment_frame, fragmentFavourites);
                    fragmentTransactionFavourites.commit();
                    return true;
                case R.id.navigation_table:
                    Fragment_Table fragmentTable = Fragment_Table.newInstance();
                    FragmentTransaction fragmentTransactionTable = getSupportFragmentManager().beginTransaction();
                    fragmentTransactionTable.replace(R.id.fragment_frame, fragmentTable);
                    fragmentTransactionTable.commit();
                    return true;
                case R.id.navigation_setting:
                    Fragment_Settings fragmentSettings = Fragment_Settings.newInstance();
                    FragmentTransaction fragmentTransactionSettings = getSupportFragmentManager().beginTransaction();
                    fragmentTransactionSettings.replace(R.id.fragment_frame, fragmentSettings);
                    fragmentTransactionSettings.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment = (FrameLayout) findViewById(R.id.fragment_frame);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        sharedPreferences = getSharedPreferences("sharedPreferences", Context.MODE_PRIVATE);

        List<ListItem> initialItemInfoList = initItemInfoList();
        Gson gson = new Gson();
        String itemInfoListJsonString = gson.toJson(initialItemInfoList);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("itemlist", itemInfoListJsonString);
        editor.commit();
    }

    private List<ListItem> initItemInfoList()
    {
        List<ListItem> ret = new ArrayList<ListItem>();

        ListItem user1 = new ListItem();
        user1.setStringName("Grapes");
        user1.setStringCategory("A");
        user1.setStringDescription("Fruit");
        ret.add(user1);

         user1 = new ListItem();
        user1.setStringName("Tomatos");
        user1.setStringCategory("B");
        user1.setStringDescription("Vegetable");
        ret.add(user1);

         user1 = new ListItem();
        user1.setStringName("Apple");
        user1.setStringCategory("A");
        user1.setStringDescription("Fruit");
        ret.add(user1);

         user1 = new ListItem();
        user1.setStringName("Potatoes");
        user1.setStringCategory("B");
        user1.setStringDescription("Vegetable");
        ret.add(user1);

         user1 = new ListItem();
        user1.setStringName("PineApple");
        user1.setStringCategory("A");
        user1.setStringDescription("Fruit");
        ret.add(user1);

         user1 = new ListItem();
        user1.setStringName("Cucumber");
        user1.setStringCategory("B");
        user1.setStringDescription("Vegetable");
        ret.add(user1);

         user1 = new ListItem();
        user1.setStringName("Banana");
        user1.setStringCategory("A");
        user1.setStringDescription("Fruit");
        ret.add(user1);

        user1 = new ListItem();
        user1.setStringName("Onion");
        user1.setStringCategory("B");
        user1.setStringDescription("Vegetable");
        ret.add(user1);

        return ret;
    }
}
