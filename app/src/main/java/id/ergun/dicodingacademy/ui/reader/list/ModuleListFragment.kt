package id.ergun.dicodingacademy.ui.reader.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import id.ergun.dicodingacademy.R
import id.ergun.dicodingacademy.data.ModuleEntity
import id.ergun.dicodingacademy.ui.reader.CourseReaderCallback
import id.ergun.dicodingacademy.ui.reader.CourseReaderActivity
import id.ergun.dicodingacademy.ui.reader.CourseReaderViewModel
import id.ergun.dicodingacademy.util.DataDummy
import kotlinx.android.synthetic.main.fragment_module_list.*

/**
 * Created by alfacart on 19/10/20.
 */
class ModuleListFragment : Fragment(), MyAdapterClickListener {

    companion object {
        val TAG = ModuleListFragment::class.java.simpleName

        fun newInstance(): ModuleListFragment = ModuleListFragment()
    }
    private lateinit var viewModel: CourseReaderViewModel
    private lateinit var adapter: ModuleListAdapter
    private lateinit var courseReaderCallback: CourseReaderCallback

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_module_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity(), ViewModelProvider.NewInstanceFactory())[CourseReaderViewModel::class.java]
        adapter = ModuleListAdapter(this)
        populateRecyclerView(viewModel.getModules())
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        courseReaderCallback = context as CourseReaderActivity
    }

    override fun onItemClicked(position: Int, moduleId: String) {
        courseReaderCallback.moveTo(position, moduleId)
        viewModel.setSelectedModule(moduleId)
    }

    private fun populateRecyclerView(modules: List<ModuleEntity>) {
        progress_bar.visibility = View.GONE
        adapter.setModules(modules)
        with(rv_module) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = adapter
        }
        val dividerItemDecoration = DividerItemDecoration(rv_module.context, DividerItemDecoration.VERTICAL)
        rv_module.addItemDecoration(dividerItemDecoration)
    }
}