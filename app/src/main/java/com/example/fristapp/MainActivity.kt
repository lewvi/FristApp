package com.example.fristapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.replace
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawer: DrawerLayout

    private val newWordActivityRequestCode = 1
    private lateinit var addViewModel: addContactViewModel

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

    }

    override fun onBackPressed() {
        if (drawer?.isDrawerOpen(GravityCompat.START)) {
            drawer?.closeDrawer(GravityCompat.START)

        } else {
            super.onBackPressed()
        }

        val intent = Intent(applicationContext, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)

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
            R.id.nav_addContact -> {
                supportFragmentManager.beginTransaction()
                    .commit()
                    setContentView(R.layout.add_contact)
            }
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}



