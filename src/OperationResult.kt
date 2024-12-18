sealed class OperationResult(open val message: String) {
    data class Success(override val message: String): OperationResult(message)
    data class Error(override val message: String): OperationResult(message)
}