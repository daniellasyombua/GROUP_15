from datetime import datetime, timedelta
activities = []
def log_exercise(name, duration, exercise_type, time=None):
    activities.append({
        "name": name,
        "duration": duration,
        "type": exercise_type,
        "time": time if time else datetime.now()
    })
def get_daily_summary():
    today = datetime.now().date()
    daily = [a for a in activities if a["time"].date() == today]
    return daily
def get_weekly_summary():
    week_ago = datetime.now().date() - timedelta(days=6)
    weekly = [a for a in activities if a["time"].date() >= week_ago]
    return weekly
def get_exercise_summary(exercise_name):
    return [a for a in activities if a["name"].lower() == exercise_name.lower()]
def print_summary(entries, label):
    print(f"\n{label} Summary:")
    if not entries:
        print(" No activities found.")
        return
    for a in entries:
        date_str = a['time'].strftime('%Y-%m-%d %H:%M')
        print(f" {a['name']} | {a['type']} | {a['duration']} mins on {date_str}")

if __name__ == "__main__":

    log_exercise("Push-ups", 10, "Strength", datetime.now() - timedelta(days=6))
    log_exercise("Cycling", 20, "Cardio", datetime.now() - timedelta(days=2))
    log_exercise("Running", 30, "Cardio")
    log_exercise("Push-ups", 15, "Strength")  
    daily_summary = get_daily_summary()
    weekly_summary = get_weekly_summary()
    exercise_summary = get_exercise_summary("Push-ups")
    print_summary(daily_summary, "Daily")
    print_summary(weekly_summary, "Weekly")
    print_summary(exercise_summary, "Push-ups")