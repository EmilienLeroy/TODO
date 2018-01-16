package fr.emilienleroy.todo;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TodoActivity extends AppCompatActivity {

    private TextView input_text;
    private Button val;
    private Button del;
    private static final int MON_ACTIVITE_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        input_text = (TextView) findViewById(R.id.editText);
        val = (Button) findViewById(R.id.Valider);
        del = (Button ) findViewById(R.id.Delete);

        val.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activiteTerminee(true,true,input_text.getText().toString());
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete(v);
            }
        });

    }

    private void delete(View v) {
        Intent myIntent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(myIntent);
    }

    private void activiteTerminee(boolean resultat, boolean etatHyperactif, String data){
        if (resultat){
            Intent fermetureMonActivite = new Intent();
            if (etatHyperactif){
                fermetureMonActivite.putExtra("etat",data);
            }else{
                fermetureMonActivite.putExtra("etat",data);
            }
            setResult(RESULT_OK,fermetureMonActivite);
        }else{
            setResult(RESULT_CANCELED);
        }
        finish();
    }

}
