public boolean MonkeyTrouble(boolean aSmile, boolean bSmile) {
  if (aSmile == bSmile || !aSmile == !bSmile) {
    return true;
  }
  return false;
}