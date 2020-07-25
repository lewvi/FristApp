package com.example.fristapp

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout



class MainActivity : AppCompatActivity(){
    private lateinit var drawer: DrawerLayout

   /* //variables
    var drawerLayout: DrawerLayout? = null
    var navigationView: NavigationView? = null
    var toolbar: Toolbar? = null
    var menu: Menu? = null
    var textView: TextView? = null
*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       var toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

       drawer = findViewById(R.id.drawer_layout)

       var toggle:ActionBarDrawerToggle = ActionBarDrawerToggle(this, drawer, toolbar,
            R.string.navigation_draw_open,R.string.navigation_draw_close)

       drawer.addDrawerListener(toggle)
       toggle.syncState()

    }

   public override fun onBackPressed() {
        if (drawer?.isDrawerOpen(GravityCompat.START)) {
            drawer?.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}

