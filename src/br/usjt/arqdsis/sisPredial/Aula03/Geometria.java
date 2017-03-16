package br.usjt.arqdsis.sisPredial.Aula03;

import java.util.ArrayList;
import java.util.List;

public class Geometria {

	public List<Figura> listaFiguras;
	
	public Geometria() {
		listaFiguras = new ArrayList<>();
		Triangulo t = new Triangulo();
		t.setAltura(2);
		t.setBase(2);
		t.setMP(2);
		t.setNM(2);
		listaFiguras.add(t);
		Retangulo r = new Retangulo();
		r.setAltura(2);
		r.setBase(2);
		listaFiguras.add(r);
		r = new Quadrado();
		r.setAltura(2);
		r.setBase(2);
		listaFiguras.add(r);
		r = new Losango();
		r.setAltura(2);
		r.setBase(2);
		listaFiguras.add(r);
		Circulo c = new Circulo();
		c.setDiametro(4);
		listaFiguras.add(c);
		Cubo cb = new Cubo();
		cb.setAltura(2);
		cb.setBase(2);
		cb.setLargura(2);
		listaFiguras.add(cb);
		cb = new Piramede();
		cb.setAltura(2);
		cb.setBase(2);
		cb.setLargura(2);
		listaFiguras.add(cb);
		c = new Cilindro();
		c.setDiametro(4);
		c.setAltura(2);
		listaFiguras.add(c);
		c = new Esfera();
		c.setDiametro(4);
		listaFiguras.add(c);
		
		
		
		
		for(Figura f: listaFiguras){
			
			System.out.println(f.getClass().getName().toString() + ":");
			
			System.out.print(" Area: " + f.area()+ ";");
			System.out.print(" Perimetro: " + f.perimetro() + ";");
			
			
			if (f instanceof Poligono3D)
				System.out.print(" Volume:" + ((Poligono3D) f).volume() + ";");
			if(f instanceof Retangulo)
				System.out.println(" Diagonal:" + ((Retangulo)f).calculaDiagonal()+ ";");
		}
	}
	
	
}
