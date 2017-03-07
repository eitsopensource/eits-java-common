package br.com.eits.common.domain.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @author rodrigo@eits.com.br
 * @since 05/05/2016
 * @version 1.0
 */
@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper=true)
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
	@NotNull
	@Version
	@Column(nullable=false)
	private Long version;

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
}