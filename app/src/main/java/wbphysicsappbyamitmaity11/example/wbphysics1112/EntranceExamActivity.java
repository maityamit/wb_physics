package wbphysicsappbyamitmaity11.example.wbphysics1112;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EntranceExamActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private DatabaseReference StudentRef;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_d_p_p_main );


        StudentRef = FirebaseDatabase.getInstance ().getReference ().child ( "Entrance" );
        progressDialog = new ProgressDialog ( EntranceExamActivity.this);





        progressDialog.setContentView ( R.layout.loading );
        progressDialog.setTitle ( "Please Wait..." );
        progressDialog.setCanceledOnTouchOutside ( false );
        progressDialog.setMessage ( "Tips: Please Cheak your Internet or Wi-fi Connection" );


        recyclerView = findViewById ( R.id.RecycleAlltheEntrance );
        recyclerView.setLayoutManager ( new LinearLayoutManager ( EntranceExamActivity.this));
    }

    @Override
    public void onStart() {
        super.onStart ();

        progressDialog.show ();


        FirebaseRecyclerOptions<Contacts2> options =
                new FirebaseRecyclerOptions.Builder<Contacts2> ()
                        .setQuery ( StudentRef,Contacts2.class )
                        .build ();


        FirebaseRecyclerAdapter<Contacts2, StudentViewHolder3> adapter =
                new FirebaseRecyclerAdapter<Contacts2, StudentViewHolder3> (options) {
                    @Override
                    protected void onBindViewHolder(@NonNull final StudentViewHolder3 holder, final int position, @NonNull final Contacts2 model) {





                        holder.ExamName.setText ( model.getExamName ());
                        holder.ExamType.setText ( model.getExamType ());
                        final String string = model.getLink ();
                        progressDialog.dismiss ();

                        holder.cardView.setOnClickListener ( new View.OnClickListener () {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent ( EntranceExamActivity.this,pdfviewerActivity.class );
                                intent.putExtra ( "KOR1",string );
                                startActivity ( intent );
                            }
                        } );






                    }

                    @NonNull
                    @Override
                    public StudentViewHolder3 onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
                        View view  = LayoutInflater.from ( viewGroup.getContext () ).inflate ( R.layout.entranceexamlayout,viewGroup,false );
                        StudentViewHolder3 viewHolder  = new StudentViewHolder3 (  view);
                        return viewHolder;

                    }
                };
        recyclerView.setAdapter ( adapter );
        adapter.startListening ();




    }


    public static class StudentViewHolder3 extends  RecyclerView.ViewHolder
    {

        CardView cardView;
        TextView ExamName,ExamType;
        public StudentViewHolder3(@NonNull View itemView) {
            super ( itemView );
            ExamName = itemView.findViewById ( R.id.entranceexamname );
            ExamType = itemView.findViewById ( R.id.entranceexamtype);
            cardView = itemView.findViewById ( R.id.entranceexamcard );
        }
    }
}