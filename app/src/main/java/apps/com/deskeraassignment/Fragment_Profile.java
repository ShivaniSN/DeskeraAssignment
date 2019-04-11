package apps.com.deskeraassignment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Fragment_Profile extends Fragment{
    public static Fragment_Profile newInstance() {

        return new Fragment_Profile();
    }

    private CollapsingToolbarLayout collapsingToolbarLayout = null;
    Toolbar toolbar;
    ActionBar actionBar;
    ImageView imageViewPoster;
    TextView textViewHobby,textViewEmail,textViewDateOfJoining;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_profile, container, false);

        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        collapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);
        textViewEmail = (TextView) view.findViewById(R.id.tv_email);
        textViewHobby = (TextView) view.findViewById(R.id.tv_hobby);
        textViewDateOfJoining = (TextView) view.findViewById(R.id.tv_doj);
        imageViewPoster = (ImageView) view.findViewById(R.id.iv_Movie);

        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        return view;
    }
}
