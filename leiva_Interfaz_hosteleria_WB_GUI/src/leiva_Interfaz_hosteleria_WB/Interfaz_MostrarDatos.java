package leiva_Interfaz_hosteleria_WB;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import com.toedter.calendar.JDateChooser;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;

public class Interfaz_MostrarDatos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JButton abrirJfilechooser;

	private String rutaCompleta;

	JFileChooser fileChooser;

	JButton btn_convertir;

	/**
	 * Create the frame.
	 */
	public Interfaz_MostrarDatos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();

		contentPane.add(panel);
		panel.setLayout(new GridLayout(3, 1, 0, 0));

		JLabel lblNewLabel = new JLabel("Reservas Salón Habana");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);

		JPanel borderCenter = new JPanel();
		borderCenter.setLayout(new BorderLayout());

		contentPane.add(borderCenter, BorderLayout.CENTER);

		JPanel panel_2 = new JPanel();
		borderCenter.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);

		abrirJfilechooser = new JButton("Seleccionar Archivo");

		textField_1 = new JTextField();
		panel_5.add(textField_1);
		textField_1.setColumns(30);

		panel_5.add(abrirJfilechooser);
		btn_convertir = new JButton("Convertir");
		panel_5.add(btn_convertir);

		JScrollPane scrollPane = new JScrollPane();

		borderCenter.add(scrollPane, BorderLayout.CENTER);

		String[] nombresColumnas = { "Fecha", "Nombre", "Telefono", "TipoReserva", "Personas", "TipoCocina",
				"NºJornadas", "NºHabitaciones", "TipoMesa", "PersonasMesa" };
		DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
		table = new JTable(modelo);
		
		scrollPane.setViewportView(table);
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		JPanel panel_3 = new JPanel();

		panel_3.setLayout(new GridLayout(1, 3, 0, 0));

		Border bordePanel = BorderFactory.createEmptyBorder(20, 20, 20, 20);

		JPanel panelBorderUlt1 = new JPanel(new BorderLayout());

		panelBorderUlt1.setBorder(bordePanel);

		panel_3.add(panelBorderUlt1);
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		panelBorderUlt1.add(lblNewLabel_1, BorderLayout.NORTH);

		textField = new JTextField();
		panelBorderUlt1.add(textField, BorderLayout.SOUTH);
		textField.setColumns(10);

		JPanel panelBorderUlt2 = new JPanel(new BorderLayout());
		panelBorderUlt2.setBorder(bordePanel);
		panel_3.add(panelBorderUlt2);

		JLabel lblNewLabel_2 = new JLabel("Fecha");
		panelBorderUlt2.add(lblNewLabel_2, BorderLayout.NORTH);

		JDateChooser fecha = new JDateChooser();
		fecha.setLocale(new Locale("es"));
		fecha.setDateFormatString("dd/MM/yyyy");
		panelBorderUlt2.add(fecha, BorderLayout.SOUTH);

		JPanel panelBorderUlt3 = new JPanel(new BorderLayout());
		panelBorderUlt3.setBorder(bordePanel);
		panel_3.add(panelBorderUlt3);

		JButton btnNewButton = new JButton("Filtrar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panelBorderUlt3.add(btnNewButton, BorderLayout.SOUTH);

		borderCenter.add(panel_3, BorderLayout.SOUTH);

		Border borde = BorderFactory.createEmptyBorder(30, 20, 30, 20);

		panel_2.setBorder(borde);

		panel.setBorder(new EmptyBorder(10, 10, 10, 10));

		contentPane.setBorder(bordePanel);

		contentPane.setBackground(new Color(249, 228, 183));
		panel.setBackground(new Color(249, 228, 183));
		panel_2.setBackground(new Color(249, 228, 183));
		panel_3.setBackground(new Color(249, 228, 183));
		panel_5.setBackground(new Color(249, 228, 183));
		panelBorderUlt1.setBackground(new Color(249, 228, 183));
		panelBorderUlt2.setBackground(new Color(249, 228, 183));
		panelBorderUlt3.setBackground(new Color(249, 228, 183));

	}

	public void manejarListeners() {

		abrirJfilechooser.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {

				// Crear un JFileChooser
				fileChooser = new JFileChooser();

				// Mostrar el cuadro de diálogo para seleccionar un archivo

				int result = fileChooser.showOpenDialog(contentPane);

				// Verificar si el usuario seleccionó un archivo

				if (result == JFileChooser.APPROVE_OPTION) {

					// Obtener el archivo seleccionado

					rutaCompleta = fileChooser.getSelectedFile().getAbsolutePath();
					textField_1.setText(rutaCompleta);
					
					System.out.println("Archivo seleccionado: " + rutaCompleta);

				}

			}

		});

		btn_convertir.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        File selectedFile = fileChooser.getSelectedFile();

		        DOM dom = new DOM();
		        org.w3c.dom.Document doc = dom.initDOM(selectedFile);
		        ArrayList<ArrayList<String>> datosReservas = dom.root(doc);

		        String[] columnas = { "Fecha", "Nombre", "Telefono", "TipoReserva", "Personas", "TipoCocina",
		                "NºJornadas", "NºHabitaciones", "TipoMesa", "PersonasMesa" };

		        DefaultTableModel modelo = new DefaultTableModel(null, columnas);

		        for (ArrayList<String> reserva : datosReservas) {
		            Object[] fila = new Object[columnas.length];
		            for (String atributo : reserva) {
		                String[] parts = atributo.split(":");
		                String nombreAtributo = parts[0];
		                String valorAtributo = parts[1];

		                
		                switch (nombreAtributo) {
		                case "fechaEvento":
		                    fila[0] = valorAtributo;
		                    break;
		                case "nombre":
		                    fila[1] = valorAtributo;
		                    break;
		                case "telefono":
		                	fila[2] = valorAtributo;
		                	break;
		                case "tipoReserva":
		                	fila[3] = valorAtributo;
		                	break;
		                case "personas":
		                	fila[4] = valorAtributo;
		                	break;
		                case "tipoCocina":
		                	fila[5] = valorAtributo;
		                	break;
		                case "numeroJornadas":
		                	fila[6] = valorAtributo;
		                	break;
		                case "habitaciones":
		                	fila[7] = valorAtributo;
		                	break;
		                case "tipoMesa":
		                	fila[8] = valorAtributo;
		                	break;
		                case "comensalesMesa":
		                	fila[9] = valorAtributo;
		                	break;
		                }
		            }
		            modelo.addRow(fila);
		        }

		        // Actualiza el modelo de la tabla existente
		        table.setModel(modelo);
		    }
		});
	}

}
