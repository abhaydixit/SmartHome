import jess.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Palsy{
	public static void main(String args[]) throws IOException{
		Rete engine = new Rete();
		
			try {
				engine.executeCommand("(clear)");
				engine.executeCommand("(bind ?symptoms (create$ Non-progressive-disease Spacity-in-patients Disturbance-in-gait Anormal-sensation Abnormal-perception))");
				engine.executeCommand("(bind ?val (create$ 5 5 5 3 2))");
				engine.executeCommand("(deftemplate sym (slot sympt) (slot response) (slot value))");
				
			} catch (JessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Enter the patients name");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String name = br.readLine();
			String cmd = "(assert (patient name " + name + "))";
			try {
				engine.executeCommand(cmd);
			} catch (JessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int i=0;i<5;i++)
			{
			String c2 ="(Defrule get-info (patient name ?) => (printout t \"Do you have \" ( nth$ ?" + i + " ?symptoms) crlf ))";
			try {
				engine.executeCommand(c2);
			} catch (JessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String ans = br.readLine();
			String c3 = "(assert ( sym ( sympt (nth$ ?" + i + " ?symptoms)) (response "+ ans +") ( value ( nth$ ?" + i + " ?val))))";
			try {
				engine.executeCommand(c3);
			} catch (JessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			try {
				engine.executeCommand("(assert ( get info finished))");
				engine.executeCommand("(bind ?sum 0)");
				engine.executeCommand("(bind ?j 0)");
				engine.executeCommand("(defrule calculate (get info finished) (bind ?j (+ ?j 1)) (sym (response y|Y) (value ?x)) => (bind ?sum (+ ?sum ?x)))");
				engine.executeCommand("(if (= ?j 5) then (assert (display result)))");
				engine.executeCommand("(defrule result (display result) => (bind ?sum (* (/ ?sum 20) 100)) (if (< ?sum 16) then (printout t \"No symptoms found \" crlf)) (if (>= ?sum 16) (<= ?sum 38) then (printout t \"Mild Palsy \" crlf)) (if (>= ?sum 39) (<= ?sum 66) then (printout t \"Moderate palsy \"crlf)) (if (>= ?sum 67) (<= ?sum 99) then (printout t \" Severe Palsy \" crlf)))");
		
			} catch (JessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
}
}

			