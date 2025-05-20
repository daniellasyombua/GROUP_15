# Daily Fitness Tracking System in Python


from datetime import datetime, timedelta

activities = []

def log_exercise(name, duration, exercise_type):
    activities.append({
        "duration": duration,
        "type": exercise_type,
        "time": datetime.now()
    })

def get_daily_summary():
    today = datetime.now().date()
    daily = [a for a in activities if a["time"].date() == today]
    return daily

def get_weekly_summary():
    week_ago = datetime.now() - timedelta(days=7)
    weekly = [a for a in activities if a["time"]>= week_ago]
    return weekly

def print_summary(entries, label):
    print(f"\n{label} Summary:")
    for a in entries:
        print(f" {a['type']} | {a['duration']} mins on {a['time']}")


log_exercise("Push-ups", 10, "Strength")
log_exercise("Running", 30, "Cardio")


daily_summary = get_daily_summary()
weekly_summary = get_weekly_summary()

print_summary(daily_summary, "Daily")
print_summary(weekly_summary, "Weekly")