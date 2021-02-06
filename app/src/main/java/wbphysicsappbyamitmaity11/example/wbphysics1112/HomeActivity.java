package wbphysicsappbyamitmaity11.example.wbphysics1112;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import com.shreyaspatil.MaterialDialog.MaterialDialog;

public class HomeActivity extends AppCompatActivity {

    private ChipNavigationBar chipNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        chipNavigationBar = findViewById(R.id.chipami);
        chipNavigationBar.setItemSelected(R.id.homee, true);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment = null;
                switch (i) {
                    case R.id.homee:
                        fragment = new HomeFragment();
                        break;
                    case R.id.activity:
                        fragment = new StudyFragment();
                        break;
                    case R.id.settings:
                        fragment = new ProfileFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            }
        });

    }







    @Override
    public void onBackPressed() {


        MaterialDialog mDialog = new MaterialDialog.Builder ( this )
                .setTitle ( "Are you sure you want to exit ?" )
                .setCancelable ( false )
                .setPositiveButton ( "Exit",R.drawable.ic_baseline_cancel_24, new MaterialDialog.OnClickListener () {
                    @Override
                    public void onClick(com.shreyaspatil.MaterialDialog.interfaces.DialogInterface dialogInterface, int which) {
                        HomeActivity.super.onBackPressed ();
                    }


                } )
                .setNegativeButton ( "No", new MaterialDialog.OnClickListener () {
                    @Override
                    public void onClick(com.shreyaspatil.MaterialDialog.interfaces.DialogInterface dialogInterface, int which) {
                        dialogInterface.cancel ();
                    }

                } )
                .build ();

        // Show Dialog
        mDialog.show ();


    }





}