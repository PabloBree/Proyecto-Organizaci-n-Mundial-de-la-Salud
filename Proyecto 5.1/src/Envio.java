import java.util.Scanner;
public class Envio 
{
	private Pedido pedido;
	private int cantCajas;
	private static float costeTransporte;
	
	public Envio (Pedido p,int valor1)
	{
		pedido = p;
		cantCajas = valor1;
	}
	
	public Pedido getPedido () 
	{
		return (pedido);
	}
	
	public boolean sos (Pedido p) 
	{
		return (pedido == p);
	}
	
	public int getCajas () 
	{
		return (cantCajas);
	}
	
	public float getCosto ()
	{
		return (pedido.getCostoCaja()*cantCajas+this.getPrecioTransporte());
	}
	
	public void listarEnvio ()
	{
		System.out.println ("Código de pedido: "+pedido.getCodigo());
		System.out.println ("Cajas recibidas: "+cantCajas);
		System.out.println ("Costo: "+this.getCosto());
	}
	
	public static float getPrecioTransporte()
	{
		if (costeTransporte == 0)
		{
			Scanner entrada = new Scanner(System.in);
			
			System.out.print ("Ingrese el valor de transporte:");
			costeTransporte = entrada.nextFloat();
		}
		return (costeTransporte);
	}
	
	public static void modificarValorTransporte (int valor1) 
	{
		costeTransporte = valor1;
	}	
	
	public int getCodigo ()
	{
		return (pedido.getCodigo());
	}
	
	public void setCajas (int valor1)
	{
		cantCajas += valor1;
	}

}
