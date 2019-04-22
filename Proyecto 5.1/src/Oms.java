import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Oms 
{
	private ArrayList<Remedio> remedios;
	private ArrayList<Caja> cajas; 
	private ArrayList<Pais> paises;
	private ArrayList<Vacuna> vacunas; 
	private ArrayList<Pedido> pedidos; 
	private ArrayList<Envio> envios;
	
	public Oms()
	{
		remedios = new ArrayList<Remedio>();
		cajas = new ArrayList<Caja>();
		paises = new ArrayList<Pais>();
		vacunas = new ArrayList<Vacuna>();
		pedidos = new ArrayList<Pedido>();
		envios = new ArrayList<Envio>();
	}

	public Envio buscarEnvio(Pedido p)  
	{
		int i=0;
		
		while ((i < envios.size()) && !(envios.get(i).sos(p)))
			i++;
		
		if (i == envios.size())
			return (null);
		else
			return (envios.get(i));
	}	
	
	public Pedido buscarPedido (int valor1) 
	{
		int i = 0;
		
		while ((i < pedidos.size()) && !(pedidos.get(i).sos(valor1)))
			i++;
		
		if (i == pedidos.size())
			return (null);
		else
			return (pedidos.get(i));
	}	
	
	public Pais buscarPais (String str1) 
	{
		int i = 0;
		
		while ((i < paises.size()) && !(paises.get(i).sos(str1)))
			i++;
		
		if (i == paises.size())
			return (null);
		else
			return (paises.get(i));
	}	
	
	public Vacuna buscarVacuna (int valor1)
	{
		int i = 0;
		
		while ((i < vacunas.size()) && !(vacunas.get(i).sos(valor1)))
			i++;
		
		if (i == vacunas.size())
			return (null);
		else
			return (vacunas.get(i));
	}
	
	public Caja buscarCaja (String str1)
	{
		int i = 0;
		
		while ((i < cajas.size()) && !(cajas.get(i).sos(str1)))
			i++;
		
		if (i == cajas.size())
			return (null);
		else
			return (cajas.get(i));
	}	
	
	public Remedio buscarRemedio (int valor1)
	{
		int i = 0;
		
		while ((i < remedios.size()) && !(remedios.get(i).sos(valor1)))
			i++;
		
		if (i == remedios.size())
			return (null);
		else
			return (remedios.get(i));
	}	
	
	public void agregarRemedio ()
	{
		Scanner entrada = new Scanner (System.in);
		
		System.out.print ("Ingrese el código del remedio: ");
		int codRemedio = entrada.nextInt();
		
		Remedio r = this.buscarRemedio(codRemedio);
		
		if (r == null)
		{
			System.out.print ("Ingrese el nombre del remedio: ");
			String nomRemedio = entrada.next();
			
			System.out.print ("Ingrese el stock del remedio: ");
			int stockRemedio = entrada.nextInt();
			
			r = new Remedio (codRemedio, nomRemedio, stockRemedio);
			
			remedios.add(r);
			
			System.out.println ("El remedio "+r.getNombre()+" ha sigo cargado con éxito.");
		}
		else
			System.out.println ("El código de remedio ingresado ya existe.");
	}
	
	public void agregarVacuna ()
	{
		Scanner entrada = new Scanner (System.in);
		
		System.out.print ("Ingrese el código de la vacuna: ");
		int codVacuna = entrada.nextInt();
		
		Vacuna v = this.buscarVacuna(codVacuna);
		
		if (v == null)
		{
			System.out.print ("Ingrese el nombre de la vacuna: ");
			String nomVacuna = entrada.next();
			
			System.out.print ("Ingrese el stock de la vacuna: ");
			int stockVacuna = entrada.nextInt();
			
			System.out.print ("Ingrese el costo de la vacuna: ");
			float costoVacuna = entrada.nextFloat();
			
			v = new Vacuna (codVacuna, nomVacuna, stockVacuna, costoVacuna);
			
			vacunas.add(v);
			
			System.out.println ("La vacuna "+v.getNombre()+" ha sigo cargada con éxito.");
		}
		else
			System.out.println ("El código de vacuna ingresado ya existe.");
	}
	
	public void agregarStockRemedio ()
	{
		if (remedios.size() > 0)
		{
			Scanner entrada = new Scanner (System.in);
			
			System.out.print ("Ingrese código de remedio: ");
			int codRem = entrada.nextInt();
			
			Remedio r = this.buscarRemedio (codRem);
			
			if (r != null)
			{
				System.out.print ("Ingrese la cantidad que desea agregar: ");
				int cantRem = entrada.nextInt();
				
				if (cantRem > 0)
				{
					r.setStock (cantRem);
					System.out.println ("Se intentara despachar pedidos con el nuevo Stock ingresado.");
					
					this.despacharPedidos(r, null);
					System.out.println ("El stock actual del remedio "+r.getNombre()+" es de "+r.getStock()+".");
				}
				else
					System.out.println ("La cantidad ingresada es invalida.");
			}
			else
				System.out.println ("El código de remedio ingresado no existe.");
		}
		else
			System.out.println ("No hay remedios cargados en el sistema.");
	}
	
	public void agregarStockVacuna () 
	{
		if (remedios.size() > 0)
		{
			Scanner entrada = new Scanner (System.in);
			
			System.out.print ("Ingrese código de vacuna: ");
			int codVac = entrada.nextInt();
			
			Vacuna v = this.buscarVacuna (codVac);
			
			if (v != null)
			{
				System.out.print ("Ingrese la cantidad que desea agregar: ");
				int cantVac = entrada.nextInt();
				
				if (cantVac > 0)
				{
					v.setStock (cantVac);
					System.out.println ("Se intentara despachar pedidos con el nuevo Stock ingresado.");
					
					this.despacharPedidos(null, v);
					System.out.println ("El stock actual del remedio "+v.getNombre()+" es de "+v.getStock()+".");
				}
				else
					System.out.println ("La cantidad ingresada es invalida.");
			}
			else
				System.out.println ("El código de vacuna ingresado no existe.");
		}
		else
			System.out.println ("No hay vacunas cargadas en el sistema.");
	}	
	 
	public void agregarPais ()
	{
		Scanner entrada = new Scanner (System.in);
		
		System.out.print ("Ingrese el nombre del país: ");
		String nomPais = entrada.next();
		
		Pais p = this.buscarPais(nomPais);
		
		if (p == null)
		{
			Fecha fHoy = new Fecha();
			
			p = new Pais (nomPais, fHoy);
			paises.add(p);
			
			System.out.println ("El país "+p.getNombre()+" ha sido cargado con éxito.");
		}
		else
			System.out.println ("El nombre de país ingresado ya existe.");
	}
	
	public void prepararCaja ()
	{
		Scanner entrada = new Scanner (System.in);
		
		System.out.print ("Ingrese el nombre de la enfermedad: ");
		String nomEnfermedad = entrada.next();
		
		Caja c = this.buscarCaja(nomEnfermedad);
		
		if (c == null)
		{
			System.out.println ("1: Caja con vacuna.");
			System.out.println ("2: Caja sin vacuna.");
			int op = entrada.nextInt();
			
			switch (op)
			{
				case 1:
				{
					System.out.print ("Ingrese el código de la vacuna correspondiente: ");
					int codVacuna = entrada.nextInt();
					
					Vacuna v = this.buscarVacuna(codVacuna);
					
					if (v != null)
					{
						System.out.print ("Ingrese la dosis de vacuna que necesita: ");
						int dosisVacuna = entrada.nextInt();
						
						if (dosisVacuna > 0)
						{
							c = new ConVacuna (v, dosisVacuna, nomEnfermedad);
							
							this.prepararRemedioCaja(c);
							cajas.add(c);
						}
						else
							System.out.println ("La cantidad de dosis que ha ingresado no es valida.");
					}
					else
						System.out.println ("El código de vacuna ingresado no existe.");
				}
				break;
				case 2:
				{
					c = new SinVacuna (nomEnfermedad);
					
					this.prepararRemedioCaja(c);
					
					if (c.getCantidadRemedios() > 0)
					{
						cajas.add(c);
						System.out.println ("El modelo de caja se ha creado con éxito.");
					}
					else
						System.out.println ("No se puede crear la cajas sin contener remedios.");
				}
			}
		}
		else
			System.out.println ("La caja que desea crear ya existe.");
	}

	public void prepararRemedioCaja (Caja cajaTipo)
	{
		Scanner entrada = new Scanner (System.in);
		
		System.out.print ("Ingrese el código de remedio (0 para fin de ingreso): ");
		int codRemedio = entrada.nextInt();
		
		while (codRemedio != 0)
		{
			Remedio r = this.buscarRemedio (codRemedio);
			
			if (r != null)
			{
				System.out.print ("Ingrese la cantidad de remedio que necesita: ");
				int cantRemedio = entrada.nextInt();
				
				if (cantRemedio > 0)
					cajaTipo.setRemedio(r, cantRemedio);
				else
					System.out.println ("La cantidad de remedio ingresada no es valida.");
			}
			else
				System.out.println ("El código de remedio ingresado no existe.");
			
			System.out.print ("Ingrese el código de remedio (0 para fin de ingreso): ");
			codRemedio = entrada.nextInt();
		}
	}
	
	public void agregarPedido ()
	{
		Scanner entrada = new Scanner (System.in);
		
		System.out.print ("Ingrese el código del pedido: ");
		int codPed = entrada.nextInt();
		
		Pedido ped = this.buscarPedido(codPed);
		
		if (ped == null)
		{
			System.out.print ("Ingrese el nombre del país que realiza el pedido: ");
			String nomPais = entrada.next();
			
			Pais p = this.buscarPais (nomPais);
			
			if (p != null) 
			{
				System.out.print ("Ingrese el nombre de la enfermedad: ");
				String nomEnf = entrada.next();
				
				Caja c = this.buscarCaja(nomEnf);
				
				if (c != null)
				{
					System.out.print ("Ingrese la cantidad de cajas que necesita para esa enfermedad: ");
					int cantCajas = entrada.nextInt();
					
					if (cantCajas > 0)
					{
						Fecha f = new Fecha();
						f = f.sumarMeses(1);
						
						ped = new Pedido (codPed, c, cantCajas, p, f);
						pedidos.add(ped);
						
						System.out.println ("El pedido ha sido registrado con éxito, se indicara si pudo ser despachado o si estara en espera.");
						
						this.despacharPedido(ped);
						
						if (ped.getCantidadCajas() == 0) 
							System.out.println ("El pedido se ha despachado por completo.");
						else
							if (ped.getCantidadCajas() < cantCajas)
							{
								cantCajas -= ped.getCantidadCajas();
								System.out.println ("Se ha despachado "+cantCajas+" caja/s del pedido ingresado. Seguirá en espera para despachar por completo.");
								System.out.println ("La fecha de vencimiento es: "+ped.getFecha());
							}
							else
								System.out.println ("El pedido estara en espera de los medicamentos.");
					}
					else
						System.out.println ("No se puede registrar un pedido sin ingresar la cantidad de cajas necesitadas.");
				}
				else
					System.out.println ("La enfermedad ingresada no existe.");
			}
			else
				System.out.println ("El país ingresado no existe.");
		}
		else
			System.out.println ("El código de pedido ingresado ya existe, esta en lista de espera.");
	}	
	
	public void despacharPedido (Pedido ped)
	{
		int cont = 0;
		
		while (ped.despacharCaja() && ped.getCantidadCajas() > 0)
		{
			cont ++;
			ped.restarCantidadCajas();
		}
		
		if (cont > 0) 
		{			
			Envio e = this.buscarEnvio(ped); 
			
			if (e != null)
			{
				e.setCajas (cont);
				ped.setCajasRecibidasPais (e, cont);
			}
			else
				{
					e = new Envio (ped, cont);
					envios.add(e);
					ped.setEnvioPais(e);
				}
		}
	}
	
	public void despacharPedidos (Remedio r, Vacuna v)
	{
		if (pedidos.size() > 0)
		{
			Fecha f = new Fecha();
			
			for (Pedido p : pedidos)
			{
				if (p.getContainsKey(r) || p.getContieneVacuna(v))
				{
					if (f.entre(f, p.getFechaVencimiento()))
					{
						int cont = p.getCantidadCajas();
						
						this.despacharPedido(p);
							
						if (p.getCantidadCajas() == 0)
							System.out.println("El pedido "+p.getCodigo()+" se despacho por completo.");
						else
							if (p.getCantidadCajas() < cont)
							{
								cont -= p.getCantidadCajas();
								System.out.println ("Solo se ha despachado "+cont+" caja/s del pedido "+p.getCodigo()+".");
							}
					}
					else
						System.out.println ("El pedido "+p.getCodigo()+" esta vencido, no puede ser verificado para su despacho.");	
					System.out.println ("**********");
				}
			}
		}
		else
			 System.out.println("No hay pedidos para despachar.");
	}
	
	public void modificarPrecioTransporte ()
	{
		Scanner entrada = new Scanner (System.in);
		
		System.out.print ("Ingrese el nuevo valor del transporte: ");
		int valorTransporte = entrada.nextInt();
		
		if (valorTransporte > 0)
			Envio.modificarValorTransporte(valorTransporte);
		else
			System.out.println ("El valor ingresado no es valido.");
	}	
	
	public void listarRemedios ()
	{
		if (remedios.size() > 0)
		{
			for (Remedio r: remedios)
			{
				System.out.println("----------");
				System.out.println ("Remedio: "+r.getNombre());
				System.out.println ("Stock: "+r.getStock()+" unidades");
				System.out.println("----------");
			}			
		}
		else
			System.out.println ("No hay remedios cargados en la oms para listar.");
	}
	
	public void listarVacunas()
	{
		if (vacunas.size() != 0)
		{
			for (Vacuna v: vacunas)
			{
				System.out.println("----------");
				System.out.println ("Vacuna: "+v.getNombre());
				System.out.println ("Costo: $"+v.getPrecio());
				System.out.println ("Stock: "+v.getStock()+" unidades");
				System.out.println("----------");
			}			
		}
		else
			System.out.println ("No hay vacunas cargadas en la oms para listar.");
	}
	
	public void listarPaises ()
	{
		if (paises.size() > 0)
		{
			for (Pais p : paises)
			{
				System.out.println("----------");
				System.out.println ("País: "+p.getNombre());
				System.out.println ("Fecha de asociación: "+p.getFecha());
				System.out.println("----------");
			}
		}
		else
			System.out.println ("No hay países cargados aún.");
	}
	
	public void listarEnviosPais ()
	{
		Scanner entrada = new Scanner (System.in);
		
		System.out.print ("Ingrese el nombre del país: ");
		String nomPais = entrada.next();
		
		Pais p = this.buscarPais(nomPais);
		
		if (p != null)
			p.listarEnvios();
		else
			System.out.println ("El país ingresado no existe.");
	}
	
	
	public void listarCajasPreparadas ()
	{
		for (Caja c : cajas)
		{
			c.listarCaja();
			System.out.println ();
			System.out.println ("**********");
		}
	}
	
	public void informarCostoPedidosEnviados ()
	{
		if (envios.size() > 0)
		{
			for (Envio e : envios)
			{
				System.out.println ("Código de pedido: "+ e.getCodigo());
				System.out.println ("Costo: "+ e.getCosto());
				System.out.println ("***************");
			}
		}
		else
			System.out.println ("No hay envíos realizados.");
	}
	
	public void informarTotalPagarPais ()
	{
		Scanner entrada = new Scanner (System.in);
		
		System.out.print ("Ingrese el nombre del país: ");
		String nomPais = entrada.next();
		
		Pais p = this.buscarPais(nomPais);
		
		if (p != null)
			System.out.println ("El costo total a pagar por el país es: "+p.getCostoTotal());
		else
			System.out.println ("El país ingresado no existe.");
	}
	
	public void informarPedidosDespachados ()
	{
		if (pedidos.size() > 0)
		{
			int cont = 0;
			for (Pedido p : pedidos)
			{
				if (p.getCantidadCajas() == 0)
				{
					cont++;
					System.out.println ("El pedido código "+p.getCodigo()+" se ha despachado por completo.");
				}
			}
			if (cont == 0)
				System.out.println ("No se ha despachado ningún pedido por completo aún.");
		}
		else
			System.out.println ("No hay pedidos cargados.");
	}
	
	public void informarEstadoPedido ()
	{
		if (pedidos.size() > 0)
		{
			Scanner entrada = new Scanner (System.in);
			
			System.out.print ("Ingrese el código del pedido: ");
			int codPed = entrada.nextInt();

			Pedido p = this.buscarPedido(codPed);
			
			if (p != null)
			{
				if (p.getCantidadCajas() > 0)
				{
					Envio e = this.buscarEnvio(p);
					
					if (e != null)
					{
						System.out.println ("Se envío "+e.getCajas()+" caja/s del pedido "+e.getCodigo()+".");
						System.out.print ("Aún pendiente/s "+p.getCantidadCajas()+" caja/s. Fecha de vencimiento "+p.getFecha()+".");
					}
					else
						System.out.println ("No se ha despachado ninguna caja.");
				}
				else
					System.out.println ("El pedido "+p.getCodigo()+" ya ha sido despachado por completo.");
			}
			else
				System.out.println ("El código de pedido ingresado no existe.");			
		}
		else
			System.out.println ("No hay pedidos cargados.");	
	}
}
