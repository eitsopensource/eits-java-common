package br.com.eits.common.application.dwr.converter;

import java.net.URLDecoder;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.regex.Pattern;

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
			val = URLDecoder.decode( val, "UTF-8" );
			if ( Pattern.matches( "^-?[0-9]+$", val ) )
			{
				long seconds = 0;
				if ( val.length() > 0 )
				{
					seconds = Long.parseLong( val ) / 1000;
				}
				return OffsetDateTime.of( LocalDateTime.ofEpochSecond( seconds, 0, ZoneOffset.UTC ), ZoneOffset.UTC );
			}
			else
			{
				return OffsetDateTime.of( LocalDateTime.parse( val, new DateTimeFormatterBuilder()
						.append( DateTimeFormatter.ISO_LOCAL_DATE_TIME )
						.appendLiteral( 'Z' )
						.toFormatter()
				), ZoneOffset.UTC );
			}
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
