package testadigrafo;

import java.util.ArrayList;

/**
 *
 * @author fabio.aglubacheski
 */
public class digraph{
	private int V; // número de vértices
	private int A; // número de arcos
	private No adj[]; // listas de adjcências
        private int visitado[]; // lista de vertices que já passou
        //private ArrayList<int> caminho = new Arraylist<int>(); // lista caminho
        
        // construtor da clsse
	// inicializa os atributos da classe e cria a 
	// o vetor de listas deadjacências para V vértices
	public digraph( int V ){
            this.V = V;
            this.A = 0;
            this.adj = new No[V];
            this.visitado = new int[V];
          //  this.caminho = new Arraylist <int>;
	}
        /* 
           Método insere um arco v-w no digrafo. O método supõe 
           que v e w são distintos, positivos e menores que V. 
           Se o digrafo já tem arco v-w, o método não faz nada.
           Insere aresta na lista de adjacencias no final
        */
        public void insereA( int v, int w){
            if(v == w){
                System.out.println("Par " + v + ' ' + w +"  x deve ser diferente do y.");
                return;
            }
            
            //Se o digrafo já tem arco v-w, o método não faz nada
            if(this.buscaIncluso(this, v, w)){
                System.out.println("Par " + v + ' ' + w +" já inserido.");
                return; // ejeta
            }
            
            if (this.buscaCliclo(this , w, v)){
                System.out.println("Par " + v + ' ' + w +" forma ciclo.");
                return ;
            }
            
            
            
            No aux = this.adj[v];
            No ant = null;
            while( aux != null ){
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
                    this.A--;
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
        
        
        public void busca(digraph D){
            for(int indice =0 ;indice< D.visitado.length; indice++){
                D.visitado[indice] = 0;
            }
            
            for(int indice =0 ;indice< D.V; indice++){
                if(D.visitado[indice] == 0){
                    buscaProf(D,indice);
                }
            }
            System.out.println("");
        }
        
        public void buscaProf(digraph D, int vertice){
            D.visitado[vertice] = 1;
            //System.out.print(vertice + " ");
            //D.caminho.
            No aux = D.adj[vertice];
            
            while( aux != null ){
                if(D.visitado[aux.getElem()] == 0){
                    D.buscaProf(D, aux.getElem());
                }
                aux = aux.getProx();
            }
            
        }
        
        public boolean buscaCaminho(digraph D, int s, int t){
            return true;
        }
        
        public boolean buscaCliclo(digraph D, int start, int end){
            for(int indice =0 ;indice< D.visitado.length; indice++){
                D.visitado[indice] = 0;
            }
            
            buscaProf(D,start);
            
            if(D.visitado[start] == 1 && D.visitado[end] == 1){
                return true;
            }
                           
            return false;
        }
        
        public boolean buscaIncluso(digraph D, int ind, int cont){
            No aux = this.adj[ind];
            while( aux != null ){
                if(aux.getElem() ==  cont){
                    return true;
                }
                
                aux = aux.getProx();
            }
            return false;
        }
}
