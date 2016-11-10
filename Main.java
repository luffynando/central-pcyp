
public class Main {
	
	public static void main(String[] args)
	{
		Central c= new Central();
		
		Telefono[]  tel= new Telefono[10];
		
		Persona[]  personas= new Persona[10];
		
		for(int i=0;i<10;i++)
		{ tel[i]=new Telefono(i,c);
		  personas[i]=new Persona(tel[i]);
		}
		
		for(int i=0;i<10;i++)
		{tel[i].start();
		 personas[i].start();
		}
		
		try {
			tel[0].join();
		} catch (InterruptedException e) {}
	}

}
