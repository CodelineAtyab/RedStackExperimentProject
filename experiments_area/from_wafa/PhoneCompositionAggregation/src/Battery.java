public class Battery {


    Battery() {
    }

    public void drain(int amount) {
            level = level - amount;
            if (level < 0) {
                level = 0;
            }
        }


        public int getLevel(){
            return level;
        }


        private int level = 100;
}
