package testadigrafo;
/**
 *
 * @author fabio.aglubacheski
 */
public class digraph{
	private int V; // número de vértices
	private int A; // número de arcos
	private No adj[]; // listas de adjcências

        // construtor da clsse
	// inicializa os atributos da classe e cria a 
	// o vetor de listas deadjacências para V vértices
	public digraph( int V ){
            this.V = V;
            this.A = 0;
            this.adj = new No[V];
	}
        /* 
           Método insere um arco v-w no digrafo. O método supõe 
           que v e w são distintos, positivos e menores que V. 
           Se o digrafo já tem arco v-w, o método não faz nada.
           Insere aresta na lista de adjacencias no final
        */
        public void insereA( int v, int w){
            No aux = this.adj[v];
            No ant = null;
            while( aux != null ){
                //Se o digrafo já tem arco v-w, o método não faz nada
                if( aux.getElem() == w )
                    return; // ejeta
                
                ant = aux;
                aux = aux.getProx();
            }
            No novo = new No( w, null );
            this.A++;// incrementa o numero de arcos
            // testa se a lista esta vazia
            if( ant == null ) // se lista vazia
                // joga no inicio da lista
                this.adj[v] = novo;
            else // insere no final da lista
                ant.setProx(novo);
        }
        /*
           Método remove do digrafo um arco aresta v-w. 
           O método supõe que v e w são distintos, positivos e 
           menores que V. Se não existe um arco v-w, método não 
           faz nada.
        */
        public void removeA( int v, int w){
            No aux = this.adj[v];
            No ant = null;
            while( aux != null ){
                //Se o digrafo já tem arco v-w, o método não faz nada
                if( aux.getElem() == w ){
                    if(ant == null){
                        this.adj[v] = null;    
                    }else{
                        ant.setProx(aux.getProx());
                    }
                    return; // ejeta
                }
                ant = aux;
                aux = aux.getProx();
            }
        } 
        /*
           Para cada vértice v do grafo, este método imprime, em 
           uma linha, todos os vértices adjacentes a v. 
        */
        public void mostra( ){
            
            for( int i=0;i<this.V;i++){
                System.out.print(i+": ");
                No aux = this.adj[i];
                while(aux != null){
                  System.out.print(aux.getElem()+", ");
                  aux = aux.getProx();
                }
                System.out.println();
            }
        }
        /*
        método indeg que calcula o grau de entrada um 
        vértice v de um digrafo.
        Grau de Entrada: número de arcos com ponta final em v
        */
        public int indeg( int v ){
            No aux;
            int cont = 0;
            
            for(int indice =0 ;indice<this.V; indice++){
                aux = this.adj[indice];
                while( aux != null ){
                    if( aux.getElem() == v ){
                        cont++;
                    }
                    aux = aux.getProx();
                }
            }
            
            return cont;
        }
        /*
        método outdeg que calcula o grau de saida de um 
        vértice v em um digrafo.
        Grau de saida: número de arcos com ponta inicial em v
        */
        public int outdeg( int v ){
            No aux = this.adj[v];
            int cont = 0;
            
            while( aux != null ){
                aux = aux.getProx();
                cont++;
            }
            return cont;
        }
}