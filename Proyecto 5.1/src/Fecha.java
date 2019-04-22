import java.util.Calendar;

public class Fecha 
{
	private int dia;
	private int mes;
	private int año;
	
	public Fecha()
	{
		Calendar c = Calendar.getInstance();
		dia = c.get(Calendar.DAY_OF_MONTH);
		mes = c.get(Calendar.MONTH)+1;
		año = c.get(Calendar.YEAR);
	}
	
	public int compareTo (Fecha f)
	{
		int f1 = año * 10000 + mes * 100 + dia;
		int f2 = f.getAño() * 10000 + f.getMes()* 100 + f.getDia();
		return (f1 - f2);
	}

	public Fecha sumarMeses (int valor1)
	{
		Fecha f = new Fecha();
		
		int m2 = mes;
		int a2 = año;
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
		f.setAño (a2);
		return (f);
	}

	public boolean entre(Fecha f1,Fecha f2)
	{
		return (this.compareTo(f1) >= 0 && this.compareTo(f2) <= 0);
	}
	
	public String getFecha()
	{
		return (dia+"/"+mes+"/"+año);
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
	
	public void setAño(int valor1) 
	{
		año = valor1;
	}
	
	public int getAño() 
	{
		return (año);
	}
}
