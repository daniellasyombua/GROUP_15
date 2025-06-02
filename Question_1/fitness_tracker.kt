import java.time.LocalDate
import java.time.DayOfWeek

data class ExerciseLog(
    val name: String,
    val durationMinutes: Int,
    val date: LocalDate = LocalDate.now()
)
class ActivityLog {
    private val logs = mutableListOf<ExerciseLog>()
    fun logExercise(name: String, durationMinutes: Int, date: LocalDate = LocalDate.now()) {
        logs.add(ExerciseLog(name, durationMinutes, date))
    }
    fun getExerciseDetails(name: String, date: LocalDate = LocalDate.now()): List<ExerciseLog> {
        return logs.filter { it.name.equals(name, ignoreCase = true) && it.date == date }
    }
    fun getDailyLog(date: LocalDate = LocalDate.now()): List<ExerciseLog> {
        return logs.filter { it.date == date }
    }
    fun getWeeklyLog(referenceDate: LocalDate = LocalDate.now()): List<ExerciseLog> {
        val monday = referenceDate.with(DayOfWeek.MONDAY)
        val sunday = referenceDate.with(DayOfWeek.SUNDAY)
        return logs.filter { it.date in monday..sunday }
    }
    fun getDailySummary(date: LocalDate = LocalDate.now()): ActivitySummary {
        val dayLogs = getDailyLog(date)
        return ActivitySummary(
            date = date,
            totalDuration = dayLogs.sumOf { it.durationMinutes }
        )
    }
    fun getWeeklySummary(referenceDate: LocalDate = LocalDate.now()): ActivitySummary {
        val weekLogs = getWeeklyLog(referenceDate)
        return ActivitySummary(
            date = referenceDate,
            totalDuration = weekLogs.sumOf { it.durationMinutes }
        )
    }
}
data class ActivitySummary(
    val date: LocalDate,
    val totalDuration: Int,
)
fun main() {
    val activityLog = ActivityLog()
    activityLog.logExercise("Running", 30)
    activityLog.logExercise("Cycling", 45)
    activityLog.logExercise("Yoga", 60, LocalDate.now().minusDays(1))
    println("Today's Exercises:")
    activityLog.getDailyLog().forEach { println(it) }
    println("\nToday's Summary:")
    println(activityLog.getDailySummary())
    println("\nThis Week's Exercises:")
    activityLog.getWeeklyLog().forEach { println(it) }
    println("\nThis Week's Summary:")
    println(activityLog.getWeeklySummary())
}