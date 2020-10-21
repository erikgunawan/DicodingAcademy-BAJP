package id.ergun.dicodingacademy.ui.reader

/**
 * Created by alfacart on 19/10/20.
 */
interface CourseReaderCallback {
    fun moveTo(position: Int, moduleId: String)
}