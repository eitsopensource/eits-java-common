package br.com.eits.common.application.dwr.converter;

import java.time.OffsetDateTime;

import org.directwebremoting.ConversionException;
import org.directwebremoting.extend.AbstractConverter;
import org.directwebremoting.extend.InboundVariable;
import org.directwebremoting.extend.NonNestedOutboundVariable;
import org.directwebremoting.extend.OutboundContext;
import org.directwebremoting.extend.OutboundVariable;
import org.directwebremoting.extend.ProtocolConstants;

public class OffsetDateTimeConverter extends AbstractConverter
{
	@Override
	public Object convertInbound( Class<?> paramType, InboundVariable data ) throws ConversionException
	{
		if ( data.isNull() )
		{
			return null;
		}

		String val = data.getValue();

		if ( val.trim().equals( ProtocolConstants.INBOUND_NULL ) )
		{
			return null;
		}

		try
		{
			return OffsetDateTime.parse( java.net.URLDecoder.decode( val, "UTF-8" ) );
		}
		catch ( Exception e )
		{
			throw new ConversionException( paramType, e );
		}
	}

	@Override
	public OutboundVariable convertOutbound( Object data, OutboundContext outctx ) throws ConversionException
	{
		return new NonNestedOutboundVariable( "'" + data.toString() + "'" );
	}
}
