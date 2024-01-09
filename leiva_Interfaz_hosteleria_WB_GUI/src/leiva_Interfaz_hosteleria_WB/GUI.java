package leiva_Interfaz_hosteleria_WB;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class GUI extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	private JButton GuiConsumidor, GuiMostrarDatos;
	private JLabel titulo, salonHabana;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GUI dialog = new GUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.initListeners();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GUI() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(249, 228, 183));
		contentPanel.setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel p_titulo = new JPanel();
			p_titulo.setBackground(new Color(249, 228, 183));
			titulo = new JLabel("Elige una ópcion");
			titulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
			p_titulo.add(titulo);

			JPanel p_salonHabana = new JPanel();
			p_salonHabana.setBackground(new Color(249, 228, 183));
			salonHabana = new JLabel("Salón Habana");
			salonHabana.setFont(new Font("Tahoma", Font.PLAIN, 20));
			p_salonHabana.add(salonHabana);

			JPanel panelPrincipal = new JPanel(new GridLayout(1, 2, 20, 20));
			panelPrincipal.setBorder(new EmptyBorder(20, 20, 20, 20));
			panelPrincipal.setBackground(new Color(249, 228, 183));
			GuiConsumidor = new JButton("Consumidor");
			GuiMostrarDatos = new JButton("Mostrar Datos");

			panelPrincipal.add(GuiConsumidor);
			panelPrincipal.add(GuiMostrarDatos);

			contentPanel.add(p_titulo, BorderLayout.SOUTH);
			contentPanel.add(panelPrincipal, BorderLayout.CENTER);
			contentPanel.add(p_salonHabana, BorderLayout.NORTH);
		}
	}

	private void initListeners() {

		GuiConsumidor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				InterfazConsumidor consumidor = new InterfazConsumidor();
				consumidor.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				consumidor.setVisible(true);
				consumidor.manejarItemsListeners();
				consumidor.manejarCheckBox();

			}
		});

		GuiMostrarDatos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Interfaz_MostrarDatos mostrarDatos = new Interfaz_MostrarDatos();
				mostrarDatos.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				mostrarDatos.setVisible(true);
				mostrarDatos.manejarListeners();

			}
		});

	}

}
