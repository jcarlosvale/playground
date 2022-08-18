package certification;

public abstract class ImprimirTela {

    public abstract void imprimeTela();

}

class MinhaTela extends ImprimirTela {

    @Override
    public void imprimeTela() {
        System.out.println("Meu comportamento");
    }
}
