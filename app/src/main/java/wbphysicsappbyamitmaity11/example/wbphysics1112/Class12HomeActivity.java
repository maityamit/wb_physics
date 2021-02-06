package wbphysicsappbyamitmaity11.example.wbphysics1112;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;


public class Class12HomeActivity extends AppCompatActivity {

    private LinearLayout soulutions,learning,important;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_class12_home );

        soulutions = findViewById ( R.id.class12solutions );
        learning = findViewById ( R.id.class12learning);
        important= findViewById ( R.id.class12importantqn );



        soulutions.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                Intent intentrrt = new Intent ( Class12HomeActivity.this,Class12SolutionsActivity.class );
                startActivity ( intentrrt);
            }
        } );
        learning.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intentr = new Intent ( Class12HomeActivity.this,Class12ChapterActivity.class );
                startActivity ( intentr);

            }
        } );
        important.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intentry = new Intent ( Class12HomeActivity.this,Class12ImportantQn.class );
                startActivity ( intentry);

            }
        } );
    }

    public void Handle12(View view) {
        Intent intentryy = new Intent ( Class12HomeActivity.this,AboutusActivity.class );
        startActivity ( intentryy);
    }
}