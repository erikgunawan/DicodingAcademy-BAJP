package id.ergun.dicodingacademy.ui.bookmark

import id.ergun.dicodingacademy.data.CourseEntity

interface BookmarkFragmentCallback {
    fun onShareClick(course: CourseEntity)
}
