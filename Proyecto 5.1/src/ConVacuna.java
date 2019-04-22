import java.util.Enumeration;
import java.util.Scanner;

public class ConVacuna extends Caja
{
	private Vacuna vacuna;
	private int dosis;
	
	public ConVacuna (Vacuna v, int valor1, String str1)
	{
		super (str1);
		vacuna = v;
		dosis = valor1;
	}
	
	public float getCosto ()
	{
		return (vacuna.getPrecio()*dosis);
	}
	
	public void listarCaja () 
	{
		System.out.println ("-- Caja con vacuna --");
		System.out.println ("Nombre de la enfermedad: "+super.getNombre());
		System.out.println ("Vacuna: "+vacuna.getNombre());
		System.out.println ("Dosis requerida: "+dosis);
		if (super.getCantidadRemedios() > 0)
			this.listarRemedios();
	}
	
	public boolean despacharCaja () 
	{
		if (dosis <= vacuna.getStock())
		{
			if (super.verificarCaja())
			{
				vacuna.descontarStock(dosis);
				super.descontarRemedios();
				return (true);
			}
		}
		return (false);
	}
	
	public boolean getContieneCaja (Vacuna v)
	{
		return (vacuna == v);
	}
	
}
