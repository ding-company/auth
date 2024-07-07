package `in`.ding.common.annotation

import `in`.ding.common.enum.PermissionUserType

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class AllowedPermission(
    val allowedPermissionList: Array<PermissionUserType>
)
