/**
 * 
 */
package br.com.eits.common.infrastructure.jcr.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.jcr.RepositoryException;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

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
		//Files.createFile( metaFilePath );
		Files.copy(metaFile.getInputStream(), metaFilePath);
		
		Files.setAttribute( metaFilePath, "basic:"+MetadataNodeType.PROPERTY_ID, metaFile.getId() );
		Files.setAttribute( metaFilePath, "basic:"+MetadataNodeType.PROPERTY_FILENAME, metaFile.getName() );
		Files.setAttribute( metaFilePath, "basic:"+MetadataNodeType.PROPERTY_DESCRIPTION, metaFile.getDescription() );
		Files.setAttribute( metaFilePath, "basic:"+MetadataNodeType.PROPERTY_CREATED_BY, metaFile.getCreatedBy() );
		
		metaFile.setCreated( Calendar.getInstance() );
		return metaFile;
	}

	/* (non-Javadoc)
	 * @see br.com.eits.common.infrastructure.jcr.IMetaFileRepository#remove(java.lang.String)
	 */
	@Override
	public void remove( String id ) throws RepositoryException
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see br.com.eits.common.infrastructure.jcr.IMetaFileRepository#removeByPath(java.lang.String)
	 */
	@Override
	public void removeByPath( String path ) throws RepositoryException
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see br.com.eits.common.infrastructure.jcr.IMetaFileRepository#removeByFolder(java.lang.String)
	 */
	@Override
	public void removeByFolder( String folder ) throws RepositoryException
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see br.com.eits.common.infrastructure.jcr.IMetaFileRepository#findById(java.lang.String, boolean)
	 */
	@Override
	public MetaFile findById( String id, boolean withStream ) throws RepositoryException
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see br.com.eits.common.infrastructure.jcr.IMetaFileRepository#findByPath(java.lang.String, boolean)
	 */
	@Override
	public MetaFile findByPath( String path, boolean withStream ) throws RepositoryException
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see br.com.eits.common.infrastructure.jcr.IMetaFileRepository#listByFolder(java.lang.String)
	 */
	@Override
	public List<MetaFile> listByFolder( String folder ) throws RepositoryException
	{
		// TODO Auto-generated method stub
		return null;
	}

}
