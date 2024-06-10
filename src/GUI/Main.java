package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Model.Polynomial;

public class Main {
    public static void main(String[] args) {

        //frame
        JFrame GUIFrame = new JFrame("Assignment1 Calculator Polinomiale Andrei Burdean");
        GUIFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUIFrame.setSize(500, 700);
        GUIFrame.setResizable(false);
        GUIFrame.setLayout(null);
        
        //labels
        
        Label labelPolyCalc = new Label("Polynomial Calculator", 100, 10, 300, 35, 30);
		GUIFrame.add(labelPolyCalc);
		
		Label labelPoly1 = new Label("Polynomial 1", 10, 70, 300, 35, 30);
		GUIFrame.add(labelPoly1);
        
		Label labelPoly2 = new Label("Polynomial 2", 10, 150, 300, 35, 30);
		GUIFrame.add(labelPoly2);
		
		Label labelResult = new Label("Result", 10, 580, 100, 35, 30);
		GUIFrame.add(labelResult);
        
        //textFields
		
		TextField textFieldPoly1 = new TextField(10, 110, 300, 25, 20);
		GUIFrame.add(textFieldPoly1);
		
		TextField textFieldPoly2 = new TextField(10, 190, 300, 25, 20);
		GUIFrame.add(textFieldPoly2);
		
		TextField textFieldResult = new TextField(10, 620, 450, 25, 20);
		GUIFrame.add(textFieldResult);
        
		//buttons
		
		Button additionButton = new Button("Addition( + )", 10, 480, 140, 35, 15);
		GUIFrame.add(additionButton);
		
		Button subtractionButton = new Button("Subtraction( - )", 160, 480, 140, 35, 15);
		GUIFrame.add(subtractionButton);
		
		Button multiplicationButton = new Button("Multiplication( * )", 10, 525, 140, 35, 15);
		GUIFrame.add(multiplicationButton);
		
		Button derivationButton = new Button("Derivation( dx )", 160, 525, 140, 35, 15);
		GUIFrame.add(derivationButton);
		
		Button integrationButton = new Button("Integrate( $dx )", 310, 480, 140, 35, 15);
		GUIFrame.add(integrationButton);
		
		additionButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent clickEvent) {
		        Polynomial polynomial1 = new Polynomial(textFieldPoly1.getText());
		        Polynomial polynomial2 = new Polynomial(textFieldPoly2.getText());
		        Polynomial sum = polynomial1.addPolynomials(polynomial2);

		        textFieldResult.setText(sum.toString());
		    }
		});
		
		subtractionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent clickEvent) {
		        Polynomial polynomial1 = new Polynomial(textFieldPoly1.getText());
		        Polynomial polynomial2 = new Polynomial(textFieldPoly2.getText());
		        Polynomial difference = polynomial1.subtractPolynomials(polynomial2);

		        textFieldResult.setText(difference.toString());
		    }
		});
		
		multiplicationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent clickEvent) {
		        Polynomial polynomial1 = new Polynomial(textFieldPoly1.getText());
		        Polynomial polynomial2 = new Polynomial(textFieldPoly2.getText());
		        Polynomial product = polynomial1.multiplyPolynomials(polynomial2);

		        textFieldResult.setText(product.toString());
		    }
		});
		
		derivationButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent clickEvent) {
		        Polynomial polynomial1 = new Polynomial(textFieldPoly1.getText());
		        Polynomial derivated = polynomial1.derivatePolynomials();

		        textFieldResult.setText(derivated.toString());
		    }
		});
		
		integrationButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent clickEvent) {
		        Polynomial polynomial1 = new Polynomial(textFieldPoly1.getText());
		        Polynomial derivated = polynomial1.integratePolynomials();

		        textFieldResult.setText(derivated.toString());
		    }
		});
		
		GUIFrame.setVisible(true);	
    }
}