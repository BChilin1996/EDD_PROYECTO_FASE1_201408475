package main;

import java.util.Properties;
import java.util.Scanner;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import models.Clientes;
import models.ClientesVentanilla;
import models.Impresoras;
import nodos.NodoPilaImagenes;

import org.json.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class main {

	public static void main(String[] args) {
		ColaClientes colaCliente = new ColaClientes();
		ColaClientes colaClienteHistorico = new ColaClientes();
		ListaSimpleVentanillas listaVentanilla = new ListaSimpleVentanillas();
		ListaSimpleClientesAtendidos listaClienteAtendidos = new ListaSimpleClientesAtendidos();
		ColaClientesVentanilla clientesVentanilla = new ColaClientesVentanilla();
		int VentanillasOcupadas = 0;
		int VentanillasIniciales = 0;
		int total_pasos_ejecutados = 0;
		int ClientesAgregados = 0;
		boolean ventanilla_llenas = false;

		// Se crean las impresoras disponibles
		ColaImpresoras cImpresorasColor = new ColaImpresoras();
		Impresoras impresora_color = new Impresoras(1, "Impresora a Color");
		cImpresorasColor.insertar(impresora_color);

		ColaImpresoras cImpresorasBlancoNegro = new ColaImpresoras();
		Impresoras impresora_blanco_negro = new Impresoras(1, "Impresora Blanco y Negro");
		cImpresorasBlancoNegro.insertar(impresora_blanco_negro);

		// PilaImagenes pila = new PilaImagenes();
		// pila.apilar(4);
		// pila.apilar(16);
		// System.out.println("\n<<-- Retirar el elemento del tope de la pila -->>");
		// pila.retirar();
		// pila.listar();
		// System.out.println("Tamaño: " + pila.getTamanio());
		Scanner sc = new Scanner(System.in);

		int cantidad_ventanillas = 0;
		int elemento = 0;
		int opcion_menu = 0;
		int contador_pasos = 0;
		String json_clientes = "";
		String graficos_ = "";

		while (opcion_menu != 6) {
			// TODO Auto-generated method stub
			System.out.println("Elija una de las siguientes opciones...");
			System.out.println("1. Parametros Iniciales");
			System.out.println("2. Ejecutar Paso (Menú Simulación)");
			System.out.println("3. Estado en Memoria de las Estructuras");
			System.out.println("4. Reportes");
			System.out.println("5. Acerca de");
			System.out.println("6. Salir");
			System.out.print("Ingrese una Opción: ");
			opcion_menu = sc.nextInt();
			switch (opcion_menu) {
			case 1:
				System.out.println("######### Carga de Parametros Iniciales #########");
				System.out.println("Elija una de las siguientes opciones...");
				System.out.println("1. Carga Masiva de Clientes");
				System.out.println("2. Cantidad de Ventanillas");
				System.out.println("3. Regresar");
				System.out.print("Ingrese una Opción: ");
				int opcion_menu_submenu = sc.nextInt();
				switch (opcion_menu_submenu) {
				case 1:
					System.out.println("######### Carga Masiva Clientes #########");
					System.out.print("Ingrese la Ruta del Archivo de Clientes a Cargar...: ");
					json_clientes = sc.next();
					// parsing file "JSONExample.json"
					String fichero = "";
					File fil = new File(json_clientes);
					Object ob;

					try {
						ob = new JSONParser().parse(new FileReader(fil));
						JSONObject obj = (JSONObject) ob;
						ClientesAgregados = obj.size();
						for (int i = 1; i <= obj.size(); i++) {
							JSONObject arr = (JSONObject) obj.get("Cliente" + i);
							String id_cliente_ = (String) arr.get("id_cliente");
							String nombre_cliente_ = (String) arr.get("nombre_cliente");
							String img_color_ = (String) arr.get("img_color");
							String img_bw_ = (String) arr.get("img_bw");
							Clientes cliente = new Clientes(Integer.parseInt(id_cliente_), nombre_cliente_,
									Integer.parseInt(img_color_), Integer.parseInt(img_bw_),
									Integer.parseInt(img_color_), Integer.parseInt(img_bw_));
							colaCliente.insertar(cliente);
							colaClienteHistorico.insertar(cliente);
						}

					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (org.json.simple.parser.ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					// System.out.println("Clientes Actuales: " + colaCliente.toString());
					break;
				case 2:
					System.out.println("######### Carga de Cantidad de Ventanillas #########");
					System.out.print("Ingrese la Cantidad de Ventanillas Disponibles... ");
					cantidad_ventanillas = sc.nextInt();
					for (int i = 1; i <= cantidad_ventanillas; i++) {
						listaVentanilla.insertarPrimero(i);
					}
					VentanillasIniciales = cantidad_ventanillas;
					// listaVentanilla.listar();
				default:
					System.out.print("Ingrese una Opción Válida: ");
				}
				break;
			case 2:
				System.out.println("######### Simulación Ejecutada #########");
				System.out.println("-------- Menú de Simulación --------");
				// Se valida si hay clientes en la cola y si hay ventanillas libres, si hay
				// ventanillas libres el primero en la lista se
				// asignará a la cola

				// Se validan si hay trabajos de impresion

				if (VentanillasOcupadas >= 1 && total_pasos_ejecutados > 1) {
					String string_finalizar_impresion = "";
					string_finalizar_impresion = clientesVentanilla.validar_impresiones_pendientes();
				}

				if (VentanillasOcupadas >= 1 && total_pasos_ejecutados > 1) {
					String impresion_cola = "";
					impresion_cola = clientesVentanilla.ImprimirCola();
				}

				if (VentanillasOcupadas >= 1 && total_pasos_ejecutados > 1) {
					String ventanillas_libres = "";
					ventanillas_libres = clientesVentanilla.EnviarTrabajoImpresion();
					if (ventanillas_libres.length() > 0) {
						System.out.println("######### Quedan Libres las Ventanillas  ######### " + ventanillas_libres);
						String[] parts = ventanillas_libres.split(",");
						for (int i = 0; i < parts.length; i++) {
							listaVentanilla.insertarPrimero(Integer.parseInt(parts[i]));
							VentanillasOcupadas = VentanillasOcupadas - 1;
						}

					}
				}

				if (VentanillasIniciales > VentanillasOcupadas) {
					VentanillasOcupadas = VentanillasOcupadas + 1;
					int id_primer_cliente_cola = colaCliente.obtenerPrimero().getIDCliente();
					int id_primer_ventanilla = listaVentanilla.obtenerPrimerVentanilla();
					ClientesVentanilla cola_cliente = new ClientesVentanilla(id_primer_cliente_cola,
							id_primer_ventanilla, colaCliente.obtenerPrimero().getNombreCliente(),
							colaCliente.obtenerPrimero().getImgColor(), colaCliente.obtenerPrimero().getImgBw(),
							colaCliente.obtenerPrimero().getImgColor(), colaCliente.obtenerPrimero().getImgBw());
					PilaImagenes pila = new PilaImagenes();
					clientesVentanilla.insertar(cola_cliente, pila);
					colaCliente.extraer();
					System.out.println("---- Cliente --- " + cola_cliente.getIDCliente() + " Se movió a la ventanilla "
							+ id_primer_ventanilla);
					// Se genera un cliente aleatorio
					ClientesAgregados = ClientesAgregados + 1;
					int id_cliente_aleatorio = (int) (ClientesAgregados);
					int img_color = (int) (Math.random() * 20 + 1);
					int img_blanco_negro = (int) (Math.random() * 20 + 1);
					Clientes cliente = new Clientes(id_cliente_aleatorio, "Cliente Aleatorio # " + id_cliente_aleatorio,
							img_color, img_blanco_negro, img_color, img_blanco_negro);
					colaCliente.insertar(cliente);
					listaVentanilla.borrar(id_primer_ventanilla);
					total_pasos_ejecutados = total_pasos_ejecutados + 1;
				} else {
					System.out.println("######### No existen Ventanillas Libres por el Momento:  ######### ");
					ventanilla_llenas = true;
				}

				if (VentanillasOcupadas >= 1 && total_pasos_ejecutados > 1) {
					clientesVentanilla.AgregarImagenNodo(ventanilla_llenas);
				}

				break;
			case 3:
				System.out.println("######### Ingrese la estructura de la que desea conocer el estado #########");
				System.out.println("######### 1. Cola de Clientes #########");
				System.out.println("######### 2. Pila de Ventanillas Libres #########");
				System.out.println("######### 3. Cola de Clientes en Ventanilla #########");
				System.out.println("######### 4. Cola de Impresión #########");
				System.out.println("######### 5. Imprimir Lista de Espera #########");
				System.out.print("Ingrese una Opción: ");
				int opcion_menu_estado_actual = sc.nextInt();
				switch (opcion_menu_estado_actual) {

				case 1:
					String imprimir_estado_cola = "";
					imprimir_estado_cola = imprimir_estado_cola + colaCliente.toString();
					imprimir_estado_cola = imprimir_estado_cola + colaCliente.apuntes_cola();
					graficos_ = imprimir_estado_cola(imprimir_estado_cola);
					break;
				case 2:
					String esta_actual_ventanilla = "";
					esta_actual_ventanilla = listaVentanilla.toString();
					esta_actual_ventanilla = esta_actual_ventanilla + listaVentanilla.apuntes_ventanilla();
					graficos_ = imprimir_ventanillas_libres(esta_actual_ventanilla);
					break;
				case 3:
					graficos_ = imprimir_ventanillas_estado(clientesVentanilla.nodos_grafo());

				case 4:
					graficos_ = imprimir_ventanillas_cola(clientesVentanilla.imprimir_cola_impresion());
					break;
				case 5:
					graficos_ = imprimir_ventanillas_lista_espera(clientesVentanilla.imprimir_lista_espera());
					break;
				default:
					break;
				}
			case 4:
				System.out.println("######### Ingrese el reporte que desea generar #########");
				System.out.println("######### 1. Top 5 Clientes con Mayor Cantidad de Imágenes a Color #########");
				System.out.println("######### 2. Top 5 Clientes con Mayor Cantidad de Imágenes en Blanco y Negro #########");
				System.out.println("######### 3. Clientes que mas pasos estuvo en el Sistema #########");
				System.out.println("######### 4. Buscar Cliente #########");
				System.out.print("Ingrese una Opción: ");
				int opcion_menu_estado_actual_reportes = sc.nextInt();
				switch (opcion_menu_estado_actual_reportes) {

				case 1:
					colaClienteHistorico.ordenar_clientes_color();
					break;

				case 2:
					colaClienteHistorico.ordenar_clientes_blanco_negro();
					break;
				default:
					System.out.println("######### Ingrese otra Opción #########");
				}
				break;
			default:
				System.out.println("######### Ingrese otra Opción #########");
			}
		}
	}

	public static String imprimir_estado_cola(String string) {
		try {
			PrintWriter writer = new PrintWriter("C:\\Temp\\grafo1.txt", "UTF-8");

			writer.println("digraph G {" + "graph [\r\n" + "rankdir = \"LR\"\r\n" + "];\r\n" + "node [\r\n"
					+ "fontsize = \"16\"\r\n" + "shape = \"ellipse\"\r\n" + "];\r\n" + "edge [\r\n" + "];");
			writer.println(string);
			writer.println("}");

			writer.close();
			try {

				String dotPath = "C:\\Program Files\\Graphviz\\bin\\dot.exe";

				String fileInputPath = "C:\\Temp\\grafo1.txt";
				String fileOutputPath = "C:\\Temp\\grafo1.jpg";

				String tParam = "-Tjpg";
				String tOParam = "-o";

				String[] cmd = new String[5];
				cmd[0] = dotPath;
				cmd[1] = tParam;
				cmd[2] = fileInputPath;
				cmd[3] = tOParam;
				cmd[4] = fileOutputPath;

				Runtime rt = Runtime.getRuntime();

				rt.exec(cmd);

			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			File file = new File("C:\\\\Temp\\\\grafo1.jpg");
			if (!Desktop.isDesktopSupported()) {
				System.out.println("not supported");
				return "Error";
			}
			Desktop desktop = Desktop.getDesktop();
			if (file.exists())
				desktop.open(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Se Imprimio el reportes";
	}

	public static String imprimir_ventanillas_libres(String string_ventanilla) {
		try {
			PrintWriter writer = new PrintWriter("C:\\Temp\\grafo.txt", "UTF-8");

			writer.println("digraph G {" + "graph [\r\n" + "rankdir = \"LR\"\r\n" + "];\r\n" + "node [\r\n"
					+ "fontsize = \"16\"\r\n" + "shape = \"ellipse\"\r\n" + "];\r\n" + "edge [\r\n" + "];");
			writer.println(string_ventanilla);
			writer.println("}");

			writer.close();
			try {

				String dotPath = "C:\\Program Files\\Graphviz\\bin\\dot.exe";

				String fileInputPath = "C:\\Temp\\grafo.txt";
				String fileOutputPath = "C:\\Temp\\grafo.jpg";

				String tParam = "-Tjpg";
				String tOParam = "-o";

				String[] cmd = new String[5];
				cmd[0] = dotPath;
				cmd[1] = tParam;
				cmd[2] = fileInputPath;
				cmd[3] = tOParam;
				cmd[4] = fileOutputPath;

				Runtime rt = Runtime.getRuntime();

				rt.exec(cmd);

			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			File file = new File("C:\\\\Temp\\\\grafo.jpg");
			if (!Desktop.isDesktopSupported()) {
				System.out.println("not supported");
				return "Error";
			}
			Desktop desktop = Desktop.getDesktop();
			if (file.exists())
				desktop.open(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Se Imprimió el Reporte";

	}

	public static String imprimir_ventanillas_cola(String string_ventanilla) {
		try {
			PrintWriter writer = new PrintWriter("C:\\Temp\\grafo.txt", "UTF-8");

			writer.println("digraph G {" + "graph [\r\n" + "rankdir = \"LR\"\r\n" + "];\r\n" + "node [\r\n"
					+ "fontsize = \"16\"\r\n" + "shape = \"ellipse\"\r\n" + "];\r\n" + "edge [\r\n" + "];");
			writer.println(string_ventanilla);
			writer.println("}");

			writer.close();
			try {

				String dotPath = "C:\\Program Files\\Graphviz\\bin\\dot.exe";

				String fileInputPath = "C:\\Temp\\grafo.txt";
				String fileOutputPath = "C:\\Temp\\grafo.jpg";

				String tParam = "-Tjpg";
				String tOParam = "-o";

				String[] cmd = new String[5];
				cmd[0] = dotPath;
				cmd[1] = tParam;
				cmd[2] = fileInputPath;
				cmd[3] = tOParam;
				cmd[4] = fileOutputPath;

				Runtime rt = Runtime.getRuntime();

				rt.exec(cmd);

			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			File file = new File("C:\\\\Temp\\\\grafo.jpg");
			if (!Desktop.isDesktopSupported()) {
				System.out.println("not supported");
				return "Error";
			}
			Desktop desktop = Desktop.getDesktop();
			if (file.exists())
				desktop.open(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Se Imprimió el reportes";

	}

	public static String imprimir_ventanillas_estado(String string_ventanilla) {
		try {
			PrintWriter writer = new PrintWriter("C:\\Temp\\grafo3.txt", "UTF-8");

			writer.println("digraph G {" + "graph [\r\n" + "rankdir = \"LR\"\r\n" + "];\r\n" + "node [\r\n"
					+ "fontsize = \"16\"\r\n" + "shape = \"ellipse\"\r\n" + "];\r\n" + "edge [\r\n" + "];");
			writer.println(string_ventanilla);
			writer.println("}");

			writer.close();
			try {

				String dotPath = "C:\\Program Files\\Graphviz\\bin\\dot.exe";

				String fileInputPath = "C:\\Temp\\grafo3.txt";
				String fileOutputPath = "C:\\Temp\\grafo3.jpg";

				String tParam = "-Tjpg";
				String tOParam = "-o";

				String[] cmd = new String[5];
				cmd[0] = dotPath;
				cmd[1] = tParam;
				cmd[2] = fileInputPath;
				cmd[3] = tOParam;
				cmd[4] = fileOutputPath;

				Runtime rt = Runtime.getRuntime();

				rt.exec(cmd);

			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			File file = new File("C:\\\\Temp\\\\grafo3.jpg");
			if (!Desktop.isDesktopSupported()) {
				System.out.println("not supported");
				return "Error";
			}
			Desktop desktop = Desktop.getDesktop();
			if (file.exists())
				desktop.open(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Se Imprimió el reportes";

	}

	public static String imprimir_ventanillas_lista_espera(String string_ventanilla) {
		try {
			PrintWriter writer = new PrintWriter("C:\\Temp\\grafo4.txt", "UTF-8");

			writer.println("digraph G {" + "graph [\r\n" + "rankdir = \"LR\"\r\n" + "];\r\n" + "node [\r\n"
					+ "fontsize = \"16\"\r\n" + "shape = \"ellipse\"\r\n" + "];\r\n" + "edge [\r\n" + "];");
			writer.println(string_ventanilla);
			writer.println("}");

			writer.close();
			try {

				String dotPath = "C:\\Program Files\\Graphviz\\bin\\dot.exe";

				String fileInputPath = "C:\\Temp\\grafo4.txt";
				String fileOutputPath = "C:\\Temp\\grafo4.jpg";

				String tParam = "-Tjpg";
				String tOParam = "-o";

				String[] cmd = new String[5];
				cmd[0] = dotPath;
				cmd[1] = tParam;
				cmd[2] = fileInputPath;
				cmd[3] = tOParam;
				cmd[4] = fileOutputPath;

				Runtime rt = Runtime.getRuntime();

				rt.exec(cmd);

			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			File file = new File("C:\\\\Temp\\\\grafo4.jpg");
			if (!Desktop.isDesktopSupported()) {
				System.out.println("not supported");
				return "Error";
			}
			Desktop desktop = Desktop.getDesktop();
			if (file.exists())
				desktop.open(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Se Imprimió el reportes";

	}

}
