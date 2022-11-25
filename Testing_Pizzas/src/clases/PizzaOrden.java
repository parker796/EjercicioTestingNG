package clases;




import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PizzaOrden {

    private boolean opcionVeg = false;
    private String ingrediente1 = "", ingrediente2 = "", ingrediente3 = "";

    public void desplegarMensajeInicio() {
        System.out.println("Bienvenido a la aplicación para ordenar pizza.\n\n"
                + "Sigue las instrucciones por favor.\n\n");
    }

    public boolean getOpcionVeg() {
        return this.opcionVeg;
    }

    public void setOpcionVeg(String opcion_veg) {
        if (opcion_veg.equals("Y")) {
            this.opcionVeg = true;
        } else {
            this.opcionVeg = false;
        }
    }

    public String getIngrediente1() {
        return ingrediente1;
    }

    public void setIngrediente1(String ingrediente1) {
        this.ingrediente1 = letraIngredienteAString(ingrediente1);
    }

    public String getIngrediente2() {
        return ingrediente2;
    }

    public void setIngrediente2(String ingrediente2) {
        this.ingrediente2 = letraIngredienteAString(ingrediente2);
    }

    public String getIngrediente3() {
        return ingrediente3;
    }

    public void setIngrediente3(String ingrediente3) {
        this.ingrediente3 = letraIngredienteAString(ingrediente3);
    }

    public void preguntarPizzaVegetariana() {
        System.out.println("¿Deseas pizza vegetariana (Y/N)?");
        Scanner input = new Scanner(System.in);
        setOpcionVeg(input.next());
    }

    public void desplegarMensajeDefault() {
        System.out.println("Todas las pizzas contienen Salsa de Tomate y Queso Mozzarella.\n\n");
    }

    public void desplegarIngredientes() {

        System.out.print("Selecciona 3 ingredientes de la siguiente  lista: \n"
                                + "[a] Pimiento \n"
                                + "[b] Hongos \n"
                                + "[c] Espinaca \n");

        if (!opcionVeg) {
            System.out.print(      "[d] Peperoni \n"
                                + "[e] Jamon \n"
                                + "[f] Salchicha \n");
        }

        System.out.println(          "[o] Ninguno \n\n");

    }    

    public void guardarIngredientes() {

        Scanner input = new Scanner(System.in);

        System.out.println("Ingrediente 1: ");
        setIngrediente1(input.next());
        System.out.println("Ingrediente 2: ");
        setIngrediente2(input.next());
        System.out.println("Ingrediente 3: ");
        setIngrediente3(input.next());

    }

    public void desplegarResumenOrden() {
        if (this.opcionVeg) {
            System.out.println("La pizza a ordenar es vegetariana.\n");
        } else {
            System.out.println("La pizza a ordenar no es vegetariana.\n");
        }

        System.out.println("Los ingredientes seleccionados son: \n");

        String ingredientes = "";
        if (getIngrediente1() != "Opcion_Invalida") { ingredientes = getIngrediente1() + ","; }
        if (getIngrediente2() != "Opcion_Invalida") { ingredientes = getIngrediente2() + ","; }
        if (getIngrediente3() != "Opcion_Invalida") { ingredientes = getIngrediente3() + ","; }

        System.out.println(ingredientes.substring(0,ingredientes.length()-1));
    }

    private String letraIngredienteAString(String letraIngrediente) {
             if (letraIngrediente.equals("a")) { return "Pimiento"; }
        else if (letraIngrediente.equals("b")) { return "Hongos"; }
        else if (letraIngrediente.equals("c")) { return "Espinaca"; }
        else if (letraIngrediente.equals("d")) { return "Peperoni"; }
        else if (letraIngrediente.equals("e")) { return "Jamon"; }
        else if (letraIngrediente.equals("f")) { return "Salchicha"; }
        else { return "Opcion_Invalida"; }        
    }
    
    @Test
    public void verificarOpcionVeganaVerdadera() {
    	PizzaOrden nuevaOrden = new PizzaOrden();
    	nuevaOrden.setOpcionVeg("Y");
    	boolean actualResult = nuevaOrden.getOpcionVeg();
    	boolean expectResult = true;
    	Assert.assertEquals(actualResult, expectResult);
    }
    
    @Test
    public void verificarOpcionVeganaFalsa() {
    	PizzaOrden nuevaOrden = new PizzaOrden();
    	nuevaOrden.setOpcionVeg("N");
    	boolean actualResult = nuevaOrden.getOpcionVeg();
    	boolean expectResult = false;
    	Assert.assertEquals(actualResult, expectResult);
    }
    
    @Test
    public void verificarPreguntarPizzaVegetarianaVerdadera() {
    	PizzaOrden nuevaOrden = new PizzaOrden();
    	nuevaOrden.setOpcionVeg("Y");
    	boolean actualResult = nuevaOrden.getOpcionVeg();
    	boolean expectResult = true;
    	Assert.assertEquals(actualResult, expectResult);
    }
    
    @Test
    public void verificarPreguntarPizzaVegetarianaFalsa() {
    	PizzaOrden nuevaOrden = new PizzaOrden();
    	nuevaOrden.setOpcionVeg("N");
    	boolean actualResult = nuevaOrden.getOpcionVeg();
    	boolean expectResult = false;
    	Assert.assertEquals(actualResult, expectResult);
    }
    
    @Test
    public void verificarGuardarIngrediente6ComoSalchicha() {
    	PizzaOrden nuevaOrden = new PizzaOrden();
        nuevaOrden.setIngrediente1("f");
        String actualResult = nuevaOrden.getIngrediente1();
        String expectedResult = "Salchicha";
        Assert.assertEquals(actualResult, expectedResult);        
    }
    
    @Test
    public void verificarGuardarIngredienteNoValida(){
    	PizzaOrden nuevaOrden = new PizzaOrden();
        nuevaOrden.setIngrediente1("j");
        String actualResult = nuevaOrden.getIngrediente1();
        String expectedResult = "Opcion_Invalida";
        Assert.assertEquals(actualResult, expectedResult);        
    }
    
    @Test
    public void verificarGuardarIngrediente5ComoJamon() {
    	PizzaOrden nuevaOrden = new PizzaOrden();
        nuevaOrden.setIngrediente1("e");
        String actualResult = nuevaOrden.getIngrediente1();
        String expectedResult = "Jamon";
        Assert.assertEquals(actualResult, expectedResult);        
    }
    
    @Test
    public void verificarGuardarIngrediente4ComoPeperoni() {
    	PizzaOrden nuevaOrden = new PizzaOrden();
        nuevaOrden.setIngrediente1("d");
        String actualResult = nuevaOrden.getIngrediente1();
        String expectedResult = "Peperoni";
        Assert.assertEquals(actualResult, expectedResult);        
    }
    
    @Test
    public void verificarGuardarIngrediente3ComoEspinaca() {
    	PizzaOrden nuevaOrden = new PizzaOrden();
        nuevaOrden.setIngrediente1("c");
        String actualResult = nuevaOrden.getIngrediente1();
        String expectedResult = "Espinaca";
        Assert.assertEquals(actualResult, expectedResult);        
    }
    
    
    

}

/*
 * codigo de bedu
 * 

package proyecto_junit;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestPizzeriaEjercicio1 {

    CommonMethods Common;
    PizzaOrden nuevaOrden;
    String stdOutputPath;

    @BeforeClass
    public void initialConditions() {
        Common = new CommonMethods();
        stdOutputPath = "output_files/output.txt";

    }

    @BeforeTest
    public void preConditions() {
        nuevaOrden = new PizzaOrden();
    }

    @Test
    public void verificarMensajeDeInicioSeDespliega() throws FileNotFoundException {

        Common.redirectStdOutput(stdOutputPath);
        nuevaOrden.desplegarMensajeInicio();

        String actualResult = Common.readFileContents(stdOutputPath);
        String expectedResult = "Bienvenido a la aplicación para ordenar pizza.\n\n"
                                    + "Sigue las instrucciones por favor.\n\n";

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void verificarOpcionVeganaVerdadera() {
        nuevaOrden.setOpcionVeg("Y");
        boolean actualResult = nuevaOrden.getOpcionVeg();
        boolean expectedResult = true;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void verificarOpcopnVeganaFalsa() {
        nuevaOrden.setOpcionVeg("N");
        boolean actualResult = nuevaOrden.getOpcionVeg();
        boolean expectedResult = false;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void verificarGuardarIngrediente1ComoPimiento() {
        nuevaOrden.setIngrediente1("a");
        String actualResult = nuevaOrden.getIngrediente1();
        String expectedResult = "Pimiento";
        Assert.assertEquals(actualResult, expectedResult);        
    }

    @Test
    public void verificarGuardarIngrediente2ComoHongos() {
        nuevaOrden.setIngrediente2("b");
        String actualResult = nuevaOrden.getIngrediente2();
        String expectedResult = "Hongos";
        Assert.assertEquals(actualResult, expectedResult);        
    }

    @Test
    public void verificarGuardarIngrediente3ComoEspinaca() {
        nuevaOrden.setIngrediente3("c");
        String actualResult = nuevaOrden.getIngrediente3();
        String expectedResult = "Espinaca";
        Assert.assertEquals(actualResult, expectedResult);        
    }

    @Test
    public void verificarGuardarIngrediente1ComoPeperoni() {
        nuevaOrden.setIngrediente1("d");
        String actualResult = nuevaOrden.getIngrediente1();
        String expectedResult = "Peperoni";
        Assert.assertEquals(actualResult, expectedResult);        
    }

    @Test
    public void verificarGuardarIngrediente2ComoJamon() {
        nuevaOrden.setIngrediente2("e");
        String actualResult = nuevaOrden.getIngrediente2();
        String expectedResult = "Jamon";
        Assert.assertEquals(actualResult, expectedResult);        
    }

    @Test
    public void verificarGuardarIngrediente3ComoSalchicha() {
        nuevaOrden.setIngrediente3("f");
        String actualResult = nuevaOrden.getIngrediente3();
        String expectedResult = "Salchicha";
        Assert.assertEquals(actualResult, expectedResult);        
    }

    @Test
    public void verificarGuardarIngrediente1ComoOpcionInvalida() {
        nuevaOrden.setIngrediente1("o");
        String actualResult = nuevaOrden.getIngrediente1();
        String expectedResult = "Opcion_Invalida";
        Assert.assertEquals(actualResult, expectedResult);        
    }

    @Test
    public void verificarOpcionVegAlPreguntarOpcionVeganaTrue() {

        String stdInputPath = "input_files/opcion_veg_true.txt";
        Common.redirectStdInput(stdInputPath);
        nuevaOrden.preguntarPizzaVegetariana();
        boolean actualResult = nuevaOrden.getOpcionVeg();
        boolean expectedResult = true;
        Assert.assertEquals(actualResult, expectedResult);

    }

    @Test
    public void verificarOpcionVegAlPreguntarOpcionVeganaFalse() {

        String stdInputPath = "input_files/opcion_veg_false.txt";
        Common.redirectStdInput(stdInputPath);
        nuevaOrden.preguntarPizzaVegetariana();
        boolean actualResult = nuevaOrden.getOpcionVeg();
        boolean expectedResult = false;
        Assert.assertEquals(actualResult, expectedResult);

    }

    @Test
    public void verificarListaIngredientesVegetarianos() throws FileNotFoundException {

        Common.redirectStdOutput(stdOutputPath);
        nuevaOrden.setOpcionVeg("Y");
        nuevaOrden.desplegarIngredientes();

        String actualResult = Common.readFileContents(stdOutputPath);
        String expectedResult = "Selecciona 3 ingredientes de la siguiente  lista: \n"
                                    + "[a] Pimiento \n"
                                    + "[b] Hongos \n"
                                    + "[c] Espinaca \n"
                                    + "[o] Ninguno \n\n";

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void verificarListaIngredientesNoVegetarianos() throws FileNotFoundException {

        Common.redirectStdOutput(stdOutputPath);
        nuevaOrden.setOpcionVeg("N");
        nuevaOrden.desplegarIngredientes();

        String actualResult = Common.readFileContents(stdOutputPath);
        String expectedResult = "Selecciona 3 ingredientes de la siguiente  lista: \n"
                                    + "[a] Pimiento \n"
                                    + "[b] Hongos \n"
                                    + "[c] Espinaca \n"
                                    + "[d] Peperoni \n"
                                    + "[e] Jamon \n"
                                    + "[f] Salchicha \n"                            
                                    + "[o] Ninguno \n\n";

        Assert.assertEquals(actualResult, expectedResult);
    }  

    @Test(enabled = false)
    public void guardarIngredientesComoHongos() {

        String stdInputPath = "input_files/ingrediente_hongos.txt";
        Common.redirectStdInput(stdInputPath);
        nuevaOrden.guardarIngredientes();
        String expectedResult = "Hongos";
        Assert.assertEquals(nuevaOrden.getIngrediente1(), expectedResult);
//        Assert.assertEquals(nuevaOrden.getIngrediente2(), expectedResult);
//        Assert.assertEquals(nuevaOrden.getIngrediente3(), expectedResult);

    }
}




 */



