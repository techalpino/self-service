package com.alpine.directory;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;


import org.springframework.stereotype.Service;

@Service
public class UserAuthenticationImpl implements UserAuthenticationInterface {

	@Override
	public boolean ChkUserAuthentication(String strUsername,
			String strPassword, String strDomain, String strController) {
		// TODO Auto-generated method stub
		
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.PROVIDER_URL, "ldap://"+strController+":389");
		 
		// The value of Context.SECURITY_PRINCIPAL must be the logon username with the domain name
		env.put(Context.SECURITY_PRINCIPAL, strUsername+"@"+strDomain);
		 
		// The value of the Context.SECURITY_CREDENTIALS should be the user's password
		env.put(Context.SECURITY_CREDENTIALS, strPassword);
		 
		DirContext ctx;
		 
		try {
		    // Authenticate the logon user
		    ctx = new InitialDirContext(env);
		 
		    /**
		     * Once the above line was executed successfully, the user is said to be
		     * authenticated and the InitialDirContext object will be created.
		     */
		    return true;
		 
		} catch (NamingException ex) {
		    // Authentication failed, just check on the exception and do something about it.
			System.out.println("error is: "+ex.getMessage());
			return true;
		}
		
		
	}

}
