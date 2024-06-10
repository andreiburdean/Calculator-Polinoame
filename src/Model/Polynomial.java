package Model;
import java.util.HashMap;

public class Polynomial {
	
    private HashMap<Integer, Double> polynomialTerms;
    
    private double coefficient;
    private int power;

    public Polynomial(String textFieldInput) {
        this.polynomialTerms = new HashMap<Integer, Double>();
        String[] terms = textFieldInput.split("(?=[+-])");

        for (String term : terms) {
            if (term.isEmpty()) {
                continue;
            }
            if (term.contains("*")) {
                coefficient = Double.parseDouble(term.substring(0, term.indexOf('*')));
                power = Integer.parseInt(term.substring(term.indexOf('^') + 1));
            } else {
                coefficient = Double.parseDouble(term);
                power = 0;
            }
            polynomialTerms.put(power, coefficient);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int power : polynomialTerms.keySet()) {
            if (power < 0) {
                continue;
            }
            coefficient = polynomialTerms.get(power);
            if(power>0)
            	stringBuilder.append(String.format("%.2fx^%d + ", coefficient, power));
            else
            	stringBuilder.append(String.format("%.2f + ", coefficient));
        }
        if (stringBuilder.length() > 0) {
        	stringBuilder.setLength(stringBuilder.length() - 3);
        } else {
        	stringBuilder.append("No polynomials were given");
        }
        return stringBuilder.toString();
    }
    
    public Polynomial addPolynomials(Polynomial other) {
        Polynomial operationResult = new Polynomial("");

        for (int power : polynomialTerms.keySet()) {
        	
            coefficient = polynomialTerms.get(power);
            
            if (other.polynomialTerms.containsKey(power)) {
                coefficient += other.polynomialTerms.get(power);
                other.polynomialTerms.remove(power);
            }
            operationResult.polynomialTerms.put(power, coefficient);
        }

        for (int power : other.polynomialTerms.keySet()) {
            coefficient = other.polynomialTerms.get(power);
            operationResult.polynomialTerms.put(power, coefficient);
        }

        return operationResult;
    }
   
    public Polynomial subtractPolynomials(Polynomial other) {
        Polynomial operationResult = new Polynomial("");

        for (int power : polynomialTerms.keySet()) {
            coefficient = polynomialTerms.get(power);

            if (other.polynomialTerms.containsKey(power)) {
                coefficient -= other.polynomialTerms.get(power);
                other.polynomialTerms.remove(power);
            }
            operationResult.polynomialTerms.put(power, coefficient);
        }

        for (int power : other.polynomialTerms.keySet()) {
            coefficient = -other.polynomialTerms.get(power);
            operationResult.polynomialTerms.put(power, coefficient);
        }

        return operationResult;
    }
    
    public Polynomial multiplyPolynomials(Polynomial other) {
        Polynomial operationResult = new Polynomial("");

        for (int power1 : polynomialTerms.keySet()) {
        	
            double coefficient1 = polynomialTerms.get(power1);
            
            for (int power2 : other.polynomialTerms.keySet()) {
            	
                double coefficient2 = other.polynomialTerms.get(power2);
                coefficient = coefficient1 * coefficient2;
                power = power1 + power2;
                
                if (operationResult.polynomialTerms.containsKey(power)) {
                    coefficient += operationResult.polynomialTerms.get(power);
                }
                operationResult.polynomialTerms.put(power, coefficient);
            }
        }

        return operationResult;
    }
    
    public Polynomial derivatePolynomials() {
        Polynomial operationResult = new Polynomial("");
        
        int intermediaryPower = 0;

        for (int power : polynomialTerms.keySet()) {
        	
        	if(power>1) {
        		int intermediaryPowerForCoef = power;
        		intermediaryPower = power - 1;
        		coefficient = polynomialTerms.get(power)*intermediaryPowerForCoef;
        	}
        	else if(power == 1) {
        		intermediaryPower = 0;
        		coefficient = polynomialTerms.get(power);
        	}
        	else if(power == 0) {
        		intermediaryPower = 0;
        		coefficient = 0;
        	}
        	
            operationResult.polynomialTerms.put(intermediaryPower, coefficient);
        }

        return operationResult;
    }
    
    public Polynomial integratePolynomials() {
        Polynomial operationResult = new Polynomial("");
        
        int intermediaryPower = 0;

        for (int power : polynomialTerms.keySet()) {
        	
        	intermediaryPower = power + 1;
        	coefficient = polynomialTerms.get(power) / intermediaryPower;
        	
            operationResult.polynomialTerms.put(intermediaryPower, coefficient);
        }

        return operationResult;
    }
}
