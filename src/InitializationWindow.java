

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.lwjgl.LWJGLUtil;
import org.newdawn.slick.SlickException;

public class InitializationWindow extends JFrame{
	
	int[] startSize=new int[] {800,600};
	int particleCount=600;
	int runSpeed = 60;
	float[] gravity=new float[] {0, .08f};
	float particleSize = 25;
	
	boolean validData = true;
	boolean windowReady=false;

	private JPanel contentPane;
	private JTextField environmentX;
	private JTextField environmentY;
	private JTextField particleCountField;
	private JTextField gravityX;
	private JTextField gravityY;
	private JTextField particleSizeField;
	private JTextField runSpeedField;
	JButton btnInitializeParameters = new JButton("Start");
	Label ErrorLabel = new Label("");
	Label ErrorLabel2 = new Label("");

	public static void main(String[] args) {
		System.setProperty("org.lwjgl.librarypath", new File(new File(System.getProperty("user.dir"), "native"), LWJGLUtil.getPlatformName()).getAbsolutePath());
		System.setProperty("net.java.games.input.librarypath", System.getProperty("org.lwjgl.librarypath"));
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitializationWindow frame = new InitializationWindow();
					frame.setVisible(true);
					frame.btnInitializeParameters.grabFocus();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public InitializationWindow() {
		setTitle("Fluid Particle Simulation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 254);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{120, 137, 120, 0};
		gbl_contentPane.rowHeights = new int[]{26, 26, 26, 26, 26, 23, 22, 22, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblEnvironmentSize = new JLabel("Environment Size (X,Y)");
		GridBagConstraints gbc_lblEnvironmentSize = new GridBagConstraints();
		gbc_lblEnvironmentSize.anchor = GridBagConstraints.WEST;
		gbc_lblEnvironmentSize.fill = GridBagConstraints.VERTICAL;
		gbc_lblEnvironmentSize.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnvironmentSize.gridx = 0;
		gbc_lblEnvironmentSize.gridy = 0;
		contentPane.add(lblEnvironmentSize, gbc_lblEnvironmentSize);
		
		environmentX = new JTextField();
		environmentX.setText("800");
		GridBagConstraints gbc_environmentX = new GridBagConstraints();
		gbc_environmentX.fill = GridBagConstraints.BOTH;
		gbc_environmentX.insets = new Insets(0, 0, 5, 5);
		gbc_environmentX.gridx = 1;
		gbc_environmentX.gridy = 0;
		contentPane.add(environmentX, gbc_environmentX);
		environmentX.setColumns(10);
		
		environmentY = new JTextField();
		environmentY.setText("600");
		GridBagConstraints gbc_environmentY = new GridBagConstraints();
		gbc_environmentY.fill = GridBagConstraints.BOTH;
		gbc_environmentY.insets = new Insets(0, 0, 5, 0);
		gbc_environmentY.gridx = 2;
		gbc_environmentY.gridy = 0;
		contentPane.add(environmentY, gbc_environmentY);
		environmentY.setColumns(10);
		
		JLabel lblStartingParticleCount = new JLabel("Starting Particle Count");
		GridBagConstraints gbc_lblStartingParticleCount = new GridBagConstraints();
		gbc_lblStartingParticleCount.anchor = GridBagConstraints.WEST;
		gbc_lblStartingParticleCount.fill = GridBagConstraints.VERTICAL;
		gbc_lblStartingParticleCount.insets = new Insets(0, 0, 5, 5);
		gbc_lblStartingParticleCount.gridx = 0;
		gbc_lblStartingParticleCount.gridy = 1;
		contentPane.add(lblStartingParticleCount, gbc_lblStartingParticleCount);
		
		particleCountField = new JTextField();
		particleCountField.setText("600");
		GridBagConstraints gbc_particleCountField = new GridBagConstraints();
		gbc_particleCountField.fill = GridBagConstraints.BOTH;
		gbc_particleCountField.insets = new Insets(0, 0, 5, 5);
		gbc_particleCountField.gridx = 1;
		gbc_particleCountField.gridy = 1;
		contentPane.add(particleCountField, gbc_particleCountField);
		particleCountField.setColumns(10);
		
		JLabel lblRunSpeed = new JLabel("Run Speed (1-60)");
		GridBagConstraints gbc_lblRunSpeed = new GridBagConstraints();
		gbc_lblRunSpeed.anchor = GridBagConstraints.WEST;
		gbc_lblRunSpeed.fill = GridBagConstraints.VERTICAL;
		gbc_lblRunSpeed.insets = new Insets(0, 0, 5, 5);
		gbc_lblRunSpeed.gridx = 0;
		gbc_lblRunSpeed.gridy = 2;
		contentPane.add(lblRunSpeed, gbc_lblRunSpeed);
		
		runSpeedField = new JTextField();
		runSpeedField.setText("60");
		GridBagConstraints gbc_runSpeedField = new GridBagConstraints();
		gbc_runSpeedField.fill = GridBagConstraints.BOTH;
		gbc_runSpeedField.insets = new Insets(0, 0, 5, 5);
		gbc_runSpeedField.gridx = 1;
		gbc_runSpeedField.gridy = 2;
		contentPane.add(runSpeedField, gbc_runSpeedField);
		runSpeedField.setColumns(10);
		
		JLabel lblGravitydVector = new JLabel("Gravity (2D Vector)");
		GridBagConstraints gbc_lblGravitydVector = new GridBagConstraints();
		gbc_lblGravitydVector.anchor = GridBagConstraints.WEST;
		gbc_lblGravitydVector.fill = GridBagConstraints.VERTICAL;
		gbc_lblGravitydVector.insets = new Insets(0, 0, 5, 5);
		gbc_lblGravitydVector.gridx = 0;
		gbc_lblGravitydVector.gridy = 3;
		contentPane.add(lblGravitydVector, gbc_lblGravitydVector);
		
		gravityX = new JTextField();
		gravityX.setText("0");
		GridBagConstraints gbc_gravityX = new GridBagConstraints();
		gbc_gravityX.fill = GridBagConstraints.BOTH;
		gbc_gravityX.insets = new Insets(0, 0, 5, 5);
		gbc_gravityX.gridx = 1;
		gbc_gravityX.gridy = 3;
		contentPane.add(gravityX, gbc_gravityX);
		gravityX.setColumns(3);
		
		gravityY = new JTextField();
		gravityY.setText(".08");
		GridBagConstraints gbc_gravityY = new GridBagConstraints();
		gbc_gravityY.fill = GridBagConstraints.BOTH;
		gbc_gravityY.insets = new Insets(0, 0, 5, 0);
		gbc_gravityY.gridx = 2;
		gbc_gravityY.gridy = 3;
		contentPane.add(gravityY, gbc_gravityY);
		gravityY.setColumns(10);
		
		JLabel lblParticleSize = new JLabel("Particle Size");
		lblParticleSize.setMinimumSize(new Dimension(120, 10));
		GridBagConstraints gbc_lblParticleSize = new GridBagConstraints();
		gbc_lblParticleSize.anchor = GridBagConstraints.WEST;
		gbc_lblParticleSize.fill = GridBagConstraints.VERTICAL;
		gbc_lblParticleSize.insets = new Insets(0, 0, 5, 5);
		gbc_lblParticleSize.gridx = 0;
		gbc_lblParticleSize.gridy = 4;
		contentPane.add(lblParticleSize, gbc_lblParticleSize);
		
		btnInitializeParameters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					startSize[0]=Integer.parseInt(environmentX.getText().trim());
					}catch(Exception E){
						validData=false;
				}
				try{
					startSize[1]=Integer.parseInt(environmentY.getText().trim());
					}catch(Exception E){
						validData=false;
					}
				try{
					particleCount=Integer.parseInt(particleCountField.getText().trim());
					}catch(Exception E){
						validData=false;
					}
				try{
					particleCount=Integer.parseInt(particleCountField.getText().trim());
					}catch(Exception E){
						validData=false;
					}
				try{
					gravity[0]=Float.parseFloat(gravityX.getText().trim());
					}catch(Exception E){
						validData=false;
					}
				try{
					gravity[1]=Float.parseFloat(gravityY.getText().trim());
					}catch(Exception E){
						validData=false;
					}
				try{
					particleSize=Float.parseFloat(particleSizeField.getText().trim());
					}catch(Exception E){
						validData=false;
					}
				try{
					runSpeed=Integer.parseInt(runSpeedField.getText().trim());
					}catch(Exception E){
						validData=false;
					}
				if (!validData){
					validData=true;
					ErrorLabel.setText(" One of your parameters is an invalid data type, probably one of");
					ErrorLabel2.setText(" the fields is expecting an integer, but was given something else.");
				}
				else{
					windowReady=true;
					InitializationWindow.this.dispose();
					Container simulation = new Container();
					try {
						simulation.runSlick(startSize, particleCount, runSpeed, gravity, particleSize);
					} catch (SlickException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		particleSizeField = new JTextField();
		particleSizeField.setText("25");
		GridBagConstraints gbc_particleSizeField = new GridBagConstraints();
		gbc_particleSizeField.fill = GridBagConstraints.BOTH;
		gbc_particleSizeField.insets = new Insets(0, 0, 5, 5);
		gbc_particleSizeField.gridx = 1;
		gbc_particleSizeField.gridy = 4;
		contentPane.add(particleSizeField, gbc_particleSizeField);
		particleSizeField.setColumns(10);
		GridBagConstraints gbc_btnInitializeParameters = new GridBagConstraints();
		gbc_btnInitializeParameters.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInitializeParameters.insets = new Insets(0, 0, 5, 0);
		gbc_btnInitializeParameters.gridwidth = 3;
		gbc_btnInitializeParameters.gridx = 0;
		gbc_btnInitializeParameters.gridy = 5;
		contentPane.add(btnInitializeParameters, gbc_btnInitializeParameters);
		GridBagConstraints gbc_ErrorLabel = new GridBagConstraints();
		gbc_ErrorLabel.fill = GridBagConstraints.BOTH;
		gbc_ErrorLabel.insets = new Insets(0, 0, 5, 0);
		gbc_ErrorLabel.gridwidth = 3;
		gbc_ErrorLabel.gridx = 0;
		gbc_ErrorLabel.gridy = 6;
		contentPane.add(ErrorLabel, gbc_ErrorLabel);
		GridBagConstraints gbc_ErrorLabel2 = new GridBagConstraints();
		gbc_ErrorLabel2.fill = GridBagConstraints.BOTH;
		gbc_ErrorLabel2.gridwidth = 3;
		gbc_ErrorLabel2.gridx = 0;
		gbc_ErrorLabel2.gridy = 7;
		contentPane.add(ErrorLabel2, gbc_ErrorLabel2);
		
	}

}
