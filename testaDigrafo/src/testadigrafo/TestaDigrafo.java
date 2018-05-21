
package testadigrafo;

/**
 *
 * @author fabio.aglubacheski
 Cliente do TAD - digraph
 */
public class TestaDigrafo {
    public static void main(String[] args){
        digraph G;
        // instancia um objeto da classe digraph
        G = new digraph(7);
        
        // insere uma aresta
        G.insereA(1, 2);
        G.insereA(1, 3);
        G.insereA(2, 2);
        G.insereA(3, 4);
        G.insereA(3, 5);
        G.insereA(4, 6);
        G.insereA(5, 6);
        G.insereA(5, 1);
        G.insereA(2, 3);
        G.insereA(2, 4);
        G.insereA(1, 3);
       // G.insereA(0, 0); //final
        
        /*
        System.out.println("Removendo vertices");
        G.removeA(0, 3);
        
        System.out.println("");
        System.out.println("Quantidades de saidas do 0");
        System.out.println(G.outdeg(0));
        
        System.out.println("");
        System.out.println("Quantidades de entradas do 5");
        System.out.println(G.indeg(5));
        */
        System.out.println("");
        System.out.println("Digrafo atual");
        G.mostra();
        
        System.out.println("");
        System.out.println("teste de busca");
        G.busca(G);
    }
    
}
