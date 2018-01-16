package fr.emilienleroy.todo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private ListView list;
    //ArrayList<String> name_tab = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    //private TextView input_text;
    private FloatingActionButton button;
    private FloatingActionButton delete;
    SharedPreferences save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        save = getSharedPreferences("PREFS", MODE_PRIVATE);
        loaddata();

        list = (ListView) findViewById(R.id.listView);
        //input_text = (TextView) findViewById(R.id.text);
        button = (FloatingActionButton ) findViewById(R.id.button);
        delete = (FloatingActionButton ) findViewById(R.id.delete);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Todo_Activity(v);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete_text(v);
            }
        });

        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, Singleton.getInstance().get_list());
        list.setAdapter(adapter);
    }

    private void delete_text(View v) {
        Singleton.getInstance().clear_list();
        adapter.notifyDataSetChanged();
        savedata();
    }

    /**
    private void Insert_Text(View v) {
        String text = input_text.getText().toString();
        Singleton.getInstance().add_list(text);
        adapter.notifyDataSetChanged();
    }
    */

    private void Todo_Activity(View v){
        Intent myIntent = new Intent(getApplicationContext(),TodoActivity.class);
        startActivityForResult(myIntent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1)
        {
            if (resultCode==RESULT_OK)
            {
                String s = data.getStringExtra("etat");
                Singleton.getInstance().add_list(s);
                savedata();
            }
        }
    }

    private void savedata() {
        SharedPreferences.Editor editor = save.edit();
        Set<String> set = new HashSet<String>();
        set.addAll(Singleton.getInstance().get_list());
        editor.putStringSet("DATE_LIST", set);
        editor.commit();
    }

    private void loaddata() {
        Set<String> set = save.getStringSet("DATE_LIST", null);
        Singleton.getInstance().addAll(set);
    }

}
