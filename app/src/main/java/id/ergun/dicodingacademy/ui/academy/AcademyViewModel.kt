package id.ergun.dicodingacademy.ui.academy

import androidx.lifecycle.ViewModel
import id.ergun.dicodingacademy.data.CourseEntity
import id.ergun.dicodingacademy.util.DataDummy

/**
 * Created by alfacart on 19/10/20.
 */
class AcademyViewModel : ViewModel() {
    fun getCourses(): List<CourseEntity> = DataDummy.generateDummyCourses()
}