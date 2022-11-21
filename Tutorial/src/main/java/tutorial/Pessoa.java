package tutorial;

public class Pessoa {
    // não podem ser acessados nem alterados (private e final)
    private final String nome;
    private final Integer altura;
    private final String dataDeNascimento;

    // Atributos são definidos no construtor durante a criação da instância
    public Pessoa(String nome, Integer altura, String dataDeNascimento) {
        this.nome = nome;
        this.altura = altura;
        this.dataDeNascimento = dataDeNascimento;
    }

    // métodos getters públicos para serem lidos
    public String getNome() {
        return nome;
    }

    public Integer getAltura() {
        return altura;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }
}
