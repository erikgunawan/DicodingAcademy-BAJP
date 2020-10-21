package id.ergun.dicodingacademy.ui.academy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.ergun.dicodingacademy.R
import id.ergun.dicodingacademy.util.DataDummy
import kotlinx.android.synthetic.main.fragment_academy.*

/**
 * Created by alfacart on 19/10/20.
 */
class AcademyFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_academy, container, false)


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[AcademyViewModel::class.java]
            val courses = viewModel.getCourses()
            val academyAdapter = AcademyAdapter()
            academyAdapter.setCourses(courses)
            with(rv_academy) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = academyAdapter
            }
        }
    }
}