//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2019.12.18 às 02:19:46 PM BRST 
//


package org.example.game;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.example.game package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.example.game
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GameRequest }
     * 
     */
    public GameRequest createGameRequest() {
        return new GameRequest();
    }

    /**
     * Create an instance of {@link GameResponse }
     * 
     */
    public GameResponse createGameResponse() {
        return new GameResponse();
    }

    /**
     * Create an instance of {@link MoveResponse }
     * 
     */
    public MoveResponse createMoveResponse() {
        return new MoveResponse();
    }

    /**
     * Create an instance of {@link MoveRequest }
     * 
     */
    public MoveRequest createMoveRequest() {
        return new MoveRequest();
    }

    /**
     * Create an instance of {@link Position }
     * 
     */
    public Position createPosition() {
        return new Position();
    }

}
