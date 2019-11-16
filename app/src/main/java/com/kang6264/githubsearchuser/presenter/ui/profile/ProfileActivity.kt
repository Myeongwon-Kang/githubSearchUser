package com.kang6264.githubsearchuser.presenter.ui.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.kang6264.githubsearchuser.R
import com.kang6264.githubsearchuser.data.remote.api.model.User
import kotlinx.android.synthetic.main.activity_profile.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val sectionsPagerAdapter =
            SectionsPagerAdapter(this, supportFragmentManager, intent?.let { it.getStringExtra("login") })
        val viewPager : ViewPager = view_pager
        viewPager.adapter = sectionsPagerAdapter

        val tabs : TabLayout = tabsLayout
        tabs.setupWithViewPager(viewPager)
    }

    companion object{
        @JvmStatic
        fun getStartIntent(context : Context, login : String): Intent {
            var intent = Intent(context, ProfileActivity::class.java)
            intent.putExtra("login", login)
            return intent

            /*
            return Intent(
                context,
                ProfileActivity::class.java
            )
             */
        }
    }
}
