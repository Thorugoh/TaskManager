object TaskManager {
    private val tasks = mutableListOf<Task>()

    fun addTask(task: Task) {
        tasks.add(task)
    }

    fun addAllTasks(tasks: List<Task>) {
        this.tasks.addAll(tasks)
    }

    fun getAllTasks(): List<Task> {
        return tasks.toList()
    }

    fun getTaskById(id: Int): Task? {
        return tasks.firstOrNull { it.id == id }
    }

    fun updateTaskStatus(id: Int, isCompleted: Boolean): OperationResult {
        val taskToBeUpdated = tasks.find { it.id == id }
        check(taskToBeUpdated != null) { "Task with given id does not exists"}

        tasks.remove(taskToBeUpdated)
        val newTask = taskToBeUpdated.copy(isComplete = isCompleted)
        tasks.add(newTask)

        return OperationResult.Success("Task successfully updated")
    }

    fun deleteTaskById(id: Int): OperationResult {
        check(tasks.find { it.id == id } != null)
        if(tasks.removeIf { it.id == id }){
            return OperationResult.Success("Task with id: $id deleted")
        }
        return OperationResult.Error("Task not found")
    }

    fun filterTasksByStatus(isCompleted: Boolean): List<Task> {
        return tasks.filter { it.isComplete == isCompleted }
    }
}