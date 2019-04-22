public class SinVacuna extends Caja
{
	public SinVacuna (String nom)
	{
		super (nom);
	}
	
	public boolean despacharCaja()
	{
		if (super.verificarCaja())
		{
			super.descontarRemedios();
			return (true);
		}
		return (false);
	}
	
	public boolean getContieneCaja (Vacuna v)
	{
		return (false);
	}
}
