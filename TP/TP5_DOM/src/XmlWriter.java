
import org.xml.sax.*;


import java.io.File;
import java.io.IOException;



import javax.xml.parsers.DocumentBuilder;

import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.ParserConfigurationException;



import org.w3c.dom.*;





class XmlReader {



    public static void main(String[] args) {

        lireXml();

    }

    public static void lireXml(){



// API used to convert XML into a DOM object tree

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {



            DocumentBuilder buidler =factory.newDocumentBuilder();

            Document doc = buidler.parse(new File("src/GenererUnFichier.xml"));




// récupérer la racine

            Element root = doc.getDocumentElement();

            System.out.println("la racine est: " + root.getNodeName());



//Affichage information sur le livre

            NodeList listLivre = root.getElementsByTagName("book");

            System.out.println("le nombre des livres est : " + listLivre.getLength());







            //parcourir la liste

            for(int i =0; i<listLivre.getLength() ;i++){

                Node book = listLivre.item(i);
                Node titre= listLivre.item(i);
                Element livre = (Element) book ;
                Element listtitre = (Element) titre ;

                String attrnom = livre.getAttribute("category");
                String title = listtitre.getTextContent();




                System.out.println("Categorie livre "+(i+1)+": "+attrnom+"\n contenu livre :"+title);


            }

/*NodeList listSections = doc.getElementsByTagName("sections");

for(int j=0; j<listSections.getLength(); j++){

Node sections = listSections.item(j);



System.out.println(getFirstChildElement(sections).getTagName());

System.out.println(getNextElement(getFirstChildElement(sections)).getTagName());

}*/





//Affichage information sur section/cahpitre/paragraph
/*
            NodeList listSection = doc.getElementsByTagName("section");

            System.out.println("----------------------------");

            for(int j=0; j<listSection.getLength(); j++){

                Node sections = listSection.item(j);

                Element section =(Element) sections;

                Element cahpitre = getFirstChildElement(sections);

                Element paragraphe = getFirstChildElement(cahpitre);

                String attrSectionTitre = section.getAttribute("titre");

                System.out.println("titre section n"+ (j+1) +" :"+attrSectionTitre);

                String attrChaptitre = cahpitre.getAttribute("titre");

                System.out.println("titre du chapitre n"+(j+1)+" : "+attrChaptitre);

                while (paragraphe != null){

                    System.out.print(paragraphe.getNodeName()+": ");

                    System.out.println(paragraphe.getTextContent().trim());

                    paragraphe =getNextElement(paragraphe);

                }

                System.out.println("----------------------------");

//section = getNextElement(section);

                NodeList listchapitre = doc.getElementsByTagName("chapitre");

/*for(int k=0; k<listchapitre.getLength(); k++){



String attrChaptitre = cahpitre.getAttribute("titre");

System.out.println("titre du chapitre n"+(k+1)+" : "+attrChaptitre);

NodeList listpagraphe = doc.getElementsByTagName("paragraphe");

for(int h=0; h<listpagraphe.getLength(); h++){

Element paragraphe = (Element) listpagraphe.item(h);

System.out.println(paragraphe.getTextContent());

}

}*/





        //    }



        } catch (ParserConfigurationException e) {

// TODO Auto-generated catch block

            e.printStackTrace();

        } catch (SAXException e) {

// TODO Auto-generated catch block

            e.printStackTrace();

        } catch (IOException e) {

// TODO Auto-generated catch block

            e.printStackTrace();

        }

    }



//function pour avoir le premiere Element fils

    public static Element getFirstChildElement(Node parent) {

        NodeList childs = parent.getChildNodes();

        for (int i = 0; i < childs.getLength(); i++) {

            Node child = childs.item(i);

            if (child instanceof Element) {

                return (Element) child;

            }

        }

        return null;

    }



//function pour avoir l’Element frere suivant



    public static Element getNextElement(Element el) {

        Node nd = el.getNextSibling();

        while (nd != null) {

            if (nd.getNodeType() == Node.ELEMENT_NODE) {

                return (Element)nd;

            }

            nd = nd.getNextSibling();

        }

        return null;

    }



}