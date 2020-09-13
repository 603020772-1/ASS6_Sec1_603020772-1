package com.myweb.ass06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(
                    R.id.frameLayout,
                    MyFragment()
            ).commit()
    }
}

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    fun MenuItem?.onOptionsItemSelected(item: MenuItem): Boolean {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        when (this?.itemId) {
            R.id.menu1 -> {
                transaction.replace(R.id.frameLayout, FriendTwoFragment())
                transaction.addToBackStack(null)
                transaction.commit()
                return true
            }
            R.id.menu2 -> {
                transaction.replace(R.id.frameLayout, FriendOneFragment())
                transaction.addToBackStack(null)
                transaction.commit()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}