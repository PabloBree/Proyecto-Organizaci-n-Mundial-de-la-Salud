import java.util.Calendar;

public class Fecha 
{
	private int dia;
	private int mes;
	private int a�o;
	
	public Fecha()
	{
		Calendar c = Calendar.getInstance();
		dia = c.get(Calendar.DAY_OF_MONTH);
		mes = c.get(Calendar.MONTH)+1;
		a�o = c.get(Calendar.YEAR);
	}
	
	public int compareTo (Fecha f)
	{
		int f1 = a�o * 10000 + mes * 100 + dia;
		int f2 = f.getA�o() * 10000 + f.getMes()* 100 + f.getDia();
		return (f1 - f2);
	}

	public Fecha sumarMeses (int valor1)
	{
		Fecha f = new Fecha();
		
		int m2 = mes;
		int a2 = a�o;
		int restan;
		
		do
		{
			restan = 12 - m2;
			if (restan >= valor1)
			{
				m2 += valor1;
				valor1 = 0;
			}
			else
			{
				valor1 -= restan;
				m2 = 0;
				a2 ++;
			}
		}
		while (valor1 > 0);
		
		f.setDia (this.dia);
		f.setMes (m2);
		f.setA�o (a2);
		return (f);
	}

	public boolean entre(Fecha f1,Fecha f2)
	{
		return (this.compareTo(f1) >= 0 && this.compareTo(f2) <= 0);
	}
	
	public String getFecha()
	{
		return (dia+"/"+mes+"/"+a�o);
	}
	
	public int getDia()
	{
		return (dia);
	}
	
	public void setDia(int valor1) 
	{
		dia = valor1;
	}
	
	public void setMes(int valor1) 
	{
		mes = valor1;
	}
	
	public int getMes() 
	{
		return (mes);
	}
	
	public void setA�o(int valor1) 
	{
		a�o = valor1;
	}
	
	public int getA�o() 
	{
		return (a�o);
	}
}
