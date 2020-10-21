package id.ergun.dicodingacademy.ui.reader.content

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import id.ergun.dicodingacademy.R
import id.ergun.dicodingacademy.data.ContentEntity
import id.ergun.dicodingacademy.data.ModuleEntity
import id.ergun.dicodingacademy.ui.reader.CourseReaderViewModel
import kotlinx.android.synthetic.main.fragment_module_content.*

/**
 * Created by alfacart on 19/10/20.
 */
class ModuleContentFragment : Fragment() {

    companion object {
        val TAG = ModuleContentFragment::class.java.simpleName

        fun newInstance(): ModuleContentFragment {
            return ModuleContentFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_module_content, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            val viewModel = ViewModelProvider(requireActivity(), ViewModelProvider.NewInstanceFactory())[CourseReaderViewModel::class.java]
            val module = viewModel.getSelectedModule()
            populateWebView(module)
        }
    }

    private fun populateWebView(module: ModuleEntity) {
        web_view.loadData(module.contentEntity?.content ?: "", "text/html", "UTF-8")
    }

}