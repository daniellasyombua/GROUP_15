import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class Exercise(
    val date: String,
    val activity: String,
    val duration: Int
)
class User(val name: String) {
    private val exercises = mutableListOf<Exercise>()

    fun logExercise(date: String, activity: String, duration: Int) {
        exercises.add(Exercise(date, activity, duration))
    }
    fun viewExercises() {
        println("Exercise log for $name:")
        for (ex in exercises)
            println("${ex.date} - $ex.activity (${ex.duration} min)")
    }
    fun viewWeekly(){
        println("Weekly exercise log for $name:")
        val startDate = LocalDate.of(2024, 5, 1)
        val endDate = LocalDate.of(2024, 5, 8)
        var currentDate = startDate
        val formatter = DateTimeFormatter.ofPattern("2024-05-08")

        while (!currentDate.isAfter(endDate)) {
            println(currentDate.format(formatter))
            currentDate = currentDate.plusDays(1)
}}






fun main() {
    val user = User("Ellena")
    user.logExercise("2024-05-01", "Running", 30)
    user.logExercise("2024-05-02", "Yoga", 20)
    user.logExercise("2024-05-03", "Cycling", 40)
    user.logExercise("2024-05-04", "Cycling", 30)
    user.logExercise("2024-05-05", "Running", 20)
    user.logExercise("2024-05-06", "Cycling", 25)
    user.logExercise("2024-05-07", "Yoga", 30)
    user.logExercise("2024-05-08", "Cycling", 35)
    user.viewExercises()
    user.viewWeekly()
   // user.dailySummary("2024-05-01")
   // user.weeklySummary()
}}





