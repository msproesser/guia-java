package programinhas.jokenpo;

import java.awt.desktop.SystemSleepEvent;
import java.util.Scanner;

public class ShellPlayer implements Player {

    private final String name;
    private final Scanner reader;
    public ShellPlayer(String name) {
        this.name = name;
        this.reader = new Scanner(System.in);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Options getGesture() {
        var options = Options.values();
        System.out.println("Pick an option");
        for(int i = 0; i < options.length; i++) {
            System.out.println(i + ": " + options[i].name());
        }
        var selected = reader.nextInt();
        if (selected >= options.length) return null;
        return options[selected];
    }
}
