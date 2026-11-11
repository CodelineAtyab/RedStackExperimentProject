public class Smartphone {
    private class Battery{
        private int level = 100;

        public Battery(int level) {
            this.level = getLevel;
        }

        public void drain(int amount)
            level -= amount;
            if (level < 0) {
                level = 0;
            }
        }

        public int getLevel(){
            return level;
        }

    }

}