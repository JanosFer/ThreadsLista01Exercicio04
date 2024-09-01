package controller;

public class ThreadSaposController extends Thread{
	private static int colocacao = 1;
	private int tamanhoPulo;
	private int distancia;
	private int numeroSapo;
	
	public ThreadSaposController(int tamanhoPulo, int distancia, int numeroSapo) {
		this.tamanhoPulo = tamanhoPulo;
		this.distancia = distancia;
		this.numeroSapo = numeroSapo;
	}
	
	public void run() {
		corrida();
	}
	
	private void corrida() {
		double percorreu = 0;
		int nSaltos = 0;
		
		while(percorreu < distancia) {
			double salto =  Math.round(Math.random() * (tamanhoPulo + 1)* 100) / 100.0;
			percorreu += salto;
			nSaltos++;
		
			if(percorreu >= distancia) {
				synchronized (ThreadSaposController.class) {
					System.out.println(colocacao + "° lugar - Sapo" + (numeroSapo + 1) +  " concluiu a corrida de " + distancia + "m com " + nSaltos + " saltos");
					colocacao++;
				}
				break;
			}else {
				System.out.println("Sapo" + (numeroSapo + 1) +  " saltou " + salto + "m e percorreu " + percorreu + "m dos " + distancia + "m corrida");
			}
		}
	}
}
