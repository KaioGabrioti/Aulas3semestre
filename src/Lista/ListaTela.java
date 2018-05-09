package Lista;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ListaTela extends JFrame implements ActionListener{
	private Container 	caixa;
	private JPanel		pnlBtn, pnlInput;
	private JButton		btnInsereInicio, btnInsereFinal, btnDeletaInicio, btnDeletaFinal; 
	private JTextField  txtInput;
	static ListaSE_Modelo lista;
	
	
	
	public ListaTela() {
			// Title;
		setTitle("Lista Singularmente Encadeada");
		
			// Container;
		caixa = getContentPane();
	    caixa.setLayout(new BorderLayout()); 
	    
	    	// JPanel;
	    pnlBtn = new JPanel(new GridLayout(2, 2, 10, 10));
	    pnlInput = new JPanel(new GridLayout(1, 1, 10, 10));
	    
	    	// JButton;
	    btnInsereInicio = new JButton("Insere no Inicio");
	    btnInsereInicio.addActionListener(this);
	    btnInsereInicio.setMnemonic(KeyEvent.VK_I);
	    btnInsereInicio.setToolTipText("ALT+I");
	    
	    btnInsereFinal = new JButton("Insere no Final");
	    btnInsereFinal.addActionListener(this);
	    btnInsereFinal.setMnemonic(KeyEvent.VK_F);
	    btnInsereFinal.setToolTipText("ALT+F");
	    
	    btnDeletaInicio = new JButton("Retira do Inicio");
	    btnDeletaInicio.addActionListener(this);
	    btnDeletaInicio.setMnemonic(KeyEvent.VK_E);
	    btnDeletaInicio.setToolTipText("ALT+E");
	    
	    btnDeletaFinal = new JButton("Retira do Final");
	    btnDeletaFinal.addActionListener(this);
	    btnDeletaFinal.setMnemonic(KeyEvent.VK_G);
	    btnDeletaFinal.setToolTipText("ALT+G");
	    
	    	// JTextField;
	    txtInput = new JTextField();
	    	
	    	// Container;
	    pnlBtn.add(btnInsereInicio);
	    pnlBtn.add(btnInsereFinal);
	    pnlBtn.add(btnDeletaInicio);
	    pnlBtn.add(btnDeletaFinal);
	    
	    pnlInput.add(txtInput);
	    
	    caixa.add(pnlInput , BorderLayout.NORTH);
	    caixa.add(pnlBtn, BorderLayout.SOUTH);
	    
	    
	    	// Configurações;
	    setSize(400, 200);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    setVisible(true);		
	}
		// actionPerformed
	public void actionPerformed(ActionEvent e){
		
		
		if(e.getSource() == btnInsereInicio) {
			int iN = Integer.parseInt(txtInput.getText());
			lista.putHead(iN);
			
			if(iN == lista.viewHead()){
				JOptionPane.showMessageDialog(null, "O número " + iN +"foi adicionado no inicio da lista");
			}
			
			System.out.println(lista.sizeLista());
			
			txtInput.setText("");
			txtInput.grabFocus();
		}
		if(e.getSource() == btnInsereFinal) {
			int iN = Integer.parseInt(txtInput.getText());
			lista.putTail(iN);
			
			if(iN == lista.viewTail()){
				JOptionPane.showMessageDialog(null, "O número " + iN + "foi adicionado no final da lista");
			}
			
			System.out.println(lista.sizeLista());
			
			txtInput.setText("");
			txtInput.grabFocus();
		}
		if(e.getSource() == btnDeletaInicio) {
			
			if(lista.isEmpty() == false){
				lista.takeHead();
				JOptionPane.showMessageDialog(null, "O número foi removido do ínicio da lista");
				System.out.println(lista.sizeLista());
			}else {
				JOptionPane.showMessageDialog(null, "A lista está vazia!");
			}
		}	
		if(e.getSource() == btnDeletaFinal) {
			if(lista.isEmpty() == false){
				lista.takeTail();
				JOptionPane.showMessageDialog(null, "O número foi removido do final da lista");
				System.out.println(lista.sizeLista());
			}else {
				JOptionPane.showMessageDialog(null, "A lista está vazia!");
			}
		}
		
	}
	
	public static void main(String args[]) {
		lista = new ListaSE_Modelo();
		new ListaTela();
	}
}
