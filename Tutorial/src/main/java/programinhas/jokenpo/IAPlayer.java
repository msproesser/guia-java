package programinhas.jokenpo;

public class IAPlayer implements Player {

    private final String name;

    public IAPlayer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Options getGesture() {
        int index = (int) Math.floor(Math.random() * Options.values().length);
        var opt = Options.values()[index];
        System.out.println("IA Player " + name + " selected option: "+opt.name());
        return opt;
    }
}
