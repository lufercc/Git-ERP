package com.jalasoft.automation.erp.api;

import com.jalasoft.automation.core.config.UserCredentials;
import com.jalasoft.automation.erp.portal.config.PortalConfig;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;

/**
 * Created by Henry Benito on 5/23/2016.
 */
public class WebServiceAPI {
    private PortalConfig config = null;
    public XmlRpcClient client = null;
    public XmlRpcClient models = null;
    public Integer uid;
    private String url, db, username, password;

    public WebServiceAPI() {
        config = new PortalConfig();
    }

    public void authenticate(String credentialType) throws Throwable {
        UserCredentials credentials = config.getCredentialsConfig().getCredentialsByType(credentialType);
        url = config.getSutUrl();
        db = config.getSutDB();
        username = credentials.userName;
        password = credentials.password;
        client = new XmlRpcClient();
        final XmlRpcClientConfigImpl common_config = new XmlRpcClientConfigImpl();
        common_config.setServerURL(
                new URL(String.format("%s/xmlrpc/2/common", url)));
        client.execute(common_config, "version", emptyList());

        uid = (int)client.execute(common_config, "authenticate", Arrays.asList(db, username, password, emptyMap()));
        models = new XmlRpcClient() {{
            setConfig(new XmlRpcClientConfigImpl() {{
                setServerURL(new URL(String.format("%s/xmlrpc/2/object", url)));
            }});
        }};
    }

    public int create(String model, HashMap data) {
        int id = 0;
        try {
            id = (Integer) models.execute("execute_kw", Arrays.asList(db,
                                                                      uid,
                                                                      password,
                                                                      model,
                                                                      "create",
                                                                      Arrays.asList(data)));
            return id;
        } catch (XmlRpcException xre) {
            System.out.println(xre.getCause());
        }
        return id;
    }

    public boolean delete(String model, String field, Object value) {

        try {
            List<Object> ids = Arrays.asList((Object[]) models.execute("execute_kw", Arrays.asList(
                    db, uid, password,
                    model, "search",
                    Arrays.asList(Arrays.asList(Arrays.asList(field, "=", value)))
            )));
            for (Object id: ids) {
                models.execute("execute_kw", Arrays.asList(
                        db, uid, password,
                        model, "unlink",
                        Arrays.asList(Arrays.asList(id))));
            }

            // check if the deleted record is still in the database
            List<Object> noDeleted = Arrays.asList((Object[]) models.execute("execute_kw", Arrays.asList(
                    db, uid, password,
                    model, "search",
                    Arrays.asList(Arrays.asList(Arrays.asList(field, "=", value)))
            )));
            if(noDeleted.isEmpty()) {
                return true;
            }
            return false;
        } catch (XmlRpcException xre) {
            System.out.println(xre.getCause());
        }
        return false;
    }
}
