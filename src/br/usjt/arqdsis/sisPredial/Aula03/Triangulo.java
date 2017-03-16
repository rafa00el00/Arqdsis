package br.usjt.arqdsis.sisPredial.Aula03;

public class Triangulo extends Poligono
{


	private double NM;
	private double MP;

	public double getNM() {
		return NM;
	}
	public void setNM(double nM) {
		NM = nM;
	}
	public double getMP() {
		return MP;
	}
	public void setMP(double mP) {
		MP = mP;
	}
	@Override
	public double area() {
		return super.area()/ 2;
	}
	
	@Override
	public double perimetro() {
		return getNM() + getBase() + getMP();
	}
	
}
