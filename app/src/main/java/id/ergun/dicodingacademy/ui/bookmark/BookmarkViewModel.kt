package id.ergun.dicodingacademy.ui.bookmark

import androidx.lifecycle.ViewModel
import id.ergun.dicodingacademy.data.CourseEntity
import id.ergun.dicodingacademy.util.DataDummy

/**
 * Created by alfacart on 19/10/20.
 */
class BookmarkViewModel : ViewModel() {
    fun getBookmarks(): List<CourseEntity> = DataDummy.generateDummyCourses()
}