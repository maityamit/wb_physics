package wbphysicsappbyamitmaity11.example.wbphysics1112;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class SupportActivity extends AppCompatActivity {


    private EditText name,email,topic,subject;
    private Button button;


    private LinearLayout linearLayout,show_layout;
    private final String stringid = "sequre_choice";
    private ProgressDialog progressDialog;
    private TextView idnotext;
    private DatabaseReference RootRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);


        RootRef= FirebaseDatabase.getInstance ().getReference ();

        name = findViewById(R.id.request_name);
        email = findViewById(R.id.request_email);
        topic = findViewById(R.id.request_topic);
        subject = findViewById(R.id.request_subject);
        button = findViewById(R.id.request_button);

        linearLayout = findViewById(R.id.hidden_layout);
        progressDialog = new ProgressDialog(this);
        progressDialog.setContentView ( R.layout.loading );
        progressDialog.setTitle ( "Please Wait" );
        progressDialog.setMessage ( "Tips: Please Cheak your Internet or Wi-fi Connection" );
        progressDialog.setCanceledOnTouchOutside ( false );

        idnotext = findViewById(R.id.hidden_text);
        show_layout = findViewById(R.id.show_layout);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RaiseARequest();
            }
        });

    }

    private void RaiseARequest() {

        String stringname = name.getText().toString();
        String stringemail = email.getText().toString();
        String stringtopic = topic.getText().toString();
        String stringsubject = subject.getText().toString();


        if (TextUtils.isEmpty ( stringname ))
        {
            Toast.makeText (SupportActivity.this, "Enter Something.", Toast.LENGTH_SHORT ).show ();
        }
        else if (TextUtils.isEmpty ( stringemail))
        {
            Toast.makeText ( SupportActivity.this, "Enter Something.", Toast.LENGTH_SHORT ).show ();
        }
        else if (TextUtils.isEmpty ( stringtopic ))
        {
            Toast.makeText (SupportActivity.this, "Enter Something.", Toast.LENGTH_SHORT ).show ();
        }
        else if (TextUtils.isEmpty ( stringsubject))
        {
            Toast.makeText ( SupportActivity.this, "Enter Something.", Toast.LENGTH_SHORT ).show ();
        }
        else {
            progressDialog.show();
            Map<String, Object> update = new HashMap<>();
            update.put("Name",stringname);
            update.put("Email",stringemail);
            update.put("Topic",stringtopic);
            update.put("Details",stringsubject);


            String key = RootRef.child("SupportQuarry").push().getKey();


            RootRef.child("SupportQuarry").child(key).updateChildren(update).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful())
                    {
                        show_layout.setVisibility(View.GONE);
                        linearLayout.setVisibility(View.VISIBLE);
                        idnotext.setText("Your Request ID is: "+ "\n" + key);
                        Toast.makeText(SupportActivity.this, "Done !", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                    else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(SupportActivity.this, "Error ! ", Toast.LENGTH_SHORT).show();

                    }
                }
            });

        }

    }



}