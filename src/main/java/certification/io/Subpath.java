package certification.io;

import certification.AnyClass;

public class Subpath extends AnyClass{
    public void metodo() {
        this.multiplicar(1,2);
    }

    public static void main(String[] args)  {


        Subpath anyClass = new Subpath();
        anyClass.multiplicar(1,2);

    }
}
