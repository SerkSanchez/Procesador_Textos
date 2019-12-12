import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ventana extends JFrame implements ItemListener, ActionListener {

    JMenuBar barraMenu;
    JMenu menuArchivo, menuEdicion,menuEstilo;
    JMenuItem menuItemNew, menuItemOpen, menuItemClose,menuItemSave,menuItemSaveAs,menuItemPrint;
    JMenuItem menuItemCopy,menuItemCut,menuItemPaste,menuItemBold,menuItemNormal,menuItemCursiva;

    JPopupMenu popupMenu;

    JButton boton_New,boton_Open,boton_Save,boton_Print,boton_Copy,boton_Cut,boton_Paste,boton_Bold;
    JButton boton_CopyPop,boton_CutPop,boton_PastePop;

    JComboBox comboLetra, comboTamanio;
    DefaultComboBoxModel modeloLetra,modeloTamanio;

    JLabel labelLetra, labelTamanio;

    JPanel panelSuperior,panelCentro;

    JTextArea textArea;

    JFileChooser fileChooser;

    public void initGUI(){
        instancias();
        configurarBarraMenu();
        configurarPanel();
        rellenarTamanio();
        rellenarLetras();
        rellenarPopUp();
        this.setSize(new Dimension(1200,600));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        acciones();
    }

    private void instancias() {
        barraMenu = new JMenuBar();
        menuArchivo = new JMenu("Archivo");
        menuEdicion = new JMenu("Edición");
        menuEstilo = new JMenu("Estilo de fuente");
        menuItemNew = new JMenuItem("Nuevo");
        menuItemNew.setIcon(new ImageIcon(getClass().getResource("/recursos/new.png")));
        menuItemOpen = new JMenuItem("Abrir");
        menuItemOpen.setIcon(new ImageIcon(getClass().getResource("/recursos/open.png")));
        menuItemClose = new JMenuItem("Cerrar");
        menuItemClose.setIcon(new ImageIcon(getClass().getResource("/recursos/close.png")));
        menuItemSave = new JMenuItem("Guardar");
        menuItemSave.setIcon(new ImageIcon(getClass().getResource("/recursos/save.png")));
        menuItemSaveAs = new JMenuItem("Cuardar Como");
        menuItemPrint = new JMenuItem("Imprimir");
        menuItemPrint.setIcon(new ImageIcon(getClass().getResource("/recursos/new.png")));
        menuItemCopy = new JMenuItem("Copiar");
        menuItemCopy.setIcon(new ImageIcon(getClass().getResource("/recursos/copy.png")));
        menuItemCut = new JMenuItem("Cortar");
        menuItemCut.setIcon(new ImageIcon(getClass().getResource("/recursos/cut.png")));
        menuItemPaste = new JMenuItem("Pegar");
        menuItemPaste.setIcon(new ImageIcon(getClass().getResource("/recursos/paste.png")));
        menuItemBold = new JMenuItem("Bold");
        menuItemBold.setIcon(new ImageIcon(getClass().getResource("/recursos/bold.png")));
        menuItemNormal = new JMenuItem("Normal");
        menuItemNormal.setIcon(new ImageIcon(getClass().getResource("/recursos/normal.png")));
        menuItemCursiva = new JMenuItem("Cursiva");
        menuItemCursiva.setIcon(new ImageIcon(getClass().getResource("/recursos/italic.png")));

        boton_New = new JButton();
        boton_New.setIcon(new ImageIcon(getClass().getResource("/recursos/new.png")));
        boton_Open = new JButton();
        boton_Open.setIcon(new ImageIcon(getClass().getResource("/recursos/open.png")));
        boton_Save = new JButton();
        boton_Save.setIcon(new ImageIcon(getClass().getResource("/recursos/save.png")));
        boton_Print = new JButton();
        boton_Print.setIcon(new ImageIcon(getClass().getResource("/recursos/new.png")));
        boton_Copy = new JButton();
        boton_Copy.setIcon(new ImageIcon(getClass().getResource("/recursos/copy.png")));
        boton_Cut = new JButton();
        boton_Cut.setIcon(new ImageIcon(getClass().getResource("/recursos/cut.png")));
        boton_Paste = new JButton();
        boton_Paste.setIcon(new ImageIcon(getClass().getResource("/recursos/paste.png")));
        boton_Bold = new JButton();
        boton_Bold.setIcon(new ImageIcon(getClass().getResource("/recursos/bold.png")));
        boton_CopyPop = new JButton("Copiar");
        boton_CopyPop.setIcon(new ImageIcon(getClass().getResource("/recursos/copy.png")));
        boton_CutPop = new JButton("Cortar");
        boton_CutPop.setIcon(new ImageIcon(getClass().getResource("/recursos/cut.png")));
        boton_PastePop = new JButton("Pegar");
        boton_PastePop.setIcon(new ImageIcon(getClass().getResource("/recursos/paste.png")));

        popupMenu = new JPopupMenu();

        modeloLetra = new DefaultComboBoxModel();
        modeloTamanio = new DefaultComboBoxModel();

        comboLetra = new JComboBox(modeloLetra);
        comboTamanio = new JComboBox(modeloTamanio);

        labelLetra = new JLabel("Estilo");
        labelTamanio = new JLabel("Tipo");

        panelCentro = new JPanel();
        panelSuperior = new JPanel();

        fileChooser = new JFileChooser();
        labelLetra = new JLabel("Tipo de Letra");
        labelTamanio = new JLabel("Tamaño de Letra");
        textArea = new JTextArea();
    }

    private void configurarBarraMenu() {
        barraMenu.add(menuArchivo);
        menuArchivo.add(menuItemNew);
        menuArchivo.add(menuItemOpen);
        menuArchivo.add(menuItemClose);
        menuArchivo.add(menuItemSave);
        menuArchivo.add(menuItemSaveAs);
        menuArchivo.addSeparator();
        menuArchivo.add(menuItemPrint);

        barraMenu.add(menuEdicion);
        menuEdicion.add(menuItemCopy);
        menuEdicion.add(menuItemCut);
        menuEdicion.add(menuItemPaste);
        menuEdicion.addSeparator();
        menuEdicion.add(menuEstilo);

        menuEstilo.add(menuItemBold);
        menuEstilo.add(menuItemNormal);
        menuEstilo.add(menuItemCursiva);

        this.setJMenuBar(barraMenu);
    }

    private void rellenarPopUp(){
        popupMenu.add(boton_CopyPop);
        popupMenu.add(boton_CutPop);
        popupMenu.add(boton_PastePop);

        textArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton()==MouseEvent.BUTTON3){
                    popupMenu.show(textArea,10,50);
                    setVisible(true);
                }
            }
        });
    }

    private void configurarPanel() {
        this.setLayout(new BorderLayout());
        this.add(configurarSuperior(),BorderLayout.NORTH);
        this.add(textArea,BorderLayout.CENTER);
    }

    private void configurarGridBag(int pX, int pY, int tX, int tY,double peX, double peY, int anc, int fill, JComponent component) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = pX;
        constraints.gridy = pY;
        constraints.gridwidth = tX;
        constraints.gridheight = tY;
        constraints.weightx = peX;
        constraints.weighty = peY;
        constraints.fill = fill;
        constraints.anchor = anc;
        panelSuperior.add(component,constraints);
    }

    private JPanel configurarSuperior() {
        panelSuperior.setLayout(new GridBagLayout());
        configurarGridBag(0,0,1,1,0,0.2, GridBagConstraints.CENTER,
                GridBagConstraints.WEST, boton_New);
        configurarGridBag(1,0,1,1,0,0.2, GridBagConstraints.CENTER,
                GridBagConstraints.WEST, boton_Open);
        configurarGridBag(2,0,1,1,0,0.2, GridBagConstraints.CENTER,
                GridBagConstraints.WEST, boton_Save);
        configurarGridBag(3,0,1,1,0,0.2, GridBagConstraints.CENTER,
                GridBagConstraints.WEST, boton_Print);
        configurarGridBag(4,0,1,1,0,0.2, GridBagConstraints.CENTER,
                GridBagConstraints.WEST, boton_Copy);
        configurarGridBag(5,0,1,1,0,0.2, GridBagConstraints.CENTER,
                GridBagConstraints.WEST, boton_Cut);
        configurarGridBag(6,0,1,1,0,0.2, GridBagConstraints.CENTER,
                GridBagConstraints.WEST, boton_Paste);
        configurarGridBag(7,0,1,1,0,0.2, GridBagConstraints.CENTER,
                GridBagConstraints.WEST, boton_Bold);
        configurarGridBag(8,0,1,1,0,0.2, GridBagConstraints.CENTER,
                GridBagConstraints.WEST, labelLetra);
        configurarGridBag(9,0,1,1,0,0.2, GridBagConstraints.CENTER,
                GridBagConstraints.WEST, comboLetra);
        configurarGridBag(10,0,1,1,0,0.2, GridBagConstraints.CENTER,
                GridBagConstraints.WEST, labelTamanio);
        configurarGridBag(11,0,1,1,0,0.2, GridBagConstraints.CENTER,
                GridBagConstraints.WEST, comboTamanio);
        return panelSuperior;
    }
    private void rellenarTamanio() {
        for (int i = 8; i <= 100; i++) {
            modeloTamanio.addElement(i);
        }
    }
    private void rellenarLetras() {
        Font[] fuentes = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getAllFonts();
        for (Font item : fuentes) {
            modeloLetra.addElement(item.getName());
        }
    }

    private void acciones(){
        comboLetra.addItemListener(this);
        comboTamanio.addItemListener(this);
        menuItemNew.addActionListener(this);
        menuItemOpen.addActionListener(this);
        menuItemClose.addActionListener(this);
        menuItemSave.addActionListener(this);
        menuItemBold.addActionListener(this);
        menuItemNormal.addActionListener(this);
        boton_New.addActionListener(this);
        boton_Open.addActionListener(this);
        boton_Save.addActionListener(this);
        boton_CutPop.addActionListener(this);
        boton_CopyPop.addActionListener(this);
        boton_PastePop.addActionListener(this);
        boton_Bold.addActionListener(this);
    }

    private void cambiarLetras() {
        Font fuente = new Font((String) modeloLetra.getSelectedItem(),
                comboTamanio.getSelectedIndex(),
                (int) modeloTamanio.getSelectedItem());
        textArea.setFont(fuente);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == comboLetra) {
            cambiarLetras();
        } else if (e.getSource() == comboTamanio) {
            cambiarLetras();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuItemOpen) {
            fileChooser.showOpenDialog(this);
        }else if (e.getSource()==boton_Open) {
            fileChooser.showOpenDialog(this);
        }else if (e.getSource()==boton_Save) {
            fileChooser.showSaveDialog(this);
        }else if (e.getSource()==menuItemSave){
            fileChooser.showSaveDialog(this);
        }else if (e.getSource()==menuItemNew){
            textArea.setText("");
        }else if (e.getSource()==boton_New){
            textArea.setText("");
        }else if (e.getSource()==menuItemClose){
            setVisible(false);
        }else if (e.getSource()==boton_Bold) {
            Font negrita = new Font((String) modeloLetra.getSelectedItem(), Font.BOLD, (int) modeloTamanio.getSelectedItem());
            textArea.setFont(negrita);
        }else if (e.getSource()==menuItemBold) {
            Font negrita = new Font((String) modeloLetra.getSelectedItem(), Font.BOLD, (int) modeloTamanio.getSelectedItem());
            textArea.setFont(negrita);
        }else if (e.getSource()==boton_CopyPop){
            textArea.getSelectedText();
        }else if (e.getSource()==boton_PastePop){
            textArea.getSelectedText();
        }else if (e.getSource()==boton_CutPop){
            textArea.getSelectedText();
            textArea.setText("");
        }else if (e.getSource()==menuItemSaveAs){
            fileChooser.showSaveDialog(this);
        }else if (e.getSource()==menuItemNormal){
            Font normal = new Font((String) modeloLetra.getSelectedItem(),Font.PLAIN ,(int) modeloTamanio.getSelectedItem());
            textArea.setFont(normal);
        }else if (e.getSource()== menuItemCursiva){
            Font normal = new Font((String) modeloLetra.getSelectedItem(),Font.ITALIC ,(int) modeloTamanio.getSelectedItem());
            textArea.setFont(normal);
        }
    }
}