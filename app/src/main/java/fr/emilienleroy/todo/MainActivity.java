package fr.emilienleroy.todo;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView list;
    ArrayList<String> name_tab = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    private TextView input_text;
    private FloatingActionButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.listView);
        input_text = (TextView) findViewById(R.id.text);
        button = (FloatingActionButton ) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Insert_Text(v);
            }
        });

        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, name_tab);
        list.setAdapter(adapter);
    }

    private void Insert_Text(View v) {
        String text = input_text.getText().toString();
        name_tab.add(text);
        adapter.notifyDataSetChanged();
    }
}
