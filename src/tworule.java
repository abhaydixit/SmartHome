import javax.accessibility.AccessibleRelation;

import jess.JessException;
import jess.Rete;

public class tworule {
	
	
	
	public static void main(String args[]) {
		
		Rete engine = new Rete();
		try {
			engine.executeCommand("(deftemplate scene (slot human) (slot door))");
			//engine.executeCommand("()")
			engine.executeCommand("(defrule open-or-close (and (scene (human ?h&:(eq ?h true)))(scene (door ?d&:(eq ?d true)))) => (printout t \"yes person AccessibleRelation door \"))");
			engine.executeCommand("(reset)");
//			engine.executeCommand("(watch all)");
			String cmd="(assert (scene (human true))(scene (door true)))";
			engine.executeCommand(cmd);
			engine.executeCommand("(run)");
		} catch (JessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
