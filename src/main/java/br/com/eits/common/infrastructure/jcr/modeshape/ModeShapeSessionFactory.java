package br.com.eits.common.infrastructure.jcr.modeshape;

import javax.annotation.PreDestroy;
import javax.jcr.LoginException;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * {@link org.springframework.beans.factory.FactoryBean} which uses
 * {@link ModeShapeRepositoryFactory} to provide different {@link Session}
 * instances each time this bean is used.
 * 
 * @author rodrigo@eits.com.br
 * @since Sep 11, 2013
 * @version 1.0
 */
public class ModeShapeSessionFactory implements FactoryBean<Session>
{
	/*-------------------------------------------------------------------
	 * 		 					ATTRIBUTES
	 *-------------------------------------------------------------------*/
	/**
	 * 
	 */
	@Autowired
	private Repository repository;
	/**
	 * 
	 */
	private Session session;
	
	/*-------------------------------------------------------------------
	 *				 		     BEHAVIORS
	 *-------------------------------------------------------------------*/
	/**
	 * 
	 */
	@PreDestroy
	public void logout()
	{
		this.session.logout();
		this.session = null;
	}

	/*-------------------------------------------------------------------
	 *				 		  GETTERS AND SETTERS
	 *-------------------------------------------------------------------*/
	/**
	 * @throws RepositoryException 
	 * @throws LoginException 
	 * 
	 */
	@Override
	public Session getObject() throws LoginException, RepositoryException
	{
		if ( session == null )
		{
			this.session = this.repository.login();
		}
		
		return this.session;
	}

	/**
	 * 
	 */
	@Override
	public Class<?> getObjectType()
	{
		return Session.class;
	}

	/**
	 * 
	 */
	@Override
	public boolean isSingleton()
	{
		return true;
	}
}