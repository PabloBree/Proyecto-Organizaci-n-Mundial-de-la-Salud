public class Remedio 
{
	private int codigo;
	private String nombre;
	private int stock;
	
	public Remedio (int valor1, String str1, int valor2)
	{
		codigo = valor1;
		nombre = str1;
		stock = valor2;
	}	
	
	public boolean sos (int valor1)
	{
		return (codigo == valor1);
	}	
	
	public String getNombre ()
	{
		return (nombre);
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
		stock+= valor1;
	}
}
