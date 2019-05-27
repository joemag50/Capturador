import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//Heredamos de JFrame para sacar de la libreria swing
public class Principal extends JFrame implements ActionListener
{
	JTextField matricula;
	JTextField App;
	JTextField Apm;
	JTextField Nom;
	JTextField Num;
	JTextField Dir;
	JTextField Sem;
	JTextField Email;
	JTextField Cant;
	
	JButton guardar, borrar, mostrar;
	private ArrayList<Alumno> Al = new ArrayList<Alumno>();

	public static void main (String[] args)
	{
		Principal pri = new Principal();
		pri.Al = new ArrayList<Alumno>();
		pri.crearGUI();
		pri.setSize(650, 350);
		pri.setVisible(true);
	}
	private void crearGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Menu");
		Container frame = getContentPane();
		frame.setLayout(new FlowLayout());
		
		//Estas son las instancias de los botones y etiquetas
		JLabel lab0 = new JLabel("Matricula");
		JLabel lab1 = new JLabel("Nombre");
		JLabel lab2 = new JLabel("Paterno");
		JLabel lab3 = new JLabel("Materno");
		JLabel lab4 = new JLabel("Numero");
		JLabel lab5 = new JLabel("Direccion");
		JLabel lab6 = new JLabel("Semestre");
		JLabel lab7 = new JLabel("Email");
		JLabel lab8 = new JLabel("Materias");
		
		matricula = new JTextField(50);
		Nom = new JTextField(50);
		App = new JTextField(50);
		Apm = new JTextField(50);
		Num = new JTextField(50);
		Dir = new JTextField(50);
		Sem = new JTextField(50);
		Email = new JTextField(50);
		Cant = new JTextField(50);
		
		guardar = new JButton("Guardar");
		borrar = new JButton("Borrar");
		mostrar = new JButton("Mostrar");
		//Les agregamos acciones
		guardar.addActionListener(this);
		borrar.addActionListener(this);
		mostrar.addActionListener(this);
		//Esta propiedad es para quitarle o darle sensibilidad
		guardar.setEnabled(true);
		borrar.setEnabled(false);
		mostrar.setEnabled(false);
		
		//agregamos los objetos al FRAME
		frame.add(lab0);
		frame.add(matricula);
		frame.add(lab1);
		frame.add(Nom);
		frame.add(lab2);
		frame.add(App);
		frame.add(lab3);
		frame.add(Apm);
		frame.add(lab4);
		frame.add(Num);
		frame.add(lab5);
		frame.add(Dir);
		frame.add(lab6);
		frame.add(Sem);
		frame.add(lab7);
		frame.add(Email);
		frame.add(lab8);
		frame.add(Cant);
		
		frame.add(guardar);
		frame.add(borrar);
		frame.add(mostrar);
	}
	//Este es el metodo que se encarga de tomar las acciones en los botones
	public void actionPerformed(ActionEvent arg0)
	{
		JButton o = (JButton)arg0.getSource();
		String name = o.getActionCommand();
		
		if (name == "Guardar")
		{
			
			if (matricula.getText().length() == 0)
			{
				JOptionPane.showMessageDialog(null,"Error: Favor de poner la matricula");
				return;
			}
			Alumno al = new Alumno();
			boolean existe = false;
			int index = 0, i = 0;
			for (Alumno a : Al)
			{
				if (a.matricula == Integer.parseInt(matricula.getText()))
				{
					index = i;
					existe = true;
					break;
				}
				i++;
			}
			
			al.matricula = Integer.parseInt(matricula.getText());
			al.App = App.getText();
			al.Apm = Apm.getText();
			al.Nom = Nom.getText();
			al.Num = Num.getText();
			al.Dir = Dir.getText();
			al.Sem = Sem.getText();
			al.Email = Email.getText();
			al.Cant = Cant.getText();
			
			if (existe)
			{
				Al.remove(index);
				Al.add(al);
			}
			else
			{
				Al.add(al);
			}
			
			JOptionPane.showMessageDialog(null,"Guardado");
			//Limpiamos esta madre
			matricula.setText("");
			App.setText("");
			Apm.setText("");
			Nom.setText("");
			Num.setText("");
			Dir.setText("");
			Sem.setText("");
			Email.setText("");
			Cant.setText("");
			
			mostrar.setEnabled(true);
			borrar.setEnabled(false);
		}
		
		if (name == "Mostrar")
		{
			boolean existe = false;
			
			for (Alumno a : Al)
			{
				if (a.matricula == Integer.parseInt(matricula.getText()))
				{
					matricula.setText("" + a.matricula);
					App.setText(a.App);
					Apm.setText(a.Apm);
					Nom.setText(a.Nom);
					Num.setText(a.Num);
					Dir.setText(a.Dir);
					Sem.setText(a.Sem);
					Email.setText(a.Email);
					Cant.setText(a.Cant);
					existe = true;
					break;
				}
			}
			
			if (existe)
			{
				JOptionPane.showMessageDialog(null,"Encontrado");
				borrar.setEnabled(true);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"No encontrado");
				matricula.setText("");
				App.setText("");
				Apm.setText("");
				Nom.setText("");
				Num.setText("");
				Dir.setText("");
				Sem.setText("");
				Email.setText("");
				Cant.setText("");
				borrar.setEnabled(false);
				return;
			}
		}
		
		if (name == "Borrar")
		{
			boolean existe = false;
			int i = 0;
			for (Alumno a : Al)
			{
				if (a.matricula == Integer.parseInt(matricula.getText()))
				{
					Al.remove(i);
					existe = true;
					matricula.setText("");
					App.setText("");
					Apm.setText("");
					Nom.setText("");
					Num.setText("");
					Dir.setText("");
					Sem.setText("");
					Email.setText("");
					Cant.setText("");
					break;
				}
				i++;
			}
			
			if (existe)
			{
				JOptionPane.showMessageDialog(null,"Borrado");
			}
			else
			{
				JOptionPane.showMessageDialog(null,"No encontrado");
				matricula.setText("");
				App.setText("");
				Apm.setText("");
				Nom.setText("");
				Num.setText("");
				Dir.setText("");
				Sem.setText("");
				Email.setText("");
				Cant.setText("");
				return;
			}
		}
	}
}
