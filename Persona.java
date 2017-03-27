import java.util.Random;

public class Persona extends Thread{

	Telefono tel;
	static final int  descolgar=1,marcar=2,colgar=3;
	
	
	public Persona(Telefono tel)
	{
		this.tel=tel;
	}
	
	public void descolgar()
	{ 
		tel.cambiaEstado(descolgar);
		
	}
	
	public void marcar(int numero)
	{   
		tel.setNumMarcar(numero);
		tel.cambiaEstado(marcar);
	}
	
	public void colgar()
	{
		tel.cambiaEstado(colgar);
		
	}
	
	public void run()
	{
		int aux=0;
		
		while(true)
		{   
			aux=(int)(Math.random()*3+1);		
			switch(aux){
			case 1: 
				this.descolgar(); 
				try{
				Thread.sleep(1000);
				}catch(Exception e){}
				break;
			case 2:
				this.marcar((int)(Math.random()*9)); 
				try{
				Thread.sleep(1000);
				}catch(Exception e){}
				break;
			case 3:
				this.colgar(); 
				try{
				Thread.sleep(1000);
				}catch(Exception e){}
				break;
			
		}
	   }
	}
	
	
	
}
