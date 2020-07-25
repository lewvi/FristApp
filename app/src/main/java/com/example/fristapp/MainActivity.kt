package com.example.fristapp

import android.app.PendingIntent.getActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import android.view.MenuItem

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    private lateinit var drawer: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       var toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

       drawer = findViewById(R.id.drawer_layout)

        var navigationView :NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

       var toggle:ActionBarDrawerToggle = ActionBarDrawerToggle(this, drawer, toolbar,
            R.string.navigation_draw_open,R.string.navigation_draw_close)

       drawer.addDrawerListener(toggle)
       toggle.syncState()

        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ProfileFragment())
                .commit()
            navigationView.setCheckedItem(R.id.nav_person)
        }

    }

   public override fun onBackPressed() {
        if (drawer?.isDrawerOpen(GravityCompat.START)) {
            drawer?.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_person -> {
                 supportFragmentManager.beginTransaction()
                     .replace(R.id.fragment_container,ProfileFragment())
                     .commit()
            }
            R.id.nav_contact -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container,ContactFragment())
                    .commit()
            }
        }

        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}



