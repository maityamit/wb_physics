package wbphysicsappbyamitmaity11.example.wbphysics1112;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import pl.droidsonroids.gif.GifImageView;


public class HomeFragment extends Fragment {
    private SliderLayout sliderLayout;
    private LinearLayout linearLayout2,linearLayout3;
    private GifImageView gifImageView;
    private CircleImageView profileImagee;

    private TextView profiletext;
    private ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        View view = inflater.inflate ( R.layout.fragment_home, container, false );
        sliderLayout = view.findViewById(R.id.imageSlider);
        gifImageView = view.findViewById(R.id.notifications);
        sliderLayout.setIndicatorAnimation ( IndicatorAnimations.FILL);



        progressDialog = new ProgressDialog ( getContext ());




        progressDialog.setContentView ( R.layout.loading );
        progressDialog.setTitle ( "Please Wait..." );
        progressDialog.setCanceledOnTouchOutside ( false );
        progressDialog.setMessage ( "Tips: Please Cheak your Internet or Wi-fi Connection" );
        linearLayout2 = view.findViewById ( R.id.quizmainfragment );
        linearLayout3 = view.findViewById ( R.id.educationminster );





        gifImageView.setOnClickListener ( new View.OnClickListener () {

            public void onClick(View view) {
                Intent intentrrt = new Intent ( getActivity (),NotificationActivity.class );
                startActivity ( intentrrt);
            }
        } );

        sliderLayout.setScrollTimeInSec ( 1 );
        setSliderViews();


        linearLayout2.setOnClickListener ( new View.OnClickListener () {
            public void onClick(View view) {
                Intent intentrrtty = new Intent ( getActivity (),QuizHomeActivity.class );
                startActivity ( intentrrtty);
            }
        } );

        linearLayout3.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle (  );
                StudyFragment fragment = new StudyFragment ();
                fragment.setArguments ( bundle );
                ChipNavigationBar chipNavigationBar = getActivity ().findViewById ( R.id.chipami );
                chipNavigationBar.setItemSelected ( R.id.activity,true );
                getFragmentManager ().beginTransaction ().replace ( R.id.fragment_container,fragment ).commit ();
            }
        } );

        return view;
    }





    private void setSliderViews() {




        for (int i=0;i<=4;i++){
            DefaultSliderView sliderView = new DefaultSliderView (getContext ());
            switch (i){
                case 0:
                    sliderView.setImageDrawable ( R.drawable.mainslider);
                    break;
                case 1:
                    sliderView.setImageDrawable ( R.drawable.sliderclass11 );
                    break;
                case 2:
                    sliderView.setImageDrawable ( R.drawable.sliderclass12);
                    break;
                case 3:
                    sliderView.setImageDrawable ( R.drawable.sliderquiz );
                    break;
                case 4:
                    sliderView.setImageDrawable ( R.drawable.contactslider );
                    break;
            }
            sliderView.setImageScaleType ( ImageView.ScaleType.FIT_XY );
            sliderView.setOnSliderClickListener ( new SliderView.OnSliderClickListener () {
                @Override
                public void onSliderClick(SliderView sliderView) {

                }
            } );

            sliderLayout.addSliderView ( sliderView );
        }


    }



}