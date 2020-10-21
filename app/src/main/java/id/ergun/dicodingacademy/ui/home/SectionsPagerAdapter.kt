package id.ergun.dicodingacademy.ui.home

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import id.ergun.dicodingacademy.R
import id.ergun.dicodingacademy.ui.academy.AcademyFragment
import id.ergun.dicodingacademy.ui.bookmark.BookmarkFragment

/**
 * Created by alfacart on 19/10/20.
 */
class SectionsPagerAdapter(private val mContext: Context, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.home, R.string.bookmark)
    }

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> AcademyFragment()
            1 -> BookmarkFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence? = mContext.resources.getString(TAB_TITLES[position])

    override fun getCount(): Int = 2

}