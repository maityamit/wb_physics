package wbphysicsappbyamitmaity11.example.wbphysics1112;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import pl.droidsonroids.gif.GifImageView;


public class StudyFragment extends Fragment {

    private LinearLayout class11,class12,Entrance;
    private ProgressDialog progressDialog;
    private GifImageView gifImageView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate ( R.layout.fragment_study, container, false );
        class11 = view.findViewById ( R.id.class11);
        class12 = view.findViewById ( R.id.class12);
         Entrance = view.findViewById ( R.id.Entrancefragment);


        progressDialog = new ProgressDialog ( getContext ());

        gifImageView = view.findViewById(R.id.notifications_stydysection);






        gifImageView.setOnClickListener ( new View.OnClickListener () {

            public void onClick(View view) {
                Intent intentrrt = new Intent ( getActivity (),NotificationActivity.class );
                startActivity ( intentrrt);
            }
        } );

        progressDialog.setContentView ( R.layout.loading );
        progressDialog.setTitle ( "Please Wait..." );
        progressDialog.setCanceledOnTouchOutside ( false );
        progressDialog.setMessage ( "Tips: Please Cheak your Internet or Wi-fi Connection" );



        class11.setOnClickListener ( new View.OnClickListener () {

            public void onClick(View view) {
                Intent intenter = new Intent ( getActivity (),Class11HomeActivity.class );
                startActivity ( intenter );
            }
        } );

        class12.setOnClickListener ( new View.OnClickListener () {

            public void onClick(View view) {
                Intent intentrrt = new Intent ( getActivity (),Class12HomeActivity.class );
                startActivity ( intentrrt);
            }
        } );

        Entrance.setOnClickListener ( new View.OnClickListener () {
            public void onClick(View view) {
                Intent intentrrty = new Intent ( getActivity (),EntranceExamActivity.class );
                startActivity ( intentrrty);
            }
        } );

        return view;
    }




}