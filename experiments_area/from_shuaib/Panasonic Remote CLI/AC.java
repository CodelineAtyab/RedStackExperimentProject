public class AC {

    int temperature = 24;

    public String acOn(boolean isRemoteOn ) {
        if (isRemoteOn) {
            return "Remote is now ON.";
        } else {
            return "Remote is now OFF.";
        }
    }

    public void acTemperature() {
        System.out.println("Current temperature: " + temperature + "°C");
    }
}
