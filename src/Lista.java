
import javax.swing.JOptionPane;

class Lista
{
        private Nodo primero;
        private int cantidad;

       public Lista(){
            primero = null;
            cantidad = 0;
       }

       public boolean vacia() {
           return primero == null;
       }

       public void setCant(int c) {
             cantidad=c;
       }

       public int getCant() {
            return cantidad;
       }
       public Nodo Primero()  {
         Nodo p=primero;
         return p;
       }

       public Nodo crearNodo(SubLista x, Nodo p) {
           Nodo q = new Nodo(x, p);
           return q;
       }

       public void insertarPrimero(SubLista x){
           Nodo q = crearNodo(x, primero);
           primero = q;
           cantidad++;
       }


       public void insertarUltimo(SubLista x) {
           if (vacia())
               insertarPrimero(x);
           else
           {
               Nodo p = primero;
               while (p.getProx() != null)
                   p = p.getProx();

               Nodo q = crearNodo(x,null);
               p.setProx(q);

               cantidad++;
           }
       }
       
     
        public SubLista getSubLista(int pos) {

            Nodo p = primero;
                int k = 1;
                while (k < pos && p!=null){
                    p = p.getProx();
                    k++;
                }
                return p.getSubLista();

        }
        
   

        public int precioPorPiso(int piso)
        {
            Nodo p=primero;
            int s=0;
            int i=1;
            SubLista SL;
            while(p!=null && i<piso)
            {
                p=p.getProx();
                i++;
            }
            SL=p.getSubLista();
            SubNodo q=SL.Primero();
                while(q!=null)
                {
                    s=s+q.getPrecio();
                    q=q.getSubProx();
                    
                }
                return s;
        }
        
        public int precioTotal()
        { Nodo p=primero;
          int s=0;
          SubLista SL;
   
          while(p!=null)
          {
              SL=p.getSubLista();
              SubNodo q=SL.Primero();
              while(q!=null)
              {
                  s=s+q.getPrecio();
              q=q.getSubProx();
              }
              p=p.getProx();
              
          }
          
        return s;
        
        }

        public void insertarAlFinalSL(int pos, int cod, int precio)
        {
             Nodo p=primero;
             SubLista SL;
             int i=1; 
            
             while(p!=null && i<pos)
             {
              p=p.getProx();
              i++; 
             }
              SL=p.getSubLista();
              SubNodo q=SL.Primero();
            
              while(q.getSubProx()!=null)
              {
                q=q.getSubProx();
              }
               SubNodo n = new SubNodo(cod,precio,null);
               q.setSubProx(n);
               SL.setCant(SL.getCant()+1);
              }
        public void eliminarPrimeroSL(int posL)
        {   Nodo p=primero;
            SubLista SL;
	    int i=1;
			 
               while(p!=null && i<posL)
	       {
                  p=p.getProx();
		  i++;
               }
                  SL=p.getSubLista();
                  SL.eliminarPrimero();
                 
        }
        
        public void insertarPrimeroSL(int posL,int cod,int precio)
        { Nodo p=primero;
          SubLista SL;
          int i=1;
            while(p!=null && i<posL)
            {
                p=p.getProx();
                i++;
            }
            SL=p.getSubLista();
            SL.insertarPrimero(cod,precio);
        }
        
        
        
        
         public void insertarPosicionSublista(int posL, int cod, int precio, int posSL)
         {
			 Nodo p=primero;
			 SubLista SL;
			 int i=1;
			 
			     while(p.getProx()!=null && i<posL)
			      {
				p=p.getProx();
				i++;
			      }
                       SL=p.getSubLista();
                       SubNodo q= SL.Primero();
		       SubNodo aq=null;
		       int j=1;
                      
                      
                        if(posSL==1)
                         {
                             insertarPrimeroSL(posL,cod, precio);
                         } else if(posSL>1 && posSL<SL.getCant()) 
                           
                        { while(q.getSubProx()!=null && j<posSL)
                              {
                                  aq=q;
                                 q=q.getSubProx();
                                  j++;
                               }
                                SubNodo n= new SubNodo(cod,precio,q);
                                 aq.setSubProx(n);
                                 SL.setCant(SL.getCant()+1);
                        }  else if(posSL==SL.getCant())
                            {
                              insertarAlFinalSL(posSL,cod,precio);
                            }   
                       
                       
                    }
         
         public void eliminarPosicionSublista(int posL, int posSL)
         {              Nodo p=primero;
			
			int i=1;
				while(p!=null && i<posL)
				{
					p=p.getProx();
					i++;
				}
                        SubLista SL;
                        SL= p.getSubLista();
                    if (SL.vacia()|| posSL>SL.getCant())
                     {
                       JOptionPane.showMessageDialog(null,"Fuera de rango..!!");
                     }
                  else{
                        SubNodo q= SL.Primero();
                        SubNodo aq=null;
                        int j=1;
                        if(posSL==1)
                        {
                          eliminarPrimeroSL(posL);
                        }
                        else{
				while(q.getSubProx()!=null && j<posSL)
				{
					aq=q;
					q=q.getSubProx();
					j++;
				}
			      if(SL.getCant()!=posSL)
                              {
                               aq.setSubProx(q.getSubProx());
			       SL.setCant(SL.getCant()-1);
                              }
                              else{
                              aq.setSubProx(null);
                              }
                            }
               
                       }
         }
         
         public void eliminarPiso(int posL)
         {  
            Nodo p=primero;
            Nodo ap=null;
            int i=1;
            if(posL==1)
            {
                
            }
                while(p!=null && i<posL)
                {
                    ap=p;
                    p=p.getProx();
                    i++;
                }
               
              ap.setProx(p.getProx());
             cantidad--;
            
         
         }
         
         public void eliminarPreciosRepetidos()
         {
            Nodo p=primero;
            SubLista SL;
            while(p!=null)
            {
                p=p.getProx();
                
            }
         }
         
         public void invertirLista()
         {
            Nodo p=primero;
            Nodo ap=null;
            Nodo siguiente=null;
             while(p!=null)
             {
                 siguiente=p.getProx();
                 p.setProx(ap);
                 ap=p;
                 p=siguiente;
             }
         
         }

                 
                 
}//end clase