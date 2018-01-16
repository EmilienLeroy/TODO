package fr.emilienleroy.todo;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by eleroy on 16/01/2018.
 */

public class Singleton {

    private static volatile Singleton instance = null;
    ArrayList<String> name_tab = new ArrayList<String>();

    private Singleton() {
        super();
    }

    public final static Singleton getInstance() {
        if (Singleton.instance == null) {
            synchronized(Singleton.class) {
                if (Singleton.instance == null) {
                    Singleton.instance = new Singleton();
                }
            }
        }
        return Singleton.instance;
    }

    public ArrayList get_list() {
       return this.name_tab;
    }

    public void clear_list() {
         this.name_tab.clear();
    }

    public void add_list(String data){
        this.name_tab.add(data);
    }

}
