import java.sql.Date
import java.time.LocalDate

data class Task(
    val id: Int,
    val title: String,
    val description: String?,
    val isComplete: Boolean,
    val createdAt: Date
) {
    companion object {
        private var currentId = 0

        fun create(title: String, description: String?, isComplete: Boolean): Task {
            require(title != "")

            return Task(
                title = title,
                id = currentId++,
                description = description,
                isComplete = isComplete,
                createdAt = Date.valueOf(LocalDate.now())
            )
        }
    }
}
