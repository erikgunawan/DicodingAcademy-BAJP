package id.ergun.dicodingacademy.data

/**
 * Created by alfacart on 19/10/20.
 */
data class ModuleEntity(
    var moduleId: String,
    var courseId: String,
    var title: String,
    var position: Int,
    var read: Boolean = false
){
    var contentEntity: ContentEntity? = null
}