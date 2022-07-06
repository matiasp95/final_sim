/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

//TODO Agregar validaciones para parametros normal y exponencial
//TODO Ultimo punto con los 15 intervalos
import java.awt.Color;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.*;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Usuario
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    private DefaultTableModel tabla = new DefaultTableModel();
    //A
    int N = 0; // Variable para cantidad de eventos
    int desde = 0; // Desde que evento mostrar
    int hasta = 0; // Hasta que evento mostrar
    double lambdaLl = 0; // Lambda para llegadas
    double lambdaE1 = 0; // Lambda para Etapa 1
    double lambdaE2 = 0; // Lambda para Etapa 2
    double lambdaE3 = 0; // Lambda para Inspeccion
    int cantTareas = 50; // Cantidad de tareas a mostrar al final de la tabla (Tambien afecta el calculo de tiempo promedio en sistema)

    private Fila2 aux1; //Fila de trabajo

    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    DecimalFormat df = new DecimalFormat("#.####");
    DecimalFormat df2 = new DecimalFormat("#.##");

    private JFrame pantallaActual;

    // Seteo de vectores filas y columnas
    private Object[] filaAImprimir = new Object[44];
    private Object[] columna = {"Nro Sim", "Reloj", "Evento", "Rnd Llegada", "T Entre Llegadas", "Prox Llegada",
        "Estado T1", "rnd T1", "T Atencion T1", "Prox fin atencion T1", "Cola E1",
        "Estado T2", "rnd T2", "T Atencion T2", "Prox fin atencion T2",
        "Estado T3", "rnd T3", "T Atencion T3", "Prox fin atencion T3", "Cola E2",
        "Estado T4", "rnd T4", "T Atencion T4", "Prox fin atencion T4",
        "Estado T5", "rnd T5", "T Atencion T5", "Prox fin atencion T5",
        "Estado T6", "rnd T6", "T Atencion T6", "Prox fin atencion T6", "Cola E3",
        "rnd Vuelve a E1", "Vuelve a E1?", "rnd Vuelve E2", "Vuelve a E2?",
        "Tareas Terminadas", "T Ocup T1", "T Ocup T2", "T Ocup T3", "T Ocup T4", "T Ocup T5", "T Ocup T6"};

    int origLength = columna.length; //Guardo length de la columna para luego hacer un copy del array y sumarle las tareas

    public Principal(IActividad auxA1, IActividad auxA2, IActividad auxA3, IActividad auxA4, IActividad auxA5, Fila2 aux1, JFrame pantallaActual, double masBajo, JButton BtnSimular, JTable Tabla, JButton btnEvaluar, ButtonGroup buttonGroup1, ButtonGroup buttonGroup2, ButtonGroup buttonGroup3, ButtonGroup buttonGroup4, ButtonGroup buttonGroup5, ButtonGroup buttonGroup6, JLabel jLabel1, JLabel jLabel10, JLabel jLabel11, JLabel jLabel12, JLabel jLabel13, JLabel jLabel14, JLabel jLabel15, JLabel jLabel16, JLabel jLabel17, JLabel jLabel18, JLabel jLabel19, JLabel jLabel2, JLabel jLabel20, JLabel jLabel21, JLabel jLabel22, JLabel jLabel23, JLabel jLabel24, JLabel jLabel25, JLabel jLabel26, JLabel jLabel27, JLabel jLabel28, JLabel jLabel29, JLabel jLabel3, JLabel jLabel30, JLabel jLabel31, JLabel jLabel32, JLabel jLabel33, JLabel jLabel34, JLabel jLabel35, JLabel jLabel4, JLabel jLabel5, JLabel jLabel6, JLabel jLabel7, JLabel jLabel8, JLabel jLabel9, JScrollPane jScrollPane1, JTextField lambdaLlegadas, JLabel lblIntegrantes, JRadioButton radioButtonExpA1, JRadioButton radioButtonExpA2, JRadioButton radioButtonExpA3, JRadioButton radioButtonExpA4, JRadioButton radioButtonExpA5, JRadioButton radioButtonNormalA1, JRadioButton radioButtonNormalA2, JRadioButton radioButtonNormalA3, JRadioButton radioButtonNormalA4, JRadioButton radioButtonNormalA5, JRadioButton radioButtonUniformeA1, JRadioButton radioButtonUniformeA2, JRadioButton radioButtonUniformeA3, JRadioButton radioButtonUniformeA4, JRadioButton radioButtonUniformeA5, JTextField textLambdaA1, JTextField textLambdaA2, JTextField textLambdaA3, JTextField textLambdaA4, JTextField textLambdaA5, JTextField textMuA1, JTextField textMuA2, JTextField textMuA3, JTextField textMuA4, JTextField textMuA5, JTextField textSigmaA1, JTextField textSigmaA2, JTextField textSigmaA3, JTextField textSigmaA4, JTextField textSigmaA5, JTextField textaA1, JTextField textaA2, JTextField textaA3, JTextField textaA4, JTextField textaA5, JTextField textbA1, JTextField textbA2, JTextField textbA3, JTextField textbA4, JTextField textbA5, JTextField txtCantidadFilas, JTextField txtDesde, JTextField txtHasta) throws HeadlessException {
        this.aux1 = aux1;
        this.pantallaActual = pantallaActual;
        this.masBajo = masBajo;
        this.BtnSimular = BtnSimular;
        this.Tabla = Tabla;

        this.buttonGroup1 = buttonGroup1;
        this.buttonGroup2 = buttonGroup2;
        this.buttonGroup3 = buttonGroup3;
        this.buttonGroup4 = buttonGroup4;
        this.buttonGroup5 = buttonGroup5;
        this.buttonGroup6 = buttonGroup6;

        this.jScrollPane1 = jScrollPane1;
        this.lambdaLlegadas = lambdaLlegadas;

        this.txtCantidadFilas = txtCantidadFilas;
        this.txtDesde = txtDesde;
        this.txtHasta = txtHasta;
    }

    /**
     * Retorna '-' en caso de que el tiempo que llega por parametro supere el
     * valor 999999.0 En caso de que no lo supere, convierte el valor a reloj en
     * formato hh:mm:ss
     *
     * @param a tiempo que deseamos llenar en tabla
     * @return tiempo en formato hh:mm:ss
     */
    private String llenarTiempo(double a) {
        if (a >= 999999.0) {
            return "-";
        }
        return convertirAReloj(a);

    }

    /**
     * Convierte aquellos random que lleguen por parametro a formato #.#### En
     * caso de que sea = 0 o >= 999999.0, devuelve un '-'
     *
     * @param a random que deseamos convertir
     * @return el random convertido
     */
    private String handleRnd(double a) {
        if (a >= 999999.0 || a == 0) {
            return "-";
        }
        return df.format(a);
    }

    /**
     * Convierte valores double a reloj. Primero toma la parte entera
     * convirtiendo el double a int. Luego, divide este int en 60 para calcular
     * las horas. Despues calcula los minutos haciendo el modulo de la parte
     * entera con 60 Luego calcula el resto para obtener los segundos, restando
     * la parte entera de a, y multiplicando este resto por 60. Por ejemplo: Si
     * mi double es 75.4343 parte entera --> 75 horas --> 75 / 60 = 1.25 -->
     * (int) 1.25 = 1 min --> 75 % 60 = 15 seg --> 75.4343-75 = 0.4343 -->
     * 0.4343*60 = 26.058 --> (int) 26.058 = 26 Resultado: 01:15:26
     *
     * Este valor es simplemente a modo de vista en la tabla, por detras no se
     * estan perdiendo decimales (Ya que la fila trabaja con double)
     *
     * @param a tiempo que deseamos convertir
     * @return tiempo en formato hh:mm:ss
     */
    private String convertirAReloj(double a) {
        if (a == 0.0) {
            return "-";
        }
        int parteEntera = (int) a;
        int horas = (int) a / 60;
        int min = parteEntera % 60;
        double resto = a - parteEntera;
        int seg = (int) (resto * 60);

        String horasForm = String.format("%02d", horas);
        String minForm = String.format("%02d", min);
        String segForm = String.format("%02d", seg);
        return horasForm + ":" + minForm + ":" + segForm;
    }

    /**
     * Llena en tabla la fila en base al estado actual de aux (Fila)
     *
     * @param aux Fila que vamos a mostrar en tabla
     */
    private void llenarFila(Fila2 aux) {
        filaAImprimir[0] = (int) aux.getContadorN(); //Nro Sim
        filaAImprimir[1] = convertirAReloj(aux.getReloj()); //Reloj
        filaAImprimir[2] = aux.getE().toString(); //Evento
        filaAImprimir[3] = handleRnd(aux.getRndTarea()); //Rnd llegada
        filaAImprimir[4] = llenarTiempo(aux.getTiempoEntreLlegadas()); //T entre llegadas
        filaAImprimir[5] = llenarTiempo(aux.getProxLlegada()); //Prox llegada
        filaAImprimir[6] = aux.getEstadoT1().toString();//"Estado T1"
        filaAImprimir[7] = handleRnd(aux.getRndTrabajador1());//"rnd T1"
        filaAImprimir[8] = llenarTiempo(aux.getTiempoDeAtencionTrabajador1());//"T Atencion T1"
        filaAImprimir[9] = llenarTiempo(aux.getProxFinAtencionTrabajador1());//"Prox fin atencion" 
        filaAImprimir[10] = aux.getColaE1();//"Cola E1"
        filaAImprimir[11] = aux.getEstadoT2().toString(); //"Estado T2", "rnd T2", "T Atencion T2", "Prox fin atencion"
        filaAImprimir[12] = handleRnd(aux.getRndTrabajador2());//
        filaAImprimir[13] = llenarTiempo(aux.getTiempoDeAtencionTrabajador2());
        filaAImprimir[14] = llenarTiempo(aux.getProxFinAtencionTrabajador2());
        filaAImprimir[15] = aux.getEstadoT3().toString(); //"Estado T3", "rnd T3", "T Atencion T3", "Prox fin atencion", "Cola E2" ,
        filaAImprimir[16] = handleRnd(aux.getRndTrabajador3());
        filaAImprimir[17] = llenarTiempo(aux.getTiempoDeAtencionTrabajador3());
        filaAImprimir[18] = llenarTiempo(aux.getProxFinAtencionTrabajador3());
        filaAImprimir[19] = aux.getColaE2();
        filaAImprimir[20] = aux.getEstadoT4().toString(); // "Estado T4", "rnd T4", "T Atencion T4", "Prox fin atencion", 
        filaAImprimir[21] = handleRnd(aux.getRndTrabajador4());
        filaAImprimir[22] = llenarTiempo(aux.getTiempoDeAtencionTrabajador4());
        filaAImprimir[23] = llenarTiempo(aux.getProxFinAtencionTrabajador4());
        filaAImprimir[24] = aux.getEstadoT5(); //"Estado T5", "rnd T5", "T Atencion T5", "Prox fin atencion", 
        filaAImprimir[25] = handleRnd(aux.getRndTrabajador5());
        filaAImprimir[26] = llenarTiempo(aux.getTiempoDeAtencionTrabajador5());
        filaAImprimir[27] = llenarTiempo(aux.getProxFinAtencionTrabajador5());
        filaAImprimir[28] = aux.getEstadoT6(); // "Estado T6", "rnd T6", "T Atencion T6", "Prox fin atencion", "Cola E3" 
        filaAImprimir[29] = handleRnd(aux.getRndTrabajador6());
        filaAImprimir[30] = llenarTiempo(aux.getTiempoDeAtencionTrabajador6());
        filaAImprimir[31] = llenarTiempo(aux.getProxFinAtencionTrabajador6());
        filaAImprimir[32] = aux.getColaE3();
        filaAImprimir[33] = handleRnd(aux.getRndFinInspE1()); //"rnd Vuelve a E1", "Vuelve a E1?", "rnd Vuelve E2", "Vuelve a E2?",
        filaAImprimir[34] = aux.isVuelveAEtapa1();
        filaAImprimir[35] = handleRnd(aux.getRndFinInspE2());
        filaAImprimir[36] = aux.isVuelveAEtapa2();
        filaAImprimir[37] = aux.getTareasTerminadas();//"Tareas Terminadas", "T Ocup T1", "T Ocup T2", "T Ocup T3", "T Ocup T4", "T Ocup T5", "T Ocup T6"};
        filaAImprimir[38] = convertirAReloj(aux.getTiempoOcupacionT1());
        filaAImprimir[39] = convertirAReloj(aux.getTiempoOcupacionT2());
        filaAImprimir[40] = convertirAReloj(aux.getTiempoOcupacionT3());
        filaAImprimir[41] = convertirAReloj(aux.getTiempoOcupacionT4());
        filaAImprimir[42] = convertirAReloj(aux.getTiempoOcupacionT5());
        filaAImprimir[43] = convertirAReloj(aux.getTiempoOcupacionT6());
        int i = 44; // Flag para continuar llenando

        // Para cada tarea que exista en el vector de tareas, completo 6 columnas con sus datos. Luego incremento el flag anterior para pasar a las siguientes 6 columnas
        for (int j = 0; j < aux.getVecTareas().length; j++) {
            filaAImprimir[i] = llenarTiempo(aux.getVecTareas()[j].getHoraLlegada());
            filaAImprimir[i + 1] = llenarTiempo(aux.getVecTareas()[j].getHoraFin());
            filaAImprimir[i + 2] = aux.getVecTareas()[j].getEstado();
            filaAImprimir[i + 3] = aux.getVecTareas()[j].getPosicion();
            filaAImprimir[i + 4] = llenarTiempo(aux.getVecTareas()[j].getHoraFinEventoActual());
            filaAImprimir[i + 5] = llenarTiempo(aux.getVecTareas()[j].getTiempoEnSistema());
            i = i + 6;
        }

    }

    private boolean validarNumerosNulos() {

        if (txtCantidadFilas.getText().length() == 0) {
            JOptionPane.showMessageDialog(new JFrame(), "Parametros N no ingresado, usando valor por defecto (10000)", "Parámetros incorrectos", JOptionPane.WARNING_MESSAGE);
            txtCantidadFilas.setText("10000");
            return false;
        } else if (txtDesde.getText().length() == 0) {
            JOptionPane.showMessageDialog(new JFrame(), "Parametros Desde no ingresado, usando valor por defecto (0)", "Parámetros incorrectos", JOptionPane.WARNING_MESSAGE);
            txtDesde.setText("0");
            return false;
        } else if (txtHasta.getText().length() == 0) {
            JOptionPane.showMessageDialog(new JFrame(), "Parametros Hasta no ingresado, usando valor por defecto (1000)", "Parámetros incorrectos", JOptionPane.WARNING_MESSAGE);
            txtHasta.setText("1000");
            return false;
        } else if (lambdaLlegadas.getText().length() == 0) {
            JOptionPane.showMessageDialog(new JFrame(), "Parametros Lambda llegadas no ingresado, usando valor por defecto (30)", "Parámetros incorrectos", JOptionPane.WARNING_MESSAGE);
            lambdaLlegadas.setText("30");
            return false;
        } else if (aUnifTxt.getText().length() == 0) {
            JOptionPane.showMessageDialog(new JFrame(), "Parametros Lambda Etapa 1 no ingresado, usando valor por defecto (60)", "Parámetros incorrectos", JOptionPane.WARNING_MESSAGE);
            aUnifTxt.setText("60");
            return false;
        } else if (bUnifTxt.getText().length() == 0) {
            JOptionPane.showMessageDialog(new JFrame(), "Parametros Lambda Etapa 2 no ingresado, usando valor por defecto (30)", "Parámetros incorrectos", JOptionPane.WARNING_MESSAGE);
            bUnifTxt.setText("30");
            return false;
        } else if (bTxt.getText().length() == 0) {
            JOptionPane.showMessageDialog(new JFrame(), "Parametros Lambda Etapa Inspeccion no ingresado, usando valor por defecto (20)", "Parámetros incorrectos", JOptionPane.WARNING_MESSAGE);
            bTxt.setText("20");
            return false;
        }
        return true;

    }

    private boolean validarLambdas(double a, double b, double c, double d) {

        if (a <= 0 || b <= 0 || c <= 0 || d <= 0) {
            JOptionPane.showMessageDialog(new JFrame(), "Los parametro de lambda no deben ser mayor a 0", "Parámetro incorrecto", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;

    }

    public Principal() {

        initComponents();
        pantallaActual = new JFrame();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        buttonGroup8 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        BtnSimular = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtCantidadFilas = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDesde = new javax.swing.JTextField();
        txtHasta = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        lambdaLlegadas = new javax.swing.JTextField();
        txtPorcentajeOcupacion1 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        aUnifTxt = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        bUnifTxt = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        bTxt = new javax.swing.JTextField();
        txtPorcentajeOcupacion4 = new javax.swing.JLabel();
        txtPorcentajeOcupacion2 = new javax.swing.JLabel();
        txtPorcentajeOcupacion5 = new javax.swing.JLabel();
        txtPorcentajeOcupacion3 = new javax.swing.JLabel();
        txtPorcentajeOcupacion6 = new javax.swing.JLabel();
        promedioTiempoEnSistemaLabel = new javax.swing.JLabel();
        BtnConsigna = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 204));

        Tabla.setBackground(new java.awt.Color(204, 204, 255));
        Tabla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tabla.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        Tabla.setGridColor(new java.awt.Color(0, 0, 0));
        Tabla.setShowGrid(true);
        jScrollPane1.setViewportView(Tabla);

        BtnSimular.setText("Simular");
        BtnSimular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSimularActionPerformed(evt);
            }
        });

        jLabel2.setText("Cantidad de Simulaciones");

        txtCantidadFilas.setText("100000");
        txtCantidadFilas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadFilasActionPerformed(evt);
            }
        });
        txtCantidadFilas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadFilasKeyTyped(evt);
            }
        });

        jLabel3.setText("Desde");

        jLabel4.setText("Hasta");

        txtDesde.setText("0");
        txtDesde.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDesdeKeyTyped(evt);
            }
        });

        txtHasta.setText("1000");
        txtHasta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHastaKeyTyped(evt);
            }
        });

        jLabel34.setText("Tareas por hora:");

        lambdaLlegadas.setText("30");
        lambdaLlegadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lambdaLlegadasActionPerformed(evt);
            }
        });
        lambdaLlegadas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lambdaLlegadasKeyTyped(evt);
            }
        });

        txtPorcentajeOcupacion1.setText("Porcentaje ocupacion T1: ");

        jLabel37.setText("Terminados por hora etapa 1:");

        aUnifTxt.setText("60");
        aUnifTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aUnifTxtActionPerformed(evt);
            }
        });
        aUnifTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                aUnifTxtKeyTyped(evt);
            }
        });

        jLabel38.setText("Terminados por hora etapa 2:");

        bUnifTxt.setText("30");
        bUnifTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUnifTxtActionPerformed(evt);
            }
        });
        bUnifTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bUnifTxtKeyTyped(evt);
            }
        });

        jLabel39.setText("Terminados por hora etapa 3:");

        bTxt.setText("20");
        bTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTxtActionPerformed(evt);
            }
        });
        bTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bTxtKeyTyped(evt);
            }
        });

        txtPorcentajeOcupacion4.setText("Porcentaje ocupacion T4: ");

        txtPorcentajeOcupacion2.setText("Porcentaje ocupacion T2: ");

        txtPorcentajeOcupacion5.setText("Porcentaje ocupacion T5: ");

        txtPorcentajeOcupacion3.setText("Porcentaje ocupacion T3: ");

        txtPorcentajeOcupacion6.setText("Porcentaje ocupacion T6: ");

        promedioTiempoEnSistemaLabel.setText("Promedio de tiempo en sistema: ");

        BtnConsigna.setText("Consigna");
        BtnConsigna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConsignaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidadFilas, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnSimular, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1643, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPorcentajeOcupacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPorcentajeOcupacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPorcentajeOcupacion3, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPorcentajeOcupacion4, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPorcentajeOcupacion5, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPorcentajeOcupacion6, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(aUnifTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel38)
                        .addGap(18, 18, 18)
                        .addComponent(bUnifTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(promedioTiempoEnSistemaLabel)
                        .addGap(83, 83, 83))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lambdaLlegadas, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnConsigna, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCantidadFilas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnSimular)
                        .addComponent(txtDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(txtHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bUnifTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(aUnifTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(promedioTiempoEnSistemaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lambdaLlegadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnConsigna))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPorcentajeOcupacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPorcentajeOcupacion4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPorcentajeOcupacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPorcentajeOcupacion5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPorcentajeOcupacion3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPorcentajeOcupacion6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    double masBajo;
    private void BtnSimularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimularActionPerformed

        columna = Arrays.copyOf(columna, origLength); //Vuelvo el array a su estado original. Esto evita que se sigan agregando columnas si aprieto Simular de nuevo

        columna = Arrays.copyOf(columna, columna.length + cantTareas * 6); //Copio el array columnas, pero agregando 6 columnas extra por cada tarea que quiera visualizar
        int j = 1;
        for (int i = origLength; i < columna.length; i = i + 6) {
            columna[i] = "Hora llegada" ;
            columna[i + 1] = "Hora Salida";
            columna[i + 2] = "Estado";
            columna[i + 3] = "Posicion";
            columna[i + 4] = "Hora Fin Ev Actual";
            columna[i + 5] = "Tiempo en sistema Tarea " + j;
            j++;
        }

        filaAImprimir = Arrays.copyOf(filaAImprimir, columna.length); //Agrando el array de filas para poder llenarlo en un futuro (Con el mismo largo que las columnas)

        validarNumerosNulos();

        N = Integer.parseInt(txtCantidadFilas.getText());
        desde = Integer.parseInt(txtDesde.getText());
        hasta = Integer.parseInt(txtHasta.getText());
        lambdaLl = Double.parseDouble(lambdaLlegadas.getText());
        lambdaE1 = Double.parseDouble(aUnifTxt.getText());
        lambdaE2 = Double.parseDouble(bUnifTxt.getText());
        lambdaE3 = Double.parseDouble(bTxt.getText());

        validarLambdas(lambdaLl, lambdaE1, lambdaE2, lambdaE3);

        //Validacion extra para que lambda no sea menor a 0, pero no se esta usando ya que hay validacion previa
        if (lambdaLl <= 0) {
            lambdaLl = 0.1;
        }
        lambdaLl = lambdaLl / 60; //Divido lambda por 60 para ver cuantos minutos pasan entre ocurrencia

        if (lambdaE1 <= 0) {
            lambdaE1 = 0.1;
        }
        lambdaE1 = lambdaE1 / 60;

        if (lambdaE2 <= 0) {
            lambdaE2 = 0.1;
        }
        lambdaE2 = lambdaE2 / 60;

        if (lambdaE3 <= 0) {
            lambdaE3 = 0.1;
        }
        lambdaE3 = lambdaE3 / 60;

        tabla = new DefaultTableModel();
        tabla.setColumnIdentifiers(columna);

        aux1 = new Fila2(lambdaLl, lambdaE1, lambdaE2, lambdaE3); //Creo la Fila inicial, pasando los 4 lambdas necesarios para los eventos

        aux1.CalcularPrimeraFila(cantTareas); //Calculo la primer fila

        // Ciclo para generar los eventos hasta el parametro N
        for (int i = 0; i < N; i++) {

            //Si el contador de la fila esta entre el desde y el hasta, lo coloco en la tabla
            if ((aux1.getContadorN() >= desde && aux1.getContadorN() <= hasta) || aux1.getContadorN() == N) {

                llenarFila(aux1);
                tabla.addRow(filaAImprimir);

            }

            //Calculo nueva fila
            aux1.CalcularNuevaFila();
        }

        //Tomo los acumuladores de los tiempos de ocupacion, y los coloco en los labels correspondientes
        double acumT1 = aux1.getTiempoOcupacionT1();
        double acumT2 = aux1.getTiempoOcupacionT2();
        double acumT3 = aux1.getTiempoOcupacionT3();
        double acumT4 = aux1.getTiempoOcupacionT4();
        double acumT5 = aux1.getTiempoOcupacionT5();
        double acumT6 = aux1.getTiempoOcupacionT6();
        txtPorcentajeOcupacion1.setText("Porcentaje ocupacion T1: " + df2.format((acumT1 * 100) / aux1.getReloj()) + " %");
        txtPorcentajeOcupacion2.setText("Porcentaje ocupacion T2: " + df2.format((acumT2 * 100) / aux1.getReloj()) + " %");
        txtPorcentajeOcupacion3.setText("Porcentaje ocupacion T3: " + df2.format((acumT3 * 100) / aux1.getReloj()) + " %");
        txtPorcentajeOcupacion4.setText("Porcentaje ocupacion T4: " + df2.format((acumT4 * 100) / aux1.getReloj()) + " %");
        txtPorcentajeOcupacion5.setText("Porcentaje ocupacion T5: " + df2.format((acumT5 * 100) / aux1.getReloj()) + " %");
        txtPorcentajeOcupacion6.setText("Porcentaje ocupacion T6: " + df2.format((acumT6 * 100) / aux1.getReloj()) + " %");

        // Verifico cuantas de las tareas del vector finalizaron, y si lo hicieron acumulo su tiempo en sistema
        int tareasFinalizadas = 0;
        double acumTareasFinalizadas = 0.0;
        for (Tarea vecTarea : aux1.getVecTareas()) {
            if (vecTarea.getEstado() == EstadoTareas.Finalizada) {
                tareasFinalizadas++;
                acumTareasFinalizadas += vecTarea.getTiempoEnSistema();
            }
        }

        // Calculo y muestro tiempo en sistema promedio
        promedioTiempoEnSistemaLabel.setText("Promedio tiempo en sistema: " + convertirAReloj(acumTareasFinalizadas / tareasFinalizadas));

        Tabla.setModel(tabla);

        Tabla.getColumn("Rnd Llegada").setCellRenderer(
                new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {
                setText(value.toString());
                setBackground(isSelected ? Color.blue : Color.yellow);
                return this;
            }
        });

        Tabla.getColumn("T Entre Llegadas").setCellRenderer(
                new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {
                setText(value.toString());
                setBackground(isSelected ? Color.blue : Color.yellow);
                return this;
            }
        });

        Tabla.getColumn("Prox Llegada").setCellRenderer(
                new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {
                setText(value.toString());
                setBackground(isSelected ? Color.blue : Color.yellow);
                return this;
            }
        });

        Tabla.getColumn("Estado T1").setCellRenderer(
                new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {
                setText(value.toString());
                setBackground(isSelected ? Color.red : Color.GREEN);
                return this;
            }
        });

        Tabla.getColumn("rnd T1").setCellRenderer(
                new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {
                setText(value.toString());
                setBackground(isSelected ? Color.red : Color.GREEN);
                return this;
            }
        });

        Tabla.getColumn("T Atencion T1").setCellRenderer(
                new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {
                setText(value.toString());
                setBackground(isSelected ? Color.red : Color.GREEN);
                return this;
            }
        });

        Tabla.getColumn("Prox fin atencion T1").setCellRenderer(
                new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {
                setText(value.toString());
                setBackground(isSelected ? Color.red : Color.GREEN);
                return this;
            }
        });

        Tabla.getColumn("Cola E1").setCellRenderer(
                new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {
                setText(value.toString());
                setBackground(isSelected ? Color.red : Color.GREEN);
                return this;
            }
        });

        Tabla.getColumn("Estado T2").setCellRenderer(
                new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {
                setText(value.toString());
                setBackground(isSelected ? Color.BLUE : Color.CYAN);
                return this;
            }
        });

        Tabla.getColumn("rnd T2").setCellRenderer(
                new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {
                setText(value.toString());
                setBackground(isSelected ? Color.BLUE : Color.CYAN);
                return this;
            }
        });

        Tabla.getColumn("T Atencion T2").setCellRenderer(
                new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {
                setText(value.toString());
                setBackground(isSelected ? Color.BLUE : Color.CYAN);
                return this;
            }
        });

        Tabla.getColumn("Prox fin atencion T2").setCellRenderer(
                new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {
                setText(value.toString());
                setBackground(isSelected ? Color.BLUE : Color.CYAN);
                return this;
            }
        });

        Tabla.getColumn("Estado T3").setCellRenderer(
                new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {
                setText(value.toString());
                setBackground(isSelected ? Color.BLUE : Color.CYAN);
                return this;
            }
        });

        Tabla.getColumn("rnd T3").setCellRenderer(
                new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {
                setText(value.toString());
                setBackground(isSelected ? Color.BLUE : Color.CYAN);
                return this;
            }
        });

        Tabla.getColumn("T Atencion T3").setCellRenderer(
                new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {
                setText(value.toString());
                setBackground(isSelected ? Color.BLUE : Color.CYAN);
                return this;
            }
        });

        Tabla.getColumn("Prox fin atencion T3").setCellRenderer(
                new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {
                setText(value.toString());
                setBackground(isSelected ? Color.BLUE : Color.CYAN);
                return this;
            }
        });

        Tabla.getColumn("Cola E2").setCellRenderer(
                new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {
                setText(value.toString());
                setBackground(isSelected ? Color.BLUE : Color.CYAN);
                return this;
            }
        });

        Tabla.getColumn("rnd Vuelve a E1").setCellRenderer(
                new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {
                setText(value.toString());
                setBackground(isSelected ? Color.red : Color.GREEN);
                return this;
            }
        });

        Tabla.getColumn("Vuelve a E1?").setCellRenderer(
                new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {
                setText(value.toString());
                setBackground(isSelected ? Color.red : Color.GREEN);
                return this;
            }
        });

        Tabla.getColumn("rnd Vuelve E2").setCellRenderer(
                new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {
                setText(value.toString());
                setBackground(isSelected ? Color.red : Color.GREEN);
                return this;
            }
        });

        Tabla.getColumn("Vuelve a E2?").setCellRenderer(
                new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {
                setText(value.toString());
                setBackground(isSelected ? Color.red : Color.GREEN);
                return this;
            }
        });

        /*  Tabla.getColumn("Prox fin A4").setCellRenderer(
                new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {
                setText(value.toString());
                setBackground(isSelected ? Color.red : Color.GREEN);
                return this;
            }
        });

        Tabla.getColumn("Cola A4").setCellRenderer(
                new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {
                setText(value.toString());
                setBackground(isSelected ? Color.red : Color.GREEN);
                return this;
            }
        });

        */
        for (int i = 1; i <= cantTareas; i++) {
            
            Tabla.getColumn("Tiempo en sistema Tarea " + i).setCellRenderer(
                new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {
                setText(value.toString());
                setBackground(isSelected ? Color.WHITE : Color.LIGHT_GRAY);
                return this;
            }
        });
        }
        
        
        
/*
        Tabla.getColumn("Cola Terminados A3").setCellRenderer(
                new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {
                setText(value.toString());
                setBackground(isSelected ? Color.WHITE : Color.LIGHT_GRAY);
                return this;
            }
        });

        Tabla.getColumn("Tareas terminadas").setCellRenderer(
                new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {
                setText(value.toString());
                setBackground(isSelected ? Color.WHITE : Color.LIGHT_GRAY);
                return this;
            }
        });*/
    }//GEN-LAST:event_BtnSimularActionPerformed

    private void lambdaLlegadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lambdaLlegadasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lambdaLlegadasActionPerformed

    private void txtCantidadFilasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadFilasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadFilasActionPerformed

    private void aUnifTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aUnifTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aUnifTxtActionPerformed

    private void bUnifTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUnifTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bUnifTxtActionPerformed

    private void bTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bTxtActionPerformed

    private void lambdaLlegadasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lambdaLlegadasKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
            evt.consume();  // if it's not a number, ignore the event
        }
    }//GEN-LAST:event_lambdaLlegadasKeyTyped

    private void txtCantidadFilasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadFilasKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
            evt.consume();  // if it's not a number, ignore the event
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadFilasKeyTyped

    private void aUnifTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aUnifTxtKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
            evt.consume();  // if it's not a number, ignore the event
        }        // TODO add your handling code here:
    }//GEN-LAST:event_aUnifTxtKeyTyped

    private void bUnifTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bUnifTxtKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
            evt.consume();  // if it's not a number, ignore the event
        }        // TODO add your handling code here:
    }//GEN-LAST:event_bUnifTxtKeyTyped

    private void bTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bTxtKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
            evt.consume();  // if it's not a number, ignore the event
        }        // TODO add your handling code here:
    }//GEN-LAST:event_bTxtKeyTyped

    private void txtDesdeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDesdeKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
            evt.consume();  // if it's not a number, ignore the event
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtDesdeKeyTyped

    private void txtHastaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHastaKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
            evt.consume();  // if it's not a number, ignore the event
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtHastaKeyTyped

    private void BtnConsignaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConsignaActionPerformed
        JOptionPane.showMessageDialog(new JFrame(), "En una línea de ensamblado llegan 30 tareas por hora. Cada trabajo debe pasar por dos etapas de\n"
                + "producción: etapa 1 y etapa 2. La etapa 1 toma un promedio de un minuto en completarse, y el\n"
                + "trabajador 1 está disponible para llevar a cabo la etapa 1. Después de completar la etapa 1, el\n"
                + "trabajo pasa de inmediato a la etapa 2. Esta toma un promedio de dos minutos en completarse, y\n"
                + "dos trabajadores están disponibles para trabajar en la etapa 2.\n"
                + "Después de completar la etapa 2, se inspecciona cada trabajo. La inspección toma un promedio de\n"
                + "tres minutos, y tres trabajadores están disponibles para efectuar la inspección. Después de la\n"
                + "inspección, 10% de los trabajos deben volver a la etapa 1 y repiten las etapas 1 y 2. Luego de la\n"
                + "inspección, 20% de los trabajos vuelven a la etapa 2 y tienen que pasar por ésta. Suponga que los\n"
                + "tiempos entre llegadas y los tiempos de servicio son exponenciales.\n"
                + "¿Cuál es el tiempo promedio que un trabajo pasa en el sistema?\n"
                + "¿Qué porcentaje de tiempo está ocupado cada trabajador?", "Consigna", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_BtnConsignaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnConsigna;
    private javax.swing.JButton BtnSimular;
    private javax.swing.JTable Tabla;
    private javax.swing.JTextField aUnifTxt;
    private javax.swing.JTextField bTxt;
    private javax.swing.JTextField bUnifTxt;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lambdaLlegadas;
    private javax.swing.JLabel promedioTiempoEnSistemaLabel;
    private javax.swing.JTextField txtCantidadFilas;
    private javax.swing.JTextField txtDesde;
    private javax.swing.JTextField txtHasta;
    private javax.swing.JLabel txtPorcentajeOcupacion1;
    private javax.swing.JLabel txtPorcentajeOcupacion2;
    private javax.swing.JLabel txtPorcentajeOcupacion3;
    private javax.swing.JLabel txtPorcentajeOcupacion4;
    private javax.swing.JLabel txtPorcentajeOcupacion5;
    private javax.swing.JLabel txtPorcentajeOcupacion6;
    // End of variables declaration//GEN-END:variables
}
