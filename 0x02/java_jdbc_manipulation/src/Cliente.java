package src;

import java.util.Objects;

public class Cliente {

    private Integer id;
    private String nome;
    private Integer idade;
    private String cpf;
    private String rg;

    public Cliente(Integer id, String nome, Integer idade, String cpf, String rg) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.rg = rg;
    }

    public Cliente() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;

        Cliente cliente = (Cliente) o;

        if (!Objects.equals(id, cliente.id)) return false;
        if (!Objects.equals(nome, cliente.nome)) return false;
        if (!Objects.equals(idade, cliente.idade)) return false;
        if (!Objects.equals(cpf, cliente.cpf)) return false;
        return Objects.equals(rg, cliente.rg);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (idade != null ? idade.hashCode() : 0);
        result = 31 * result + (cpf != null ? cpf.hashCode() : 0);
        result = 31 * result + (rg != null ? rg.hashCode() : 0);
        return result;
    }
}
