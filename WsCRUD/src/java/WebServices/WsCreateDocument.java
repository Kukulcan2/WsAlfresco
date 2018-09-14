/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import org.apache.chemistry.opencmis.client.api.CmisObject;
import org.apache.chemistry.opencmis.client.api.ItemIterable;
import org.apache.chemistry.opencmis.client.api.Document;
import org.apache.chemistry.opencmis.client.api.Folder;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.client.api.SessionFactory;
import org.apache.chemistry.opencmis.client.runtime.SessionFactoryImpl;
import org.apache.chemistry.opencmis.commons.PropertyIds;
import org.apache.chemistry.opencmis.commons.SessionParameter;
import org.apache.chemistry.opencmis.commons.data.ContentStream;
import org.apache.chemistry.opencmis.commons.enums.BindingType;
import org.apache.chemistry.opencmis.commons.enums.VersioningState;
import org.apache.chemistry.opencmis.commons.impl.dataobjects.ContentStreamHashImpl;
        /*SessionFactory factory = SessionFactoryImpl.newInstance();
        Map<String, String> parameters = new HashMap();
        //TODO write your implementation code here:
        // user credentials
        parameters.put(SessionParameter.USER, "admin");
        parameters.put(SessionParameter.PASSWORD, "admin");

        // connection settings
        parameters.put(SessionParameter.BINDING_TYPE, BindingType.WEBSERVICES.value());
        parameters.put(SessionParameter.WEBSERVICES_ACL_SERVICE, "http://142.93.83.23:8080/alfresco/cmisws/ACLService?wsdl");
        parameters.put(SessionParameter.WEBSERVICES_DISCOVERY_SERVICE, "http://142.93.83.23:8080/alfresco/cmisws/DiscoveryService?wsdl");
        parameters.put(SessionParameter.WEBSERVICES_MULTIFILING_SERVICE, "http://142.93.83.23:8080/alfresco/cmisws/MultiFilingService?wsdl");
        parameters.put(SessionParameter.WEBSERVICES_NAVIGATION_SERVICE, "http://142.93.83.23:8080/alfresco/cmisws/NavigationService?wsdl");
        parameters.put(SessionParameter.WEBSERVICES_OBJECT_SERVICE, "http://142.93.83.23:8080/alfresco/cmisws/ObjectService?wsdl");
        parameters.put(SessionParameter.WEBSERVICES_POLICY_SERVICE, "http://142.93.83.23:8080/alfresco/cmisws/PolicyService?wsdl");
        parameters.put(SessionParameter.WEBSERVICES_RELATIONSHIP_SERVICE, "http://142.93.83.23:8080/alfresco/cmisws/RelationshipService?wsdl");
        parameters.put(SessionParameter.WEBSERVICES_REPOSITORY_SERVICE, "http://142.93.83.23:8080/alfresco/cmisws/RepositoryService?wsdl");
        parameters.put(SessionParameter.WEBSERVICES_VERSIONING_SERVICE, "http://142.93.83.23:8080/alfresco/cmisws/VersioningService?wsdl");
        parameters.put(SessionParameter.REPOSITORY_ID, "myRepository");

        // create session
        Session session = factory.createSession(parameters);*/


@WebService(serviceName = "WsCreateDocument")
public class WsCreateDocument {


    /**
     * Web service operation
     */
    @WebMethod(operationName = "Crear")
    public String Crear(@WebParam(name = "Base64") long Base64, @WebParam(name = "NombreDocumento") String NombreDocumento, @WebParam(name = "Ruta") String Ruta) {
        
        //TODO write your implementation code here:
        SessionFactory factory = SessionFactoryImpl.newInstance();
        Map<String, String> parameters = new HashMap();
        //TODO write your implementation code here:
        // user credentials
        parameters.put(SessionParameter.USER, "admin");
        parameters.put(SessionParameter.PASSWORD, "admin");

        // connection settings
        parameters.put(SessionParameter.BINDING_TYPE, BindingType.WEBSERVICES.value());
        parameters.put(SessionParameter.WEBSERVICES_ACL_SERVICE, "http://142.93.83.23:8080/alfresco/cmisws/ACLService?wsdl");
        parameters.put(SessionParameter.WEBSERVICES_DISCOVERY_SERVICE, "http://142.93.83.23:8080/alfresco/cmisws/DiscoveryService?wsdl");
        parameters.put(SessionParameter.WEBSERVICES_MULTIFILING_SERVICE, "http://142.93.83.23:8080/alfresco/cmisws/MultiFilingService?wsdl");
        parameters.put(SessionParameter.WEBSERVICES_NAVIGATION_SERVICE, "http://142.93.83.23:8080/alfresco/cmisws/NavigationService?wsdl");
        parameters.put(SessionParameter.WEBSERVICES_OBJECT_SERVICE, "http://142.93.83.23:8080/alfresco/cmisws/ObjectService?wsdl");
        parameters.put(SessionParameter.WEBSERVICES_POLICY_SERVICE, "http://142.93.83.23:8080/alfresco/cmisws/PolicyService?wsdl");
        parameters.put(SessionParameter.WEBSERVICES_RELATIONSHIP_SERVICE, "http://142.93.83.23:8080/alfresco/cmisws/RelationshipService?wsdl");
        parameters.put(SessionParameter.WEBSERVICES_REPOSITORY_SERVICE, "http://142.93.83.23:8080/alfresco/cmisws/RepositoryService?wsdl");
        parameters.put(SessionParameter.WEBSERVICES_VERSIONING_SERVICE, "http://142.93.83.23:8080/alfresco/cmisws/VersioningService?wsdl");
        parameters.put(SessionParameter.REPOSITORY_ID, "5ed242a5-bed5-4369-a717-bdb9b56d99ec");

        // create session
        Session session = factory.createSession(parameters);
        Folder root = session.getRootFolder();
        System.out.println("Creating 'ADGNewFolder' in the root folder");
        /*Creamos nuestra variable tipo Map que recibe por atributos 2 strings.*/
        Map<String, String> newFolderProps = new HashMap<String, String>();
        /*Se asignan estos parametros string con la función put. Podemos Notar que nuestra variable newFolderProps recibirá válidamente tantos put como parametros tengan que definirse en nuestro Mapa (Map, debemos tener cuidado en que asignemos tipos de dato que correspondan al definido para ese parámetro (creamos puts según el orden definido). Anteriormente los parámetros se asignaron a partir de un constructor llamado HashMap, que internamente setea los datos necesarios para conectarse al repositorio WEBSERVICES().*/
        newFolderProps.put(PropertyIds.OBJECT_TYPE_ID, "cmis:folder");
        newFolderProps.put(PropertyIds.NAME, "ADGNewFolder");
        //Se crea la variable de nuestra carpeta a agregar.
        Folder newFolder = root.createFolder(newFolderProps);
        //El comando de más abajo verificara si nuestro método funciono recorriendo la carpeta root.
        // Did it work?
        ItemIterable<CmisObject> children = root.getChildren();
        System.out.println("Now finding the following objects in the root folder:-");
        for (CmisObject o : children) {
            System.out.println(o.getName()); /*Aquí debieramos poner un if que verifique que el objeto actual tiene el nombre de la carpeta buscada, y si es así, nuestra variable ahora seria Children = Carpetaencontrada.getChildren() y repetir el proceso hasta llegar a la ultima carpeta*/
            if (o.getName() == "ADGNewFolder"){ 
                return "SI esta!";
            }

        }
        

        return "No esta!";
    }



}
