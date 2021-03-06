package myProject;


import javax.swing.*;
import java.awt.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.MouseListenimport javax.swing.*;


/**
 * This class is used for ...
 *
 * @version v.1.0.0 date 11/01/2022
 * @authors Laura Jaimes, laura.jaimes@correounivalle.edu.co, 2040430-3743
 * Esteban Hernandez, esteban.cortes@correounivalle.edu.co, 2042817 - 3743
 */

public class GUI extends JFrame {

    public static final String MENSAJE_INICIO = "Bienvenido a Geek Out Masters!!\n"
            + "Para iniciar el juego oprime el boton lanzar y se lanzaran los 10 dados de forma aleatoria.\n"
            + "Tres de esos 10 dados se iran a la parte de dados inactivos y 7 quedan en dados activos.\n"
            + "Al tener los dados, tienes que recordar las siguientes reglas:\n"
            + "1. El Meeple permite relanzar otro dado en juego, es decir, de la sección dados activos.\n"
            + "2. El cohete envía un dado no usado (de la sección dados activos) a la sección de dados inanctivos\n"
            + "3. El Superhéroe permite que cualquier dado no usado (sección dados activos) sea volteado y colocando en su cara opuesta.\n"
            + "4. El Corazón permite tomar un dado de la sección de dados inactivos y lanzarlo para que sea un nuevo dado activo.\n"
            + "5. El Dragón es la cara que se quiere evitar, ya que si al final de la ronda es el último dado activo que queda se habrán perdido todos los puntos ganados y acumulados.\n"
            + "6. 42 es la cara que permite sumar puntos al final de la ronda.\n"
            + "Pero tienes que tener en cuenta que cada dado tiene una cara opuesta.\n"
            + "Oprime el boton de Caras para saber mas!!";

    public static final String MENSAJE_CARAS = "Hola!! al parecer quieres conocer cuales son las caras opuestas de los dados, aca te explico.\n"
            + "La cara contraría al Corazón es el 42, ya que tienen el mismo color (rojo)\n"
            + "La cara contraria del Meeple es el Cohete, mismo color (verde).\n"
            + "Y la cara contraria del Superhéroe es el Dragón, mismo color (amarillo).";
    public static final String MENSAJE_PERDISTE = "Perdiste todos tus puntos";

    private Header headerProject;
    private JPanel panelPuntaje, panelUtilizados, panelActivos, panelInactivos, mensajePuntaje, mensajeRonda;
    private JButton lanzar, ayuda, salir, carasOpuestas, finalizarRonda, dado1, dado2, dado3, dado4, dado5, dado6, dado7, dado8, dado9, dado10, botonPuntaje;
    private ImageIcon imageDados, imageDado, imageBotonSalir, imageBotonAyuda, imagenfondo, imagenPuntaje, imageDadoM;
    private Escucha escucha;
    private Partida partida;
    private Zona lamonda;
    private Zona inactivos;
    private Zona activos;
    private Zona utilizados;
    private ModelGeek modelGeek;
    private Dado dado;


    /**
     * Constructor of GUI class
     */
    public GUI() {
        initGUI();

        //Default JFrame configuration
        this.setTitle("Geek Out Masters");
        this.setSize(900, 900);
        //this.setBackground(new Color(255,255,255,0));
        this.setUndecorated(true);
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        //Create Listener Object and Control Object
        escucha = new Escucha();
        partida = new Partida();
        modelGeek = new ModelGeek();
        //Set up JComponents
        headerProject = new Header("Geek Out Masters", Color.BLACK);
        headerProject.setFont(new Font("Arial", Font.BOLD, 26));
        headerProject.setBackground(Color.WHITE);
        headerProject.setIcon(new ImageIcon(getClass().getResource("/resources/fondoHeader.jpeg")));
        headerProject.setPreferredSize(new Dimension(200, 100));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(headerProject, constraints);

//------------Se añande la imagen inicial a los dados-------------------------------------------------------------------------------------
        imageDados = new ImageIcon(getClass().getResource("/resources/dado1.png"));
        dado1 = new JButton(imageDados);
        dado1.setPreferredSize(new Dimension(70, 60));
        dado2 = new JButton(imageDados);
        dado2.setPreferredSize(new Dimension(70, 60));
        dado3 = new JButton(imageDados);
        dado3.setPreferredSize(new Dimension(70, 60));
        dado4 = new JButton(imageDados);
        dado4.setPreferredSize(new Dimension(70, 60));
        dado5 = new JButton(imageDados);
        dado5.setPreferredSize(new Dimension(70, 60));
        dado6 = new JButton(imageDados);
        dado6.setPreferredSize(new Dimension(70, 60));
        dado7 = new JButton(imageDados);
        dado7.setPreferredSize(new Dimension(70, 60));
        dado8 = new JButton(imageDados);
        dado8.setPreferredSize(new Dimension(70, 60));
        dado9 = new JButton(imageDados);
        dado9.setPreferredSize(new Dimension(70, 60));
        dado10 = new JButton(imageDados);
        dado10.setPreferredSize(new Dimension(70, 60));

        dado1.addActionListener(escucha);
        dado2.addActionListener(escucha);
        dado3.addActionListener(escucha);
        dado4.addActionListener(escucha);
        dado5.addActionListener(escucha);
        dado6.addActionListener(escucha);
        dado7.addActionListener(escucha);
        dado8.addActionListener(escucha);
        dado9.addActionListener(escucha);
        dado10.addActionListener(escucha);

//------Se crean los botones--------------------------------------------------------------------------------------------------
        lanzar = new JButton("Lanzar");
        lanzar.setFont(new Font("times new roman", Font.BOLD, 15));
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(lanzar, constraints);
        lanzar.addActionListener(escucha);
        lanzar.setBackground(Color.darkGray);
        lanzar.setForeground(Color.WHITE);

        salir = new JButton();
        imageBotonSalir = new ImageIcon(getClass().getResource("/resources/salir.jpeg"));
        salir.setPreferredSize(new Dimension(25, 25));
        salir.setIcon(imageBotonSalir);
        salir.setBackground(Color.WHITE);
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_END;
        this.add(salir, constraints);
        salir.addActionListener(escucha);

        ayuda = new JButton();
        imageBotonAyuda = new ImageIcon(getClass().getResource("/resources/ayuda.jpeg"));
        ayuda.setPreferredSize(new Dimension(25, 25));
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_START;
        this.add(ayuda, constraints);
        ayuda.addActionListener(escucha);
        ayuda.setBackground(Color.WHITE);
        ayuda.setIcon(imageBotonAyuda);

        carasOpuestas = new JButton("Caras");
        carasOpuestas.setFont(new Font("times new roman", Font.BOLD, 15));
        carasOpuestas.setBackground(Color.darkGray);
        carasOpuestas.setForeground(Color.WHITE);
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(carasOpuestas, constraints);
        carasOpuestas.addActionListener(escucha);

        finalizarRonda = new JButton("Finalizar ronda");
        finalizarRonda.setFont(new Font("times new roman", Font.BOLD, 15));
        finalizarRonda.setBackground(Color.darkGray);
        finalizarRonda.setForeground(Color.WHITE);
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(finalizarRonda, constraints);
        finalizarRonda.addActionListener(escucha);

        botonPuntaje = new JButton("Calcula el puntaje");
        botonPuntaje.setFont(new Font("times new roman", Font.BOLD, 15));
        botonPuntaje.setBackground(Color.darkGray);
        botonPuntaje.setForeground(Color.WHITE);
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(finalizarRonda, constraints);
        botonPuntaje.addActionListener(escucha);

//-------Se crean los paneles----------------------------------------------------------------------------------------------------------------
        panelActivos = new JPanel();
        panelActivos.setPreferredSize(new Dimension(400, 180));
        panelActivos.setBorder(BorderFactory.createTitledBorder("Dados activos: "));
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(panelActivos, constraints);
        panelActivos.setBackground(new Color(255, 255, 255, 0));
        panelActivos.setOpaque(false);

        panelActivos.add(dado1);
        panelActivos.add(dado2);
        panelActivos.add(dado3);
        panelActivos.add(dado4);
        panelActivos.add(dado5);
        panelActivos.add(dado6);
        panelActivos.add(dado7);

        panelInactivos = new JPanel();
        panelInactivos.setBorder(BorderFactory.createTitledBorder("Dados inactivos: "));
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(panelInactivos, constraints);
        panelInactivos.setPreferredSize(new Dimension(400, 180));
        panelInactivos.setBackground(new Color(255, 255, 255, 0));

        panelInactivos.add(dado8);
        panelInactivos.add(dado9);
        panelInactivos.add(dado10);

        panelUtilizados = new JPanel();
        panelUtilizados.setPreferredSize(new Dimension(400, 180));
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(panelUtilizados, constraints);
        panelUtilizados.setBorder(BorderFactory.createTitledBorder("Dados utilizados: "));
        panelUtilizados.setBackground(new Color(255, 255, 255, 0));

        panelPuntaje = new JPanel();
        panelPuntaje.setPreferredSize(new Dimension(400, 180));
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        this.add(panelPuntaje, constraints);
        panelPuntaje.setBorder(BorderFactory.createTitledBorder("Tu puntaje: "));
        panelPuntaje.add(botonPuntaje);


        mensajeRonda = new JPanel();
        mensajeRonda.setBorder(BorderFactory.createTitledBorder("Ronda: \n" + partida.getRonda()));
        mensajeRonda.setPreferredSize(new Dimension(110, 30));
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_END;
        this.add(mensajeRonda, constraints);

        mensajePuntaje = new JPanel();
        mensajePuntaje.setBorder(BorderFactory.createTitledBorder("Puntaje global: \n" + partida.getPuntaje().calcularPuntaje()));
        mensajePuntaje.setPreferredSize(new Dimension(130, 30));
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_START;
        this.add(mensajePuntaje, constraints);

    }

    /**
     * Main process of the Java program
     *
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */

    private class Escucha implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == ayuda) {
                JOptionPane.showMessageDialog(null, MENSAJE_INICIO);
            } else if (e.getSource() == lanzar) {
                modelGeek.calcularCara();
                int[] caraDados = modelGeek.getCaras();
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[0] + ".png"));
                dado1.setIcon(imageDado);
                revalidate();
                repaint();
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[1] + ".png"));
                dado2.setIcon(imageDado);
                revalidate();
                repaint();
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[2] + ".png"));
                dado3.setIcon(imageDado);
                revalidate();
                repaint();
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[3] + ".png"));
                dado4.setIcon(imageDado);
                revalidate();
                repaint();
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[4] + ".png"));
                dado5.setIcon(imageDado);
                revalidate();
                repaint();
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[5] + ".png"));
                dado6.setIcon(imageDado);
                revalidate();
                repaint();
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[6] + ".png"));
                dado7.setIcon(imageDado);
                revalidate();
                repaint();
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[7] + ".png"));
                dado8.setIcon(imageDado);
                revalidate();
                repaint();
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[8] + ".png"));
                dado9.setIcon(imageDado);
                revalidate();
                repaint();
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[9] + ".png"));
                dado10.setIcon(imageDado);
                revalidate();
                repaint();
                mensajeRonda.setBorder(BorderFactory.createTitledBorder("Ronda: \n" + partida.aumentarRonda()));


            } else if (e.getSource() == carasOpuestas) {
                JOptionPane.showMessageDialog(null, MENSAJE_CARAS);

            } else if (e.getSource() == salir) {
                System.exit(0);
            } else if (e.getSource() == botonPuntaje) {
                partida.calculoP();
            }
            if (e.getSource() == finalizarRonda) {
                panelPuntaje.removeAll();
                panelInactivos.removeAll();
                panelActivos.removeAll();
                panelUtilizados.removeAll();
                modelGeek.calcularCara();
                int[] caraDados = modelGeek.getCaras();
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[0] + ".png"));
                dado1.setIcon(imageDado);
                revalidate();
                repaint();
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[1] + ".png"));
                dado2.setIcon(imageDado);
                revalidate();
                repaint();
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[2] + ".png"));
                dado3.setIcon(imageDado);
                revalidate();
                repaint();
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[3] + ".png"));
                dado4.setIcon(imageDado);
                revalidate();
                repaint();
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[4] + ".png"));
                dado5.setIcon(imageDado);
                revalidate();
                repaint();
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[5] + ".png"));
                dado6.setIcon(imageDado);
                revalidate();
                repaint();
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[6] + ".png"));
                dado7.setIcon(imageDado);
                revalidate();
                repaint();
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[7] + ".png"));
                dado8.setIcon(imageDado);
                revalidate();
                repaint();
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[8] + ".png"));
                dado9.setIcon(imageDado);
                revalidate();
                repaint();
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[9] + ".png"));
                dado10.setIcon(imageDado);
                revalidate();
                repaint();
                dado1.add(panelActivos);
                dado2.add(panelActivos);
                dado3.add(panelActivos);
                dado4.add(panelActivos);
                dado5.add(panelActivos);
                dado6.add(panelActivos);
                dado7.add(panelActivos);

                dado8.add(panelInactivos);
                dado9.add(panelInactivos);
                dado10.add(panelInactivos);
                partida.finalizarRonda();
            }
//----------------Se activa el poder del 42-------------------------------------------------------------------------------------------------
            else if (e.getSource() == dado1) {
                int[] caraDados = modelGeek.getCaras();
                if (caraDados[0] == 6) {
                    Dado dado = new Dado();
                    partida.activar42(dado);
                    panelActivos.remove(dado1);
                    panelPuntaje.add(dado1);
                    repaint();
                    revalidate();
                    mensajePuntaje.setBorder(BorderFactory.createTitledBorder("Puntaje global: \n" + partida.calculoP()));
                }
            } else if (e.getSource() == dado2) {
                int[] caraDados = modelGeek.getCaras();
                if (caraDados[1] == 6) {
                    Dado dado = new Dado();
                    partida.activar42(dado);
                    panelActivos.remove(dado2);
                    panelPuntaje.add(dado2);
                    revalidate();
                    repaint();

                    mensajePuntaje.setBorder(BorderFactory.createTitledBorder("Puntaje global: \n" + partida.calculoP()));
                }
            } else if (e.getSource() == dado3) {
                int[] caraDados = modelGeek.getCaras();
                if (caraDados[2] == 6) {
                    Dado dado = new Dado();
                    partida.activar42(dado);
                    panelActivos.remove(dado3);
                    panelPuntaje.add(dado3);
                    revalidate();
                    repaint();
                    mensajePuntaje.setBorder(BorderFactory.createTitledBorder("Puntaje global: \n" + partida.calculoP()));
                }
            } else if (e.getSource() == dado4) {
                int[] caraDados = modelGeek.getCaras();


                if (caraDados[3] == 6) {
                    panelActivos.remove(dado4);
                    panelPuntaje.add(dado4);
                    revalidate();
                    repaint();


                    mensajePuntaje.setBorder(BorderFactory.createTitledBorder("Puntaje global: \n" + partida.calculoP()));
                }

            } else if (e.getSource() == dado5) {
                int[] caraDados = modelGeek.getCaras();


                if (caraDados[4] == 6) {
                    panelActivos.remove(dado5);
                    panelPuntaje.add(dado5);
                    revalidate();
                    repaint();

                    mensajePuntaje.setBorder(BorderFactory.createTitledBorder("Puntaje global: \n" + partida.calculoP()));
                }

            } else if (e.getSource() == dado6) {
                int[] caraDados = modelGeek.getCaras();


                if (caraDados[5] == 6) {
                    panelActivos.remove(dado6);
                    panelPuntaje.add(dado6);
                    revalidate();
                    repaint();


                    mensajePuntaje.setBorder(BorderFactory.createTitledBorder("Puntaje global: \n" + partida.calculoP()));
                }

            } else if (e.getSource() == dado7) {
                int[] caraDados = modelGeek.getCaras();


                if (caraDados[6] == 6) {
                    panelActivos.remove(dado7);
                    panelPuntaje.add(dado7);
                    revalidate();
                    repaint();

                    mensajePuntaje.setBorder(BorderFactory.createTitledBorder("Puntaje global: \n" + partida.calculoP()));
                }

            }

//----------------Se activa el poder del dragon----------------------------------------------------------------------------------------------------------
            else if (e.getSource() == dado1) {
                int[] caraDados = modelGeek.getCaras();
                if (caraDados[0] == 2) {

                    panelPuntaje.removeAll();
                    revalidate();
                    repaint();
                    mensajePuntaje.setBorder(BorderFactory.createTitledBorder("Puntaje global: \n" + partida.getPuntaje().calcularPuntaje()));

                    JOptionPane.showMessageDialog(null, MENSAJE_PERDISTE);
                }
            } else if (e.getSource() == dado2) {
                int[] caraDados = modelGeek.getCaras();
                if (caraDados[1] == 2) {
                    panelPuntaje.removeAll();
                    repaint();
                    mensajePuntaje.setBorder(BorderFactory.createTitledBorder("Puntaje global: \n" + partida.getPuntaje().calcularPuntaje()));
                    JOptionPane.showMessageDialog(null, MENSAJE_PERDISTE);
                }
            } else if (e.getSource() == dado3) {
                int[] caraDados = modelGeek.getCaras();
                if (caraDados[2] == 2) {
                    panelPuntaje.removeAll();
                    revalidate();
                    repaint();
                    mensajePuntaje.setBorder(BorderFactory.createTitledBorder("Puntaje global: \n" + partida.getPuntaje().calcularPuntaje()));
                    JOptionPane.showMessageDialog(null, MENSAJE_PERDISTE);
                }
            } else if (e.getSource() == dado4) {
                int[] caraDados = modelGeek.getCaras();
                if (caraDados[3] == 2) {
                    panelPuntaje.removeAll();
                    revalidate();
                    repaint();
                    mensajePuntaje.setBorder(BorderFactory.createTitledBorder("Puntaje global: \n" + partida.getPuntaje().calcularPuntaje()));
                    JOptionPane.showMessageDialog(null, MENSAJE_PERDISTE);
                }
            } else if (e.getSource() == dado5) {
                int[] caraDados = modelGeek.getCaras();
                if (caraDados[4] == 2) {
                    panelPuntaje.removeAll();
                    revalidate();
                    repaint();
                    mensajePuntaje.setBorder(BorderFactory.createTitledBorder("Puntaje global: \n" + partida.getPuntaje().calcularPuntaje()));
                    JOptionPane.showMessageDialog(null, MENSAJE_PERDISTE);
                }
            } else if (e.getSource() == dado6) {
                int[] caraDados = modelGeek.getCaras();
                if (caraDados[5] == 2) {
                    panelPuntaje.removeAll();
                    revalidate();
                    repaint();
                    mensajePuntaje.setBorder(BorderFactory.createTitledBorder("Puntaje global: \n" + partida.getPuntaje().calcularPuntaje()));
                    JOptionPane.showMessageDialog(null, MENSAJE_PERDISTE);
                }
            } else if (e.getSource() == dado7) {
                int[] caraDados = modelGeek.getCaras();
                if (caraDados[6] == 2) {
                    panelPuntaje.removeAll();
                    revalidate();
                    repaint();
                    mensajePuntaje.setBorder(BorderFactory.createTitledBorder("Puntaje global: \n" + partida.getPuntaje().calcularPuntaje()));
                    JOptionPane.showMessageDialog(null, MENSAJE_PERDISTE);
                }
            }
//----------------Se activa el poder del meeple-------------------------------------------------------------------------
            if (e.getSource() == dado1) {

                int[] caraDados = modelGeek.getCaras();
                modelGeek.calcularCara();
                if (caraDados[0] == 3) {

                    int dado = partida.dadoSelec();
                    if (dado == 2) {
                        int[] caraDadosu = modelGeek.getCaras();
                        modelGeek.calcularCara();
                        panelActivos.remove(dado1);
                        panelUtilizados.add(dado1);
                        revalidate();
                        repaint();
                        dado2.setIcon(imageDado);
                        revalidate();
                        repaint();

                    }
                    if (dado == 3) {
                        panelActivos.remove(dado1);
                        panelUtilizados.add(dado1);
                        revalidate();
                        repaint();
                        dado3.setIcon(imageDado);
                    }
                    if (dado == 4) {
                        panelActivos.remove(dado1);
                        panelUtilizados.add(dado1);
                        revalidate();
                        repaint();

                        dado4.setIcon(imageDado);
                    }
                    if (dado == 5) {
                        panelActivos.remove(dado1);
                        panelUtilizados.add(dado1);
                        revalidate();
                        repaint();
                        dado5.setIcon(imageDado);
                    }
                    if (dado == 6) {
                        panelActivos.remove(dado1);
                        panelUtilizados.add(dado1);
                        revalidate();
                        repaint();
                        dado6.setIcon(imageDado);
                    }
                    if (dado == 7) {
                        panelActivos.remove(dado1);
                        panelUtilizados.add(dado1);
                        revalidate();
                        repaint();
                        dado7.setIcon(imageDado);
                    }
                }
            }
            if (e.getSource() == dado2) {
                int[] caraDados = modelGeek.getCaras();
                if (caraDados[1] == 3) {
                    panelActivos.remove(dado2);
                    panelUtilizados.add(dado2);
                    int dado = partida.dadoSelec();
                    if (dado == 1) {
                        panelActivos.remove(dado2);
                        panelUtilizados.add(dado2);
                        revalidate();
                        repaint();

                        dado1.setIcon(new ImageIcon(getClass().getResource("/resources/" + caraDados[0] + ".png")));
                    }
                    if (dado == 3) {
                        panelActivos.remove(dado2);
                        panelUtilizados.add(dado2);
                        revalidate();
                        repaint();

                        dado3.setIcon(imageDado);
                    }
                    if (dado == 4) {
                        panelActivos.remove(dado2);
                        panelUtilizados.add(dado2);
                        revalidate();
                        repaint();

                        dado4.setIcon(imageDado);
                    }
                    if (dado == 5) {
                        panelActivos.remove(dado2);
                        panelUtilizados.add(dado2);
                        revalidate();
                        repaint();
                        dado5.setIcon(imageDado);
                    }
                    if (dado == 6) {
                        panelActivos.remove(dado2);
                        panelUtilizados.add(dado2);
                        revalidate();
                        repaint();
                        dado6.setIcon(imageDado);
                    }
                    if (dado == 7) {
                        panelActivos.remove(dado2);
                        panelUtilizados.add(dado2);
                        revalidate();
                        repaint();
                        dado7.setIcon(imageDado);
                    }
                }
            }
            if (e.getSource() == dado3) {
                int[] caraDados = modelGeek.getCaras();
                if (caraDados[2] == 3) {
                    panelActivos.remove(dado3);
                    panelUtilizados.add(dado3);
                    imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[2] + ".png"));
                    dado2.setIcon(imageDado);

                    int dado = partida.dadoSelec();

                    if (dado == 2) {
                        panelActivos.remove(dado3);
                        panelUtilizados.add(dado3);
                        revalidate();
                        repaint();

                        dado2.setIcon(imageDado);
                    }
                    if (dado == 1) {
                        panelActivos.remove(dado3);
                        panelUtilizados.add(dado3);
                        revalidate();
                        repaint();

                        dado1.setIcon(imageDado);
                    }
                    if (dado == 4) {
                        panelActivos.remove(dado3);
                        panelUtilizados.add(dado3);
                        revalidate();
                        repaint();
                        dado4.setIcon(imageDado);
                    }
                    if (dado == 5) {
                        panelActivos.remove(dado3);
                        panelUtilizados.add(dado3);
                        revalidate();
                        repaint();
                        dado5.setIcon(imageDado);
                    }
                    if (dado == 6) {
                        panelActivos.remove(dado3);
                        panelUtilizados.add(dado3);
                        revalidate();
                        repaint();
                        dado6.setIcon(imageDado);
                    }
                    if (dado == 7) {
                        panelActivos.remove(dado3);
                        panelUtilizados.add(dado3);
                        revalidate();
                        repaint();
                        dado7.setIcon(imageDado);
                    }
                }
            }
            if (e.getSource() == dado4) {

                int[] caraDados = modelGeek.getCaras();
                if (caraDados[3] == 3) {
                    panelActivos.remove(dado4);
                    panelUtilizados.add(dado4);

                    int dado = partida.dadoSelec();

                    if (dado == 2) {
                        panelActivos.remove(dado4);
                        panelUtilizados.add(dado4);
                        revalidate();
                        repaint();
                        dado2.setIcon(imageDado);
                    }
                    if (dado == 3) {
                        panelActivos.remove(dado4);
                        panelUtilizados.add(dado4);
                        revalidate();
                        repaint();
                        dado3.setIcon(imageDado);
                    }
                    if (dado == 1) {
                        panelActivos.remove(dado4);
                        panelUtilizados.add(dado4);
                        revalidate();
                        repaint();
                        dado1.setIcon(imageDado);
                    }
                    if (dado == 5) {
                        panelActivos.remove(dado4);
                        panelUtilizados.add(dado4);
                        revalidate();
                        repaint();
                        dado5.setIcon(imageDado);
                    }
                    if (dado == 6) {
                        panelActivos.remove(dado4);
                        panelUtilizados.add(dado4);
                        revalidate();
                        repaint();
                        dado6.setIcon(imageDado);
                    }
                    if (dado == 7) {
                        panelActivos.remove(dado4);
                        panelUtilizados.add(dado4);
                        revalidate();
                        repaint();
                        dado7.setIcon(imageDado);
                    }
                }
            }
            if (e.getSource() == dado5) {

                int[] caraDados = modelGeek.getCaras();
                if (caraDados[3] == 3) {
                    panelActivos.remove(dado5);
                    panelUtilizados.add(dado5);

                    int dado = partida.dadoSelec();

                    if (dado == 2) {
                        panelActivos.remove(dado5);
                        panelUtilizados.add(dado5);
                        revalidate();
                        repaint();
                        dado2.setIcon(imageDado);
                    }
                    if (dado == 3) {
                        panelActivos.remove(dado5);
                        panelUtilizados.add(dado5);
                        revalidate();
                        repaint();
                        dado3.setIcon(imageDado);
                    }
                    if (dado == 1) {
                        panelActivos.remove(dado5);
                        panelUtilizados.add(dado5);
                        revalidate();
                        repaint();
                        dado1.setIcon(imageDado);
                    }
                    if (dado == 6) {
                        panelActivos.remove(dado5);
                        panelUtilizados.add(dado5);
                        revalidate();
                        repaint();
                        dado6.setIcon(imageDado);
                    }
                    if (dado == 7) {
                        panelActivos.remove(dado5);
                        panelUtilizados.add(dado5);
                        revalidate();
                        repaint();
                        dado7.setIcon(imageDado);
                    }
                }
            }
            if (e.getSource() == dado6) {
                int[] caraDados = modelGeek.getCaras();
                if (caraDados[3] == 3) {
                    panelActivos.remove(dado6);
                    panelUtilizados.add(dado6);

                    int dado = partida.dadoSelec();

                    if (dado == 2) {
                        panelActivos.remove(dado6);
                        panelUtilizados.add(dado6);
                        revalidate();
                        repaint();
                        dado2.setIcon(imageDado);
                    }
                    if (dado == 3) {
                        panelActivos.remove(dado6);
                        panelUtilizados.add(dado6);
                        revalidate();
                        repaint();
                        dado3.setIcon(imageDado);
                    }
                    if (dado == 1) {
                        panelActivos.remove(dado6);
                        panelUtilizados.add(dado6);
                        revalidate();
                        repaint();
                        dado1.setIcon(imageDado);
                    }
                    if (dado == 5) {
                        panelActivos.remove(dado6);
                        panelUtilizados.add(dado6);
                        revalidate();
                        repaint();
                        dado5.setIcon(imageDado);
                    }
                    if (dado == 7) {
                        panelActivos.remove(dado6);
                        panelUtilizados.add(dado6);
                        revalidate();
                        repaint();
                        dado7.setIcon(imageDado);
                    }
                }
            }
            if (e.getSource() == dado7) {

                int[] caraDados = modelGeek.getCaras();
                if (caraDados[3] == 3) {
                    panelActivos.remove(dado4);
                    panelUtilizados.add(dado4);

                    int dado = partida.dadoSelec();

                    if (dado == 2) {
                        panelActivos.remove(dado7);
                        panelUtilizados.add(dado7);
                        revalidate();
                        repaint();
                        dado2.setIcon(imageDado);
                    }
                    if (dado == 3) {
                        panelActivos.remove(dado7);
                        panelUtilizados.add(dado7);
                        revalidate();
                        repaint();
                        dado3.setIcon(imageDado);
                    }
                    if (dado == 1) {
                        panelActivos.remove(dado7);
                        panelUtilizados.add(dado7);
                        revalidate();
                        repaint();
                        dado1.setIcon(imageDado);
                    }
                    if (dado == 5) {
                        panelActivos.remove(dado7);
                        panelUtilizados.add(dado7);
                        revalidate();
                        repaint();
                        dado5.setIcon(imageDado);
                    }
                    if (dado == 6) {
                        panelActivos.remove(dado7);
                        panelUtilizados.add(dado7);
                        revalidate();
                        repaint();
                        dado6.setIcon(imageDado);
                    }
                }
            }

//----------------Se activa el poder del cohete-------------------------------------------------------------------------
            if (e.getSource() == dado1) {
                int[] caraDados = modelGeek.getCaras();
                if (caraDados[0] == 4) {
                    int dado = partida.dadoSelecS();
                    if (dado == 2) {
                        panelActivos.remove(dado1);
                        panelUtilizados.add(dado1);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado2);
                        panelInactivos.add(dado2);
                    }
                    if (dado == 3) {
                        panelActivos.remove(dado1);
                        panelUtilizados.add(dado1);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado3);
                        panelInactivos.add(dado3);
                    }
                    if (dado == 4) {
                        panelActivos.remove(dado1);
                        panelUtilizados.add(dado1);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado4);
                        panelInactivos.add(dado4);
                    }
                    if (dado == 5) {
                        panelActivos.remove(dado1);
                        panelUtilizados.add(dado1);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado5);
                        panelInactivos.add(dado5);
                    }
                    if (dado == 6) {
                        panelActivos.remove(dado1);
                        panelUtilizados.add(dado1);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado6);
                        panelInactivos.add(dado6);
                    }
                    if (dado == 7) {
                        panelActivos.remove(dado1);
                        panelUtilizados.add(dado1);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado7);
                        panelInactivos.add(dado7);
                    }
                }
            }
            if (e.getSource() == dado2) {
                int[] caraDados = modelGeek.getCaras();
                if (caraDados[1] == 4) {
                    int dado = partida.dadoSelecS();
                    if (dado == 1) {
                        panelActivos.remove(dado2);
                        panelUtilizados.add(dado2);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado1);
                        panelInactivos.add(dado1);
                    }
                    if (dado == 3) {
                        panelActivos.remove(dado2);
                        panelUtilizados.add(dado2);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado3);
                        panelInactivos.add(dado3);
                    }
                    if (dado == 4) {
                        panelActivos.remove(dado2);
                        panelUtilizados.add(dado2);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado4);
                        panelInactivos.add(dado4);
                    }
                    if (dado == 5) {
                        panelActivos.remove(dado2);
                        panelUtilizados.add(dado2);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado5);
                        panelInactivos.add(dado5);
                    }
                    if (dado == 6) {
                        panelActivos.remove(dado2);
                        panelUtilizados.add(dado2);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado6);
                        panelInactivos.add(dado6);
                    }
                    if (dado == 7) {
                        panelActivos.remove(dado2);
                        panelUtilizados.add(dado2);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado7);
                        panelInactivos.add(dado7);
                    }

                }
            }
            if (e.getSource() == dado3) {
                int[] caraDados = modelGeek.getCaras();
                if (caraDados[2] == 4) {
                    int dado = partida.dadoSelecS();
                    if (dado == 1) {
                        panelActivos.remove(dado3);
                        panelUtilizados.add(dado3);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado1);
                        panelInactivos.add(dado1);
                    }
                    if (dado == 4) {
                        panelActivos.remove(dado3);
                        panelUtilizados.add(dado3);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado4);
                        panelInactivos.add(dado4);
                    }
                    if (dado == 2) {
                        panelActivos.remove(dado3);
                        panelUtilizados.add(dado3);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado2);
                        panelInactivos.add(dado2);
                    }
                    if (dado == 5) {
                        panelActivos.remove(dado3);
                        panelUtilizados.add(dado3);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado5);
                        panelInactivos.add(dado5);
                    }
                    if (dado == 6) {
                        panelActivos.remove(dado3);
                        panelUtilizados.add(dado3);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado6);
                        panelInactivos.add(dado6);
                    }
                    if (dado == 7) {
                        panelActivos.remove(dado3);
                        panelUtilizados.add(dado3);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado7);
                        panelInactivos.add(dado7);
                    }

                }
            }
            if (e.getSource() == dado4) {
                int[] caraDados = modelGeek.getCaras();
                if (caraDados[3] == 4) {
                    int dado = partida.dadoSelecS();
                    if (dado == 1) {
                        panelActivos.remove(dado4);
                        panelUtilizados.add(dado4);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado1);
                        panelInactivos.add(dado1);
                    }
                    if (dado == 3) {
                        panelActivos.remove(dado4);
                        panelUtilizados.add(dado4);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado3);
                        panelInactivos.add(dado3);
                    }
                    if (dado == 2) {
                        panelActivos.remove(dado4);
                        panelUtilizados.add(dado4);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado2);
                        panelInactivos.add(dado2);
                    }
                    if (dado == 5) {
                        panelActivos.remove(dado4);
                        panelUtilizados.add(dado4);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado5);
                        panelInactivos.add(dado5);
                    }
                    if (dado == 6) {
                        panelActivos.remove(dado4);
                        panelUtilizados.add(dado4);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado6);
                        panelInactivos.add(dado6);
                    }
                    if (dado == 7) {
                        panelActivos.remove(dado4);
                        panelUtilizados.add(dado4);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado7);
                        panelInactivos.add(dado7);
                    }

                }
            }
            if (e.getSource() == dado5) {
                int[] caraDados = modelGeek.getCaras();
                if (caraDados[4] == 4) {
                    int dado = partida.dadoSelecS();
                    if (dado == 2) {
                        panelActivos.remove(dado5);
                        panelUtilizados.add(dado5);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado2);
                        panelInactivos.add(dado2);
                    }
                    if (dado == 3) {
                        panelActivos.remove(dado5);
                        panelUtilizados.add(dado5);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado3);
                        panelInactivos.add(dado3);
                    }
                    if (dado == 4) {
                        panelActivos.remove(dado5);
                        panelUtilizados.add(dado5);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado4);
                        panelInactivos.add(dado4);
                    }
                    if (dado == 1) {
                        panelActivos.remove(dado5);
                        panelUtilizados.add(dado5);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado1);
                        panelInactivos.add(dado1);
                    }
                    if (dado == 6) {
                        panelActivos.remove(dado5);
                        panelUtilizados.add(dado5);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado6);
                        panelInactivos.add(dado6);
                    }
                    if (dado == 7) {
                        panelActivos.remove(dado5);
                        panelUtilizados.add(dado5);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado7);
                        panelInactivos.add(dado7);
                    }
                }
            }
            if (e.getSource() == dado6) {
                int[] caraDados = modelGeek.getCaras();
                if (caraDados[5] == 4) {
                    int dado = partida.dadoSelecS();
                    if (dado == 2) {
                        panelActivos.remove(dado6);
                        panelUtilizados.add(dado6);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado2);
                        panelInactivos.add(dado2);
                    }
                    if (dado == 3) {
                        panelActivos.remove(dado6);
                        panelUtilizados.add(dado6);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado3);
                        panelInactivos.add(dado3);
                    }
                    if (dado == 4) {
                        panelActivos.remove(dado6);
                        panelUtilizados.add(dado6);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado4);
                        panelInactivos.add(dado4);
                    }
                    if (dado == 5) {
                        panelActivos.remove(dado6);
                        panelUtilizados.add(dado6);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado5);
                        panelInactivos.add(dado5);
                    }
                    if (dado == 1) {
                        panelActivos.remove(dado6);
                        panelUtilizados.add(dado6);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado1);
                        panelInactivos.add(dado1);
                    }
                    if (dado == 7) {
                        panelActivos.remove(dado6);
                        panelUtilizados.add(dado6);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado7);
                        panelInactivos.add(dado7);
                    }
                }

            }
            if (e.getSource() == dado7) {
                int[] caraDados = modelGeek.getCaras();
                if (caraDados[6] == 4) {
                    int dado = partida.dadoSelecS();
                    if (dado == 2) {
                        panelActivos.remove(dado7);
                        panelUtilizados.add(dado7);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado2);
                        panelInactivos.add(dado2);
                    }
                    if (dado == 3) {
                        panelActivos.remove(dado7);
                        panelUtilizados.add(dado7);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado3);
                        panelInactivos.add(dado3);
                    }
                    if (dado == 4) {
                        panelActivos.remove(dado7);
                        panelUtilizados.add(dado7);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado4);
                        panelInactivos.add(dado4);
                    }
                    if (dado == 5) {
                        panelActivos.remove(dado7);
                        panelUtilizados.add(dado7);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado5);
                        panelInactivos.add(dado5);
                    }
                    if (dado == 6) {
                        panelActivos.remove(dado7);
                        panelUtilizados.add(dado7);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado6);
                        panelInactivos.add(dado6);
                    }
                    if (dado == 1) {
                        panelActivos.remove(dado7);
                        panelUtilizados.add(dado7);
                        repaint();
                        revalidate();
                        panelActivos.remove(dado1);
                        panelInactivos.add(dado1);
                    }

                }

            }
//----------------Se activa el poder del superHeroe---------------------------------------------------------------------
            if (e.getSource() == dado1) {
                int[] caraDados = modelGeek.getCaras();
                if (caraDados[0] == 5) {
                    panelActivos.remove(dado1);
                    panelUtilizados.add(dado1);
                    revalidate();
                    repaint();
                    Dado dado = new Dado();
                    Dado dadoSeleccionado = new Dado();
                    partida.activarSuperHeroe(dado, dadoSeleccionado);
                }
            }
            if (e.getSource() == dado2) {
                int[] caraDados = modelGeek.getCaras();
                if (caraDados[1] == 5) {
                    panelActivos.remove(dado2);
                    panelUtilizados.add(dado2);
                    revalidate();
                    repaint();
                    Dado dado = new Dado();
                    Dado dadoSeleccionado = new Dado();
                    partida.activarSuperHeroe(dado, dadoSeleccionado);
                }

            }
            if (e.getSource() == dado3) {
                int[] caraDados = modelGeek.getCaras();
                if (caraDados[2] == 5) {
                    panelActivos.remove(dado3);
                    panelUtilizados.add(dado3);
                    revalidate();
                    repaint();
                    Dado dado = new Dado();
                    Dado dadoSeleccionado = new Dado();
                    partida.activarSuperHeroe(dado, dadoSeleccionado);
                }
            }
            if (e.getSource() == dado4) {
                int[] caraDados = modelGeek.getCaras();
                if (caraDados[3] == 5) {
                    panelActivos.remove(dado4);
                    panelUtilizados.add(dado4);
                    revalidate();
                    repaint();
                    Dado dado = new Dado();
                    Dado dadoSeleccionado = new Dado();
                    partida.activarSuperHeroe(dado, dadoSeleccionado);

                }
            }
            if (e.getSource() == dado5) {
                int[] caraDados = modelGeek.getCaras();
                if (caraDados[4] == 5) {
                    panelActivos.remove(dado5);
                    panelUtilizados.add(dado5);
                    revalidate();
                    repaint();
                    Dado dado = new Dado();
                    Dado dadoSeleccionado = new Dado();
                    partida.activarSuperHeroe(dado, dadoSeleccionado);

                }
            }
            if (e.getSource() == dado6) {
                int[] caraDados = modelGeek.getCaras();
                if (caraDados[5] == 5) {
                    panelActivos.remove(dado6);
                    panelUtilizados.add(dado6);
                    revalidate();
                    repaint();
                    Dado dado = new Dado();
                    Dado dadoSeleccionado = new Dado();
                    partida.activarSuperHeroe(dado, dadoSeleccionado);

                }

            }
            if (e.getSource() == dado7) {
                int[] caraDados = modelGeek.getCaras();
                if (caraDados[6] == 5) {
                    panelActivos.remove(dado7);
                    panelUtilizados.add(dado7);
                    revalidate();
                    repaint();
                    Dado dado = new Dado();
                    Dado dadoSeleccionado = new Dado();
                    partida.activarSuperHeroe(dado, dadoSeleccionado);

                }

            }

//----------------Se activa el poder del corazon------------------------------------------------------------------------
            if (e.getSource() == dado1) {
                int[] caraDados = modelGeek.getCaras();
                if (caraDados[0] == 1) {
                    panelActivos.remove(dado1);
                    panelUtilizados.add(dado1);
                    revalidate();
                    repaint();
                    Dado dado = new Dado();
                    Dado dadoSeleccionado = new Dado();
                    partida.activarCorazon(dado, dadoSeleccionado);

                }

            }
            if (e.getSource() == dado2) {
                int[] caraDados = modelGeek.getCaras();
                if (caraDados[1] == 1) {
                    panelActivos.remove(dado2);
                    panelUtilizados.add(dado2);
                    revalidate();
                    repaint();
                    Dado dado = new Dado();
                    Dado dadoSeleccionado = new Dado();
                    partida.activarCorazon(dado, dadoSeleccionado);

                }

            }
            if (e.getSource() == dado3) {
                int[] caraDados = modelGeek.getCaras();
                if (caraDados[2] == 1) {
                    panelActivos.remove(dado3);
                    panelUtilizados.add(dado3);
                    revalidate();
                    repaint();
                    Dado dado = new Dado();
                    Dado dadoSeleccionado = new Dado();
                    partida.activarCorazon(dado, dadoSeleccionado);

                }

            }
            if (e.getSource() == dado4) {
                int[] caraDados = modelGeek.getCaras();
                if (caraDados[3] == 1) {
                    panelActivos.remove(dado4);
                    panelUtilizados.add(dado4);
                    revalidate();
                    repaint();
                    Dado dado = new Dado();
                    Dado dadoSeleccionado = new Dado();
                    partida.activarCorazon(dado, dadoSeleccionado);

                }

            }
            if (e.getSource() == dado5) {
                int[] caraDados = modelGeek.getCaras();
                if (caraDados[4] == 1) {
                    panelActivos.remove(dado5);
                    panelUtilizados.add(dado5);
                    revalidate();
                    repaint();
                    Dado dado = new Dado();
                    Dado dadoSeleccionado = new Dado();
                    partida.activarCorazon(dado, dadoSeleccionado);

                }

            }
            if (e.getSource() == dado6) {
                int[] caraDados = modelGeek.getCaras();
                if (caraDados[5] == 1) {
                    panelActivos.remove(dado6);
                    panelUtilizados.add(dado6);
                    revalidate();
                    repaint();
                    Dado dado = new Dado();
                    Dado dadoSeleccionado = new Dado();
                    partida.activarCorazon(dado, dadoSeleccionado);

                }

            }
            if (e.getSource() == dado7) {
                int[] caraDados = modelGeek.getCaras();
                if (caraDados[6] == 1) {
                    panelActivos.remove(dado7);
                    panelUtilizados.add(dado7);
                    revalidate();
                    repaint();
                    Dado dado = new Dado();
                    Dado dadoSeleccionado = new Dado();
                    partida.activarCorazon(dado, dadoSeleccionado);
                }

            }

//----------------------------------------Fin---------------------------------------------------------------------------
        }
    }
}



















































































