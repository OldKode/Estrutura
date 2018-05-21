/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testadigrafo;

/**
 *
 * @author fabio.aglubacheski
 */
class No {
    private int elem;
    private No prox;

    public No(int elem, No prox) {
        this.elem = elem;
        this.prox = prox;
    }

    public int getElem() {
        return elem;
    }

    public void setElem(int elem) {
        this.elem = elem;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }

    @Override
    public String toString() {
        return "{" + "elem=" + this.elem +"," +this.prox + '}';
    }
    
    
}
