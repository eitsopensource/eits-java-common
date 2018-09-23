package br.com.eits.common.infrastructure.json;

import java.util.UUID;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;

public class EntityIdGenerator extends ObjectIdGenerator<JsonRef>
{
	@Override
	public Class<?> getScope()
	{
		return Object.class;
	}

	@Override
	public boolean canUseFor( ObjectIdGenerator<?> gen )
	{
		return (gen.getClass() == getClass()) && (gen.getScope() == Object.class);
	}

	@Override
	public ObjectIdGenerator<JsonRef> forScope( Class<?> scope )
	{
		return this;
	}

	@Override
	public ObjectIdGenerator<JsonRef> newForSerialization( Object context )
	{
		return this;
	}

	@Override
	public IdKey key( Object key )
	{
		return new IdKey( getClass(), null, key );
	}

	@Override
	public JsonRef generateId( Object forPojo )
	{
		return new JsonRef( UUID.randomUUID() );
	}
}
