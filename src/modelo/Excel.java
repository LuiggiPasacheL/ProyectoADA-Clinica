/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JTable;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author nick paredes
 */
public class Excel {
    private String nombre;
    private String absolutePath;
    private File file;
    private Date fechaCreacion;
    
    public Excel(String nombre, File file) {
        this.nombre = nombre;
        this.file = file;
        this.absolutePath = this.file.getAbsolutePath() + File.separator + nombre + ".xlsx";
        
        this.fechaCreacion = new Date();
    }

    
    
    public void generar(JTable tablaD) throws FileNotFoundException, IOException{
        Workbook wb;

        int numFila=tablaD.getRowCount(), numColumna=tablaD.getColumnCount();
        wb = new XSSFWorkbook();
        Sheet hoja = wb.createSheet("Nueva hoja");
        
        for (int i = -1; i < numFila; i++) {
            Row fila = (Row) hoja.createRow(i+1);
            for (int j = 0; j < numColumna; j++) {
                Cell celda = fila.createCell(j);
                if(i==-1){
                    celda.setCellValue(String.valueOf(tablaD.getColumnName(j)));
                }else{
                    celda.setCellValue(String.valueOf(tablaD.getValueAt(i, j)));
                }

                
            }
        }
        
        for (int i = 0;  i< hoja.getRow(0).getPhysicalNumberOfCells(); i++)
           hoja.autoSizeColumn(i);
        
        
        wb.write(new FileOutputStream(absolutePath));

    }
    
    public static String[][] cargarExcel(String path){
        ArrayList <ArrayList> filas = new ArrayList<ArrayList>(30);
        Workbook wb;
        try{
            wb = WorkbookFactory.create(new FileInputStream(new File(path)));
            Sheet hoja = wb.getSheetAt(0);
            Iterator filaIterator = hoja.rowIterator();
            int i = -1;
            while(filaIterator.hasNext()){
                ArrayList <Object>  filaAux = new ArrayList<Object>();
                i++;
                Row fila = (Row) filaIterator.next();
                Iterator columnaIterator = fila.cellIterator();
                Object[] listaColumna = new Object[5];
                int j = -1;
                
                while(columnaIterator.hasNext()){
                    
                    j++;
                    
                    Cell celda = (Cell) columnaIterator.next();
                    
                    filaAux.add(celda.getStringCellValue());
                    
                }  
                filas.add(filaAux);
            }
            wb.close();
            
            
            
        }catch (Exception e){
            System.err.println(e);
            e.printStackTrace();
        }
        return matrixLoader(filas);
    }

    
    private static String[][] matrixLoader(ArrayList <ArrayList> filas){
        String [][] matrix = new String[filas.size()][filas.get(0).size()];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                String value = filas.get(i).get(j).toString();

                matrix[i][j] = value;

            }
        }
        
        return matrix;
        
    }


    public String getNombre() {
        return nombre;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public File getFile() {
        return file;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }
    
    
    
    
    
}
