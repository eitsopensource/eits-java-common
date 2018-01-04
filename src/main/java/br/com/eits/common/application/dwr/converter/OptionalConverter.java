package br.com.eits.common.application.dwr.converter;


import java.lang.reflect.ParameterizedType;
import java.util.Optional;

import org.directwebremoting.ConversionException;
import org.directwebremoting.extend.Converter;
import org.directwebremoting.extend.ConverterManager;
import org.directwebremoting.extend.InboundVariable;
import org.directwebremoting.extend.NonNestedOutboundVariable;
import org.directwebremoting.extend.OutboundContext;
import org.directwebremoting.extend.OutboundVariable;

/**
 * @author eduardo
 */
public class OptionalConverter implements Converter
{
	/*-------------------------------------------------------------------
	 * 		 					ATTRIBUTES
	 *-------------------------------------------------------------------*/
	/**
	 * 
	 */
	private ConverterManager converterManager;

	/*-------------------------------------------------------------------
	 * 		 					BEHAVIORS
	 *-------------------------------------------------------------------*/
	/**
	 * 
	 */
	@Override
	public void setConverterManager( ConverterManager converterManager )
	{
		this.converterManager = converterManager;
	}

	/**
	 * 
	 */
	@Override
	public Object convertInbound( Class<?> paramType, InboundVariable data ) throws ConversionException
	{
		// TODO muito provável que isso estoure um ClassCastException
		Class<?> optionalType = (Class<?>) ((ParameterizedType) paramType.getGenericSuperclass()).getActualTypeArguments()[0];
		return Optional.ofNullable( converterManager.convertInbound( optionalType, data, data.getContext().getCurrentProperty() ) );
	}

	/**
	 * 
	 */
	@Override
	public OutboundVariable convertOutbound( Object data, OutboundContext outctx ) throws ConversionException
	{
		Optional<?> optional = (Optional<?>) data;
		
		return optional
					.map( val -> this.converterManager.convertOutbound( val, outctx ) )
					.orElse( new NonNestedOutboundVariable( "null" ) );
	}
}
