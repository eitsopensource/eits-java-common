package br.com.eits.common.infrastructure.dbunit;

import java.util.HashMap;
import java.util.Map;

import org.dbunit.operation.CascadeTruncateTableOperation;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.operation.DatabaseOperationLookup;

/**
 * 
 * @author rodrigo@eits.com.br
 * @deprecated Please use the sprint test @SQL
 */
public class DBUnitOperationLookup implements DatabaseOperationLookup
{
	/**
	 * 
	 */
	private static final Map<DatabaseOperation, org.dbunit.operation.DatabaseOperation> OPERATION_LOOKUP = new HashMap<DatabaseOperation, org.dbunit.operation.DatabaseOperation>();
	
	/**
	 * 
	 */
	static
	{
		OPERATION_LOOKUP.put( DatabaseOperation.UPDATE, org.dbunit.operation.DatabaseOperation.UPDATE );
		OPERATION_LOOKUP.put( DatabaseOperation.INSERT, org.dbunit.operation.DatabaseOperation.INSERT );
		OPERATION_LOOKUP.put( DatabaseOperation.REFRESH, org.dbunit.operation.DatabaseOperation.REFRESH );
		OPERATION_LOOKUP.put( DatabaseOperation.DELETE, org.dbunit.operation.DatabaseOperation.DELETE );
		OPERATION_LOOKUP.put( DatabaseOperation.DELETE_ALL, org.dbunit.operation.DatabaseOperation.DELETE_ALL );
		OPERATION_LOOKUP.put( DatabaseOperation.CLEAN_INSERT, org.dbunit.operation.DatabaseOperation.CLEAN_INSERT );
		OPERATION_LOOKUP.put( DatabaseOperation.TRUNCATE_TABLE, new CascadeTruncateTableOperation() );
	}

	/**
	 */
	public org.dbunit.operation.DatabaseOperation get( DatabaseOperation operation )
	{
		return OPERATION_LOOKUP.get( operation );
	}

}
