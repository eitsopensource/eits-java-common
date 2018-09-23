package br.com.eits.common.infrastructure.json;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @see https://github.com/jsog/jsog-jackson
 */
@JsonSerialize(using = JsonRef.Serializer.class)
@JsonDeserialize(using = JsonRef.Deserializer.class)
public class JsonRef
{
	@JsonProperty("$ref")
	private UUID ref;

	public transient boolean used = false;

	public JsonRef( UUID ref )
	{
		this.ref = ref;
	}

	@Override
	public int hashCode()
	{
		return ref.hashCode();
	}

	@Override
	public boolean equals( Object obj )
	{
		return obj instanceof JsonRef && Objects.equals( ((JsonRef) obj).ref, ref );
	}

	public static class Serializer extends JsonSerializer<JsonRef>
	{
		@Override
		public void serialize( JsonRef jsonRef, JsonGenerator jsonGenerator, SerializerProvider serializerProvider ) throws IOException, JsonProcessingException
		{
			if ( jsonRef.used )
			{
				jsonGenerator.writeStartObject();
				jsonGenerator.writeObjectField( "$ref", jsonRef.ref );
				jsonGenerator.writeEndObject();
			}
			else
			{
				jsonRef.used = true;
				jsonGenerator.writeObject( jsonRef.ref );
			}
		}
	}

	public static class Deserializer extends JsonDeserializer<JsonRef>
	{
		@Override
		public JsonRef deserialize( JsonParser jsonParser, DeserializationContext deserializationContext ) throws IOException, JsonProcessingException
		{
			JsonNode node = jsonParser.readValueAsTree();
			if ( node.isTextual() )
			{
				return new JsonRef( UUID.fromString( node.asText() ) );
			}
			else
			{
				return new JsonRef( UUID.fromString( node.get( "$ref" ).asText() ) );
			}
		}
	}
}
