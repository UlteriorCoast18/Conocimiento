package ejercicio_examen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App extends JFrame {
    int frameWidth = 1000;
    int frameHeight = 600;

    public void colocarTabla() {
        System.out.println("Colocar una tabla");
    }

    public void nuevaVentana(App originalFrame) {
        App frame = new App();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frame.frameWidth, frame.frameHeight);
        frame.setTitle("Ingrese Datos Alumno");
        frame.setLocation((screenWidth - frame.frameWidth) / 2, (screenHeight - frame.frameHeight) / 2);

        JLabel nombreAlumno = new JLabel("Nombre del Alumno:");
        nombreAlumno.setBounds(20, 20, 200, 30);
        frame.add(nombreAlumno);

        JTextField datoNombreAlumno = new JTextField();
        datoNombreAlumno.setBounds(250, 20, 700, 30);
        frame.add(datoNombreAlumno);

        JLabel apellidoAlumno = new JLabel("Apellido Paterno del Alumno:");
        apellidoAlumno.setBounds(20, 60, 200, 30);
        frame.add(apellidoAlumno);

        JTextField datoApellidoPaterno = new JTextField("");
        datoApellidoPaterno.setBounds(250, 60, 700, 30);
        frame.add(datoApellidoPaterno);

        JLabel apellidoAlumno2 = new JLabel("Apellido Materno del Alumno:");
        apellidoAlumno2.setBounds(20, 100, 200, 30);
        frame.add(apellidoAlumno2);

        JTextField datoApellidoMaterno = new JTextField("");
        datoApellidoMaterno.setBounds(250, 100, 700, 30);
        frame.add(datoApellidoMaterno);

        JLabel boletaAlumno = new JLabel("Boleta del Alumno:");
        boletaAlumno.setBounds(20, 140, 200, 30);
        frame.add(boletaAlumno);

        JTextField datoBoletaAlumno = new JTextField("");
        datoBoletaAlumno.setBounds(250, 140, 700, 30);
        frame.add(datoBoletaAlumno);

        JLabel grupoAnteriorAlumno = new JLabel("Grupo Anterior del Alumno:");
        grupoAnteriorAlumno.setBounds(20, 180, 200, 30);
        frame.add(grupoAnteriorAlumno);

        JTextField datoGrupoAlumno = new JTextField("");
        datoGrupoAlumno.setBounds(250, 180, 700, 30);
        frame.add(datoGrupoAlumno);

        JLabel calificacionesAlumno = new JLabel("Primera Calificación del Alumno:");
        calificacionesAlumno.setBounds(20, 220, 200, 30);
        frame.add(calificacionesAlumno);
        JLabel calificacionesAlumno2 = new JLabel("segunda Calificación del Alumno:");
        calificacionesAlumno2.setBounds(20, 260, 200, 30);
        frame.add(calificacionesAlumno2);
        JLabel calificacionesAlumno3 = new JLabel("tercera Calificación del Alumno:");
        calificacionesAlumno3.setBounds(20, 300, 200, 30);
        frame.add(calificacionesAlumno3);
        JLabel calificacionesAlumno4 = new JLabel("cuarta Calificación del Alumno:");
        calificacionesAlumno4.setBounds(20, 340, 200, 30);
        frame.add(calificacionesAlumno4);
        JLabel calificacionesAlumno5 = new JLabel("quinta Calificación del Alumno:");
        calificacionesAlumno5.setBounds(20, 380, 200, 30);
        frame.add(calificacionesAlumno5);

        JComboBox<String> datosCalificaciones1Box = new JComboBox<>();
        datosCalificaciones1Box.setBounds(250, 220, 700, 30);
        frame.add(datosCalificaciones1Box);
        JComboBox<String> datosCalificaciones2Box = new JComboBox<>();
        datosCalificaciones2Box.setBounds(250, 260, 700, 30);
        frame.add(datosCalificaciones2Box);
        JComboBox<String> datosCalificaciones3Box = new JComboBox<>();
        datosCalificaciones3Box.setBounds(250, 300, 700, 30);
        frame.add(datosCalificaciones3Box);
         JComboBox<String> datosCalificaciones4Box = new JComboBox<>();
        datosCalificaciones4Box.setBounds(250, 340, 700, 30);
        frame.add(datosCalificaciones4Box);
         JComboBox<String> datosCalificaciones5Box = new JComboBox<>();
        datosCalificaciones5Box.setBounds(250, 380, 700, 30);
        frame.add(datosCalificaciones5Box);

        for (int i = 0; i <= 10; i++) {
            datosCalificaciones1Box.addItem(String.valueOf(i));
            datosCalificaciones2Box.addItem(String.valueOf(i));
            datosCalificaciones3Box.addItem(String.valueOf(i));
            datosCalificaciones4Box.addItem(String.valueOf(i));
            datosCalificaciones5Box.addItem(String.valueOf(i));
        }

        /* Botón */

        JButton botonregistrarAlumno = new JButton("Registrar");
        botonregistrarAlumno.setSize(300, 40);
        botonregistrarAlumno.setLocation((frame.frameWidth-300)/2,450);
        botonregistrarAlumno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //obtener los datos y colocarlos enel archivo datos.txt
                float promedioAlumno = (Float.parseFloat((String) datosCalificaciones1Box.getSelectedItem()) + Float.parseFloat((String) datosCalificaciones2Box.getSelectedItem()) + Float.parseFloat((String) datosCalificaciones3Box.getSelectedItem()) + Float.parseFloat((String) datosCalificaciones4Box.getSelectedItem()) + Float.parseFloat((String) datosCalificaciones5Box.getSelectedItem())) / 5.00f;
                String grupoAsignar = "";
                
                if(promedioAlumno < 6.00f) grupoAsignar = "Recursadores";
                else if(6.00f <= promedioAlumno && promedioAlumno < 8.00f) grupoAsignar = "6IM1";
                else if(8.00f <= promedioAlumno && promedioAlumno < 9.50f) grupoAsignar = "6IM2";
                else if(9.50f <= promedioAlumno) grupoAsignar = "6IM3";
                System.out.println(promedioAlumno);
                
                try {
                    FileWriter myWriter = new FileWriter("datos.txt", true);
                    myWriter.write(datoNombreAlumno.getText() + "," + datoApellidoPaterno.getText() + ',' +datoApellidoMaterno.getText() + ',' + datoBoletaAlumno.getText() + ',' + datoGrupoAlumno.getText() + ',' + promedioAlumno + ',' + grupoAsignar + '\n');
                    myWriter.close();
                } catch (Exception exce) {
                    System.out.println("Ocurrio error.");
                    exce.printStackTrace();
                }
                frame.setVisible(false);
                originalFrame.setVisible(true);
                colocarDatosTablayBarra(originalFrame);
            }  
        });
        frame.add(botonregistrarAlumno);

        JButton botonRegresar = new JButton("Regresar");
        botonRegresar.setSize(150, 40);
        botonRegresar.setLocation(20,450);
        botonRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                originalFrame.setVisible(true);
            }  
        });
        frame.add(botonRegresar);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        App frame = new App();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frame.frameWidth, frame.frameHeight);
        frame.setTitle("Examen David 2025");
        frame.setLocation((screenWidth - frame.frameWidth) / 2, (screenHeight - frame.frameHeight) / 2);

        // Tabla
        colocarDatosTablayBarra(frame);

        // Botón
        JButton botonAnadirAlumno = new JButton("Añadir Nuevo Alumno");
        botonAnadirAlumno.setSize(300, 40);
        botonAnadirAlumno.setLocation((frame.frameWidth - 300) / 2, 20);
        botonAnadirAlumno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.nuevaVentana(frame);
            }
        });
        frame.add(botonAnadirAlumno);

        frame.setVisible(true);
        frame.colocarTabla();
    }

    private static void colocarDatosTablayBarra(App frame) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Apellido Paterno");
        model.addColumn("Apellido Materno");
        model.addColumn("Boleta");
        model.addColumn("Grupo Anterior");
        model.addColumn("Promedio");
        model.addColumn("Grupo Asignado");
        JTable tabla = new JTable(model);
        
        try {
            File myObj = new File("datos.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    String[] lineas = data.split("\n");
                    for(int i = 0; i < lineas.length; i++){
                        model.addRow(lineas[i].split(","));
                    }
                }
                myReader.close();
            }
        } catch (Exception e) {
            System.out.println("Error en el código");
            e.printStackTrace();
        }
        
        JScrollPane barraDesplazamiento = new JScrollPane(tabla);
        barraDesplazamiento.setBounds(100,100,800,400); // Posición y tamaño
        frame.add(barraDesplazamiento);
    }
}