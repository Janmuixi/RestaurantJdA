package com.example.jan.restaurantapp;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements WelcomeFragment.OnFragmentInteractionListener, CrearReservaFragment.OnFragmentInteractionListener, ListaReservasFragment.OnFragmentInteractionListener{
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = new WelcomeFragment();
        fm.beginTransaction().replace(R.id.fragmentContainer, fragment).commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.line1:
                FragmentManager fm = getSupportFragmentManager();
                Fragment fragment = new CrearReservaFragment();
                fm.beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
                break;
            case R.id.line2:
                fm = getSupportFragmentManager();
                fragment = new ListaReservasFragment();
                fm.beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void pasarALista() {
    }
}
