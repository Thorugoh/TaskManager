fun Task.beutify(): String {
    return """
        Id: ${this.id}
        Title: ${this.title}
        Description: ${this.description}
        isCompleted: ${this.isComplete}
    """.trimIndent()
}

fun TaskManager.getCompletedTasks(): List<Task> {
    return this.filterTasksByStatus(isCompleted = true)
}

fun main() {
    val taskManager = TaskManager

    // Populating tasks
    taskManager.addAllTasks(
        listOf(
            Task.create(
                title = "Do the homework",
                description = "Practice kotlin", isComplete = false
            ),
            Task.create(
                title = "Work",
                description = "Finish project", isComplete = false
            ),
            Task.create(
                title = "Play the guitar",
                description = "chill out", isComplete = false
            )
        )
    )

    val result = taskManager.updateTaskStatus(id = 1, isCompleted = true)
    println(result.message)
    println(taskManager.getTaskById(id = 1))

    println("\nUncompleted tasks")
    println(taskManager.filterTasksByStatus(isCompleted = false).joinToString(separator = "\n"))

    println("\nAll Tasks: ")
    println(taskManager.getAllTasks().joinToString(separator = "\n"))

    println("\nAll Tasks: ")
    taskManager.deleteTaskById(id = 1)
    println(taskManager.getAllTasks().joinToString(separator = "\n"))


    // Using extension functions
    taskManager.updateTaskStatus(id = 2, isCompleted = true)

    println(taskManager.getCompletedTasks().map {
        it.beutify()
    })

    println("\nBeautify Task: ")
    println(taskManager.getTaskById(id = 0)?.beutify())


}