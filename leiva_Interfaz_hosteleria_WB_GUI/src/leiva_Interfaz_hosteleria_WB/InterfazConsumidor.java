package leiva_Interfaz_hosteleria_WB;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

import org.w3c.dom.Document;

import javax.swing.JSpinner;

public class InterfazConsumidor extends JFrame implements ItemListener {

	private static ArrayList<ArrayList<String>> nReservas = new ArrayList<ArrayList<String>>();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTextField textField;
	JTextField textField_1;

	JComboBox<String> reservas = new JComboBox<String>();
	JComboBox<Integer> personas = new JComboBox<Integer>();
	JComboBox<String> tipoCocina = new JComboBox<String>();

	JLabel Lb_nJornadas = new JLabel("Número de jornadas");
	JComboBox<Integer> cb_nJornadas = new JComboBox<Integer>();
	JLabel Lb_Habitaciones = new JLabel("Habitaciones");
	JCheckBox checkBox_No = new JCheckBox("No");
	JCheckBox checkBox_Si = new JCheckBox("Si");

	JLabel Lb_tipoMesa = new JLabel("Tipo de mesa");
	JLabel Lb_pMesa = new JLabel("Personas por mesa");
	JComboBox<String> cb_tipoMesa = new JComboBox<String>();
	JComboBox<Integer> cb_pMesa = new JComboBox<Integer>();

	JDateChooser fecha;

	JSpinner spinner = new JSpinner();

	String tipoReservaElegido = "Banquete";
	int nPersonasElegidas = 0;
	String tipoCocinaElegido = "";

	JButton btnReserva;

	/**
	 * Create the frame.
	 */
	public InterfazConsumidor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 2, 0, 0));

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(
				"C:\\Users\\christian.leiva.AULAS\\Documents\\Desarrollo_Interfaces\\leiva_Interfaz_hosteleria_WB\\src\\prueba2.jpg"));
		contentPane.add(lblNewLabel, gbc);

		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(8, 1, 0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 1, 0, 0));

		JLabel lblNewLabel_1 = new JLabel("Salón Habana");
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1);
		panel_1.setBackground(new Color(249, 228, 183));

		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(2, 1, 20, 0));

		JLabel lblNewLabel_4 = new JLabel("Fecha");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		panel_4.add(lblNewLabel_4);

		fecha = new JDateChooser();

		panel_4.add(fecha);
		panel_4.setBackground(new Color(249, 228, 183));
		panel_4.setBorder(new EmptyBorder(10, 10, 10, 10));

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(3, 3, 20, 0));

		JLabel lblNewLabel_3 = new JLabel("Nombre");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		panel_3.add(lblNewLabel_3);

		JLabel lblNewLabel_2 = new JLabel("Teléfono");
		panel_3.add(lblNewLabel_2);

		textField = new JTextField();
		textField.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.add(textField_1);
		textField_1.setColumns(10);

		panel_2.setBackground(new Color(249, 228, 183));
		panel_3.setBackground(new Color(249, 228, 183));

		panel_2.setBorder(new EmptyBorder(10, 10, 10, 10));

		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6);
		panel_6.setLayout(new GridLayout(3, 3, 20, 0));

		panel_5.setBackground(new Color(249, 228, 183));
		panel_6.setBackground(new Color(249, 228, 183));

		JLabel lblNewLabel_5 = new JLabel("Tipo reserva");

		panel_6.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Personas");
		panel_6.add(lblNewLabel_6);

		reservas.addItem("Banquete");
		reservas.addItem("Jornada");
		reservas.addItem("Congreso");
		panel_6.add(reservas);

		personas.setMaximumRowCount(5);
		for (int i = 1; i <= 50; i++) {
			personas.addItem(i);
		}
		panel_6.add(personas);

		panel_6.setBorder(new EmptyBorder(10, 10, 10, 10));

		JPanel panel_7 = new JPanel();
		panel.add(panel_7);
		panel_7.setLayout(new GridLayout(3, 1, 0, 0));

		panel_7.setBackground(new Color(249, 228, 183));

		JLabel lblNewLabel_7 = new JLabel("Tipo Cocina");
		panel_7.add(lblNewLabel_7);

		tipoCocina.addItem("Bufet");
		tipoCocina.addItem("Carta");
		tipoCocina.addItem("Cita con chef");
		tipoCocina.addItem("No precisa");
		panel_7.add(tipoCocina);

		panel_7.setBorder(new EmptyBorder(10, 10, 10, 10));

		JPanel panel_8 = new JPanel();
		panel.add(panel_8);
		panel_8.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel_9 = new JPanel();
		panel_8.add(panel_9);
		panel_9.setLayout(new GridLayout(3, 2, 0, 0));

		panel_9.setBackground(new Color(249, 228, 183));

		Lb_nJornadas.setVisible(true);
		panel_9.add(Lb_nJornadas);

		for (int i = 1; i <= 50; i++) {
			cb_nJornadas.addItem(i);
		}
		cb_nJornadas.setMaximumRowCount(5);
		cb_nJornadas.setVisible(true);
		panel_9.add(cb_nJornadas);

		Lb_Habitaciones.setVisible(true);

		panel_9.add(Lb_Habitaciones);

		JPanel panel_10 = new JPanel();

		panel_9.add(panel_10);
		checkBox_No.setBackground(new Color(249, 228, 183));

		checkBox_No.setHorizontalAlignment(SwingConstants.LEFT);
		checkBox_No.setVisible(true);
		checkBox_Si.setBackground(new Color(249, 228, 183));

		checkBox_Si.setVisible(true);
		panel_10.setLayout(new GridLayout(1, 2, 0, 0));
		panel_10.setBackground(new Color(249, 228, 183));
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(checkBox_Si);
		buttonGroup.add(checkBox_No);
		panel_10.add(checkBox_Si);
		panel_10.add(checkBox_No);
		panel_9.setBorder(new EmptyBorder(10, 10, 10, 10));

		spinner.setVisible(false);
		panel_9.add(spinner);

		JPanel panel_11 = new JPanel();
		panel.add(panel_11);
		panel_11.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel_12 = new JPanel();
		panel_11.add(panel_12);
		panel_12.setLayout(new GridLayout(3, 3, 20, 0));

		panel_12.add(Lb_tipoMesa);
		Lb_tipoMesa.setVisible(true);

		panel_12.add(Lb_pMesa);
		Lb_pMesa.setVisible(true);

		panel_12.add(cb_tipoMesa);
		cb_tipoMesa.addItem("Rectangular");
		cb_tipoMesa.addItem("Redonda");
		cb_tipoMesa.setVisible(true);
		cb_pMesa.setMaximumRowCount(5);

		panel_12.add(cb_pMesa);
		for (int i = 1; i <= 50; i++) {
			cb_pMesa.addItem(i);
		}
		cb_pMesa.setVisible(true);

		panel_12.setBorder(new EmptyBorder(10, 10, 10, 10));

		JPanel panel_13 = new JPanel();
		panel.add(panel_13);
		panel_13.setLayout(new GridLayout(1, 1, 0, 0));

		btnReserva = new JButton("Reservar");
		panel_13.add(btnReserva);

		panel_13.setBorder(new EmptyBorder(20, 20, 20, 20));

		panel_11.setBackground(new Color(249, 228, 183));
		panel_12.setBackground(new Color(249, 228, 183));
		panel_13.setBackground(new Color(249, 228, 183));

		Lb_nJornadas.setEnabled(false);
		cb_nJornadas.setEnabled(false);
		Lb_Habitaciones.setEnabled(false);
		checkBox_No.setEnabled(false);
		checkBox_Si.setEnabled(false);
		Lb_tipoMesa.setEnabled(false);
		Lb_pMesa.setEnabled(false);
		cb_tipoMesa.setEnabled(false);
		cb_pMesa.setEnabled(false);

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
	    if (e.getSource() == reservas) {
	        tipoReservaElegido = reservas.getSelectedItem().toString();
	    }

	    if (e.getSource() == personas) {
	        nPersonasElegidas = Integer.parseInt(personas.getSelectedItem().toString());
	    }

	    if (e.getSource() == tipoCocina) {
	        tipoCocinaElegido = tipoCocina.getSelectedItem().toString();
	    }
	}

	public void manejarItemsListeners() {

		
		
		btnReserva.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tipoReservaElegido = reservas.getSelectedItem().toString();
				nReservas.add(guardarReserva());
				DOM d = new DOM();
				Document doc = d.initWriteDOM();
				d.rootWrite(doc, nReservas);
				d.createXML(doc);
				  

			}
		});

		reservas.setSelectedItem("Jornada");

		reservas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if ("Congreso".equals(reservas.getSelectedItem())) {
					// Si se selecciona "Opción 1", muestra el nuevo componente

					Lb_tipoMesa.setEnabled(false);
					Lb_pMesa.setEnabled(false);
					cb_tipoMesa.setEnabled(false);
					cb_pMesa.setEnabled(false);
				} else {

					Lb_tipoMesa.setEnabled(true);
					Lb_pMesa.setEnabled(true);
					cb_tipoMesa.setEnabled(true);
					cb_pMesa.setEnabled(true);
				}

				if ("Banquete".equals(reservas.getSelectedItem())) {

					Lb_nJornadas.setEnabled(false);
					cb_nJornadas.setEnabled(false);
					Lb_Habitaciones.setEnabled(false);
					checkBox_No.setEnabled(false);
					checkBox_Si.setEnabled(false);

				} else {

					Lb_nJornadas.setEnabled(true);
					cb_nJornadas.setEnabled(true);
					Lb_Habitaciones.setEnabled(true);
					checkBox_No.setEnabled(true);
					checkBox_Si.setEnabled(true);

				}
			}

		});
		
		

	}

	public ArrayList<String> guardarReserva() {

		ArrayList<String> rCongreso = new ArrayList<String>();

		rCongreso.add("nombre:" + textField.getText());
		rCongreso.add("fechaEvento:" + obtenerFechaSeleccionada(fecha));
		rCongreso.add("telefono:" + textField_1.getText());
		rCongreso.add("tipoReserva:" + reservas.getSelectedItem().toString());
		rCongreso.add("personas:" + personas.getSelectedItem().toString());
		rCongreso.add("tipoCocina:" + tipoCocina.getSelectedItem().toString());
		System.out.println(tipoReservaElegido);
		switch (tipoReservaElegido) {

		case "Banquete": {
			
			rCongreso.add("tipoMesa:" + cb_tipoMesa.getSelectedItem().toString());
			rCongreso.add("comensalesMesa:" + cb_pMesa.getSelectedItem().toString());
			return rCongreso;

		}

		case "Congreso": {

			rCongreso.add("numeroJornadas:" + cb_nJornadas.getSelectedItem().toString());
			if (checkBox_Si.isSelected())
				rCongreso.add("habitaciones: " + spinner.getValue().toString());
			
			
			return rCongreso;
		}
		default:
			break;

		}
		

		return rCongreso;

	}

	private static String obtenerFechaSeleccionada(JDateChooser dateChooser) {
		// Obtener la fecha seleccionada
		Date selectedDate = dateChooser.getDate();
		String textoFecha = null;
		// Verificar si se ha seleccionado una fecha
		if (selectedDate != null) {
			// Formatear la fecha como texto usando SimpleDateFormat
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			textoFecha = dateFormat.format(selectedDate);

			// Mostrar el texto de la fecha (puedes hacer lo que necesites con este texto)

		}
		return textoFecha;
	}

	public void manejarCheckBox() {

		checkBox_Si.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					spinner.setVisible(true);
				} else {
					spinner.setVisible(false);
				}

			}
		});

	}

}
