package jimpatrizi.com.netrtl;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Button executeButton = (Button) findViewById(R.id.execute);
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        executeButton.setOnClickListener(new View.OnClickListener() {//make executeButtonOnClickListen
            @Override
            public void onClick(View v){
                Parameters.ATAN_MATH.append("Ben Sucks 69Hz");
                Parameters.ATAN_MATH.append("Ben Sucks ATAN MATH BALLS");
                Parameters.ATAN_MATH.append("Ben Sucks at 100MS/s");
                String dameon = "";
                for (Parameters p : Parameters.values())
                {
                    //if i want to fuck with sockets, later, do socket shit here
                    for(String s : p.getDameonCallableStrings()){
                        dameon += s;
                        dameon += "\n";
                    }
                    p.resetValues();
                }
                Toast.makeText(getApplicationContext(), dameon, Toast.LENGTH_LONG).show();
            }
        });

        //make this into a class

        //Create Modulation Mode Spinner
        String[] modeSpinner = new String[] {
                "WBFM", "AM", "USB", "LSB"
        };
        Spinner s = (Spinner) findViewById(R.id.modeSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, modeSpinner);
        s.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //end spinner


        //put below inits inside a function and call
        Button increment1KHZ = (Button) findViewById(R.id.p1khz);
        increment1KHZ.setOnClickListener(new FrequencyChangeButtonOnClickListener(1000, getApplicationContext()));

        Button increment10KHZ = (Button) findViewById(R.id.p10khz);
        increment10KHZ.setOnClickListener(new FrequencyChangeButtonOnClickListener(10000, getApplicationContext()));

        Button decrement1KHZ = (Button) findViewById(R.id.n1khz);
        decrement1KHZ.setOnClickListener(new FrequencyChangeButtonOnClickListener(-1000, getApplicationContext()));
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
