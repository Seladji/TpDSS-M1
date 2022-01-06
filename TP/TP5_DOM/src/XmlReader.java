


import java.io.File;



// Used to write data to a file

import java.io.FileOutputStream;

// Triggered when an I/O error occurs

import java.io.IOException;

// Represents your XML document and contains useful methods

import org.jdom2.Document;

// Represents XML elements and contains useful methods

import org.jdom2.Element;

// Top level JDOM exception

import org.jdom2.JDOMException;

// Represents text used with JDOM

import org.jdom2.Text;

// Creates a JDOM document parsed using SAX Simple API for XML

import org.jdom2.input.SAXBuilder;

// Formats how the XML document will look

import org.jdom2.output.Format;

// Outputs the JDOM document to a file

import org.jdom2.output.XMLOutputter;



     class XmlWriter {

        public static void main(String[] args) {



            ecrireXML();

        }



        private static void ecrireXML(){

            try{



                Document doc = new Document();



                Element theRoot = new Element("bookstore");

                doc.setRootElement(theRoot);






                Element book = new Element("book");

                Element title = new Element("title");
                title.addContent(new Text("Harry Potter"));
                Element editeur= new Element("editeur");
                editeur.addContent(new Text("editeur1"));
                Element author = new Element("auteur");
                author.addContent(new Text("J K. Rowling"));
                Element year = new Element("year");
                year.addContent(new Text("2005"));
                Element price = new Element("price");
                price.addContent(new Text("29.99"));



                book.setAttribute("category", "CHILDREN");





                Element book2 = new Element("book");
                Element title2 = new Element("auteur");
                title2.addContent(new Text("XQuery Kick Start"));
                Element author2 = new Element("auteur");
                author2.addContent(new Text("James McGovern"));
                Element author22 = new Element("auteur");
                author22.addContent(new Text("James Per Bothner"));
                Element author222 = new Element("auteur");
                author222.addContent(new Text("Vaidyanathan Nagarajan"));
                Element year2 = new Element("year");
                year2.addContent(new Text("2003"));
                Element price2 = new Element("price");
                price2.addContent(new Text("49.99"));

                book2.setAttribute("category", "WEB");
                title2.setAttribute("lang", "en");



                title.addContent(editeur);

                book.addContent(title);
                book.addContent(author);
                book.addContent(year);
                book.addContent(price);

                book2.addContent(title2);
                book2.addContent(author2);
                book2.addContent(author22);
                book2.addContent(author222);
                book2.addContent(year2);
                book2.addContent(price2);







                theRoot.addContent(book);
                theRoot.addContent(book2);
















                XMLOutputter xmlOutput = new XMLOutputter(Format.getPrettyFormat());







                xmlOutput.output(doc, new FileOutputStream(new File("./src/GenererUnFichier.xml")));



                System.out.println("fichier XML generé");



            }



            catch (Exception e) {



                e.printStackTrace();

            }

        }



    }

