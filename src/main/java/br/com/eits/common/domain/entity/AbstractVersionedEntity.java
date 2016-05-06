package br.com.eits.common.domain.entity;

import java.util.Calendar;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * 
 * @author rodrigo@eits.com.br
 * @since 05/05/2016
 * @version 1.0
 */
@MappedSuperclass
public abstract class AbstractVersionedEntity extends AbstractEntity
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1172731705850432771L;
	
	/*-------------------------------------------------------------------
	 * 		 					ATTRIBUTES
	 *-------------------------------------------------------------------*/
	/**
	 * 
	 */
	@Version
	private Calendar version;

	/*-------------------------------------------------------------------
	 * 		 					CONSTRUCTORS
	 *-------------------------------------------------------------------*/
	/**
	 * 
	 */
	public AbstractVersionedEntity()
	{
	}

	/**
	 * 
	 * @param id
	 */
	public AbstractVersionedEntity( Long id )
	{
		super( id );
	}

	/*-------------------------------------------------------------------
	 * 		 					BEHAVIORS
	 *-------------------------------------------------------------------*/

	/*-------------------------------------------------------------------
	 *				 	    GETTERS AND SETTERS
	 *-------------------------------------------------------------------*/
	/**
	 * @return the version
	 */
	public void setVersion( Calendar version )
	{
		this.version = version;
	}
	/**
	 * @return the version
	 */
	public Calendar getVersion()
	{
		return this.version;
	}
}