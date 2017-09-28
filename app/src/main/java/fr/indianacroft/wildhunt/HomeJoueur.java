package fr.indianacroft.wildhunt;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class HomeJoueur extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homejoueur);

        // Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Drawer Menu
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Avatar
        ImageView imageViewAvatar = (ImageView) findViewById(R.id.imageViewAvatar);
        imageViewAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeJoueur.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        // Bottom Navigation Bar
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        // Fragment Adapter
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }



    // Fragments
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    //onglet 1 vers Player Activity
                    HomeJoueur_PlayerActivity playerActivity = new HomeJoueur_PlayerActivity();
                    return playerActivity;
                case 1:
                    // onglet 2 vers Lobby Activity
                    HomeJoueur_LobbyActivity lobbyActivity = new HomeJoueur_LobbyActivity();
                    return lobbyActivity;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return 2;
        }
        //TODO enlever hardcoding
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    // nom onglet 1
                    return "Partie en cours";
                case 1:
                    // nom onglet 2
                    return "Lobby";
            }
            return null;
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }



    // Drawer Menu
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        // TODO : remplacer les toasts par des liens
        if (id == R.id.nav_home) {
            Toast.makeText(HomeJoueur.this, "Créer lien page Home", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_rules) {
            Toast.makeText(HomeJoueur.this, "Créer lien page Rules", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_settings) {
            Intent intent = new Intent(HomeJoueur.this, ProfileActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_quests) {
            Toast.makeText(HomeJoueur.this, "Créer lien page Quests", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_switch) {
            Toast.makeText(HomeJoueur.this, "Créer lien page Switch", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_delete) {
            Toast.makeText(HomeJoueur.this, "Déco joueur", Toast.LENGTH_SHORT).show();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    // Bottom Navigation Bar
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Toast.makeText(HomeJoueur.this, "Créer lien page Home", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.navigation_camera:
                    Toast.makeText(HomeJoueur.this, "Créer lien page camera", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.navigation_switch:
                    Intent intent = new Intent(HomeJoueur.this, HomeGameMaster.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_notifications:
                    Toast.makeText(HomeJoueur.this, "Créer lien page Notifications", Toast.LENGTH_SHORT).show();
                    return true;
            }
            return false;
        }
    };
}
