package br.com.eits.common.infrastructure.jcr;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.validation.constraints.NotNull;

/**
 * Esta classe representa um arquivo armazenado em qualquer servico de
 * armazenamento, como JCR
 * 
 * @author rodrigo@eits.com.br
 * @since 03/08/2012
 * @version 1.0
 */
public class MetaFile implements Serializable, Cloneable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -729784288513252096L;
	/**
	 * separador do caminho
	 */
	public static final char PATH_SEPARATOR = '/';

	/*-------------------------------------------------------------------
	 * 		 					ATTRIBUTES
	 *-------------------------------------------------------------------*/
	/**
	 * id do {@link MetaFile}
	 */
	@NotNull
	private String id;
	/**
	 * data de criação do {@link MetaFile}
	 */
	@NotNull
	private Calendar created;
	/**
	 * nome original do arquivo do {@link MetaFile}
	 */
	@NotNull
	private String name;
	/**
	 * pasta onde o {@link MetaFile} é armazenado
	 * 
	 */
	@NotNull
	private String folder;
	/**
	 * o tipo do conteudo
	 */
	@NotNull
	private String contentType;
	/**
	 * tamanho do conteudo do {@link MetaFile}
	 */
	@NotNull
	private long contentLength;
	/**
	 * {@link InputStream} do {@link MetaFile}
	 */
	@NotNull
	private InputStream inputStream;
	/**
	 * nome do criador do armazendamento do {@link MetaFile}
	 */
	private String createdBy;
	/**
	 * descricao do {@link MetaFile}
	 */
	private String description;

	/*-------------------------------------------------------------------
	 *				 		  		CONSTRUCTORS
	 *-------------------------------------------------------------------*/
	/**
	 * 
	 */
	public MetaFile()
	{
	}

	/**
	 * 
	 * 
	 * @param path
	 */
	public MetaFile( String path )
	{
		this.setPath( path );
	}

	/*-------------------------------------------------------------------
	 * 		 					BEHAVIORS
	 *-------------------------------------------------------------------*/
	/**
	 * 
	 */
	@Override
	public String toString()
	{
		if ( getPath() != null && !getPath().isEmpty() )
			return this.getPath();

		return super.toString();
	}

	/**
	 * Método responsável por renomear com números sequenciais os arquivos que
	 * estajam com os nomes iguais
	 */
	public String rename( List<MetaFile> metaFiles, MetaFile metaFile )
	{
		final int lastDot = metaFile.getName().lastIndexOf( '.' );
		// Extensão do arquivo que se encontra na última parte da string
		// separada por ponto
		final String extension = metaFile.getName().substring( lastDot + 1 );

		// Nome do arquivo sem extensão
		final String fileName = metaFile.getName().substring( 0, lastDot );

		// Compara o arquivo corrente com a lista de arquivos e
		// verifica se o nome do arquivo já existem. Se existir é necessário
		// adicionar um "( )" com número sequencial maior ao último criado
		for ( int j = 0; j < metaFiles.size(); j++ )
		{
			if ( metaFiles.get( j ).getName().equalsIgnoreCase( metaFile.getName() ) )
			{
				// Devemos percorrer a lista novamente e verificar se já existe
				// algum arquivo com o nome e o "( )" com número.
				int inc = 1;
				for ( int i = 0; i <= metaFiles.size() - 1; i++ )
				{
					// Caso exista o arquivo com o nome e o "( )" com número
					// devemos incrementar +1
					if ( metaFiles.get( i ).getName().equalsIgnoreCase( fileName + "(" + inc + ")." + extension ) )
					{
						inc++;

						// Devemos tornar a verificação da lista recursiva até
						// que todos os nomes dos arquivos estejam diferentes
						i = -1;
					}
				}
				metaFile.setName( fileName + "(" + inc + ")." + extension );
			}
		}

		return metaFile.getName();
	}

	/**
	 * Retorna o caminho completo onde o arquivo remoto deve ser salvo, baseado
	 * na pasta e no id do arquivo
	 * 
	 * @return O caminho externo completo
	 */
	public String getPath()
	{
		return this.getFolder() + PATH_SEPARATOR + this.getId();
	}

	/**
	 * 
	 * @param value
	 */
	public void setPath( String value )
	{
		if ( value == null || value.isEmpty() ) return;

		this.folder = value.substring( 0, value.lastIndexOf( PATH_SEPARATOR ) );
		final int separatorIndex = value.lastIndexOf( '.' );

		if ( separatorIndex >= 0 )
		{
			this.id = value.substring( value.lastIndexOf( PATH_SEPARATOR ) + 1, separatorIndex );
		}
		else
		{
			this.id = value.substring( value.lastIndexOf( PATH_SEPARATOR ) + 1 );
		}
	}
	
	/**
	 * 
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * 
	 * @param name
	 */
	public void setName( String name )
	{
		this.name = name;

		if ( name != null )
		{
			// Preciso checar se o caminho é completo
			// Ex: C:\fakepath\Hydrangeas.jpg (windows)
			int index = name.lastIndexOf( '\\' );
			// Ex: /fakepath/Hydrangeas.jpg (unix)
			index = index == -1 ? name.lastIndexOf( '/' ) : index;
			if ( index != -1 )
			{
				this.name = name.substring( index + 1 );
			}
		}
	}
	
	/*-------------------------------------------------------------------
	 * 		 				GETTERS AND SETTERS
	 *-------------------------------------------------------------------*/
	/**
	 * 
	 */
	public String getId()
	{
		return id;
	}

	public void setId( String id )
	{
		this.id = id;
	}

	/**
	 * 
	 */
	public String getFolder()
	{
		return folder;
	}

	public void setFolder( String folder )
	{
		this.folder = folder;
	}

	/**
	 * 
	 */
	public String getContentType()
	{
		return contentType;
	}

	/**
	 * 
	 * @param contentType
	 */
	public void setContentType( String contentType )
	{
		this.contentType = contentType;
	}

	/**
	 * 
	 */
	public long getContentLength()
	{
		return this.contentLength;
	}

	public void setContentLength( long contentLength )
	{
		this.contentLength = contentLength;
	}

	/**
	 * 
	 */
	public Calendar getCreated()
	{
		return created;
	}

	public void setCreated( Calendar created )
	{
		this.created = created;
	}

	/**
	 * 
	 * @return inputStream
	 */
	public InputStream getInputStream()
	{
		return inputStream;
	}

	/**
	 * 
	 * @param inputStream
	 */
	public void setInputStream( InputStream inputStream )
	{
		this.inputStream = inputStream;
	}

	/**
	 * 
	 * @return description
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * 
	 * @param description
	 */
	public void setDescription( String description )
	{
		this.description = description;
	}

	/**
	 * 
	 * @return createdBy
	 */
	public String getCreatedBy()
	{
		return createdBy;
	}

	/**
	 * 
	 * @param createdBy
	 */
	public void setCreatedBy( String createdBy )
	{
		this.createdBy = createdBy;
	}
}