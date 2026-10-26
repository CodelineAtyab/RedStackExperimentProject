public boolean SleepIn(boolean weekday, boolean vacation) {
  if (!weekday || vacation) {
    return true;
  }
  return false;
}