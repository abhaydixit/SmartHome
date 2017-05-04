import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class ReadFile {

  public static void main(String argv[]){
    try{
      File file = new File("src/knock.xml");
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder db = dbf.newDocumentBuilder();
      Document doc = db.parse(file);

      doc.getDocumentElement().normalize();
      System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

      NodeList nList = doc.getElementsByTagName("object");

      System.out.println("----------------------------");

      for (int temp = 0; temp < nList.getLength(); temp++) {

        Node nNode = nList.item(temp);

        System.out.println("\nCurrent Element :" + nNode.getNodeName());

        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

          Element eElement = (Element) nNode;

          System.out.println("Object id : " + eElement.getAttribute("id"));
          System.out.println(" Name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
          System.out.println("attribute : " + eElement.getElementsByTagName("attributes").item(0).getTextContent());
            System.out.println("points : " + eElement.getElementsByTagName("polygon").item(0).getTextContent());

          /*  System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
          System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());*/

        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
