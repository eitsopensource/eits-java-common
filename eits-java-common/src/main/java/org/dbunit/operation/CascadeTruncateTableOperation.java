/*
 * The DbUnit Database Testing Framework
 * Copyright (C)2002-2004, DbUnit.org
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */

package org.dbunit.operation;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.statement.IBatchStatement;
import org.dbunit.database.statement.IStatementFactory;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITableIterator;
import org.dbunit.dataset.ITableMetaData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author rodrigo@eits.com.br
 */
public class CascadeTruncateTableOperation extends TruncateTableOperation
{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory.getLogger( CascadeTruncateTableOperation.class );

	/**
	 * 
	 */
	protected String getDeleteAllCommand()
	{
		return "truncate table ";
	}

	/**
	 * 
	 */
	@SuppressWarnings("deprecation")
	public void execute( IDatabaseConnection connection, IDataSet dataSet ) throws DatabaseUnitException, SQLException
	{
		logger.debug( "execute(connection={}, dataSet={}) - start", connection, dataSet );

		// Patch to make it work with MS SQL Server
		DatabaseConfig config = connection.getConfig();
		boolean oldValue = config.getFeature( DatabaseConfig.FEATURE_BATCHED_STATEMENTS );
		try
		{
			config.setFeature( DatabaseConfig.FEATURE_BATCHED_STATEMENTS, false );
			this.execute2( connection, dataSet );
		}
		finally
		{
			config.setFeature( DatabaseConfig.FEATURE_BATCHED_STATEMENTS, oldValue );
		}
	}

	/**
	 * 
	 * @param connection
	 * @param dataSet
	 * @throws DatabaseUnitException
	 * @throws SQLException
	 */
	public void execute2( IDatabaseConnection connection, IDataSet dataSet ) throws DatabaseUnitException, SQLException
	{
		logger.debug( "execute(connection={}, dataSet={}) - start", connection, dataSet );

		IDataSet databaseDataSet = connection.createDataSet();

		DatabaseConfig databaseConfig = connection.getConfig();
		IStatementFactory statementFactory = ( IStatementFactory ) databaseConfig.getProperty( DatabaseConfig.PROPERTY_STATEMENT_FACTORY );
		IBatchStatement statement = statementFactory.createBatchStatement( connection );
		try
		{
			int count = 0;

			final Stack<String> tableNames = new Stack<>();
			final Set<String> tablesSeen = new HashSet<>();
			final ITableIterator iterator = dataSet.iterator();
			while ( iterator.next() )
			{
				String tableName = iterator.getTableMetaData().getTableName();
				if ( !tablesSeen.contains( tableName ) )
				{
					tableNames.push( tableName );
					tablesSeen.add( tableName );
				}
			}

			// delete tables once each in reverse order of seeing them.
			while ( !tableNames.isEmpty() )
			{
				String tableName = ( String ) tableNames.pop();

				// Use database table name. Required to support case sensitive database.
				ITableMetaData databaseMetaData = databaseDataSet.getTableMetaData( tableName );
				tableName = databaseMetaData.getTableName();

				StringBuffer sqlBuffer = new StringBuffer( 128 );
				sqlBuffer.append( getDeleteAllCommand() );
				sqlBuffer.append( getQualifiedName( connection.getSchema(), tableName, connection ) );
				sqlBuffer.append( " cascade" );
				String sql = sqlBuffer.toString();
				statement.addBatch( sql );

				if ( logger.isDebugEnabled() ) logger.debug( "Added SQL: {}", sql );

				count++;
			}

			if ( count > 0 )
			{
				statement.executeBatch();
				statement.clearBatch();
			}
		}
		finally
		{
			statement.close();
		}
	}
}
