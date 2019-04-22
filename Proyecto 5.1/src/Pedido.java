public class Pedido 
{
	private int codigo;
	private Caja caja;
	private int cantidad;
	private Pais pais;
	private Fecha fechaVencimiento;
	
	public Pedido (int valor1, Caja c, int valor2, Pais p, Fecha f)
	{
		codigo = valor1;
		caja = c;
		cantidad = valor2;
		pais = p;
		fechaVencimiento = f;
	}	
	
	public boolean sos (int valor1)
	{
		return (codigo == valor1);
	}
	
	public int getCodigo ()
	{
		return (codigo);
	}
	
	public float getCostoCaja ()
	{
		return (caja.getCosto());
	}
	
	public int getCantidadCajas ()
	{
		return (cantidad);
	}
	
	public boolean despacharCaja ()
	{
		return (caja.despacharCaja());
	}
	
	public void restarCantidadCajas ()
	{
		cantidad--;
	}
	
	public void setCajasRecibidasPais (Envio e, int valor1)
	{
		pais.setCajasRecibidas(e, valor1);
	}
	
	public void setEnvioPais (Envio e)
	{
		pais.setEnvio(e);
	}
	
	public String getFecha()
	{
		return (fechaVencimiento.getFecha());
	}
	
	public Fecha getFechaVencimiento ()
	{
		return (fechaVencimiento);
	}
	
	public boolean getContainsKey (Remedio r)
	{
		return (caja.getContainsKey(r));
	}
	
	public boolean getContieneVacuna (Vacuna v)
	{
		return (caja.getContieneCaja(v));
	}
}
