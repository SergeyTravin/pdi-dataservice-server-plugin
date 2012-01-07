/**
 * The Pentaho proprietary code is licensed under the terms and conditions
 * of the software license agreement entered into between the entity licensing
 * such code and Pentaho Corporation. 
 */
package org.pentaho.di.ui.repository.pur.repositoryexplorer;

import java.lang.reflect.Constructor;

import org.pentaho.di.repository.pur.model.IRole;
import org.pentaho.di.ui.repository.pur.repositoryexplorer.model.UIRepositoryRole;
import org.pentaho.di.ui.repository.repositoryexplorer.model.UIObjectCreationException;

public class UIEEObjectRegistery implements java.io.Serializable {

  private static final long serialVersionUID = 1405941020109398651L; /* EESOURCE: UPDATE SERIALVERUID */

  public static final Class<?> DEFAULT_UIREPOSITORYROLE_CLASS = UIRepositoryRole.class;
  
  private static UIEEObjectRegistery instance;

  private Class<?> repositoryRoleClass;
  
  private UIEEObjectRegistery() {

  }

  public static UIEEObjectRegistery getInstance() {
    if (instance == null) {
      instance = new UIEEObjectRegistery();
    }
    return instance;
  }

  public void registerUIRepositoryRoleClass(Class<?> repositoryRoleClass) {
    this.repositoryRoleClass = repositoryRoleClass;
  }

  public Class<?> getRegisteredUIRepositoryRoleClass() {
    return this.repositoryRoleClass;
  }

  public IUIRole constructUIRepositoryRole(IRole role) throws UIObjectCreationException {
    try {
      if(repositoryRoleClass == null) {
        repositoryRoleClass = DEFAULT_UIREPOSITORYROLE_CLASS;
      }
      Constructor<?> constructor = repositoryRoleClass.getConstructor(IRole.class);
      if (constructor != null) {
        return (IUIRole) constructor.newInstance(role);
      } else {
        throw new UIObjectCreationException("Unable to get the constructor for " + repositoryRoleClass);
      }
    } catch (Exception e) {
      throw new UIObjectCreationException("Unable to instantiate object for " + repositoryRoleClass);
    }
  }
}
