import java.net.StandardSocketOptions;
import java.util.Scanner;
public class Ejecutora 
{
	public static void main(String[] args) 
	{
		Oms org = new Oms();
		Scanner entrada = new Scanner(System.in);
		int op;
		Scanner in = new Scanner(System.in);
		int opcion;
		
		do
		{	
			System.out.println ("----------------");
			System.out.println ("Menú principal.");
			System.out.println ("0: Salir.");
			System.out.println ("1: Remedio.");
			System.out.println ("2: Vacuna.");
			System.out.println ("3: País.");
			System.out.println ("4: Pedido.");
			System.out.println ("5: Transporte.");
			System.out.println ("6: Caja.");
			System.out.println ("----------------");
			op = entrada.nextInt();

			switch (op)
			{ 		
				
				case 1 : //Remedio
					System.out.println ("0: Salir.");
					System.out.println ("1: Agregar remedio."); 
					System.out.println ("2: Agregar stock de remedio."); 
					System.out.println ("3: Listar remedios."); 
					opcion = in.nextInt();				
					
					switch (opcion)
					{
						case 1:
							org.agregarRemedio();
						break;
						case 2:
							org.agregarStockRemedio();
						break;	
						case 3:
							org.listarRemedios();
						break;
					}
				break;
				
				case 2: //Vacuna
					System.out.println ("0: Salir.");
					System.out.println ("1: Agregar vacuna."); 
					System.out.println ("2: Agregar stock de vacuna."); 
					System.out.println ("3: Listar vacunas."); 
					opcion = in.nextInt();				
					
					switch (opcion)
					{
						case 1:
							org.agregarVacuna();
						break;
						case 2:
							org.agregarStockVacuna();
						break;	
						case 3:
							org.listarVacunas();
						break;						
					}
				break;
				
				case 3: //Pais
					System.out.println ("0: Salir.");
					System.out.println ("1: Agregar país."); 
					System.out.println ("2: Listar todos los envíos de un país."); 
					System.out.println ("3: Informar total a pagar por un país."); 
					System.out.println ("4: Listar países asociados."); 
					opcion = in.nextInt();
					
					switch (opcion)
					{
						case 1:
							org.agregarPais();
						break;
						case 2:
							org.listarEnviosPais();
						break;	
						case 3:
							org.informarTotalPagarPais();
						break;	
						case 4:
							org.listarPaises();
						break;	
						
					}
				break;
				
				case 4: //Pedido
					System.out.println ("0: Salir.");
					System.out.println ("1: Agregar pedido."); 
					System.out.println ("2: Informar estado de un pedido."); 
					System.out.println ("3: Informar costo de cada pedido enviado.");
					System.out.println ("4: Informar todos los pedidos despachados por completo.");
					opcion = in.nextInt();
					
					switch (opcion)
					{
					case 1:
						org.agregarPedido();
					break;
					case 2:
						org.informarEstadoPedido();
					break;
					case 3:
						org.informarCostoPedidosEnviados();
					break;
					case 4:
						org.informarPedidosDespachados();
					break;
					}
				break;
				
				case 5: //Transpote
					System.out.println ("0: Salir.");
					System.out.println ("1: Modificar el valor de transporte.");
					opcion = in.nextInt();
					
					switch (opcion)
					{
						case 1:
							org.modificarPrecioTransporte();
						break;
					}
				break;
				
				case 6:	//Caja
					System.out.println ("0: Salir.");
					System.out.println ("1: Preparar caja.");
					System.out.println ("2: Listar las cajas preparadas para afrontar las enfermedades."); 
					opcion = in.nextInt();
					
					switch (opcion)
					{
						case 1:
							org.prepararCaja();
						break;
						case 2:
							org.listarCajasPreparadas();
						break;
					}
				break;
			}
		}while(op>0);
	}
}
