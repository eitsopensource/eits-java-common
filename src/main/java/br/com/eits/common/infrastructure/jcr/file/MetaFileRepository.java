/**
 * 
 */
package br.com.eits.common.infrastructure.jcr.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.validation.Validator;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.formula.eval.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;

import br.com.eits.common.infrastructure.jcr.IMetaFileRepository;
import br.com.eits.common.infrastructure.jcr.MetaFile;
import br.com.eits.common.infrastructure.jcr.modeshape.MetadataNodeType;

/**
 * @author thiago
 *
 */
public class MetaFileRepository implements IMetaFileRepository
{
	/**
	 * 
	 */
	@Autowired
	private Validator validator;
	
	/**
	 *
	 */
	@Value("${jcr.files}")
	private String filesPath;
	
	/* (non-Javadoc)
	 * @see br.com.eits.common.infrastructure.jcr.IMetaFileRepository#insert(br.com.eits.common.infrastructure.jcr.MetaFile)
	 */
	@Override
	public MetaFile insert( MetaFile metaFile ) throws RepositoryException, IOException
	{
		this.validator.validate(metaFile);

		//Se não passar uma ID, geramos uma dinâmicamente com UUID.
		if ( metaFile.getId() == null )
		{
			metaFile.setId( UUID.randomUUID().toString() );
		}

		final Path metaFilePath = FileSystems.getDefault().getPath( this.filesPath + File.separatorChar + metaFile.getPath() );
		FileUtils.copyInputStreamToFile(metaFile.getInputStream(), metaFilePath.toFile());//copy all the original content
		metaFile.getInputStream().close();

		this.fromMetaFileToFile( metaFilePath, metaFile );
		return metaFile;
	}

	/* (non-Javadoc)
	 * @see br.com.eits.common.infrastructure.jcr.IMetaFileRepository#remove(java.lang.String)
	 */
	@Override
	public void remove( String id ) throws RepositoryException
	{
		throw new NotImplementedException( "Please use the removeByPath" );
	}

	/* (non-Javadoc)
	 * @see br.com.eits.common.infrastructure.jcr.IMetaFileRepository#removeByPath(java.lang.String)
	 */
	@Override
	public void removeByPath( String path ) throws RepositoryException
	{
		Assert.notNull( path );
		
		final MetaFile metaFile = new MetaFile(path);
		final Path metaFilePath = FileSystems.getDefault().getPath( this.filesPath + File.separatorChar + metaFile.getPath() );
		
		if ( !metaFilePath.toFile().exists() )
		{
			throw new PathNotFoundException("The path set was not found.");
		}
		
		try
		{
			Files.delete( metaFilePath );
		}
		catch ( IOException e )
		{
			throw new RepositoryException( e ); 
		}
		
	}

	/* (non-Javadoc)
	 * @see br.com.eits.common.infrastructure.jcr.IMetaFileRepository#removeByFolder(java.lang.String)
	 */
	@Override
	public void removeByFolder( String folder ) throws RepositoryException
	{
		// TODO Auto-generated method stub
		
		Assert.notNull( folder );
		
		final Path metaFilePath = FileSystems.getDefault().getPath( this.filesPath + File.separatorChar + folder );
		
		if ( !metaFilePath.toFile().exists() )
		{
			throw new PathNotFoundException("The folder set was not found.");
		}
		
		for ( File file : metaFilePath.toFile().listFiles() )
		{
			try
			{
				Files.delete( file.toPath() );
			}
			catch ( IOException e )
			{
				throw new RepositoryException( e ); 
			}
		} 
	}

	/* (non-Javadoc)
	 * @see br.com.eits.common.infrastructure.jcr.IMetaFileRepository#findById(java.lang.String, boolean)
	 */
	@Override
	public MetaFile findById( String id, boolean withStream ) throws RepositoryException
	{
		throw new NotImplementedException( "Please use the findByPath" );
	}

	/* (non-Javadoc)
	 * @see br.com.eits.common.infrastructure.jcr.IMetaFileRepository#findByPath(java.lang.String, boolean)
	 */
	@Override
	public MetaFile findByPath( String path, boolean withStream ) throws RepositoryException
	{
		Assert.notNull( path );
		
		final MetaFile metaFile = new MetaFile(path);
		final Path metaFilePath = FileSystems.getDefault().getPath( this.filesPath + File.separatorChar + metaFile.getPath() );
		
		if ( !metaFilePath.toFile().exists() )
		{
			throw new PathNotFoundException("The path set was not found.");
		}
		
		try
		{
			this.fromFileToMetaFile( metaFilePath, metaFile );
		}
		catch ( Exception e )
		{
			throw new RepositoryException( e ); 
		}
		
		if ( withStream )
		{
			try
			{
				metaFile.setInputStream( new FileInputStream( metaFilePath.toFile() ) );
			}
			catch ( FileNotFoundException e )
			{
				throw new RepositoryException(e); 
			}
		}
		
		return metaFile;
	}

	/* (non-Javadoc)
	 * @see br.com.eits.common.infrastructure.jcr.IMetaFileRepository#listByFolder(java.lang.String)
	 */
	@Override
	public List<MetaFile> listByFolder( String folder ) throws RepositoryException
	{
		Assert.notNull( folder );
		final Path folderPath = FileSystems.getDefault().getPath( this.filesPath + File.separatorChar + folder );
		
		List<MetaFile> metaFiles = new ArrayList<MetaFile>();
		
		for ( File file : folderPath.toFile().listFiles() )
		{
			metaFiles.add( this.findByPath( folder+File.separatorChar+file.getName(), false ) );
		} 
		
		return metaFiles;
	}

	/**
	 * 
	 * @return
	 * @throws IOException 
	 */
	private void fromFileToMetaFile( Path metaFilePath, MetaFile metaFile ) throws IOException
	{
		
		final UserDefinedFileAttributeView userDefinedFileAttributeView = Files.getFileAttributeView(metaFilePath, UserDefinedFileAttributeView.class);
		
		if ( userDefinedFileAttributeView != null ) 
		{
			ByteBuffer buffer = ByteBuffer.allocateDirect( userDefinedFileAttributeView.size(MetadataNodeType.PROPERTY_FILENAME) );
			userDefinedFileAttributeView.read( MetadataNodeType.PROPERTY_FILENAME, buffer );
			buffer.flip();
			metaFile.setName( StandardCharsets.UTF_8.decode( buffer ).toString() );

			buffer = ByteBuffer.allocateDirect( userDefinedFileAttributeView.size(MetadataNodeType.PROPERTY_DESCRIPTION) );
			userDefinedFileAttributeView.read( MetadataNodeType.PROPERTY_DESCRIPTION, buffer );
			buffer.flip();
			metaFile.setDescription( StandardCharsets.UTF_8.decode( buffer ).toString() );

			buffer = ByteBuffer.allocateDirect( userDefinedFileAttributeView.size(MetadataNodeType.PROPERTY_CREATED_BY) );
			userDefinedFileAttributeView.read( MetadataNodeType.PROPERTY_CREATED_BY, buffer );
			buffer.flip();
			metaFile.setCreatedBy( StandardCharsets.UTF_8.decode( buffer ).toString() );
			
			buffer = ByteBuffer.allocateDirect( userDefinedFileAttributeView.size(MetadataNodeType.PROPERTY_CONTENT_TYPE) );
			userDefinedFileAttributeView.read( MetadataNodeType.PROPERTY_CONTENT_TYPE, buffer );
			buffer.flip();
			metaFile.setContentType( StandardCharsets.UTF_8.decode( buffer ).toString() );
		}
		
		//FIXME verificar ondew pegar a data de criacao...
		//metaFile.setCreated( Calendar.getInstance() );
		//FIXME como pegar o contentLength sem ler o stream? metaFile.setContentLenght
	}
	
	/**
	 * 
	 * @param metaFilePath
	 * @param metaFile
	 * @throws IOException 
	 * @throws RepositoryException 
	 */
	private void fromMetaFileToFile( Path metaFilePath, MetaFile metaFile ) throws IOException, RepositoryException
	{
		if ( metaFile.getName() != null || metaFile.getDescription() != null || metaFile.getCreatedBy() != null || metaFile.getContentType() != null ) 
		{
			final UserDefinedFileAttributeView userDefinedFileAttributeView = Files.getFileAttributeView(metaFilePath, UserDefinedFileAttributeView.class);
			
			if ( userDefinedFileAttributeView != null ) 
			{
				userDefinedFileAttributeView.write(MetadataNodeType.PROPERTY_FILENAME, StandardCharsets.UTF_8.encode(metaFile.getName()) );
				userDefinedFileAttributeView.write(MetadataNodeType.PROPERTY_DESCRIPTION, StandardCharsets.UTF_8.encode(metaFile.getDescription()) );
				userDefinedFileAttributeView.write(MetadataNodeType.PROPERTY_CREATED_BY, StandardCharsets.UTF_8.encode(metaFile.getCreatedBy()) );
				userDefinedFileAttributeView.write(MetadataNodeType.PROPERTY_CONTENT_TYPE, StandardCharsets.UTF_8.encode(metaFile.getContentType()) );				
			}
			else
			{
				throw new RepositoryException("The current file system do not support custom metadata.");
			}
		}
		
		//FIXME verificar ondew pegar a data de criacao...
		metaFile.setCreated( Calendar.getInstance() );
	}

}
