import java.util.Hashtable;
import java.util.Enumeration;

public abstract class Caja 
{
	private Hashtable<Remedio,Integer> remediosNecesarios;
	private String nombreEnfermedad;
	
	public abstract boolean despacharCaja ();
	public abstract boolean getContieneCaja (Vacuna v);
	
	public Caja (String nom)
	{
		remediosNecesarios = new Hashtable<Remedio,Integer>();
		nombreEnfermedad = nom;
	}
	
	boolean sos (String str1) 
	{
		return (nombreEnfermedad.equalsIgnoreCase(str1));
	}
	
	public String getNombre ()
	{
		return (nombreEnfermedad);
	}
	
	public float getCosto ()
	{
		return (0);
	}
	
	public void setRemedio (Remedio r, int valor1) 
	{
		if (remediosNecesarios.containsKey(r)) 
		{
			Integer cantidad = remediosNecesarios.get(r);
			cantidad += valor1;
			remediosNecesarios.put (r, cantidad);
		}
		else
			remediosNecesarios.put (r, valor1); 
	}
	
	public void listarRemedios () 
	{
		Remedio r;
		Enumeration<Remedio> keys = remediosNecesarios.keys();
		System.out.println ("-- Remedios --");
		
		while (keys.hasMoreElements())
		{
			r = keys.nextElement();
			System.out.println ("Nombre del remedio: "+r.getNombre());
			System.out.println ("Cantidad requerida: "+remediosNecesarios.get(r));
		}		
	}
	
	public int getCantidadRemedios () 
	{
		return (remediosNecesarios.size());
	}
	
	public void listarCaja () 
	{
		System.out.println ("-- Caja sin vacuna --");
		System.out.println ("Nombre de la enfermedad: "+nombreEnfermedad);
		this.listarRemedios();
	}
	
	public boolean verificarCaja () 
	{
		Enumeration<Remedio> keys = remediosNecesarios.keys();
		Remedio r;
		boolean sigo = true;
		
		while (keys.hasMoreElements() && sigo)
		{
			r = keys.nextElement();
			
			if (remediosNecesarios.get(r) > r.getStock())
				sigo = false;
		}
		
		return (sigo);
	}
	
	public void descontarRemedios () 
	{
		Enumeration<Remedio> keys = remediosNecesarios.keys();
		
		Remedio r;
		
		while (keys.hasMoreElements())
		{
			r = keys.nextElement();
			r.descontarStock (remediosNecesarios.get(r));
		}		
	}
	
	public boolean getContainsKey (Remedio r)
	{
		if (r != null)
			return (remediosNecesarios.containsKey(r));
		else
			return (false);
	}
}
