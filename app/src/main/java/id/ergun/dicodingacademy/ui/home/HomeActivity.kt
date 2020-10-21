package id.ergun.dicodingacademy.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.ergun.dicodingacademy.R
import kotlinx.android.synthetic.main.activity_home.*

/**
 * Created by alfacart on 19/10/20.
 */
class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        view_pager.adapter = sectionsPagerAdapter
        tabs.setupWithViewPager(view_pager)
        supportActionBar?.elevation = 0f
    }
}