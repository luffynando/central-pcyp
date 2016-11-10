
public class Central {
	
	int[] id;
	int[] marcar;
	
	public Central()
	{
	 id=new int[10];
	 for(int i=0;i<10;i++)
		 id[i]=0;
	
	 marcar=new int[10];
	 for(int i=0;i<10;i++)
		 marcar[i]=i;
	}
	
	//el telefono receptor revisa quien le está llamando y retorna quien lo está llamando
	public synchronized int llamadaEntrante(int receptor)
	{ 
			for(int i=0;i<10;i++)
			{ if(marcar[i]==receptor)
				{this.estableciendoComunicacion(i,receptor);
				
				  return(i);
				}
				
			}
			return(receptor);
	}
	
	public synchronized void hayTono()
	{
		
	}
	
	//el emisor indica a quien está llamando
	public synchronized void estaLlamando(int numMarcar, int id)
	{
		//marca al número 
		marcar[id]=numMarcar;
		//checa si está ocupado o no
		estaOcupado(numMarcar,id);
		
	}
	
	public synchronized void estaOcupado(int numMarcar, int id)
	{    //está ocupado
		if(this.id[numMarcar]!=Telefono.cye)
		{	System.out.println("el telefono: "+numMarcar+ " está ocupado");
		    this.id[id]=Telefono.dyd;
		    this.marcar[id]=id;
		}
		
	}
	
	public synchronized void estableciendoComunicacion(int emisor, int receptor)
	{
		id[emisor]=Telefono.dye;
		id[receptor]=Telefono.dye;
		System.out.println("Estableciendo llamada entre tel: "+ emisor+ " y tel: "+ receptor);
		id[emisor]=Telefono.dyo;
		id[receptor]=Telefono.dyo;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		id[emisor]=Telefono.dyd;
		id[receptor]=Telefono.dyd;
		
		
		
	}
	
	public synchronized void cambiarEstado(int id, int estado)
	{ 
		this.id[id]=estado;
		
	}


}
