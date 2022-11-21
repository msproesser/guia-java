package tutorial;

public class Inicio {

    public static void main(String[] args) {
        String comparador = "opção 2";

        if ("opção 1".equals(comparador)) {
            System.out.println("Comparador escolhido foi \"opção 1\"");
        } else if ("opção 2".equals(comparador) || "opção 3".equals(comparador)){
            System.out.println("comparador é igual \"opção 2\" ou \"opção 3\"");
        } else {
            System.out.println("Comparador não combinou com nenhuma opção");
        }
    }
}
