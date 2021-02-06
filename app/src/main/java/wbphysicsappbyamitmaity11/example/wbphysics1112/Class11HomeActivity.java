package wbphysicsappbyamitmaity11.example.wbphysics1112;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Class11HomeActivity extends AppCompatActivity {

    private LinearLayout problems,solution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_class11_home );

        problems = findViewById ( R.id.class11learning );
        solution = findViewById ( R.id.class11solutions );



    }
}