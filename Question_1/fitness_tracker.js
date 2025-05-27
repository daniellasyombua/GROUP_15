class ActivityLog{
  constructor(name) {
    this.name = name;
    this.exercises = [];
  }

  logExercise(date, activity, duration) {
    this.exercises.push({ date, activity, duration });
  }

  viewExercises() {
    console.log(`Exercise log for ${this.name}:`);
    this.exercises.forEach(ex => {
      console.log(`${ex.date} - ${ex.activity} (${ex.duration} min)`);
    });
  }

  dailySummary(date) {
    let dailyTotal = 0;
    this.exercises.forEach(ex => {
      if (ex.date === date) {
        dailyTotal += ex.duration;
      }
    });
    console.log(`${this.name}'s total on ${date}: ${dailyTotal} min`);
}
  weeklySummary() {
    const summary = {};
    this.exercises.forEach(ex => {
      if (!summary[ex.date]) {
        summary[ex.date] = 0;
      
     summary[ex.date] += ex.duration;
  }});



  

    console.log(`Weekly summary for ${this.name}:`);
    for (const date in summary) {
        console.log(`${date}: ${summary[date]} min`);
    }
  }
}

const user = new ActivityLog("Amina");
user.logExercise("2025-05-01", "Running", 30);
user.logExercise("2025-05-01", "Yoga", 20);
user.logExercise("2025-05-02", "Walking", 40);

user.viewExercises();
user.dailySummary("2025-05-01");
user.weeklySummary();


