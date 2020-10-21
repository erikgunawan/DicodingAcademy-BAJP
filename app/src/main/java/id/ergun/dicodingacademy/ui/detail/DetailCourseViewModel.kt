package id.ergun.dicodingacademy.ui.detail

import androidx.lifecycle.ViewModel
import id.ergun.dicodingacademy.data.CourseEntity
import id.ergun.dicodingacademy.data.ModuleEntity
import id.ergun.dicodingacademy.util.DataDummy

/**
 * Created by alfacart on 19/10/20.
 */
class DetailCourseViewModel : ViewModel() {
    private lateinit var courseId: String

    fun setSelectedCourse(courseId: String) {
        this.courseId = courseId
    }

    fun getCourse(): CourseEntity {
        lateinit var course: CourseEntity
        val coursesEntities = DataDummy.generateDummyCourses()
        for (courseEntity in coursesEntities) {
            if (courseEntity.courseId == courseId) {
                course = courseEntity
            }
        }
        return course
    }

    fun getModules(): List<ModuleEntity> = DataDummy.generateDummyModules(courseId)
}