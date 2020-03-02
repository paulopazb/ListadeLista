public class Nodo
 {
        private SubLista SLista;
        private Nodo prox;

        public Nodo(){
            SLista=new SubLista();
            prox = null;
        }

        public Nodo(SubLista x, Nodo p){
            SLista=x;
            prox = p;
        }

        public void setSubLista(SubLista SL) {
           SLista=SL;
        }

        public SubLista getSubLista() {
            return SLista;
        }
        
   
        public void setProx(Nodo p){
            prox = p;
        }

        public Nodo getProx(){
            return prox;
        }
 }

