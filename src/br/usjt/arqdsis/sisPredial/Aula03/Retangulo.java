package br.usjt.arqdsis.sisPredial.Aula03;

public class Retangulo extends Poligono implements Diagonal 
{

	@Override
	public double calculaDiagonal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double perimetro() {
		return getBase() * 2 + getAltura() * 2;
	}
	
	

}
