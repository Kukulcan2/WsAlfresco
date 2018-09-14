/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alfresco;


import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

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
/**
 *
 * @author byron
 */
@WebService(serviceName = "WsCreateDocument")
public class WsCreateDocument {
SessionFactory factory = SessionFactoryImpl.newInstance();
Map<String, String> parameters = new HashMap<String, String>();

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {

    parameters.put(SessionParameter.USER, "admin");
    parameters.put(SessionParameter.PASSWORD, "admin");

    // connection settings
    parameters.put(SessionParameter.BINDING_TYPE, BindingType.WEBSERVICES.value());
    parameters.put(SessionParameter.WEBSERVICES_ACL_SERVICE, "http://<host>:<port>/cmis/services/ACLService?wsdl");
    parameters.put(SessionParameter.WEBSERVICES_DISCOVERY_SERVICE, "http://<host>:<port>/cmis/services/DiscoveryService?wsdl");
    parameters.put(SessionParameter.WEBSERVICES_MULTIFILING_SERVICE, "http://<host>:<port>/cmis/services/MultiFilingService?wsdl");
    parameters.put(SessionParameter.WEBSERVICES_NAVIGATION_SERVICE, "http://<host>:<port>/cmis/services/NavigationService?wsdl");
    parameters.put(SessionParameter.WEBSERVICES_OBJECT_SERVICE, "http://<host>:<port>/cmis/services/ObjectService?wsdl");
    parameters.put(SessionParameter.WEBSERVICES_POLICY_SERVICE, "http://<host>:<port>/cmis/services/PolicyService?wsdl");
    parameters.put(SessionParameter.WEBSERVICES_RELATIONSHIP_SERVICE, "http://<host>:<port>/cmis/services/RelationshipService?wsdl");
    parameters.put(SessionParameter.WEBSERVICES_REPOSITORY_SERVICE, "http://<host>:<port>/cmis/services/RepositoryService?wsdl");
    parameters.put(SessionParameter.WEBSERVICES_VERSIONING_SERVICE, "http://<host>:<port>/cmis/services/VersioningService?wsdl");
    parameters.put(SessionParameter.REPOSITORY_ID, "myRepository");

    // create session
    Session session = factory.createSession(parameters);
 return "Hello " + txt + " !";
    }
}
