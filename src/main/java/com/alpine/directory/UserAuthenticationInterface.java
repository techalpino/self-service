package com.alpine.directory;

import org.springframework.stereotype.Component;

@Component
public interface UserAuthenticationInterface {
	boolean ChkUserAuthentication(String strUsername, String strPassword, String strDomain, String strController);
}
