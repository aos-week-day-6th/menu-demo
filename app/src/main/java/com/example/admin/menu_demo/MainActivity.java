package com.example.admin.menu_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView btnContextMenu;
    Button btnPopup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnContextMenu=findViewById(R.id.btnContextMenu);

        btnPopup=findViewById(R.id.btnPopupMenu);
        registerForContextMenu(btnContextMenu);


        btnPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu menu= new PopupMenu(MainActivity.this,v);
                menu.inflate(R.menu.context_menu);
                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.select:
                                btnContextMenu.setText("selected Text");
                                return true;
                            case R.id.copy:
                                return true;
                            case R.id.cut:
                                return true;
                            case R.id.past:
                                return true;

                            default: return false;
                        }
                    }
                });

                menu.show();
            }
        });
    }


    //crate context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.select:
                btnContextMenu.setText("selected Text");
                return true;
            case R.id.copy:
                return true;
            case R.id.cut:
                return true;
            case R.id.past:
                return true;

            default: return false;
        }
    }

    //create option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.option_menu,menu);
        //search view
        MenuItem searchItem= menu.findItem(R.id.search);
        SearchView searchView= (SearchView) searchItem.getActionView();
        //register event to searchView
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                MessageHelper.showMessage(MainActivity.this,""+s);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                Log.e("Search View", "onQueryTextChange: "+s );
                return true;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.share :
                    MessageHelper.showMessage(this,"I want this video to you.");
                return true;
            case R.id.download:
                    MessageHelper.showMessage(this,"I am downloading this video.");
                return true;
            case R.id.print:
                MessageHelper.showMessage(this,"I want to print this lyrics");
                return true;
            default: return false;
        }
    }


}
