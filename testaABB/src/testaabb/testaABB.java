package testaabb;

/**
 *
 * @author fabio.aglubacheski
 */
public class testaABB {
    public static void main(String[] args){
        ArvoreBB T = new ArvoreBB();
        
        T.adiciona(25);
        T.adiciona(40);
        T.adiciona(27);
        T.adiciona(15);
        T.adiciona(20);
        T.adiciona(17);
        
        System.out.println(T.busca(30));
        
        System.out.println(T.ordemCrescente());
    }
}
