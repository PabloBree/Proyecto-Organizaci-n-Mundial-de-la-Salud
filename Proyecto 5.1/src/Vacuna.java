public class Vacuna 
{
	private int codigo;
	private String nombre;
	private int stock;
	private float costo;
	
	public Vacuna (int valor1, String str1, int valor2, float valor3)
	{
		codigo = valor1;
		nombre = str1;
		stock = valor2;
		costo = valor3;
	}
	
	public boolean sos (int valor1)
	{
		return (codigo == valor1);
	}
	
	public String getNombre ()
	{
		return (nombre);
	}
	
	public float getPrecio ()
	{
		return (costo);
	}
	
	public int getStock ()
	{
		return (stock);
	}
	
	public void descontarStock (int valor1)
	{
		stock -= valor1;
	}
	
	public void setStock (int valor1)
	{
		stock += valor1;
	}
}
