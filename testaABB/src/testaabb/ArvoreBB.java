/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testaabb;

/**
 *
 * @author fabio.aglubacheski
 */
public class ArvoreBB {
    private No raiz;// endereço inicial da lista
    private No raizAux;// endereço aux
    private String aux;
    public ArvoreBB(){
        this.raiz = null;
    }
    public void adiciona( int elemento ){
        No aux, pai;
        
        pai = null;
        aux = this.raiz;
        while( aux != null ){
            pai = aux; // lembra o ant da lista ligada
            
            if( elemento < aux.getElemento()) // cai a esquerda do pai
                aux = aux.getEsq();
            else 
                aux = aux.getDir();
            
        }
        if( pai  == null ){ // se pai nulo nao tem raiz
            this.raiz = new No(elemento);
            return;
        }
        if( elemento < pai.getElemento()) // cai a esquerda do pai
            pai.setEsq(new No(elemento));
        else if( elemento > pai.getElemento() ) 
            pai.setDir(new No(elemento));
        else // igual
            return;
    }       
    public void remove(int elemento){
        if (!this.busca(elemento))
            return;
        No aux = this.raiz;
        No deletar = null;
        No pai = null;
        while( aux != null){
            if( elemento == aux.getElemento()){
                //achou
                pai = aux;
                while( aux != null ){
                    pai = aux; // lembra o ant da lista ligada

                    if( elemento < aux.getElemento()) // cai a esquerda do pai
                        aux = aux.getEsq();
                    else 
                        aux = aux.getDir();

                }                
            }
            //if( elemento > aux.getElemento()){
            if(elemento < aux.getElemento()){
                aux = aux.getEsq();
            }else{
                aux = aux.getDir();
            }
        }        
    }
        
    public boolean busca(int elemento){
        No aux = this.raiz;
        
        while( aux != null){
            if( elemento == aux.getElemento())
                return true;
            if( elemento < aux.getElemento())
                aux = aux.getEsq();
            else 
                aux = aux.getDir();
        }
   
        return false;
    }
    public String ordemCrescente(){
        aux = "";
        this.retornaOrdemC(this.raiz);
        return aux;
    }
    
    public void retornaOrdemC(No atual){
        if(atual != null){
            retornaOrdemC(atual.getEsq());
            aux = aux + " " + atual.getElemento();       
            retornaOrdemC(atual.getDir());
        }    
    }
}
