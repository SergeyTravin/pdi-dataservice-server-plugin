/**
 * The Pentaho proprietary code is licensed under the terms and conditions
 * of the software license agreement entered into between the entity licensing
 * such code and Pentaho Corporation. 
 */
package org.pentaho.di.ui.repository.pur.services;

import java.util.List;

import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.repository.RepositorySecurityProvider;

/**
 * Core security API for Action based security
 * 
 * <p>
 * Reponsible for determining if access to a given action should be allowed or denied.
 * 
 * @author rmansoor
 */

public interface IAbsSecurityProvider extends RepositorySecurityProvider{
  public final static String CREATE_CONTENT_ROLE = "org.pentaho.di.creator"; //$NON-NLS-1$

  public final static String READ_CONTENT_ROLE = "org.pentaho.di.reader";//$NON-NLS-1$

  public final static String ADMINISTER_SECURITY_ROLE = "org.pentaho.di.securityAdministrator";//$NON-NLS-1$

  public final static String CREATE_CONTENT_ACTION = "org.pentaho.repository.create"; //$NON-NLS-1$

  public final static String READ_CONTENT_ACTION = "org.pentaho.repository.read";//$NON-NLS-1$

  public final static String ADMINISTER_SECURITY_ACTION = "org.pentaho.security.administerSecurity";//$NON-NLS-1$

  public final static String NAMESPACE = "org.pentaho"; //$NON-NLS-1$


  /**
  * Returns {@code true} if the the action should be allowed.
  * 
  * @param actionName name of action (e.g. {@code org.pentaho.di.repository.create})
  * @return {@code true} to allow
  */
  public boolean isAllowed(String actionName) throws KettleException;
  
  /**
  * Returns all actions in the given namespace that are currently allowed.
  * 
  * @param actionNamespace action namespace (e.g. {@code org.pentaho.di.repository}); {@code null} means all allowed actions
  * @return list of actions
  */  
  public List<String> getAllowedActions(String actionNamespace) throws KettleException;
}
