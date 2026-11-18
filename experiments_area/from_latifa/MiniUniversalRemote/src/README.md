##Project Structure

    Main.java – Runs the program and selects the remote.

    RemoteCover.java – Contains the six abstract methods.

    LGTVRemote.java – Handles TV power and channel.

    LGACRemote.java – Handles AC power and temperature.

##How to Run

    Open the project in IntelliJ IDEA.

    Make sure Java 17 is selected.

    Open Main.java.

    Choose which remote to run:

    RemoteCover remote = new LGTVRemote();
    // RemoteCover remote = new LGACRemote();

    To run the AC remote, comment out the TV line and uncomment the AC line.
    Run the main() method.

##OOP Concepts

    1/Abstraction: RemoteCover declares the common methods for both remotes.

    2/Inheritance: LGTVRemote and LGACRemote extend RemoteCover.

    3/Polymorphism: The same RemoteCover reference can be used with either remote.

    4/Encapsulation: Each remote has private fields and a private method to display its status.

##Features

    Turn the TV and AC ON or OFF.

    Change the TV channel.

    Increase or decrease the AC temperature.

    The TV volume stays fixed at 20.

    The AC cooling mode is COOL.

    The AC temperature cannot be changed when it is OFF.

##Requirements

Java 17 or later.

IntelliJ IDEA.

