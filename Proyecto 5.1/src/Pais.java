import java.util.ArrayList;
public class Pais 
{
	private String nombre;
	private Fecha fechaAsociacion;
	private ArrayList<Envio> enviosRecibidos;
	
	public Pais (String str1, Fecha f)
	{
		nombre = str1;
		fechaAsociacion = f;
		enviosRecibidos = new ArrayList<Envio>(); 
	}
	
	public boolean sos (String str1)
	{
		return (nombre.equalsIgnoreCase(str1));
	}
	
	public String getNombre ()
	{
		return (nombre);
	}
	
	public String getFecha ()
	{
		return (fechaAsociacion.getFecha());
	}
	
	public void listarEnvios ()
	{
		if (enviosRecibidos.size() > 0)
		{
			for (Envio e : enviosRecibidos)
				e.listarEnvio();
		}
		else
			System.out.println ("El país "+nombre+" aún no ha recibido ningún pedido.");
	}
	
	public float getCostoTotal ()
	{
		float total = 0;
			
		for (Envio e : enviosRecibidos)
			total += e.getCosto();
		
		return (total);
	}
	
	public void setCajasRecibidas (Envio e2,int valor1)
	{
		int i = 0;
		
		while ((i < enviosRecibidos.size()) && !(enviosRecibidos.get(i).sos(e2.getPedido()))) //Para saber que dos envios son iguales comparo si sus pedidos son los mismos
			i++;
		
		if (i < enviosRecibidos.size())
			enviosRecibidos.get(i).setCajas(valor1);
	}
	
	public void setEnvio (Envio e)
	{
		enviosRecibidos.add(e);
	}
}
