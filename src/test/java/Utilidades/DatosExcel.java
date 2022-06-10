package Utilidades;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DatosExcel {
	
	public static Object[][] leerExcel(String ruta,String nombreHoja) throws Exception{
		FileInputStream file = new FileInputStream(new File(ruta));
		
		XSSFWorkbook libroExcel = new XSSFWorkbook(file);
		XSSFSheet Hoja = libroExcel.getSheet(nombreHoja);
		
		System.out.println(nombreHoja);
		
		XSSFRow fila;
		int filas = Hoja.getPhysicalNumberOfRows(); // restarle menos uno si tiene encabezado
		int columnas = Hoja.getRow(0).getPhysicalNumberOfCells();
		
		Object cellValue[][] = new Object [filas][columnas];
		
		for (int r =0; r< filas; r++) { // en este for se indica a partir de que fila
			fila=Hoja.getRow(r);
			if(fila == null) { // CONDICION DE SALIDA
				break;
			}else {
				for (int c = 0 ; c< columnas ; c++) {
					DataFormatter dataFormatter = new DataFormatter();
					cellValue[r][c] = dataFormatter.formatCellValue(Hoja.getRow(r).getCell(c)); // SE OBTIENEN LOS DATOS DEL EXCEL.
				}
			}
		}
		
		
		return cellValue;
		
				
	}

}
