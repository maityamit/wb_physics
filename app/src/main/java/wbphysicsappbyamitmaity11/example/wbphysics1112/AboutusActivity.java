package wbphysicsappbyamitmaity11.example.wbphysics1112;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;




public class AboutusActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_aboutus );


    }


    public void HowTOUSEThisAPppp(View view) {
        Intent intent = new Intent ( AboutusActivity.this,pdfviewerActivity.class );
        intent.putExtra ( "KOR1","https://youtu.be/RqJABTvF06g" );
        startActivity ( intent );
    }
}