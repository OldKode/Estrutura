
package testaabb;

/**
 *
 * @author fabio.aglubacheski
 */
public class No {
    // Atributos da classe
    private int elemento;
    private No esq;
    private No dir;
  
    // construtor da classe
    public No(int elemento, No esq, No dir) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }
    public No(int elemento ) {
        this.elemento = elemento;
        this.esq = null;
        this.dir = null;
    }
    public int getElemento() {
        return elemento;
    }

    public No getEsq() {
        return esq;
    }

    public No getDir() {
        return dir;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

    public void setEsq(No esq) {
        this.esq = esq;
    }

    public void setDir(No dir) {
        this.dir = dir;
    }

  
}
