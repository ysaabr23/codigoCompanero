import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Scanner sn = new Scanner(System.in);
		int opc = 0;
		String ruta = "coches.txt";
		File archivo = new File(ruta);
		ArrayList<Coche> cochesDatos = new ArrayList<Coche>();
		ArrayList<Coche> cochesDatosNoExtras = new ArrayList<Coche>();
		
		if (!archivo.exists()) {
			try {
				archivo.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		String linea = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(ruta));
			try {
				linea = br.readLine();
				while (linea != null) {
					String[] splits = linea.split(";");
					if (splits.length == 5) {
						cochesDatosNoExtras.add(
								new Coche(splits[0], splits[1], splits[2], splits[3], Integer.parseInt(splits[4])));
					} else if (splits.length == 6) {
						cochesDatos.add(new Coche(splits[0], splits[1], splits[2], splits[3],
								Integer.parseInt(splits[4]), splits[5]));
					}
					linea = br.readLine();
				}
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		do {
			menuOpciones();
			opc = sc.nextInt();
			switch (opc) {
			case 1:
				for (Coche coches : cochesDatosNoExtras) {
					coches.mostrarDatos();
				}
				for (Coche coches : cochesDatos) {
					coches.mostrarDatos();
				}
				break;
			case 2:
				for (int i = 0; i < cochesDatos.size(); i++) {
					ruta = cochesDatos.get(i).getMarca() + "Coche.txt";
					archivo = new File(ruta);
					if (!archivo.exists()) {
						try {
							archivo.createNewFile();
							try {
								BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, false));
								for (int j = 0; j < cochesDatos.size(); j++) {
									if (archivo.getName().equalsIgnoreCase(cochesDatos.get(j).getMarca() + "Coche.txt")) {
										linea = cochesDatos.get(j).getMatricula() + ";" + cochesDatos.get(j).getMarca()
												+ ";" + cochesDatos.get(j).getModelo() + ";"
												+ cochesDatos.get(j).getColor() + ";" + cochesDatos.get(j).getPrecio()
												+ ";" + cochesDatos.get(j).getExtra();
										bw.write(linea);
										bw.newLine();
									}
								}
								bw.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				for (int i = 0; i < cochesDatosNoExtras.size(); i++) {
					ruta = cochesDatosNoExtras.get(i).getMarca() + "Coche.txt";
					archivo = new File(ruta);
					if (!archivo.exists()) {
						try {
							archivo.createNewFile();
							try {
								BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, false));
								for (int j = 0; j < cochesDatosNoExtras.size(); j++) {
									if (archivo.getName().equalsIgnoreCase(cochesDatosNoExtras.get(j).getMarca() + "Coche.txt")) {
										linea = cochesDatosNoExtras.get(j).getMatricula() + ";"
												+ cochesDatosNoExtras.get(j).getMarca() + ";"
												+ cochesDatosNoExtras.get(j).getModelo() + ";"
												+ cochesDatosNoExtras.get(j).getColor() + ";"
												+ cochesDatosNoExtras.get(j).getPrecio() + ";"
												+ cochesDatosNoExtras.get(j).getExtra();
										bw.write(linea);
										bw.newLine();
									}
								}
								bw.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				break;
			}
		} while (opc != 3);
	}

	static void menuOpciones() {
		System.out.println("1. Mostrar datos de todos los coches.\r\n" + "2. Generar archivos de marcas.\r\n"
				+ "3. Salir.\r\n" + "Elige una opción: ");
	}

	static void crearArchivoMarcas(ArrayList<Coche> datos) {
		for (int i = 0; i < datos.size(); i++) {
			String ruta = datos.get(i).getMarca() + "Coche.txt";
			File archivo = new File(ruta);
			if (!archivo.exists()) {
				try {
					archivo.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
