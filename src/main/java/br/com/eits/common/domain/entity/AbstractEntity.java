package br.com.eits.common.domain.entity;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import br.com.eits.common.infrastructure.json.EntityIdGenerator;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 */
@Data
@NoArgsConstructor
@MappedSuperclass
@JsonIdentityInfo(generator = EntityIdGenerator.class, property = "$id")
public abstract class AbstractEntity implements IEntity<Long>
{
	/**
	 *
	 */
	private static final long serialVersionUID = -3875941859616104733L;

	/*-------------------------------------------------------------------
	 * 		 					ATTRIBUTES
	 *-------------------------------------------------------------------*/
	/**
	 * Atributo id para todas as classes filhas
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	/**
	 *
	 */
	@Column(nullable = false, updatable = false)
	protected OffsetDateTime created;
	/**
	 *
	 */
	protected OffsetDateTime updated;

	/*-------------------------------------------------------------------
	 * 		 					CONSTRUCTORS
	 *-------------------------------------------------------------------*/

	/**
	 *
	 */
	public AbstractEntity( Long id )
	{
		this.setId( id );
	}

	/*-------------------------------------------------------------------
	 * 		 					BEHAVIORS
	 *-------------------------------------------------------------------*/

	/**
	 *
	 */
	@PrePersist
	protected void refreshCreated()
	{
		if ( this.getCreated() == null )
		{
			this.setCreated( OffsetDateTime.now() );
		}
	}

	/**
	 *
	 */
	@PreUpdate
	protected void refreshUpdated()
	{
		this.refreshCreated();
		this.setUpdated( OffsetDateTime.now() );
	}

	/*-------------------------------------------------------------------
	 *				 	    GETTERS AND SETTERS
	 *-------------------------------------------------------------------*/

	/**
	 *
	 */
	@Override
	public Long getId()
	{
		return id;
	}

	/**
	 *
	 */
	@Override
	public void setId( Long id )
	{
		this.id = id;
	}
}