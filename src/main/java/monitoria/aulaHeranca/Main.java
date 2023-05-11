package monitoria.aulaHeranca;

public class Main {

    public static void main(String[] args) {
//        Cliente joao = new ClienteEspecial("Joao", 1);
//        ClienteEspecial especial = new Cliente("especial", 2);
//        Object obj = new Cliente("especial", 2);
//        Cliente normal = new Cliente("Joao", 1);





        Cliente especial =
                new ClienteEspecial("Joao", 1);



//        System.out.println(especial);














//        int x = 10;
//        incrementar(x);
//        System.out.println(x);


//        Aluno aluno = new Aluno();
//        aluno.x = 10;
//        incrementar(aluno);
//        alterar(aluno);
//        System.out.println(aluno.x);
    }

    /*
    (V)Passagem por valor => feita cópia, valor original nao se altera
    (X)Passagem por referencia => referencia, valor é alterado
     */

    /*
    Polimorfismo =
    Sobrecarga = mudo os parametros
    Sobrescrita = heranca + mesmo metodo
     */
    public static void incrementar(Aluno qualquer) {
        qualquer.x += 1;
    }

    public static void incrementar(int x) {
        x += 1;
    }

    public static void alterar(Aluno flavia) {
        flavia = new Aluno();
        flavia.x = 100;
    }

}
