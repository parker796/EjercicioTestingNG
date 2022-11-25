package clases;

public class sistemaLealtad {
	//sistema de lealtad
    private boolean estatusTarje, estatusCupon;
    private int saldoPuntos;

	public boolean isEstatusTarje() {
		return estatusTarje;
	}

	public void setEstatusTarje(boolean estatusTarje) {
		this.estatusTarje = estatusTarje;
	}

	public boolean isEstatusCupon() {
		return estatusCupon;
	}

	public void setEstatusCupon(boolean estatusCupon) {
		this.estatusCupon = estatusCupon;
	}

	public int getSaldoPuntos() {
		return saldoPuntos;
	}

	public void setSaldoPuntos(int saldoPuntos) {
		this.saldoPuntos = saldoPuntos;
	}
    
	 public String mostrarProductosExtras(int a) {
		 	if ( a >= 50 && a <= 100) {
		 		return "orden con Espagueti extra";
		 	}else if( a > 100 && a <= 150) {
		 		return "orden con Espagueti y Queso extra";
		 	}else if( a > 150) {
		 		return "Espagueti,Queso Extra,Cupon Pizza Gratis";
		 	}
		 	else {
	        return null;
		 	}
	    }
	 
	 public boolean usarCupon(String respuesta) {

	        if (respuesta.equals("Y")) {
	        	return true;
	        } else if (respuesta.equals("N")) {
	        	return false;
	        } else {
	        	return false;
	        }
	    }

}
