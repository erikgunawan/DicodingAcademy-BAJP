package id.ergun.dicodingacademy.ui.detail

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.ergun.dicodingacademy.R
import id.ergun.dicodingacademy.data.CourseEntity
import id.ergun.dicodingacademy.ui.reader.CourseReaderActivity
import id.ergun.dicodingacademy.util.DataDummy
import kotlinx.android.synthetic.main.activity_detail_course.*
import kotlinx.android.synthetic.main.content_detail_course.*

/**
 * Created by alfacart on 19/10/20.
 */
class DetailCourseActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_COURSE = "extra_course"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_course)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailCourseViewModel::class.java]

        val adapter = DetailCourseAdapter()

        val extras = intent.extras
        if (extras != null) {
            val courseId = extras.getString(EXTRA_COURSE)
            if (courseId != null) {
                viewModel.setSelectedCourse(courseId)
                val modules = viewModel.getModules()
                adapter.setModules(modules)
                populateCourse(viewModel.getCourse())
            }
        }

        with(rv_module) {
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(this@DetailCourseActivity)
            setHasFixedSize(true)
            this.adapter = adapter
            val dividerItemDecoration = DividerItemDecoration(rv_module.context, DividerItemDecoration.VERTICAL)
            addItemDecoration(dividerItemDecoration)
        }
    }

    private fun populateCourse(courseEntity: CourseEntity) {
        text_title.text = courseEntity.title
        text_desc.text = courseEntity.description
        text_date.text = resources.getString(R.string.deadline_date, courseEntity.deadline)

        Glide.with(this)
            .load(courseEntity.imagePath)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                .error(R.drawable.ic_error))
            .into(image_poster)

        btn_start.setOnClickListener {
            val intent = Intent(this@DetailCourseActivity, CourseReaderActivity::class.java).apply {
                putExtra(CourseReaderActivity.EXTRA_COURSE_ID, courseEntity.courseId)
            }
            startActivity(intent)
        }
    }
}