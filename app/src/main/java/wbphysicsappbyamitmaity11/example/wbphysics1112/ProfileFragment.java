package wbphysicsappbyamitmaity11.example.wbphysics1112;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ProfileFragment extends Fragment {

    private LinearLayout linearLayout1,linearLayout2,linearLayout4,linearLayout5;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate ( R.layout.fragment_profile, container, false );


        linearLayout1 = view.findViewById ( R.id.aboureally );
        linearLayout2 = view.findViewById ( R.id.contactreally );
        linearLayout4 = view.findViewById ( R.id.sharereally );
        linearLayout5 = view.findViewById ( R.id.account_in_support_lay );






        linearLayout1.setOnClickListener ( new View.OnClickListener () {
            public void onClick(View view) {
                Intent intent = new Intent ( getActivity (),AboutusActivity.class );
                startActivity ( intent );
            }
        } );
        linearLayout2.setOnClickListener ( new View.OnClickListener () {
            public void onClick(View view) {
                Intent intentt = new Intent ( getActivity (),ContactUSActivity.class );
                startActivity ( intentt );
            }
        } );
        linearLayout5.setOnClickListener ( new View.OnClickListener () {
            public void onClick(View view) {
                Intent intenttr = new Intent ( getActivity (),SupportActivity.class );
                startActivity ( intenttr );
            }
        } );


        linearLayout4.setOnClickListener ( new View.OnClickListener () {
            public void onClick(View view) {
                Intent sendIntent = new Intent (  Intent.ACTION_SEND);
                sendIntent.putExtra ( Intent.EXTRA_TEXT,
                        "\n\nPlease Download HS Physics 2021 From Google PlayStore:-\n" +
                                "\n\nhttps://play.google.com/store/apps/details?id=hsfinheejeamitjeeellojeerphysicshumnagamaortk.example.wbchsephysicshungama");
                sendIntent.putExtra ( Intent.EXTRA_SUBJECT,"WBCHSE Physics Life App" );
                sendIntent.setType ( "text/plain" );
                Intent shareIntent = Intent.createChooser ( sendIntent,"WBCHSE Physics Life App" );
                startActivity ( shareIntent );
            }
        } );


        return view;
    }


}